package com.yipkei.vanilladdition.block;

import net.minecraft.block.*;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.block.enums.SlabType;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.Direction;

import static com.yipkei.vanilladdition.helper.BlockStateHelper.hasCompleteSlabSurface;
import static com.yipkei.vanilladdition.helper.BlockStateHelper.hasCompleteStairSurface;

public class TranslucentSlab extends SlabBlock implements AbstractTranslucentBlock{
    public TranslucentSlab(AbstractBlock.Settings settings) {
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
        if (!(stateFrom.getBlock() instanceof AbstractTranslucentBlock)) {
            return super.isSideInvisible(state, stateFrom, direction);
        }

        if (stateFrom.getBlock() instanceof TranslucentBlock) {
            if (this.getBlockSeries() != stateFrom.getBlock()){
                return super.isSideInvisible(state, stateFrom, direction);
            }
            return switch (state.get(Properties.SLAB_TYPE)) {
                case DOUBLE -> true;
                case TOP -> direction != Direction.DOWN || super.isSideInvisible(state, stateFrom, direction);
                case BOTTOM -> direction != Direction.UP || super.isSideInvisible(state, stateFrom, direction);
            };
        }

        if (stateFrom.getBlock() instanceof TranslucentSlab) {
            if (this.getBlockSeries() != ((TranslucentSlab)(stateFrom.getBlock())).getBlockSeries())
                return super.isSideInvisible(state, stateFrom, direction);
            return switch (state.get(Properties.SLAB_TYPE)){
                case DOUBLE -> (hasCompleteSlabSurface(stateFrom,direction.getOpposite())) || super.isSideInvisible(state, stateFrom, direction);
                case TOP -> ((direction == Direction.UP && stateFrom.get(Properties.SLAB_TYPE) != SlabType.TOP) || ((direction.getAxis() != Direction.Axis.Y) && stateFrom.get(Properties.SLAB_TYPE) != SlabType.BOTTOM)) || super.isSideInvisible(state, stateFrom, direction);
                case BOTTOM -> ((direction == Direction.DOWN && stateFrom.get(Properties.SLAB_TYPE) != SlabType.BOTTOM)||((direction.getAxis() != Direction.Axis.Y) && stateFrom.get(Properties.SLAB_TYPE) != SlabType.TOP)) || super.isSideInvisible(state, stateFrom, direction);
            };
        }

        if (stateFrom.getBlock() instanceof TranslucentStairs){
            if (this.getBlockSeries() != ((TranslucentStairs)(stateFrom.getBlock())).getBlockSeries())
                return super.isSideInvisible(state, stateFrom, direction);
            return switch (state.get(Properties.SLAB_TYPE)){
                case DOUBLE -> (hasCompleteStairSurface(stateFrom,direction.getOpposite())) || super.isSideInvisible(state, stateFrom, direction);
                case TOP -> ((direction == Direction.UP && stateFrom.get(Properties.BLOCK_HALF) == BlockHalf.BOTTOM) || ((direction.getAxis() != Direction.Axis.Y) && stateFrom.get(Properties.BLOCK_HALF) == BlockHalf.TOP)) || super.isSideInvisible(state, stateFrom, direction);
                case BOTTOM -> ((direction == Direction.DOWN && stateFrom.get(Properties.BLOCK_HALF) == BlockHalf.TOP) || ((direction.getAxis() != Direction.Axis.Y) && stateFrom.get(Properties.BLOCK_HALF) == BlockHalf.BOTTOM)) || super.isSideInvisible(state, stateFrom, direction);
            };
        }

        return super.isSideInvisible(state, stateFrom, direction);
    }
}
