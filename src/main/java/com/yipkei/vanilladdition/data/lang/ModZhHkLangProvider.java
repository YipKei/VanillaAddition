package com.yipkei.vanilladdition.data.lang;

import com.yipkei.vanilladdition.init.ModBlocks;
import com.yipkei.vanilladdition.init.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModZhHkLangProvider extends FabricLanguageProvider {
    public ModZhHkLangProvider(FabricDataOutput dataGenerator, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup){
        super(dataGenerator,"zh_hk",registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.STEEL_AXE,                      "鋼斧");
        translationBuilder.add(ModItems.STEEL_HOE,                      "鋼鏟");
        translationBuilder.add(ModItems.STEEL_SWORD,                    "鋼劍");
        translationBuilder.add(ModItems.STEEL_PICKAXE,                  "鋼鎬");
        translationBuilder.add(ModItems.STEEL_SHOVEL,                   "鋼鋤");
        translationBuilder.add(ModItems.STEEL_INGOT,                    "鋼錠");
        translationBuilder.add(ModItems.STONE_HAMMER,                   "石錘");
        translationBuilder.add(ModItems.IRON_HAMMER,                    "鐵錘");
        translationBuilder.add(ModItems.DIAMOND_HAMMER,                 "鑽石錘");
        translationBuilder.add(ModItems.DIAMOND_SHARD,                  "碎鑽");
        translationBuilder.add(ModItems.DIAMOND_SHARDS_UPGRADED_SMITHING_TEMPLATE,"永流傳模板（流嘢）");
        translationBuilder.add(ModItems.DIAMOND_UPGRADED_AXE,           "鑽石斧（流嘢）");
        translationBuilder.add(ModItems.DIAMOND_UPGRADED_PICKAXE,       "鑽石鎬（流嘢）");
        translationBuilder.add(ModItems.ROASTED_ROTTEN_FLESH,           "辣條");

        //方块
        translationBuilder.add(ModBlocks.STEEL_BLOCK,                   "鋼塊");

        translationBuilder.add(ModBlocks.STONE_WALL,                    "石墻");
        translationBuilder.add(ModBlocks.POLISHED_GRANITE_WALL,         "拋光花崗岩墻");
        translationBuilder.add(ModBlocks.POLISHED_DIORITE_WALL,         "拋光閃長岩墻");
        translationBuilder.add(ModBlocks.POLISHED_ANDESITE_WALL,        "拋光安山岩墻");
        translationBuilder.add(ModBlocks.SMOOTH_SANDSTONE_WALL,         "平滑砂岩墻");
        translationBuilder.add(ModBlocks.SMOOTH_RED_SANDSTONE_WALL,     "平滑红砂岩墻");
        translationBuilder.add(ModBlocks.PRISMARINE_BRICK_WALL,         "海磷石磚墻");
        translationBuilder.add(ModBlocks.DARK_PRISMARINE_WALL,          "暗海磷石墻");
        translationBuilder.add(ModBlocks.SMOOTH_STONE_WALL,             "平滑石頭墻");
        translationBuilder.add(ModBlocks.SMOOTH_STONE_STAIRS,           "平滑石頭半磚");
        translationBuilder.add(ModBlocks.BASALT_WALL,                   "玄武岩墻");
        translationBuilder.add(ModBlocks.BASALT_STAIRS,                 "玄武岩樓梯");
        translationBuilder.add(ModBlocks.BASALT_SLAB,                   "玄武岩半磚");
        translationBuilder.add(ModBlocks.SMOOTH_BASALT_WALL,            "平滑玄武岩墻");
        translationBuilder.add(ModBlocks.SMOOTH_BASALT_STAIRS,          "平滑玄武岩樓梯");
        translationBuilder.add(ModBlocks.SMOOTH_BASALT_SLAB,            "平滑玄武岩半磚");
        translationBuilder.add(ModBlocks.POLISHED_BASALT_WALL,          "拋光玄武岩墻");
        translationBuilder.add(ModBlocks.POLISHED_BASALT_STAIRS,        "拋光玄武岩樓梯");
        translationBuilder.add(ModBlocks.POLISHED_BASALT_SLAB,          "拋光玄武岩半磚");
        translationBuilder.add(ModBlocks.DIRT_WALL,                     "泥土墻");
        translationBuilder.add(ModBlocks.DIRT_STAIRS,                   "泥土樓梯");
        translationBuilder.add(ModBlocks.DIRT_SLAB,                     "泥土半磚");
        translationBuilder.add(ModBlocks.MUD_WALL,                      "泥墻");
        translationBuilder.add(ModBlocks.MUD_STAIRS,                    "泥樓梯");
        translationBuilder.add(ModBlocks.MUD_SLAB,                      "泥半磚");
        translationBuilder.add(ModBlocks.CLAY_WALL,                     "黏土墻");
        translationBuilder.add(ModBlocks.CLAY_STAIRS,                   "黏土樓梯");
        translationBuilder.add(ModBlocks.CLAY_SLAB,                     "黏土半磚");
        translationBuilder.add(ModBlocks.CALCITE_WALL,                  "方解石墻");
        translationBuilder.add(ModBlocks.CALCITE_STAIRS,                "方解石樓梯");
        translationBuilder.add(ModBlocks.CALCITE_SLAB,                  "方解石半磚");
        translationBuilder.add(ModBlocks.NETHERRACK_WALL,               "地獄石墻");
        translationBuilder.add(ModBlocks.NETHERRACK_STAIRS,             "地獄石樓梯");
        translationBuilder.add(ModBlocks.NETHERRACK_SLAB,               "地獄石半磚");
        translationBuilder.add(ModBlocks.OBSIDIAN_WALL,                 "黑曜石墻");
        translationBuilder.add(ModBlocks.OBSIDIAN_STAIRS,               "黑曜石樓梯");
        translationBuilder.add(ModBlocks.OBSIDIAN_SLAB,                 "黑曜石半磚");
        translationBuilder.add(ModBlocks.CRYING_OBSIDIAN_WALL,          "哭曜石墻");
        translationBuilder.add(ModBlocks.CRYING_OBSIDIAN_STAIRS,        "哭曜石樓梯");
        translationBuilder.add(ModBlocks.CRYING_OBSIDIAN_SLAB,          "哭曜石半磚");
        translationBuilder.add(ModBlocks.PURPUR_WALL,                   "紫珀墙");
        translationBuilder.add(ModBlocks.END_STONE_WALL,                "終界石墻");
        translationBuilder.add(ModBlocks.END_STONE_STAIRS,              "終界石樓梯");
        translationBuilder.add(ModBlocks.END_STONE_SLAB,                "終界石半磚");
        translationBuilder.add(ModBlocks.QUARTZ_WALL,                   "石英墻");
        translationBuilder.add(ModBlocks.SMOOTH_QUARTZ_WALL,            "平滑石英墻");
        translationBuilder.add(ModBlocks.AMETHYST_WALL,                 "紫水晶墻");
        translationBuilder.add(ModBlocks.AMETHYST_STAIRS,               "紫水晶樓梯");
        translationBuilder.add(ModBlocks.AMETHYST_SLAB,                 "紫水晶半磚");
        translationBuilder.add(ModBlocks.GLOWSTONE_WALL,                "熒光石墻");
        translationBuilder.add(ModBlocks.GLOWSTONE_STAIRS,              "熒光石樓梯");
        translationBuilder.add(ModBlocks.GLOWSTONE_SLAB,                "熒光石半磚");
        translationBuilder.add(ModBlocks.ICE_WALL,                      "冰墻");
        translationBuilder.add(ModBlocks.ICE_STAIRS,                    "冰樓梯");
        translationBuilder.add(ModBlocks.ICE_SLAB,                      "冰半磚");
        translationBuilder.add(ModBlocks.PACKED_ICE_WALL,               "冰磚墻");
        translationBuilder.add(ModBlocks.PACKED_ICE_STAIRS,             "冰磚樓梯");
        translationBuilder.add(ModBlocks.PACKED_ICE_SLAB,               "冰磚半磚");
        translationBuilder.add(ModBlocks.BLUE_ICE_WALL,                 "藍冰墻");
        translationBuilder.add(ModBlocks.BLUE_ICE_STAIRS,               "藍冰樓梯");
        translationBuilder.add(ModBlocks.BLUE_ICE_SLAB,                 "藍冰半磚");

        translationBuilder.add(ModBlocks.WHITE_CONCRETE_WALL,           "白色混凝土墻");
        translationBuilder.add(ModBlocks.WHITE_CONCRETE_STAIRS,         "白色混凝土樓梯");
        translationBuilder.add(ModBlocks.WHITE_CONCRETE_SLAB,           "白色混凝土半磚");
        translationBuilder.add(ModBlocks.LIGHT_GRAY_CONCRETE_WALL,      "淺灰色混凝土墻");
        translationBuilder.add(ModBlocks.LIGHT_GRAY_CONCRETE_STAIRS,    "淺灰色混凝土樓梯");
        translationBuilder.add(ModBlocks.LIGHT_GRAY_CONCRETE_SLAB,      "淺灰色混凝土半磚");
        translationBuilder.add(ModBlocks.GRAY_CONCRETE_WALL,            "灰色混凝土墻");
        translationBuilder.add(ModBlocks.GRAY_CONCRETE_STAIRS,          "灰色混凝土樓梯");
        translationBuilder.add(ModBlocks.GRAY_CONCRETE_SLAB,            "灰色混凝土半磚");
        translationBuilder.add(ModBlocks.BLACK_CONCRETE_WALL,           "黑色混凝土墻");
        translationBuilder.add(ModBlocks.BLACK_CONCRETE_STAIRS,         "黑色混凝土樓梯");
        translationBuilder.add(ModBlocks.BLACK_CONCRETE_SLAB,           "黑色混凝土半磚");
        translationBuilder.add(ModBlocks.BROWN_CONCRETE_WALL,           "啡色混凝土墻");
        translationBuilder.add(ModBlocks.BROWN_CONCRETE_STAIRS,         "啡色混凝土樓梯");
        translationBuilder.add(ModBlocks.BROWN_CONCRETE_SLAB,           "啡色混凝土半磚");
        translationBuilder.add(ModBlocks.RED_CONCRETE_WALL,             "紅色混凝土墻");
        translationBuilder.add(ModBlocks.RED_CONCRETE_STAIRS,           "紅色混凝土樓梯");
        translationBuilder.add(ModBlocks.RED_CONCRETE_SLAB,             "紅色混凝土半磚");
        translationBuilder.add(ModBlocks.ORANGE_CONCRETE_WALL,          "橙色混凝土墻");
        translationBuilder.add(ModBlocks.ORANGE_CONCRETE_STAIRS,        "橙色混凝土樓梯");
        translationBuilder.add(ModBlocks.ORANGE_CONCRETE_SLAB,          "橙色混凝土半磚");
        translationBuilder.add(ModBlocks.YELLOW_CONCRETE_WALL,          "黃色混凝土墻");
        translationBuilder.add(ModBlocks.YELLOW_CONCRETE_STAIRS,        "黃色混凝土樓梯");
        translationBuilder.add(ModBlocks.YELLOW_CONCRETE_SLAB,          "黃色混凝土半磚");
        translationBuilder.add(ModBlocks.LIME_CONCRETE_WALL,            "淺綠色混凝土墻");
        translationBuilder.add(ModBlocks.LIME_CONCRETE_STAIRS,          "淺綠色混凝土樓梯");
        translationBuilder.add(ModBlocks.LIME_CONCRETE_SLAB,            "淺綠色混凝土半磚");
        translationBuilder.add(ModBlocks.GREEN_CONCRETE_WALL,           "綠色混凝土墻");
        translationBuilder.add(ModBlocks.GREEN_CONCRETE_STAIRS,         "綠色混凝土樓梯");
        translationBuilder.add(ModBlocks.GREEN_CONCRETE_SLAB,           "綠色混凝土半磚");
        translationBuilder.add(ModBlocks.CYAN_CONCRETE_WALL,            "青藍色混凝土墻");
        translationBuilder.add(ModBlocks.CYAN_CONCRETE_STAIRS,          "青藍色混凝土樓梯");
        translationBuilder.add(ModBlocks.CYAN_CONCRETE_SLAB,            "青藍色混凝土搬磚");
        translationBuilder.add(ModBlocks.LIGHT_BLUE_CONCRETE_WALL,      "淺藍色混凝土墻");
        translationBuilder.add(ModBlocks.LIGHT_BLUE_CONCRETE_STAIRS,    "淺藍色混凝土樓梯");
        translationBuilder.add(ModBlocks.LIGHT_BLUE_CONCRETE_SLAB,      "淺藍色混凝土半磚");
        translationBuilder.add(ModBlocks.BLUE_CONCRETE_WALL,            "藍色混凝土墻");
        translationBuilder.add(ModBlocks.BLUE_CONCRETE_STAIRS,          "藍色混凝土樓梯");
        translationBuilder.add(ModBlocks.BLUE_CONCRETE_SLAB,            "藍色混凝土半磚");
        translationBuilder.add(ModBlocks.PURPLE_CONCRETE_WALL,          "紫色混凝土墻");
        translationBuilder.add(ModBlocks.PURPLE_CONCRETE_STAIRS,        "紫色混凝土樓梯");
        translationBuilder.add(ModBlocks.PURPLE_CONCRETE_SLAB,          "紫色混凝土半磚");
        translationBuilder.add(ModBlocks.MAGENTA_CONCRETE_WALL,         "紫紅色混凝土墻");
        translationBuilder.add(ModBlocks.MAGENTA_CONCRETE_STAIRS,       "紫紅色混凝土樓梯");
        translationBuilder.add(ModBlocks.MAGENTA_CONCRETE_SLAB,         "紫紅色混凝土半磚");
        translationBuilder.add(ModBlocks.PINK_CONCRETE_WALL,            "粉紅色混凝土墻");
        translationBuilder.add(ModBlocks.PINK_CONCRETE_STAIRS,          "粉紅色混凝土樓梯");
        translationBuilder.add(ModBlocks.PINK_CONCRETE_SLAB,            "粉紅色混凝土半磚");

        translationBuilder.add(ModBlocks.TERRACOTTA_WALL,               "陶瓦墻");
        translationBuilder.add(ModBlocks.TERRACOTTA_STAIRS,             "陶瓦樓梯");
        translationBuilder.add(ModBlocks.TERRACOTTA_SLAB,               "陶瓦半磚");
        translationBuilder.add(ModBlocks.WHITE_TERRACOTTA_WALL,         "白色陶瓦墻");
        translationBuilder.add(ModBlocks.WHITE_TERRACOTTA_STAIRS,       "白色陶瓦樓梯");
        translationBuilder.add(ModBlocks.WHITE_TERRACOTTA_SLAB,         "白色陶瓦半磚");
        translationBuilder.add(ModBlocks.LIGHT_GRAY_TERRACOTTA_WALL,    "淺灰色陶瓦墻");
        translationBuilder.add(ModBlocks.LIGHT_GRAY_TERRACOTTA_STAIRS,  "淺灰色陶瓦樓梯");
        translationBuilder.add(ModBlocks.LIGHT_GRAY_TERRACOTTA_SLAB,    "淺灰色陶瓦半磚");
        translationBuilder.add(ModBlocks.GRAY_TERRACOTTA_WALL,          "灰色陶瓦墻");
        translationBuilder.add(ModBlocks.GRAY_TERRACOTTA_STAIRS,        "灰色陶瓦樓梯");
        translationBuilder.add(ModBlocks.GRAY_TERRACOTTA_SLAB,          "灰色陶瓦半磚");
        translationBuilder.add(ModBlocks.BLACK_TERRACOTTA_WALL,         "黑色陶瓦墻");
        translationBuilder.add(ModBlocks.BLACK_TERRACOTTA_STAIRS,       "黑色陶瓦樓梯");
        translationBuilder.add(ModBlocks.BLACK_TERRACOTTA_SLAB,         "黑色陶瓦半磚");
        translationBuilder.add(ModBlocks.BROWN_TERRACOTTA_WALL,         "啡色陶瓦墻");
        translationBuilder.add(ModBlocks.BROWN_TERRACOTTA_STAIRS,       "啡色陶瓦樓梯");
        translationBuilder.add(ModBlocks.BROWN_TERRACOTTA_SLAB,         "啡色陶瓦半磚");
        translationBuilder.add(ModBlocks.RED_TERRACOTTA_WALL,           "紅色陶瓦墻");
        translationBuilder.add(ModBlocks.RED_TERRACOTTA_STAIRS,         "紅色陶瓦樓梯");
        translationBuilder.add(ModBlocks.RED_TERRACOTTA_SLAB,           "紅色陶瓦半磚");
        translationBuilder.add(ModBlocks.ORANGE_TERRACOTTA_WALL,        "橙色陶瓦墻");
        translationBuilder.add(ModBlocks.ORANGE_TERRACOTTA_STAIRS,      "橙色陶瓦樓梯");
        translationBuilder.add(ModBlocks.ORANGE_TERRACOTTA_SLAB,        "橙色陶瓦半磚");
        translationBuilder.add(ModBlocks.YELLOW_TERRACOTTA_WALL,        "黃色陶瓦墻");
        translationBuilder.add(ModBlocks.YELLOW_TERRACOTTA_STAIRS,      "黃色陶瓦樓梯");
        translationBuilder.add(ModBlocks.YELLOW_TERRACOTTA_SLAB,        "黃色陶瓦半磚");
        translationBuilder.add(ModBlocks.LIME_TERRACOTTA_WALL,          "淺綠色陶瓦墻");
        translationBuilder.add(ModBlocks.LIME_TERRACOTTA_STAIRS,        "淺綠色陶瓦樓梯");
        translationBuilder.add(ModBlocks.LIME_TERRACOTTA_SLAB,          "淺綠色陶瓦半磚");
        translationBuilder.add(ModBlocks.GREEN_TERRACOTTA_WALL,         "綠色陶瓦墻");
        translationBuilder.add(ModBlocks.GREEN_TERRACOTTA_STAIRS,       "綠色陶瓦樓梯");
        translationBuilder.add(ModBlocks.GREEN_TERRACOTTA_SLAB,         "綠色陶瓦半磚");
        translationBuilder.add(ModBlocks.CYAN_TERRACOTTA_WALL,          "青藍色陶瓦墻");
        translationBuilder.add(ModBlocks.CYAN_TERRACOTTA_STAIRS,        "青藍色陶瓦樓梯");
        translationBuilder.add(ModBlocks.CYAN_TERRACOTTA_SLAB,          "青藍色陶瓦搬磚");
        translationBuilder.add(ModBlocks.LIGHT_BLUE_TERRACOTTA_WALL,    "淺藍色陶瓦墻");
        translationBuilder.add(ModBlocks.LIGHT_BLUE_TERRACOTTA_STAIRS,  "淺藍色陶瓦樓梯");
        translationBuilder.add(ModBlocks.LIGHT_BLUE_TERRACOTTA_SLAB,    "淺藍色陶瓦半磚");
        translationBuilder.add(ModBlocks.BLUE_TERRACOTTA_WALL,          "藍色陶瓦墻");
        translationBuilder.add(ModBlocks.BLUE_TERRACOTTA_STAIRS,        "藍色陶瓦樓梯");
        translationBuilder.add(ModBlocks.BLUE_TERRACOTTA_SLAB,          "藍色陶瓦半磚");
        translationBuilder.add(ModBlocks.PURPLE_TERRACOTTA_WALL,        "紫色陶瓦墻");
        translationBuilder.add(ModBlocks.PURPLE_TERRACOTTA_STAIRS,      "紫色陶瓦樓梯");
        translationBuilder.add(ModBlocks.PURPLE_TERRACOTTA_SLAB,        "紫色陶瓦半磚");
        translationBuilder.add(ModBlocks.MAGENTA_TERRACOTTA_WALL,       "紫紅色陶瓦墻");
        translationBuilder.add(ModBlocks.MAGENTA_TERRACOTTA_STAIRS,     "紫紅色陶瓦樓梯");
        translationBuilder.add(ModBlocks.MAGENTA_TERRACOTTA_SLAB,       "紫紅色陶瓦半磚");
        translationBuilder.add(ModBlocks.PINK_TERRACOTTA_WALL,          "粉紅色陶瓦墻");
        translationBuilder.add(ModBlocks.PINK_TERRACOTTA_STAIRS,        "粉紅色陶瓦樓梯");
        translationBuilder.add(ModBlocks.PINK_TERRACOTTA_SLAB,          "粉紅色陶瓦半磚");

        //文本
        translationBuilder.add("diamond_shards_upgrade_applies_to",         "鋼制工具");
        translationBuilder.add("diamond_shards_upgrade_ingredients",        "碎鑽石");
        translationBuilder.add("diamond_shards_upgrade",                    "鑽石升級（流嘢）");
        translationBuilder.add("diamond_shards_upgrade_base_slot",          "擺入鋼斧或鋼鎬");
        translationBuilder.add("diamond_shards_upgrade_additions_slot",     "擺入任意碎鑽石");

        translationBuilder.add("itemGroup.vanilla_addition",                "原版升級");
        translationBuilder.add("itemGroup.building_addition",               "建筑升級");
    }


}
