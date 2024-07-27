package com.yipkei.vanilladdition.block;

import net.minecraft.block.*;
import net.minecraft.util.math.Direction;

import static com.yipkei.vanilladdition.helper.BlockStateHelper.*;

public class TranslucentWall extends WallBlock implements AbstractTranslucentBlock {
    public TranslucentWall(Settings settings) {
        super(settings);
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
        if (!(stateFrom.getBlock() instanceof AbstractTranslucentBlock)){
            return super.isSideInvisible(state, stateFrom, direction);
        }

        if (stateFrom.getBlock() instanceof TranslucentBlock || stateFrom.getBlock() instanceof TranslucentWall) {
            return (this.getBlockSeries() == stateFrom.getBlock()) || super.isSideInvisible(state, stateFrom, direction);
        }

        if (stateFrom.getBlock() instanceof TranslucentStairs) {
            return (this.getBlockSeries() == ((TranslucentStairs)(stateFrom.getBlock())).getBlockSeries() && hasCompleteStairSurface(stateFrom,direction.getOpposite())) || super.isSideInvisible(state, stateFrom, direction);
        }

        if (stateFrom.getBlock() instanceof TranslucentSlab){
            return (this.getBlockSeries() == ((TranslucentSlab)(stateFrom.getBlock())).getBlockSeries() && hasCompleteSlabSurface(stateFrom,direction.getOpposite())) || super.isSideInvisible(state, stateFrom, direction);
        }
        return super.isSideInvisible(state, stateFrom, direction);
    }

}
