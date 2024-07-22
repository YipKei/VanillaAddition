package com.yipkei.vanilladdition.item;

import net.minecraft.block.BlockState;
import net.minecraft.block.JukeboxBlock;
import net.minecraft.block.entity.JukeboxBlockEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static com.yipkei.vanilladdition.helper.PathChangeHelper.pathChange;
import static net.minecraft.block.JukeboxBlock.HAS_RECORD;

public class SheetMusic extends Item {
    public SheetMusic(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context){
        BlockPos blockPos = context.getBlockPos();
        World world = context.getWorld();
        BlockState blockState = world.getBlockState(blockPos);
        if (blockState.getBlock() instanceof JukeboxBlock){
            if (blockState.get(HAS_RECORD)){
                JukeboxBlockEntity jukebox = (JukeboxBlockEntity) context.getWorld().getBlockEntity(blockPos);
                Item disc = jukebox.getStack().getItem();
                ItemStack discSheet = new ItemStack(pathChange(disc,"_sheet_music"));
                context.getStack().decrement(1);
                ItemEntity discSheetEntity = new ItemEntity(world, blockPos.getX(), blockPos.getY()+1d, blockPos.getZ(), discSheet,0,0.1,0);
                world.spawnEntity(discSheetEntity);
                return ActionResult.SUCCESS;
            }

        }
        return ActionResult.PASS;
    }
}
