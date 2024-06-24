package com.yipkei.vanilladdition.item;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ExplosionCreatorWand extends AbstractFairyWand{
    public ExplosionCreatorWand(Settings settings) {
        super(settings);
    }

    @Override protected void replaceOrDrop(World world, BlockPos blockPos, BlockState blockState, PlayerEntity player){
        if (blockState.isOf(Blocks.CREEPER_HEAD) || blockState.isOf(Blocks.CREEPER_WALL_HEAD)){
            LightningEntity lightningEntity = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
            lightningEntity.setPos(blockPos.getX(),blockPos.getY(),blockPos.getZ());
            world.spawnEntity(lightningEntity);
        }
    }
}
