package com.yipkei.vanilladdition.data.lang;

import com.yipkei.vanilladdition.init.ModBlocks;
import com.yipkei.vanilladdition.init.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModZhCnLangProvider extends FabricLanguageProvider {
    public ModZhCnLangProvider(FabricDataOutput dataGenerator, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup){
        super(dataGenerator,"zh_cn",registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.STEEL_AXE,                      "钢斧");
        translationBuilder.add(ModItems.STEEL_HOE,                      "钢铲");
        translationBuilder.add(ModItems.STEEL_SWORD,                    "钢剑");
        translationBuilder.add(ModItems.STEEL_PICKAXE,                  "钢镐");
        translationBuilder.add(ModItems.STEEL_SHOVEL,                   "钢锄");
        translationBuilder.add(ModItems.STEEL_INGOT,                    "钢锭");
        translationBuilder.add(ModItems.STONE_HAMMER,                   "石锤");
        translationBuilder.add(ModItems.IRON_HAMMER,                    "铁锤");
        translationBuilder.add(ModItems.DIAMOND_HAMMER,                 "钻锤");
        translationBuilder.add(ModItems.DIAMOND_SHARD,                  "碎钻");
        translationBuilder.add(ModItems.DIAMOND_SHARDS_UPGRADED_SMITHING_TEMPLATE,"钻石升级模板（伪）");
        translationBuilder.add(ModItems.DIAMOND_UPGRADED_AXE,           "钻斧（伪）");
        translationBuilder.add(ModItems.DIAMOND_UPGRADED_PICKAXE,       "钻镐（伪）");
        translationBuilder.add(ModItems.ROASTED_ROTTEN_FLESH,           "辣条");

        //方块
        translationBuilder.add(ModBlocks.STEEL_BLOCK,                   "钢块");

        translationBuilder.add(ModBlocks.STONE_WALL,                    "石墙");
        translationBuilder.add(ModBlocks.POLISHED_GRANITE_WALL,         "磨制花岗岩墙");
        translationBuilder.add(ModBlocks.POLISHED_DIORITE_WALL,         "磨制闪长岩墙");
        translationBuilder.add(ModBlocks.POLISHED_ANDESITE_WALL,        "磨制安山岩墙");
        translationBuilder.add(ModBlocks.SMOOTH_SANDSTONE_WALL,         "平滑砂岩墙");
        translationBuilder.add(ModBlocks.SMOOTH_RED_SANDSTONE_WALL,     "平滑红砂岩墙");
        translationBuilder.add(ModBlocks.PRISMARINE_BRICK_WALL,         "海晶石砖墙");
        translationBuilder.add(ModBlocks.DARK_PRISMARINE_WALL,          "暗海晶石墙");
        translationBuilder.add(ModBlocks.SMOOTH_STONE_WALL,             "平滑石头墙");
        translationBuilder.add(ModBlocks.SMOOTH_STONE_STAIRS,           "平滑石头楼梯");
        translationBuilder.add(ModBlocks.BASALT_WALL,                   "玄武岩墙");
        translationBuilder.add(ModBlocks.BASALT_STAIRS,                 "玄武岩楼梯");
        translationBuilder.add(ModBlocks.BASALT_SLAB,                   "玄武岩半砖");
        translationBuilder.add(ModBlocks.SMOOTH_BASALT_WALL,            "平滑玄武岩墙");
        translationBuilder.add(ModBlocks.SMOOTH_BASALT_STAIRS,          "平滑玄武岩楼梯");
        translationBuilder.add(ModBlocks.SMOOTH_BASALT_SLAB,            "平滑玄武岩半砖");
        translationBuilder.add(ModBlocks.POLISHED_BASALT_WALL,          "磨制玄武岩墙");
        translationBuilder.add(ModBlocks.POLISHED_BASALT_STAIRS,        "磨制玄武岩楼梯");
        translationBuilder.add(ModBlocks.POLISHED_BASALT_SLAB,          "磨制玄武岩半砖");
        translationBuilder.add(ModBlocks.DIRT_WALL,                     "泥土墙");
        translationBuilder.add(ModBlocks.DIRT_STAIRS,                   "泥土楼梯");
        translationBuilder.add(ModBlocks.DIRT_SLAB,                     "泥土半砖");
        translationBuilder.add(ModBlocks.MUD_WALL,                      "泥墙");
        translationBuilder.add(ModBlocks.MUD_STAIRS,                    "泥楼梯");
        translationBuilder.add(ModBlocks.MUD_SLAB,                      "泥半砖");
        translationBuilder.add(ModBlocks.CLAY_WALL,                     "黏土墙");
        translationBuilder.add(ModBlocks.CLAY_STAIRS,                   "黏土楼梯");
        translationBuilder.add(ModBlocks.CLAY_SLAB,                     "黏土半砖");
        translationBuilder.add(ModBlocks.CALCITE_WALL,                  "方解石墙");
        translationBuilder.add(ModBlocks.CALCITE_STAIRS,                "方解石楼梯");
        translationBuilder.add(ModBlocks.CALCITE_SLAB,                  "方解石半砖");
        translationBuilder.add(ModBlocks.NETHERRACK_WALL,               "下界岩墙");
        translationBuilder.add(ModBlocks.NETHERRACK_STAIRS,             "下界岩楼梯");
        translationBuilder.add(ModBlocks.NETHERRACK_SLAB,               "下界岩半砖");
        translationBuilder.add(ModBlocks.OBSIDIAN_WALL,                 "黑曜石墙");
        translationBuilder.add(ModBlocks.OBSIDIAN_STAIRS,               "黑曜石楼梯");
        translationBuilder.add(ModBlocks.OBSIDIAN_SLAB,                 "黑曜石半砖");
        translationBuilder.add(ModBlocks.CRYING_OBSIDIAN_WALL,          "哭泣的黑曜石墙");
        translationBuilder.add(ModBlocks.CRYING_OBSIDIAN_STAIRS,        "哭泣的黑曜石楼梯");
        translationBuilder.add(ModBlocks.CRYING_OBSIDIAN_SLAB,          "哭泣的黑曜石半磚");
        translationBuilder.add(ModBlocks.PURPUR_WALL,                   "紫珀墙");
        translationBuilder.add(ModBlocks.END_STONE_WALL,                "末地石墙");
        translationBuilder.add(ModBlocks.END_STONE_STAIRS,              "末地石楼梯");
        translationBuilder.add(ModBlocks.END_STONE_SLAB,                "末地石半砖");
        translationBuilder.add(ModBlocks.QUARTZ_WALL,                   "石英墙");
        translationBuilder.add(ModBlocks.SMOOTH_QUARTZ_WALL,            "平滑石英墙");
        translationBuilder.add(ModBlocks.AMETHYST_WALL,                 "紫水晶墙");
        translationBuilder.add(ModBlocks.AMETHYST_STAIRS,               "紫水晶楼梯");
        translationBuilder.add(ModBlocks.AMETHYST_SLAB,                 "紫水晶半砖");
        translationBuilder.add(ModBlocks.GLOWSTONE_WALL,                "萤石墙");
        translationBuilder.add(ModBlocks.GLOWSTONE_STAIRS,              "萤石楼梯");
        translationBuilder.add(ModBlocks.GLOWSTONE_SLAB,                "萤石半砖");
        translationBuilder.add(ModBlocks.ICE_WALL,                      "冰墙");
        translationBuilder.add(ModBlocks.ICE_STAIRS,                    "冰楼梯");
        translationBuilder.add(ModBlocks.ICE_SLAB,                      "冰半砖");
        translationBuilder.add(ModBlocks.PACKED_ICE_WALL,               "浮冰墙");
        translationBuilder.add(ModBlocks.PACKED_ICE_STAIRS,             "浮冰楼梯");
        translationBuilder.add(ModBlocks.PACKED_ICE_SLAB,               "浮冰半砖");
        translationBuilder.add(ModBlocks.BLUE_ICE_WALL,                 "蓝冰墙");
        translationBuilder.add(ModBlocks.BLUE_ICE_STAIRS,               "蓝冰楼梯");
        translationBuilder.add(ModBlocks.BLUE_ICE_SLAB,                 "蓝冰半砖");

        translationBuilder.add(ModBlocks.WHITE_CONCRETE_WALL,           "白色混凝土墙");
        translationBuilder.add(ModBlocks.WHITE_CONCRETE_STAIRS,         "白色混凝土楼梯");
        translationBuilder.add(ModBlocks.WHITE_CONCRETE_SLAB,           "白色混凝土半砖");
        translationBuilder.add(ModBlocks.LIGHT_GRAY_CONCRETE_WALL,      "淡灰色混凝土墙");
        translationBuilder.add(ModBlocks.LIGHT_GRAY_CONCRETE_STAIRS,    "淡灰色混凝土楼梯");
        translationBuilder.add(ModBlocks.LIGHT_GRAY_CONCRETE_SLAB,      "淡灰色混凝土半砖");
        translationBuilder.add(ModBlocks.GRAY_CONCRETE_WALL,            "灰色混凝土墙");
        translationBuilder.add(ModBlocks.GRAY_CONCRETE_STAIRS,          "灰色混凝土楼梯");
        translationBuilder.add(ModBlocks.GRAY_CONCRETE_SLAB,            "灰色混凝土半砖");
        translationBuilder.add(ModBlocks.BLACK_CONCRETE_WALL,           "黑色混凝土墙");
        translationBuilder.add(ModBlocks.BLACK_CONCRETE_STAIRS,         "黑色混凝土楼梯");
        translationBuilder.add(ModBlocks.BLACK_CONCRETE_SLAB,           "黑色混凝土半砖");
        translationBuilder.add(ModBlocks.BROWN_CONCRETE_WALL,           "棕色混凝土墙");
        translationBuilder.add(ModBlocks.BROWN_CONCRETE_STAIRS,         "棕色混凝土楼梯");
        translationBuilder.add(ModBlocks.BROWN_CONCRETE_SLAB,           "棕色混凝土半砖");
        translationBuilder.add(ModBlocks.RED_CONCRETE_WALL,             "红色混凝土墙");
        translationBuilder.add(ModBlocks.RED_CONCRETE_STAIRS,           "红色混凝土楼梯");
        translationBuilder.add(ModBlocks.RED_CONCRETE_SLAB,             "红色混凝土半砖");
        translationBuilder.add(ModBlocks.ORANGE_CONCRETE_WALL,          "橙色混凝土墙");
        translationBuilder.add(ModBlocks.ORANGE_CONCRETE_STAIRS,        "橙色混凝土楼梯");
        translationBuilder.add(ModBlocks.ORANGE_CONCRETE_SLAB,          "橙色混凝土半砖");
        translationBuilder.add(ModBlocks.YELLOW_CONCRETE_WALL,          "黄色混凝土墙");
        translationBuilder.add(ModBlocks.YELLOW_CONCRETE_STAIRS,        "黄色混凝土楼梯");
        translationBuilder.add(ModBlocks.YELLOW_CONCRETE_SLAB,          "黄色混凝土半砖");
        translationBuilder.add(ModBlocks.LIME_CONCRETE_WALL,            "草绿色混凝土墙");
        translationBuilder.add(ModBlocks.LIME_CONCRETE_STAIRS,          "草绿色混凝土楼梯");
        translationBuilder.add(ModBlocks.LIME_CONCRETE_SLAB,            "草绿色混凝土半砖");
        translationBuilder.add(ModBlocks.GREEN_CONCRETE_WALL,           "绿色混凝土墙");
        translationBuilder.add(ModBlocks.GREEN_CONCRETE_STAIRS,         "绿色混凝土楼梯");
        translationBuilder.add(ModBlocks.GREEN_CONCRETE_SLAB,           "绿色混凝土半砖");
        translationBuilder.add(ModBlocks.CYAN_CONCRETE_WALL,            "青色混凝土墙");
        translationBuilder.add(ModBlocks.CYAN_CONCRETE_STAIRS,          "青色混凝土楼梯");
        translationBuilder.add(ModBlocks.CYAN_CONCRETE_SLAB,            "青色混凝土半砖");
        translationBuilder.add(ModBlocks.LIGHT_BLUE_CONCRETE_WALL,      "淡蓝色混凝土墙");
        translationBuilder.add(ModBlocks.LIGHT_BLUE_CONCRETE_STAIRS,    "淡蓝色混凝土楼梯");
        translationBuilder.add(ModBlocks.LIGHT_BLUE_CONCRETE_SLAB,      "淡蓝色混凝土半砖");
        translationBuilder.add(ModBlocks.BLUE_CONCRETE_WALL,            "蓝色混凝土墙");
        translationBuilder.add(ModBlocks.BLUE_CONCRETE_STAIRS,          "蓝色混凝土楼梯");
        translationBuilder.add(ModBlocks.BLUE_CONCRETE_SLAB,            "蓝色混凝土半砖");
        translationBuilder.add(ModBlocks.PURPLE_CONCRETE_WALL,          "紫色混凝土墙");
        translationBuilder.add(ModBlocks.PURPLE_CONCRETE_STAIRS,        "紫色混凝土楼梯");
        translationBuilder.add(ModBlocks.PURPLE_CONCRETE_SLAB,          "紫色混凝土半砖");
        translationBuilder.add(ModBlocks.MAGENTA_CONCRETE_WALL,         "品红色混凝土墙");
        translationBuilder.add(ModBlocks.MAGENTA_CONCRETE_STAIRS,       "品红色混凝土楼梯");
        translationBuilder.add(ModBlocks.MAGENTA_CONCRETE_SLAB,         "品红色混凝土半砖");
        translationBuilder.add(ModBlocks.PINK_CONCRETE_WALL,            "粉红色混凝土墙");
        translationBuilder.add(ModBlocks.PINK_CONCRETE_STAIRS,          "粉红色混凝土楼梯");
        translationBuilder.add(ModBlocks.PINK_CONCRETE_SLAB,            "粉红色混凝土半砖");

        translationBuilder.add(ModBlocks.TERRACOTTA_WALL,               "陶瓦墙");
        translationBuilder.add(ModBlocks.TERRACOTTA_STAIRS,             "陶瓦楼梯");
        translationBuilder.add(ModBlocks.TERRACOTTA_SLAB,               "陶瓦半砖");
        translationBuilder.add(ModBlocks.WHITE_TERRACOTTA_WALL,         "白色陶瓦墙");
        translationBuilder.add(ModBlocks.WHITE_TERRACOTTA_STAIRS,       "白色陶瓦楼梯");
        translationBuilder.add(ModBlocks.WHITE_TERRACOTTA_SLAB,         "白色陶瓦半砖");
        translationBuilder.add(ModBlocks.LIGHT_GRAY_TERRACOTTA_WALL,    "淡灰色陶瓦墙");
        translationBuilder.add(ModBlocks.LIGHT_GRAY_TERRACOTTA_STAIRS,  "淡灰色陶瓦楼梯");
        translationBuilder.add(ModBlocks.LIGHT_GRAY_TERRACOTTA_SLAB,    "淡灰色陶瓦半砖");
        translationBuilder.add(ModBlocks.GRAY_TERRACOTTA_WALL,          "灰色陶瓦墙");
        translationBuilder.add(ModBlocks.GRAY_TERRACOTTA_STAIRS,        "灰色陶瓦楼梯");
        translationBuilder.add(ModBlocks.GRAY_TERRACOTTA_SLAB,          "灰色陶瓦半砖");
        translationBuilder.add(ModBlocks.BLACK_TERRACOTTA_WALL,         "黑色陶瓦墙");
        translationBuilder.add(ModBlocks.BLACK_TERRACOTTA_STAIRS,       "黑色陶瓦楼梯");
        translationBuilder.add(ModBlocks.BLACK_TERRACOTTA_SLAB,         "黑色陶瓦半砖");
        translationBuilder.add(ModBlocks.BROWN_TERRACOTTA_WALL,         "棕色陶瓦墙");
        translationBuilder.add(ModBlocks.BROWN_TERRACOTTA_STAIRS,       "棕色陶瓦楼梯");
        translationBuilder.add(ModBlocks.BROWN_TERRACOTTA_SLAB,         "棕色陶瓦半砖");
        translationBuilder.add(ModBlocks.RED_TERRACOTTA_WALL,           "绿色陶瓦墙");
        translationBuilder.add(ModBlocks.RED_TERRACOTTA_STAIRS,         "绿色陶瓦楼梯");
        translationBuilder.add(ModBlocks.RED_TERRACOTTA_SLAB,           "绿色陶瓦半砖");
        translationBuilder.add(ModBlocks.ORANGE_TERRACOTTA_WALL,        "橙色陶瓦墙");
        translationBuilder.add(ModBlocks.ORANGE_TERRACOTTA_STAIRS,      "橙色陶瓦楼梯");
        translationBuilder.add(ModBlocks.ORANGE_TERRACOTTA_SLAB,        "橙色陶瓦半砖");
        translationBuilder.add(ModBlocks.YELLOW_TERRACOTTA_WALL,        "黄色陶瓦墙");
        translationBuilder.add(ModBlocks.YELLOW_TERRACOTTA_STAIRS,      "黄色陶瓦楼梯");
        translationBuilder.add(ModBlocks.YELLOW_TERRACOTTA_SLAB,        "黄色陶瓦半砖");
        translationBuilder.add(ModBlocks.LIME_TERRACOTTA_WALL,          "草绿色陶瓦墙");
        translationBuilder.add(ModBlocks.LIME_TERRACOTTA_STAIRS,        "草绿色陶瓦楼梯");
        translationBuilder.add(ModBlocks.LIME_TERRACOTTA_SLAB,          "草绿色陶瓦半砖");
        translationBuilder.add(ModBlocks.GREEN_TERRACOTTA_WALL,         "绿色陶瓦墙");
        translationBuilder.add(ModBlocks.GREEN_TERRACOTTA_STAIRS,       "绿色陶瓦楼梯");
        translationBuilder.add(ModBlocks.GREEN_TERRACOTTA_SLAB,         "绿色陶瓦半砖");
        translationBuilder.add(ModBlocks.CYAN_TERRACOTTA_WALL,          "青色陶瓦墙");
        translationBuilder.add(ModBlocks.CYAN_TERRACOTTA_STAIRS,        "青色陶瓦楼梯");
        translationBuilder.add(ModBlocks.CYAN_TERRACOTTA_SLAB,          "青色陶瓦半砖");
        translationBuilder.add(ModBlocks.LIGHT_BLUE_TERRACOTTA_WALL,    "淡蓝色陶瓦墙");
        translationBuilder.add(ModBlocks.LIGHT_BLUE_TERRACOTTA_STAIRS,  "淡蓝色陶瓦楼梯");
        translationBuilder.add(ModBlocks.LIGHT_BLUE_TERRACOTTA_SLAB,    "淡蓝色陶瓦半砖");
        translationBuilder.add(ModBlocks.BLUE_TERRACOTTA_WALL,          "蓝色陶瓦墙");
        translationBuilder.add(ModBlocks.BLUE_TERRACOTTA_STAIRS,        "蓝色陶瓦楼梯");
        translationBuilder.add(ModBlocks.BLUE_TERRACOTTA_SLAB,          "蓝色陶瓦半砖");
        translationBuilder.add(ModBlocks.PURPLE_TERRACOTTA_WALL,        "紫色陶瓦墙");
        translationBuilder.add(ModBlocks.PURPLE_TERRACOTTA_STAIRS,      "紫色陶瓦楼梯");
        translationBuilder.add(ModBlocks.PURPLE_TERRACOTTA_SLAB,        "紫色陶瓦半砖");
        translationBuilder.add(ModBlocks.MAGENTA_TERRACOTTA_WALL,       "品红色陶瓦墙");
        translationBuilder.add(ModBlocks.MAGENTA_TERRACOTTA_STAIRS,     "品红色陶瓦楼梯");
        translationBuilder.add(ModBlocks.MAGENTA_TERRACOTTA_SLAB,       "品红色陶瓦半砖");
        translationBuilder.add(ModBlocks.PINK_TERRACOTTA_WALL,          "粉红色陶瓦墙");
        translationBuilder.add(ModBlocks.PINK_TERRACOTTA_STAIRS,        "粉红色陶瓦楼梯");
        translationBuilder.add(ModBlocks.PINK_TERRACOTTA_SLAB,          "粉红色陶瓦半砖");

        //文本
        translationBuilder.add("diamond_shards_upgrade_applies_to",         "钢质工具");
        translationBuilder.add("diamond_shards_upgrade_ingredients",        "碎钻");
        translationBuilder.add("diamond_shards_upgrade",                    "钻石升级（伪）");
        translationBuilder.add("diamond_shards_upgrade_base_slot",          "置入钢斧或钢镐");
        translationBuilder.add("diamond_shards_upgrade_additions_slot",     "置入任意碎钻");

        translationBuilder.add("itemGroup.vanilla_addition",                "原版增强");
        translationBuilder.add("itemGroup.building_addition",               "建筑增强");
    }


}
