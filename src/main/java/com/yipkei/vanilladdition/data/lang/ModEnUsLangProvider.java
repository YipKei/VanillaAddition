package com.yipkei.vanilladdition.data.lang;

import com.yipkei.vanilladdition.init.ModBlocks;
import com.yipkei.vanilladdition.init.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModEnUsLangProvider extends FabricLanguageProvider {
    public ModEnUsLangProvider(FabricDataOutput dataGenerator, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup){
        super(dataGenerator,"en_us",registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.STEEL_AXE,                      "Steel Axe");
        translationBuilder.add(ModItems.STEEL_HOE,                      "Steel Hoe");
        translationBuilder.add(ModItems.STEEL_SWORD,                    "Steel Sword");
        translationBuilder.add(ModItems.STEEL_PICKAXE,                  "Steel Pickaxe");
        translationBuilder.add(ModItems.STEEL_SHOVEL,                   "Steel Shovel");
        translationBuilder.add(ModItems.STEEL_INGOT,                    "Steel Ingot");
        translationBuilder.add(ModItems.STONE_HAMMER,                   "Steel Hammer");
        translationBuilder.add(ModItems.IRON_HAMMER,                    "Iron Hammer");
        translationBuilder.add(ModItems.DIAMOND_HAMMER,                 "Diamond Hammer");
        translationBuilder.add(ModItems.DIAMOND_SHARD,                  "Diamond Shard");
        translationBuilder.add(ModItems.DIAMOND_SHARDS_UPGRADED_SMITHING_TEMPLATE,"Faked Diamond Upgraded Smithing Template");
        translationBuilder.add(ModItems.DIAMOND_UPGRADED_AXE,           "Faked Diamond Axe");
        translationBuilder.add(ModItems.DIAMOND_UPGRADED_PICKAXE,       "Faked Diamond Pickaxe");
        translationBuilder.add(ModItems.ROASTED_ROTTEN_FLESH,           "Latiao");

        //方块
        translationBuilder.add(ModBlocks.STEEL_BLOCK,                   "Steel Block");

        translationBuilder.add(ModBlocks.STONE_WALL,                    "Stone Block");
        translationBuilder.add(ModBlocks.POLISHED_GRANITE_WALL,         "Polished Granite Wall");
        translationBuilder.add(ModBlocks.POLISHED_DIORITE_WALL,         "Polished Diorite Wall");
        translationBuilder.add(ModBlocks.POLISHED_ANDESITE_WALL,        "Polished Andesite Wall");
        translationBuilder.add(ModBlocks.SMOOTH_SANDSTONE_WALL,         "Smooth Sandstone Wall");
        translationBuilder.add(ModBlocks.SMOOTH_RED_SANDSTONE_WALL,     "Smooth Red Sandstone Wall");
        translationBuilder.add(ModBlocks.PRISMARINE_BRICK_WALL,         "Prismarine Brick Wall");
        translationBuilder.add(ModBlocks.DARK_PRISMARINE_WALL,          "Dark Prismarine Wall");
        translationBuilder.add(ModBlocks.SMOOTH_STONE_WALL,             "Smooth Stone Wall");
        translationBuilder.add(ModBlocks.SMOOTH_STONE_STAIRS,           "Smooth Stone Stairs");
        translationBuilder.add(ModBlocks.BASALT_WALL,                   "Basalt Wall");
        translationBuilder.add(ModBlocks.BASALT_STAIRS,                 "Basalt Stairs");
        translationBuilder.add(ModBlocks.BASALT_SLAB,                   "Basalt Slab");
        translationBuilder.add(ModBlocks.SMOOTH_BASALT_WALL,            "Smooth Basalt Wall");
        translationBuilder.add(ModBlocks.SMOOTH_BASALT_STAIRS,          "Smooth Basalt Stairs");
        translationBuilder.add(ModBlocks.SMOOTH_BASALT_SLAB,            "Smooth Basalt Slab");
        translationBuilder.add(ModBlocks.POLISHED_BASALT_WALL,          "Polished Basalt Wall");
        translationBuilder.add(ModBlocks.POLISHED_BASALT_STAIRS,        "Polished Basalt Stairs");
        translationBuilder.add(ModBlocks.POLISHED_BASALT_SLAB,          "Polished Basalt Slab");
        translationBuilder.add(ModBlocks.DIRT_WALL,                     "Dirt Wall");
        translationBuilder.add(ModBlocks.DIRT_STAIRS,                   "Dirt Stairs");
        translationBuilder.add(ModBlocks.DIRT_SLAB,                     "Dirt Slab");
        translationBuilder.add(ModBlocks.MUD_WALL,                      "Mud Wall");
        translationBuilder.add(ModBlocks.MUD_STAIRS,                    "Mud Stairs");
        translationBuilder.add(ModBlocks.MUD_SLAB,                      "Mud Slab");
        translationBuilder.add(ModBlocks.CLAY_WALL,                     "Clay Wall");
        translationBuilder.add(ModBlocks.CLAY_STAIRS,                   "Clay Stairs");
        translationBuilder.add(ModBlocks.CLAY_SLAB,                     "Clay Slab");
        translationBuilder.add(ModBlocks.CALCITE_WALL,                  "Calcite Wall");
        translationBuilder.add(ModBlocks.CALCITE_STAIRS,                "Calcite Stairs");
        translationBuilder.add(ModBlocks.CALCITE_SLAB,                  "Calcite Slab");
        translationBuilder.add(ModBlocks.NETHERRACK_WALL,               "Netherrack Wall");
        translationBuilder.add(ModBlocks.NETHERRACK_STAIRS,             "Netherrack Stairs");
        translationBuilder.add(ModBlocks.NETHERRACK_SLAB,               "Netherrack Slab");
        translationBuilder.add(ModBlocks.OBSIDIAN_WALL,                 "Obsidian Wall");
        translationBuilder.add(ModBlocks.OBSIDIAN_STAIRS,               "Obsidian Stairs");
        translationBuilder.add(ModBlocks.OBSIDIAN_SLAB,                 "Obsidian Slab");
        translationBuilder.add(ModBlocks.CRYING_OBSIDIAN_WALL,          "Crying Obsidian Wall");
        translationBuilder.add(ModBlocks.CRYING_OBSIDIAN_STAIRS,        "Crying Obsidian Stairs");
        translationBuilder.add(ModBlocks.CRYING_OBSIDIAN_SLAB,          "Crying Obsidian Slab");
        translationBuilder.add(ModBlocks.PURPUR_WALL,                   "Purpur Wall");
        translationBuilder.add(ModBlocks.END_STONE_WALL,                "End Stone Wall");
        translationBuilder.add(ModBlocks.END_STONE_STAIRS,              "End Stone Stairs");
        translationBuilder.add(ModBlocks.END_STONE_SLAB,                "End Stone Slab");
        translationBuilder.add(ModBlocks.QUARTZ_WALL,                   "Quartz Wall");
        translationBuilder.add(ModBlocks.SMOOTH_QUARTZ_WALL,            "Smooth Quartz Wall");
        translationBuilder.add(ModBlocks.AMETHYST_WALL,                 "Amethyst Wall");
        translationBuilder.add(ModBlocks.AMETHYST_STAIRS,               "Amethyst Stairs");
        translationBuilder.add(ModBlocks.AMETHYST_SLAB,                 "Amethyst Slab");
        translationBuilder.add(ModBlocks.GLOWSTONE_WALL,                "Glowstone Wall");
        translationBuilder.add(ModBlocks.GLOWSTONE_STAIRS,              "Glowstone Stairs");
        translationBuilder.add(ModBlocks.GLOWSTONE_SLAB,                "Glowstone Slabs");
        translationBuilder.add(ModBlocks.ICE_WALL,                      "Ice Wall");
        translationBuilder.add(ModBlocks.ICE_STAIRS,                    "Ice Stairs");
        translationBuilder.add(ModBlocks.ICE_SLAB,                      "Ice Slab");
        translationBuilder.add(ModBlocks.PACKED_ICE_WALL,               "Packed Ice Wall");
        translationBuilder.add(ModBlocks.PACKED_ICE_STAIRS,             "Packed Ice Stairs");
        translationBuilder.add(ModBlocks.PACKED_ICE_SLAB,               "Packed Ice Slab");
        translationBuilder.add(ModBlocks.BLUE_ICE_WALL,                 "Blue Ice Wall");
        translationBuilder.add(ModBlocks.BLUE_ICE_STAIRS,               "Blue Ice Stairs");
        translationBuilder.add(ModBlocks.BLUE_ICE_SLAB,                 "Blue Ice Slab");

        translationBuilder.add(ModBlocks.WHITE_CONCRETE_WALL,           "White Concrete Wall");
        translationBuilder.add(ModBlocks.WHITE_CONCRETE_STAIRS,         "White Concrete Stairs");
        translationBuilder.add(ModBlocks.WHITE_CONCRETE_SLAB,           "White Concrete Slab");
        translationBuilder.add(ModBlocks.LIGHT_GRAY_CONCRETE_WALL,      "Light Gray Concrete Wall");
        translationBuilder.add(ModBlocks.LIGHT_GRAY_CONCRETE_STAIRS,    "Light Gray Concrete Stairs");
        translationBuilder.add(ModBlocks.LIGHT_GRAY_CONCRETE_SLAB,      "Light Gray Concrete Slab");
        translationBuilder.add(ModBlocks.GRAY_CONCRETE_WALL,            "Gray Concrete Wall");
        translationBuilder.add(ModBlocks.GRAY_CONCRETE_STAIRS,          "Gray Concrete Stairs");
        translationBuilder.add(ModBlocks.GRAY_CONCRETE_SLAB,            "Gray Concrete Slab");
        translationBuilder.add(ModBlocks.BLACK_CONCRETE_WALL,           "Black Concrete Wall");
        translationBuilder.add(ModBlocks.BLACK_CONCRETE_STAIRS,         "Black Concrete Stairs");
        translationBuilder.add(ModBlocks.BLACK_CONCRETE_SLAB,           "Black Concrete Slab");
        translationBuilder.add(ModBlocks.BROWN_CONCRETE_WALL,           "Brown Concrete Wall");
        translationBuilder.add(ModBlocks.BROWN_CONCRETE_STAIRS,         "Brown Concrete Stairs");
        translationBuilder.add(ModBlocks.BROWN_CONCRETE_SLAB,           "Brown Concrete Slab");
        translationBuilder.add(ModBlocks.RED_CONCRETE_WALL,             "Red Concrete Wall");
        translationBuilder.add(ModBlocks.RED_CONCRETE_STAIRS,           "Red Concrete Stairs");
        translationBuilder.add(ModBlocks.RED_CONCRETE_SLAB,             "Red Concrete Slab");
        translationBuilder.add(ModBlocks.ORANGE_CONCRETE_WALL,          "Orange Concrete Wall");
        translationBuilder.add(ModBlocks.ORANGE_CONCRETE_STAIRS,        "Orange Concrete Stairs");
        translationBuilder.add(ModBlocks.ORANGE_CONCRETE_SLAB,          "Orange Concrete Slab");
        translationBuilder.add(ModBlocks.YELLOW_CONCRETE_WALL,          "Yellow Concrete Wall");
        translationBuilder.add(ModBlocks.YELLOW_CONCRETE_STAIRS,        "Yellow Concrete Stairs");
        translationBuilder.add(ModBlocks.YELLOW_CONCRETE_SLAB,          "Yellow Concrete Slab");
        translationBuilder.add(ModBlocks.LIME_CONCRETE_WALL,            "Lime Concrete Wall");
        translationBuilder.add(ModBlocks.LIME_CONCRETE_STAIRS,          "Lime Concrete Stairs");
        translationBuilder.add(ModBlocks.LIME_CONCRETE_SLAB,            "Lime Concrete Slab");
        translationBuilder.add(ModBlocks.GREEN_CONCRETE_WALL,           "Green Concrete Wall");
        translationBuilder.add(ModBlocks.GREEN_CONCRETE_STAIRS,         "Green Concrete Stairs");
        translationBuilder.add(ModBlocks.GREEN_CONCRETE_SLAB,           "Green Concrete Slab");
        translationBuilder.add(ModBlocks.CYAN_CONCRETE_WALL,            "Cyan Concrete Wall");
        translationBuilder.add(ModBlocks.CYAN_CONCRETE_STAIRS,          "Cyan Concrete Stair");
        translationBuilder.add(ModBlocks.CYAN_CONCRETE_SLAB,            "Cyan Concrete Slab");
        translationBuilder.add(ModBlocks.LIGHT_BLUE_CONCRETE_WALL,      "Light Blue Concrete Wall");
        translationBuilder.add(ModBlocks.LIGHT_BLUE_CONCRETE_STAIRS,    "Light Blue Concrete Stairs");
        translationBuilder.add(ModBlocks.LIGHT_BLUE_CONCRETE_SLAB,      "Light Blue Concrete Slab");
        translationBuilder.add(ModBlocks.BLUE_CONCRETE_WALL,            "Blue Concrete Wall");
        translationBuilder.add(ModBlocks.BLUE_CONCRETE_STAIRS,          "Blue Concrete Stairs");
        translationBuilder.add(ModBlocks.BLUE_CONCRETE_SLAB,            "Blue Concrete Slab");
        translationBuilder.add(ModBlocks.PURPLE_CONCRETE_WALL,          "Purple Concrete Wall");
        translationBuilder.add(ModBlocks.PURPLE_CONCRETE_STAIRS,        "Purple Concrete Stairs");
        translationBuilder.add(ModBlocks.PURPLE_CONCRETE_SLAB,          "Purple Concrete Slab");
        translationBuilder.add(ModBlocks.MAGENTA_CONCRETE_WALL,         "Magenta Concrete Wall");
        translationBuilder.add(ModBlocks.MAGENTA_CONCRETE_STAIRS,       "Magenta Concrete Stairs");
        translationBuilder.add(ModBlocks.MAGENTA_CONCRETE_SLAB,         "Magenta Concrete Slab");
        translationBuilder.add(ModBlocks.PINK_CONCRETE_WALL,            "Pink Concrete Wall");
        translationBuilder.add(ModBlocks.PINK_CONCRETE_STAIRS,          "Pink Concrete Stairs");
        translationBuilder.add(ModBlocks.PINK_CONCRETE_SLAB,            "Pink Concrete Slab");

        translationBuilder.add(ModBlocks.TERRACOTTA_WALL,               "Terracotta Wall");
        translationBuilder.add(ModBlocks.TERRACOTTA_STAIRS,             "Terracotta Stairs");
        translationBuilder.add(ModBlocks.TERRACOTTA_SLAB,               "Terracotta Slab");
        translationBuilder.add(ModBlocks.WHITE_TERRACOTTA_WALL,         "White Terracotta Wall");
        translationBuilder.add(ModBlocks.WHITE_TERRACOTTA_STAIRS,       "White Terracotta Stairs");
        translationBuilder.add(ModBlocks.WHITE_TERRACOTTA_SLAB,         "White Terracotta Slab");
        translationBuilder.add(ModBlocks.LIGHT_GRAY_TERRACOTTA_WALL,    "Light Gray Terracotta Wall");
        translationBuilder.add(ModBlocks.LIGHT_GRAY_TERRACOTTA_STAIRS,  "Light Gray Terracotta Stairs");
        translationBuilder.add(ModBlocks.LIGHT_GRAY_TERRACOTTA_SLAB,    "Light Gray Terracotta Slab");
        translationBuilder.add(ModBlocks.GRAY_TERRACOTTA_WALL,          "Gray Terracotta Wall");
        translationBuilder.add(ModBlocks.GRAY_TERRACOTTA_STAIRS,        "Gray Terracotta Stairs");
        translationBuilder.add(ModBlocks.GRAY_TERRACOTTA_SLAB,          "Gray Terracotta Slab");
        translationBuilder.add(ModBlocks.BLACK_TERRACOTTA_WALL,         "Black Terracotta Wall");
        translationBuilder.add(ModBlocks.BLACK_TERRACOTTA_STAIRS,       "Black Terracotta Stairs");
        translationBuilder.add(ModBlocks.BLACK_TERRACOTTA_SLAB,         "Black Terracotta Slab");
        translationBuilder.add(ModBlocks.BROWN_TERRACOTTA_WALL,         "Brown Terracotta Wall");
        translationBuilder.add(ModBlocks.BROWN_TERRACOTTA_STAIRS,       "Brown Terracotta Stairs");
        translationBuilder.add(ModBlocks.BROWN_TERRACOTTA_SLAB,         "Brown Terracotta Slab");
        translationBuilder.add(ModBlocks.RED_TERRACOTTA_WALL,           "Red Terracotta Wall");
        translationBuilder.add(ModBlocks.RED_TERRACOTTA_STAIRS,         "Red Terracotta Stairs");
        translationBuilder.add(ModBlocks.RED_TERRACOTTA_SLAB,           "Red Terracotta Slab");
        translationBuilder.add(ModBlocks.ORANGE_TERRACOTTA_WALL,        "Orange Terracotta Wall");
        translationBuilder.add(ModBlocks.ORANGE_TERRACOTTA_STAIRS,      "Orange Terracotta Stairs");
        translationBuilder.add(ModBlocks.ORANGE_TERRACOTTA_SLAB,        "Orange Terracotta Slab");
        translationBuilder.add(ModBlocks.YELLOW_TERRACOTTA_WALL,        "Yellow Terracotta Wall");
        translationBuilder.add(ModBlocks.YELLOW_TERRACOTTA_STAIRS,      "Yellow Terracotta Stairs");
        translationBuilder.add(ModBlocks.YELLOW_TERRACOTTA_SLAB,        "Yellow Terracotta Slab");
        translationBuilder.add(ModBlocks.LIME_TERRACOTTA_WALL,          "Lime Terracotta Wall");
        translationBuilder.add(ModBlocks.LIME_TERRACOTTA_STAIRS,        "Lime Terracotta Stairs");
        translationBuilder.add(ModBlocks.LIME_TERRACOTTA_SLAB,          "Lime Terracotta Slab");
        translationBuilder.add(ModBlocks.GREEN_TERRACOTTA_WALL,         "Green Terracotta Wall");
        translationBuilder.add(ModBlocks.GREEN_TERRACOTTA_STAIRS,       "Green Terracotta Stairs");
        translationBuilder.add(ModBlocks.GREEN_TERRACOTTA_SLAB,         "Green Terracotta Slab");
        translationBuilder.add(ModBlocks.CYAN_TERRACOTTA_WALL,          "Cyan Terracotta Wall");
        translationBuilder.add(ModBlocks.CYAN_TERRACOTTA_STAIRS,        "Cyan Terracotta Stair");
        translationBuilder.add(ModBlocks.CYAN_TERRACOTTA_SLAB,          "Cyan Terracotta Slab");
        translationBuilder.add(ModBlocks.LIGHT_BLUE_TERRACOTTA_WALL,    "Light Blue Terracotta Wall");
        translationBuilder.add(ModBlocks.LIGHT_BLUE_TERRACOTTA_STAIRS,  "Light Blue Terracotta Stairs");
        translationBuilder.add(ModBlocks.LIGHT_BLUE_TERRACOTTA_SLAB,    "Light Blue Terracotta Slab");
        translationBuilder.add(ModBlocks.BLUE_TERRACOTTA_WALL,          "Blue Terracotta Wall");
        translationBuilder.add(ModBlocks.BLUE_TERRACOTTA_STAIRS,        "Blue Terracotta Stairs");
        translationBuilder.add(ModBlocks.BLUE_TERRACOTTA_SLAB,          "Blue Terracotta Slab");
        translationBuilder.add(ModBlocks.PURPLE_TERRACOTTA_WALL,        "Purple Terracotta Wall");
        translationBuilder.add(ModBlocks.PURPLE_TERRACOTTA_STAIRS,      "Purple Terracotta Stairs");
        translationBuilder.add(ModBlocks.PURPLE_TERRACOTTA_SLAB,        "Purple Terracotta Slab");
        translationBuilder.add(ModBlocks.MAGENTA_TERRACOTTA_WALL,       "Magenta Terracotta Wall");
        translationBuilder.add(ModBlocks.MAGENTA_TERRACOTTA_STAIRS,     "Magenta Terracotta Stairs");
        translationBuilder.add(ModBlocks.MAGENTA_TERRACOTTA_SLAB,       "Magenta Terracotta Slab");
        translationBuilder.add(ModBlocks.PINK_TERRACOTTA_WALL,          "Pink Terracotta Wall");
        translationBuilder.add(ModBlocks.PINK_TERRACOTTA_STAIRS,        "Pink Terracotta Stairs");
        translationBuilder.add(ModBlocks.PINK_TERRACOTTA_SLAB,          "Pink Terracotta Slab");

        //文本
        translationBuilder.add("diamond_shards_upgrade_applies_to",         "Steel Tools");
        translationBuilder.add("diamond_shards_upgrade_ingredients",        "Diamond Shard");
        translationBuilder.add("diamond_shards_upgrade",                    "Faked Diamond Upgrade");
        translationBuilder.add("diamond_shards_upgrade_base_slot",          "Put Steel Pickaxe or Axe");
        translationBuilder.add("diamond_shards_upgrade_additions_slot",     "Put Any Diamond Shards");

        translationBuilder.add("itemGroup.vanilla_addition",                "Vanilla Addition");
        translationBuilder.add("itemGroup.building_addition",               "Building Addition");
    }


}
