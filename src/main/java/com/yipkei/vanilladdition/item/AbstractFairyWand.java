package com.yipkei.vanilladdition.item;

import com.yipkei.vanilladdition.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AbstractFairyWand extends Item {
    public AbstractFairyWand(Settings settings) {
        super(settings);
    }

    public ActionResult useOnBlock(ItemUsageContext context){
        World world = context.getWorld();
        if (world.isClient){
            return ActionResult.SUCCESS;
        }
        BlockPos blockPos = context.getBlockPos();
        PlayerEntity playerEntity = context.getPlayer();
        BlockState blockState = context.getWorld().getBlockState(blockPos.down());
        if (blockState.isIn(ModTags.Blocks.FAIRY_WAND_REPLACEABEL)){
            replaceOrDropHead(world, blockPos, blockState);
            context.getStack().damage(1, context.getPlayer(), EquipmentSlot.MAINHAND);
        }
        return ActionResult.SUCCESS;
    }

    protected void replaceOrDropHead(World world, BlockPos blockPos, BlockState blockState){
        if (blockState.isOf(Blocks.WITHER_SKELETON_SKULL) || blockState.isOf(Blocks.WITHER_SKELETON_WALL_SKULL)){
            world.playSound(null, blockPos, SoundEvents.ENTITY_DRAGON_FIREBALL_EXPLODE, SoundCategory.BLOCKS, 1.0f, 1.0f);
            world.setBlockState(blockPos, Blocks.DRAGON_HEAD.getDefaultState(), Block.NOTIFY_ALL_AND_REDRAW);
        }
        if (blockState.isOf(Blocks.ZOMBIE_HEAD) || blockState.isOf(Blocks.ZOMBIE_WALL_HEAD)){
            world.playSound(null, blockPos, SoundEvents.ENTITY_ZOMBIE_AMBIENT, SoundCategory.BLOCKS, 1.0f, 1.0f);
            world.setBlockState(blockPos, Blocks.PLAYER_HEAD.getDefaultState(), Block.NOTIFY_ALL_AND_REDRAW);
        }
    }
}
