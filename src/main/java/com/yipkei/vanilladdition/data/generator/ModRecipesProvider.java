package com.yipkei.vanilladdition.data.generator;

import com.yipkei.vanilladdition.VanillaAddition;
import com.yipkei.vanilladdition.data.recipe.ModCustomRecipeProvider;
import com.yipkei.vanilladdition.init.ModBlocks;
import com.yipkei.vanilladdition.init.ModItems;
import com.yipkei.vanilladdition.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipesProvider extends ModCustomRecipeProvider {
    private static final List<ItemConvertible> STEEL_MATERIAL_LIST = List.of(Items.IRON_INGOT);

    public ModRecipesProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        /* 可逆压实 */
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.STEEL_INGOT, RecipeCategory.BUILDING_BLOCKS, ModBlocks.STEEL_BLOCK);

        offerReversible2x2CompactingRecipes(exporter,RecipeCategory.MISC,ModItems.DIAMOND_SHARD, ModItems.DIAMOND_SHARD_STACK);

        /* 原版烧炼配方 */
        offerSmelting(exporter,STEEL_MATERIAL_LIST,RecipeCategory.MISC,ModItems.STEEL_INGOT, 1.0f,1000,"steel_ingot");
        offerBlasting(exporter,STEEL_MATERIAL_LIST,RecipeCategory.MISC,ModItems.STEEL_INGOT, 1.0f,400,"steel_ingot");

        offerCookingDefault(exporter,200,Items.ROTTEN_FLESH,ModItems.ROASTED_ROTTEN_FLESH,0.8f);

        /* 工具与装备合成配方 */
        offerSwordRecipe  (exporter, ModItems.STEEL_INGOT, Items.STICK, ModItems.STEEL_SWORD,   "steel");
        offerShovelRecipe (exporter, ModItems.STEEL_INGOT, Items.STICK, ModItems.STEEL_SHOVEL,  "steel");
        offerPickaxeRecipe(exporter, ModItems.STEEL_INGOT, Items.STICK, ModItems.STEEL_PICKAXE, "steel");
        offerAxeRecipe    (exporter, ModItems.STEEL_INGOT, Items.STICK, ModItems.STEEL_AXE,     "steel");
        offerHoeRecipe    (exporter, ModItems.STEEL_INGOT, Items.STICK, ModItems.STEEL_HOE,     "steel");
        
        /* 工具锤合成配方及其处理配方*/
        offerTorchLikeRecipe(exporter, RecipeCategory.TOOLS, Items.COBBLESTONE,      Items.STICK,          ModItems.STONE_HAMMER,   1, "stone_hammer");
        offerTorchLikeRecipe(exporter, RecipeCategory.TOOLS, Items.IRON_INGOT,       Items.STICK,          ModItems.IRON_HAMMER,    1, "iron_hammer");
        offerTorchLikeRecipe(exporter, RecipeCategory.TOOLS, ModItems.DIAMOND_SHARD, ModItems.IRON_HAMMER, ModItems.DIAMOND_HAMMER, 1, "diamond_hammer");

        offerHammerProcessing(exporter,Items.DIAMOND,            1, ModItems.STONE_HAMMER, ModItems.DIAMOND_SHARD, 3, "processing");
        offerHammerProcessing(exporter,Items.DIAMOND_SWORD,      1, ModItems.STONE_HAMMER, ModItems.DIAMOND_SHARD, 2, "recycling");
        offerHammerProcessing(exporter,Items.DIAMOND_SHOVEL,     1, ModItems.STONE_HAMMER, ModItems.DIAMOND_SHARD, 1, "recycling");
        offerHammerProcessing(exporter,Items.DIAMOND_PICKAXE,    1, ModItems.STONE_HAMMER, ModItems.DIAMOND_SHARD, 3, "recycling");
        offerHammerProcessing(exporter,Items.DIAMOND_AXE,        1, ModItems.STONE_HAMMER, ModItems.DIAMOND_SHARD, 3, "recycling");
        offerHammerProcessing(exporter,Items.DIAMOND_HOE,        1, ModItems.STONE_HAMMER, ModItems.DIAMOND_SHARD, 2, "recycling");
        offerHammerProcessing(exporter,Items.DIAMOND_HELMET,     1, ModItems.STONE_HAMMER, ModItems.DIAMOND_SHARD, 5, "recycling");
        offerHammerProcessing(exporter,Items.DIAMOND_CHESTPLATE, 1, ModItems.STONE_HAMMER, ModItems.DIAMOND_SHARD, 8, "recycling");
        offerHammerProcessing(exporter,Items.DIAMOND_LEGGINGS,   1, ModItems.STONE_HAMMER, ModItems.DIAMOND_SHARD, 7, "recycling");
        offerHammerProcessing(exporter,Items.DIAMOND_BOOTS,      1, ModItems.STONE_HAMMER, ModItems.DIAMOND_SHARD, 4, "recycling");
        offerHammerProcessing(exporter,Items.DIAMOND_HORSE_ARMOR,1, ModItems.STONE_HAMMER, ModItems.DIAMOND_SHARD, 5, "recycling");

        offerHammerProcessing(exporter,Items.DIAMOND,            1, ModItems.IRON_HAMMER,  ModItems.DIAMOND_SHARD, 24, "processing");
        offerHammerProcessing(exporter,Items.DIAMOND_SWORD,      1, ModItems.IRON_HAMMER,  ModItems.DIAMOND_SHARD, 16, "recycling");
        offerHammerProcessing(exporter,Items.DIAMOND_SHOVEL,     1, ModItems.IRON_HAMMER,  ModItems.DIAMOND_SHARD, 8,  "recycling");
        offerHammerProcessing(exporter,Items.DIAMOND_PICKAXE,    1, ModItems.IRON_HAMMER,  ModItems.DIAMOND_SHARD, 24, "recycling");
        offerHammerProcessing(exporter,Items.DIAMOND_AXE,        1, ModItems.IRON_HAMMER,  ModItems.DIAMOND_SHARD, 24, "recycling");
        offerHammerProcessing(exporter,Items.DIAMOND_HOE,        1, ModItems.IRON_HAMMER,  ModItems.DIAMOND_SHARD, 16, "recycling");
        offerHammerProcessing(exporter,Items.DIAMOND_HELMET,     1, ModItems.IRON_HAMMER,  ModItems.DIAMOND_SHARD, 40, "recycling");
        offerHammerProcessing(exporter,Items.DIAMOND_CHESTPLATE, 1, ModItems.IRON_HAMMER,  ModItems.DIAMOND_SHARD, 64, "recycling");
        offerHammerProcessing(exporter,Items.DIAMOND_LEGGINGS,   1, ModItems.IRON_HAMMER,  ModItems.DIAMOND_SHARD, 56, "recycling");
        offerHammerProcessing(exporter,Items.DIAMOND_BOOTS,      1, ModItems.IRON_HAMMER,  ModItems.DIAMOND_SHARD, 32, "recycling");
        offerHammerProcessing(exporter,Items.DIAMOND_HORSE_ARMOR,1, ModItems.IRON_HAMMER,  ModItems.DIAMOND_SHARD, 40, "recycling");

        // 石英块拆解
        offerHammerProcessing(exporter,ModTags.Items.QUARTZ_BLOCK,8,ModItems.DIAMOND_HAMMER,Items.QUARTZ,32,"recycling", "quartz_like_block");
        // 潮涌核心拆解
        offerHammerProcessing(exporter,Items.CONDUIT,1,ModItems.DIAMOND_HAMMER,ModItems.PULSE_OF_THE_SEA,8,"processing");

        // 锻造台配方
        offerUpgradeRecipe(exporter,ModItems.DIAMOND_SHARDS_UPGRADED_SMITHING_TEMPLATE, ModItems.STEEL_PICKAXE, ModItems.STEEL_INGOT, RecipeCategory.TOOLS,ModItems.DIAMOND_UPGRADED_PICKAXE);
        offerUpgradeRecipe(exporter,ModItems.DIAMOND_SHARDS_UPGRADED_SMITHING_TEMPLATE, ModItems.STEEL_AXE,     ModItems.STEEL_INGOT, RecipeCategory.TOOLS,ModItems.DIAMOND_UPGRADED_AXE);

        offerUpgradeRecipe(exporter,ModItems.PRESSURE_CRAFTING_TEMPLATE,           ModItems.DIAMOND_PROTOTYPE,    Items.END_CRYSTAL,        RecipeCategory.MISC, Items.DIAMOND_BLOCK);
        offerUpgradeRecipe(exporter,ModItems.NETHER_SMITHING_TEMPLATE,             ModItems.ANCIENT_PROTOTYPE,    ModItems.ANCIENT_TEAR,    RecipeCategory.MISC, Items.ANCIENT_DEBRIS);
        offerUpgradeRecipe(exporter,ModItems.NETHER_SMITHING_TEMPLATE,             ModItems.SUSPICIOUS_PROTOTYPE, ModItems.ANCIENT_TEAR,    RecipeCategory.MISC, Items.ANCIENT_DEBRIS);
        offerUpgradeRecipe(exporter,ModItems.NETHER_SMITHING_TEMPLATE_PRO,         ModItems.HEAVY_CORE_PROTOTYPE, Items.WIND_CHARGE,        RecipeCategory.MISC, Items.HEAVY_CORE);
        offerUpgradeRecipe(exporter,ModItems.NETHER_SMITHING_TEMPLATE_PRO,         ModItems.CONDUIT_PROTOTYPE,    Items.NAUTILUS_SHELL,     RecipeCategory.MISC, Items.HEART_OF_THE_SEA);
        offerUpgradeRecipe(exporter,ModItems.ELYTRA_COPY_TEMPLATE,                 ModItems.ELYTRA_PROTOTYPE,     Items.SADDLE,             RecipeCategory.MISC, Items.ELYTRA);
        offerUpgradeRecipe(exporter,ModItems.ENCHANTED_GOLDEN_APPLE_COPY_TEMPLATE, Items.GOLDEN_APPLE,            Items.EXPERIENCE_BOTTLE,  RecipeCategory.MISC, Items.ENCHANTED_GOLDEN_APPLE);
        offerUpgradeRecipe(exporter,ModItems.NETHER_SMITHING_TEMPLATE_PRO,         Items.NETHERITE_PICKAXE,       Items.HEAVY_CORE,         RecipeCategory.MISC, ModItems.DESTROYER_PICKAXE);

        /* 简易再生 */
        offerChestLikeRecipe(exporter,RecipeCategory.MISC,Items.YELLOW_WOOL,  ModItems.PULSE_OF_THE_SEA,Items.SPONGE,            8);
        offerChestLikeRecipe(exporter,RecipeCategory.MISC,Items.BRAIN_CORAL,  ModItems.PULSE_OF_THE_SEA,Items.BRAIN_CORAL_BLOCK, 1);
        offerChestLikeRecipe(exporter,RecipeCategory.MISC,Items.BUBBLE_CORAL, ModItems.PULSE_OF_THE_SEA,Items.BUBBLE_CORAL_BLOCK,1);
        offerChestLikeRecipe(exporter,RecipeCategory.MISC,Items.FIRE_CORAL,   ModItems.PULSE_OF_THE_SEA,Items.FIRE_CORAL_BLOCK,  1);
        offerChestLikeRecipe(exporter,RecipeCategory.MISC,Items.HORN_CORAL,   ModItems.PULSE_OF_THE_SEA,Items.HORN_CORAL_BLOCK,  1);
        offerChestLikeRecipe(exporter,RecipeCategory.MISC,Items.TUBE_CORAL,   ModItems.PULSE_OF_THE_SEA,Items.TUBE_CORAL_BLOCK,  1);

        /* 原型合成 */
        offerChestLikeRecipe(exporter,RecipeCategory.MISC,ModItems.DIAMOND_SHARD_STACK,Items.COAL_BLOCK,ModItems.DIAMOND_PROTOTYPE,1);
        offerChestLikeRecipe(exporter,RecipeCategory.MISC,Items.NETHERITE_BLOCK,Items.NETHER_STAR,ModItems.HEAVY_CORE_PROTOTYPE,1);
        offerChestLikeRecipe(exporter,RecipeCategory.MISC,Items.NETHER_STAR,ModBlocks.STEEL_BLOCK.asItem(),ModItems.SUSPICIOUS_PROTOTYPE,1);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.ANCIENT_PROTOTYPE,16)
                .pattern("#*")
                .pattern("*#")
                .input('#',Items.NETHERITE_INGOT)
                .input('*',Items.NETHER_STAR)
                .criterion(hasItem(Items.NETHERITE_INGOT),conditionsFromItem(Items.NETHERITE_INGOT))
                .criterion(hasItem(Items.NETHER_STAR),conditionsFromItem(Items.NETHER_STAR))
                .offerTo(exporter,Identifier.of(VanillaAddition.MOD_ID,"ancient_prototype_from_netherite_ingot"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.ELYTRA_PROTOTYPE,1)
                .pattern("# #")
                .pattern("*#*")
                .pattern("* *")
                .input('#',Items.NETHERITE_INGOT)
                .input('*',ModItems.DRAGON_WING_MEMBRANE)
                .criterion(hasItem(Items.NETHERITE_INGOT),conditionsFromItem(Items.NETHERITE_INGOT))
                .criterion(hasItem(ModItems.DRAGON_WING_MEMBRANE),conditionsFromItem(ModItems.DRAGON_WING_MEMBRANE))
                .offerTo(exporter,Identifier.of(VanillaAddition.MOD_ID,"elytra_prototype_from_dragon_wing_membrane"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.CONDUIT_PROTOTYPE,1)
                .pattern("#*#")
                .pattern("*o*")
                .pattern("#*#")
                .input('#',Items.PRISMARINE_CRYSTALS)
                .input('*',ModItems.PULSE_OF_THE_SEA)
                .input('o',Items.NETHER_STAR)
                .criterion(hasItem(Items.NETHER_STAR),conditionsFromItem(Items.NETHER_STAR))
                .criterion(hasItem(ModItems.PULSE_OF_THE_SEA),conditionsFromItem(ModItems.PULSE_OF_THE_SEA))
                .offerTo(exporter,Identifier.of(VanillaAddition.MOD_ID,"conduit_prototype_from_pulse_of_the_sea"));

        /* 模板复制 */
        // 碎钻升级锻造模板，不考虑模板复制，因为合成成本极低
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DIAMOND_SHARDS_UPGRADED_SMITHING_TEMPLATE,1)
                .pattern("#*#")
                .pattern("###")
                .pattern("#*#")
                .input('#', ItemTags.PLANKS)
                .input('*',ModItems.DIAMOND_SHARD)
                .criterion(hasItem(ModItems.DIAMOND_SHARD),conditionsFromItem(ModItems.DIAMOND_SHARD))
                .offerTo(exporter,Identifier.of(VanillaAddition.MOD_ID,"diamond_upgraded_smithing_template"));

        // 压力合成模板 合成 - 贵
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PRESSURE_CRAFTING_TEMPLATE,1)
                .pattern("#*#")
                .pattern("###")
                .pattern("#*#")
                .input('#', Items.NETHERITE_INGOT)
                .input('*',Items.NETHER_STAR)
                .criterion(hasItem(Items.NETHERITE_INGOT),conditionsFromItem(Items.NETHERITE_INGOT))
                .criterion(hasItem(Items.NETHER_STAR),conditionsFromItem(Items.NETHER_STAR))
                .offerTo(exporter,Identifier.of(VanillaAddition.MOD_ID,"pressure_crafting_template_by_crafting"));

        // 复制 - 便宜
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PRESSURE_CRAFTING_TEMPLATE,2)
                .pattern("###")
                .pattern("#*#")
                .pattern("###")
                .input('#', ModItems.STEEL_INGOT)
                .input('*',ModItems.PRESSURE_CRAFTING_TEMPLATE)
                .criterion(hasItem(ModItems.PRESSURE_CRAFTING_TEMPLATE),conditionsFromItem(ModItems.PRESSURE_CRAFTING_TEMPLATE))
                .offerTo(exporter,Identifier.of(VanillaAddition.MOD_ID,"pressure_crafting_template_by_copying"));

        // 初级下界锻造模板 - 复制（初次击败凋零必定获取，远古遗迹低概率开出）
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.NETHER_SMITHING_TEMPLATE,2)
                .pattern("#o#")
                .pattern("#*#")
                .pattern("###")
                .input('#', ModItems.STEEL_INGOT)
                .input('o',Items.ENDER_EYE)
                .input('*',ModItems.NETHER_SMITHING_TEMPLATE)
                .criterion(hasItem(ModItems.NETHER_SMITHING_TEMPLATE),conditionsFromItem(ModItems.NETHER_SMITHING_TEMPLATE))
                .offerTo(exporter,Identifier.of(VanillaAddition.MOD_ID,"nether_smithing_template_by_copying"));

        // 高级下界锻造模板 - 升级
        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.NETHER_SMITHING_TEMPLATE),
                Ingredient.ofItems(Items.NETHERITE_BLOCK),
                Ingredient.ofItems(ModItems.DIAMOND_HAMMER),
                RecipeCategory.MISC,
                ModItems.NETHER_SMITHING_TEMPLATE_PRO)
                .criterion(hasItem(ModItems.NETHER_SMITHING_TEMPLATE),conditionsFromItem(ModItems.NETHER_SMITHING_TEMPLATE))
                .offerTo(exporter,Identifier.of(VanillaAddition.MOD_ID,"nether_smithing_template_upgrade"));

        // 高级下界锻造模板 - 复制
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.NETHER_SMITHING_TEMPLATE_PRO,2)
                .pattern("#o#")
                .pattern("o*o")
                .pattern("#o#")
                .input('#', Items.NETHERITE_INGOT)
                .input('o',Items.NETHER_STAR)
                .input('*',ModItems.NETHER_SMITHING_TEMPLATE_PRO)
                .criterion(hasItem(ModItems.NETHER_SMITHING_TEMPLATE_PRO),conditionsFromItem(ModItems.NETHER_SMITHING_TEMPLATE_PRO))
                .offerTo(exporter,Identifier.of(VanillaAddition.MOD_ID,"nether_smithing_template_pro_by_copying"));

        // 鞘翅仿制模板 - 复制（初次击败末影龙必定获取，末地城低概率开出）
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ELYTRA_COPY_TEMPLATE,4)
                .pattern("o*o")
                .pattern("#x#")
                .pattern("#x#")
                .input('#', Items.PHANTOM_MEMBRANE)
                .input('o',Items.BAMBOO)
                .input('x',Items.STRING)
                .input('*',ModItems.ELYTRA_COPY_TEMPLATE)
                .criterion(hasItem(ModItems.NETHER_SMITHING_TEMPLATE),conditionsFromItem(ModItems.NETHER_SMITHING_TEMPLATE))
                .offerTo(exporter,Identifier.of(VanillaAddition.MOD_ID,"elytra_copy_template_by_copying"));

        // 金苹果仿制模板 - 合成
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ENCHANTED_GOLDEN_APPLE_COPY_TEMPLATE,1)
                .pattern("###")
                .pattern("#*#")
                .pattern("###")
                .input('#', Items.NETHERITE_INGOT)
                .input('*',ModItems.ENCHANTED_GOLDEN_APPLE_COPY_TEMPLATE)
                .criterion(hasItem(Items.ENCHANTED_GOLDEN_APPLE),conditionsFromItem(Items.ENCHANTED_GOLDEN_APPLE))
                .offerTo(exporter,Identifier.of(VanillaAddition.MOD_ID,"enchanted_golden_apple_copy_template_from_itself"));

        // 金苹果仿制模板 - 复制
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ENCHANTED_GOLDEN_APPLE_COPY_TEMPLATE,4)
                .pattern("###")
                .pattern("#*#")
                .pattern("###")
                .input('#', Items.GOLD_BLOCK)
                .input('*',ModItems.ENCHANTED_GOLDEN_APPLE_COPY_TEMPLATE)
                .criterion(hasItem(ModItems.ENCHANTED_GOLDEN_APPLE_COPY_TEMPLATE),conditionsFromItem(ModItems.ENCHANTED_GOLDEN_APPLE_COPY_TEMPLATE))
                .offerTo(exporter,Identifier.of(VanillaAddition.MOD_ID,"enchanted_golden_apple_copy_template_by_copying"));

        // 不死图腾仿制模板
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TOTEM_OF_UNDYING_COPY_TEMPLATE,1)
                .pattern("###")
                .pattern("#*#")
                .pattern("###")
                .input('#', Items.TOTEM_OF_UNDYING)
                .input('*',Items.NETHER_STAR)
                .criterion(hasItem(Items.TOTEM_OF_UNDYING),conditionsFromItem(Items.TOTEM_OF_UNDYING))
                .offerTo(exporter,Identifier.of(VanillaAddition.MOD_ID,"totem_of_undying_copy_template_from_itself"));

        // 不死图腾复制模板
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TOTEM_OF_UNDYING_COPY_TEMPLATE,4)
                .pattern("o#o")
                .pattern("#*#")
                .pattern("o#o")
                .input('#', Items.GOLD_BLOCK)
                .input('o', Items.EMERALD_BLOCK)
                .input('*',ModItems.TOTEM_OF_UNDYING_COPY_TEMPLATE)
                .criterion(hasItem(ModItems.TOTEM_OF_UNDYING_COPY_TEMPLATE),conditionsFromItem(ModItems.TOTEM_OF_UNDYING_COPY_TEMPLATE))
                .offerTo(exporter,Identifier.of(VanillaAddition.MOD_ID,"totem_of_undying_copy_template_by_copying"));

        // 龙头仿制模板
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.HEAD_COPY_TEMPLATE,1)
                .pattern("123")
                .pattern("4*5")
                .pattern("666")
                .input('1', Items.CREEPER_HEAD)
                .input('2', Items.SKELETON_SKULL)
                .input('3', Items.ZOMBIE_HEAD)
                .input('4', Items.DRAGON_HEAD)
                .input('5', Items.PIGLIN_HEAD)
                .input('6', Items.WITHER_SKELETON_SKULL)
                .input('*', ModItems.NETHER_SMITHING_TEMPLATE_PRO)
                .criterion(hasItem(Items.DRAGON_HEAD),conditionsFromItem(Items.DRAGON_HEAD))
                .offerTo(exporter,Identifier.of(VanillaAddition.MOD_ID,"head_copy_template_from_crafting"));

        // 龙头仿制模板
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.HEAD_COPY_TEMPLATE,4)
                .pattern("###")
                .pattern("#*#")
                .pattern("ooo")
                .input('#', Items.NETHERITE_INGOT)
                .input('o', Items.WITHER_SKELETON_SKULL)
                .input('*', ModItems.HEAD_COPY_TEMPLATE)
                .criterion(hasItem(ModItems.HEAD_COPY_TEMPLATE),conditionsFromItem(ModItems.HEAD_COPY_TEMPLATE))
                .offerTo(exporter,Identifier.of(VanillaAddition.MOD_ID,"head_copy_template_by_copying"));

        /* 陶片复制 */
        offerSherdCopy(exporter, Items.ANGLER_POTTERY_SHERD,     ModItems.ANGLER_POTTERY_SHERD_BLUEPRINT,     ModItems.ANGLER_POTTERY_SHERD_PROTOTYPE,     0.4f, 200);
        offerSherdCopy(exporter, Items.ARCHER_POTTERY_SHERD,     ModItems.ARCHER_POTTERY_SHERD_BLUEPRINT,     ModItems.ARCHER_POTTERY_SHERD_PROTOTYPE,     0.4f, 200);
        offerSherdCopy(exporter, Items.ARMS_UP_POTTERY_SHERD,    ModItems.ARMS_UP_POTTERY_SHERD_BLUEPRINT,    ModItems.ARMS_UP_POTTERY_SHERD_PROTOTYPE,    0.4f, 200);
        offerSherdCopy(exporter, Items.BLADE_POTTERY_SHERD,      ModItems.BLADE_POTTERY_SHERD_BLUEPRINT,      ModItems.BLADE_POTTERY_SHERD_PROTOTYPE,      0.4f, 200);
        offerSherdCopy(exporter, Items.BREWER_POTTERY_SHERD,     ModItems.BREWER_POTTERY_SHERD_BLUEPRINT,     ModItems.BREWER_POTTERY_SHERD_PROTOTYPE,     0.4f, 200);
        offerSherdCopy(exporter, Items.BURN_POTTERY_SHERD,       ModItems.BURN_POTTERY_SHERD_BLUEPRINT,       ModItems.BURN_POTTERY_SHERD_PROTOTYPE,       0.4f, 200);
        offerSherdCopy(exporter, Items.DANGER_POTTERY_SHERD,     ModItems.DANGER_POTTERY_SHERD_BLUEPRINT,     ModItems.DANGER_POTTERY_SHERD_PROTOTYPE,     0.4f, 200);
        offerSherdCopy(exporter, Items.EXPLORER_POTTERY_SHERD,   ModItems.EXPLORER_POTTERY_SHERD_BLUEPRINT,   ModItems.EXPLORER_POTTERY_SHERD_PROTOTYPE,   0.4f, 200);
        offerSherdCopy(exporter, Items.FRIEND_POTTERY_SHERD,     ModItems.FRIEND_POTTERY_SHERD_BLUEPRINT,     ModItems.FRIEND_POTTERY_SHERD_PROTOTYPE,     0.4f, 200);
        offerSherdCopy(exporter, Items.HEART_POTTERY_SHERD,      ModItems.HEART_POTTERY_SHERD_BLUEPRINT,      ModItems.HEART_POTTERY_SHERD_PROTOTYPE,      0.4f, 200);
        offerSherdCopy(exporter, Items.HEARTBREAK_POTTERY_SHERD, ModItems.HEARTBREAK_POTTERY_SHERD_BLUEPRINT, ModItems.HEARTBREAK_POTTERY_SHERD_PROTOTYPE, 0.4f, 200);
        offerSherdCopy(exporter, Items.HOWL_POTTERY_SHERD,       ModItems.HOWL_POTTERY_SHERD_BLUEPRINT,       ModItems.HOWL_POTTERY_SHERD_PROTOTYPE,       0.4f, 200);
        offerSherdCopy(exporter, Items.MINER_POTTERY_SHERD,      ModItems.MINER_POTTERY_SHERD_BLUEPRINT,      ModItems.MINER_POTTERY_SHERD_PROTOTYPE,      0.4f, 200);
        offerSherdCopy(exporter, Items.MOURNER_POTTERY_SHERD,    ModItems.MOURNER_POTTERY_SHERD_BLUEPRINT,    ModItems.MOURNER_POTTERY_SHERD_PROTOTYPE,    0.4f, 200);
        offerSherdCopy(exporter, Items.PLENTY_POTTERY_SHERD,     ModItems.PLENTY_POTTERY_SHERD_BLUEPRINT,     ModItems.PLENTY_POTTERY_SHERD_PROTOTYPE,     0.4f, 200);
        offerSherdCopy(exporter, Items.PRIZE_POTTERY_SHERD,      ModItems.PRIZE_POTTERY_SHERD_BLUEPRINT,      ModItems.PRIZE_POTTERY_SHERD_PROTOTYPE,      0.4f, 200);
        offerSherdCopy(exporter, Items.SHEAF_POTTERY_SHERD,      ModItems.SHEAF_POTTERY_SHERD_BLUEPRINT,      ModItems.SHEAF_POTTERY_SHERD_PROTOTYPE,      0.4f, 200);
        offerSherdCopy(exporter, Items.SHELTER_POTTERY_SHERD,    ModItems.SHELTER_POTTERY_SHERD_BLUEPRINT,    ModItems.SHELTER_POTTERY_SHERD_PROTOTYPE,    0.4f, 200);
        offerSherdCopy(exporter, Items.SKULL_POTTERY_SHERD,      ModItems.SKULL_POTTERY_SHERD_BLUEPRINT,      ModItems.SKULL_POTTERY_SHERD_PROTOTYPE,      0.4f, 200);
        offerSherdCopy(exporter, Items.SNORT_POTTERY_SHERD,      ModItems.SNORT_POTTERY_SHERD_BLUEPRINT,      ModItems.SNORT_POTTERY_SHERD_PROTOTYPE,      0.4f, 200);
        offerSherdCopy(exporter, Items.FLOW_POTTERY_SHERD,       ModItems.FLOW_POTTERY_SHERD_BLUEPRINT,       ModItems.FLOW_POTTERY_SHERD_PROTOTYPE,       0.4f, 200);
        offerSherdCopy(exporter, Items.GUSTER_POTTERY_SHERD,     ModItems.GUSTER_POTTERY_SHERD_BLUEPRINT,     ModItems.GUSTER_POTTERY_SHERD_PROTOTYPE,     0.4f, 200);
        offerSherdCopy(exporter, Items.SCRAPE_POTTERY_SHERD,     ModItems.SCRAPE_POTTERY_SHERD_BLUEPRINT,     ModItems.SCRAPE_POTTERY_SHERD_PROTOTYPE,     0.4f, 200);

        /* 建筑方块拓展配方 */
        // 墙
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.STONE,                 ModBlocks.STONE_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.SMOOTH_STONE ,         ModBlocks.SMOOTH_STONE_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.DIRT,                  ModBlocks.DIRT_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.MUD,                   ModBlocks.MUD_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.CLAY,                  ModBlocks.CLAY_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.POLISHED_GRANITE,      ModBlocks.POLISHED_GRANITE_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.POLISHED_DIORITE,      ModBlocks.POLISHED_DIORITE_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.POLISHED_ANDESITE,     ModBlocks.POLISHED_ANDESITE_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.CALCITE,               ModBlocks.CALCITE_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.SMOOTH_SANDSTONE,      ModBlocks.SMOOTH_SANDSTONE_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.SMOOTH_RED_SANDSTONE,  ModBlocks.SMOOTH_RED_SANDSTONE_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.PRISMARINE_BRICKS,     ModBlocks.PRISMARINE_BRICK_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.DARK_PRISMARINE,       ModBlocks.DARK_PRISMARINE_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.OBSIDIAN,              ModBlocks.OBSIDIAN_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.CRYING_OBSIDIAN,       ModBlocks.CRYING_OBSIDIAN_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.NETHERRACK,            ModBlocks.NETHERRACK_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.BASALT,                ModBlocks.BASALT_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.SMOOTH_BASALT,         ModBlocks.SMOOTH_BASALT_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.POLISHED_BASALT,       ModBlocks.POLISHED_BASALT_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.END_STONE,             ModBlocks.END_STONE_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.PURPUR_BLOCK,          ModBlocks.PURPUR_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.QUARTZ_BLOCK,          ModBlocks.QUARTZ_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.SMOOTH_QUARTZ,         ModBlocks.SMOOTH_QUARTZ_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.AMETHYST_BLOCK,        ModBlocks.AMETHYST_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.GLOWSTONE,             ModBlocks.GLOWSTONE_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.ICE,                   ModBlocks.ICE_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.PACKED_ICE,            ModBlocks.PACKED_ICE_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.BLUE_ICE,              ModBlocks.BLUE_ICE_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.WHITE_CONCRETE,        ModBlocks.WHITE_CONCRETE_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.LIGHT_GRAY_CONCRETE,   ModBlocks.LIGHT_GRAY_CONCRETE_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.GRAY_CONCRETE,         ModBlocks.GRAY_CONCRETE_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.BLACK_CONCRETE,        ModBlocks.BLACK_CONCRETE_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.BROWN_CONCRETE,        ModBlocks.BROWN_CONCRETE_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.RED_CONCRETE,          ModBlocks.RED_CONCRETE_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.ORANGE_CONCRETE,       ModBlocks.ORANGE_CONCRETE_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.YELLOW_CONCRETE,       ModBlocks.YELLOW_CONCRETE_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.LIME_CONCRETE,         ModBlocks.LIME_CONCRETE_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.GREEN_CONCRETE,        ModBlocks.GREEN_CONCRETE_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.CYAN_CONCRETE,         ModBlocks.CYAN_CONCRETE_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.LIGHT_BLUE_CONCRETE,   ModBlocks.LIGHT_BLUE_CONCRETE_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.BLUE_CONCRETE,         ModBlocks.BLUE_CONCRETE_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.PURPLE_CONCRETE,       ModBlocks.PURPLE_CONCRETE_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.MAGENTA_CONCRETE,      ModBlocks.MAGENTA_CONCRETE_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.PINK_CONCRETE,         ModBlocks.PINK_CONCRETE_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.TERRACOTTA,            ModBlocks.TERRACOTTA_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.WHITE_TERRACOTTA,      ModBlocks.WHITE_TERRACOTTA_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.LIGHT_GRAY_TERRACOTTA, ModBlocks.LIGHT_GRAY_TERRACOTTA_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.GRAY_TERRACOTTA,       ModBlocks.GRAY_TERRACOTTA_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.BLACK_TERRACOTTA,      ModBlocks.BLACK_TERRACOTTA_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.BROWN_TERRACOTTA,      ModBlocks.BROWN_TERRACOTTA_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.RED_TERRACOTTA,        ModBlocks.RED_TERRACOTTA_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.ORANGE_TERRACOTTA,     ModBlocks.ORANGE_TERRACOTTA_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.YELLOW_TERRACOTTA,     ModBlocks.YELLOW_TERRACOTTA_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.LIME_TERRACOTTA,       ModBlocks.LIME_TERRACOTTA_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.GREEN_TERRACOTTA,      ModBlocks.GREEN_TERRACOTTA_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.CYAN_TERRACOTTA,       ModBlocks.CYAN_TERRACOTTA_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.LIGHT_BLUE_TERRACOTTA, ModBlocks.LIGHT_BLUE_TERRACOTTA_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.BLUE_TERRACOTTA,       ModBlocks.BLUE_TERRACOTTA_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.PURPLE_TERRACOTTA,     ModBlocks.PURPLE_TERRACOTTA_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.MAGENTA_TERRACOTTA,    ModBlocks.MAGENTA_TERRACOTTA_WALL);
        offerDefaultWallRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.PINK_TERRACOTTA,       ModBlocks.PINK_TERRACOTTA_WALL);

        // 台阶
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.STONE,                 ModBlocks.STONE_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.SMOOTH_STONE ,         ModBlocks.SMOOTH_STONE_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.DIRT,                  ModBlocks.DIRT_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.MUD,                   ModBlocks.MUD_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.CLAY,                  ModBlocks.CLAY_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.POLISHED_GRANITE,      ModBlocks.POLISHED_GRANITE_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.POLISHED_DIORITE,      ModBlocks.POLISHED_DIORITE_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.POLISHED_ANDESITE,     ModBlocks.POLISHED_ANDESITE_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.CALCITE,               ModBlocks.CALCITE_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.SMOOTH_SANDSTONE,      ModBlocks.SMOOTH_SANDSTONE_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.SMOOTH_RED_SANDSTONE,  ModBlocks.SMOOTH_RED_SANDSTONE_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.PRISMARINE_BRICKS,     ModBlocks.PRISMARINE_BRICK_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.DARK_PRISMARINE,       ModBlocks.DARK_PRISMARINE_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.OBSIDIAN,              ModBlocks.OBSIDIAN_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.CRYING_OBSIDIAN,       ModBlocks.CRYING_OBSIDIAN_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.NETHERRACK,            ModBlocks.NETHERRACK_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.BASALT,                ModBlocks.BASALT_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.SMOOTH_BASALT,         ModBlocks.SMOOTH_BASALT_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.POLISHED_BASALT,       ModBlocks.POLISHED_BASALT_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.END_STONE,             ModBlocks.END_STONE_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.PURPUR_BLOCK,          ModBlocks.PURPUR_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.QUARTZ_BLOCK,          ModBlocks.QUARTZ_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.SMOOTH_QUARTZ,         ModBlocks.SMOOTH_QUARTZ_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.AMETHYST_BLOCK,        ModBlocks.AMETHYST_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.GLOWSTONE,             ModBlocks.GLOWSTONE_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.ICE,                   ModBlocks.ICE_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.PACKED_ICE,            ModBlocks.PACKED_ICE_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.BLUE_ICE,              ModBlocks.BLUE_ICE_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.WHITE_CONCRETE,        ModBlocks.WHITE_CONCRETE_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.LIGHT_GRAY_CONCRETE,   ModBlocks.LIGHT_GRAY_CONCRETE_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.GRAY_CONCRETE,         ModBlocks.GRAY_CONCRETE_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.BLACK_CONCRETE,        ModBlocks.BLACK_CONCRETE_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.BROWN_CONCRETE,        ModBlocks.BROWN_CONCRETE_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.RED_CONCRETE,          ModBlocks.RED_CONCRETE_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.ORANGE_CONCRETE,       ModBlocks.ORANGE_CONCRETE_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.YELLOW_CONCRETE,       ModBlocks.YELLOW_CONCRETE_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.LIME_CONCRETE,         ModBlocks.LIME_CONCRETE_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.GREEN_CONCRETE,        ModBlocks.GREEN_CONCRETE_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.CYAN_CONCRETE,         ModBlocks.CYAN_CONCRETE_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.LIGHT_BLUE_CONCRETE,   ModBlocks.LIGHT_BLUE_CONCRETE_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.BLUE_CONCRETE,         ModBlocks.BLUE_CONCRETE_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.PURPLE_CONCRETE,       ModBlocks.PURPLE_CONCRETE_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.MAGENTA_CONCRETE,      ModBlocks.MAGENTA_CONCRETE_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.PINK_CONCRETE,         ModBlocks.PINK_CONCRETE_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.TERRACOTTA,            ModBlocks.TERRACOTTA_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.WHITE_TERRACOTTA,      ModBlocks.WHITE_TERRACOTTA_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.LIGHT_GRAY_TERRACOTTA, ModBlocks.LIGHT_GRAY_TERRACOTTA_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.GRAY_TERRACOTTA,       ModBlocks.GRAY_TERRACOTTA_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.BLACK_TERRACOTTA,      ModBlocks.BLACK_TERRACOTTA_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.BROWN_TERRACOTTA,      ModBlocks.BROWN_TERRACOTTA_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.RED_TERRACOTTA,        ModBlocks.RED_TERRACOTTA_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.ORANGE_TERRACOTTA,     ModBlocks.ORANGE_TERRACOTTA_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.YELLOW_TERRACOTTA,     ModBlocks.YELLOW_TERRACOTTA_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.LIME_TERRACOTTA,       ModBlocks.LIME_TERRACOTTA_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.GREEN_TERRACOTTA,      ModBlocks.GREEN_TERRACOTTA_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.CYAN_TERRACOTTA,       ModBlocks.CYAN_TERRACOTTA_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.LIGHT_BLUE_TERRACOTTA, ModBlocks.LIGHT_BLUE_TERRACOTTA_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.BLUE_TERRACOTTA,       ModBlocks.BLUE_TERRACOTTA_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.PURPLE_TERRACOTTA,     ModBlocks.PURPLE_TERRACOTTA_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.MAGENTA_TERRACOTTA,    ModBlocks.MAGENTA_TERRACOTTA_STAIRS);
        offerDefaultStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.PINK_TERRACOTTA,       ModBlocks.PINK_TERRACOTTA_STAIRS);

        // 半砖
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.STONE,                 ModBlocks.STONE_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.SMOOTH_STONE ,         ModBlocks.SMOOTH_STONE_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.DIRT,                  ModBlocks.DIRT_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.MUD,                   ModBlocks.MUD_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.CLAY,                  ModBlocks.CLAY_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.POLISHED_GRANITE,      ModBlocks.POLISHED_GRANITE_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.POLISHED_DIORITE,      ModBlocks.POLISHED_DIORITE_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.POLISHED_ANDESITE,     ModBlocks.POLISHED_ANDESITE_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.CALCITE,               ModBlocks.CALCITE_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.SMOOTH_SANDSTONE,      ModBlocks.SMOOTH_SANDSTONE_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.SMOOTH_RED_SANDSTONE,  ModBlocks.SMOOTH_RED_SANDSTONE_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.PRISMARINE_BRICKS,     ModBlocks.PRISMARINE_BRICK_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.DARK_PRISMARINE,       ModBlocks.DARK_PRISMARINE_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.OBSIDIAN,              ModBlocks.OBSIDIAN_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.CRYING_OBSIDIAN,       ModBlocks.CRYING_OBSIDIAN_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.NETHERRACK,            ModBlocks.NETHERRACK_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.BASALT,                ModBlocks.BASALT_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.SMOOTH_BASALT,         ModBlocks.SMOOTH_BASALT_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.POLISHED_BASALT,       ModBlocks.POLISHED_BASALT_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.END_STONE,             ModBlocks.END_STONE_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.PURPUR_BLOCK,          ModBlocks.PURPUR_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.QUARTZ_BLOCK,          ModBlocks.QUARTZ_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.SMOOTH_QUARTZ,         ModBlocks.SMOOTH_QUARTZ_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.AMETHYST_BLOCK,        ModBlocks.AMETHYST_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.GLOWSTONE,             ModBlocks.GLOWSTONE_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.ICE,                   ModBlocks.ICE_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.PACKED_ICE,            ModBlocks.PACKED_ICE_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.BLUE_ICE,              ModBlocks.BLUE_ICE_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.WHITE_CONCRETE,        ModBlocks.WHITE_CONCRETE_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.LIGHT_GRAY_CONCRETE,   ModBlocks.LIGHT_GRAY_CONCRETE_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.GRAY_CONCRETE,         ModBlocks.GRAY_CONCRETE_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.BLACK_CONCRETE,        ModBlocks.BLACK_CONCRETE_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.BROWN_CONCRETE,        ModBlocks.BROWN_CONCRETE_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.RED_CONCRETE,          ModBlocks.RED_CONCRETE_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.ORANGE_CONCRETE,       ModBlocks.ORANGE_CONCRETE_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.YELLOW_CONCRETE,       ModBlocks.YELLOW_CONCRETE_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.LIME_CONCRETE,         ModBlocks.LIME_CONCRETE_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.GREEN_CONCRETE,        ModBlocks.GREEN_CONCRETE_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.CYAN_CONCRETE,         ModBlocks.CYAN_CONCRETE_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.LIGHT_BLUE_CONCRETE,   ModBlocks.LIGHT_BLUE_CONCRETE_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.BLUE_CONCRETE,         ModBlocks.BLUE_CONCRETE_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.PURPLE_CONCRETE,       ModBlocks.PURPLE_CONCRETE_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.MAGENTA_CONCRETE,      ModBlocks.MAGENTA_CONCRETE_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.PINK_CONCRETE,         ModBlocks.PINK_CONCRETE_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.TERRACOTTA,            ModBlocks.TERRACOTTA_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.WHITE_TERRACOTTA,      ModBlocks.WHITE_TERRACOTTA_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.LIGHT_GRAY_TERRACOTTA, ModBlocks.LIGHT_GRAY_TERRACOTTA_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.GRAY_TERRACOTTA,       ModBlocks.GRAY_TERRACOTTA_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.BLACK_TERRACOTTA,      ModBlocks.BLACK_TERRACOTTA_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.BROWN_TERRACOTTA,      ModBlocks.BROWN_TERRACOTTA_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.RED_TERRACOTTA,        ModBlocks.RED_TERRACOTTA_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.ORANGE_TERRACOTTA,     ModBlocks.ORANGE_TERRACOTTA_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.YELLOW_TERRACOTTA,     ModBlocks.YELLOW_TERRACOTTA_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.LIME_TERRACOTTA,       ModBlocks.LIME_TERRACOTTA_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.GREEN_TERRACOTTA,      ModBlocks.GREEN_TERRACOTTA_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.CYAN_TERRACOTTA,       ModBlocks.CYAN_TERRACOTTA_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.LIGHT_BLUE_TERRACOTTA, ModBlocks.LIGHT_BLUE_TERRACOTTA_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.BLUE_TERRACOTTA,       ModBlocks.BLUE_TERRACOTTA_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.PURPLE_TERRACOTTA,     ModBlocks.PURPLE_TERRACOTTA_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.MAGENTA_TERRACOTTA,    ModBlocks.MAGENTA_TERRACOTTA_SLAB);
        offerDefaultSlabRecipe  (exporter,RecipeCategory.BUILDING_BLOCKS, Blocks.PINK_TERRACOTTA,       ModBlocks.PINK_TERRACOTTA_SLAB);

        /* As no plan：有损原木配方 - 原木合成木楼梯等 */
        //箱子合成
        offerChestLikeRecipe(exporter, RecipeCategory.MISC, ItemTags.LOGS, Items.CHEST, 4,"logs");

        //箱船堆叠合成
        offerBoatLikeRecipe(exporter, RecipeCategory.MISC, Items.ACACIA_PLANKS,   Items.CHEST,   Items.ACACIA_CHEST_BOAT,   1);
        offerBoatLikeRecipe(exporter, RecipeCategory.MISC, Items.BIRCH_PLANKS,    Items.CHEST,   Items.BIRCH_CHEST_BOAT,    1);
        offerBoatLikeRecipe(exporter, RecipeCategory.MISC, Items.CHERRY_PLANKS,   Items.CHEST,   Items.CHERRY_CHEST_BOAT,   1);
        offerBoatLikeRecipe(exporter, RecipeCategory.MISC, Items.DARK_OAK_PLANKS, Items.CHEST,   Items.DARK_OAK_CHEST_BOAT, 1);
        offerBoatLikeRecipe(exporter, RecipeCategory.MISC, Items.MANGROVE_PLANKS, Items.CHEST,   Items.MANGROVE_CHEST_BOAT, 1);
        offerBoatLikeRecipe(exporter, RecipeCategory.MISC, Items.JUNGLE_PLANKS,   Items.CHEST,   Items.JUNGLE_CHEST_BOAT,   1);
        offerBoatLikeRecipe(exporter, RecipeCategory.MISC, Items.OAK_PLANKS,      Items.CHEST,   Items.OAK_CHEST_BOAT,      1);
        offerBoatLikeRecipe(exporter, RecipeCategory.MISC, Items.SPRUCE_PLANKS,   Items.CHEST,   Items.SPRUCE_CHEST_BOAT,   1);
        offerBoatLikeRecipe(exporter, RecipeCategory.MISC, Items.BAMBOO_PLANKS,   Items.CHEST,   Items.BAMBOO_CHEST_RAFT,   1);

        //功能矿车堆叠合成
        offerBoatLikeRecipe(exporter, RecipeCategory.MISC, Items.IRON_INGOT,      Items.TNT,     Items.TNT_MINECART,        1);
        offerBoatLikeRecipe(exporter, RecipeCategory.MISC, Items.IRON_INGOT,      Items.CHEST,   Items.CHEST_MINECART,      1);
        offerBoatLikeRecipe(exporter, RecipeCategory.MISC, Items.IRON_INGOT,      Items.HOPPER,  Items.HOPPER_MINECART,     1);
        offerBoatLikeRecipe(exporter, RecipeCategory.MISC, Items.IRON_INGOT,      Items.FURNACE, Items.FURNACE_MINECART,    1);

        //木板切台阶
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.ACACIA_SLAB,        Items.ACACIA_PLANKS,    2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.BIRCH_SLAB,         Items.BIRCH_PLANKS,     2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.CHERRY_SLAB,        Items.CHERRY_PLANKS,    2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.DARK_OAK_SLAB,      Items.DARK_OAK_PLANKS,  2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.MANGROVE_SLAB,      Items.MANGROVE_PLANKS,  2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.JUNGLE_SLAB,        Items.JUNGLE_PLANKS,    2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.OAK_SLAB,           Items.OAK_PLANKS,       2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.SPRUCE_SLAB,        Items.SPRUCE_PLANKS,    2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.CRIMSON_SLAB,       Items.CRIMSON_PLANKS,   2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.WARPED_SLAB,        Items.WARPED_PLANKS,    2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.BAMBOO_SLAB,        Items.BAMBOO_PLANKS,    2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.BAMBOO_MOSAIC_SLAB, Items.BAMBOO_PLANKS,    2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.BAMBOO_MOSAIC_SLAB, Items.BAMBOO_MOSAIC,    2);

        //竹台阶转化
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.BAMBOO_MOSAIC_SLAB, Items.BAMBOO_SLAB);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.BAMBOO_MOSAIC,      Items.BAMBOO_BLOCK);

        //原木切台阶
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.ACACIA_SLAB,        Items.ACACIA_LOG,            8);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.ACACIA_SLAB,        Items.STRIPPED_ACACIA_LOG,   8);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.BIRCH_SLAB,         Items.BIRCH_LOG,             8);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.BIRCH_SLAB,         Items.STRIPPED_BIRCH_LOG,    8);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.CHERRY_SLAB,        Items.CHERRY_LOG,            8);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.CHERRY_SLAB,        Items.STRIPPED_CHERRY_LOG,   8);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.DARK_OAK_SLAB,      Items.DARK_OAK_LOG,          8);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.DARK_OAK_SLAB,      Items.STRIPPED_DARK_OAK_LOG, 8);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.MANGROVE_SLAB,      Items.MANGROVE_LOG,          8);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.MANGROVE_SLAB,      Items.STRIPPED_MANGROVE_LOG, 8);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.JUNGLE_SLAB,        Items.JUNGLE_LOG,            8);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.JUNGLE_SLAB,        Items.STRIPPED_JUNGLE_LOG,   8);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.OAK_SLAB,           Items.OAK_LOG,               8);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.OAK_SLAB,           Items.STRIPPED_OAK_LOG,      8);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.SPRUCE_SLAB,        Items.SPRUCE_LOG,            8);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.SPRUCE_SLAB,        Items.STRIPPED_SPRUCE_LOG,   8);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.CRIMSON_SLAB,       Items.STRIPPED_CRIMSON_STEM, 8);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.WARPED_SLAB,        Items.WARPED_STEM,           8);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.WARPED_SLAB,        Items.STRIPPED_WARPED_STEM,  8);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.BAMBOO_SLAB,        Items.BAMBOO_BLOCK,          4);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.BAMBOO_SLAB,        Items.STRIPPED_BAMBOO_BLOCK, 4);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.BAMBOO_MOSAIC_SLAB, Items.BAMBOO_BLOCK,          4);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.BAMBOO_MOSAIC_SLAB, Items.STRIPPED_BAMBOO_BLOCK, 4);

        //木板切楼梯
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.ACACIA_STAIRS,        Items.ACACIA_PLANKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.BIRCH_STAIRS,         Items.BIRCH_PLANKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.CHERRY_STAIRS,        Items.CHERRY_PLANKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.DARK_OAK_STAIRS,      Items.DARK_OAK_PLANKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.MANGROVE_STAIRS,      Items.MANGROVE_PLANKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.JUNGLE_STAIRS,        Items.JUNGLE_PLANKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.OAK_STAIRS,           Items.OAK_PLANKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.SPRUCE_STAIRS,        Items.SPRUCE_PLANKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.CRIMSON_STAIRS,       Items.CRIMSON_PLANKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.WARPED_STAIRS,        Items.WARPED_PLANKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.BAMBOO_STAIRS,        Items.BAMBOO_PLANKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.BAMBOO_MOSAIC_STAIRS, Items.BAMBOO_PLANKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.BAMBOO_MOSAIC_STAIRS, Items.BAMBOO_MOSAIC);

        //原木切楼梯
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.ACACIA_STAIRS,        Items.ACACIA_LOG,            4);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.ACACIA_STAIRS,        Items.STRIPPED_ACACIA_LOG,   4);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.BIRCH_STAIRS,         Items.BIRCH_LOG,             4);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.BIRCH_STAIRS,         Items.STRIPPED_BIRCH_LOG,    4);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.CHERRY_STAIRS,        Items.CHERRY_LOG,            4);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.CHERRY_STAIRS,        Items.STRIPPED_CHERRY_LOG,   4);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.DARK_OAK_STAIRS,      Items.DARK_OAK_LOG,          4);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.DARK_OAK_STAIRS,      Items.STRIPPED_DARK_OAK_LOG, 4);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.MANGROVE_STAIRS,      Items.MANGROVE_LOG,          4);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.MANGROVE_STAIRS,      Items.STRIPPED_MANGROVE_LOG, 4);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.JUNGLE_STAIRS,        Items.JUNGLE_LOG,            4);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.JUNGLE_STAIRS,        Items.STRIPPED_JUNGLE_LOG,   4);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.OAK_STAIRS,           Items.OAK_LOG,               4);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.OAK_STAIRS,           Items.STRIPPED_OAK_LOG,      4);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.SPRUCE_STAIRS,        Items.SPRUCE_LOG,            4);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.SPRUCE_STAIRS,        Items.STRIPPED_SPRUCE_LOG,   4);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.CRIMSON_STAIRS,       Items.CRIMSON_STEM,          4);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.CRIMSON_STAIRS,       Items.STRIPPED_CRIMSON_STEM, 4);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.WARPED_STAIRS,        Items.WARPED_STEM,           4);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.WARPED_STAIRS,        Items.STRIPPED_WARPED_STEM,  4);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.BAMBOO_STAIRS,        Items.BAMBOO_BLOCK,          2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.BAMBOO_STAIRS,        Items.STRIPPED_BAMBOO_BLOCK, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.BAMBOO_MOSAIC_STAIRS, Items.BAMBOO_BLOCK,          2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.BAMBOO_MOSAIC_STAIRS, Items.STRIPPED_BAMBOO_BLOCK, 2);

        //原木切栅栏（略微增产）
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.ACACIA_FENCE,         Items.ACACIA_LOG,            3);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.ACACIA_FENCE,         Items.STRIPPED_ACACIA_LOG,   3);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.BIRCH_FENCE,          Items.BIRCH_LOG,             3);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.BIRCH_FENCE,          Items.STRIPPED_BIRCH_LOG,    3);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.CHERRY_FENCE,         Items.CHERRY_LOG,            3);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.CHERRY_FENCE,         Items.STRIPPED_CHERRY_LOG,   3);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.DARK_OAK_FENCE,       Items.DARK_OAK_LOG,          3);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.DARK_OAK_FENCE,       Items.STRIPPED_DARK_OAK_LOG, 3);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.MANGROVE_FENCE,       Items.MANGROVE_LOG,          3);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.MANGROVE_FENCE,       Items.STRIPPED_MANGROVE_LOG, 3);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.JUNGLE_FENCE,         Items.JUNGLE_LOG,            3);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.JUNGLE_FENCE,         Items.STRIPPED_JUNGLE_LOG,   3);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.OAK_FENCE,            Items.OAK_LOG,               3);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.OAK_FENCE,            Items.STRIPPED_OAK_LOG,      3);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.SPRUCE_FENCE,         Items.SPRUCE_LOG,            3);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.SPRUCE_FENCE,         Items.STRIPPED_SPRUCE_LOG,   3);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.CRIMSON_FENCE,        Items.CRIMSON_STEM,          3);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.CRIMSON_FENCE,        Items.STRIPPED_CRIMSON_STEM, 3);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.WARPED_FENCE,         Items.WARPED_STEM,           3);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.WARPED_FENCE,         Items.STRIPPED_WARPED_STEM,  3);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.BAMBOO_FENCE,         Items.BAMBOO_BLOCK,          1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.BAMBOO_FENCE,         Items.STRIPPED_BAMBOO_BLOCK, 1);

        //原木切栅栏门
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.ACACIA_FENCE_GATE,    Items.ACACIA_LOG,            1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.ACACIA_FENCE_GATE,    Items.STRIPPED_ACACIA_LOG,   1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.BIRCH_FENCE_GATE,     Items.BIRCH_LOG,             1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.BIRCH_FENCE_GATE,     Items.STRIPPED_BIRCH_LOG,    1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.CHERRY_FENCE_GATE,    Items.CHERRY_LOG,            1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.CHERRY_FENCE_GATE,    Items.STRIPPED_CHERRY_LOG,   1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.DARK_OAK_FENCE_GATE,  Items.DARK_OAK_LOG,          1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.DARK_OAK_FENCE_GATE,  Items.STRIPPED_DARK_OAK_LOG, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.MANGROVE_FENCE_GATE,  Items.MANGROVE_LOG,          1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.MANGROVE_FENCE_GATE,  Items.STRIPPED_MANGROVE_LOG, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.JUNGLE_FENCE_GATE,    Items.JUNGLE_LOG,            1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.JUNGLE_FENCE_GATE,    Items.STRIPPED_JUNGLE_LOG,   1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.OAK_FENCE_GATE,       Items.OAK_LOG,               1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.OAK_FENCE_GATE,       Items.STRIPPED_OAK_LOG,      1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.SPRUCE_FENCE_GATE,    Items.SPRUCE_LOG,            1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.SPRUCE_FENCE_GATE,    Items.STRIPPED_SPRUCE_LOG,   1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.CRIMSON_FENCE_GATE,   Items.CRIMSON_STEM,          1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.CRIMSON_FENCE_GATE,   Items.STRIPPED_CRIMSON_STEM, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.WARPED_FENCE_GATE,    Items.WARPED_STEM,           1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.WARPED_FENCE_GATE,    Items.STRIPPED_WARPED_STEM,  1);

        //原木切告示牌（略微增产）
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.ACACIA_SIGN,          Items.ACACIA_LOG,            2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.ACACIA_SIGN,          Items.STRIPPED_ACACIA_LOG,   2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.BIRCH_SIGN,           Items.BIRCH_LOG,             2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.BIRCH_SIGN,           Items.STRIPPED_BIRCH_LOG,    2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.CHERRY_SIGN,          Items.CHERRY_LOG,            2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.CHERRY_SIGN,          Items.STRIPPED_CHERRY_LOG,   2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.DARK_OAK_SIGN,        Items.DARK_OAK_LOG,          2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.DARK_OAK_SIGN,        Items.STRIPPED_DARK_OAK_LOG, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.MANGROVE_SIGN,        Items.MANGROVE_LOG,          2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.MANGROVE_SIGN,        Items.STRIPPED_MANGROVE_LOG, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.JUNGLE_SIGN,          Items.JUNGLE_LOG,            2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.JUNGLE_SIGN,          Items.STRIPPED_JUNGLE_LOG,   2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.OAK_SIGN,             Items.OAK_LOG,               2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.OAK_SIGN,             Items.STRIPPED_OAK_LOG,      2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.SPRUCE_SIGN,          Items.SPRUCE_LOG,            2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.SPRUCE_SIGN,          Items.STRIPPED_SPRUCE_LOG,   2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.CRIMSON_SIGN,         Items.CRIMSON_STEM,          2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.CRIMSON_SIGN,         Items.STRIPPED_CRIMSON_STEM, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.WARPED_SIGN,          Items.WARPED_STEM,           2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.WARPED_SIGN,          Items.STRIPPED_WARPED_STEM,  2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.BAMBOO_SIGN,          Items.BAMBOO_BLOCK,          1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.BAMBOO_SIGN,          Items.STRIPPED_BAMBOO_BLOCK, 1);

        //原木合成台阶（如果增加建筑方块的话可能要考虑删除）
        offerSlabLikeRecipe    (exporter, RecipeCategory.BUILDING_BLOCKS, ItemTags.ACACIA_LOGS,       Items.ACACIA_SLAB,           24, "acacia_logs");
        offerSlabLikeRecipe    (exporter, RecipeCategory.BUILDING_BLOCKS, ItemTags.BIRCH_LOGS,        Items.BIRCH_SLAB,            24, "birch_logs");
        offerSlabLikeRecipe    (exporter, RecipeCategory.BUILDING_BLOCKS, ItemTags.CHERRY_LOGS,       Items.CHERRY_SLAB,           24, "cherry_logs");
        offerSlabLikeRecipe    (exporter, RecipeCategory.BUILDING_BLOCKS, ItemTags.DARK_OAK_LOGS,     Items.DARK_OAK_SLAB,         24, "dark_oak_logs");
        offerSlabLikeRecipe    (exporter, RecipeCategory.BUILDING_BLOCKS, ItemTags.MANGROVE_LOGS,     Items.MANGROVE_SLAB,         24, "mangrove_logs");
        offerSlabLikeRecipe    (exporter, RecipeCategory.BUILDING_BLOCKS, ItemTags.JUNGLE_LOGS,       Items.JUNGLE_SLAB,           24, "jungle_logs");
        offerSlabLikeRecipe    (exporter, RecipeCategory.BUILDING_BLOCKS, ItemTags.OAK_LOGS,          Items.OAK_SLAB,              24, "oak_logs");
        offerSlabLikeRecipe    (exporter, RecipeCategory.BUILDING_BLOCKS, ItemTags.SPRUCE_LOGS,       Items.SPRUCE_SLAB,           24, "spruce_logs");
        offerSlabLikeRecipe    (exporter, RecipeCategory.BUILDING_BLOCKS, ItemTags.CRIMSON_STEMS,     Items.CRIMSON_SLAB,          24, "spruce_logs");
        offerSlabLikeRecipe    (exporter, RecipeCategory.BUILDING_BLOCKS, ItemTags.WARPED_STEMS,      Items.WARPED_SLAB,           24, "spruce_logs");
        offerSlabLikeRecipe    (exporter, RecipeCategory.BUILDING_BLOCKS, ItemTags.BAMBOO_BLOCKS,     Items.BAMBOO_SLAB,           12, "bamboo_block");
        offerSlabLikeRecipe    (exporter, RecipeCategory.BUILDING_BLOCKS, Items.BAMBOO_MOSAIC,        Items.BAMBOO_SLAB,           12);

        //原木合成活板门
        offerTrapdoorLikeRecipe(exporter, RecipeCategory.MISC,            ItemTags.ACACIA_LOGS,       Items.ACACIA_TRAPDOOR,       8, "acacia_logs");
        offerTrapdoorLikeRecipe(exporter, RecipeCategory.MISC,            ItemTags.BIRCH_LOGS,        Items.BIRCH_TRAPDOOR,        8, "birch_logs");
        offerTrapdoorLikeRecipe(exporter, RecipeCategory.MISC,            ItemTags.CHERRY_LOGS,       Items.CHERRY_TRAPDOOR,       8, "cherry_logs");
        offerTrapdoorLikeRecipe(exporter, RecipeCategory.MISC,            ItemTags.DARK_OAK_LOGS,     Items.DARK_OAK_TRAPDOOR,     8, "dark_oak_logs");
        offerTrapdoorLikeRecipe(exporter, RecipeCategory.MISC,            ItemTags.MANGROVE_LOGS,     Items.MANGROVE_TRAPDOOR,     8, "mangrove_logs");
        offerTrapdoorLikeRecipe(exporter, RecipeCategory.MISC,            ItemTags.JUNGLE_LOGS,       Items.JUNGLE_TRAPDOOR,       8, "jungle_logs");
        offerTrapdoorLikeRecipe(exporter, RecipeCategory.MISC,            ItemTags.OAK_LOGS,          Items.OAK_TRAPDOOR,          8, "oak_logs");
        offerTrapdoorLikeRecipe(exporter, RecipeCategory.MISC,            ItemTags.SPRUCE_LOGS,       Items.SPRUCE_TRAPDOOR,       8, "spruce_logs");
        offerTrapdoorLikeRecipe(exporter, RecipeCategory.MISC,            ItemTags.CRIMSON_STEMS,     Items.CRIMSON_TRAPDOOR,      8, "spruce_logs");
        offerTrapdoorLikeRecipe(exporter, RecipeCategory.MISC,            ItemTags.WARPED_STEMS,      Items.WARPED_TRAPDOOR,       8, "spruce_logs");
        offerTrapdoorLikeRecipe(exporter, RecipeCategory.MISC,            ItemTags.BAMBOO_BLOCKS,     Items.BAMBOO_TRAPDOOR,       8, "bamboo_block");
        offerTrapdoorLikeRecipe(exporter, RecipeCategory.MISC,            Items.COPPER_BLOCK,         Items.COPPER_TRAPDOOR,       18);

        //切铁链与铁栅栏（铁链略微增产）
        offerStonecuttingRecipe(exporter, RecipeCategory.MISC,            Items.CHAIN,                Items.IRON_BLOCK,            8);
        offerStonecuttingRecipe(exporter, RecipeCategory.MISC,            Items.IRON_BARS,            Items.IRON_BLOCK,            24);

        //发射器快捷合成（基于弓与投掷器）
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.DISPENSER, 1)
                .input(Items.DROPPER)
                .input(Items.BOW)
                .criterion(hasItem(Items.DROPPER),conditionsFromItem(Items.DROPPER))
                .criterion(hasItem(Items.BOW),conditionsFromItem(Items.BOW))
                .offerTo(exporter,Identifier.of(VanillaAddition.MOD_ID,"dispenser_from_bow"));

        //发射器快捷合成（基于弓的原料）
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.DISPENSER, 1)
                .pattern(" *o")
                .pattern("*#o")
                .pattern(" *o")
                .input('#',Items.DROPPER)
                .input('*',Items.STICK)
                .input('o',Items.STRING)
                .criterion(hasItem(Items.DROPPER),conditionsFromItem(Items.DROPPER))
                .offerTo(exporter,Identifier.of(VanillaAddition.MOD_ID,"dispenser_from_bow_material"));

    }


}

