package com.yipkei.vanilladdition.item;

import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Hammer extends Item implements FabricItem {

    public Hammer(Item.Settings settings) {
        super(settings);
    }

    @Override
    public  final ItemStack getRecipeRemainder(ItemStack stack){
        if (stack.getDamage()< stack.getMaxDamage()-1){
            ItemStack processed = stack.copy();
            processed.setDamage(stack.getDamage()+1);
            return processed;
        }
        return ItemStack.EMPTY;
    }
}
