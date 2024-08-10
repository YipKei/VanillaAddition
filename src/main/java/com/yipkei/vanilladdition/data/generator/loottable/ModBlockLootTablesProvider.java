package com.yipkei.vanilladdition.data.generator.loottable;

import com.yipkei.vanilladdition.init.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.enums.SlabType;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.LootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTablesProvider extends FabricBlockLootTableProvider {

    public ModBlockLootTablesProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.STEEL_BLOCK);
        addDrop(ModBlocks.COMPRESS_WOOL);
        
        addDrop(ModBlocks.STONE_WALL);
        addDrop(ModBlocks.POLISHED_GRANITE_WALL);
        addDrop(ModBlocks.POLISHED_DIORITE_WALL);
        addDrop(ModBlocks.POLISHED_ANDESITE_WALL);
        addDrop(ModBlocks.SMOOTH_SANDSTONE_WALL);
        addDrop(ModBlocks.SMOOTH_RED_SANDSTONE_WALL);
        addDrop(ModBlocks.PRISMARINE_BRICK_WALL);
        addDrop(ModBlocks.DARK_PRISMARINE_WALL);
        addDrop(ModBlocks.PURPUR_WALL);
        addDrop(ModBlocks.QUARTZ_WALL);
        addDrop(ModBlocks.SMOOTH_QUARTZ_WALL);
        
        addDrop(ModBlocks.SMOOTH_STONE_WALL);
        addDrop(ModBlocks.SMOOTH_STONE_STAIRS);

        addDrop(ModBlocks.BASALT_WALL);
        addDrop(ModBlocks.BASALT_STAIRS);
        addDrop(ModBlocks.BASALT_SLAB, slabDrops(ModBlocks.BASALT_SLAB));

        addDrop(ModBlocks.SMOOTH_BASALT_WALL);
        addDrop(ModBlocks.SMOOTH_BASALT_STAIRS);
        addDrop(ModBlocks.SMOOTH_BASALT_SLAB, slabDrops(ModBlocks.SMOOTH_BASALT_SLAB));

        addDrop(ModBlocks.POLISHED_BASALT_WALL);
        addDrop(ModBlocks.POLISHED_BASALT_STAIRS);
        addDrop(ModBlocks.POLISHED_BASALT_SLAB, slabDrops(ModBlocks.POLISHED_BASALT_SLAB));
        
        addDrop(ModBlocks.DIRT_WALL);
        addDrop(ModBlocks.DIRT_STAIRS);
        addDrop(ModBlocks.DIRT_SLAB, slabDrops(ModBlocks.DIRT_SLAB));
        
        addDrop(ModBlocks.MUD_WALL);
        addDrop(ModBlocks.MUD_STAIRS);
        addDrop(ModBlocks.MUD_SLAB, slabDrops(ModBlocks.MUD_SLAB));
        
        addDrop(ModBlocks.CLAY_WALL);
        addDrop(ModBlocks.CLAY_STAIRS);
        addDrop(ModBlocks.CLAY_SLAB, slabDrops(ModBlocks.CLAY_SLAB));

        addDrop(ModBlocks.CALCITE_WALL);
        addDrop(ModBlocks.CALCITE_STAIRS);
        addDrop(ModBlocks.CALCITE_SLAB, slabDrops(ModBlocks.CALCITE_SLAB));

        addDrop(ModBlocks.NETHERRACK_WALL);
        addDrop(ModBlocks.NETHERRACK_STAIRS);
        addDrop(ModBlocks.NETHERRACK_SLAB, slabDrops(ModBlocks.NETHERRACK_SLAB));

        addDrop(ModBlocks.OBSIDIAN_WALL);
        addDrop(ModBlocks.OBSIDIAN_STAIRS);
        addDrop(ModBlocks.OBSIDIAN_SLAB, slabDrops(ModBlocks.OBSIDIAN_SLAB));

        addDrop(ModBlocks.CRYING_OBSIDIAN_WALL);
        addDrop(ModBlocks.CRYING_OBSIDIAN_STAIRS);
        addDrop(ModBlocks.CRYING_OBSIDIAN_SLAB, slabDrops(ModBlocks.CRYING_OBSIDIAN_SLAB));

        addDrop(ModBlocks.END_STONE_WALL);
        addDrop(ModBlocks.END_STONE_STAIRS);
        addDrop(ModBlocks.END_STONE_SLAB, slabDrops(ModBlocks.END_STONE_SLAB));

        addDrop(ModBlocks.AMETHYST_WALL);
        addDrop(ModBlocks.AMETHYST_STAIRS);
        addDrop(ModBlocks.AMETHYST_SLAB, slabDrops(ModBlocks.AMETHYST_SLAB));

        addDrop(ModBlocks.GLOWSTONE_WALL);
        addDrop(ModBlocks.GLOWSTONE_STAIRS);
        addDrop(ModBlocks.GLOWSTONE_SLAB, slabDrops(ModBlocks.GLOWSTONE_SLAB));

        addDropWithSilkTouch(ModBlocks.ICE_WALL);
        addDropWithSilkTouch(ModBlocks.ICE_STAIRS);
        addDrop(ModBlocks.ICE_SLAB, slabDropsWithSilkTouch(ModBlocks.ICE_SLAB));

        addDropWithSilkTouch(ModBlocks.PACKED_ICE_WALL);
        addDropWithSilkTouch(ModBlocks.PACKED_ICE_STAIRS);
        addDrop(ModBlocks.PACKED_ICE_SLAB, slabDropsWithSilkTouch(ModBlocks.PACKED_ICE_SLAB));

        addDropWithSilkTouch(ModBlocks.BLUE_ICE_WALL);
        addDropWithSilkTouch(ModBlocks.BLUE_ICE_STAIRS);
        addDrop(ModBlocks.BLUE_ICE_SLAB, slabDropsWithSilkTouch(ModBlocks.BLUE_ICE_SLAB));

        addDrop(ModBlocks.WHITE_CONCRETE_WALL);
        addDrop(ModBlocks.WHITE_CONCRETE_STAIRS);
        addDrop(ModBlocks.WHITE_CONCRETE_SLAB, slabDrops(ModBlocks.WHITE_CONCRETE_SLAB));

        addDrop(ModBlocks.LIGHT_GRAY_CONCRETE_WALL);
        addDrop(ModBlocks.LIGHT_GRAY_CONCRETE_STAIRS);
        addDrop(ModBlocks.LIGHT_GRAY_CONCRETE_SLAB, slabDrops(ModBlocks.LIGHT_GRAY_CONCRETE_SLAB));

        addDrop(ModBlocks.GRAY_CONCRETE_WALL);
        addDrop(ModBlocks.GRAY_CONCRETE_STAIRS);
        addDrop(ModBlocks.GRAY_CONCRETE_SLAB, slabDrops(ModBlocks.GRAY_CONCRETE_SLAB));

        addDrop(ModBlocks.BLACK_CONCRETE_WALL);
        addDrop(ModBlocks.BLACK_CONCRETE_STAIRS);
        addDrop(ModBlocks.BLACK_CONCRETE_SLAB, slabDrops(ModBlocks.BLACK_CONCRETE_SLAB));

        addDrop(ModBlocks.BROWN_CONCRETE_WALL);
        addDrop(ModBlocks.BROWN_CONCRETE_STAIRS);
        addDrop(ModBlocks.BROWN_CONCRETE_SLAB, slabDrops(ModBlocks.BROWN_CONCRETE_SLAB));

        addDrop(ModBlocks.RED_CONCRETE_WALL);
        addDrop(ModBlocks.RED_CONCRETE_STAIRS);
        addDrop(ModBlocks.RED_CONCRETE_SLAB, slabDrops(ModBlocks.RED_CONCRETE_SLAB));

        addDrop(ModBlocks.ORANGE_CONCRETE_WALL);
        addDrop(ModBlocks.ORANGE_CONCRETE_STAIRS);
        addDrop(ModBlocks.ORANGE_CONCRETE_SLAB, slabDrops(ModBlocks.ORANGE_CONCRETE_SLAB));

        addDrop(ModBlocks.YELLOW_CONCRETE_WALL);
        addDrop(ModBlocks.YELLOW_CONCRETE_STAIRS);
        addDrop(ModBlocks.YELLOW_CONCRETE_SLAB, slabDrops(ModBlocks.YELLOW_CONCRETE_SLAB));

        addDrop(ModBlocks.LIME_CONCRETE_WALL);
        addDrop(ModBlocks.LIME_CONCRETE_STAIRS);
        addDrop(ModBlocks.LIME_CONCRETE_SLAB, slabDrops(ModBlocks.LIME_CONCRETE_SLAB));

        addDrop(ModBlocks.GREEN_CONCRETE_WALL);
        addDrop(ModBlocks.GREEN_CONCRETE_STAIRS);
        addDrop(ModBlocks.GREEN_CONCRETE_SLAB, slabDrops(ModBlocks.GREEN_CONCRETE_SLAB));

        addDrop(ModBlocks.CYAN_CONCRETE_WALL);
        addDrop(ModBlocks.CYAN_CONCRETE_STAIRS);
        addDrop(ModBlocks.CYAN_CONCRETE_SLAB, slabDrops(ModBlocks.CYAN_CONCRETE_SLAB));

        addDrop(ModBlocks.LIGHT_BLUE_CONCRETE_WALL);
        addDrop(ModBlocks.LIGHT_BLUE_CONCRETE_STAIRS);
        addDrop(ModBlocks.LIGHT_BLUE_CONCRETE_SLAB, slabDrops(ModBlocks.LIGHT_BLUE_CONCRETE_SLAB));

        addDrop(ModBlocks.BLUE_CONCRETE_WALL);
        addDrop(ModBlocks.BLUE_CONCRETE_STAIRS);
        addDrop(ModBlocks.BLUE_CONCRETE_SLAB, slabDrops(ModBlocks.BLUE_CONCRETE_SLAB));

        addDrop(ModBlocks.PURPLE_CONCRETE_WALL);
        addDrop(ModBlocks.PURPLE_CONCRETE_STAIRS);
        addDrop(ModBlocks.PURPLE_CONCRETE_SLAB, slabDrops(ModBlocks.PURPLE_CONCRETE_SLAB));

        addDrop(ModBlocks.MAGENTA_CONCRETE_WALL);
        addDrop(ModBlocks.MAGENTA_CONCRETE_STAIRS);
        addDrop(ModBlocks.MAGENTA_CONCRETE_SLAB, slabDrops(ModBlocks.MAGENTA_CONCRETE_SLAB));

        addDrop(ModBlocks.PINK_CONCRETE_WALL);
        addDrop(ModBlocks.PINK_CONCRETE_STAIRS);
        addDrop(ModBlocks.PINK_CONCRETE_SLAB, slabDrops(ModBlocks.PINK_CONCRETE_SLAB));

        addDrop(ModBlocks.TERRACOTTA_WALL);
        addDrop(ModBlocks.TERRACOTTA_STAIRS);
        addDrop(ModBlocks.TERRACOTTA_SLAB, slabDrops(ModBlocks.TERRACOTTA_SLAB));

        addDrop(ModBlocks.WHITE_TERRACOTTA_WALL);
        addDrop(ModBlocks.WHITE_TERRACOTTA_STAIRS);
        addDrop(ModBlocks.WHITE_TERRACOTTA_SLAB, slabDrops(ModBlocks.WHITE_TERRACOTTA_SLAB));

        addDrop(ModBlocks.LIGHT_GRAY_TERRACOTTA_WALL);
        addDrop(ModBlocks.LIGHT_GRAY_TERRACOTTA_STAIRS);
        addDrop(ModBlocks.LIGHT_GRAY_TERRACOTTA_SLAB, slabDrops(ModBlocks.LIGHT_GRAY_TERRACOTTA_SLAB));

        addDrop(ModBlocks.GRAY_TERRACOTTA_WALL);
        addDrop(ModBlocks.GRAY_TERRACOTTA_STAIRS);
        addDrop(ModBlocks.GRAY_TERRACOTTA_SLAB, slabDrops(ModBlocks.GRAY_TERRACOTTA_SLAB));

        addDrop(ModBlocks.BLACK_TERRACOTTA_WALL);
        addDrop(ModBlocks.BLACK_TERRACOTTA_STAIRS);
        addDrop(ModBlocks.BLACK_TERRACOTTA_SLAB, slabDrops(ModBlocks.BLACK_TERRACOTTA_SLAB));

        addDrop(ModBlocks.BROWN_TERRACOTTA_WALL);
        addDrop(ModBlocks.BROWN_TERRACOTTA_STAIRS);
        addDrop(ModBlocks.BROWN_TERRACOTTA_SLAB, slabDrops(ModBlocks.BROWN_TERRACOTTA_SLAB));

        addDrop(ModBlocks.RED_TERRACOTTA_WALL);
        addDrop(ModBlocks.RED_TERRACOTTA_STAIRS);
        addDrop(ModBlocks.RED_TERRACOTTA_SLAB, slabDrops(ModBlocks.RED_TERRACOTTA_SLAB));

        addDrop(ModBlocks.ORANGE_TERRACOTTA_WALL);
        addDrop(ModBlocks.ORANGE_TERRACOTTA_STAIRS);
        addDrop(ModBlocks.ORANGE_TERRACOTTA_SLAB, slabDrops(ModBlocks.ORANGE_TERRACOTTA_SLAB));

        addDrop(ModBlocks.YELLOW_TERRACOTTA_WALL);
        addDrop(ModBlocks.YELLOW_TERRACOTTA_STAIRS);
        addDrop(ModBlocks.YELLOW_TERRACOTTA_SLAB, slabDrops(ModBlocks.YELLOW_TERRACOTTA_SLAB));

        addDrop(ModBlocks.LIME_TERRACOTTA_WALL);
        addDrop(ModBlocks.LIME_TERRACOTTA_STAIRS);
        addDrop(ModBlocks.LIME_TERRACOTTA_SLAB, slabDrops(ModBlocks.LIME_TERRACOTTA_SLAB));

        addDrop(ModBlocks.GREEN_TERRACOTTA_WALL);
        addDrop(ModBlocks.GREEN_TERRACOTTA_STAIRS);
        addDrop(ModBlocks.GREEN_TERRACOTTA_SLAB, slabDrops(ModBlocks.GREEN_TERRACOTTA_SLAB));

        addDrop(ModBlocks.CYAN_TERRACOTTA_WALL);
        addDrop(ModBlocks.CYAN_TERRACOTTA_STAIRS);
        addDrop(ModBlocks.CYAN_TERRACOTTA_SLAB, slabDrops(ModBlocks.CYAN_TERRACOTTA_SLAB));

        addDrop(ModBlocks.LIGHT_BLUE_TERRACOTTA_WALL);
        addDrop(ModBlocks.LIGHT_BLUE_TERRACOTTA_STAIRS);
        addDrop(ModBlocks.LIGHT_BLUE_TERRACOTTA_SLAB, slabDrops(ModBlocks.LIGHT_BLUE_TERRACOTTA_SLAB));

        addDrop(ModBlocks.BLUE_TERRACOTTA_WALL);
        addDrop(ModBlocks.BLUE_TERRACOTTA_STAIRS);
        addDrop(ModBlocks.BLUE_TERRACOTTA_SLAB, slabDrops(ModBlocks.BLUE_TERRACOTTA_SLAB));

        addDrop(ModBlocks.PURPLE_TERRACOTTA_WALL);
        addDrop(ModBlocks.PURPLE_TERRACOTTA_STAIRS);
        addDrop(ModBlocks.PURPLE_TERRACOTTA_SLAB, slabDrops(ModBlocks.PURPLE_TERRACOTTA_SLAB));

        addDrop(ModBlocks.MAGENTA_TERRACOTTA_WALL);
        addDrop(ModBlocks.MAGENTA_TERRACOTTA_STAIRS);
        addDrop(ModBlocks.MAGENTA_TERRACOTTA_SLAB, slabDrops(ModBlocks.MAGENTA_TERRACOTTA_SLAB));

        addDrop(ModBlocks.PINK_TERRACOTTA_WALL);
        addDrop(ModBlocks.PINK_TERRACOTTA_STAIRS);
        addDrop(ModBlocks.PINK_TERRACOTTA_SLAB, slabDrops(ModBlocks.PINK_TERRACOTTA_SLAB));
    }

    public LootTable.Builder slabDropsWithSilkTouch(Block block){
        return LootTable.builder().pool(LootPool.builder().conditionally(this.createSilkTouchCondition()).rolls(ConstantLootNumberProvider.create(1.0f)).with((LootPoolEntry.Builder)this.applyExplosionDecay(block, ItemEntry.builder(block).apply((LootFunction.Builder)((Object) SetCountLootFunction.builder(ConstantLootNumberProvider.create(2.0f)).conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(SlabBlock.TYPE, SlabType.DOUBLE))))))));
    }
}
