package com.yipkei.vanilladdition.util;

import com.yipkei.vanilladdition.VanillaAddition;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {

    public static class Blocks {
        public static final TagKey<Block> NULL_BLOCK = createTag("null_block");
        public static final TagKey<Block> OBSIDIAN = createTag("obsidian");
        public static final TagKey<Block> WORLD_DESTROYER = createTag("world_destroyer");
        public static final TagKey<Block> FAIRY_WAND_REPLACEABLE = createTag("fairy_wand_replaceable");
        public static final TagKey<Block> NETHER_BRICKS = createTag("nether_bricks");

        private static TagKey<Block> createTag(String name){
            return TagKey.of(RegistryKeys.BLOCK,Identifier.of(VanillaAddition.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> STEEL_TOOLS = createTag("steel_tools");
        public static final TagKey<Item> DIAMOND_LIKE_SHARDS = createTag("diamond_like_shards");
        public static final TagKey<Item> DIAMOND_LIKE_INGREDIENTS = createTag("diamond_like_ingredients");
        public static final TagKey<Item> QUARTZ_BLOCK = createTag("quartz_block");
        public static final TagKey<Item> SHEARS = createTag("shears");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(VanillaAddition.MOD_ID, name));
        }
    }

    public static class Structures{
//        public static final TagKey<Structures>
    }
}
