package com.yipkei.vanilladdition.mixin;

import com.mojang.datafixers.util.Pair;
import com.yipkei.vanilladdition.item.AbstractDurabilityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RepairItemRecipe;
import net.minecraft.recipe.input.CraftingRecipeInput;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RepairItemRecipe.class)
public class RepairItemRecipeMixin {
    /**
     * 修复类配方的判断方法，寻找匹配物品对。当返回的物品对符合特定条件，则让匹配对返回为空。
     * <p>
     * 匹配对非空，且第一个物品存在返回值，且属于给定的物品类型时，令匹配对返回为空，否则不修改。
     * <p>
     * 如果你希望所有耐久配方无都无法参与修复，则可以去掉对物品类型的判断。
     * <p>
     * 对物品类型的判断推荐使用 {@code instanceof} ，只要你物品类型没注册错，那就必定生效，缺点是属于动态硬编码。
     * 其次可以使用 {@code itemTag} ，优点是可以被外部数据包修改，缺点是忘记加标签会出事。
     * 最后最不推荐是直接硬编码。
     * <p>
     * 通过该方法禁用的物品放置在合成台上时，不会触发合成提示，即显示无产物，无法合成
     * */
    @Inject(method = "findPair", at = @At("RETURN"), cancellable = true)
    private void disableDurabilityPair(CraftingRecipeInput input, CallbackInfoReturnable<Pair<ItemStack, ItemStack>> cir){
        Pair<ItemStack, ItemStack> pair = cir.getReturnValue();
        cir.setReturnValue((pair != null && pair.getFirst().getItem().getDefaultStack().getRecipeRemainder() != null && pair.getFirst().getItem() instanceof AbstractDurabilityItem) ? null : pair);
    }
}
