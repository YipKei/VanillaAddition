package com.yipkei.vanilladdition.block;

import net.minecraft.block.*;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.Direction;

import static com.yipkei.vanilladdition.helper.BlockStateHelper.*;

public class TranslucentStairs extends StairsBlock implements AbstractTranslucentBlock {
    public TranslucentStairs(BlockState baseBlockState, Settings settings) {
        super(baseBlockState, settings);
    }

    private Block blockSeries;

    public Block setBlockSeriesAtSetting(Block block){
        this.setBlockSeries(block);
        return this;
    }

    public void setBlockSeries(Block block){
        this.blockSeries = block;
    }

    public Block getBlockSeries(){
        return blockSeries;
    }

    @Override
    protected boolean isSideInvisible(BlockState state, BlockState stateFrom, Direction direction) {

        if (!(stateFrom.getBlock() instanceof AbstractTranslucentBlock))
            return super.isSideInvisible(state, stateFrom, direction);

        if (stateFrom.getBlock() instanceof TranslucentBlock) {
            return (this.getBlockSeries() == stateFrom.getBlock()) || super.isSideInvisible(state, stateFrom, direction);
        }

        if (this.getBlockSeries() == stateFrom.getBlock()) return true;

        if (stateFrom.getBlock() instanceof TranslucentStairs) {
            if (this.getBlockSeries() != ((TranslucentStairs)(stateFrom.getBlock())).getBlockSeries())
                return super.isSideInvisible(state, stateFrom, direction);
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

        if (stateFrom.getBlock() instanceof TranslucentSlab && this.getBlockSeries() == ((TranslucentSlab)(stateFrom.getBlock())).getBlockSeries() && hasCompleteSlabSurface(stateFrom, direction.getOpposite()))
            return true;
        return super.isSideInvisible(state, stateFrom, direction);
    }
}

