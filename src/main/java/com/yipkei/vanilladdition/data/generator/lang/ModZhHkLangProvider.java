package com.yipkei.vanilladdition.data.generator.lang;

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
        translationBuilder.add(ModItems.STEEL_HELMET,                   "鋼盔");
        translationBuilder.add(ModItems.STEEL_CHESTPLATE,               "鋼甲");
        translationBuilder.add(ModItems.STEEL_LEGGINGS,                 "鋼褲");
        translationBuilder.add(ModItems.STEEL_BOOTS,                    "鋼鞋");
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
        translationBuilder.add(ModItems.GLASS_PICKAXE_PROTOTYPE,        "玻璃鎬樣板");
        translationBuilder.add(ModItems.GLASS_PICKAXE,                  "玻璃鎬");
        translationBuilder.add(ModItems.DESTROYER_PICKAXE,              "“無敵破壞王”");
        translationBuilder.add(ModItems.DIAMOND_FLINT,                  "高級打火石");
        translationBuilder.add(ModItems.STEEL_SHEARS,                   "鋼鉸剪");
        translationBuilder.add(ModItems.DEEP_DARK_FANTASY,              "黑暗深邃幻想");
        translationBuilder.add(ModItems.EXPLOSION_CREATOR,              "呼叫超級大炸彈");
        translationBuilder.add(ModItems.NOTHING_TO_BE_AFRAID_OF,        "無可畏懼");

        //再生
        translationBuilder.add(ModItems.DIAMOND_SHARD_STACK,            "碎鑽石堆");
        translationBuilder.add(ModItems.PULSE_OF_THE_SEA,               "海之脈搏");
        translationBuilder.add(ModItems.DRAGON_WING_MEMBRANE,           "終界龍翼膜");
        translationBuilder.add(ModItems.ANCIENT_TEAR,                   "遠古之淚");
        translationBuilder.add(ModItems.DIAMOND_PROTOTYPE,              "鑽石樣板");
        translationBuilder.add(ModItems.ANCIENT_PROTOTYPE,              "遠古樣板");
        translationBuilder.add(ModItems.SUSPICIOUS_PROTOTYPE,           "古怪嘅樣板");
        translationBuilder.add(ModItems.HEAVY_CORE_PROTOTYPE,           "沉重核心樣板");
        translationBuilder.add(ModItems.CONDUIT_SHARD,                  "海靈碎片");
        translationBuilder.add(ModItems.ELYTRA_PROTOTYPE,               "鞘翅樣板");

        translationBuilder.add(ModItems.IRON_HORSE_ARMOR_BLUEPRINT, "鐵馬鎧圖紙");
        translationBuilder.add(ModItems.GOLDEN_HORSE_ARMOR_BLUEPRINT, "金馬鎧圖紙");
        translationBuilder.add(ModItems.DIAMOND_HORSE_ARMOR_BLUEPRINT, "鑽石馬鎧圖紙");

        translationBuilder.add(ModItems.PRESSURE_CRAFTING_TEMPLATE,         "高壓合成模板");
        translationBuilder.add(ModItems.NETHER_SMITHING_TEMPLATE,           "下界鍛造模板");
        translationBuilder.add(ModItems.NETHER_SMITHING_TEMPLATE_PRO,       "高級下界鍛造模板");
        translationBuilder.add(ModItems.ELYTRA_COPY_TEMPLATE,               "鞘翅複製模板");
        translationBuilder.add(ModItems.ENCHANTED_GOLDEN_APPLE_TEMPLATE,    "附魔金蘋果模板");
        translationBuilder.add(ModItems.HEAD_COPY_TEMPLATE,                 "「分頭行動」");
        translationBuilder.add(ModItems.TOTEM_OF_UNDYING_COPY_TEMPLATE,     "不死圖騰仿製模板");

        translationBuilder.add(ModItems.ANGLER_POTTERY_SHERD_BLUEPRINT,     "垂釣款圖紙");
        translationBuilder.add(ModItems.ARCHER_POTTERY_SHERD_BLUEPRINT,     "弓箭款圖紙");
        translationBuilder.add(ModItems.ARMS_UP_POTTERY_SHERD_BLUEPRINT,    "舉臂款圖紙");
        translationBuilder.add(ModItems.BLADE_POTTERY_SHERD_BLUEPRINT,      "利刃款圖紙");
        translationBuilder.add(ModItems.BREWER_POTTERY_SHERD_BLUEPRINT,     "佳釀款圖紙");
        translationBuilder.add(ModItems.BURN_POTTERY_SHERD_BLUEPRINT,       "烈焰款圖紙");
        translationBuilder.add(ModItems.DANGER_POTTERY_SHERD_BLUEPRINT,     "危機款圖紙");
        translationBuilder.add(ModItems.EXPLORER_POTTERY_SHERD_BLUEPRINT,   "探險款圖紙");
        translationBuilder.add(ModItems.FRIEND_POTTERY_SHERD_BLUEPRINT,     "朋友款圖紙");
        translationBuilder.add(ModItems.HEART_POTTERY_SHERD_BLUEPRINT,      "愛心款圖紙");
        translationBuilder.add(ModItems.HEARTBREAK_POTTERY_SHERD_BLUEPRINT, "心碎款圖紙");
        translationBuilder.add(ModItems.HOWL_POTTERY_SHERD_BLUEPRINT,       "狼嚎款圖紙");
        translationBuilder.add(ModItems.MINER_POTTERY_SHERD_BLUEPRINT,      "採礦款圖紙");
        translationBuilder.add(ModItems.MOURNER_POTTERY_SHERD_BLUEPRINT,    "悲慟款圖紙");
        translationBuilder.add(ModItems.PLENTY_POTTERY_SHERD_BLUEPRINT,     "富饒款圖紙");
        translationBuilder.add(ModItems.PRIZE_POTTERY_SHERD_BLUEPRINT,      "珍寶款圖紙");
        translationBuilder.add(ModItems.SHEAF_POTTERY_SHERD_BLUEPRINT,      "麥捆款圖紙");
        translationBuilder.add(ModItems.SHELTER_POTTERY_SHERD_BLUEPRINT,    "樹蔭款圖紙");
        translationBuilder.add(ModItems.SKULL_POTTERY_SHERD_BLUEPRINT,      "頭顱款圖紙");
        translationBuilder.add(ModItems.SNORT_POTTERY_SHERD_BLUEPRINT,      "嗅探款圖紙");
        translationBuilder.add(ModItems.FLOW_POTTERY_SHERD_BLUEPRINT,       "渦流款圖紙");
        translationBuilder.add(ModItems.GUSTER_POTTERY_SHERD_BLUEPRINT,     "旋風款圖紙");
        translationBuilder.add(ModItems.SCRAPE_POTTERY_SHERD_BLUEPRINT,     "刮削款圖紙");

        translationBuilder.add(ModItems.ANGLER_POTTERY_SHERD_PROTOTYPE,     "垂釣款生陶板");
        translationBuilder.add(ModItems.ARCHER_POTTERY_SHERD_PROTOTYPE,     "弓箭款生陶板");
        translationBuilder.add(ModItems.ARMS_UP_POTTERY_SHERD_PROTOTYPE,    "舉臂款生陶板");
        translationBuilder.add(ModItems.BLADE_POTTERY_SHERD_PROTOTYPE,      "利刃款生陶板");
        translationBuilder.add(ModItems.BREWER_POTTERY_SHERD_PROTOTYPE,     "佳釀款生陶板");
        translationBuilder.add(ModItems.BURN_POTTERY_SHERD_PROTOTYPE,       "烈焰款生陶板");
        translationBuilder.add(ModItems.DANGER_POTTERY_SHERD_PROTOTYPE,     "危機款生陶板");
        translationBuilder.add(ModItems.EXPLORER_POTTERY_SHERD_PROTOTYPE,   "探險款生陶板");
        translationBuilder.add(ModItems.FRIEND_POTTERY_SHERD_PROTOTYPE,     "朋友款生陶板");
        translationBuilder.add(ModItems.HEART_POTTERY_SHERD_PROTOTYPE,      "愛心款生陶板");
        translationBuilder.add(ModItems.HEARTBREAK_POTTERY_SHERD_PROTOTYPE, "心碎款生陶板");
        translationBuilder.add(ModItems.HOWL_POTTERY_SHERD_PROTOTYPE,       "狼嚎款生陶板");
        translationBuilder.add(ModItems.MINER_POTTERY_SHERD_PROTOTYPE,      "採礦款生陶板");
        translationBuilder.add(ModItems.MOURNER_POTTERY_SHERD_PROTOTYPE,    "悲慟款生陶板");
        translationBuilder.add(ModItems.PLENTY_POTTERY_SHERD_PROTOTYPE,     "富饒款生陶板");
        translationBuilder.add(ModItems.PRIZE_POTTERY_SHERD_PROTOTYPE,      "珍寶款生陶板");
        translationBuilder.add(ModItems.SHEAF_POTTERY_SHERD_PROTOTYPE,      "麥捆款生陶板");
        translationBuilder.add(ModItems.SHELTER_POTTERY_SHERD_PROTOTYPE,    "樹蔭款生陶板");
        translationBuilder.add(ModItems.SKULL_POTTERY_SHERD_PROTOTYPE,      "頭顱款生陶板");
        translationBuilder.add(ModItems.SNORT_POTTERY_SHERD_PROTOTYPE,      "嗅探款生陶板");
        translationBuilder.add(ModItems.FLOW_POTTERY_SHERD_PROTOTYPE,       "渦流款生陶板");
        translationBuilder.add(ModItems.GUSTER_POTTERY_SHERD_PROTOTYPE,     "旋風款生陶板");
        translationBuilder.add(ModItems.SCRAPE_POTTERY_SHERD_PROTOTYPE,     "刮削款生陶板");

        translationBuilder.add(ModItems.GLASS_DISC,                         "玻璃光碟");
        translationBuilder.add(ModItems.EMPTY_SHEET_MUSIC,                  "空樂譜");
        translationBuilder.add(ModItems.MUSIC_DISC_13_SHEET_MUSIC,          "樂譜《13》");
        translationBuilder.add(ModItems.MUSIC_DISC_CAT_SHEET_MUSIC,         "樂譜《Cat》");
        translationBuilder.add(ModItems.MUSIC_DISC_BLOCKS_SHEET_MUSIC,      "樂譜《Block》");
        translationBuilder.add(ModItems.MUSIC_DISC_CHIRP_SHEET_MUSIC,       "樂譜《Chirp》");
        translationBuilder.add(ModItems.MUSIC_DISC_CREATOR_SHEET_MUSIC,     "樂譜《Creator》");
        translationBuilder.add(ModItems.MUSIC_DISC_CREATOR_MUSIC_BOX_SHEET_MUSIC, "樂譜《Creator》（音樂盒）");
        translationBuilder.add(ModItems.MUSIC_DISC_FAR_SHEET_MUSIC,         "樂譜《Far》");
        translationBuilder.add(ModItems.MUSIC_DISC_MALL_SHEET_MUSIC,        "樂譜《Mall》");
        translationBuilder.add(ModItems.MUSIC_DISC_MELLOHI_SHEET_MUSIC,     "樂譜《Mellohi》");
        translationBuilder.add(ModItems.MUSIC_DISC_STAL_SHEET_MUSIC,        "樂譜《Stal》");
        translationBuilder.add(ModItems.MUSIC_DISC_STRAD_SHEET_MUSIC,       "樂譜《Strad》");
        translationBuilder.add(ModItems.MUSIC_DISC_WARD_SHEET_MUSIC,        "樂譜《Ward》");
        translationBuilder.add(ModItems.MUSIC_DISC_11_SHEET_MUSIC,          "樂譜《11》");
        translationBuilder.add(ModItems.MUSIC_DISC_WAIT_SHEET_MUSIC,        "樂譜《Wait》");
        translationBuilder.add(ModItems.MUSIC_DISC_OTHERSIDE_SHEET_MUSIC,   "樂譜《Otherside》");
        translationBuilder.add(ModItems.MUSIC_DISC_RELIC_SHEET_MUSIC,       "樂譜《Relic》");
        translationBuilder.add(ModItems.MUSIC_DISC_5_SHEET_MUSIC,           "樂譜《5》");
        translationBuilder.add(ModItems.MUSIC_DISC_PIGSTEP_SHEET_MUSIC,     "樂譜《Pigstep》");
        translationBuilder.add(ModItems.MUSIC_DISC_PRECIPICE_SHEET_MUSIC,   "樂譜《Precipice》");

        //方块
        translationBuilder.add(ModBlocks.STEEL_BLOCK,                   "鋼塊");
        translationBuilder.add(ModBlocks.COMPRESS_WOOL,                 "壓縮羊毛");

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
        translationBuilder.add("diamond_shards_upgrade_applies_to",         "工具");
        translationBuilder.add("diamond_shards_upgrade_ingredients",        "碎鑽石");
        translationBuilder.add("diamond_shards_upgrade",                    "鑽石升級（流嘢）");
        translationBuilder.add("diamond_shards_upgrade_base_slot",          "擺入斧頭或鎬");
        translationBuilder.add("diamond_shards_upgrade_additions_slot",     "擺入任意碎鑽石");

        translationBuilder.add("pressure_crafting_applies_to",              "樣板磚");
        translationBuilder.add("pressure_crafting_ingredients",             "大炸彈，好似末影水晶");
        translationBuilder.add("pressure_crafting",                         "宇宙洪荒");
        translationBuilder.add("pressure_crafting_base_slot",               "擺入樣板磚");
        translationBuilder.add("pressure_crafting_additions_slot",          "擺入大炸彈");

        translationBuilder.add("nether_smithing_applies_to",                "稀有物樣板");
        translationBuilder.add("nether_smithing_ingredients",               "遠古之淚");
        translationBuilder.add("nether_smithing",                           "上古之泣");
        translationBuilder.add("nether_smithing_base_slot",                 "擺入材料樣板");
        translationBuilder.add("nether_smithing_additions_slot",            "擺入遠古之淚");

        translationBuilder.add("nether_smithing_pro_applies_to",            "財寶樣板");
        translationBuilder.add("nether_smithing_pro_ingredients",           "儀式之引");
        translationBuilder.add("nether_smithing_pro",                       "上古之泣");
        translationBuilder.add("nether_smithing_pro_base_slot",             "擺入財寶樣板");
        translationBuilder.add("nether_smithing_pro_additions_slot",        "擺入儀式之引");

        translationBuilder.add("elytra_copy_applies_to",                    "鞘翅樣板");
        translationBuilder.add("elytra_copy_ingredients",                   "鞍");
        translationBuilder.add("elytra_copy",                               "鞘翅嘅傳承");
        translationBuilder.add("elytra_copy_base_slot",                     "擺入鞘翅樣板");
        translationBuilder.add("elytra_copy_additions_slot",                "擺入鞍");

        translationBuilder.add("enchanted_golden_apple_copy_applies_to",    "金蘋果");
        translationBuilder.add("enchanted_golden_apple_copy_ingredients",   "附魔之瓶");
        translationBuilder.add("enchanted_golden_apple_copy",               "超級金蘋果");
        translationBuilder.add("enchanted_golden_apple_copy_base_slot",     "擺入金蘋果");
        translationBuilder.add("enchanted_golden_apple_copy_additions_slot","擺入附魔之瓶");

        translationBuilder.add("head_copy_applies_to",                      "旋風棒");
        translationBuilder.add("head_copy_ingredients",                     "龍之吐息");
        translationBuilder.add("head_copy",                                 "Q比之愛");
        translationBuilder.add("head_copy_base_slot",                       "擺入旋風棒");
        translationBuilder.add("head_copy_additions_slot",                  "擺入龍之吐息");

        translationBuilder.add("totem_of_undying_copy_applies_to",          "鑽石");
        translationBuilder.add("totem_of_undying_copy_ingredients",         "青金石");
        translationBuilder.add("totem_of_undying_copy",                     "買命錢");
        translationBuilder.add("totem_of_undying_copy_base_slot",           "擺入鑽石");
        translationBuilder.add("totem_of_undying_copy_additions_slot",      "擺入青金石");

        translationBuilder.add("itemGroup.vanilla_addition",                "原版升級");
        translationBuilder.add("itemGroup.building_addition",               "建筑升級");
        translationBuilder.add("itemGroup.vanilla_renewable",               "可持續發展");

        translationBuilder.add("custom_banner.bilibili", "嗶哩嗶哩乾杯");

        translationBuilder.add("RedstoneHead_","數字： ");
    }


}
