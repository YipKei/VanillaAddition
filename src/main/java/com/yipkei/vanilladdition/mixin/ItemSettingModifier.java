package com.yipkei.vanilladdition.mixin;

import net.minecraft.item.ItemStack;

public interface ItemSettingModifier {
    public ItemStack getDestroyedStack(int damage);
}
