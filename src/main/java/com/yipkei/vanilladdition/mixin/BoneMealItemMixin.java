package com.yipkei.vanilladdition.mixin;

import com.yipkei.vanilladdition.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BoneMealItem;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static com.yipkei.vanilladdition.settings.VanillaAdditionSettings.extraTallPlantFertilizable;

@Mixin(BoneMealItem.class)
public abstract class BoneMealItemMixin {

    @Inject(method = "useOnFertilizable", at = @At("HEAD"), cancellable = true)
    private static void moreUsableBlock(ItemStack stack, World world, BlockPos pos, CallbackInfoReturnable<Boolean> cir){
        BlockState blockState = world.getBlockState(pos);
        Block block = blockState.getBlock();
        if (extraTallPlantFertilizable && blockState.isIn(ModTags.Blocks.TALL_PLANT_FERTILIZABLE)){
            if (world instanceof ServerWorld){
                Block.dropStack(world, pos, new ItemStack(block));
            }
            cir.setReturnValue(true);
        }
    }
}
