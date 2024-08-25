package com.yipkei.vanilladdition.mixin;

import com.yipkei.vanilladdition.block.screen.SmitherScreen;
import com.yipkei.vanilladdition.init.ModScreenHandlerType;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HandledScreens.class)
public class HandledScreensMixin {
    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void addHandledScreens(CallbackInfo ci) {
        HandledScreens.register(ModScreenHandlerType.SMITHER, SmitherScreen::new);
    }
}
