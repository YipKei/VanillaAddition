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
        translationBuilder.add(ModItems.GLASS_PICKAXE_PROTOTYPE,        "玻璃镐原坯");
        translationBuilder.add(ModItems.GLASS_PICKAXE,                  "玻璃镐");
        translationBuilder.add(ModItems.DESTROYER_PICKAXE,              "“破坏王”");
        translationBuilder.add(ModItems.DIAMOND_FLINT,                  "持久火石");
        translationBuilder.add(ModItems.STEEL_SHEARS,                   "钢剪");
        translationBuilder.add(ModItems.DEEP_DARK_FANTASY,              "黑暗深邃幻想");
        translationBuilder.add(ModItems.EXPLOSION_CREATOR,              "大炸逼制造者");
        translationBuilder.add(ModItems.NOTHING_TO_BE_AFRAID_OF,        "已经没有什么好害怕的了");

        //再生
        translationBuilder.add(ModItems.DIAMOND_SHARD_STACK,            "碎钻堆");
        translationBuilder.add(ModItems.PULSE_OF_THE_SEA,               "海洋脉搏");
        translationBuilder.add(ModItems.DRAGON_WING_MEMBRANE,           "龙翼膜");
        translationBuilder.add(ModItems.ANCIENT_TEAR,                   "远古之泪");
        translationBuilder.add(ModItems.DIAMOND_PROTOTYPE,              "钻石原坯");
        translationBuilder.add(ModItems.ANCIENT_PROTOTYPE,              "远古原坯");
        translationBuilder.add(ModItems.SUSPICIOUS_PROTOTYPE,           "可疑的原坯");
        translationBuilder.add(ModItems.HEAVY_CORE_PROTOTYPE,           "沉重核心原坯");
        translationBuilder.add(ModItems.CONDUIT_SHARD,                  "潮涌碎片");
        translationBuilder.add(ModItems.ELYTRA_PROTOTYPE,               "鞘翅原坯");

        translationBuilder.add(ModItems.PRESSURE_CRAFTING_TEMPLATE,         "压力合成模板");
        translationBuilder.add(ModItems.NETHER_SMITHING_TEMPLATE,           "下界锻造模板");
        translationBuilder.add(ModItems.NETHER_SMITHING_TEMPLATE_PRO,       "高级下界锻造模板");
        translationBuilder.add(ModItems.ELYTRA_COPY_TEMPLATE,               "鞘翅复制模板");
        translationBuilder.add(ModItems.ENCHANTED_GOLDEN_APPLE_TEMPLATE,    "附魔金苹果模板");
        translationBuilder.add(ModItems.HEAD_COPY_TEMPLATE,                 "“分头行动”");
        translationBuilder.add(ModItems.TOTEM_OF_UNDYING_COPY_TEMPLATE,     "不死图腾仿制模板");

        translationBuilder.add(ModItems.ANGLER_POTTERY_SHERD_BLUEPRINT,     "垂钓纹样拓片");
        translationBuilder.add(ModItems.ARCHER_POTTERY_SHERD_BLUEPRINT,     "弓箭纹样拓片");
        translationBuilder.add(ModItems.ARMS_UP_POTTERY_SHERD_BLUEPRINT,    "举臂纹样拓片");
        translationBuilder.add(ModItems.BLADE_POTTERY_SHERD_BLUEPRINT,      "利刃纹样拓片");
        translationBuilder.add(ModItems.BREWER_POTTERY_SHERD_BLUEPRINT,     "佳酿纹样拓片");
        translationBuilder.add(ModItems.BURN_POTTERY_SHERD_BLUEPRINT,       "烈焰纹样拓片");
        translationBuilder.add(ModItems.DANGER_POTTERY_SHERD_BLUEPRINT,     "危机纹样拓片");
        translationBuilder.add(ModItems.EXPLORER_POTTERY_SHERD_BLUEPRINT,   "探险纹样拓片");
        translationBuilder.add(ModItems.FRIEND_POTTERY_SHERD_BLUEPRINT,     "挚友纹样拓片");
        translationBuilder.add(ModItems.HEART_POTTERY_SHERD_BLUEPRINT,      "爱心纹样拓片");
        translationBuilder.add(ModItems.HEARTBREAK_POTTERY_SHERD_BLUEPRINT, "心碎纹样拓片");
        translationBuilder.add(ModItems.HOWL_POTTERY_SHERD_BLUEPRINT,       "狼嚎纹样拓片");
        translationBuilder.add(ModItems.MINER_POTTERY_SHERD_BLUEPRINT,      "采矿纹样拓片");
        translationBuilder.add(ModItems.MOURNER_POTTERY_SHERD_BLUEPRINT,    "悲恸纹样拓片");
        translationBuilder.add(ModItems.PLENTY_POTTERY_SHERD_BLUEPRINT,     "富饶纹样拓片");
        translationBuilder.add(ModItems.PRIZE_POTTERY_SHERD_BLUEPRINT,      "珍宝纹样拓片");
        translationBuilder.add(ModItems.SHEAF_POTTERY_SHERD_BLUEPRINT,      "麦捆纹样拓片");
        translationBuilder.add(ModItems.SHELTER_POTTERY_SHERD_BLUEPRINT,    "树荫纹样拓片");
        translationBuilder.add(ModItems.SKULL_POTTERY_SHERD_BLUEPRINT,      "头颅纹样拓片");
        translationBuilder.add(ModItems.SNORT_POTTERY_SHERD_BLUEPRINT,      "嗅探纹样拓片");
        translationBuilder.add(ModItems.FLOW_POTTERY_SHERD_BLUEPRINT,       "涡流纹样拓片");
        translationBuilder.add(ModItems.GUSTER_POTTERY_SHERD_BLUEPRINT,     "旋风纹样拓片");
        translationBuilder.add(ModItems.SCRAPE_POTTERY_SHERD_BLUEPRINT,     "刮削纹样拓片");

        translationBuilder.add(ModItems.ANGLER_POTTERY_SHERD_PROTOTYPE,     "垂钓纹样陶坯");
        translationBuilder.add(ModItems.ARCHER_POTTERY_SHERD_PROTOTYPE,     "弓箭纹样陶坯");
        translationBuilder.add(ModItems.ARMS_UP_POTTERY_SHERD_PROTOTYPE,    "举臂纹样陶坯");
        translationBuilder.add(ModItems.BLADE_POTTERY_SHERD_PROTOTYPE,      "利刃纹样陶坯");
        translationBuilder.add(ModItems.BREWER_POTTERY_SHERD_PROTOTYPE,     "佳酿纹样陶坯");
        translationBuilder.add(ModItems.BURN_POTTERY_SHERD_PROTOTYPE,       "烈焰纹样陶坯");
        translationBuilder.add(ModItems.DANGER_POTTERY_SHERD_PROTOTYPE,     "危机纹样陶坯");
        translationBuilder.add(ModItems.EXPLORER_POTTERY_SHERD_PROTOTYPE,   "探险纹样陶坯");
        translationBuilder.add(ModItems.FRIEND_POTTERY_SHERD_PROTOTYPE,     "挚友纹样陶坯");
        translationBuilder.add(ModItems.HEART_POTTERY_SHERD_PROTOTYPE,      "爱心纹样陶坯");
        translationBuilder.add(ModItems.HEARTBREAK_POTTERY_SHERD_PROTOTYPE, "心碎纹样陶坯");
        translationBuilder.add(ModItems.HOWL_POTTERY_SHERD_PROTOTYPE,       "狼嚎纹样陶坯");
        translationBuilder.add(ModItems.MINER_POTTERY_SHERD_PROTOTYPE,      "采矿纹样陶坯");
        translationBuilder.add(ModItems.MOURNER_POTTERY_SHERD_PROTOTYPE,    "悲恸纹样陶坯");
        translationBuilder.add(ModItems.PLENTY_POTTERY_SHERD_PROTOTYPE,     "富饶纹样陶坯");
        translationBuilder.add(ModItems.PRIZE_POTTERY_SHERD_PROTOTYPE,      "珍宝纹样陶坯");
        translationBuilder.add(ModItems.SHEAF_POTTERY_SHERD_PROTOTYPE,      "麦捆纹样陶坯");
        translationBuilder.add(ModItems.SHELTER_POTTERY_SHERD_PROTOTYPE,    "树荫纹样陶坯");
        translationBuilder.add(ModItems.SKULL_POTTERY_SHERD_PROTOTYPE,      "头颅纹样陶坯");
        translationBuilder.add(ModItems.SNORT_POTTERY_SHERD_PROTOTYPE,      "嗅探纹样陶坯");
        translationBuilder.add(ModItems.FLOW_POTTERY_SHERD_PROTOTYPE,       "涡流纹样陶坯");
        translationBuilder.add(ModItems.GUSTER_POTTERY_SHERD_PROTOTYPE,     "旋风纹样陶坯");
        translationBuilder.add(ModItems.SCRAPE_POTTERY_SHERD_PROTOTYPE,     "刮削纹样陶坯");
        
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
        translationBuilder.add("diamond_shards_upgrade_applies_to",         "工具");
        translationBuilder.add("diamond_shards_upgrade_ingredients",        "碎钻");
        translationBuilder.add("diamond_shards_upgrade",                    "钻石升级（伪）");
        translationBuilder.add("diamond_shards_upgrade_base_slot",          "置入斧头或镐子");
        translationBuilder.add("diamond_shards_upgrade_additions_slot",     "置入任意碎钻");

        translationBuilder.add("pressure_crafting_applies_to",              "原型");
        translationBuilder.add("pressure_crafting_ingredients",             "强力爆炸物，如末影水晶");
        translationBuilder.add("pressure_crafting",                         "高爆压合");
        translationBuilder.add("pressure_crafting_base_slot",               "置入原料方块");
        translationBuilder.add("pressure_crafting_additions_slot",          "置入爆炸物");

        translationBuilder.add("nether_smithing_applies_to",                "稀有材料原型");
        translationBuilder.add("nether_smithing_ingredients",               "远古之泪");
        translationBuilder.add("nether_smithing",                           "“远哭”");
        translationBuilder.add("nether_smithing_base_slot",                 "置入材料原型");
        translationBuilder.add("nether_smithing_additions_slot",            "置入远古之泪");

        translationBuilder.add("nether_smithing_pro_applies_to",            "宝藏原型");
        translationBuilder.add("nether_smithing_pro_ingredients",           "引子");
        translationBuilder.add("nether_smithing_pro",                       "“远哭”");
        translationBuilder.add("nether_smithing_pro_base_slot",             "置入宝藏原型");
        translationBuilder.add("nether_smithing_pro_additions_slot",        "置入引子");

        translationBuilder.add("elytra_copy_applies_to",                    "鞘翅原型");
        translationBuilder.add("elytra_copy_ingredients",                   "鞍");
        translationBuilder.add("elytra_copy",                               "鞘翅的传承");
        translationBuilder.add("elytra_copy_base_slot",                     "置入鞘翅原型");
        translationBuilder.add("elytra_copy_additions_slot",                "置入鞍");

        translationBuilder.add("enchanted_golden_apple_copy_applies_to",    "金苹果");
        translationBuilder.add("enchanted_golden_apple_copy_ingredients",   "置入附魔之瓶");
        translationBuilder.add("enchanted_golden_apple_copy",               "为苹果附魔");
        translationBuilder.add("enchanted_golden_apple_copy_base_slot",     "置入金苹果");
        translationBuilder.add("enchanted_golden_apple_copy_additions_slot","置入附魔之瓶");

        translationBuilder.add("head_copy_applies_to",                      "旋风棒");
        translationBuilder.add("head_copy_ingredients",                     "龙息");
        translationBuilder.add("head_copy",                                 "丘比之爱");
        translationBuilder.add("head_copy_base_slot",                       "置入旋风棒");
        translationBuilder.add("head_copy_additions_slot",                  "置入龙息");

        translationBuilder.add("totem_of_undying_copy_applies_to",          "钻石");
        translationBuilder.add("totem_of_undying_copy_ingredients",         "青金石");
        translationBuilder.add("totem_of_undying_copy",                     "续命仪式");
        translationBuilder.add("totem_of_undying_copy_base_slot",           "置入钻石");
        translationBuilder.add("totem_of_undying_copy_additions_slot",      "置入青金石");

        translationBuilder.add("itemGroup.vanilla_addition",                "原版增强");
        translationBuilder.add("itemGroup.building_addition",               "建筑增强");
        translationBuilder.add("itemGroup.vanilla_renewable",               "再生增強");

        translationBuilder.add("custom_banner.bilibili", "哔哩哔哩干杯~");
        translationBuilder.add("RedstoneHead_","数字： ");
    }


}
