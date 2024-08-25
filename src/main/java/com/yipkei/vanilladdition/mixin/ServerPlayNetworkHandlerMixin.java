package com.yipkei.vanilladdition.mixin;

import com.yipkei.vanilladdition.block.screen.SmitherScreenHandler;
import net.minecraft.network.packet.c2s.play.SlotChangedStateC2SPacket;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayNetworkHandler.class)
public class ServerPlayNetworkHandlerMixin {
    @Shadow
    public ServerPlayerEntity player;

    @Inject(method = "onSlotChangedState", at = @At("RETURN"))
    private void smitherSet(SlotChangedStateC2SPacket packet, CallbackInfo ci){
        Object object = this.player.currentScreenHandler;
        if (object instanceof SmitherScreenHandler) {
            object = ((SmitherScreenHandler) object).getInputInventory();
        }
    }
}
