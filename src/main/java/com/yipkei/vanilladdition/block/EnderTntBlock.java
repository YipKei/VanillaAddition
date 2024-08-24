package com.yipkei.vanilladdition.block;

import com.mojang.serialization.MapCodec;
import com.yipkei.vanilladdition.entity.EnderTntEntity;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.explosion.Explosion;
import org.jetbrains.annotations.Nullable;

public class EnderTntBlock extends FacingBlock {
    public static final MapCodec<EnderTntBlock> CODEC = EnderTntBlock.createCodec(EnderTntBlock::new);
    public static final BooleanProperty UNSTABLE = Properties.UNSTABLE;

    @Override
    protected MapCodec<EnderTntBlock> getCodec() { return CODEC; }

    public EnderTntBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.SOUTH).with(UNSTABLE,false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder){
        builder.add(FACING, UNSTABLE);
    }

    @Override
    protected BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    protected BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerLookDirection().getOpposite().getOpposite());
    }

    @Override
    protected void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if (oldState.isOf(state.getBlock())) {
            return;
        }
        if (world.isReceivingRedstonePower(pos)) {
            primeEnderTNT(world, pos, state.get(FACING));
            world.removeBlock(pos, false);
        }
    }


    @Override
    protected void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify){
        if (world.isReceivingRedstonePower(pos)) {
            primeEnderTNT(world, pos, state.get(FACING));
            world.removeBlock(pos, false);
        }
    }

    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!world.isClient() && !player.isCreative() && state.get(UNSTABLE)) {
            primeEnderTNT(world, pos, state.get(FACING));
        }
        return super.onBreak(world, pos, state, player);
    }

    public static void primeEnderTNT(World world, BlockPos pos, Direction facing){
        primeEnderTNT(world, pos, facing, null);
    }

    private static void primeEnderTNT(World world, BlockPos pos, Direction facing, @Nullable LivingEntity igniter){
        if (world.isClient) {
            return;
        }
        EnderTntEntity enderTntEntity = new EnderTntEntity(world, pos.getX()+0.5, pos.getY(), pos.getZ()+0.5, igniter, facing);
        world.spawnEntity(enderTntEntity);
        world.playSound(null, enderTntEntity.getX(), enderTntEntity.getY(), enderTntEntity.getZ(), SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0f, 1.0f);
        world.emitGameEvent(igniter, GameEvent.PRIME_FUSE, pos);
    }

    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit){
        if (!stack.isIn(ItemTags.CREEPER_IGNITERS)){
            return super.onUseWithItem(stack, state, world, pos, player, hand, hit);
        }
        primeEnderTNT(world, pos, state.get(FACING), player);
        world.setBlockState(pos, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL_AND_REDRAW);
        Item item = stack.getItem();
        if (stack.isIn(ItemTags.CREEPER_IGNITERS) && !stack.isOf(Items.FIRE_CHARGE)){
            stack.damage(1, player, LivingEntity.getSlotForHand(hand));
        }else {
            stack.decrementUnlessCreative(1, player);
        }
        player.incrementStat(Stats.USED.getOrCreateStat(item));
        return ItemActionResult.success(world.isClient);
    }

    @Override
    protected void onProjectileHit(World world, BlockState state, BlockHitResult hit, ProjectileEntity projectile){
        if (!world.isClient) {
            BlockPos blockPos = hit.getBlockPos();
            Entity entity = projectile.getOwner();
            if (projectile.isOnFire() && projectile.canModifyAt(world, blockPos)) {
                primeEnderTNT(world, blockPos, state.get(FACING), entity instanceof LivingEntity ? (LivingEntity)entity : null);
                world.removeBlock(blockPos, false);
            }
        }
    }

    @Override
    public boolean shouldDropItemsOnExplosion(Explosion explosion) {
        return false;
    }

}
