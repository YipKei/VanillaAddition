package com.yipkei.vanilladdition.mixin;

import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.minecraft.item.FlintAndSteelItem;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(FlintAndSteelItem.class)
public class FlintAndSteelItemMixin implements FabricItem {
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
