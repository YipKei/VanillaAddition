package com.yipkei.vanilladdition.mixin;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Item.class)
public abstract class ItemMixin implements ItemSettingModifier{

    @Shadow public abstract ItemStack getDefaultStack();

    @Override
    public ItemStack getDestroyedStack(int damage){
        ItemStack stack = this.getDefaultStack();
        //stack.damage(damage);
        return stack;
    }
}
