package com.yipkei.vanilladdition.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import com.yipkei.vanilladdition.handler.CrafterHandler;
import com.yipkei.vanilladdition.helper.ModRecipeHelper;
import net.minecraft.block.BlockState;
import net.minecraft.block.CrafterBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.CrafterBlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.input.CraftingRecipeInput;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CrafterBlock.class)
public class CrafterBlockMixin {
    @Inject(method = "craft", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/entity/CrafterBlockEntity;createRecipeInput()Lnet/minecraft/recipe/input/CraftingRecipeInput;"))
    private void setCheckPoint(BlockState state, ServerWorld world, BlockPos pos, CallbackInfo ci) {
        BlockEntity entity = world.getBlockEntity(pos);
        if (!(entity instanceof CrafterBlockEntity crafterBlockEntity)) {
            return;
        }
        CraftingRecipeInput input = crafterBlockEntity.createPositionedRecipeInput().input();
        CrafterHandler.IS_REPAIR.set(ModRecipeHelper.checkCraftingRepair(input, world));
        CrafterHandler.PASSED_RESULT.set(false);
        CrafterHandler.SLOT.set(-2);
    }

    @Inject(method = "craft", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isEmpty()Z"))
    private void setSlot(BlockState state, ServerWorld world, BlockPos pos, CallbackInfo ci){
        if (CrafterHandler.SLOT.get()>-2) CrafterHandler.SLOT.set(CrafterHandler.SLOT.get()+1);
    }

    @ModifyArg(method = "craft", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/CrafterBlock;transferOrSpawnStack(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/entity/CrafterBlockEntity;Lnet/minecraft/item/ItemStack;Lnet/minecraft/block/BlockState;Lnet/minecraft/recipe/RecipeEntry;)V"), index = 3)
    private ItemStack setNoRemainder(ItemStack stack, @Local CraftingRecipeInput craftingRecipeInput) {
        if (!CrafterHandler.PASSED_RESULT.get()) {
            CrafterHandler.PASSED_RESULT.set(true);
            CrafterHandler.SLOT.set(-1);
        } else {
            if (CrafterHandler.IS_REPAIR.get() || stack.isOf(craftingRecipeInput.getStackInSlot(CrafterHandler.SLOT.get()).getItem())) return ItemStack.EMPTY;
        }
        return stack;
    }

    @Inject(method = "method_54474", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;decrement(I)V"), cancellable = true)
    private static void keepRemainder(ItemStack stack, CallbackInfo ci){
        if (stack.getRecipeRemainder().isOf(stack.getItem())) {
            stack.setDamage(stack.getRecipeRemainder().getDamage());
            ci.cancel();
        }
    }


    @Inject(method = "craft", at = @At("RETURN"))
    private void clean(BlockState state, ServerWorld world, BlockPos pos, CallbackInfo ci) {
        CrafterHandler.IS_REPAIR.remove();
        CrafterHandler.PASSED_RESULT.remove();
        CrafterHandler.SLOT.remove();
    }
}
