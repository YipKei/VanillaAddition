package com.yipkei.vanilladdition.item;

import net.minecraft.item.Item;

/**
 * 改为在接口 {@link com.yipkei.vanilladdition.item.AbstractDurabilityItem} 中重载该方法，由该接口继承 {@link net.fabricmc.fabric.api.item.v1.FabricItem} 接口。
 * <p>
 * 接口仅有唯一重载的 Default 方法，
 * <pre>
 *     {@code
 *     @Override
 *     Default ItemStack getRecipeRemainder(ItemStack stack){
 *         if (stack.getDamage()< stack.getMaxDamage()-1){
 *             ItemStack processed = stack.copy();
 *             processed.setDamage(stack.getDamage()+1);
 *             return processed;
 *         }
 *         return ItemStack.EMPTY;
 *     }}
 * </pre>
 * <p>
 * 使用接口的优点是可以被应用于原版物品的 Mixin ，方便拓展与标记，同时可以应用于高级物品的自定义继承，如一个继承了 ToolItem 的自定义物品
 * <p>
 * 如果不使用接口，则需要继承 {@link net.fabricmc.fabric.api.item.v1.FabricItem} 接口，并重载该方法
 * <p>
 * 注意将 {@code Default} 替换为 {@code public}
 */
public class SimpleDurabilityTool extends Item implements AbstractDurabilityItem {

    public SimpleDurabilityTool(Item.Settings settings) {
        super(settings);
    }
}
