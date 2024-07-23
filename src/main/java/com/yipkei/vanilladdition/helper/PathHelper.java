package com.yipkei.vanilladdition.helper;

import com.yipkei.vanilladdition.VanillaAddition;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class PathHelper {
    public static Item pathChange(Item item, String addString){
        return Registries.ITEM.get(Identifier.of(VanillaAddition.MOD_ID, Registries.ITEM.getId(item).getPath() + addString));
    }

    public static Item pathChange(Item item, String addString, String namespace){
        return Registries.ITEM.get(Identifier.of(namespace, Registries.ITEM.getId(item).getPath() + addString));
    }

    public static Item getItemFromName(String name){
        return Registries.ITEM.get(Identifier.of(VanillaAddition.MOD_ID, name));
    }

    public static Item getItemFromName(String name, String namespace){
        return Registries.ITEM.get(Identifier.of(namespace, name));
    }

    public static Item getVanillaItemFromName(String name){
        return Registries.ITEM.get(Identifier.ofVanilla(name));
    }
}
