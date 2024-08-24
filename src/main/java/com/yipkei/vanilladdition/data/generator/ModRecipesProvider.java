package com.yipkei.vanilladdition.data.generator;

import com.yipkei.vanilladdition.VanillaAddition;
import com.yipkei.vanilladdition.helper.ModCustomRecipeHelper;
import com.yipkei.vanilladdition.init.ModBlocks;
import com.yipkei.vanilladdition.init.ModItems;
import com.yipkei.vanilladdition.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.*;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static com.yipkei.vanilladdition.helper.ModCustomRecipeHelper.*;

public class ModRecipesProvider extends FabricRecipeProvider {
    private final CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture;
    private static final List<ItemConvertible> STEEL_MATERIAL_LIST = List.of(Items.IRON_INGOT);

    public ModRecipesProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
        this.completableFuture = registriesFuture;
    }

    @Override
    public void generate(RecipeExporter exporter) {
        RegistryWrapper.WrapperLookup registryLookup = null;
        try {
            registryLookup = this.completableFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        RegistryWrapper.Impl<Enchantment> impl = registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);

        /* 可逆压实 */
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.STEEL_INGOT, RecipeCategory.BUILDING_BLOCKS, ModBlocks.STEEL_BLOCK);

        offerReversible2x2CompactingRecipes(exporter,RecipeCategory.MISC,ModItems.DIAMOND_SHARD, ModItems.DIAMOND_SHARD_STACK);

        /* 压缩羊毛 */
        offerChestLikeRecipe(exporter,RecipeCategory.MISC,Items.WHITE_WOOL,Items.STRING,ModBlocks.COMPRESS_WOOL,1);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.WHITE_WOOL, 8)
                .input(ModBlocks.COMPRESS_WOOL)
                .input(ModTags.Items.SHEARS)
                .criterion(hasItem(ModBlocks.COMPRESS_WOOL),conditionsFromItem(ModBlocks.COMPRESS_WOOL))
                .offerTo(exporter,Identifier.of(VanillaAddition.MOD_ID,"compress_wool_unzip"));

        /* 原版烧炼配方 */
        offerSmelting(exporter,STEEL_MATERIAL_LIST,RecipeCategory.MISC,ModItems.STEEL_INGOT, 1.0f,1000,"steel_ingot");
        offerBlasting(exporter,STEEL_MATERIAL_LIST,RecipeCategory.MISC,ModItems.STEEL_INGOT, 1.0f,400,"steel_ingot");

        offerCookingDefault(exporter,200,Items.ROTTEN_FLESH,ModItems.ROASTED_ROTTEN_FLESH,0.8f);

        /* 工具与装备合成配方 */

        offerEnchantedToolRecipe(exporter, ModItems.STEEL_INGOT, Items.STICK, impl.getOrThrow(Enchantments.UNBREAKING), 1, "steel");
        offerEnchantedArmorRecipe(exporter, ModItems.STEEL_INGOT, impl.getOrThrow(Enchantments.UNBREAKING), 1, "steel");

        offerPickaxeRecipe (exporter, Items.GLASS_PANE,     Items.STICK, ModItems.GLASS_PICKAXE_PROTOTYPE, "glass");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.STEEL_SHEARS, 1)
                .pattern(" #")
                .pattern("# ")
                .input('#',ModItems.STEEL_INGOT)
                .criterion(hasItem(ModItems.STEEL_INGOT),conditionsFromItem(ModItems.STEEL_INGOT))
                .offerTo(exporter,Identifier.of(VanillaAddition.MOD_ID,"steel_shears"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DIAMOND_FLINT, 1)
                .pattern("#*")
                .input('#',ModItems.STEEL_INGOT)
                .input('*',ModItems.DIAMOND_SHARD)
                .criterion(hasItem(ModItems.STEEL_INGOT),conditionsFromItem(ModItems.STEEL_INGOT))
                .criterion(hasItem(ModItems.DIAMOND_SHARD),conditionsFromItem(ModItems.DIAMOND_SHARD))
                .offerTo(exporter,Identifier.of(VanillaAddition.MOD_ID,"diamond_flint"));
        
        /* 消耗类工具合成配方及其处理配方*/
        offerTorchLikeRecipe (exporter, RecipeCategory.TOOLS, Items.COBBLESTONE,      Items.STICK,          ModItems.STONE_HAMMER,   1, "stone_hammer");
        offerTorchLikeRecipe (exporter, RecipeCategory.TOOLS, Items.IRON_INGOT,       Items.STICK,          ModItems.IRON_HAMMER,    1, "iron_hammer");
        offerTorchLikeRecipe (exporter, RecipeCategory.TOOLS, ModItems.DIAMOND_SHARD, ModItems.IRON_HAMMER, ModItems.DIAMOND_HAMMER, 1, "diamond_hammer");
        offerTorchLikeRecipe (exporter, RecipeCategory.TOOLS, ModItems.DIAMOND_SHARD, Items.STICK,          ModItems.DIAMOND_GRAVER, 1, "diamond_graver");

        offerHammerProcessing(exporter,Items.DIAMOND,             ModItems.STONE_HAMMER, ModItems.DIAMOND_SHARD, 3, "processing");
        offerHammerProcessing(exporter,Items.DIAMOND_SWORD,       ModItems.STONE_HAMMER, ModItems.DIAMOND_SHARD, 2, "recycling");
        offerHammerProcessing(exporter,Items.DIAMOND_SHOVEL,      ModItems.STONE_HAMMER, ModItems.DIAMOND_SHARD, 1, "recycling");
        offerHammerProcessing(exporter,Items.DIAMOND_PICKAXE,     ModItems.STONE_HAMMER, ModItems.DIAMOND_SHARD, 3, "recycling");
        offerHammerProcessing(exporter,Items.DIAMOND_AXE,         ModItems.STONE_HAMMER, ModItems.DIAMOND_SHARD, 3, "recycling");
        offerHammerProcessing(exporter,Items.DIAMOND_HOE,         ModItems.STONE_HAMMER, ModItems.DIAMOND_SHARD, 2, "recycling");
        offerHammerProcessing(exporter,Items.DIAMOND_HELMET,      ModItems.STONE_HAMMER, ModItems.DIAMOND_SHARD, 5, "recycling");
        offerHammerProcessing(exporter,Items.DIAMOND_CHESTPLATE,  ModItems.STONE_HAMMER, ModItems.DIAMOND_SHARD, 8, "recycling");
        offerHammerProcessing(exporter,Items.DIAMOND_LEGGINGS,    ModItems.STONE_HAMMER, ModItems.DIAMOND_SHARD, 7, "recycling");
        offerHammerProcessing(exporter,Items.DIAMOND_BOOTS,       ModItems.STONE_HAMMER, ModItems.DIAMOND_SHARD, 4, "recycling");
        offerHammerProcessing(exporter,Items.DIAMOND_HORSE_ARMOR, ModItems.STONE_HAMMER, ModItems.DIAMOND_SHARD, 5, "recycling");

        offerHammerProcessing(exporter,Items.DIAMOND,             ModItems.IRON_HAMMER,  ModItems.DIAMOND_SHARD, 3, "processing");
        offerHammerProcessing(exporter,Items.DIAMOND_SWORD,       ModItems.IRON_HAMMER,  ModItems.DIAMOND_SHARD, 2, "recycling");
        offerHammerProcessing(exporter,Items.DIAMOND_SHOVEL,      ModItems.IRON_HAMMER,  ModItems.DIAMOND_SHARD, 1, "recycling");
        offerHammerProcessing(exporter,Items.DIAMOND_PICKAXE,     ModItems.IRON_HAMMER,  ModItems.DIAMOND_SHARD, 3, "recycling");
        offerHammerProcessing(exporter,Items.DIAMOND_AXE,         ModItems.IRON_HAMMER,  ModItems.DIAMOND_SHARD, 3, "recycling");
        offerHammerProcessing(exporter,Items.DIAMOND_HOE,         ModItems.IRON_HAMMER,  ModItems.DIAMOND_SHARD, 2, "recycling");
        offerHammerProcessing(exporter,Items.DIAMOND_HELMET,      ModItems.IRON_HAMMER,  ModItems.DIAMOND_SHARD, 5, "recycling");
        offerHammerProcessing(exporter,Items.DIAMOND_CHESTPLATE,  ModItems.IRON_HAMMER,  ModItems.DIAMOND_SHARD, 8, "recycling");
        offerHammerProcessing(exporter,Items.DIAMOND_LEGGINGS,    ModItems.IRON_HAMMER,  ModItems.DIAMOND_SHARD, 7, "recycling");
        offerHammerProcessing(exporter,Items.DIAMOND_BOOTS,       ModItems.IRON_HAMMER,  ModItems.DIAMOND_SHARD, 4, "recycling");
        offerHammerProcessing(exporter,Items.DIAMOND_HORSE_ARMOR, ModItems.IRON_HAMMER,  ModItems.DIAMOND_SHARD, 5, "recycling");

        offerHammerProcessing(exporter,Items.DIAMOND,             ModItems.DIAMOND_HAMMER,  ModItems.DIAMOND_SHARD, 3, "processing");
        offerHammerProcessing(exporter,Items.DIAMOND_SWORD,       ModItems.DIAMOND_HAMMER,  ModItems.DIAMOND_SHARD, 2, "recycling");
        offerHammerProcessing(exporter,Items.DIAMOND_SHOVEL,      ModItems.DIAMOND_HAMMER,  ModItems.DIAMOND_SHARD, 1, "recycling");
        offerHammerProcessing(exporter,Items.DIAMOND_PICKAXE,     ModItems.DIAMOND_HAMMER,  ModItems.DIAMOND_SHARD, 3, "recycling");
        offerHammerProcessing(exporter,Items.DIAMOND_AXE,         ModItems.DIAMOND_HAMMER,  ModItems.DIAMOND_SHARD, 3, "recycling");
        offerHammerProcessing(exporter,Items.DIAMOND_HOE,         ModItems.DIAMOND_HAMMER,  ModItems.DIAMOND_SHARD, 2, "recycling");
        offerHammerProcessing(exporter,Items.DIAMOND_HELMET,      ModItems.DIAMOND_HAMMER,  ModItems.DIAMOND_SHARD, 5, "recycling");
        offerHammerProcessing(exporter,Items.DIAMOND_CHESTPLATE,  ModItems.DIAMOND_HAMMER,  ModItems.DIAMOND_SHARD, 8, "recycling");
        offerHammerProcessing(exporter,Items.DIAMOND_LEGGINGS,    ModItems.DIAMOND_HAMMER,  ModItems.DIAMOND_SHARD, 7, "recycling");
        offerHammerProcessing(exporter,Items.DIAMOND_BOOTS,       ModItems.DIAMOND_HAMMER,  ModItems.DIAMOND_SHARD, 4, "recycling");
        offerHammerProcessing(exporter,Items.DIAMOND_HORSE_ARMOR, ModItems.DIAMOND_HAMMER,  ModItems.DIAMOND_SHARD, 5, "recycling");

        // 石英块拆解
        offerHammerProcessing(exporter,ModTags.Items.QUARTZ_BLOCK,ModItems.DIAMOND_HAMMER,  Items.QUARTZ,           3,"recycling");

        // 信标基座
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.LIGHT_BEACON_BASE, 8)
                .pattern("#*#")
                .pattern("*o*")
                .pattern("#*#")
                .input('#', ModBlocks.STEEL_BLOCK)
                .input('*', Items.NETHERITE_SCRAP)
                .input('o', Items.NETHER_STAR)
                .criterion(hasItem(Items.NETHER_STAR), conditionsFromItem(Items.NETHER_STAR))
                .offerTo(exporter, Identifier.of(VanillaAddition.MOD_ID, getItemPath(ModBlocks.LIGHT_BEACON_BASE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.PORTABLE_BEACON_BASE)
                .pattern("ENE")
                .pattern("GBG")
                .pattern("III")
                .input('E', Blocks.EMERALD_BLOCK)
                .input('N', Items.NETHERITE_INGOT)
                .input('G', Blocks.GOLD_BLOCK)
                .input('B', Blocks.BEACON)
                .input('I', Blocks.IRON_BLOCK)
                .criterion(hasItem(Blocks.BEACON), conditionsFromItem(Blocks.BEACON))
                .offerTo(exporter, Identifier.of(VanillaAddition.MOD_ID, getItemPath(ModBlocks.PORTABLE_BEACON_BASE)));

        /* 锻造台配方 */
        // 潮涌核心拆解
        offerUpgradeRecipe(exporter, ModItems.PRESSURE_CRAFTING_TEMPLATE, Items.HEART_OF_THE_SEA, ModItems.DIAMOND_HAMMER, RecipeCategory.MISC, ModItems.CONDUIT_SHARD, 8);

        // 工具加工
        offerEnchantedUpgradeRecipe(exporter, ModItems.DIAMOND_SHARDS_UPGRADED_SMITHING_TEMPLATE, ModItems.STEEL_PICKAXE,  ModItems.DIAMOND_SHARD, RecipeCategory.TOOLS,  ModItems.DIAMOND_UPGRADED_PICKAXE, impl.getOrThrow(Enchantments.UNBREAKING), 3);
        offerEnchantedUpgradeRecipe(exporter, ModItems.DIAMOND_SHARDS_UPGRADED_SMITHING_TEMPLATE, ModItems.STEEL_AXE,      ModItems.DIAMOND_SHARD, RecipeCategory.TOOLS,  ModItems.DIAMOND_UPGRADED_AXE, impl.getOrThrow(Enchantments.UNBREAKING), 3);
        offerUpgradeRecipe(exporter, ModItems.NETHER_SMITHING_TEMPLATE_PRO,              Items.NETHERITE_PICKAXE, Items.HEAVY_CORE,     RecipeCategory.COMBAT, ModItems.DESTROYER_PICKAXE);
        offerUpgradeRecipe(exporter, ModItems.DIAMOND_SHARDS_UPGRADED_SMITHING_TEMPLATE, ModItems.GLASS_PICKAXE_PROTOTYPE, ModItems.DIAMOND_SHARD, RecipeCategory.TOOLS, ModItems.GLASS_PICKAXE);

        // 仙女棒
        offerUpgradeRecipe(exporter, ModItems.HEAD_COPY_TEMPLATE,                        Items.BREEZE_ROD,        Items.DRAGON_BREATH,  RecipeCategory.MISC,   ModItems.DEEP_DARK_FANTASY);
        offerUpgradeRecipe(exporter, ModItems.HEAD_COPY_TEMPLATE,                        Items.BLAZE_ROD,         Items.GUNPOWDER,      RecipeCategory.MISC,   ModItems.EXPLOSION_CREATOR);
        offerUpgradeRecipe(exporter, ModItems.HEAD_COPY_TEMPLATE,                        Items.END_ROD,           Items.ENCHANTED_GOLDEN_APPLE, RecipeCategory.MISC, ModItems.NOTHING_TO_BE_AFRAID_OF);

        // 宝藏再生
        offerUpgradeRecipe(exporter, ModItems.PRESSURE_CRAFTING_TEMPLATE,      ModItems.DIAMOND_PROTOTYPE,    Items.FLINT_AND_STEEL,        RecipeCategory.MISC, Items.DIAMOND, 4);
        offerUpgradeRecipe(exporter, ModItems.PRESSURE_CRAFTING_TEMPLATE,      ModItems.DIAMOND_PROTOTYPE,    ModItems.DIAMOND_FLINT,        RecipeCategory.MISC, Items.DIAMOND, 4);

        offerUpgradeRecipe(exporter, ModItems.NETHER_SMITHING_TEMPLATE,        ModItems.ANCIENT_PROTOTYPE,    ModItems.ANCIENT_TEAR,    RecipeCategory.MISC, Items.ANCIENT_DEBRIS);
        offerUpgradeRecipe(exporter, ModItems.NETHER_SMITHING_TEMPLATE,        ModItems.SUSPICIOUS_PROTOTYPE, ModItems.ANCIENT_TEAR,    RecipeCategory.MISC, Items.ANCIENT_DEBRIS);
        offerUpgradeRecipe(exporter, ModItems.NETHER_SMITHING_TEMPLATE_PRO,    ModItems.HEAVY_CORE_PROTOTYPE, Items.WIND_CHARGE,        RecipeCategory.MISC, Items.HEAVY_CORE);
        offerUpgradeRecipe(exporter, ModItems.NETHER_SMITHING_TEMPLATE_PRO,    ModItems.PULSE_OF_THE_SEA,     Items.NAUTILUS_SHELL,     RecipeCategory.MISC, Items.HEART_OF_THE_SEA);
        offerUpgradeRecipe(exporter, ModItems.ELYTRA_COPY_TEMPLATE,            ModItems.ELYTRA_PROTOTYPE,     Items.SADDLE,             RecipeCategory.MISC, Items.ELYTRA, 1, 431);
        offerUpgradeRecipe(exporter, ModItems.ENCHANTED_GOLDEN_APPLE_TEMPLATE, Items.GOLDEN_APPLE,            Items.EXPERIENCE_BOTTLE,  RecipeCategory.MISC, Items.ENCHANTED_GOLDEN_APPLE);
        offerUpgradeRecipe(exporter, ModItems.TOTEM_OF_UNDYING_COPY_TEMPLATE,  Items.DIAMOND,                 Items.LAPIS_LAZULI,       RecipeCategory.MISC, Items.TOTEM_OF_UNDYING);

        // 马铠再生
        offerUpgradeRecipe(exporter, ModItems.IRON_HORSE_ARMOR_BLUEPRINT,      Items.LEATHER_HORSE_ARMOR,     Items.IRON_BLOCK,         RecipeCategory.MISC, Items.IRON_HORSE_ARMOR);
        offerUpgradeRecipe(exporter, ModItems.GOLDEN_HORSE_ARMOR_BLUEPRINT,    Items.LEATHER_HORSE_ARMOR,     Items.GOLD_BLOCK,         RecipeCategory.MISC, Items.GOLDEN_HORSE_ARMOR);
        offerUpgradeRecipe(exporter, ModItems.DIAMOND_HORSE_ARMOR_BLUEPRINT,   Items.LEATHER_HORSE_ARMOR,     Items.DIAMOND_BLOCK,      RecipeCategory.MISC, Items.DIAMOND_HORSE_ARMOR);
        

        /* 简易再生 */
        offerChestLikeRecipe(exporter,RecipeCategory.MISC,Items.YELLOW_WOOL,   ModItems.CONDUIT_SHARD,Items.SPONGE,            8);
        offerChestLikeRecipe(exporter,RecipeCategory.MISC,Items.BRAIN_CORAL,   ModItems.CONDUIT_SHARD,Items.BRAIN_CORAL_BLOCK, 1);
        offerChestLikeRecipe(exporter,RecipeCategory.MISC,Items.BUBBLE_CORAL,  ModItems.CONDUIT_SHARD,Items.BUBBLE_CORAL_BLOCK,1);
        offerChestLikeRecipe(exporter,RecipeCategory.MISC,Items.FIRE_CORAL,    ModItems.CONDUIT_SHARD,Items.FIRE_CORAL_BLOCK,  1);
        offerChestLikeRecipe(exporter,RecipeCategory.MISC,Items.HORN_CORAL,    ModItems.CONDUIT_SHARD,Items.HORN_CORAL_BLOCK,  1);
        offerChestLikeRecipe(exporter,RecipeCategory.MISC,Items.TUBE_CORAL,    ModItems.CONDUIT_SHARD,Items.TUBE_CORAL_BLOCK,  1);
        offerChestLikeRecipe(exporter,RecipeCategory.MISC,Items.AMETHYST_SHARD,ModItems.ANCIENT_TEAR, Items.ECHO_SHARD,        8);

        /* 原型合成 */
//        offerChestLikeRecipe(exporter,RecipeCategory.MISC,ModItems.DIAMOND_SHARD_STACK,Items.COAL_BLOCK,ModItems.DIAMOND_PROTOTYPE,1);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.DIAMOND_PROTOTYPE,1)
                .pattern("#*#")
                .pattern("*o*")
                .pattern("#*#")
                .input('#',ModItems.DIAMOND_SHARD_STACK)
                .input('*',Items.COAL_BLOCK)
                .input('o',Items.END_CRYSTAL)
                .criterion(hasItem(ModItems.DIAMOND_SHARD_STACK),conditionsFromItem(ModItems.DIAMOND_SHARD_STACK))
                .criterion(hasItem(Items.END_CRYSTAL),conditionsFromItem(Items.END_CRYSTAL))
                .offerTo(exporter,Identifier.of(VanillaAddition.MOD_ID,"diamond_prototype_from_diamond_stack"));


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

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.PULSE_OF_THE_SEA,1)
                .pattern("#*#")
                .pattern("*o*")
                .pattern("#*#")
                .input('#',Items.PRISMARINE_CRYSTALS)
                .input('*',ModItems.CONDUIT_SHARD)
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
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ENCHANTED_GOLDEN_APPLE_TEMPLATE,1)
                .pattern("###")
                .pattern("#*#")
                .pattern("###")
                .input('#', Items.NETHERITE_INGOT)
                .input('*', Items.ENCHANTED_GOLDEN_APPLE)
                .criterion(hasItem(Items.ENCHANTED_GOLDEN_APPLE),conditionsFromItem(Items.ENCHANTED_GOLDEN_APPLE))
                .offerTo(exporter,Identifier.of(VanillaAddition.MOD_ID,"enchanted_golden_apple_copy_template_from_itself"));

        // 金苹果仿制模板 - 复制
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ENCHANTED_GOLDEN_APPLE_TEMPLATE,4)
                .pattern("###")
                .pattern("#*#")
                .pattern("###")
                .input('#', Items.GOLD_BLOCK)
                .input('*',ModItems.ENCHANTED_GOLDEN_APPLE_TEMPLATE)
                .criterion(hasItem(ModItems.ENCHANTED_GOLDEN_APPLE_TEMPLATE),conditionsFromItem(ModItems.ENCHANTED_GOLDEN_APPLE_TEMPLATE))
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
        offerSherdCopy(exporter, Items.ANGLER_POTTERY_SHERD     );
        offerSherdCopy(exporter, Items.ARCHER_POTTERY_SHERD     );
        offerSherdCopy(exporter, Items.ARMS_UP_POTTERY_SHERD    );
        offerSherdCopy(exporter, Items.BLADE_POTTERY_SHERD      );
        offerSherdCopy(exporter, Items.BREWER_POTTERY_SHERD     );
        offerSherdCopy(exporter, Items.BURN_POTTERY_SHERD       );
        offerSherdCopy(exporter, Items.DANGER_POTTERY_SHERD     );
        offerSherdCopy(exporter, Items.EXPLORER_POTTERY_SHERD   );
        offerSherdCopy(exporter, Items.FRIEND_POTTERY_SHERD     );
        offerSherdCopy(exporter, Items.HEART_POTTERY_SHERD      );
        offerSherdCopy(exporter, Items.HEARTBREAK_POTTERY_SHERD );
        offerSherdCopy(exporter, Items.HOWL_POTTERY_SHERD       );
        offerSherdCopy(exporter, Items.MINER_POTTERY_SHERD      );
        offerSherdCopy(exporter, Items.MOURNER_POTTERY_SHERD    );
        offerSherdCopy(exporter, Items.PLENTY_POTTERY_SHERD     );
        offerSherdCopy(exporter, Items.PRIZE_POTTERY_SHERD      );
        offerSherdCopy(exporter, Items.SHEAF_POTTERY_SHERD      );
        offerSherdCopy(exporter, Items.SHELTER_POTTERY_SHERD    );
        offerSherdCopy(exporter, Items.SKULL_POTTERY_SHERD      );
        offerSherdCopy(exporter, Items.SNORT_POTTERY_SHERD      );
        offerSherdCopy(exporter, Items.FLOW_POTTERY_SHERD       );
        offerSherdCopy(exporter, Items.GUSTER_POTTERY_SHERD     );
        offerSherdCopy(exporter, Items.SCRAPE_POTTERY_SHERD     );

        /* 唱片复制 */
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GLASS_DISC, 4)
                .pattern(" # ")
                .pattern("#*#")
                .pattern(" # ")
                .input('#', Items.ECHO_SHARD)
                .input('*', Items.GLASS)
                .criterion(hasItem(Items.ECHO_SHARD), conditionsFromItem(Items.ECHO_SHARD))
                .offerTo(exporter, Identifier.of(VanillaAddition.MOD_ID, ModCustomRecipeHelper.convertBetween(ModItems.GLASS_DISC, Items.GLASS, Items.ECHO_SHARD)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.EMPTY_SHEET_MUSIC)
                .input(Items.PAPER)
                .input(Items.INK_SAC)
                .input(Items.FEATHER)
                .criterion(hasItem(Items.INK_SAC), conditionsFromItem(Items.INK_SAC))
                .offerTo(exporter, Identifier.of(VanillaAddition.MOD_ID, RecipeProvider.getItemPath(ModItems.EMPTY_SHEET_MUSIC)));

        offerDiscCopy(exporter, Items.MUSIC_DISC_13);
        offerDiscCopy(exporter, Items.MUSIC_DISC_CAT);
        offerDiscCopy(exporter, Items.MUSIC_DISC_BLOCKS);
        offerDiscCopy(exporter, Items.MUSIC_DISC_CHIRP);
        offerDiscCopy(exporter, Items.MUSIC_DISC_CREATOR);
        offerDiscCopy(exporter, Items.MUSIC_DISC_CREATOR_MUSIC_BOX);
        offerDiscCopy(exporter, Items.MUSIC_DISC_FAR);
        offerDiscCopy(exporter, Items.MUSIC_DISC_MALL);
        offerDiscCopy(exporter, Items.MUSIC_DISC_MELLOHI);
        offerDiscCopy(exporter, Items.MUSIC_DISC_STAL);
        offerDiscCopy(exporter, Items.MUSIC_DISC_STRAD);
        offerDiscCopy(exporter, Items.MUSIC_DISC_WARD);
        offerDiscCopy(exporter, Items.MUSIC_DISC_11);
        offerDiscCopy(exporter, Items.MUSIC_DISC_WAIT);
        offerDiscCopy(exporter, Items.MUSIC_DISC_OTHERSIDE);
        offerDiscCopy(exporter, Items.MUSIC_DISC_RELIC);
        offerDiscCopy(exporter, Items.MUSIC_DISC_5);
        offerDiscCopy(exporter, Items.MUSIC_DISC_PIGSTEP);
        offerDiscCopy(exporter, Items.MUSIC_DISC_PRECIPICE);

        /* 建筑方块拓展配方 */
        // 仅缺墙
        offerDefaultWallRecipe  (exporter, Blocks.STONE);
        offerDefaultWallRecipe  (exporter, Blocks.POLISHED_GRANITE);
        offerDefaultWallRecipe  (exporter, Blocks.POLISHED_DIORITE);
        offerDefaultWallRecipe  (exporter, Blocks.POLISHED_ANDESITE);
        offerDefaultWallRecipe  (exporter, Blocks.SMOOTH_SANDSTONE);
        offerDefaultWallRecipe  (exporter, Blocks.SMOOTH_RED_SANDSTONE);
        offerDefaultWallRecipe  (exporter, Blocks.PRISMARINE_BRICKS);
        offerDefaultWallRecipe  (exporter, Blocks.DARK_PRISMARINE);
        offerDefaultWallRecipe  (exporter, Blocks.SMOOTH_QUARTZ);

        offerDefaultWallRecipe  (exporter, Blocks.PURPUR_BLOCK,     ModBlocks.PURPUR_WALL);
        offerDefaultWallRecipe  (exporter, Blocks.QUARTZ_BLOCK,     ModBlocks.QUARTZ_WALL);

        // 缺墙与台阶
        offerDefaultWallRecipe  (exporter, Blocks.SMOOTH_STONE);
        offerDefaultStairsRecipe(exporter, Blocks.SMOOTH_STONE);


        // 三种都缺
        offerDefaultDecorateRecipe(exporter, Blocks.DIRT                  );
        offerDefaultDecorateRecipe(exporter, Blocks.MUD                   );
        offerDefaultDecorateRecipe(exporter, Blocks.CLAY                  );
        offerDefaultDecorateRecipe(exporter, Blocks.CALCITE               );
        offerDefaultDecorateRecipe(exporter, Blocks.OBSIDIAN              );
        offerDefaultDecorateRecipe(exporter, Blocks.CRYING_OBSIDIAN       );
        offerDefaultDecorateRecipe(exporter, Blocks.NETHERRACK            );
        offerDefaultDecorateRecipe(exporter, Blocks.BASALT                );
        offerDefaultDecorateRecipe(exporter, Blocks.SMOOTH_BASALT         );
        offerDefaultDecorateRecipe(exporter, Blocks.POLISHED_BASALT       );
        offerDefaultDecorateRecipe(exporter, Blocks.END_STONE             );
        offerDefaultDecorateRecipe(exporter, Blocks.GLOWSTONE             );
        offerDefaultDecorateRecipe(exporter, Blocks.ICE                   );
        offerDefaultDecorateRecipe(exporter, Blocks.PACKED_ICE            );
        offerDefaultDecorateRecipe(exporter, Blocks.BLUE_ICE              );
        offerDefaultDecorateRecipe(exporter, Blocks.WHITE_CONCRETE        );
        offerDefaultDecorateRecipe(exporter, Blocks.LIGHT_GRAY_CONCRETE   );
        offerDefaultDecorateRecipe(exporter, Blocks.GRAY_CONCRETE         );
        offerDefaultDecorateRecipe(exporter, Blocks.BLACK_CONCRETE        );
        offerDefaultDecorateRecipe(exporter, Blocks.BROWN_CONCRETE        );
        offerDefaultDecorateRecipe(exporter, Blocks.RED_CONCRETE          );
        offerDefaultDecorateRecipe(exporter, Blocks.ORANGE_CONCRETE       );
        offerDefaultDecorateRecipe(exporter, Blocks.YELLOW_CONCRETE       );
        offerDefaultDecorateRecipe(exporter, Blocks.LIME_CONCRETE         );
        offerDefaultDecorateRecipe(exporter, Blocks.GREEN_CONCRETE        );
        offerDefaultDecorateRecipe(exporter, Blocks.CYAN_CONCRETE         );
        offerDefaultDecorateRecipe(exporter, Blocks.LIGHT_BLUE_CONCRETE   );
        offerDefaultDecorateRecipe(exporter, Blocks.BLUE_CONCRETE         );
        offerDefaultDecorateRecipe(exporter, Blocks.PURPLE_CONCRETE       );
        offerDefaultDecorateRecipe(exporter, Blocks.MAGENTA_CONCRETE      );
        offerDefaultDecorateRecipe(exporter, Blocks.PINK_CONCRETE         );
        offerDefaultDecorateRecipe(exporter, Blocks.TERRACOTTA            );
        offerDefaultDecorateRecipe(exporter, Blocks.WHITE_TERRACOTTA      );
        offerDefaultDecorateRecipe(exporter, Blocks.LIGHT_GRAY_TERRACOTTA );
        offerDefaultDecorateRecipe(exporter, Blocks.GRAY_TERRACOTTA       );
        offerDefaultDecorateRecipe(exporter, Blocks.BLACK_TERRACOTTA      );
        offerDefaultDecorateRecipe(exporter, Blocks.BROWN_TERRACOTTA      );
        offerDefaultDecorateRecipe(exporter, Blocks.RED_TERRACOTTA        );
        offerDefaultDecorateRecipe(exporter, Blocks.ORANGE_TERRACOTTA     );
        offerDefaultDecorateRecipe(exporter, Blocks.YELLOW_TERRACOTTA     );
        offerDefaultDecorateRecipe(exporter, Blocks.LIME_TERRACOTTA       );
        offerDefaultDecorateRecipe(exporter, Blocks.GREEN_TERRACOTTA      );
        offerDefaultDecorateRecipe(exporter, Blocks.CYAN_TERRACOTTA       );
        offerDefaultDecorateRecipe(exporter, Blocks.LIGHT_BLUE_TERRACOTTA );
        offerDefaultDecorateRecipe(exporter, Blocks.BLUE_TERRACOTTA       );
        offerDefaultDecorateRecipe(exporter, Blocks.PURPLE_TERRACOTTA     );
        offerDefaultDecorateRecipe(exporter, Blocks.MAGENTA_TERRACOTTA    );
        offerDefaultDecorateRecipe(exporter, Blocks.PINK_TERRACOTTA       );

        offerDefaultWallRecipe  (exporter, Blocks.AMETHYST_BLOCK,      ModBlocks.AMETHYST_WALL);
        offerDefaultStairsRecipe(exporter, Blocks.AMETHYST_BLOCK,      ModBlocks.AMETHYST_STAIRS);
        offerDefaultSlabRecipe  (exporter, Blocks.AMETHYST_BLOCK,      ModBlocks.AMETHYST_SLAB);

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

