package com.yipkei.vanilladdition.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalRef;
import com.yipkei.vanilladdition.util.ModTags;
import net.minecraft.client.render.entity.SheepEntityRenderer;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Shearable;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.entity.mob.BoggedEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BoggedEntity.class)
public abstract class BoggedEntityMixin extends AbstractSkeletonEntity implements Shearable {
    protected BoggedEntityMixin(EntityType<? extends AbstractSkeletonEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "interactMob", at = @At( value = "HEAD" ), cancellable = true)
    private void checkCorrectItem(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> ci){
        if (!player.getStackInHand(hand).isIn(ModTags.Items.SHEARS)){
            ci.setReturnValue(super.interactMob(player,hand));
        }
    }

    @ModifyExpressionValue(method = "interactMob", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"))
    private boolean replaceCheck(boolean isShears){
        return true;
    }
}
