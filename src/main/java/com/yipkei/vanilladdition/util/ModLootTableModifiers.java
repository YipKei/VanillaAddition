package com.yipkei.vanilladdition.util;

import com.yipkei.vanilladdition.init.ModItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.KilledByPlayerLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {
    private static final RegistryKey<LootTable> ENDER_DRAGON_DROPS_KEY =    RegistryKey.of(RegistryKeys.LOOT_TABLE, Identifier.of("minecraft","entities/ender_dragon"));
    private static final RegistryKey<LootTable> WARDEN_KEY =                RegistryKey.of(RegistryKeys.LOOT_TABLE, Identifier.of("minecraft","entities/warden"));

    public static void modifierLootTables(){
        LootTableEvents.MODIFY.register((key,tableBuilder,source)->{
            if (ENDER_DRAGON_DROPS_KEY.equals(key)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0f))
                        .with(ItemEntry.builder(ModItems.DRAGON_WING_MEMBRANE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(8.0f, 16.0f)))
                        .conditionally(KilledByPlayerLootCondition.builder());
                tableBuilder.pool(poolBuilder.build());
            }
            if (WARDEN_KEY.equals(key)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0f))
                        .with(ItemEntry.builder(ModItems.ANCIENT_TEAR))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.5f)))
                        .conditionally(KilledByPlayerLootCondition.builder());
                tableBuilder.pool(poolBuilder.build());
            }
        });
    }
}
