package com.yipkei.vanilladdition.data.generator;

import com.yipkei.vanilladdition.init.ModBlocks;
import com.yipkei.vanilladdition.init.ModItems;
import com.yipkei.vanilladdition.init.ModLootTables;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLootTableProvider;
import net.fabricmc.fabric.impl.datagen.loot.FabricLootTableProviderImpl;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataProvider;
import net.minecraft.data.DataWriter;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.loot.entry.EmptyEntry;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootTableEntry;
import net.minecraft.loot.function.*;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.potion.Potions;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntryList;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.BiConsumer;

public class ModChestLootTableProvider implements FabricLootTableProvider, DataProvider {
    private final FabricDataOutput output;
    private final CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture;

    public ModChestLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup)  {

        this.output = dataOutput;
        this.completableFuture = registryLookup;;
    }

    @Override
    public void accept(BiConsumer<RegistryKey<LootTable>, LootTable.Builder> lootTableBiConsumer) {
        RegistryWrapper.WrapperLookup registryLookup = null;
        try {
            registryLookup = this.completableFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        RegistryWrapper.Impl<Enchantment> impl = registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);

        lootTableBiConsumer.accept(ModLootTables.STONE_BLIND_BOX_COMMON,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(Blocks.ANDESITE).weight(1))
                        .with(ItemEntry.builder(Blocks.DIORITE).weight(1))
                        .with(ItemEntry.builder(Blocks.GRANITE).weight(1))
                        .with(ItemEntry.builder(Blocks.CALCITE).weight(1))
                        .with(ItemEntry.builder(Blocks.TUFF).weight(2))
                        .with(ItemEntry.builder(Blocks.NETHERRACK).weight(2))
                        .with(ItemEntry.builder(Blocks.BLACKSTONE).weight(1))
                        .with(ItemEntry.builder(Blocks.END_STONE).weight(1))
                ));

        lootTableBiConsumer.accept(ModLootTables.STONE_BLIND_BOX_UNCOMMON,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(Items.COAL).weight(430))
                        .with(ItemEntry.builder(Items.RAW_IRON).weight(340))
                        .with(ItemEntry.builder(Items.RAW_COPPER).weight(1200))
                        .with(ItemEntry.builder(Items.RAW_GOLD).weight(50))
                        .with(ItemEntry.builder(Items.LAPIS_LAZULI).weight(380))
                        .with(ItemEntry.builder(Items.REDSTONE).weight(240))
                        .with(ItemEntry.builder(Items.DIAMOND).weight(9))
                        .with(ItemEntry.builder(Items.EMERALD).weight(1))
                        .with(ItemEntry.builder(Items.QUARTZ).weight(150))
                        .with(ItemEntry.builder(Items.GOLD_NUGGET).weight(200))
                ));

        lootTableBiConsumer.accept(ModLootTables.STONE_BLIND_BOX_RARE,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(Blocks.COAL_ORE).weight(425))
                        .with(ItemEntry.builder(Blocks.IRON_ORE).weight(340))
                        .with(ItemEntry.builder(Blocks.COPPER_ORE).weight(360))
                        .with(ItemEntry.builder(Blocks.GOLD_ORE).weight(50))
                        .with(ItemEntry.builder(Blocks.LAPIS_ORE).weight(60))
                        .with(ItemEntry.builder(Blocks.REDSTONE_ORE).weight(55))
                        .with(ItemEntry.builder(Blocks.DIAMOND_ORE).weight(9))
                        .with(ItemEntry.builder(Blocks.EMERALD_ORE).weight(1))
                        .with(ItemEntry.builder(Blocks.NETHER_QUARTZ_ORE).weight(150))
                        .with(ItemEntry.builder(Blocks.NETHER_GOLD_ORE).weight(50))
                ));

        lootTableBiConsumer.accept(ModLootTables.STONE_BLIND_BOX_UNIQUE,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(Blocks.COAL_BLOCK).weight(430))
                        .with(ItemEntry.builder(Blocks.RAW_IRON_BLOCK).weight(340))
                        .with(ItemEntry.builder(Blocks.RAW_COPPER_BLOCK).weight(1200))
                        .with(ItemEntry.builder(Blocks.RAW_GOLD_BLOCK).weight(50))
                        .with(ItemEntry.builder(Blocks.LAPIS_BLOCK).weight(380))
                        .with(ItemEntry.builder(Blocks.REDSTONE_BLOCK).weight(240))
                        .with(ItemEntry.builder(Blocks.DIAMOND_BLOCK).weight(9))
                        .with(ItemEntry.builder(Blocks.EMERALD_BLOCK).weight(1))
                        .with(ItemEntry.builder(Items.QUARTZ).weight(150).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(9.0F))))
                        .with(ItemEntry.builder(Items.GOLD_INGOT).weight(200))
                ));

        lootTableBiConsumer.accept(ModLootTables.STONE_BLIND_BOX,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(10.0F))
                        .with(LootTableEntry.builder(ModLootTables.STONE_BLIND_BOX_COMMON).weight(40))
                        .with(LootTableEntry.builder(ModLootTables.STONE_BLIND_BOX_UNCOMMON).weight(50))
                        .with(LootTableEntry.builder(ModLootTables.STONE_BLIND_BOX_RARE).weight(8))
                        .with(LootTableEntry.builder(ModLootTables.STONE_BLIND_BOX_UNIQUE).weight(2))));

        lootTableBiConsumer.accept(ModLootTables.OMINOUS_STONE_BLIND_BOX_COMMON,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(Blocks.TERRACOTTA).weight(4))
                        .with(ItemEntry.builder(Blocks.WHITE_TERRACOTTA).weight(1))
                        .with(ItemEntry.builder(Blocks.LIGHT_GRAY_TERRACOTTA).weight(1))
                        .with(ItemEntry.builder(Blocks.GRAY_TERRACOTTA).weight(1))
                        .with(ItemEntry.builder(Blocks.BLACK_TERRACOTTA).weight(1))
                        .with(ItemEntry.builder(Blocks.BROWN_TERRACOTTA).weight(1))
                        .with(ItemEntry.builder(Blocks.RED_TERRACOTTA).weight(1))
                        .with(ItemEntry.builder(Blocks.ORANGE_TERRACOTTA).weight(1))
                        .with(ItemEntry.builder(Blocks.YELLOW_TERRACOTTA).weight(1))
                        .with(ItemEntry.builder(Blocks.LIME_TERRACOTTA).weight(1))
                        .with(ItemEntry.builder(Blocks.GREEN_TERRACOTTA).weight(1))
                        .with(ItemEntry.builder(Blocks.CYAN_TERRACOTTA).weight(1))
                        .with(ItemEntry.builder(Blocks.LIGHT_BLUE_TERRACOTTA).weight(1))
                        .with(ItemEntry.builder(Blocks.BLUE_TERRACOTTA).weight(1))
                        .with(ItemEntry.builder(Blocks.PURPLE_TERRACOTTA).weight(1))
                        .with(ItemEntry.builder(Blocks.MAGENTA_TERRACOTTA).weight(1))
                        .with(ItemEntry.builder(Blocks.PINK_TERRACOTTA).weight(1))
                ));

        lootTableBiConsumer.accept(ModLootTables.OMINOUS_STONE_BLIND_BOX_UNCOMMON,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(Items.COAL).weight(9))
                        .with(ItemEntry.builder(Items.RAW_IRON).weight(175))
                        .with(ItemEntry.builder(Items.RAW_COPPER).weight(165))
                        .with(ItemEntry.builder(Items.RAW_GOLD).weight(140))
                        .with(ItemEntry.builder(Items.LAPIS_LAZULI).weight(490))
                        .with(ItemEntry.builder(Items.REDSTONE).weight(1180))
                        .with(ItemEntry.builder(Items.DIAMOND).weight(150))
                        .with(ItemEntry.builder(Items.EMERALD).weight(1))
                        .with(ItemEntry.builder(Items.QUARTZ).weight(95))
                        .with(ItemEntry.builder(Items.GOLD_NUGGET).weight(95))
                ));

        lootTableBiConsumer.accept(ModLootTables.OMINOUS_STONE_BLIND_BOX_RARE,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(Blocks.COAL_ORE).weight(9))
                        .with(ItemEntry.builder(Blocks.IRON_ORE).weight(180))
                        .with(ItemEntry.builder(Blocks.COPPER_ORE).weight(50))
                        .with(ItemEntry.builder(Blocks.GOLD_ORE).weight(140))
                        .with(ItemEntry.builder(Blocks.LAPIS_ORE).weight(80))
                        .with(ItemEntry.builder(Blocks.REDSTONE_ORE).weight(270))
                        .with(ItemEntry.builder(Blocks.DIAMOND_ORE).weight(150))
                        .with(ItemEntry.builder(Blocks.EMERALD_ORE).weight(1))
                        .with(ItemEntry.builder(Blocks.NETHER_QUARTZ_ORE).weight(95))
                        .with(ItemEntry.builder(Blocks.NETHER_GOLD_ORE).weight(24))
                        .with(ItemEntry.builder(Blocks.ANCIENT_DEBRIS).weight(1))
                ));

        lootTableBiConsumer.accept(ModLootTables.OMINOUS_STONE_BLIND_BOX_UNIQUE,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(Blocks.COAL_BLOCK).weight(9))
                        .with(ItemEntry.builder(Blocks.RAW_IRON_BLOCK).weight(175))
                        .with(ItemEntry.builder(Blocks.RAW_COPPER_BLOCK).weight(165))
                        .with(ItemEntry.builder(Blocks.RAW_GOLD_BLOCK).weight(140))
                        .with(ItemEntry.builder(Blocks.LAPIS_BLOCK).weight(490))
                        .with(ItemEntry.builder(Blocks.REDSTONE_BLOCK).weight(1180))
                        .with(ItemEntry.builder(Blocks.DIAMOND_BLOCK).weight(150))
                        .with(ItemEntry.builder(Blocks.EMERALD_BLOCK).weight(1))
                        .with(ItemEntry.builder(Items.QUARTZ).weight(90).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(9.0F))))
                        .with(ItemEntry.builder(Items.GOLD_INGOT).weight(90))
                        .with(ItemEntry.builder(Items.NETHERITE_SCRAP).weight(10))
                ));

        lootTableBiConsumer.accept(ModLootTables.OMINOUS_STONE_BLIND_BOX,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(10.0F))
                        .with(LootTableEntry.builder(ModLootTables.OMINOUS_STONE_BLIND_BOX_COMMON).weight(40))
                        .with(LootTableEntry.builder(ModLootTables.OMINOUS_STONE_BLIND_BOX_UNCOMMON).weight(50))
                        .with(LootTableEntry.builder(ModLootTables.OMINOUS_STONE_BLIND_BOX_RARE).weight(8))
                        .with(LootTableEntry.builder(ModLootTables.OMINOUS_STONE_BLIND_BOX_UNIQUE).weight(2))));

        lootTableBiConsumer.accept(ModLootTables.COAL_BLIND_BOX_COMMON,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(LootTableEntry.builder(LootTables.DESERT_PYRAMID_ARCHAEOLOGY).weight(10))
                        .with(LootTableEntry.builder(LootTables.DESERT_WELL_ARCHAEOLOGY).weight(10))
                        .with(LootTableEntry.builder(LootTables.OCEAN_RUIN_COLD_ARCHAEOLOGY).weight(5))
                        .with(LootTableEntry.builder(LootTables.OCEAN_RUIN_WARM_ARCHAEOLOGY).weight(5))
                        .with(LootTableEntry.builder(LootTables.TRAIL_RUINS_COMMON_ARCHAEOLOGY).weight(8))
                        .with(LootTableEntry.builder(LootTables.TRAIL_RUINS_RARE_ARCHAEOLOGY).weight(2))
                        .with(EmptyEntry.builder().weight(40))
                ));

        lootTableBiConsumer.accept(ModLootTables.COAL_BLIND_BOX_UNCOMMON,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(Items.BLACK_DYE).weight(10))
                        .with(ItemEntry.builder(Items.WITHER_ROSE).weight(5))
                        .with(ItemEntry.builder(Items.INK_SAC).weight(4))
                        .with(ItemEntry.builder(Items.GLOW_INK_SAC).weight(1))
                        .with(ItemEntry.builder(Items.CHARCOAL).weight(30))
                        .with(EmptyEntry.builder().weight(120))
                ));

        lootTableBiConsumer.accept(ModLootTables.COAL_BLIND_BOX_RARE,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(Items.LAVA_BUCKET).weight(1))
                        .with(ItemEntry.builder(Items.MAGMA_CREAM).weight(4))
                        .with(EmptyEntry.builder().weight(35))
                ));

        lootTableBiConsumer.accept(ModLootTables.COAL_BLIND_BOX_UNIQUE,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(Blocks.DIAMOND_BLOCK).weight(1))
                        .with(ItemEntry.builder(Items.DIAMOND).weight(9))
                        .with(EmptyEntry.builder().weight(150))
                ));

        lootTableBiConsumer.accept(ModLootTables.COAL_BLIND_BOX,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(10.0F))
                        .with(LootTableEntry.builder(ModLootTables.COAL_BLIND_BOX_COMMON).weight(40))
                        .with(LootTableEntry.builder(ModLootTables.COAL_BLIND_BOX_UNCOMMON).weight(50))
                        .with(LootTableEntry.builder(ModLootTables.COAL_BLIND_BOX_RARE).weight(8))
                        .with(LootTableEntry.builder(ModLootTables.COAL_BLIND_BOX_UNIQUE).weight(2))));

        lootTableBiConsumer.accept(ModLootTables.OMINOUS_COAL_BLIND_BOX_COMMON,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(LootTableEntry.builder(LootTables.DESERT_PYRAMID_ARCHAEOLOGY).weight(10))
                        .with(LootTableEntry.builder(LootTables.DESERT_WELL_ARCHAEOLOGY).weight(10))
                        .with(LootTableEntry.builder(LootTables.OCEAN_RUIN_COLD_ARCHAEOLOGY).weight(5))
                        .with(LootTableEntry.builder(LootTables.OCEAN_RUIN_WARM_ARCHAEOLOGY).weight(5))
                        .with(LootTableEntry.builder(LootTables.TRAIL_RUINS_COMMON_ARCHAEOLOGY).weight(8))
                        .with(LootTableEntry.builder(LootTables.TRAIL_RUINS_RARE_ARCHAEOLOGY).weight(2))
                ));

        lootTableBiConsumer.accept(ModLootTables.OMINOUS_COAL_BLIND_BOX_UNCOMMON,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(Items.BLACK_DYE).weight(10))
                        .with(ItemEntry.builder(Items.WITHER_ROSE).weight(5))
                        .with(ItemEntry.builder(Items.INK_SAC).weight(4))
                        .with(ItemEntry.builder(Items.GLOW_INK_SAC).weight(1))
                        .with(ItemEntry.builder(Items.CHARCOAL).weight(30))
                        .with(EmptyEntry.builder().weight(25))
                ));

        lootTableBiConsumer.accept(ModLootTables.OMINOUS_COAL_BLIND_BOX_RARE,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(Items.LAVA_BUCKET).weight(1))
                        .with(ItemEntry.builder(Items.MAGMA_CREAM).weight(4))
                        .with(EmptyEntry.builder().weight(5))
                ));

        lootTableBiConsumer.accept(ModLootTables.OMINOUS_COAL_BLIND_BOX_UNIQUE,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(Blocks.WITHER_SKELETON_SKULL).weight(1))
                        .with(ItemEntry.builder(Blocks.DIAMOND_BLOCK).weight(2))
                        .with(ItemEntry.builder(Items.DIAMOND).weight(5))
                        .with(EmptyEntry.builder().weight(12))
                ));

        lootTableBiConsumer.accept(ModLootTables.OMINOUS_COAL_BLIND_BOX,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(10.0F))
                        .with(LootTableEntry.builder(ModLootTables.OMINOUS_COAL_BLIND_BOX_COMMON).weight(40))
                        .with(LootTableEntry.builder(ModLootTables.OMINOUS_COAL_BLIND_BOX_UNCOMMON).weight(50))
                        .with(LootTableEntry.builder(ModLootTables.OMINOUS_COAL_BLIND_BOX_RARE).weight(8))
                        .with(LootTableEntry.builder(ModLootTables.OMINOUS_COAL_BLIND_BOX_UNIQUE).weight(2))
                ));


        lootTableBiConsumer.accept(ModLootTables.COPPER_BLIND_BOX_COMMON,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(LootTableEntry.builder(LootTables.UNDERWATER_RUIN_SMALL_CHEST).weight(8))
                        .with(LootTableEntry.builder(LootTables.UNDERWATER_RUIN_BIG_CHEST).weight(2))
                ));

        lootTableBiConsumer.accept(ModLootTables.COPPER_BLIND_BOX_UNCOMMON,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(LootTableEntry.builder(LootTables.SHIPWRECK_SUPPLY_CHEST).weight(6))
                        .with(LootTableEntry.builder(LootTables.SHIPWRECK_TREASURE_CHEST).weight(3))
                        .with(LootTableEntry.builder(LootTables.SHIPWRECK_MAP_CHEST).weight(1))
                ));

        lootTableBiConsumer.accept(ModLootTables.COPPER_BLIND_BOX_RARE,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(LootTableEntry.builder(LootTables.RUINED_PORTAL_CHEST))
                ));

        lootTableBiConsumer.accept(ModLootTables.COPPER_BLIND_BOX_UNIQUE,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(LootTableEntry.builder(LootTables.BURIED_TREASURE_CHEST).weight(15))
                        .with(ItemEntry.builder(ModItems.PULSE_OF_THE_SEA).weight(30))
                        .with(ItemEntry.builder(Items.NAUTILUS_SHELL).weight(20).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 6.0F))))
                        .with(ItemEntry.builder(Items.SPONGE).weight(20).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4.0F, 8.0F))))
                        .with(ItemEntry.builder(Blocks.BRAIN_CORAL_BLOCK).weight(2))
                        .with(ItemEntry.builder(Blocks.TUBE_CORAL_BLOCK).weight(2))
                        .with(ItemEntry.builder(Blocks.BUBBLE_CORAL_BLOCK).weight(2))
                        .with(ItemEntry.builder(Blocks.FIRE_CORAL_BLOCK).weight(2))
                        .with(ItemEntry.builder(Blocks.HORN_CORAL_BLOCK).weight(2))
                ));

        lootTableBiConsumer.accept(ModLootTables.COPPER_BLIND_BOX,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(10.0F))
                        .with(LootTableEntry.builder(ModLootTables.COPPER_BLIND_BOX_COMMON).weight(40))
                        .with(LootTableEntry.builder(ModLootTables.COPPER_BLIND_BOX_UNCOMMON).weight(50))
                        .with(LootTableEntry.builder(ModLootTables.COPPER_BLIND_BOX_RARE).weight(8))
                        .with(LootTableEntry.builder(ModLootTables.COPPER_BLIND_BOX_UNIQUE).weight(2))));

        lootTableBiConsumer.accept(ModLootTables.OMINOUS_COPPER_BLIND_BOX_COMMON,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(Items.IRON_BOOTS).weight(4).apply((new EnchantRandomlyLootFunction.Builder()).option(impl.getOrThrow(Enchantments.DEPTH_STRIDER))))
                        .with(ItemEntry.builder(Items.IRON_HELMET).weight(4).apply((new EnchantRandomlyLootFunction.Builder()).option(impl.getOrThrow(Enchantments.AQUA_AFFINITY))))
                        .with(ItemEntry.builder(Items.IRON_HELMET).weight(4).apply((new EnchantRandomlyLootFunction.Builder()).option(impl.getOrThrow(Enchantments.RESPIRATION))))
                        .with(ItemEntry.builder(Items.FISHING_ROD).weight(4).apply((new EnchantRandomlyLootFunction.Builder()).option(impl.getOrThrow(Enchantments.LUCK_OF_THE_SEA))))
                        .with(ItemEntry.builder(Items.BOOK).weight(1).apply((new EnchantRandomlyLootFunction.Builder()).option(impl.getOrThrow(Enchantments.DEPTH_STRIDER))))
                        .with(ItemEntry.builder(Items.BOOK).weight(1).apply((new EnchantRandomlyLootFunction.Builder()).option(impl.getOrThrow(Enchantments.AQUA_AFFINITY))))
                        .with(ItemEntry.builder(Items.BOOK).weight(1).apply((new EnchantRandomlyLootFunction.Builder()).option(impl.getOrThrow(Enchantments.RESPIRATION))))
                        .with(ItemEntry.builder(Items.BOOK).weight(1).apply((new EnchantRandomlyLootFunction.Builder()).option(impl.getOrThrow(Enchantments.LUCK_OF_THE_SEA))))
                        .with(ItemEntry.builder(Items.TROPICAL_FISH_BUCKET).weight(5))
                        .with(ItemEntry.builder(Items.PUFFERFISH_BUCKET).weight(5))
                        .with(ItemEntry.builder(Items.COD_BUCKET).weight(20))
                        .with(ItemEntry.builder(Items.SALMON_BUCKET).weight(20))
                        .with(ItemEntry.builder(Items.SEAGRASS).weight(30))
                ));

        lootTableBiConsumer.accept(ModLootTables.OMINOUS_COPPER_BLIND_BOX_UNCOMMON,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(Items.INK_SAC).weight(60))
                        .with(ItemEntry.builder(Items.GLOW_INK_SAC).weight(10))
                        .with(ItemEntry.builder(Items.SPONGE).weight(20))
                        .with(ItemEntry.builder(Items.FISHING_ROD).weight(8)
                                .apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.15F, 0.8F)))
                                .apply(EnchantRandomlyLootFunction.builder(registryLookup)))
                        .with(ItemEntry.builder(Items.FISHING_ROD).weight(1)
                                .apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.15F, 0.8F)))
                                .apply((new SetEnchantmentsLootFunction.Builder())
                                        .enchantment(impl.getOrThrow(Enchantments.LUCK_OF_THE_SEA),ConstantLootNumberProvider.create(3.0F))
                                        .enchantment(impl.getOrThrow(Enchantments.LURE),ConstantLootNumberProvider.create(3.0F))
                                        .enchantment(impl.getOrThrow(Enchantments.UNBREAKING),ConstantLootNumberProvider.create(3.0F))))
                        .with(ItemEntry.builder(Items.TRIDENT).weight(1)
                                .apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.8F, 0.99F)))                        )
                ));

        lootTableBiConsumer.accept(ModLootTables.OMINOUS_COPPER_BLIND_BOX_RARE,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(LootTableEntry.builder(LootTables.BURIED_TREASURE_CHEST).weight(1))
                        .with(LootTableEntry.builder(LootTables.RUINED_PORTAL_CHEST).weight(3))
                ));

        lootTableBiConsumer.accept(ModLootTables.OMINOUS_COPPER_BLIND_BOX_UNIQUE,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(Items.BOOK).weight(1).apply((new EnchantRandomlyLootFunction.Builder()).option(impl.getOrThrow(Enchantments.DEPTH_STRIDER))))
                        .with(ItemEntry.builder(Items.BOOK).weight(1).apply((new EnchantRandomlyLootFunction.Builder()).option(impl.getOrThrow(Enchantments.AQUA_AFFINITY))))
                        .with(ItemEntry.builder(Items.BOOK).weight(1).apply((new EnchantRandomlyLootFunction.Builder()).option(impl.getOrThrow(Enchantments.RESPIRATION))))
                        .with(ItemEntry.builder(Items.BOOK).weight(1).apply((new EnchantRandomlyLootFunction.Builder()).option(impl.getOrThrow(Enchantments.LUCK_OF_THE_SEA))))
                        .with(ItemEntry.builder(Items.BOOK).weight(1).apply((new EnchantRandomlyLootFunction.Builder()).option(impl.getOrThrow(Enchantments.LURE))))
                        .with(ItemEntry.builder(Items.BOOK).weight(1).apply((new EnchantRandomlyLootFunction.Builder()).option(impl.getOrThrow(Enchantments.RIPTIDE))))
                        .with(ItemEntry.builder(Items.BOOK).weight(1).apply((new EnchantRandomlyLootFunction.Builder()).option(impl.getOrThrow(Enchantments.IMPALING))))
                        .with(ItemEntry.builder(Items.BOOK).weight(1).apply((new EnchantRandomlyLootFunction.Builder()).option(impl.getOrThrow(Enchantments.LOYALTY))))
                        .with(ItemEntry.builder(Items.BOOK).weight(1).apply((new EnchantRandomlyLootFunction.Builder()).option(impl.getOrThrow(Enchantments.MENDING))))
                        .with(ItemEntry.builder(Items.HEART_OF_THE_SEA).weight(1))
                ));

        lootTableBiConsumer.accept(ModLootTables.OMINOUS_COPPER_BLIND_BOX,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(10.0F))
                        .with(LootTableEntry.builder(ModLootTables.OMINOUS_COPPER_BLIND_BOX_COMMON).weight(40))
                        .with(LootTableEntry.builder(ModLootTables.OMINOUS_COPPER_BLIND_BOX_UNCOMMON).weight(50))
                        .with(LootTableEntry.builder(ModLootTables.OMINOUS_COPPER_BLIND_BOX_RARE).weight(8))
                        .with(LootTableEntry.builder(ModLootTables.OMINOUS_COPPER_BLIND_BOX_UNIQUE).weight(2))
                ));

        lootTableBiConsumer.accept(ModLootTables.IRON_BLIND_BOX_COMMON,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(LootTableEntry.builder(LootTables.VILLAGE_DESERT_HOUSE_CHEST).weight(1))
                        .with(LootTableEntry.builder(LootTables.VILLAGE_PLAINS_CHEST).weight(1))
                        .with(LootTableEntry.builder(LootTables.VILLAGE_SAVANNA_HOUSE_CHEST).weight(1))
                        .with(LootTableEntry.builder(LootTables.VILLAGE_SNOWY_HOUSE_CHEST).weight(1))
                        .with(LootTableEntry.builder(LootTables.VILLAGE_TAIGA_HOUSE_CHEST).weight(1))
                ));

        lootTableBiConsumer.accept(ModLootTables.IRON_BLIND_BOX_UNCOMMON,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(LootTableEntry.builder(LootTables.VILLAGE_ARMORER_CHEST).weight(1))
                        .with(LootTableEntry.builder(LootTables.VILLAGE_BUTCHER_CHEST).weight(1))
                        .with(LootTableEntry.builder(LootTables.VILLAGE_CARTOGRAPHER_CHEST).weight(1))
                        .with(LootTableEntry.builder(LootTables.VILLAGE_FISHER_CHEST).weight(1))
                        .with(LootTableEntry.builder(LootTables.VILLAGE_FLETCHER_CHEST).weight(1))
                        .with(LootTableEntry.builder(LootTables.VILLAGE_MASON_CHEST).weight(1))
                        .with(LootTableEntry.builder(LootTables.VILLAGE_SHEPARD_CHEST).weight(1))
                        .with(LootTableEntry.builder(LootTables.VILLAGE_TANNERY_CHEST).weight(1))
                        .with(LootTableEntry.builder(LootTables.VILLAGE_TEMPLE_CHEST).weight(1))
                        .with(LootTableEntry.builder(LootTables.VILLAGE_TOOLSMITH_CHEST).weight(1))
                        .with(LootTableEntry.builder(LootTables.VILLAGE_WEAPONSMITH_CHEST).weight(1))
                ));

        lootTableBiConsumer.accept(ModLootTables.IRON_BLIND_BOX_RARE,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(LootTableEntry.builder(LootTables.WOODLAND_MANSION_CHEST))
                ));

        lootTableBiConsumer.accept(ModLootTables.IRON_BLIND_BOX_UNIQUE,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(Items.ENCHANTED_GOLDEN_APPLE).weight(1))
                        .with(ItemEntry.builder(Items.GOLDEN_APPLE).weight(4))
                        .with(ItemEntry.builder(Items.TOTEM_OF_UNDYING).weight(15))
                ));

        lootTableBiConsumer.accept(ModLootTables.IRON_BLIND_BOX,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(10.0F))
                        .with(LootTableEntry.builder(ModLootTables.IRON_BLIND_BOX_COMMON).weight(40))
                        .with(LootTableEntry.builder(ModLootTables.IRON_BLIND_BOX_UNCOMMON).weight(50))
                        .with(LootTableEntry.builder(ModLootTables.IRON_BLIND_BOX_RARE).weight(8))
                        .with(LootTableEntry.builder(ModLootTables.IRON_BLIND_BOX_UNIQUE).weight(2))));

        lootTableBiConsumer.accept(ModLootTables.OMINOUS_IRON_BLIND_BOX_COMMON,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(LootTableEntry.builder(LootTables.ABANDONED_MINESHAFT_CHEST))
                ));

        lootTableBiConsumer.accept(ModLootTables.OMINOUS_IRON_BLIND_BOX_UNCOMMON,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(LootTableEntry.builder(LootTables.SIMPLE_DUNGEON_CHEST).weight(7))
                        .with(LootTableEntry.builder(LootTables.PILLAGER_OUTPOST_CHEST).weight(2))
                        .with(LootTableEntry.builder(LootTables.IGLOO_CHEST_CHEST).weight(1))
                ));

        lootTableBiConsumer.accept(ModLootTables.OMINOUS_IRON_BLIND_BOX_RARE,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(LootTableEntry.builder(LootTables.END_CITY_TREASURE_CHEST).weight(600))
                        .with(ItemEntry.builder(Items.SHULKER_SHELL).weight(199))
                        .with(ItemEntry.builder(Items.ELYTRA).weight(1).apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.90F,0.99F))))
                ));

        lootTableBiConsumer.accept(ModLootTables.OMINOUS_IRON_BLIND_BOX_UNIQUE,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(Items.BOOK).weight(1).apply((new EnchantRandomlyLootFunction.Builder()).option(impl.getOrThrow(Enchantments.MENDING))))
                        .with(ItemEntry.builder(Items.BOOK).weight(1).apply((new EnchantRandomlyLootFunction.Builder()).option(impl.getOrThrow(Enchantments.UNBREAKING))))
                        .with(ItemEntry.builder(Items.BOOK).weight(1).apply((new EnchantRandomlyLootFunction.Builder()).option(impl.getOrThrow(Enchantments.EFFICIENCY))))
                        .with(ItemEntry.builder(Items.BOOK).weight(1).apply((new EnchantRandomlyLootFunction.Builder()).option(impl.getOrThrow(Enchantments.PROTECTION))))
                ));

        lootTableBiConsumer.accept(ModLootTables.OMINOUS_IRON_BLIND_BOX,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(10.0F))
                        .with(LootTableEntry.builder(ModLootTables.OMINOUS_IRON_BLIND_BOX_COMMON).weight(40))
                        .with(LootTableEntry.builder(ModLootTables.OMINOUS_IRON_BLIND_BOX_UNCOMMON).weight(50))
                        .with(LootTableEntry.builder(ModLootTables.OMINOUS_IRON_BLIND_BOX_RARE).weight(8))
                        .with(LootTableEntry.builder(ModLootTables.OMINOUS_IRON_BLIND_BOX_UNIQUE).weight(2))
                ));

        lootTableBiConsumer.accept(ModLootTables.GOLDEN_BLIND_BOX_COMMON,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(LootTableEntry.builder(LootTables.ABANDONED_MINESHAFT_CHEST).weight(19))
                        .with(ItemEntry.builder(Items.DIAMOND).weight(1))
                ));

        lootTableBiConsumer.accept(ModLootTables.GOLDEN_BLIND_BOX_UNCOMMON,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(LootTableEntry.builder(LootTables.JUNGLE_TEMPLE_CHEST).weight(15))
                        .with(LootTableEntry.builder(LootTables.DESERT_PYRAMID_CHEST).weight(15))
                        .with(LootTableEntry.builder(LootTables.STRONGHOLD_CROSSING_CHEST).weight(10))
                        .with(LootTableEntry.builder(LootTables.STRONGHOLD_CORRIDOR_CHEST).weight(5))
                        .with(LootTableEntry.builder(LootTables.STRONGHOLD_LIBRARY_CHEST).weight(5))

                ));

        lootTableBiConsumer.accept(ModLootTables.GOLDEN_BLIND_BOX_RARE,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(LootTableEntry.builder(LootTables.ANCIENT_CITY_CHEST).weight(10))
                        .with(LootTableEntry.builder(LootTables.ANCIENT_CITY_ICE_BOX_CHEST).weight(2))
                        .with(ItemEntry.builder(Items.ENCHANTED_GOLDEN_APPLE).weight(1))
                        .with(ItemEntry.builder(Items.GOLDEN_APPLE).weight(2))
                        .with(ItemEntry.builder(Items.GOLDEN_CARROT).weight(5))
                ));

        lootTableBiConsumer.accept(ModLootTables.GOLDEN_BLIND_BOX_UNIQUE,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(Items.BOOK).weight(9).apply((new SetEnchantmentsLootFunction.Builder()).enchantment(impl.getOrThrow(Enchantments.SWIFT_SNEAK),ConstantLootNumberProvider.create(1.0F))))
                        .with(ItemEntry.builder(Items.BOOK).weight(1).apply((new EnchantRandomlyLootFunction.Builder()).options(RegistryEntryList.of(impl.getOrThrow(Enchantments.SWIFT_SNEAK)))))
                        .with(ItemEntry.builder(Items.GOLDEN_LEGGINGS).weight(15).apply((new SetEnchantmentsLootFunction.Builder()).enchantment(impl.getOrThrow(Enchantments.SWIFT_SNEAK),ConstantLootNumberProvider.create(1.0F))))
                        .with(ItemEntry.builder(Items.GOLDEN_LEGGINGS).weight(5).apply((new EnchantRandomlyLootFunction.Builder()).options(RegistryEntryList.of(impl.getOrThrow(Enchantments.SWIFT_SNEAK)))))
                        .with(ItemEntry.builder(Items.ANCIENT_DEBRIS).weight(10))
                        .with(ItemEntry.builder(Items.NETHERITE_SCRAP).weight(20))
                        .with(ItemEntry.builder(ModItems.ANCIENT_TEAR).weight(40))
                ));

        lootTableBiConsumer.accept(ModLootTables.GOLDEN_BLIND_BOX,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(10.0F))
                        .with(LootTableEntry.builder(ModLootTables.GOLDEN_BLIND_BOX_COMMON).weight(40))
                        .with(LootTableEntry.builder(ModLootTables.GOLDEN_BLIND_BOX_UNCOMMON).weight(50))
                        .with(LootTableEntry.builder(ModLootTables.GOLDEN_BLIND_BOX_RARE).weight(8))
                        .with(LootTableEntry.builder(ModLootTables.GOLDEN_BLIND_BOX_UNIQUE).weight(2))));

        lootTableBiConsumer.accept(ModLootTables.OMINOUS_GOLDEN_BLIND_BOX_COMMON,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(LootTableEntry.builder(LootTables.PIGLIN_BARTERING_GAMEPLAY).weight(10))
                        .with(LootTableEntry.builder(LootTables.NETHER_BRIDGE_CHEST).weight(30))
                ));

        lootTableBiConsumer.accept(ModLootTables.OMINOUS_GOLDEN_BLIND_BOX_UNCOMMON,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(LootTableEntry.builder(LootTables.BASTION_BRIDGE_CHEST).weight(2))
                        .with(LootTableEntry.builder(LootTables.BASTION_OTHER_CHEST).weight(2))
                        .with(LootTableEntry.builder(LootTables.BASTION_HOGLIN_STABLE_CHEST).weight(1))
                ));

        lootTableBiConsumer.accept(ModLootTables.OMINOUS_GOLDEN_BLIND_BOX_RARE,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(LootTableEntry.builder(LootTables.BASTION_TREASURE_CHEST).weight(5))
                        .with(ItemEntry.builder(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE).weight(1))
                        .with(ItemEntry.builder(Items.ANCIENT_DEBRIS).weight(3))
                        .with(ItemEntry.builder(Items.NETHERITE_INGOT).weight(1))
                ));

        lootTableBiConsumer.accept(ModLootTables.OMINOUS_GOLDEN_BLIND_BOX_UNIQUE,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(Items.BOOK).weight(8).apply((new SetEnchantmentsLootFunction.Builder()).enchantment(impl.getOrThrow(Enchantments.LOOTING),ConstantLootNumberProvider.create(1.0F))))
                        .with(ItemEntry.builder(Items.BOOK).weight(2).apply((new EnchantRandomlyLootFunction.Builder()).options(RegistryEntryList.of(impl.getOrThrow(Enchantments.LOOTING)))))
                        .with(ItemEntry.builder(Items.BOOK).weight(8).apply((new SetEnchantmentsLootFunction.Builder()).enchantment(impl.getOrThrow(Enchantments.FIRE_PROTECTION),ConstantLootNumberProvider.create(1.0F))))
                        .with(ItemEntry.builder(Items.BOOK).weight(2).apply((new EnchantRandomlyLootFunction.Builder()).options(RegistryEntryList.of(impl.getOrThrow(Enchantments.FIRE_PROTECTION)))))
                        .with(ItemEntry.builder(Items.ENCHANTED_GOLDEN_APPLE).weight(5))
                        .with(ItemEntry.builder(Items.GOLDEN_APPLE).weight(15))
                        .with(ItemEntry.builder(Items.NETHERITE_INGOT).weight(5))
                ));

        lootTableBiConsumer.accept(ModLootTables.OMINOUS_GOLDEN_BLIND_BOX,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(10.0F))
                        .with(LootTableEntry.builder(ModLootTables.OMINOUS_GOLDEN_BLIND_BOX_COMMON).weight(40))
                        .with(LootTableEntry.builder(ModLootTables.OMINOUS_GOLDEN_BLIND_BOX_UNCOMMON).weight(50))
                        .with(LootTableEntry.builder(ModLootTables.OMINOUS_GOLDEN_BLIND_BOX_RARE).weight(8))
                        .with(LootTableEntry.builder(ModLootTables.OMINOUS_GOLDEN_BLIND_BOX_UNIQUE).weight(2))
                ));

        lootTableBiConsumer.accept(ModLootTables.EMERALD_BLIND_BOX_COMMON,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(LootTableEntry.builder(LootTables.HERO_OF_THE_VILLAGE_ARMORER_GIFT_GAMEPLAY).weight(1))
                        .with(LootTableEntry.builder(LootTables.HERO_OF_THE_VILLAGE_BUTCHER_GIFT_GAMEPLAY).weight(1))
                        .with(LootTableEntry.builder(LootTables.HERO_OF_THE_VILLAGE_CARTOGRAPHER_GIFT_GAMEPLAY).weight(1))
                        .with(LootTableEntry.builder(LootTables.HERO_OF_THE_VILLAGE_CLERIC_GIFT_GAMEPLAY).weight(1))
                        .with(LootTableEntry.builder(LootTables.HERO_OF_THE_VILLAGE_FARMER_GIFT_GAMEPLAY).weight(1))
                        .with(LootTableEntry.builder(LootTables.HERO_OF_THE_VILLAGE_FISHERMAN_GIFT_GAMEPLAY).weight(1))
                        .with(LootTableEntry.builder(LootTables.HERO_OF_THE_VILLAGE_FLETCHER_GIFT_GAMEPLAY).weight(1))
                        .with(LootTableEntry.builder(LootTables.HERO_OF_THE_VILLAGE_LEATHERWORKER_GIFT_GAMEPLAY).weight(1))
                        .with(LootTableEntry.builder(LootTables.HERO_OF_THE_VILLAGE_LIBRARIAN_GIFT_GAMEPLAY).weight(1))
                        .with(LootTableEntry.builder(LootTables.HERO_OF_THE_VILLAGE_MASON_GIFT_GAMEPLAY).weight(1))
                        .with(LootTableEntry.builder(LootTables.HERO_OF_THE_VILLAGE_SHEPHERD_GIFT_GAMEPLAY).weight(1))
                        .with(LootTableEntry.builder(LootTables.HERO_OF_THE_VILLAGE_TOOLSMITH_GIFT_GAMEPLAY).weight(1))
                        .with(LootTableEntry.builder(LootTables.HERO_OF_THE_VILLAGE_WEAPONSMITH_GIFT_GAMEPLAY).weight(1))
                ));

        lootTableBiConsumer.accept(ModLootTables.EMERALD_BLIND_BOX_UNCOMMON,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(Items.EMERALD).weight(120))
                        .with(ItemEntry.builder(Items.REDSTONE).weight(100))
                        .with(ItemEntry.builder(Items.STICK).weight(20))
                        .with(ItemEntry.builder(Items.TOTEM_OF_UNDYING).weight(13))
                        .with(ItemEntry.builder(Items.SUGAR).weight(9))
                        .with(ItemEntry.builder(Items.GLOWSTONE_DUST).weight(9))
                        .with(ItemEntry.builder(Items.SPIDER_EYE).weight(9))
                        .with(ItemEntry.builder(Items.GUNPOWDER).weight(9))
                        .with(ItemEntry.builder(Items.CROSSBOW).weight(6)
                                .apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.98F,0.99F)))
                                .apply((new SetEnchantmentsLootFunction.Builder()).enchantment(impl.getOrThrow(Enchantments.PIERCING), UniformLootNumberProvider.create(0F,1F))))
                        .with(ItemEntry.builder(Items.IRON_AXE).weight(5)
                                .apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.98F,0.99F)))
                                .apply((new SetEnchantmentsLootFunction.Builder()).enchantment(impl.getOrThrow(Enchantments.SHARPNESS), UniformLootNumberProvider.create(0F,1F))))
                ));

        lootTableBiConsumer.accept(ModLootTables.EMERALD_BLIND_BOX_RARE,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(Items.BOOK).weight(10)
                                .apply(EnchantRandomlyLootFunction.builder(registryLookup)))
                        .with(ItemEntry.builder(Items.BOOK).weight(5)
                                .apply((new SetEnchantmentsLootFunction.Builder()).enchantment(impl.getOrThrow(Enchantments.UNBREAKING), ConstantLootNumberProvider.create(3.0F))))
                        .with(ItemEntry.builder(Items.BOOK).weight(5)
                                .apply((new SetEnchantmentsLootFunction.Builder()).enchantment(impl.getOrThrow(Enchantments.MENDING), ConstantLootNumberProvider.create(1.0F))))
                        .with(ItemEntry.builder(Blocks.EMERALD_BLOCK).weight(10))
                        .with(ItemEntry.builder(Items.DIAMOND).weight(4))
                        .with(ItemEntry.builder(Items.GOLDEN_CARROT).weight(3))
                        .with(ItemEntry.builder(Items.GOLDEN_APPLE).weight(2))
                        .with(ItemEntry.builder(Items.ENCHANTED_GOLDEN_APPLE).weight(1))
                ));

        lootTableBiConsumer.accept(ModLootTables.EMERALD_BLIND_BOX_UNIQUE,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(Items.DIAMOND_PICKAXE).weight(8)
                                .apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.8F,0.99F)))
                                .apply((new SetEnchantmentsLootFunction.Builder())
                                        .enchantment(impl.getOrThrow(Enchantments.UNBREAKING), ConstantLootNumberProvider.create(3.0F))
                                        .enchantment(impl.getOrThrow(Enchantments.MENDING), ConstantLootNumberProvider.create(1.0F))
                                        .enchantment(impl.getOrThrow(Enchantments.EFFICIENCY), ConstantLootNumberProvider.create(5.0F))
                                        .enchantment(impl.getOrThrow(Enchantments.VANISHING_CURSE), ConstantLootNumberProvider.create(1.0F))))
                        .with(ItemEntry.builder(Items.DIAMOND_AXE).weight(8)
                                .apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.8F,0.99F)))
                                .apply((new SetEnchantmentsLootFunction.Builder())
                                        .enchantment(impl.getOrThrow(Enchantments.UNBREAKING), ConstantLootNumberProvider.create(3.0F))
                                        .enchantment(impl.getOrThrow(Enchantments.MENDING), ConstantLootNumberProvider.create(1.0F))
                                        .enchantment(impl.getOrThrow(Enchantments.EFFICIENCY), ConstantLootNumberProvider.create(5.0F))
                                        .enchantment(impl.getOrThrow(Enchantments.VANISHING_CURSE), ConstantLootNumberProvider.create(1.0F))))
                        .with(ItemEntry.builder(Items.DIAMOND_SHOVEL).weight(8)
                                .apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.8F,0.99F)))
                                .apply((new SetEnchantmentsLootFunction.Builder())
                                        .enchantment(impl.getOrThrow(Enchantments.UNBREAKING), ConstantLootNumberProvider.create(3.0F))
                                        .enchantment(impl.getOrThrow(Enchantments.MENDING), ConstantLootNumberProvider.create(1.0F))
                                        .enchantment(impl.getOrThrow(Enchantments.EFFICIENCY), ConstantLootNumberProvider.create(5.0F))
                                        .enchantment(impl.getOrThrow(Enchantments.VANISHING_CURSE), ConstantLootNumberProvider.create(1.0F))))
                        .with(ItemEntry.builder(Items.DIAMOND_HOE).weight(8)
                                .apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.8F,0.99F)))
                                .apply((new SetEnchantmentsLootFunction.Builder())
                                        .enchantment(impl.getOrThrow(Enchantments.UNBREAKING), ConstantLootNumberProvider.create(3.0F))
                                        .enchantment(impl.getOrThrow(Enchantments.MENDING), ConstantLootNumberProvider.create(1.0F))
                                        .enchantment(impl.getOrThrow(Enchantments.EFFICIENCY), ConstantLootNumberProvider.create(5.0F))
                                        .enchantment(impl.getOrThrow(Enchantments.VANISHING_CURSE), ConstantLootNumberProvider.create(1.0F))))
                        .with(ItemEntry.builder(Items.BOOK).weight(5)
                                .apply((new SetEnchantmentsLootFunction.Builder())
                                        .enchantment(impl.getOrThrow(Enchantments.LOOTING), ConstantLootNumberProvider.create(3.0F))
                                        .enchantment(impl.getOrThrow(Enchantments.SWEEPING_EDGE), ConstantLootNumberProvider.create(3.0F))
                                        .enchantment(impl.getOrThrow(Enchantments.SHARPNESS), ConstantLootNumberProvider.create(5.0F))
                                        .enchantment(impl.getOrThrow(Enchantments.UNBREAKING), ConstantLootNumberProvider.create(3.0F))
                                        .enchantment(impl.getOrThrow(Enchantments.MENDING), ConstantLootNumberProvider.create(1.0F))
                                        .enchantment(impl.getOrThrow(Enchantments.VANISHING_CURSE), ConstantLootNumberProvider.create(1.0F))))
                        .with(ItemEntry.builder(Items.BOOK).weight(5)
                                .apply((new SetEnchantmentsLootFunction.Builder())
                                        .enchantment(impl.getOrThrow(Enchantments.INFINITY), ConstantLootNumberProvider.create(3.0F))
                                        .enchantment(impl.getOrThrow(Enchantments.PUNCH), ConstantLootNumberProvider.create(3.0F))
                                        .enchantment(impl.getOrThrow(Enchantments.POWER), ConstantLootNumberProvider.create(5.0F))
                                        .enchantment(impl.getOrThrow(Enchantments.FLAME), ConstantLootNumberProvider.create(3.0F))
                                        .enchantment(impl.getOrThrow(Enchantments.UNBREAKING), ConstantLootNumberProvider.create(3.0F))
                                        .enchantment(impl.getOrThrow(Enchantments.VANISHING_CURSE), ConstantLootNumberProvider.create(1.0F))))
                        .with(ItemEntry.builder(Items.ELYTRA).weight(5)
                                .apply((new SetEnchantmentsLootFunction.Builder())
                                        .enchantment(impl.getOrThrow(Enchantments.MENDING), ConstantLootNumberProvider.create(1.0F))
                                        .enchantment(impl.getOrThrow(Enchantments.UNBREAKING), ConstantLootNumberProvider.create(3.0F))
                                        .enchantment(impl.getOrThrow(Enchantments.BINDING_CURSE), ConstantLootNumberProvider.create(1.0F))))
                        .with(ItemEntry.builder(Items.TOTEM_OF_UNDYING).weight(3))
                ));

        lootTableBiConsumer.accept(ModLootTables.EMERALD_BLIND_BOX,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(10.0F))
                        .with(LootTableEntry.builder(ModLootTables.EMERALD_BLIND_BOX_COMMON).weight(40))
                        .with(LootTableEntry.builder(ModLootTables.EMERALD_BLIND_BOX_UNCOMMON).weight(50))
                        .with(LootTableEntry.builder(ModLootTables.EMERALD_BLIND_BOX_RARE).weight(8))
                        .with(LootTableEntry.builder(ModLootTables.EMERALD_BLIND_BOX_UNIQUE).weight(2))));

        lootTableBiConsumer.accept(ModLootTables.OMINOUS_EMERALD_BLIND_BOX_COMMON,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(Items.ROSE_BUSH).weight(1))
                        .with(ItemEntry.builder(Items.GOLDEN_BOOTS).weight(4))
                        .with(ItemEntry.builder(Items.GOLDEN_LEGGINGS).weight(2))
                        .with(ItemEntry.builder(Items.RABBIT_HIDE).weight(3))
                        .with(ItemEntry.builder(Items.RABBIT_STEW).weight(2))
                        .with(ItemEntry.builder(Items.AMETHYST_SHARD).weight(5))
                        .with(ItemEntry.builder(Items.EXPERIENCE_BOTTLE).weight(5))
                        .with(ItemEntry.builder(Items.GLISTERING_MELON_SLICE).weight(5))
                        .with(ItemEntry.builder(Items.CHERRY_CHEST_BOAT).weight(1))
                        .with(ItemEntry.builder(Items.BAMBOO_CHEST_RAFT).weight(1))
                        .with(ItemEntry.builder(Items.MANGROVE_CHEST_BOAT).weight(1))
                        .with(ItemEntry.builder(Items.BIRCH_CHEST_BOAT).weight(1))
                        .with(ItemEntry.builder(ModItems.DIAMOND_SHARD).weight(5))
                        .with(ItemEntry.builder(Items.ARMADILLO_SCUTE).weight(5))
                        .with(ItemEntry.builder(Items.TINTED_GLASS).weight(5))
                        .with(ItemEntry.builder(Blocks.DECORATED_POT).weight(5))
                        .with(ItemEntry.builder(ModBlocks.COMPRESS_WOOL).weight(5))
                        .with(ItemEntry.builder(ModItems.IRON_HAMMER).weight(5))
                        .with(ItemEntry.builder(Items.NETHERITE_SCRAP).weight(1))
                        .with(ItemEntry.builder(Items.SHORT_GRASS).weight(18))
                ));

        lootTableBiConsumer.accept(ModLootTables.OMINOUS_EMERALD_BLIND_BOX_UNCOMMON,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(Items.EMERALD).weight(80))
                        .with(ItemEntry.builder(Items.REDSTONE).weight(100))
                        .with(ItemEntry.builder(Items.STICK).weight(20))
                        .with(ItemEntry.builder(Items.TOTEM_OF_UNDYING).weight(16))
                        .with(ItemEntry.builder(Items.SUGAR).weight(9))
                        .with(ItemEntry.builder(Items.GLOWSTONE_DUST).weight(9))
                        .with(ItemEntry.builder(Items.SPIDER_EYE).weight(9))
                        .with(ItemEntry.builder(Items.GUNPOWDER).weight(9))
                        .with(ItemEntry.builder(Items.LAPIS_LAZULI).weight(30))
                        .with(ItemEntry.builder(Items.EXPERIENCE_BOTTLE).weight(18))
                ));

        lootTableBiConsumer.accept(ModLootTables.OMINOUS_EMERALD_BLIND_BOX_RARE,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(Items.BOOK).weight(1)
                                .apply((new EnchantRandomlyLootFunction.Builder()).options(RegistryEntryList.of(
                                        impl.getOrThrow(Enchantments.MENDING),
                                        impl.getOrThrow(Enchantments.UNBREAKING),
                                        impl.getOrThrow(Enchantments.EFFICIENCY),
                                        impl.getOrThrow(Enchantments.SHARPNESS),
                                        impl.getOrThrow(Enchantments.FORTUNE),
                                        impl.getOrThrow(Enchantments.SILK_TOUCH)))))
                        .with(ItemEntry.builder(Items.BOOK).weight(1)
                                .apply((new EnchantRandomlyLootFunction.Builder()).options(RegistryEntryList.of(
                                        impl.getOrThrow(Enchantments.MENDING),
                                        impl.getOrThrow(Enchantments.UNBREAKING),
                                        impl.getOrThrow(Enchantments.PROTECTION),
                                        impl.getOrThrow(Enchantments.FIRE_PROTECTION),
                                        impl.getOrThrow(Enchantments.PROJECTILE_PROTECTION),
                                        impl.getOrThrow(Enchantments.BLAST_PROTECTION),
                                        impl.getOrThrow(Enchantments.THORNS)))))
                        .with(ItemEntry.builder(Items.BOOK).weight(1)
                                .apply((new EnchantRandomlyLootFunction.Builder()).options(RegistryEntryList.of(
                                        impl.getOrThrow(Enchantments.DEPTH_STRIDER),
                                        impl.getOrThrow(Enchantments.FROST_WALKER),
                                        impl.getOrThrow(Enchantments.SOUL_SPEED),
                                        impl.getOrThrow(Enchantments.FEATHER_FALLING)))))
                        .with(ItemEntry.builder(Items.BOOK).weight(1)
                                .apply((new EnchantRandomlyLootFunction.Builder()).options(RegistryEntryList.of(
                                        impl.getOrThrow(Enchantments.MENDING),
                                        impl.getOrThrow(Enchantments.UNBREAKING),
                                        impl.getOrThrow(Enchantments.DENSITY),
                                        impl.getOrThrow(Enchantments.BREACH),
                                        impl.getOrThrow(Enchantments.WIND_BURST),
                                        impl.getOrThrow(Enchantments.SMITE),
                                        impl.getOrThrow(Enchantments.FIRE_ASPECT),
                                        impl.getOrThrow(Enchantments.BANE_OF_ARTHROPODS)))))
                        .with(ItemEntry.builder(Items.BOOK).weight(1)
                                .apply((new EnchantRandomlyLootFunction.Builder()).options(RegistryEntryList.of(
                                        impl.getOrThrow(Enchantments.SHARPNESS),
                                        impl.getOrThrow(Enchantments.SMITE),
                                        impl.getOrThrow(Enchantments.BANE_OF_ARTHROPODS),
                                        impl.getOrThrow(Enchantments.MENDING),
                                        impl.getOrThrow(Enchantments.UNBREAKING),
                                        impl.getOrThrow(Enchantments.LOOTING),
                                        impl.getOrThrow(Enchantments.KNOCKBACK),
                                        impl.getOrThrow(Enchantments.SWEEPING_EDGE)))))
                        .with(ItemEntry.builder(Items.BOOK).weight(1)
                                .apply((new EnchantRandomlyLootFunction.Builder()).options(RegistryEntryList.of(
                                        impl.getOrThrow(Enchantments.INFINITY),
                                        impl.getOrThrow(Enchantments.POWER),
                                        impl.getOrThrow(Enchantments.UNBREAKING),
                                        impl.getOrThrow(Enchantments.MENDING),
                                        impl.getOrThrow(Enchantments.FLAME),
                                        impl.getOrThrow(Enchantments.PUNCH)))))
                        .with(ItemEntry.builder(Items.BOOK).weight(1)
                                .apply((new EnchantRandomlyLootFunction.Builder()).options(RegistryEntryList.of(
                                        impl.getOrThrow(Enchantments.MENDING),
                                        impl.getOrThrow(Enchantments.UNBREAKING),
                                        impl.getOrThrow(Enchantments.MULTISHOT),
                                        impl.getOrThrow(Enchantments.PIERCING),
                                        impl.getOrThrow(Enchantments.QUICK_CHARGE)))))
                        .with(ItemEntry.builder(Items.BOOK).weight(1)
                                .apply((new EnchantRandomlyLootFunction.Builder()).options(RegistryEntryList.of(
                                        impl.getOrThrow(Enchantments.MENDING),
                                        impl.getOrThrow(Enchantments.UNBREAKING),
                                        impl.getOrThrow(Enchantments.CHANNELING),
                                        impl.getOrThrow(Enchantments.IMPALING),
                                        impl.getOrThrow(Enchantments.LOYALTY),
                                        impl.getOrThrow(Enchantments.RIPTIDE)))))
                ));

        lootTableBiConsumer.accept(ModLootTables.OMINOUS_EMERALD_BLIND_BOX_UNIQUE,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(Items.DIAMOND_PICKAXE).weight(12)
                                .apply((new SetEnchantmentsLootFunction.Builder())
                                        .enchantment(impl.getOrThrow(Enchantments.MENDING), ConstantLootNumberProvider.create(1.0F))
                                        .enchantment(impl.getOrThrow(Enchantments.SILK_TOUCH), ConstantLootNumberProvider.create(1.0F))
                                        .enchantment(impl.getOrThrow(Enchantments.UNBREAKING), ConstantLootNumberProvider.create(3.0F))
                                        .enchantment(impl.getOrThrow(Enchantments.EFFICIENCY), ConstantLootNumberProvider.create(5.0F))))
                        .with(ItemEntry.builder(Items.DIAMOND_SHOVEL).weight(3)
                                .apply((new SetEnchantmentsLootFunction.Builder())
                                        .enchantment(impl.getOrThrow(Enchantments.MENDING), ConstantLootNumberProvider.create(1.0F))
                                        .enchantment(impl.getOrThrow(Enchantments.SILK_TOUCH), ConstantLootNumberProvider.create(1.0F))
                                        .enchantment(impl.getOrThrow(Enchantments.UNBREAKING), ConstantLootNumberProvider.create(3.0F))
                                        .enchantment(impl.getOrThrow(Enchantments.EFFICIENCY), ConstantLootNumberProvider.create(5.0F))))
                        .with(ItemEntry.builder(Items.DIAMOND_AXE).weight(1)
                                .apply((new SetEnchantmentsLootFunction.Builder())
                                        .enchantment(impl.getOrThrow(Enchantments.MENDING), ConstantLootNumberProvider.create(1.0F))
                                        .enchantment(impl.getOrThrow(Enchantments.SILK_TOUCH), ConstantLootNumberProvider.create(1.0F))
                                        .enchantment(impl.getOrThrow(Enchantments.UNBREAKING), ConstantLootNumberProvider.create(3.0F))
                                        .enchantment(impl.getOrThrow(Enchantments.EFFICIENCY), ConstantLootNumberProvider.create(5.0F))
                                        .enchantment(impl.getOrThrow(Enchantments.SHARPNESS), ConstantLootNumberProvider.create(5.0F))))
                ));

        lootTableBiConsumer.accept(ModLootTables.OMINOUS_EMERALD_BLIND_BOX,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(10.0F))
                        .with(LootTableEntry.builder(ModLootTables.OMINOUS_EMERALD_BLIND_BOX_COMMON).weight(40))
                        .with(LootTableEntry.builder(ModLootTables.OMINOUS_EMERALD_BLIND_BOX_UNCOMMON).weight(50))
                        .with(LootTableEntry.builder(ModLootTables.OMINOUS_EMERALD_BLIND_BOX_RARE).weight(8))
                        .with(LootTableEntry.builder(ModLootTables.OMINOUS_EMERALD_BLIND_BOX_UNIQUE).weight(2))
                ));

        lootTableBiConsumer.accept(ModLootTables.DIAMOND_BLIND_BOX_COMMON,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(LootTableEntry.builder(LootTables.TRIAL_CHAMBER_CONSUMABLES_SPAWNER).weight(25))
                        .with(LootTableEntry.builder(LootTables.TRIAL_CHAMBERS_SUPPLY_CHEST).weight(5))
                        .with(LootTableEntry.builder(LootTables.TRIAL_CHAMBERS_ENTRANCE_CHEST).weight(5))
                        .with(LootTableEntry.builder(LootTables.TRIAL_CHAMBERS_CORRIDOR_CHEST).weight(5))
                        .with(LootTableEntry.builder(LootTables.TRIAL_CHAMBERS_REWARD_COMMON_CHEST).weight(40))
                ));

        lootTableBiConsumer.accept(ModLootTables.DIAMOND_BLIND_BOX_UNCOMMON,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(LootTableEntry.builder(LootTables.TRIAL_CHAMBERS_REWARD_RARE_CHEST))
                ));

        lootTableBiConsumer.accept(ModLootTables.DIAMOND_BLIND_BOX_RARE,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(LootTableEntry.builder(LootTables.TRIAL_CHAMBERS_REWARD_UNIQUE_CHEST))
                ));

        lootTableBiConsumer.accept(ModLootTables.DIAMOND_BLIND_BOX_UNIQUE,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(Items.NETHER_STAR).weight(1))
                        .with(ItemEntry.builder(ModItems.ELYTRA_PROTOTYPE).weight(1))
                        .with(ItemEntry.builder(ModItems.PULSE_OF_THE_SEA).weight(1))
                        .with(ItemEntry.builder(Items.NETHERITE_SCRAP).weight(2))
                        .with(ItemEntry.builder(Items.BOOK).weight(10)
                                .apply(EnchantWithLevelsLootFunction.builder(registryLookup, UniformLootNumberProvider.create(5.0F, 45.0F))))
                ));

        lootTableBiConsumer.accept(ModLootTables.DIAMOND_BLIND_BOX,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(10.0F))
                        .with(LootTableEntry.builder(ModLootTables.DIAMOND_BLIND_BOX_COMMON).weight(40))
                        .with(LootTableEntry.builder(ModLootTables.DIAMOND_BLIND_BOX_UNCOMMON).weight(50))
                        .with(LootTableEntry.builder(ModLootTables.DIAMOND_BLIND_BOX_RARE).weight(8))
                        .with(LootTableEntry.builder(ModLootTables.DIAMOND_BLIND_BOX_UNIQUE).weight(2))));

        lootTableBiConsumer.accept(ModLootTables.OMINOUS_DIAMOND_BLIND_BOX_COMMON,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(LootTableEntry.builder(LootTables.OMINOUS_TRIAL_CHAMBER_CONSUMABLES_SPAWNER).weight(25))
                        .with(LootTableEntry.builder(LootTables.TRIAL_CHAMBERS_INTERSECTION_CHEST).weight(5))
                        .with(LootTableEntry.builder(LootTables.TRIAL_CHAMBERS_INTERSECTION_BARREL_CHEST).weight(5))
                        .with(LootTableEntry.builder(LootTables.TRIAL_CHAMBERS_CORRIDOR_POT).weight(5))
                        .with(LootTableEntry.builder(LootTables.TRIAL_CHAMBERS_REWARD_OMINOUS_COMMON_CHEST).weight(40))
                ));

        lootTableBiConsumer.accept(ModLootTables.OMINOUS_DIAMOND_BLIND_BOX_UNCOMMON,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(LootTableEntry.builder(LootTables.TRIAL_CHAMBERS_REWARD_OMINOUS_RARE_CHEST))
                ));

        lootTableBiConsumer.accept(ModLootTables.OMINOUS_DIAMOND_BLIND_BOX_RARE,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(LootTableEntry.builder(LootTables.TRIAL_CHAMBERS_REWARD_OMINOUS_UNIQUE_CHEST))
                ));

        lootTableBiConsumer.accept(ModLootTables.OMINOUS_DIAMOND_BLIND_BOX_UNIQUE,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(ModItems.HEAVY_CORE_PROTOTYPE).weight(1))
                        .with(ItemEntry.builder(Blocks.NETHERITE_BLOCK).weight(2))
                        .with(ItemEntry.builder(Items.NETHERITE_INGOT).weight(3))
                        .with(ItemEntry.builder(Items.NETHERITE_SCRAP).weight(4))
                        .with(ItemEntry.builder(ModItems.ANCIENT_PROTOTYPE).weight(10))
                ));

        lootTableBiConsumer.accept(ModLootTables.OMINOUS_DIAMOND_BLIND_BOX,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(10.0F))
                        .with(LootTableEntry.builder(ModLootTables.OMINOUS_DIAMOND_BLIND_BOX_COMMON).weight(40))
                        .with(LootTableEntry.builder(ModLootTables.OMINOUS_DIAMOND_BLIND_BOX_UNCOMMON).weight(50))
                        .with(LootTableEntry.builder(ModLootTables.OMINOUS_DIAMOND_BLIND_BOX_RARE).weight(8))
                        .with(LootTableEntry.builder(ModLootTables.OMINOUS_DIAMOND_BLIND_BOX_UNIQUE).weight(2))
                ));

        lootTableBiConsumer.accept(ModLootTables.NETHERITE_BLIND_BOX_COMMON,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(Items.EMERALD).weight(4).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F,4.0F))))
                        .with(ItemEntry.builder(Items.WIND_CHARGE).weight(5).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F,3.0F))))
                        .with(ItemEntry.builder(Items.DIAMOND).weight(1).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F,3.0F))))
                        .with(ItemEntry.builder(Items.HONEYCOMB).weight(3).apply(SetPotionLootFunction.builder(Potions.OOZING)))
                        .with(ItemEntry.builder(Items.GOLD_INGOT).weight(2).apply(SetPotionLootFunction.builder(Potions.INFESTED)))
                ));

        lootTableBiConsumer.accept(ModLootTables.NETHERITE_BLIND_BOX_UNCOMMON,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(Items.EMERALD).weight(3))
                        .with(ItemEntry.builder(Items.GOLDEN_CARROT).weight(2))
                        .with(ItemEntry.builder(Items.GOLDEN_APPLE).weight(1))
                        .with(ItemEntry.builder(Items.BOOK).weight(1)
                                .apply((new EnchantRandomlyLootFunction.Builder()).options(RegistryEntryList.of(
                                        impl.getOrThrow(Enchantments.SHARPNESS),
                                        impl.getOrThrow(Enchantments.BANE_OF_ARTHROPODS),
                                        impl.getOrThrow(Enchantments.EFFICIENCY),
                                        impl.getOrThrow(Enchantments.FORTUNE),
                                        impl.getOrThrow(Enchantments.SILK_TOUCH),
                                        impl.getOrThrow(Enchantments.FEATHER_FALLING)))))
                        .with(ItemEntry.builder(Items.BOOK).weight(1)
                                .apply((new EnchantRandomlyLootFunction.Builder()).options(RegistryEntryList.of(
                                        impl.getOrThrow(Enchantments.RIPTIDE),
                                        impl.getOrThrow(Enchantments.LOYALTY),
                                        impl.getOrThrow(Enchantments.CHANNELING),
                                        impl.getOrThrow(Enchantments.IMPALING),
                                        impl.getOrThrow(Enchantments.MENDING)))))
                        .with(ItemEntry.builder(Items.BOOK).weight(1)
                                .apply((new EnchantRandomlyLootFunction.Builder()).options(RegistryEntryList.of(
                                        impl.getOrThrow(Enchantments.DENSITY),
                                        impl.getOrThrow(Enchantments.BREACH)))))
                        .with(ItemEntry.builder(Items.BOOK).weight(1)
                                .apply(EnchantWithLevelsLootFunction.builder(registryLookup, UniformLootNumberProvider.create(20F,40F))))
                ));

        lootTableBiConsumer.accept(ModLootTables.NETHERITE_BLIND_BOX_RARE,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(LootTableEntry.builder(LootTables.TRIAL_CHAMBERS_REWARD_UNIQUE_CHEST).weight(8))
                        .with(LootTableEntry.builder(LootTables.TRIAL_CHAMBERS_REWARD_OMINOUS_UNIQUE_CHEST).weight(2))
                        .with(ItemEntry.builder(Items.TRIDENT).weight(5))
                        .with(ItemEntry.builder(Items.BOOK).weight(5)
                                .apply(EnchantWithLevelsLootFunction.builder(registryLookup, UniformLootNumberProvider.create(30.F,70.F))))
                ));

        lootTableBiConsumer.accept(ModLootTables.NETHERITE_BLIND_BOX_UNIQUE,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(Items.HEAVY_CORE).weight(7))
                        .with(ItemEntry.builder(Items.BOOK)
                                .apply((new SetEnchantmentsLootFunction.Builder()).enchantment(impl.getOrThrow(Enchantments.WIND_BURST), UniformLootNumberProvider.create(1.0F,3.0F))).weight(10))
                        .with(ItemEntry.builder(Items.MACE).weight(3)
                                .apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.5F,0.95F)))
                                .apply(EnchantRandomlyLootFunction.builder(registryLookup)))
                ));

        lootTableBiConsumer.accept(ModLootTables.NETHERITE_BLIND_BOX,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(10.0F))
                        .with(LootTableEntry.builder(ModLootTables.NETHERITE_BLIND_BOX_COMMON).weight(40))
                        .with(LootTableEntry.builder(ModLootTables.NETHERITE_BLIND_BOX_UNCOMMON).weight(50))
                        .with(LootTableEntry.builder(ModLootTables.NETHERITE_BLIND_BOX_RARE).weight(8))
                        .with(LootTableEntry.builder(ModLootTables.NETHERITE_BLIND_BOX_UNIQUE).weight(2))));

        lootTableBiConsumer.accept(ModLootTables.OMINOUS_NETHERITE_BLIND_BOX_COMMON,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(Items.EMERALD).weight(5).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4.0F,10.0F))))
                        .with(ItemEntry.builder(Items.WIND_CHARGE).weight(4).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4.0F,6.0F))))
                        .with(ItemEntry.builder(Items.BREEZE_ROD).weight(1).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F,3.0F))))
                        .with(ItemEntry.builder(Items.DIAMOND).weight(2).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F,3.0F))))
                        .with(ItemEntry.builder(Items.SPLASH_POTION).weight(1).apply(SetPotionLootFunction.builder(Potions.OOZING)))
                        .with(ItemEntry.builder(Items.SPLASH_POTION).weight(1).apply(SetPotionLootFunction.builder(Potions.INFESTED)))
                        .with(ItemEntry.builder(Items.OMINOUS_BOTTLE).weight(1)).apply(SetOminousBottleAmplifierLootFunction.builder(UniformLootNumberProvider.create(2.0F, 4.0F)))
                ));

        lootTableBiConsumer.accept(ModLootTables.OMINOUS_NETHERITE_BLIND_BOX_UNCOMMON,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(Items.EMERALD_BLOCK).weight(6))
                        .with(ItemEntry.builder(Items.DIAMOND_BLOCK).weight(1))
                        .with(ItemEntry.builder(Items.GOLD_BLOCK).weight(4))
                        .with(ItemEntry.builder(Items.BOOK).weight(1)
                                .apply((new SetEnchantmentsLootFunction.Builder()).enchantment(
                                        impl.getOrThrow(Enchantments.WIND_BURST), ConstantLootNumberProvider.create(1.0F))))
                        .with(ItemEntry.builder(Items.BOOK).weight(2)
                                .apply((new EnchantRandomlyLootFunction.Builder()).options(RegistryEntryList.of(
                                        impl.getOrThrow(Enchantments.KNOCKBACK),
                                        impl.getOrThrow(Enchantments.PUNCH),
                                        impl.getOrThrow(Enchantments.SMITE),
                                        impl.getOrThrow(Enchantments.LOOTING),
                                        impl.getOrThrow(Enchantments.MULTISHOT)))))
                        .with(ItemEntry.builder(Items.BOOK).weight(2)
                                .apply((new EnchantRandomlyLootFunction.Builder()).options(RegistryEntryList.of(
                                        impl.getOrThrow(Enchantments.BREACH),
                                        impl.getOrThrow(Enchantments.DENSITY)))))
                        .with(ItemEntry.builder(Items.GOLDEN_APPLE).weight(3))
                        .with(ItemEntry.builder(Items.ENCHANTED_GOLDEN_APPLE).weight(1))
                ));

        lootTableBiConsumer.accept(ModLootTables.OMINOUS_NETHERITE_BLIND_BOX_RARE,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(Items.HEAVY_CORE).weight(5))
                        .with(ItemEntry.builder(Items.ENCHANTED_GOLDEN_APPLE).weight(4))
                        .with(ItemEntry.builder(Items.MACE).weight(1)
                                .apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.5F,0.8F)))
                                .apply((new SetEnchantmentsLootFunction.Builder()).enchantment(impl.getOrThrow(Enchantments.WIND_BURST), UniformLootNumberProvider.create(0.0F, 3.0F))))
                ));

        lootTableBiConsumer.accept(ModLootTables.OMINOUS_NETHERITE_BLIND_BOX_UNIQUE,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(Items.HEAVY_CORE).weight(1))
                        .with(ItemEntry.builder(Items.BOOK).weight(1)
                                .apply((new SetEnchantmentsLootFunction.Builder()).enchantment(impl.getOrThrow(Enchantments.WIND_BURST), ConstantLootNumberProvider.create(3.0F))))
                ));

        lootTableBiConsumer.accept(ModLootTables.OMINOUS_NETHERITE_BLIND_BOX,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(10.0F))
                        .with(LootTableEntry.builder(ModLootTables.OMINOUS_NETHERITE_BLIND_BOX_COMMON).weight(40))
                        .with(LootTableEntry.builder(ModLootTables.OMINOUS_NETHERITE_BLIND_BOX_UNCOMMON).weight(50))
                        .with(LootTableEntry.builder(ModLootTables.OMINOUS_NETHERITE_BLIND_BOX_RARE).weight(8))
                        .with(LootTableEntry.builder(ModLootTables.OMINOUS_NETHERITE_BLIND_BOX_UNIQUE).weight(2))
                ));
    }
    
    

    @Override
    public CompletableFuture<?> run(DataWriter writer) {
        return FabricLootTableProviderImpl.run(writer, this, LootContextTypes.CHEST, output, completableFuture);
    }

    @Override
    public String getName() {
        return "Chest Loot Tables";
    }
}
