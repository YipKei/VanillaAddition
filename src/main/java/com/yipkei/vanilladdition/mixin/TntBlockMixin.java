package com.yipkei.vanilladdition.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.TntBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
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
public class TntBlockMixin extends Block {
    public TntBlockMixin(Settings settings) {
        super(settings);
    }

    @Inject(method = "onUseWithItem", at = @At("HEAD"), cancellable = true)
    private void replaceJudgment(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit, CallbackInfoReturnable<ItemActionResult> cir){
        if (!stack.isIn(ItemTags.CREEPER_IGNITERS)) {
            cir.setReturnValue(super.onUseWithItem(stack, state, world, pos, player, hand, hit));
        }
    }


}
