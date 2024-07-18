package com.yipkei.vanilladdition.item;

import com.yipkei.vanilladdition.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DeepDarkFantasyWand extends AbstractFairyWand{
    public DeepDarkFantasyWand(Settings settings)
    {
        super(settings,ModTags.Blocks.DEEP_DARK_FANTASY_AFFECTABLE);
    }

    @Override
    protected void replaceOrDrop(World world, BlockPos blockPos, BlockState blockState, PlayerEntity player){
        if (blockState.isOf(Blocks.WITHER_SKELETON_SKULL)){
            int yLevel = player.getBlockY()+64;
            if (player.hasStatusEffect(StatusEffects.WITHER)) yLevel /= 2;
            int chance = world.random.nextBetween(0,yLevel);
            if (chance==0) {
                BlockState dragonHead = Blocks.DRAGON_HEAD.getDefaultState().with(Properties.ROTATION, blockState.get(Properties.ROTATION));
                world.playSound(null, blockPos, SoundEvents.ENTITY_DRAGON_FIREBALL_EXPLODE, SoundCategory.BLOCKS, 1.0f, 1.0f);
                world.setBlockState(blockPos, dragonHead, Block.NOTIFY_ALL_AND_REDRAW);
            }else {
                createExplosionBySkull(world, blockPos);
            }
        }
        if (blockState.isOf(Blocks.WITHER_SKELETON_WALL_SKULL)){
            int yLevel = player.getBlockY()+64;
            if (player.hasStatusEffect(StatusEffects.WITHER)) yLevel /= 2;
            int chance = world.random.nextBetween(0,yLevel);
            if (chance==0) {
                BlockState dragonHead = Blocks.DRAGON_WALL_HEAD.getDefaultState().with(Properties.FACING, blockState.get(Properties.FACING));
                world.playSound(null, blockPos, SoundEvents.ENTITY_DRAGON_FIREBALL_EXPLODE, SoundCategory.BLOCKS, 1.0f, 1.0f);
                world.setBlockState(blockPos, dragonHead, Block.NOTIFY_ALL_AND_REDRAW);
            }else {
                createExplosionBySkull(world, blockPos);
            }
        }
        if (blockState.isOf(Blocks.TURTLE_EGG)){
            if (world.random.nextBetween(0,99)<20*checkManhattanDistance(world, blockPos, Blocks.WITHER_ROSE, 5)){
                world.playSound(null,blockPos,SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.BLOCKS,1.0f,1.0f);
                world.setBlockState(blockPos, Blocks.DRAGON_EGG.getDefaultState(), Block.NOTIFY_ALL_AND_REDRAW);
            }
        }
    }


}
