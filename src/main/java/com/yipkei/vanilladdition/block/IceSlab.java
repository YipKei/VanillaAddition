package com.yipkei.vanilladdition.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.IceBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.block.enums.SlabType;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.Direction;

import static com.yipkei.vanilladdition.helper.BlockStateHelper.*;

public class IceSlab extends SlabBlock implements TranslucentIce {
    public IceSlab(Settings settings) {
        super(settings);
    }

    @Override
    protected boolean isSideInvisible(BlockState state, BlockState stateFrom, Direction direction) {
        if (!(stateFrom.getBlock() instanceof TranslucentIce)) {
            return super.isSideInvisible(state, stateFrom, direction);
        }

        if (stateFrom.getBlock() instanceof IceBlock){
            switch (state.get(Properties.SLAB_TYPE)){
                case DOUBLE -> {
                    return true;
                }
                case TOP -> {
                    if (direction != Direction.DOWN) return true;
                    return super.isSideInvisible(state, stateFrom, direction);
                }
                case BOTTOM -> {
                    if (direction != Direction.UP) return true;
                    return super.isSideInvisible(state, stateFrom, direction);
                }
            }
        }

        if (stateFrom.getBlock() instanceof IceSlab) {
            switch (state.get(Properties.SLAB_TYPE)){
                case DOUBLE -> {
                    if (hasCompleteSlabSurface(stateFrom,direction.getOpposite())) return true;
                }
                case TOP -> {
                    if ((direction == Direction.UP && stateFrom.get(Properties.SLAB_TYPE) != SlabType.TOP) || ((direction.getAxis() != Direction.Axis.Y) && stateFrom.get(Properties.SLAB_TYPE) != SlabType.BOTTOM)) return true;
                }
                case BOTTOM -> {
                    if ((direction == Direction.DOWN && stateFrom.get(Properties.SLAB_TYPE) != SlabType.BOTTOM)||((direction.getAxis() != Direction.Axis.Y) && stateFrom.get(Properties.SLAB_TYPE) != SlabType.TOP)) return true;
                }
            }
            return super.isSideInvisible(state, stateFrom, direction);
        }

        if (stateFrom.getBlock() instanceof IceStairs){
            switch (state.get(Properties.SLAB_TYPE)){
                case DOUBLE -> {
                    if (hasCompleteStairSurface(stateFrom,direction.getOpposite())) return true;
                }
                case TOP -> {
                    if ((direction == Direction.UP && stateFrom.get(Properties.BLOCK_HALF) == BlockHalf.BOTTOM) || ((direction.getAxis() != Direction.Axis.Y) && stateFrom.get(Properties.BLOCK_HALF) == BlockHalf.TOP)) return true;
                }
                case BOTTOM -> {
                    if ((direction == Direction.DOWN && stateFrom.get(Properties.BLOCK_HALF) == BlockHalf.TOP) || ((direction.getAxis() != Direction.Axis.Y) && stateFrom.get(Properties.BLOCK_HALF) == BlockHalf.BOTTOM)) return true;
                }

            }
        }


        return super.isSideInvisible(state, stateFrom, direction);
    }
}
