package com.yipkei.vanilladdition.init;

import com.yipkei.vanilladdition.VanillaAddition;
import com.yipkei.vanilladdition.custom.ModFoodComponents;
import com.yipkei.vanilladdition.custom.ModToolMaterials;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModItems {

    //食物
    public static final Item ROASTED_ROTTEN_FLESH = registerItems("roasted_rotten_flesh", new Item(new Item.Settings().food(ModFoodComponents.ROASTED_ROTTEN_FLESH)));

    //耗材
    public static final Item STONE_HAMMER = registerItems("stone_hammer", new Item(new Item.Settings()));
    public static final Item IRON_HAMMER = registerItems("iron_hammer", new Item(new Item.Settings()));
    public static final Item DIAMOND_HAMMER = registerItems("diamond_hammer", new Item((new Item.Settings())));

    //工具
    public static final Item STEEL_SWORD = registerItems("steel_sword", new SwordItem(ModToolMaterials.STEEL,(new Item.Settings()).attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.STEEL, 3, -2.4F))));
   public static final Item STEEL_SHOVEL = registerItems("steel_shovel", new ShovelItem(ModToolMaterials.STEEL,(new Item.Settings()).attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.STEEL,1.5f,-3.0f))));
    public static final Item STEEL_PICKAXE = registerItems("steel_pickaxe", new PickaxeItem(ModToolMaterials.STEEL,(new Item.Settings()).attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.STEEL,1,-2.8f))));
    public static final Item STEEL_AXE = registerItems("steel_axe", new AxeItem(ModToolMaterials.STEEL,(new Item.Settings()).attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.STEEL,6.0f,-3.1f))));
    public static final Item STEEL_HOE = registerItems("steel_hoe", new HoeItem(ModToolMaterials.STEEL,(new Item.Settings()).attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.STEEL,-2,-1.0f))));

    public static final Item DIAMOND_UPGRADED_PICKAXE = registerItems("diamond_upgraded_pickaxe", new PickaxeItem(ModToolMaterials.DIAMOND_SHARD,(new Item.Settings()).attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.DIAMOND_SHARD,1,-2.8f))));
    public static final Item DIAMOND_UPGRADED_AXE = registerItems("diamond_upgraded_axe", new AxeItem(ModToolMaterials.DIAMOND_SHARD,(new Item.Settings()).attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.DIAMOND_SHARD,6.0f,-3.1f))));

    public static final Item DIAMOND_FLINT = registerItems("diamond_flint", new FlintAndSteelItem(new Item.Settings().maxDamage(200)));
    public static final Item STEEL_SHEARS = registerItems("steel_shears", new ShearsItem(new Item.Settings().maxDamage(600)));

    //原料
    public static final Item STEEL_INGOT = registerItems("steel_ingot", new Item(new Item.Settings()));
    public static final Item DIAMOND_SHARD = registerItems("diamond_shard", new Item(new Item.Settings()));
    public static final Item DIAMOND_SHARD_STACK = registerItems("diamond_shard_stack", new Item(new Item.Settings()));
    public static final Item PULSE_OF_THE_SEA = registerItems("pulse_of_the_sea", new Item(new Item.Settings()));
    public static final Item DRAGON_WING_MEMBRANE = registerItems("dragon_wing_membrane", new Item(new Item.Settings()));
    public static final Item ANCIENT_TEAR = registerItems("ancient_tear", new Item(new Item.Settings()));

    //原型
    public static final Item DIAMOND_PROTOTYPE = registerItems("diamond_prototype", new Item(new Item.Settings()));
    public static final Item ANCIENT_PROTOTYPE = registerItems("ancient_prototype", new Item(new Item.Settings()));
    public static final Item HEAVY_CORE_PROTOTYPE = registerItems("heavy_core_prototype", new Item(new Item.Settings()));
    public static final Item CONDUIT_PROTOTYPE = registerItems("conduit_prototype", new Item(new Item.Settings()));
    public static final Item ELYTRA_PROTOTYPE = registerItems("elytra_prototype", new Item(new Item.Settings()));


    //模板相关
    private static List<Identifier> getDiamondShardsUpgradeEmptyBaseSlotTextures(){
        return List.of(
                Identifier.of("item/empty_slot_axe"),
                Identifier.of("item/empty_slot_pickaxe"));
    }

    private static List<Identifier> getDiamondShardsUpgradeEmptyAdditionsSlotTextures(){
        return List.of(Identifier.of("item/empty_slot_ingot"));
    }

    public static final Item DIAMOND_SHARDS_UPGRADED_SMITHING_TEMPLATE = registerItems("diamond_shards_upgrade_smithing_template",
            new SmithingTemplateItem(
                    Text.translatable("diamond_shards_upgrade_applies_to"),
                    Text.translatable("diamond_shards_upgrade_ingredients"),
                    Text.translatable("diamond_shards_upgrade"),
                    Text.translatable("diamond_shards_upgrade_base_slot"),
                    Text.translatable("diamond_shards_upgrade_additions_slot"),
                    getDiamondShardsUpgradeEmptyBaseSlotTextures(),
                    getDiamondShardsUpgradeEmptyAdditionsSlotTextures()
            ));

    public static final Item PRESSURE_CRAFTING_SMITHING_TEMPLATE = registerItems("pressure_crafting_smithing_template",
            new SmithingTemplateItem(
                    Text.translatable("pressure_crafting_applies_to"),
                    Text.translatable("pressure_crafting_ingredients"),
                    Text.translatable("pressure_crafting"),
                    Text.translatable("pressure_crafting_base_slot"),
                    Text.translatable("pressure_crafting_additions_slot"),
                    getDiamondShardsUpgradeEmptyBaseSlotTextures(),
                    getDiamondShardsUpgradeEmptyAdditionsSlotTextures()
            ));

    public static final Item NETHER_SMITHING_TEMPLATE = registerItems("nether_smithing_template",
            new SmithingTemplateItem(
                    Text.translatable("nether_smithing_applies_to"),
                    Text.translatable("nether_smithing_ingredients"),
                    Text.translatable("nether_smithing"),
                    Text.translatable("nether_smithing_base_slot"),
                    Text.translatable("nether_smithing_additions_slot"),
                    getDiamondShardsUpgradeEmptyBaseSlotTextures(),
                    getDiamondShardsUpgradeEmptyAdditionsSlotTextures()
            ));

    public static final Item NETHER_SMITHING_TEMPLATE_PRO = registerItems("nether_smithing_template_pro",
            new SmithingTemplateItem(
                    Text.translatable("nether_sminthing_pro_applies_to"),
                    Text.translatable("nether_sminthing_pro_ingredients"),
                    Text.translatable("nether_sminthing_pro"),
                    Text.translatable("nether_sminthing_pro_base_slot"),
                    Text.translatable("nether_sminthing_pro_additions_slot"),
                    getDiamondShardsUpgradeEmptyBaseSlotTextures(),
                    getDiamondShardsUpgradeEmptyAdditionsSlotTextures()
            ));

    public static final Item ELYTRA_COPY_TEMPLATE = registerItems("elytra_copy_template",
            new SmithingTemplateItem(
                    Text.translatable("elytra_copy_applies_to"),
                    Text.translatable("elytra_copy_ingredients"),
                    Text.translatable("elytra_copy"),
                    Text.translatable("elytra_copy_base_slot"),
                    Text.translatable("elytra_copy_additions_slot"),
                    getDiamondShardsUpgradeEmptyBaseSlotTextures(),
                    getDiamondShardsUpgradeEmptyAdditionsSlotTextures()
            ));

    public static final Item ENCHANTED_GOLDEN_APPLE_COPY_TEMPLATE = registerItems("enchanted_golden_apply_copy_template",
            new SmithingTemplateItem(
                    Text.translatable("enchanted_golden_apple_copy_applies_to"),
                    Text.translatable("enchanted_golden_apple_copy_ingredients"),
                    Text.translatable("enchanted_golden_apple_copy"),
                    Text.translatable("enchanted_golden_apple_copy_base_slot"),
                    Text.translatable("enchanted_golden_apple_copy_additions_slot"),
                    getDiamondShardsUpgradeEmptyBaseSlotTextures(),
                    getDiamondShardsUpgradeEmptyAdditionsSlotTextures()
            ));

    public static final Item HEAD_COPY_TEMPLATE = registerItems("head_copy_smithing_template",
            new SmithingTemplateItem(
                    Text.translatable("head_copy_applies_to"),
                    Text.translatable("head_copy_ingredients"),
                    Text.translatable("head_copy"),
                    Text.translatable("head_copy_base_slot"),
                    Text.translatable("head_copy_additions_slot"),
                    getDiamondShardsUpgradeEmptyBaseSlotTextures(),
                    getDiamondShardsUpgradeEmptyAdditionsSlotTextures()
            ));

    public static final Item TOTEM_OF_UNDYING_COPY_TEMPLATE = registerItems("totem_of_undying_copy_template",
            new SmithingTemplateItem(
                    Text.translatable("totem_of_undying_copy_applies_to"),
                    Text.translatable("totem_of_undying_copy_ingredients"),
                    Text.translatable("totem_of_undying_copy"),
                    Text.translatable("totem_of_undying_copy_base_slot"),
                    Text.translatable("totem_of_undying_copy_additions_slot"),
                    getDiamondShardsUpgradeEmptyBaseSlotTextures(),
                    getDiamondShardsUpgradeEmptyAdditionsSlotTextures()
            ));

    private static void addItemsToIG(FabricItemGroupEntries fabricItemGroupEntries){}
    private static Item registerItems(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(VanillaAddition.MOD_ID,name),item);
    }
    public static void registerModItems(){
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIG);
    }
}
