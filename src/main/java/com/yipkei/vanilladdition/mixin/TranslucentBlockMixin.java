package com.yipkei.vanilladdition.mixin;

import com.yipkei.vanilladdition.block.AbstractTranslucentBlock;
import com.yipkei.vanilladdition.block.TranslucentSlab;
import com.yipkei.vanilladdition.block.TranslucentStairs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.TranslucentBlock;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static com.yipkei.vanilladdition.helper.BlockStateHelper.hasCompleteSlabSurface;
import static com.yipkei.vanilladdition.helper.BlockStateHelper.hasCompleteStairSurface;

@Mixin(TranslucentBlock.class)
public class TranslucentBlockMixin extends Block implements AbstractTranslucentBlock {

    public TranslucentBlockMixin(Settings settings) {
        super(settings);
    }

    @Inject(method = "isSideInvisible", at = @At("HEAD"), cancellable = true)
    protected void isSideInvisibleChanged(BlockState state, BlockState stateFrom, Direction direction, CallbackInfoReturnable<Boolean> cir){
        if (!(stateFrom.getBlock() instanceof AbstractTranslucentBlock)) {
            cir.setReturnValue(super.isSideInvisible(state, stateFrom, direction));
        }

        if ( (stateFrom.getBlock() instanceof TranslucentBlock)){
            cir.setReturnValue(stateFrom.getBlock() == this || super.isSideInvisible(state, stateFrom, direction));
        }

        if (stateFrom.getBlock() instanceof TranslucentSlab){
            if (((TranslucentSlab)(stateFrom.getBlock())).getBlockSeries() != this)
                cir.setReturnValue(super.isSideInvisible(state, stateFrom, direction));
            if (hasCompleteSlabSurface(stateFrom, direction.getOpposite()))
                cir.setReturnValue(true);
        }

        if (stateFrom.getBlock() instanceof TranslucentStairs){
            if (((TranslucentStairs)(stateFrom.getBlock())).getBlockSeries() != this)
                cir.setReturnValue(super.isSideInvisible(state, stateFrom, direction));
            if (hasCompleteStairSurface(stateFrom, direction.getOpposite())) cir.setReturnValue(true);
        }
    }

}
