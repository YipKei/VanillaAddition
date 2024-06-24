package com.yipkei.vanilladdition.custom;

import com.yipkei.vanilladdition.init.ModItems;
import net.minecraft.block.*;
import net.minecraft.block.dispenser.FallibleItemDispenserBehavior;
import net.minecraft.block.dispenser.ItemDispenserBehavior;
import net.minecraft.block.dispenser.ShearsDispenserBehavior;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.event.GameEvent;

public class ModDispenserBehavior {
    private static final ItemDispenserBehavior defaultBehavior = new ItemDispenserBehavior();

    public static void register(){
        DispenserBlock.registerBehavior(ModItems.STEEL_SHEARS, new ShearsDispenserBehavior());
        DispenserBlock.registerBehavior(ModItems.DIAMOND_FLINT, new FallibleItemDispenserBehavior(){

            @Override
            protected ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {
                ServerWorld serverWorld = pointer.world();
                this.setSuccess(true);
                Direction direction = pointer.state().get(DispenserBlock.FACING);
                BlockPos blockPos = pointer.pos().offset(direction);
                BlockState blockState = serverWorld.getBlockState(blockPos);
                if (AbstractFireBlock.canPlaceAt(serverWorld, blockPos, direction)) {
                    serverWorld.setBlockState(blockPos, AbstractFireBlock.getState(serverWorld, blockPos));
                    serverWorld.emitGameEvent(null, GameEvent.BLOCK_PLACE, blockPos);
                } else if (CampfireBlock.canBeLit(blockState) || CandleBlock.canBeLit(blockState) || CandleCakeBlock.canBeLit(blockState)) {
                    serverWorld.setBlockState(blockPos, blockState.with(Properties.LIT, true));
                    serverWorld.emitGameEvent(null, GameEvent.BLOCK_CHANGE, blockPos);
                } else if (blockState.getBlock() instanceof TntBlock) {
                    TntBlock.primeTnt(serverWorld, blockPos);
                    serverWorld.removeBlock(blockPos, false);
                } else {
                    this.setSuccess(false);
                }
                if (this.isSuccess()) {
                    stack.damage(1, serverWorld, null, item -> {});
                }
                return stack;
            }
        });
    }
}
