package com.yipkei.vanilladdition.init;

import com.yipkei.vanilladdition.VanillaAddition;
import com.yipkei.vanilladdition.block.BlindBox;
import com.yipkei.vanilladdition.block.TranslucentSlab;
import com.yipkei.vanilladdition.block.TranslucentStairs;
import com.yipkei.vanilladdition.block.TranslucentWall;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks extends Blocks{
    public static final Block STEEL_BLOCK = registerBlocks("steel_block",new Block(AbstractBlock.Settings.copy(IRON_BLOCK)));
    public static final Block COMPRESS_WOOL = registerBlocks("compress_wool", new Block(AbstractBlock.Settings.copy(WHITE_WOOL)));

    public static final Block STONE_BLIND_BOX = registerBlocks("stone_blind_box", new BlindBox(ModLootTables.STONE_BLIND_BOX, Blocks.STONE));
    public static final Block COAL_BLIND_BOX = registerBlocks("coal_blind_box", new BlindBox(ModLootTables.COAL_BLIND_BOX, Blocks.COAL_BLOCK));
    public static final Block COPPER_BLIND_BOX = registerBlocks("copper_blind_box", new BlindBox(ModLootTables.COPPER_BLIND_BOX, Blocks.COPPER_BLOCK));
    public static final Block IRON_BLIND_BOX = registerBlocks("iron_blind_box", new BlindBox(ModLootTables.IRON_BLIND_BOX, Blocks.IRON_BLOCK));
    public static final Block GOLDEN_BLIND_BOX = registerBlocks("golden_blind_box", new BlindBox(ModLootTables.GOLDEN_BLIND_BOX, Blocks.GOLD_BLOCK));
    public static final Block EMERALD_BLIND_BOX = registerBlocks("emerald_blind_box", new BlindBox(ModLootTables.EMERALD_BLIND_BOX, Blocks.EMERALD_BLOCK));
    public static final Block DIAMOND_BLIND_BOX = registerBlocks("diamond_blind_box", new BlindBox(ModLootTables.DIAMOND_BLIND_BOX, Blocks.DIAMOND_BLOCK));
    public static final Block NETHERITE_BLIND_BOX = registerBlocks("netherite_blind_box", new BlindBox(ModLootTables.NETHERITE_BLIND_BOX, Blocks.NETHERITE_BLOCK));

    public static final Block OMINOUS_STONE_BLIND_BOX = registerBlocks("ominous_stone_blind_box", new BlindBox(ModLootTables.OMINOUS_STONE_BLIND_BOX, Blocks.STONE));
    public static final Block OMINOUS_COAL_BLIND_BOX = registerBlocks("ominous_coal_blind_box", new BlindBox(ModLootTables.OMINOUS_COAL_BLIND_BOX, Blocks.COAL_BLOCK));
    public static final Block OMINOUS_COPPER_BLIND_BOX = registerBlocks("ominous_copper_blind_box", new BlindBox(ModLootTables.OMINOUS_COPPER_BLIND_BOX, Blocks.COPPER_BLOCK));
    public static final Block OMINOUS_IRON_BLIND_BOX = registerBlocks("ominous_iron_blind_box", new BlindBox(ModLootTables.OMINOUS_IRON_BLIND_BOX, Blocks.IRON_BLOCK));
    public static final Block OMINOUS_GOLDEN_BLIND_BOX = registerBlocks("ominous_golden_blind_box", new BlindBox(ModLootTables.OMINOUS_GOLDEN_BLIND_BOX, Blocks.GOLD_BLOCK));
    public static final Block OMINOUS_EMERALD_BLIND_BOX = registerBlocks("ominous_emerald_blind_box", new BlindBox(ModLootTables.OMINOUS_EMERALD_BLIND_BOX, Blocks.EMERALD_BLOCK));
    public static final Block OMINOUS_DIAMOND_BLIND_BOX = registerBlocks("ominous_diamond_blind_box", new BlindBox(ModLootTables.OMINOUS_DIAMOND_BLIND_BOX, Blocks.DIAMOND_BLOCK));
    public static final Block OMINOUS_NETHERITE_BLIND_BOX = registerBlocks("ominous_netherite_blind_box", new BlindBox(ModLootTables.OMINOUS_NETHERITE_BLIND_BOX, Blocks.NETHERITE_BLOCK));

    // 原版建材补全（一）只缺墙
    public static final Block STONE_WALL = registerBlocks("stone_wall", new WallBlock(AbstractBlock.Settings.copy(STONE).solid()));
    public static final Block POLISHED_GRANITE_WALL = registerBlocks("polished_granite_wall", new WallBlock(AbstractBlock.Settings.copy(POLISHED_GRANITE).solid()));
    public static final Block POLISHED_DIORITE_WALL = registerBlocks("polished_diorite_wall", new WallBlock(AbstractBlock.Settings.copy(POLISHED_DIORITE).solid()));
    public static final Block POLISHED_ANDESITE_WALL = registerBlocks("polished_andesite_wall", new WallBlock(AbstractBlock.Settings.copy(POLISHED_ANDESITE).solid()));
    public static final Block SMOOTH_SANDSTONE_WALL = registerBlocks("smooth_sandstone_wall", new WallBlock(AbstractBlock.Settings.copy(SMOOTH_SANDSTONE).solid()));
    public static final Block SMOOTH_RED_SANDSTONE_WALL = registerBlocks("smooth_red_sandstone_wall", new WallBlock(AbstractBlock.Settings.copy(SMOOTH_RED_SANDSTONE).solid()));
    public static final Block PRISMARINE_BRICK_WALL = registerBlocks("prismarine_bricks_wall", new WallBlock(AbstractBlock.Settings.copy(PRISMARINE_BRICKS).solid()));
    public static final Block DARK_PRISMARINE_WALL = registerBlocks("dark_prismarine_wall", new WallBlock(AbstractBlock.Settings.copy(DARK_PRISMARINE).solid()));

    //原版建材补全 - 平滑石类，缺墙与台阶
    public static final Block SMOOTH_STONE_WALL = registerBlocks("smooth_stone_wall", new WallBlock(AbstractBlock.Settings.copy(SMOOTH_STONE).solid()));
    public static final Block SMOOTH_STONE_STAIRS = registerBlocks("smooth_stone_stairs", new StairsBlock(Blocks.SMOOTH_STONE.getDefaultState(),AbstractBlock.Settings.copy(SMOOTH_STONE)));


    //原版建材补全 - 素石类+混凝土，缺墙，台阶，半砖


    public static final Block SMOOTH_BASALT_WALL = registerBlocks("smooth_basalt_wall", new WallBlock(AbstractBlock.Settings.copy(SMOOTH_BASALT).solid()));
    public static final Block SMOOTH_BASALT_STAIRS = registerBlocks("smooth_basalt_stairs", new StairsBlock(Blocks.SMOOTH_BASALT.getDefaultState(),AbstractBlock.Settings.copy(SMOOTH_BASALT)));
    public static final Block SMOOTH_BASALT_SLAB = registerBlocks("smooth_basalt_slab", new SlabBlock(AbstractBlock.Settings.copy(SMOOTH_BASALT)));

    public static final Block DIRT_WALL = registerBlocks("dirt_wall", new WallBlock(AbstractBlock.Settings.copy(DIRT).solid()));
    public static final Block DIRT_STAIRS = registerBlocks("dirt_stairs", new StairsBlock(Blocks.DIRT.getDefaultState(),AbstractBlock.Settings.copy(DIRT)));
    public static final Block DIRT_SLAB = registerBlocks("dirt_slab", new SlabBlock(AbstractBlock.Settings.copy(DIRT)));

    public static final Block MUD_WALL = registerBlocks("mud_wall", new WallBlock(AbstractBlock.Settings.copy(MUD).solid()));
    public static final Block MUD_STAIRS = registerBlocks("mud_stairs", new StairsBlock(Blocks.MUD.getDefaultState(),AbstractBlock.Settings.copy(MUD)));
    public static final Block MUD_SLAB = registerBlocks("mud_slab", new SlabBlock(AbstractBlock.Settings.copy(MUD)));

    public static final Block CLAY_WALL = registerBlocks("clay_wall", new WallBlock(AbstractBlock.Settings.copy(CLAY).solid()));
    public static final Block CLAY_STAIRS = registerBlocks("clay_stairs", new StairsBlock(Blocks.CLAY.getDefaultState(),AbstractBlock.Settings.copy(CLAY)));
    public static final Block CLAY_SLAB = registerBlocks("clay_slab", new SlabBlock(AbstractBlock.Settings.copy(CLAY)));

    public static final Block CALCITE_WALL = registerBlocks("calcite_wall", new WallBlock(AbstractBlock.Settings.copy(CALCITE).solid()));
    public static final Block CALCITE_STAIRS = registerBlocks("calcite_stairs", new StairsBlock(Blocks.CALCITE.getDefaultState(),AbstractBlock.Settings.copy(CALCITE)));
    public static final Block CALCITE_SLAB = registerBlocks("calcite_slab", new SlabBlock(AbstractBlock.Settings.copy(CALCITE)));


    public static final Block NETHERRACK_WALL = registerBlocks("netherrack_wall", new WallBlock(AbstractBlock.Settings.copy(NETHERRACK).solid()));
    public static final Block NETHERRACK_STAIRS = registerBlocks("netherrack_stairs", new StairsBlock(Blocks.NETHERRACK.getDefaultState(),AbstractBlock.Settings.copy(NETHERRACK)));
    public static final Block NETHERRACK_SLAB = registerBlocks("netherrack_slab", new SlabBlock(AbstractBlock.Settings.copy(NETHERRACK)));


    public static final Block OBSIDIAN_WALL = registerBlocks("obsidian_wall", new WallBlock(AbstractBlock.Settings.copy(OBSIDIAN).solid()));
    public static final Block OBSIDIAN_STAIRS = registerBlocks("obsidian_stairs", new StairsBlock(Blocks.OBSIDIAN.getDefaultState(),AbstractBlock.Settings.copy(OBSIDIAN)));
    public static final Block OBSIDIAN_SLAB = registerBlocks("obsidian_slab", new SlabBlock(AbstractBlock.Settings.copy(OBSIDIAN)));


    public static final Block CRYING_OBSIDIAN_WALL = registerBlocks("crying_obsidian_wall", new WallBlock(AbstractBlock.Settings.copy(CRYING_OBSIDIAN).solid()));
    public static final Block CRYING_OBSIDIAN_STAIRS = registerBlocks("crying_obsidian_stairs", new StairsBlock(Blocks.CRYING_OBSIDIAN.getDefaultState(),AbstractBlock.Settings.copy(CRYING_OBSIDIAN)));
    public static final Block CRYING_OBSIDIAN_SLAB = registerBlocks("crying_obsidian_slab", new SlabBlock(AbstractBlock.Settings.copy(CRYING_OBSIDIAN)));


    public static final Block PURPUR_WALL = registerBlocks("purpur_wall", new WallBlock(AbstractBlock.Settings.copy(PURPUR_BLOCK).solid()));

    public static final Block END_STONE_WALL = registerBlocks("end_stone_wall", new WallBlock(AbstractBlock.Settings.copy(END_STONE).solid()));
    public static final Block END_STONE_STAIRS = registerBlocks("end_stone_stairs", new StairsBlock(Blocks.END_STONE.getDefaultState(),AbstractBlock.Settings.copy(END_STONE)));
    public static final Block END_STONE_SLAB = registerBlocks("end_stone_slab", new SlabBlock(AbstractBlock.Settings.copy(END_STONE)));

    //建材补全 · 特殊方块
    public static final Block SMOOTH_QUARTZ_WALL = registerBlocks("smooth_quartz_wall", new WallBlock(AbstractBlock.Settings.copy(SMOOTH_QUARTZ).solid()));

    public static final Block AMETHYST_WALL = registerBlocks("amethyst_wall", new WallBlock(AbstractBlock.Settings.copy(AMETHYST_BLOCK).solid()));
    public static final Block AMETHYST_STAIRS = registerBlocks("amethyst_stairs", new StairsBlock(Blocks.AMETHYST_BLOCK.getDefaultState(),AbstractBlock.Settings.copy(AMETHYST_BLOCK)));
    public static final Block AMETHYST_SLAB = registerBlocks("amethyst_slab", new SlabBlock(AbstractBlock.Settings.copy(AMETHYST_BLOCK)));

    public static final Block GLOWSTONE_WALL = registerBlocks("glowstone_wall", new WallBlock(AbstractBlock.Settings.copy(GLOWSTONE).solid()));
    public static final Block GLOWSTONE_STAIRS = registerBlocks("glowstone_stairs", new StairsBlock(Blocks.GLOWSTONE.getDefaultState(),AbstractBlock.Settings.copy(GLOWSTONE)));
    public static final Block GLOWSTONE_SLAB = registerBlocks("glowstone_slab", new SlabBlock(AbstractBlock.Settings.copy(GLOWSTONE)));

    public static final Block ICE_WALL = registerBlocks("ice_wall", new TranslucentWall(AbstractBlock.Settings.copy(ICE).nonOpaque().solid().slipperiness(0.98f).solidBlock(Blocks::never)).setBlockSeriesAtSetting(Blocks.ICE));
    public static final Block ICE_STAIRS = registerBlocks("ice_stairs", new TranslucentStairs(Blocks.ICE.getDefaultState(),AbstractBlock.Settings.copy(ICE).nonOpaque().slipperiness(0.98f).solidBlock(Blocks::never)).setBlockSeriesAtSetting(Blocks.ICE));
    public static final Block ICE_SLAB = registerBlocks("ice_slab", new TranslucentSlab(AbstractBlock.Settings.copy(ICE).nonOpaque().slipperiness(0.98f).solidBlock(Blocks::never)).setBlockSeriesAtSetting(Blocks.ICE));

    public static final Block PACKED_ICE_WALL = registerBlocks("packed_ice_wall", new WallBlock(AbstractBlock.Settings.copy(PACKED_ICE).solid().slipperiness(0.98f)));
    public static final Block PACKED_ICE_STAIRS = registerBlocks("packed_ice_stairs", new StairsBlock(Blocks.PACKED_ICE.getDefaultState(),AbstractBlock.Settings.copy(PACKED_ICE).slipperiness(0.98f)));
    public static final Block PACKED_ICE_SLAB = registerBlocks("packed_ice_slab", new SlabBlock(AbstractBlock.Settings.copy(PACKED_ICE).slipperiness(0.98f)));

    public static final Block BLUE_ICE_WALL = registerBlocks("blue_ice_wall", new WallBlock(AbstractBlock.Settings.copy(BLUE_ICE).solid().slipperiness(0.989f)));
    public static final Block BLUE_ICE_STAIRS = registerBlocks("blue_ice_stairs", new StairsBlock(Blocks.BLUE_ICE.getDefaultState(),AbstractBlock.Settings.copy(BLUE_ICE).slipperiness(0.989f)));
    public static final Block BLUE_ICE_SLAB = registerBlocks("blue_ice_slab", new SlabBlock(AbstractBlock.Settings.copy(BLUE_ICE).slipperiness(0.989f)));

    //建材补全 · 彩色方块

    public static final Block WHITE_CONCRETE_WALL = registerBlocks("white_concrete_wall", new WallBlock(AbstractBlock.Settings.copy(WHITE_CONCRETE).solid()));
    public static final Block WHITE_CONCRETE_STAIRS = registerBlocks("white_concrete_stairs", new StairsBlock(Blocks.WHITE_CONCRETE.getDefaultState(),AbstractBlock.Settings.copy(WHITE_CONCRETE)));
    public static final Block WHITE_CONCRETE_SLAB = registerBlocks("white_concrete_slab", new SlabBlock(AbstractBlock.Settings.copy(WHITE_CONCRETE)));

    public static final Block LIGHT_GRAY_CONCRETE_WALL = registerBlocks("light_gray_concrete_wall", new WallBlock(AbstractBlock.Settings.copy(LIGHT_GRAY_CONCRETE).solid()));
    public static final Block LIGHT_GRAY_CONCRETE_STAIRS = registerBlocks("light_gray_concrete_stairs", new StairsBlock(Blocks.LIGHT_GRAY_CONCRETE.getDefaultState(),AbstractBlock.Settings.copy(LIGHT_GRAY_CONCRETE)));
    public static final Block LIGHT_GRAY_CONCRETE_SLAB = registerBlocks("light_gray_concrete_slab", new SlabBlock(AbstractBlock.Settings.copy(LIGHT_GRAY_CONCRETE)));

    public static final Block GRAY_CONCRETE_WALL = registerBlocks("gray_concrete_wall", new WallBlock(AbstractBlock.Settings.copy(GRAY_CONCRETE).solid()));
    public static final Block GRAY_CONCRETE_STAIRS = registerBlocks("gray_concrete_stairs", new StairsBlock(Blocks.GRAY_CONCRETE.getDefaultState(),AbstractBlock.Settings.copy(GRAY_CONCRETE)));
    public static final Block GRAY_CONCRETE_SLAB = registerBlocks("gray_concrete_slab", new SlabBlock(AbstractBlock.Settings.copy(GRAY_CONCRETE)));

    public static final Block BLACK_CONCRETE_WALL = registerBlocks("black_concrete_wall", new WallBlock(AbstractBlock.Settings.copy(BLACK_CONCRETE).solid()));
    public static final Block BLACK_CONCRETE_STAIRS = registerBlocks("black_concrete_stairs", new StairsBlock(Blocks.BLACK_CONCRETE.getDefaultState(),AbstractBlock.Settings.copy(BLACK_CONCRETE)));
    public static final Block BLACK_CONCRETE_SLAB = registerBlocks("black_concrete_slab", new SlabBlock(AbstractBlock.Settings.copy(BLACK_CONCRETE)));

    public static final Block BROWN_CONCRETE_WALL = registerBlocks("brown_concrete_wall", new WallBlock(AbstractBlock.Settings.copy(BROWN_CONCRETE).solid()));
    public static final Block BROWN_CONCRETE_STAIRS = registerBlocks("brown_concrete_stairs", new StairsBlock(Blocks.BROWN_CONCRETE.getDefaultState(),AbstractBlock.Settings.copy(BROWN_CONCRETE)));
    public static final Block BROWN_CONCRETE_SLAB = registerBlocks("brown_concrete_slab", new SlabBlock(AbstractBlock.Settings.copy(BROWN_CONCRETE)));

    public static final Block RED_CONCRETE_WALL = registerBlocks("red_concrete_wall", new WallBlock(AbstractBlock.Settings.copy(RED_CONCRETE).solid()));
    public static final Block RED_CONCRETE_STAIRS = registerBlocks("red_concrete_stairs", new StairsBlock(Blocks.RED_CONCRETE.getDefaultState(),AbstractBlock.Settings.copy(RED_CONCRETE)));
    public static final Block RED_CONCRETE_SLAB = registerBlocks("red_concrete_slab", new SlabBlock(AbstractBlock.Settings.copy(RED_CONCRETE)));

    public static final Block ORANGE_CONCRETE_WALL = registerBlocks("orange_concrete_wall", new WallBlock(AbstractBlock.Settings.copy(ORANGE_CONCRETE).solid()));
    public static final Block ORANGE_CONCRETE_STAIRS = registerBlocks("orange_concrete_stairs", new StairsBlock(Blocks.ORANGE_CONCRETE.getDefaultState(),AbstractBlock.Settings.copy(ORANGE_CONCRETE)));
    public static final Block ORANGE_CONCRETE_SLAB = registerBlocks("orange_concrete_slab", new SlabBlock(AbstractBlock.Settings.copy(ORANGE_CONCRETE)));

    public static final Block YELLOW_CONCRETE_WALL = registerBlocks("yellow_concrete_wall", new WallBlock(AbstractBlock.Settings.copy(YELLOW_CONCRETE).solid()));
    public static final Block YELLOW_CONCRETE_STAIRS = registerBlocks("yellow_concrete_stairs", new StairsBlock(Blocks.YELLOW_CONCRETE.getDefaultState(),AbstractBlock.Settings.copy(YELLOW_CONCRETE)));
    public static final Block YELLOW_CONCRETE_SLAB = registerBlocks("yellow_concrete_slab", new SlabBlock(AbstractBlock.Settings.copy(YELLOW_CONCRETE)));

    public static final Block LIME_CONCRETE_WALL = registerBlocks("lime_concrete_wall", new WallBlock(AbstractBlock.Settings.copy(LIME_CONCRETE).solid()));
    public static final Block LIME_CONCRETE_STAIRS = registerBlocks("lime_concrete_stairs", new StairsBlock(Blocks.LIME_CONCRETE.getDefaultState(),AbstractBlock.Settings.copy(LIME_CONCRETE)));
    public static final Block LIME_CONCRETE_SLAB = registerBlocks("lime_concrete_slab", new SlabBlock(AbstractBlock.Settings.copy(LIME_CONCRETE)));

    public static final Block GREEN_CONCRETE_WALL = registerBlocks("green_concrete_wall", new WallBlock(AbstractBlock.Settings.copy(GREEN_CONCRETE).solid()));
    public static final Block GREEN_CONCRETE_STAIRS = registerBlocks("green_concrete_stairs", new StairsBlock(Blocks.GREEN_CONCRETE.getDefaultState(),AbstractBlock.Settings.copy(GREEN_CONCRETE)));
    public static final Block GREEN_CONCRETE_SLAB = registerBlocks("green_concrete_slab", new SlabBlock(AbstractBlock.Settings.copy(GREEN_CONCRETE)));

    public static final Block CYAN_CONCRETE_WALL = registerBlocks("cyan_concrete_wall", new WallBlock(AbstractBlock.Settings.copy(CYAN_CONCRETE).solid()));
    public static final Block CYAN_CONCRETE_STAIRS = registerBlocks("cyan_concrete_stairs", new StairsBlock(Blocks.CYAN_CONCRETE.getDefaultState(),AbstractBlock.Settings.copy(CYAN_CONCRETE)));
    public static final Block CYAN_CONCRETE_SLAB = registerBlocks("cyan_concrete_slab", new SlabBlock(AbstractBlock.Settings.copy(CYAN_CONCRETE)));

    public static final Block LIGHT_BLUE_CONCRETE_WALL = registerBlocks("light_blue_concrete_wall", new WallBlock(AbstractBlock.Settings.copy(LIGHT_BLUE_CONCRETE).solid()));
    public static final Block LIGHT_BLUE_CONCRETE_STAIRS = registerBlocks("light_blue_concrete_stairs", new StairsBlock(Blocks.LIGHT_BLUE_CONCRETE.getDefaultState(),AbstractBlock.Settings.copy(LIGHT_BLUE_CONCRETE)));
    public static final Block LIGHT_BLUE_CONCRETE_SLAB = registerBlocks("light_blue_concrete_slab", new SlabBlock(AbstractBlock.Settings.copy(LIGHT_BLUE_CONCRETE)));

    public static final Block BLUE_CONCRETE_WALL = registerBlocks("blue_concrete_wall", new WallBlock(AbstractBlock.Settings.copy(BLUE_CONCRETE).solid()));
    public static final Block BLUE_CONCRETE_STAIRS = registerBlocks("blue_concrete_stairs", new StairsBlock(Blocks.BLUE_CONCRETE.getDefaultState(),AbstractBlock.Settings.copy(BLUE_CONCRETE)));
    public static final Block BLUE_CONCRETE_SLAB = registerBlocks("blue_concrete_slab", new SlabBlock(AbstractBlock.Settings.copy(BLUE_CONCRETE)));

    public static final Block PURPLE_CONCRETE_WALL = registerBlocks("purple_concrete_wall", new WallBlock(AbstractBlock.Settings.copy(PURPLE_CONCRETE).solid()));
    public static final Block PURPLE_CONCRETE_STAIRS = registerBlocks("purple_concrete_stairs", new StairsBlock(Blocks.PURPLE_CONCRETE.getDefaultState(),AbstractBlock.Settings.copy(PURPLE_CONCRETE)));
    public static final Block PURPLE_CONCRETE_SLAB = registerBlocks("purple_concrete_slab", new SlabBlock(AbstractBlock.Settings.copy(PURPLE_CONCRETE)));

    public static final Block MAGENTA_CONCRETE_WALL = registerBlocks("magenta_concrete_wall", new WallBlock(AbstractBlock.Settings.copy(MAGENTA_CONCRETE).solid()));
    public static final Block MAGENTA_CONCRETE_STAIRS = registerBlocks("magenta_concrete_stairs", new StairsBlock(Blocks.MAGENTA_CONCRETE.getDefaultState(),AbstractBlock.Settings.copy(MAGENTA_CONCRETE)));
    public static final Block MAGENTA_CONCRETE_SLAB = registerBlocks("magenta_concrete_slab", new SlabBlock(AbstractBlock.Settings.copy(MAGENTA_CONCRETE)));

    public static final Block PINK_CONCRETE_WALL = registerBlocks("pink_concrete_wall", new WallBlock(AbstractBlock.Settings.copy(PINK_CONCRETE).solid()));
    public static final Block PINK_CONCRETE_STAIRS = registerBlocks("pink_concrete_stairs", new StairsBlock(Blocks.PINK_CONCRETE.getDefaultState(),AbstractBlock.Settings.copy(PINK_CONCRETE)));
    public static final Block PINK_CONCRETE_SLAB = registerBlocks("pink_concrete_slab", new SlabBlock(AbstractBlock.Settings.copy(PINK_CONCRETE)));

    public static final Block TERRACOTTA_WALL = registerBlocks("terracotta_wall", new WallBlock(AbstractBlock.Settings.copy(TERRACOTTA).solid()));
    public static final Block TERRACOTTA_STAIRS = registerBlocks("terracotta_stairs", new StairsBlock(Blocks.TERRACOTTA.getDefaultState(),AbstractBlock.Settings.copy(TERRACOTTA)));
    public static final Block TERRACOTTA_SLAB = registerBlocks("terracotta_slab", new SlabBlock(AbstractBlock.Settings.copy(TERRACOTTA)));

    public static final Block WHITE_TERRACOTTA_WALL = registerBlocks("white_terracotta_wall", new WallBlock(AbstractBlock.Settings.copy(WHITE_TERRACOTTA).solid()));
    public static final Block WHITE_TERRACOTTA_STAIRS = registerBlocks("white_terracotta_stairs", new StairsBlock(Blocks.WHITE_TERRACOTTA.getDefaultState(),AbstractBlock.Settings.copy(WHITE_TERRACOTTA)));
    public static final Block WHITE_TERRACOTTA_SLAB = registerBlocks("white_terracotta_slab", new SlabBlock(AbstractBlock.Settings.copy(WHITE_TERRACOTTA)));

    public static final Block LIGHT_GRAY_TERRACOTTA_WALL = registerBlocks("light_gray_terracotta_wall", new WallBlock(AbstractBlock.Settings.copy(LIGHT_GRAY_TERRACOTTA).solid()));
    public static final Block LIGHT_GRAY_TERRACOTTA_STAIRS = registerBlocks("light_gray_terracotta_stairs", new StairsBlock(Blocks.LIGHT_GRAY_TERRACOTTA.getDefaultState(),AbstractBlock.Settings.copy(TERRACOTTA)));
    public static final Block LIGHT_GRAY_TERRACOTTA_SLAB = registerBlocks("light_gray_terracotta_slab", new SlabBlock(AbstractBlock.Settings.copy(LIGHT_GRAY_TERRACOTTA)));

    public static final Block GRAY_TERRACOTTA_WALL = registerBlocks("gray_terracotta_wall", new WallBlock(AbstractBlock.Settings.copy(GRAY_TERRACOTTA).solid()));
    public static final Block GRAY_TERRACOTTA_STAIRS = registerBlocks("gray_terracotta_stairs", new StairsBlock(Blocks.GRAY_TERRACOTTA.getDefaultState(),AbstractBlock.Settings.copy(GRAY_TERRACOTTA)));
    public static final Block GRAY_TERRACOTTA_SLAB = registerBlocks("gray_terracotta_slab", new SlabBlock(AbstractBlock.Settings.copy(GRAY_TERRACOTTA)));

    public static final Block BLACK_TERRACOTTA_WALL = registerBlocks("black_terracotta_wall", new WallBlock(AbstractBlock.Settings.copy(BLACK_TERRACOTTA).solid()));
    public static final Block BLACK_TERRACOTTA_STAIRS = registerBlocks("black_terracotta_stairs", new StairsBlock(Blocks.BLACK_TERRACOTTA.getDefaultState(),AbstractBlock.Settings.copy(BLACK_TERRACOTTA)));
    public static final Block BLACK_TERRACOTTA_SLAB = registerBlocks("black_terracotta_slab", new SlabBlock(AbstractBlock.Settings.copy(BLACK_TERRACOTTA)));

    public static final Block BROWN_TERRACOTTA_WALL = registerBlocks("brown_terracotta_wall", new WallBlock(AbstractBlock.Settings.copy(BROWN_TERRACOTTA).solid()));
    public static final Block BROWN_TERRACOTTA_STAIRS = registerBlocks("brown_terracotta_stairs", new StairsBlock(Blocks.BROWN_TERRACOTTA.getDefaultState(),AbstractBlock.Settings.copy(BROWN_TERRACOTTA)));
    public static final Block BROWN_TERRACOTTA_SLAB = registerBlocks("brown_terracotta_slab", new SlabBlock(AbstractBlock.Settings.copy(BROWN_TERRACOTTA)));

    public static final Block RED_TERRACOTTA_WALL = registerBlocks("red_terracotta_wall", new WallBlock(AbstractBlock.Settings.copy(RED_TERRACOTTA).solid()));
    public static final Block RED_TERRACOTTA_STAIRS = registerBlocks("red_terracotta_stairs", new StairsBlock(Blocks.RED_TERRACOTTA.getDefaultState(),AbstractBlock.Settings.copy(RED_TERRACOTTA)));
    public static final Block RED_TERRACOTTA_SLAB = registerBlocks("red_terracotta_slab", new SlabBlock(AbstractBlock.Settings.copy(RED_TERRACOTTA)));

    public static final Block ORANGE_TERRACOTTA_WALL = registerBlocks("orange_terracotta_wall", new WallBlock(AbstractBlock.Settings.copy(ORANGE_TERRACOTTA).solid()));
    public static final Block ORANGE_TERRACOTTA_STAIRS = registerBlocks("orange_terracotta_stairs", new StairsBlock(Blocks.ORANGE_TERRACOTTA.getDefaultState(),AbstractBlock.Settings.copy(ORANGE_TERRACOTTA)));
    public static final Block ORANGE_TERRACOTTA_SLAB = registerBlocks("orange_terracotta_slab", new SlabBlock(AbstractBlock.Settings.copy(ORANGE_TERRACOTTA)));

    public static final Block YELLOW_TERRACOTTA_WALL = registerBlocks("yellow_terracotta_wall", new WallBlock(AbstractBlock.Settings.copy(YELLOW_TERRACOTTA).solid()));
    public static final Block YELLOW_TERRACOTTA_STAIRS = registerBlocks("yellow_terracotta_stairs", new StairsBlock(Blocks.YELLOW_TERRACOTTA.getDefaultState(),AbstractBlock.Settings.copy(YELLOW_TERRACOTTA)));
    public static final Block YELLOW_TERRACOTTA_SLAB = registerBlocks("yellow_terracotta_slab", new SlabBlock(AbstractBlock.Settings.copy(YELLOW_TERRACOTTA)));

    public static final Block LIME_TERRACOTTA_WALL = registerBlocks("lime_terracotta_wall", new WallBlock(AbstractBlock.Settings.copy(LIME_TERRACOTTA).solid()));
    public static final Block LIME_TERRACOTTA_STAIRS = registerBlocks("lime_terracotta_stairs", new StairsBlock(Blocks.LIME_TERRACOTTA.getDefaultState(),AbstractBlock.Settings.copy(LIME_TERRACOTTA)));
    public static final Block LIME_TERRACOTTA_SLAB = registerBlocks("lime_terracotta_slab", new SlabBlock(AbstractBlock.Settings.copy(LIME_TERRACOTTA)));

    public static final Block GREEN_TERRACOTTA_WALL = registerBlocks("green_terracotta_wall", new WallBlock(AbstractBlock.Settings.copy(GREEN_TERRACOTTA).solid()));
    public static final Block GREEN_TERRACOTTA_STAIRS = registerBlocks("green_terracotta_stairs", new StairsBlock(Blocks.GREEN_TERRACOTTA.getDefaultState(),AbstractBlock.Settings.copy(GREEN_TERRACOTTA)));
    public static final Block GREEN_TERRACOTTA_SLAB = registerBlocks("green_terracotta_slab", new SlabBlock(AbstractBlock.Settings.copy(GREEN_TERRACOTTA)));

    public static final Block CYAN_TERRACOTTA_WALL = registerBlocks("cyan_terracotta_wall", new WallBlock(AbstractBlock.Settings.copy(CYAN_TERRACOTTA).solid()));
    public static final Block CYAN_TERRACOTTA_STAIRS = registerBlocks("cyan_terracotta_stairs", new StairsBlock(Blocks.CYAN_TERRACOTTA.getDefaultState(),AbstractBlock.Settings.copy(CYAN_TERRACOTTA)));
    public static final Block CYAN_TERRACOTTA_SLAB = registerBlocks("cyan_terracotta_slab", new SlabBlock(AbstractBlock.Settings.copy(CYAN_TERRACOTTA)));

    public static final Block LIGHT_BLUE_TERRACOTTA_WALL = registerBlocks("light_blue_terracotta_wall", new WallBlock(AbstractBlock.Settings.copy(LIGHT_BLUE_TERRACOTTA).solid()));
    public static final Block LIGHT_BLUE_TERRACOTTA_STAIRS = registerBlocks("light_blue_terracotta_stairs", new StairsBlock(Blocks.LIGHT_BLUE_TERRACOTTA.getDefaultState(),AbstractBlock.Settings.copy(LIGHT_BLUE_TERRACOTTA)));
    public static final Block LIGHT_BLUE_TERRACOTTA_SLAB = registerBlocks("light_blue_terracotta_slab", new SlabBlock(AbstractBlock.Settings.copy(LIGHT_BLUE_TERRACOTTA)));

    public static final Block BLUE_TERRACOTTA_WALL = registerBlocks("blue_terracotta_wall", new WallBlock(AbstractBlock.Settings.copy(BLUE_TERRACOTTA).solid()));
    public static final Block BLUE_TERRACOTTA_STAIRS = registerBlocks("blue_terracotta_stairs", new StairsBlock(Blocks.BLUE_TERRACOTTA.getDefaultState(),AbstractBlock.Settings.copy(BLUE_TERRACOTTA)));
    public static final Block BLUE_TERRACOTTA_SLAB = registerBlocks("blue_terracotta_slab", new SlabBlock(AbstractBlock.Settings.copy(BLUE_TERRACOTTA)));

    public static final Block PURPLE_TERRACOTTA_WALL = registerBlocks("purple_terracotta_wall", new WallBlock(AbstractBlock.Settings.copy(PURPLE_TERRACOTTA).solid()));
    public static final Block PURPLE_TERRACOTTA_STAIRS = registerBlocks("purple_terracotta_stairs", new StairsBlock(Blocks.PURPLE_TERRACOTTA.getDefaultState(),AbstractBlock.Settings.copy(PURPLE_TERRACOTTA)));
    public static final Block PURPLE_TERRACOTTA_SLAB = registerBlocks("purple_terracotta_slab", new SlabBlock(AbstractBlock.Settings.copy(PURPLE_TERRACOTTA)));

    public static final Block MAGENTA_TERRACOTTA_WALL = registerBlocks("magenta_terracotta_wall", new WallBlock(AbstractBlock.Settings.copy(MAGENTA_TERRACOTTA).solid()));
    public static final Block MAGENTA_TERRACOTTA_STAIRS = registerBlocks("magenta_terracotta_stairs", new StairsBlock(Blocks.MAGENTA_TERRACOTTA.getDefaultState(),AbstractBlock.Settings.copy(MAGENTA_TERRACOTTA)));
    public static final Block MAGENTA_TERRACOTTA_SLAB = registerBlocks("magenta_terracotta_slab", new SlabBlock(AbstractBlock.Settings.copy(MAGENTA_TERRACOTTA)));

    public static final Block PINK_TERRACOTTA_WALL = registerBlocks("pink_terracotta_wall", new WallBlock(AbstractBlock.Settings.copy(PINK_TERRACOTTA).solid()));
    public static final Block PINK_TERRACOTTA_STAIRS = registerBlocks("pink_terracotta_stairs", new StairsBlock(Blocks.PINK_TERRACOTTA.getDefaultState(),AbstractBlock.Settings.copy(PINK_TERRACOTTA)));
    public static final Block PINK_TERRACOTTA_SLAB = registerBlocks("pink_terracotta_slab", new SlabBlock(AbstractBlock.Settings.copy(PINK_TERRACOTTA)));

    public static final Block BASALT_WALL = registerBlocks("basalt_wall", new WallBlock(AbstractBlock.Settings.copy(BASALT).solid()));
    public static final Block BASALT_STAIRS = registerBlocks("basalt_stairs", new StairsBlock(Blocks.BASALT.getDefaultState(),AbstractBlock.Settings.copy(BASALT)));
    public static final Block BASALT_SLAB = registerBlocks("basalt_slab", new SlabBlock(AbstractBlock.Settings.copy(BASALT)));

    public static final Block POLISHED_BASALT_WALL = registerBlocks("polished_basalt_wall", new WallBlock(AbstractBlock.Settings.copy(POLISHED_BASALT).solid()));
    public static final Block POLISHED_BASALT_STAIRS = registerBlocks("polished_basalt_stairs", new StairsBlock(Blocks.POLISHED_BASALT.getDefaultState(),AbstractBlock.Settings.copy(POLISHED_BASALT)));
    public static final Block POLISHED_BASALT_SLAB = registerBlocks("polished_basalt_slab", new SlabBlock(AbstractBlock.Settings.copy(POLISHED_BASALT)));

    public static final Block QUARTZ_WALL = registerBlocks("quartz_wall", new WallBlock(AbstractBlock.Settings.copy(QUARTZ_BLOCK).solid()));

    private static Block registerBlocks(String name,Block block){
        registerBlockItems(name,block);
        return Registry.register(Registries.BLOCK, Identifier.of(VanillaAddition.MOD_ID,name),block);
    }
    private static void registerBlockItems(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(VanillaAddition.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }
    public static void registerModBlocks(){

    }
}
