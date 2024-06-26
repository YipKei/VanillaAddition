package com.yipkei.vanilladdition.mixin;

import com.yipkei.vanilladdition.init.ModItems;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.boss.dragon.EnderDragonFight;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.feature.EndPortalFeature;
import org.jetbrains.annotations.Nullable;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EnderDragonFight.class)
public class EnderDragonFightMixin {

    @Shadow
    private boolean previouslyKilled;

    @Shadow
    @Final
    private ServerWorld world;

    @Shadow
    @Final
    private @Nullable BlockPos origin;

    @Inject(
            method = "dragonKilled",
            at =
            @At(
                    value = "FIELD",
                    target = "Lnet/minecraft/entity/boss/dragon/EnderDragonFight;previouslyKilled:Z",
                    opcode = Opcodes.PUTFIELD))
    private void dropElytraCopyTemplate(EnderDragonEntity dragon, CallbackInfo ci){
        BlockPos templateDropPos = this.world.getTopPosition(Heightmap.Type.MOTION_BLOCKING, EndPortalFeature.offsetOrigin(this.origin)).offset(Direction.Axis.Y, 6);
        if (!previouslyKilled){
            ItemEntity template = new ItemEntity(world, templateDropPos.getX(), templateDropPos.getY(), templateDropPos.getZ(), new ItemStack(ModItems.ELYTRA_COPY_TEMPLATE, 1));
            this.world.spawnEntity(template);
        }
    }

}
