package com.yipkei.vanilladdition.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.yipkei.vanilladdition.handler.BeaconHandler;
import com.yipkei.vanilladdition.init.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BeaconBlockEntity;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BeaconBlockEntity.class)
public class BeaconBlockEntityMixin {
    @ModifyExpressionValue(method = "updateLevel", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;getBlockState(Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/block/BlockState;"))
    private static BlockState getLevel(BlockState state){
        BeaconHandler.SHOULD_CHECK_MIDDLE.set(false);
        if (!state.isIn(BlockTags.BEACON_BASE_BLOCKS)) {
            BeaconHandler.SHOULD_CHECK_MIDDLE.set(true);
        }
        return state;
    }

    @Inject(method = "updateLevel", at = @At("RETURN"), cancellable = true)
    private static void setReturnLevel(World world, int x, int y, int z, CallbackInfoReturnable<Integer> cir){
        boolean bl = BeaconHandler.SHOULD_CHECK_MIDDLE.get();
        BeaconHandler.SHOULD_CHECK_MIDDLE.remove();
        if (bl && world.getBlockState(new BlockPos(x, y-1, z)).isOf(ModBlocks.PORTABLE_BEACON_BASE)) {
            cir.setReturnValue(4);
        }
    }

}
