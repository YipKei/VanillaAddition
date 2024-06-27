package com.yipkei.vanilladdition.mixin;

import com.yipkei.vanilladdition.util.ModTags;
import net.minecraft.block.*;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PumpkinBlock.class)
public abstract class PumpkinBlockMixin extends Block {
    public PumpkinBlockMixin(Settings settings) {
        super(settings);
    }

    @Inject(method = "onUseWithItem",at = @At("HEAD"), cancellable = true)
    private void checkSteelShears(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit, CallbackInfoReturnable<ItemActionResult> ci){
        if (stack.isIn(ModTags.Items.SHEARS)){
            if (world.isClient){
                ci.setReturnValue(ItemActionResult.success(world.isClient));
            }
            Direction direction = hit.getSide();
            Direction direction2 = direction.getAxis() == Direction.Axis.Y ? player.getHorizontalFacing().getOpposite() : direction;
            world.playSound(null, pos, SoundEvents.BLOCK_PUMPKIN_CARVE, SoundCategory.BLOCKS, 1.0f, 1.0f);
            world.setBlockState(pos, Blocks.CARVED_PUMPKIN.getDefaultState().with(CarvedPumpkinBlock.FACING, direction2), Block.NOTIFY_ALL_AND_REDRAW);
            ItemEntity itemEntity = new ItemEntity(world, (double)pos.getX() + 0.5 + (double)direction2.getOffsetX() * 0.65, (double)pos.getY() + 0.1, (double)pos.getZ() + 0.5 + (double)direction2.getOffsetZ() * 0.65, new ItemStack(Items.PUMPKIN_SEEDS, 4));
            itemEntity.setVelocity(0.05 * (double)direction2.getOffsetX() + world.random.nextDouble() * 0.02, 0.05, 0.05 * (double)direction2.getOffsetZ() + world.random.nextDouble() * 0.02);
            world.spawnEntity(itemEntity);
            stack.damage(1, player, LivingEntity.getSlotForHand(hand));
            world.emitGameEvent(player, GameEvent.SHEAR, pos);
            player.incrementStat(Stats.USED.getOrCreateStat(Items.SHEARS));
            ci.setReturnValue(ItemActionResult.success(world.isClient));
        }
    }

//    /**
//     * @author YipKei
//     * @reason The original method cannot accept custom Shears.
//     */
//    @Overwrite
//    public ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
//        if (!stack.isIn(ModTags.Items.SHEARS)) {
//            return super.onUseWithItem(stack, state, world, pos, player, hand, hit);
//        }
//        if (world.isClient) {
//            return ItemActionResult.success(world.isClient);
//        }
//        Direction direction = hit.getSide();
//        Direction direction2 = direction.getAxis() == Direction.Axis.Y ? player.getHorizontalFacing().getOpposite() : direction;
//        world.playSound(null, pos, SoundEvents.BLOCK_PUMPKIN_CARVE, SoundCategory.BLOCKS, 1.0f, 1.0f);
//        world.setBlockState(pos, Blocks.CARVED_PUMPKIN.getDefaultState().with(CarvedPumpkinBlock.FACING, direction2), Block.NOTIFY_ALL_AND_REDRAW);
//        ItemEntity itemEntity = new ItemEntity(world, (double)pos.getX() + 0.5 + (double)direction2.getOffsetX() * 0.65, (double)pos.getY() + 0.1, (double)pos.getZ() + 0.5 + (double)direction2.getOffsetZ() * 0.65, new ItemStack(Items.PUMPKIN_SEEDS, 4));
//        itemEntity.setVelocity(0.05 * (double)direction2.getOffsetX() + world.random.nextDouble() * 0.02, 0.05, 0.05 * (double)direction2.getOffsetZ() + world.random.nextDouble() * 0.02);
//        world.spawnEntity(itemEntity);
//        stack.damage(1, player, LivingEntity.getSlotForHand(hand));
//        world.emitGameEvent(player, GameEvent.SHEAR, pos);
//        player.incrementStat(Stats.USED.getOrCreateStat(Items.SHEARS));
//        return ItemActionResult.success(world.isClient);
//    }
}
