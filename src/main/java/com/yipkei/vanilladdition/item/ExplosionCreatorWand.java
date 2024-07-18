package com.yipkei.vanilladdition.item;

import com.yipkei.vanilladdition.util.ModTags;
import net.fabricmc.fabric.api.biome.v1.BiomeModificationContext;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ExplosionCreatorWand extends AbstractFairyWand{
    public ExplosionCreatorWand(Settings settings)
    {
        super(settings, ModTags.Blocks.EXPLOSION_CREATOR_AFFECTABLE);
    }

    @Override protected void replaceOrDrop(World world, BlockPos blockPos, BlockState blockState, PlayerEntity player){
        if (blockState.isOf(Blocks.CREEPER_HEAD) || blockState.isOf(Blocks.CREEPER_WALL_HEAD)){
            int successChance = 20;
            if (world.isNight()) successChance = 50;
            else if (world.isRaining()) successChance = 80;
            else if (world.isThundering()) successChance = 100;
            if (world.random.nextBetween(0,99)< successChance) {
                LightningEntity lightningEntity = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
                lightningEntity.setPos(blockPos.getX(),blockPos.getY(),blockPos.getZ());
                world.spawnEntity(lightningEntity);
            } else if (!world.isRaining() && world.random.nextBetween(0, 1) < 1) {
                createExplosionBySkull(world, blockPos);
            }

        }
    }
}
