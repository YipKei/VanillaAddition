package com.yipkei.vanilladdition.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DeepDarkFantasyWand extends AbstractFairyWand{
    public DeepDarkFantasyWand(Settings settings) {
        super(settings);
    }

    @Override protected void replaceOrDrop(World world, BlockPos blockPos, BlockState blockState, PlayerEntity player){
        if (blockState.isOf(Blocks.WITHER_SKELETON_SKULL)){
            BlockState dragonHead = Blocks.DRAGON_HEAD.getDefaultState().with(Properties.ROTATION, blockState.get(Properties.ROTATION));
            world.playSound(null, blockPos, SoundEvents.ENTITY_DRAGON_FIREBALL_EXPLODE, SoundCategory.BLOCKS, 1.0f, 1.0f);
            world.setBlockState(blockPos, dragonHead, Block.NOTIFY_ALL_AND_REDRAW);
        }
        if (blockState.isOf(Blocks.WITHER_SKELETON_WALL_SKULL)){
            BlockState dragonHead = Blocks.DRAGON_WALL_HEAD.getDefaultState().with(Properties.FACING, blockState.get(Properties.FACING));
            world.playSound(null, blockPos, SoundEvents.ENTITY_DRAGON_FIREBALL_EXPLODE, SoundCategory.BLOCKS, 1.0f, 1.0f);
            world.setBlockState(blockPos, Blocks.DRAGON_WALL_HEAD.getDefaultState(), Block.NOTIFY_ALL_AND_REDRAW);
        }
    }
}
