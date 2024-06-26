package com.yipkei.vanilladdition.util;

import com.yipkei.vanilladdition.init.ModItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.KilledByPlayerLootCondition;
import net.minecraft.loot.entry.EmptyEntry;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {
    private static final RegistryKey<LootTable> ENDER_DRAGON_DROPS_KEY =    registerKey("minecraft", "entities/ender_dragon");
    private static final RegistryKey<LootTable> WARDEN_KEY =                registerKey("minecraft", "entities/warden");
    private static final RegistryKey<LootTable> BASTION_TREASURE =          registerKey("minecraft", "chest/bastion_treasure");
    private static final RegistryKey<LootTable> BASTION_BRIDGE =            registerKey("minecraft", "chest/bastion_bridge");
    private static final RegistryKey<LootTable> BASTION_HOGLIN_STABLE =     registerKey("minecraft", "chest/bastion_hoglin_stable");
    private static final RegistryKey<LootTable> BASTION_OTHER =             registerKey("minecraft", "chest/bastion_others");
    private static final RegistryKey<LootTable> END_CITY_TREASURE = registerKey("minecraft", "chest/end_city_treasure");
    private static final RegistryKey<LootTable> ANCIENT_CITY = registerKey("minecraft", "chest/ancient_city");

    public static void modifierLootTables(){
        LootTableEvents.MODIFY.register((key,tableBuilder,source)->{
            if (ENDER_DRAGON_DROPS_KEY.equals(key)){
                tableBuilder.pool(createEntityKilledLootPool(1.0f, ModItems.DRAGON_WING_MEMBRANE, 8.0f, 16.0f));
            }
            if (WARDEN_KEY.equals(key)){
                tableBuilder.pool(createEntityKilledLootPool(1.0f, ModItems.ANCIENT_TEAR, 1.0f, 1.5f));
            }
            if (BASTION_TREASURE.equals(key)){
                tableBuilder.pool(createSimpleLootPool(1.0f, ModItems.NETHER_SMITHING_TEMPLATE));
            }
            if (BASTION_BRIDGE.equals(key)){
                tableBuilder.pool(createSimpleWeightLootPool(1.0f, ModItems.NETHER_SMITHING_TEMPLATE, 5, 1));
            }
            if (BASTION_HOGLIN_STABLE.equals(key)){
                tableBuilder.pool(createSimpleWeightLootPool(1.0f, ModItems.NETHER_SMITHING_TEMPLATE, 9, 1));
            }
            if (BASTION_OTHER.equals(key)){
                tableBuilder.pool(createSimpleWeightLootPool(1.0f, ModItems.NETHER_SMITHING_TEMPLATE,  19, 1));
            }
            if (END_CITY_TREASURE.equals(key)){
                tableBuilder.pool(createSimpleWeightLootPool(1.0f, ModItems.ELYTRA_COPY_TEMPLATE, 9, 1));
            }
            if (ANCIENT_CITY.equals(key)){
                tableBuilder.pool(createMultipleWeightLootPool(3.0f,85, Items.TOTEM_OF_UNDYING, 5, ModItems.ANCIENT_TEAR, 4, ModItems.SUSPICIOUS_PROTOTYPE,3, ModItems.ANCIENT_PROTOTYPE, 2, ModItems.NETHER_SMITHING_TEMPLATE, 1));
            }

        });
    }

    private static RegistryKey<LootTable> registerKey(String namespace, String path){
        return RegistryKey.of(RegistryKeys.LOOT_TABLE, Identifier.of(namespace,path));
    }

    private static LootPool.Builder createSimpleLootPool(float rolls, ItemConvertible drops){
        return LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(rolls))
                .with(ItemEntry.builder(drops));
    }

    private static LootPool.Builder createSimpleLootPool(float rolls, ItemConvertible drops, float minCount, float maxCount){
        return LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(rolls))
                .with(ItemEntry.builder(drops))
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minCount, maxCount)));
    }

    private static LootPool.Builder createSimpleWeightLootPool(float rolls, ItemConvertible drops, int emptyWeight, int itemWeight){
        return LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(rolls))
                .with(ItemEntry.builder(drops).weight(itemWeight))
                .with(EmptyEntry.builder().weight(emptyWeight));
    }

    private static LootPool.Builder createSimpleWeightLootPool(float rolls, int emptyWeight, ItemConvertible drops, int itemWeight, float minCount, float maxCount){
        return LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(rolls))
                .with(ItemEntry.builder(drops).weight(itemWeight))
                .with(EmptyEntry.builder().weight(emptyWeight))
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minCount, maxCount)));
    }

    private static LootPool.Builder createMultipleWeightLootPool(float rolls, int emptyWeight, ItemConvertible drops1, int itemWeight1, ItemConvertible drops2, int itemWeight2){
        return LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(rolls))
                .with(ItemEntry.builder(drops1).weight(itemWeight1))
                .with(ItemEntry.builder(drops2).weight(itemWeight2))
                .with(EmptyEntry.builder().weight(emptyWeight));
    }

    private static LootPool.Builder createMultipleWeightLootPool(float rolls, int emptyWeight, ItemConvertible drops1, int itemWeight1, ItemConvertible drops2, int itemWeight2, ItemConvertible drops3, int itemWeight3){
        return LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(rolls))
                .with(ItemEntry.builder(drops1).weight(itemWeight1))
                .with(ItemEntry.builder(drops2).weight(itemWeight2))
                .with(ItemEntry.builder(drops3).weight(itemWeight3))
                .with(EmptyEntry.builder().weight(emptyWeight));
    }

    private static LootPool.Builder createMultipleWeightLootPool(float rolls, int emptyWeight, ItemConvertible drops1, int itemWeight1, ItemConvertible drops2, int itemWeight2, ItemConvertible drops3, int itemWeight3, ItemConvertible drops4, int itemWeight4){
        return LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(rolls))
                .with(ItemEntry.builder(drops1).weight(itemWeight1))
                .with(ItemEntry.builder(drops2).weight(itemWeight2))
                .with(ItemEntry.builder(drops3).weight(itemWeight3))
                .with(ItemEntry.builder(drops4).weight(itemWeight4))
                .with(EmptyEntry.builder().weight(emptyWeight));
    }

    private static LootPool.Builder createMultipleWeightLootPool(float rolls, int emptyWeight, ItemConvertible drops1, int itemWeight1, ItemConvertible drops2, int itemWeight2, ItemConvertible drops3, int itemWeight3, ItemConvertible drops4, int itemWeight4, ItemConvertible drops5, int itemWeight5){
        return LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(rolls))
                .with(ItemEntry.builder(drops1).weight(itemWeight1))
                .with(ItemEntry.builder(drops2).weight(itemWeight2))
                .with(ItemEntry.builder(drops3).weight(itemWeight3))
                .with(ItemEntry.builder(drops4).weight(itemWeight4))
                .with(ItemEntry.builder(drops5).weight(itemWeight5))
                .with(EmptyEntry.builder().weight(emptyWeight));
    }

    private static LootPool.Builder createEntityKilledLootPool(float rolls, ItemConvertible drops){
        return LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(rolls))
                .with(ItemEntry.builder(drops))
                .conditionally(KilledByPlayerLootCondition.builder());
    }

    private static LootPool.Builder createEntityKilledLootPool(float rolls, ItemConvertible drops, float minCount, float maxCount){
        return LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(rolls))
                .with(ItemEntry.builder(drops))
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minCount, maxCount)))
                .conditionally(KilledByPlayerLootCondition.builder());
    }
}
