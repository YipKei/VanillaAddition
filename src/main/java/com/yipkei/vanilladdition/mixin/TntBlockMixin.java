package com.yipkei.vanilladdition.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.yipkei.vanilladdition.handler.TntMixinHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.TntBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TntBlock.class)
public class TntBlockMixin {

    @Inject(method = "onUseWithItem", at = @At("HEAD")/*, cancellable = true*/)
    private void replaceJudgment(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit, CallbackInfoReturnable<ItemActionResult> cir){
        TntMixinHandler.IS_JUDGMENT_CHECK.set(true);
    }

    @Inject(method = "onUseWithItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/TntBlock;primeTnt(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/entity/LivingEntity;)V"))
    private void setPass(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit, CallbackInfoReturnable<ItemActionResult> cir){
        TntMixinHandler.IS_JUDGMENT_CHECK.set(false);
    }

    @ModifyExpressionValue(method = "onUseWithItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"))
    private boolean replaceItemJudgment(boolean original, ItemStack stack){
        return TntMixinHandler.IS_JUDGMENT_CHECK.get() ? stack.isIn(ItemTags.CREEPER_IGNITERS) : stack.isIn(ItemTags.CREEPER_IGNITERS) && !stack.isOf(Items.FIRE_CHARGE);
    }

    @Inject(method = "onUseWithItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;incrementStat(Lnet/minecraft/stat/Stat;)V"))
    private void clearStat(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit, CallbackInfoReturnable<ItemActionResult> cir){
        TntMixinHandler.IS_JUDGMENT_CHECK.remove();
    }




}
