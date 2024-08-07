package com.yipkei.vanilladdition.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import com.yipkei.vanilladdition.block.BlindBox;
import net.minecraft.block.Block;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.village.TradeOffer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(VillagerEntity.class)
public class VillagerEntityMixin {

    @ModifyArg(method = "prepareOffersFor", at = @At(value = "INVOKE", target = "Lnet/minecraft/village/TradeOffer;increaseSpecialPrice(I)V"))
    private int replaceVault(int increment, @Local TradeOffer tradeOffer){
        return (Block.getBlockFromItem(tradeOffer.getSellItem().getItem()) instanceof BlindBox) ? 0 : increment;
    }
}
