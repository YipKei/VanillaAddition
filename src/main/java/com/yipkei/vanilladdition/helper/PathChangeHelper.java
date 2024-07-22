package com.yipkei.vanilladdition.helper;

import com.yipkei.vanilladdition.VanillaAddition;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class PathChangeHelper {
    public static Item pathChange(Item item, String addString){
        return Registries.ITEM.get(Identifier.of(VanillaAddition.MOD_ID, Registries.ITEM.getId(item).getPath() + addString));
    }

    public static Item pathChange(Item item, String addString, String namespace){
        return Registries.ITEM.get(Identifier.of(namespace, Registries.ITEM.getId(item).getPath() + addString));
    }
}
