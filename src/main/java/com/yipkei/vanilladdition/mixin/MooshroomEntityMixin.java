package com.yipkei.vanilladdition.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalRef;
import com.yipkei.vanilladdition.util.ModTags;
import net.minecraft.entity.passive.MooshroomEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MooshroomEntity.class)
public abstract class MooshroomEntityMixin{

    @Inject(method = "interactMob", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"))
    private void changeShears(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> cir, @Local LocalRef<ItemStack> itemStackLocalRef){
        if (itemStackLocalRef.get().isIn(ModTags.Items.SHEARS)){
            itemStackLocalRef.set(new ItemStack(Items.SHEARS));
        }
    }
}
