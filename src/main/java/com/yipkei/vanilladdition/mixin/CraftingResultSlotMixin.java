package com.yipkei.vanilladdition.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalRef;
import com.yipkei.vanilladdition.helper.ModRecipeHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.RecipeInputInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.input.CraftingRecipeInput;
import net.minecraft.screen.slot.CraftingResultSlot;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CraftingResultSlot.class)
public class CraftingResultSlotMixin {
    @Shadow @Final private RecipeInputInventory input;

    /**
     * {@link net.minecraft.screen.slot.CraftingResultSlot#onTakeItem(PlayerEntity, ItemStack)}：提取合成产物
     * <p>
     * 原版在这个方法中进行返还物的设置
     * <p>设置逻辑为，先计算返还物列表，再遍历替换返还物
     * <p>在设置返还物列表之后，插入方法进行判断修改
     * <p>1、获取返还物列表，设置检查标记为空，设置修复标记为否
     * <p>2、遍历返还物列表，判断是否恰好有两个相同物品，如是，设置修复标记为是
     * <p>3、如果是修复配方，那么整个列表设置为空
     * @param player：操作的玩家，用不到
     * @param stack：成品，用不到
     * @param ci：返回值，用不到
     * @param defaultedListRef：合成返还列表，本注入修改的地方
     */
    @Inject(method = "onTakeItem", at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/recipe/RecipeManager;getRemainingStacks(Lnet/minecraft/recipe/RecipeType;Lnet/minecraft/recipe/input/RecipeInput;Lnet/minecraft/world/World;)Lnet/minecraft/util/collection/DefaultedList;"))
    private void removeNonDurabilityTools(PlayerEntity player, ItemStack stack, CallbackInfo ci, @Local LocalRef<DefaultedList<ItemStack>> defaultedListRef){
        World world = player.getWorld();
        CraftingRecipeInput craftingRecipeInput = this.input.createPositionedRecipeInput().input();
        int length = defaultedListRef.get().size();
        boolean isRepair = ModRecipeHelper.checkCraftingRepair(craftingRecipeInput, world);
        if (isRepair){
            defaultedListRef.set(DefaultedList.ofSize(length, ItemStack.EMPTY));
        }
    }
}
