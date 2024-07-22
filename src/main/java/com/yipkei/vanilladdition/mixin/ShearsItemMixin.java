package com.yipkei.vanilladdition.mixin;

import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShearsItem;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ShearsItem.class)
public class ShearsItemMixin implements FabricItem {
    @Override
    public final ItemStack getRecipeRemainder(ItemStack stack) {
        if (stack.getDamage()< stack.getMaxDamage()-1){
            ItemStack processed = stack.copy();
            processed.setDamage(stack.getDamage()+1);
            return processed;
        }
        return ItemStack.EMPTY;
    }
}
