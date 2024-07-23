package com.yipkei.vanilladdition.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.IceBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.Direction;

import static com.yipkei.vanilladdition.helper.BlockStateHelper.*;

public class IceStairs extends StairsBlock implements TranslucentIce {
    public IceStairs(BlockState baseBlockState, Settings settings) {
        super(baseBlockState, settings);
    }

    @Override
    protected boolean isSideInvisible(BlockState state, BlockState stateFrom, Direction direction) {

        if (!(stateFrom.getBlock() instanceof TranslucentIce))
            return super.isSideInvisible(state, stateFrom, direction);

        if (stateFrom.getBlock() instanceof IceBlock) return true;

        if (stateFrom.getBlock() instanceof IceStairs) {
            if (hasCompleteStairSurface(stateFrom, direction.getOpposite())) return true;
            Direction facing = state.get(Properties.HORIZONTAL_FACING);
            if (state.get(Properties.BLOCK_HALF) == stateFrom.get(Properties.BLOCK_HALF)) {
                if (direction.getAxis() == facing.getAxis()) {
                    if (facing == stateFrom.get(Properties.HORIZONTAL_FACING))
                        return super.isSideInvisible(state, stateFrom, direction);
                    return true;
                }
                if (direction.getAxis() == Direction.Axis.Y){
                    return super.isSideInvisible(state, stateFrom, direction);
                }
                return true;
            }

        }

        if (stateFrom.getBlock() instanceof IceSlab && hasCompleteSlabSurface(stateFrom, direction.getOpposite()))
            return true;
        return super.isSideInvisible(state, stateFrom, direction);
    }
}

