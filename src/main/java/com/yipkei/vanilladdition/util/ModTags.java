package com.yipkei.vanilladdition.util;

import com.yipkei.vanilladdition.VanillaAddition;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {

    public static class Blocks {
        public static final TagKey<Block> NULL_BLOCK = createTag("null_block");
        public static final TagKey<Block> OBSIDIAN = createTag("obsidian");
        public static final TagKey<Block> WORLD_DESTROYER = createTag("world_destroyer");
        public static final TagKey<Block> DEEP_DARK_FANTASY_AFFECTABLE = createTag("deep_dark_fantasy_affectable");
        public static final TagKey<Block> EXPLOSION_CREATOR_AFFECTABLE = createTag("explosion_creator_affectable");
        public static final TagKey<Block> MAGICAL_GIRLS_AFFECTABLE = createTag("magical_girls_affectable");
        public static final TagKey<Block> NETHER_FORTRESS_CAN_SPAWNS = createTag("nether_bricks");
        public static final TagKey<Block> TALL_PLANT_FERTILIZABLE = createTag("bone_meal_drops_extra");

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
        public static final TagKey<Item> HAMMERS = createTag("hammers");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(VanillaAddition.MOD_ID, name));
        }
    }

    public static class Enchantments{

        public static final TagKey<Enchantment> WANDER_NEARBY = createTag("wander_nearby");

        private static TagKey<Enchantment> createTag(String name) {
            return TagKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(VanillaAddition.MOD_ID, name));
        }
    }
}
