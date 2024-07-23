package com.yipkei.vanilladdition.helper;

import net.minecraft.block.BlockState;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.block.enums.SlabType;
import net.minecraft.block.enums.StairShape;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.Direction;

public class BlockStateHelper {
    public static boolean hasCompleteStairSurface(BlockState blockState, Direction direction) {
        return switch (direction) {
            case UP -> blockState.get(Properties.BLOCK_HALF) == BlockHalf.TOP;
            case DOWN -> blockState.get(Properties.BLOCK_HALF) == BlockHalf.BOTTOM;
            case NORTH ->
                    (blockState.get(Properties.HORIZONTAL_FACING) == Direction.NORTH && (blockState.get(Properties.STAIR_SHAPE) == StairShape.STRAIGHT));
            case SOUTH ->
                    (blockState.get(Properties.HORIZONTAL_FACING) == Direction.SOUTH && (blockState.get(Properties.STAIR_SHAPE) == StairShape.STRAIGHT));
            case WEST ->
                    (blockState.get(Properties.HORIZONTAL_FACING) == Direction.WEST && (blockState.get(Properties.STAIR_SHAPE) == StairShape.STRAIGHT));
            case EAST ->
                    (blockState.get(Properties.HORIZONTAL_FACING) == Direction.EAST && (blockState.get(Properties.STAIR_SHAPE) == StairShape.STRAIGHT));
        };
    }

    public static boolean hasCompleteSlabSurface(BlockState blockState, Direction direction){
        return switch (direction){
            case UP -> blockState.get(Properties.SLAB_TYPE) != SlabType.BOTTOM;
            case DOWN -> blockState.get(Properties.SLAB_TYPE) != SlabType.TOP;
            case EAST, NORTH, WEST, SOUTH -> blockState.get(Properties.SLAB_TYPE) == SlabType.DOUBLE;
        };
    }

}
