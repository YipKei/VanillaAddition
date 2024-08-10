package com.yipkei.vanilladdition.mixin;

import com.yipkei.vanilladdition.util.ModTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.entity.mob.WitherSkeletonEntity;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

import java.util.ArrayList;

@Mixin(WitherSkeletonEntity.class)
public abstract class WitherSkeletonEntityMixin extends AbstractSkeletonEntity {

    protected WitherSkeletonEntityMixin(EntityType<? extends AbstractSkeletonEntity> entityType, World world) {
        super((EntityType<? extends AbstractSkeletonEntity>)entityType, world);
        this.setPathfindingPenalty(PathNodeType.LAVA, 8.0f);
    }

    @Override
    public void onDeath(DamageSource damageSource) {
        boolean hasWitherHead = this.getEquippedStack(EquipmentSlot.HEAD).isOf(Items.WITHER_SKELETON_SKULL);
        super.onDeath(damageSource);
        World world = this.getWorld();
        if (world.isClient || !hasWitherHead) return;
        BlockPos pos = this.getBlockPos();
        if (world.getBlockState(pos).isOf(Blocks.SOUL_SAND)) pos = pos.up();
        ArrayList<BlockPos> availablePos = new ArrayList<>();
        if (world.getBlockState(pos).isOf(Blocks.WITHER_ROSE)){
            if (canWitherRoseStayOn(world,pos.east())) availablePos.add(pos.east());
            if (canWitherRoseStayOn(world,pos.south())) availablePos.add(pos.south());
            if (canWitherRoseStayOn(world,pos.west())) availablePos.add(pos.west());
            if (canWitherRoseStayOn(world,pos.north())) availablePos.add(pos.north());
        }
        if (!availablePos.isEmpty()) {
            BlockPos selectPos = availablePos.get(world.random.nextBetween(0, availablePos.size()-1));
            world.setBlockState(selectPos, Blocks.WITHER_ROSE.getDefaultState(),11);
        }
    }

    @Unique
    private static boolean canWitherRoseStayOn(World world, BlockPos pos){
        BlockState floor = world.getBlockState(pos.down());
        return world.getBlockState(pos).isOf(Blocks.AIR) && (floor.isIn(ModTags.Blocks.WITHER_ROSE_CAN_KEEP_ON) || floor.isIn(BlockTags.DIRT) || floor.isOf(Blocks.SOUL_SAND) || floor.isOf(Blocks.SOUL_SOIL) || floor.isOf(Blocks.NETHERRACK) || floor.isOf(Blocks.FARMLAND));
    }

    @Override
    protected void drop(ServerWorld world, DamageSource damageSource){
        if (world.getBlockState(this.getBlockPos()).isOf(Blocks.WITHER_ROSE)) return;
        super.drop(world,damageSource);
    }

//    @Inject(method = "dropEquipment", at = @At(value = "HEAD"), cancellable = true)
//    private void disableDrop(ServerWorld world, DamageSource source, boolean causedByPlayer, CallbackInfo ci){
//        if (world.getBlockState(this.getBlockPos()).isOf(Blocks.WITHER_ROSE)){
//            ci.cancel();
//        }
//    }
}
