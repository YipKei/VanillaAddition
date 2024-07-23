package com.yipkei.vanilladdition.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.IceBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.util.math.Direction;

import static com.yipkei.vanilladdition.helper.BlockStateHelper.*;

public class IceWall extends WallBlock implements TranslucentIce {
    public IceWall(Settings settings) {
        super(settings);
    }

    @Override
    protected boolean isSideInvisible(BlockState state, BlockState stateFrom, Direction direction) {
        if (!(stateFrom.getBlock() instanceof TranslucentIce)){
            return super.isSideInvisible(state, stateFrom, direction);
        }

        if (stateFrom.getBlock() instanceof IceWall){
            return true;
        }

        if (direction != Direction.UP){
            if (stateFrom.getBlock() instanceof IceBlock) return true;
            if (stateFrom.getBlock() instanceof IceStairs) {
                if (hasCompleteStairSurface(stateFrom,direction.getOpposite())) return true;
                return super.isSideInvisible(state, stateFrom, direction);
            }
            if (stateFrom.getBlock() instanceof IceSlab){
                if (hasCompleteSlabSurface(stateFrom,direction.getOpposite())) return true;
                return super.isSideInvisible(state, stateFrom, direction);
            }
        }

        return super.isSideInvisible(state, stateFrom, direction);
    }
}
