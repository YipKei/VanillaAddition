package com.yipkei.vanilladdition.handler;

import net.minecraft.item.ItemStack;

public class SmithingRemainderHandler {
    public static final ThreadLocal<ItemStack> REMAINDER_STACK = new ThreadLocal<>();
}
