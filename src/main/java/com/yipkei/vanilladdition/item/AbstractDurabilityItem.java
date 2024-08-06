package com.yipkei.vanilladdition.item;

import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.minecraft.item.ItemStack;

public interface AbstractDurabilityItem extends FabricItem {
    @Override
    default ItemStack getRecipeRemainder(ItemStack stack){
        if (stack.getDamage()< stack.getMaxDamage()-1){
            ItemStack processed = stack.copy();
            processed.setDamage(stack.getDamage()+1);
            return processed;
        }
        return ItemStack.EMPTY;
    }
}
