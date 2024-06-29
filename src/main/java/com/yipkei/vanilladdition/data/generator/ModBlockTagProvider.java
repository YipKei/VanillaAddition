package com.yipkei.vanilladdition.data.generator;

import com.yipkei.vanilladdition.init.ModBlocks;
import com.yipkei.vanilladdition.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {


        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.OBSIDIAN_WALL, ModBlocks.OBSIDIAN_STAIRS, ModBlocks.OBSIDIAN_SLAB)
                .add(ModBlocks.CRYING_OBSIDIAN_WALL, ModBlocks.CRYING_OBSIDIAN_STAIRS, ModBlocks.CRYING_OBSIDIAN_SLAB)
        ;

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.STEEL_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)

        ;

        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(ModBlocks.DIRT_WALL, ModBlocks.DIRT_STAIRS, ModBlocks.DIRT_SLAB)
                .add(ModBlocks.MUD_WALL, ModBlocks.MUD_STAIRS, ModBlocks.MUD_SLAB)
                .add(ModBlocks.CLAY_WALL, ModBlocks.CLAY_STAIRS, ModBlocks.CLAY_SLAB);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.STEEL_BLOCK)
                .add(ModBlocks.STONE_WALL)
                .add(ModBlocks.SMOOTH_STONE_WALL, ModBlocks.SMOOTH_STONE_STAIRS)
                .add(ModBlocks.CALCITE_WALL, ModBlocks.CALCITE_STAIRS, ModBlocks.CALCITE_SLAB)
                .add(ModBlocks.POLISHED_GRANITE_WALL)
                .add(ModBlocks.POLISHED_DIORITE_WALL)
                .add(ModBlocks.POLISHED_ANDESITE_WALL)
                .add(ModBlocks.SMOOTH_SANDSTONE_WALL)
                .add(ModBlocks.SMOOTH_RED_SANDSTONE_WALL)
                .add(ModBlocks.PRISMARINE_BRICK_WALL)
                .add(ModBlocks.DARK_PRISMARINE_WALL)
                .add(ModBlocks.NETHERRACK_WALL, ModBlocks.NETHERRACK_STAIRS, ModBlocks.NETHERRACK_SLAB)
                .add(ModBlocks.BASALT_WALL, ModBlocks.BASALT_STAIRS, ModBlocks.BASALT_SLAB)
                .add(ModBlocks.SMOOTH_BASALT_WALL, ModBlocks.SMOOTH_BASALT_STAIRS, ModBlocks.SMOOTH_BASALT_SLAB)
                .add(ModBlocks.POLISHED_BASALT_WALL, ModBlocks.POLISHED_BASALT_STAIRS, ModBlocks.POLISHED_BASALT_SLAB)
                .add(ModBlocks.PURPUR_WALL)
                .add(ModBlocks.END_STONE_WALL, ModBlocks.END_STONE_STAIRS, ModBlocks.END_STONE_SLAB)
                .add(ModBlocks.QUARTZ_WALL, ModBlocks.QUARTZ_STAIRS, ModBlocks.QUARTZ_SLAB)
                .add(ModBlocks.SMOOTH_QUARTZ_WALL)
                .add(ModBlocks.AMETHYST_WALL, ModBlocks.AMETHYST_STAIRS, ModBlocks.AMETHYST_SLAB)
                .add(ModBlocks.GLOWSTONE_WALL, ModBlocks.GLOWSTONE_STAIRS, ModBlocks.GLOWSTONE_SLAB)
                .add(ModBlocks.ICE_WALL, ModBlocks.ICE_STAIRS, ModBlocks.ICE_SLAB)
                .add(ModBlocks.PACKED_ICE_WALL, ModBlocks.PACKED_ICE_STAIRS, ModBlocks.PACKED_ICE_SLAB)
                .add(ModBlocks.BLUE_ICE_WALL, ModBlocks.BLUE_ICE_STAIRS, ModBlocks.BLUE_ICE_SLAB)
                .add(ModBlocks.OBSIDIAN_WALL, ModBlocks.OBSIDIAN_STAIRS, ModBlocks.OBSIDIAN_SLAB)
                .add(ModBlocks.CRYING_OBSIDIAN_WALL, ModBlocks.CRYING_OBSIDIAN_STAIRS, ModBlocks.CRYING_OBSIDIAN_SLAB)

                .add(ModBlocks.WHITE_CONCRETE_WALL, ModBlocks.WHITE_CONCRETE_STAIRS, ModBlocks.WHITE_CONCRETE_SLAB)
                .add(ModBlocks.LIGHT_GRAY_CONCRETE_WALL, ModBlocks.LIGHT_GRAY_CONCRETE_STAIRS, ModBlocks.LIGHT_GRAY_CONCRETE_SLAB)
                .add(ModBlocks.GRAY_CONCRETE_WALL, ModBlocks.GRAY_CONCRETE_STAIRS, ModBlocks.GRAY_CONCRETE_SLAB)
                .add(ModBlocks.BLACK_CONCRETE_WALL, ModBlocks.BLACK_CONCRETE_STAIRS, ModBlocks.BLACK_CONCRETE_SLAB)
                .add(ModBlocks.BROWN_CONCRETE_WALL, ModBlocks.BROWN_CONCRETE_STAIRS, ModBlocks.BROWN_CONCRETE_SLAB)
                .add(ModBlocks.RED_CONCRETE_WALL, ModBlocks.RED_CONCRETE_STAIRS, ModBlocks.RED_CONCRETE_SLAB)
                .add(ModBlocks.ORANGE_CONCRETE_WALL, ModBlocks.ORANGE_CONCRETE_STAIRS, ModBlocks.ORANGE_CONCRETE_SLAB)
                .add(ModBlocks.YELLOW_CONCRETE_WALL, ModBlocks.YELLOW_CONCRETE_STAIRS, ModBlocks.YELLOW_CONCRETE_SLAB)
                .add(ModBlocks.LIME_CONCRETE_WALL, ModBlocks.LIME_CONCRETE_STAIRS, ModBlocks.LIME_CONCRETE_SLAB)
                .add(ModBlocks.GREEN_CONCRETE_WALL, ModBlocks.GREEN_CONCRETE_STAIRS, ModBlocks.GRAY_CONCRETE_SLAB)
                .add(ModBlocks.CYAN_CONCRETE_WALL, ModBlocks.CYAN_CONCRETE_STAIRS, ModBlocks.CYAN_CONCRETE_SLAB)
                .add(ModBlocks.LIGHT_BLUE_CONCRETE_WALL, ModBlocks.LIGHT_BLUE_CONCRETE_STAIRS, ModBlocks.LIGHT_BLUE_CONCRETE_SLAB)
                .add(ModBlocks.BLUE_CONCRETE_WALL, ModBlocks.BLUE_CONCRETE_STAIRS, ModBlocks.BLUE_CONCRETE_SLAB)
                .add(ModBlocks.PURPLE_CONCRETE_WALL, ModBlocks.PURPLE_CONCRETE_STAIRS, ModBlocks.PURPLE_CONCRETE_SLAB)
                .add(ModBlocks.MAGENTA_CONCRETE_WALL, ModBlocks.MAGENTA_CONCRETE_STAIRS, ModBlocks.MAGENTA_CONCRETE_SLAB)
                .add(ModBlocks.PINK_CONCRETE_WALL, ModBlocks.PINK_CONCRETE_STAIRS, ModBlocks.PINK_CONCRETE_SLAB)

                .add(ModBlocks.TERRACOTTA_WALL, ModBlocks.TERRACOTTA_STAIRS, ModBlocks.TERRACOTTA_SLAB)
                .add(ModBlocks.WHITE_TERRACOTTA_WALL, ModBlocks.WHITE_TERRACOTTA_STAIRS, ModBlocks.WHITE_TERRACOTTA_SLAB)
                .add(ModBlocks.LIGHT_GRAY_TERRACOTTA_WALL, ModBlocks.LIGHT_GRAY_TERRACOTTA_STAIRS, ModBlocks.LIGHT_GRAY_TERRACOTTA_SLAB)
                .add(ModBlocks.GRAY_TERRACOTTA_WALL, ModBlocks.GRAY_TERRACOTTA_STAIRS, ModBlocks.GRAY_TERRACOTTA_SLAB)
                .add(ModBlocks.BLACK_TERRACOTTA_WALL, ModBlocks.BLACK_TERRACOTTA_STAIRS, ModBlocks.BLACK_TERRACOTTA_SLAB)
                .add(ModBlocks.BROWN_TERRACOTTA_WALL, ModBlocks.BROWN_TERRACOTTA_STAIRS, ModBlocks.BROWN_TERRACOTTA_SLAB)
                .add(ModBlocks.RED_TERRACOTTA_WALL, ModBlocks.RED_TERRACOTTA_STAIRS, ModBlocks.RED_TERRACOTTA_SLAB)
                .add(ModBlocks.ORANGE_TERRACOTTA_WALL, ModBlocks.ORANGE_TERRACOTTA_STAIRS, ModBlocks.ORANGE_TERRACOTTA_SLAB)
                .add(ModBlocks.YELLOW_TERRACOTTA_WALL, ModBlocks.YELLOW_TERRACOTTA_STAIRS, ModBlocks.YELLOW_TERRACOTTA_SLAB)
                .add(ModBlocks.LIME_TERRACOTTA_WALL, ModBlocks.LIME_TERRACOTTA_STAIRS, ModBlocks.LIME_TERRACOTTA_SLAB)
                .add(ModBlocks.GREEN_TERRACOTTA_WALL, ModBlocks.GREEN_TERRACOTTA_STAIRS, ModBlocks.GRAY_TERRACOTTA_SLAB)
                .add(ModBlocks.CYAN_TERRACOTTA_WALL, ModBlocks.CYAN_TERRACOTTA_STAIRS, ModBlocks.CYAN_TERRACOTTA_SLAB)
                .add(ModBlocks.LIGHT_BLUE_TERRACOTTA_WALL, ModBlocks.LIGHT_BLUE_TERRACOTTA_STAIRS, ModBlocks.LIGHT_BLUE_TERRACOTTA_SLAB)
                .add(ModBlocks.BLUE_TERRACOTTA_WALL, ModBlocks.BLUE_TERRACOTTA_STAIRS, ModBlocks.BLUE_TERRACOTTA_SLAB)
                .add(ModBlocks.PURPLE_TERRACOTTA_WALL, ModBlocks.PURPLE_TERRACOTTA_STAIRS, ModBlocks.PURPLE_TERRACOTTA_SLAB)
                .add(ModBlocks.MAGENTA_TERRACOTTA_WALL, ModBlocks.MAGENTA_TERRACOTTA_STAIRS, ModBlocks.MAGENTA_TERRACOTTA_SLAB)
                .add(ModBlocks.PINK_TERRACOTTA_WALL, ModBlocks.PINK_TERRACOTTA_STAIRS, ModBlocks.PINK_TERRACOTTA_SLAB)
        ;

        getOrCreateTagBuilder(BlockTags.BEACON_BASE_BLOCKS)
                .add(ModBlocks.STEEL_BLOCK);

        getOrCreateTagBuilder(ModTags.Blocks.OBSIDIAN)
                .add(Blocks.OBSIDIAN, ModBlocks.OBSIDIAN_WALL, ModBlocks.OBSIDIAN_STAIRS, ModBlocks.OBSIDIAN_SLAB)
                .add(Blocks.CRYING_OBSIDIAN, ModBlocks.CRYING_OBSIDIAN_WALL, ModBlocks.CRYING_OBSIDIAN_STAIRS, ModBlocks.CRYING_OBSIDIAN_SLAB)
        ;

        getOrCreateTagBuilder(ModTags.Blocks.WORLD_DESTROYER)
                .add(Blocks.COBBLESTONE,Blocks.MOSSY_COBBLESTONE)
                .add(Blocks.NETHER_BRICKS)
                .add(Blocks.DARK_OAK_LOG, Blocks.DARK_OAK_WOOD, Blocks.STRIPPED_DARK_OAK_LOG, Blocks.STRIPPED_DARK_OAK_WOOD)
                .add(Blocks.OAK_LOG, Blocks.OAK_WOOD, Blocks.STRIPPED_OAK_LOG, Blocks.STRIPPED_OAK_WOOD)
                .add(Blocks.ACACIA_LOG, Blocks.ACACIA_WOOD, Blocks.STRIPPED_ACACIA_LOG, Blocks.STRIPPED_ACACIA_WOOD)
                .add(Blocks.BIRCH_LOG, Blocks.BIRCH_WOOD, Blocks.STRIPPED_BIRCH_LOG, Blocks.STRIPPED_BIRCH_WOOD)
                .add(Blocks.JUNGLE_LOG, Blocks.JUNGLE_WOOD, Blocks.STRIPPED_JUNGLE_LOG, Blocks.STRIPPED_JUNGLE_WOOD)
                .add(Blocks.SPRUCE_LOG, Blocks.SPRUCE_WOOD, Blocks.STRIPPED_SPRUCE_LOG, Blocks.STRIPPED_SPRUCE_WOOD)
                .add(Blocks.CRIMSON_STEM, Blocks.STRIPPED_CRIMSON_STEM, Blocks.CRIMSON_HYPHAE, Blocks.STRIPPED_CRIMSON_HYPHAE)
                .add(Blocks.WARPED_STEM, Blocks.STRIPPED_WARPED_STEM, Blocks.WARPED_HYPHAE, Blocks.STRIPPED_WARPED_HYPHAE)
                .add(Blocks.MANGROVE_LOG, Blocks.MANGROVE_WOOD, Blocks.STRIPPED_MANGROVE_LOG, Blocks.STRIPPED_MANGROVE_WOOD)
                .add(Blocks.CHERRY_LOG, Blocks.CHERRY_WOOD, Blocks.STRIPPED_CHERRY_LOG, Blocks.STRIPPED_CHERRY_WOOD)
                .add(Blocks.OAK_PLANKS, Blocks.SPRUCE_PLANKS, Blocks.BIRCH_PLANKS, Blocks.JUNGLE_PLANKS, Blocks.ACACIA_PLANKS, Blocks.DARK_OAK_PLANKS, Blocks.CRIMSON_PLANKS, Blocks.WARPED_PLANKS, Blocks.MANGROVE_PLANKS, Blocks.BAMBOO_PLANKS, Blocks.CHERRY_PLANKS)
                .add(Blocks.SMOOTH_SANDSTONE,Blocks.CUT_SANDSTONE,Blocks.CHISELED_SANDSTONE)
                .add(Blocks.GOLD_ORE, Blocks.NETHER_GOLD_ORE, Blocks.DEEPSLATE_GOLD_ORE)
                .add(Blocks.IRON_ORE, Blocks.DEEPSLATE_IRON_ORE)
                .add(Blocks.DIAMOND_ORE, Blocks.DEEPSLATE_DIAMOND_ORE)
                .add(Blocks.REDSTONE_ORE, Blocks.DEEPSLATE_REDSTONE_ORE)
                .add(Blocks.COAL_ORE, Blocks.DEEPSLATE_COAL_ORE)
                .add(Blocks.EMERALD_ORE, Blocks.DEEPSLATE_EMERALD_ORE)
                .add(Blocks.COPPER_ORE, Blocks.DEEPSLATE_COPPER_ORE)
                .add(Blocks.LAPIS_ORE, Blocks.DEEPSLATE_LAPIS_ORE)
                .add(Blocks.NETHER_QUARTZ_ORE)
                .add(Blocks.DEEPSLATE,Blocks.COBBLED_DEEPSLATE)
                .add(Blocks.END_STONE, Blocks.END_STONE_BRICKS)


        ;

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.STONE_WALL)
                .add(ModBlocks.SMOOTH_STONE_WALL)
                .add(ModBlocks.DIRT_WALL)
                .add(ModBlocks.MUD_WALL)
                .add(ModBlocks.CLAY_WALL)
                .add(ModBlocks.CALCITE_WALL)
                .add(ModBlocks.POLISHED_GRANITE_WALL)
                .add(ModBlocks.POLISHED_DIORITE_WALL)
                .add(ModBlocks.POLISHED_ANDESITE_WALL)
                .add(ModBlocks.SMOOTH_SANDSTONE_WALL)
                .add(ModBlocks.SMOOTH_RED_SANDSTONE_WALL)
                .add(ModBlocks.PRISMARINE_BRICK_WALL)
                .add(ModBlocks.DARK_PRISMARINE_WALL)
                .add(ModBlocks.NETHERRACK_WALL)
                .add(ModBlocks.BASALT_WALL)
                .add(ModBlocks.SMOOTH_BASALT_WALL)
                .add(ModBlocks.POLISHED_BASALT_WALL)
                .add(ModBlocks.PURPUR_WALL)
                .add(ModBlocks.END_STONE_WALL)
                .add(ModBlocks.QUARTZ_WALL)
                .add(ModBlocks.SMOOTH_QUARTZ_WALL)
                .add(ModBlocks.AMETHYST_WALL)
                .add(ModBlocks.GLOWSTONE_WALL)
                .add(ModBlocks.ICE_WALL)
                .add(ModBlocks.PACKED_ICE_WALL)
                .add(ModBlocks.BLUE_ICE_WALL)
                .add(ModBlocks.OBSIDIAN_WALL)
                .add(ModBlocks.CRYING_OBSIDIAN_WALL)

                .add(ModBlocks.WHITE_CONCRETE_WALL)
                .add(ModBlocks.LIGHT_GRAY_CONCRETE_WALL)
                .add(ModBlocks.GRAY_CONCRETE_WALL)
                .add(ModBlocks.BLACK_CONCRETE_WALL)
                .add(ModBlocks.BROWN_CONCRETE_WALL)
                .add(ModBlocks.RED_CONCRETE_WALL)
                .add(ModBlocks.ORANGE_CONCRETE_WALL)
                .add(ModBlocks.YELLOW_CONCRETE_WALL)
                .add(ModBlocks.LIME_CONCRETE_WALL)
                .add(ModBlocks.GREEN_CONCRETE_WALL)
                .add(ModBlocks.CYAN_CONCRETE_WALL)
                .add(ModBlocks.LIGHT_BLUE_CONCRETE_WALL)
                .add(ModBlocks.BLUE_CONCRETE_WALL)
                .add(ModBlocks.PURPLE_CONCRETE_WALL)
                .add(ModBlocks.MAGENTA_CONCRETE_WALL)
                .add(ModBlocks.PINK_CONCRETE_WALL)

                .add(ModBlocks.TERRACOTTA_WALL)
                .add(ModBlocks.WHITE_TERRACOTTA_WALL)
                .add(ModBlocks.LIGHT_GRAY_TERRACOTTA_WALL)
                .add(ModBlocks.GRAY_TERRACOTTA_WALL)
                .add(ModBlocks.BLACK_TERRACOTTA_WALL)
                .add(ModBlocks.BROWN_TERRACOTTA_WALL)
                .add(ModBlocks.RED_TERRACOTTA_WALL)
                .add(ModBlocks.ORANGE_TERRACOTTA_WALL)
                .add(ModBlocks.YELLOW_TERRACOTTA_WALL)
                .add(ModBlocks.LIME_TERRACOTTA_WALL)
                .add(ModBlocks.GREEN_TERRACOTTA_WALL)
                .add(ModBlocks.CYAN_TERRACOTTA_WALL)
                .add(ModBlocks.LIGHT_BLUE_TERRACOTTA_WALL)
                .add(ModBlocks.BLUE_TERRACOTTA_WALL)
                .add(ModBlocks.PURPLE_TERRACOTTA_WALL)
                .add(ModBlocks.MAGENTA_TERRACOTTA_WALL)
                .add(ModBlocks.PINK_TERRACOTTA_WALL)
        ;

        getOrCreateTagBuilder(BlockTags.SLABS)
                .add(ModBlocks.DIRT_SLAB)
                .add(ModBlocks.MUD_SLAB)
                .add(ModBlocks.CLAY_SLAB);

        getOrCreateTagBuilder(BlockTags.STAIRS)
                .add(ModBlocks.DIRT_STAIRS)
                .add(ModBlocks.MUD_STAIRS)
                .add(ModBlocks.CLAY_STAIRS);

        getOrCreateTagBuilder(BlockTags.ICE)
                .add(ModBlocks.ICE_WALL)
                .add(ModBlocks.ICE_STAIRS)
                .add(ModBlocks.ICE_SLAB)
                .add(ModBlocks.PACKED_ICE_STAIRS)
                .add(ModBlocks.PACKED_ICE_SLAB)
                .add(ModBlocks.PACKED_ICE_WALL)
                .add(ModBlocks.BLUE_ICE_STAIRS)
                .add(ModBlocks.BLUE_ICE_SLAB)
                .add(ModBlocks.BLUE_ICE_WALL)
                ;

        getOrCreateTagBuilder(ModTags.Blocks.FAIRY_WAND_REPLACEABLE)
                .add(Blocks.WITHER_SKELETON_WALL_SKULL)
                .add(Blocks.WITHER_SKELETON_SKULL)
//                .add(Blocks.ZOMBIE_HEAD)
//                .add(Blocks.ZOMBIE_WALL_HEAD)
                .add(Blocks.CREEPER_HEAD)
                .add(Blocks.CREEPER_WALL_HEAD)
                .add(Blocks.PIGLIN_HEAD)
                .add(Blocks.PIGLIN_WALL_HEAD)
                .add(Blocks.SKELETON_SKULL)
                .add(Blocks.SKELETON_WALL_SKULL)
                .add(Blocks.NETHER_BRICKS)
                ;

        getOrCreateTagBuilder(ModTags.Blocks.NETHER_BRICKS)
                .add(Blocks.NETHER_BRICKS)
                .add(ModBlocks.NETHERRACK_SLAB)
                .add(ModBlocks.NETHERRACK_STAIRS)
                ;

    }
}
