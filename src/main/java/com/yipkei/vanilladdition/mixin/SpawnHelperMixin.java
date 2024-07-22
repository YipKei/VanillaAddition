package com.yipkei.vanilladdition.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.yipkei.vanilladdition.util.ModTags;
import net.minecraft.block.Blocks;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.SpawnHelper;
import net.minecraft.world.gen.StructureAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static com.yipkei.vanilladdition.settings.VanillaAdditionSettings.enableWitherSkeletonSpawnOnMoreBlocks;

@Mixin(SpawnHelper.class)
public class SpawnHelperMixin {

    @Inject(method = "shouldUseNetherFortressSpawns",at = @At("HEAD"), cancellable = true)
    private static void addNewJudgment(BlockPos pos, ServerWorld world, SpawnGroup spawnGroup, StructureAccessor structureAccessor, CallbackInfoReturnable<Boolean> cir){
        boolean canSpawn = world.getBlockState(pos.down()).isOf(Blocks.NETHER_BRICKS);
        if (enableWitherSkeletonSpawnOnMoreBlocks){
            canSpawn = world.getBlockState(pos.down()).isIn(ModTags.Blocks.NETHER_FORTRESS_CAN_SPAWNS);
        }
        if (spawnGroup != SpawnGroup.MONSTER || !canSpawn) {
            cir.setReturnValue(false);
        }
    }

    @ModifyExpressionValue(method = "shouldUseNetherFortressSpawns", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z"))
    private static boolean replaceCheck(boolean isNetherBricks){
        return true;
    }

}
