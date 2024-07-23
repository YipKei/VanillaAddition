package com.yipkei.vanilladdition.mixin;

import com.yipkei.vanilladdition.block.IceSlab;
import com.yipkei.vanilladdition.block.IceStairs;
import com.yipkei.vanilladdition.block.TranslucentIce;
import net.minecraft.block.BlockState;
import net.minecraft.block.IceBlock;
import net.minecraft.block.TranslucentBlock;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.Mixin;

import static com.yipkei.vanilladdition.helper.BlockStateHelper.*;

@Mixin(IceBlock.class)
public class IceBlockMixin extends TranslucentBlock implements TranslucentIce {
    public IceBlockMixin(Settings settings) {
        super(settings);
    }

    @Override
    protected boolean isSideInvisible(BlockState state, BlockState stateFrom, Direction direction){
        if (!(stateFrom.getBlock() instanceof TranslucentIce)) {
            return super.isSideInvisible(state, stateFrom, direction);
        }

        if (stateFrom.getBlock() instanceof IceSlab){
            if (hasCompleteSlabSurface(stateFrom, direction.getOpposite())) return true;
        }

        if (stateFrom.getBlock() instanceof IceStairs){
            if (hasCompleteStairSurface(stateFrom, direction.getOpposite())) return true;
        }

        return super.isSideInvisible(state, stateFrom, direction);
    }
}
