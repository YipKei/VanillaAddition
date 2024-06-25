package com.yipkei.vanilladdition.init;

import com.yipkei.vanilladdition.VanillaAddition;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;


public class ModItemGroups {
    public static final ItemGroup Vanilla_Addition = Registry.register(
            Registries.ITEM_GROUP,
            Identifier.of(VanillaAddition.MOD_ID,"vanilla_addition"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.vanilla_addition"))
                    .icon(()->new ItemStack(ModItems.ROASTED_ROTTEN_FLESH))
                    .entries((displayContext,entries)->{
                        entries.add(ModItems.ROASTED_ROTTEN_FLESH);
                        entries.add(ModItems.STEEL_INGOT);
                        entries.add(ModBlocks.STEEL_BLOCK);
                        entries.add(ModItems.DIAMOND_SHARD);
                        entries.add(ModItems.DIAMOND_SHARDS_UPGRADED_SMITHING_TEMPLATE);

                        entries.add(ModItems.STEEL_SWORD);
                        entries.add(ModItems.STEEL_SHOVEL);
                        entries.add(ModItems.STEEL_PICKAXE);
                        entries.add(ModItems.STEEL_AXE);
                        entries.add(ModItems.STEEL_HOE);
                        entries.add(ModItems.DIAMOND_UPGRADED_PICKAXE);
                        entries.add(ModItems.DIAMOND_UPGRADED_AXE);

                        entries.add(ModItems.GLASS_PICKAXE_PROTOTYPE);
                        entries.add(ModItems.GLASS_PICKAXE);
                        entries.add(ModItems.DESTROYER_PICKAXE);
                        entries.add(ModItems.DIAMOND_FLINT);
                        entries.add(ModItems.STEEL_SHEARS);

                        entries.add(ModItems.DEEP_DARK_FANTASY);
                        entries.add(ModItems.EXPLOSION_CREATOR);

                        entries.add(ModItems.STONE_HAMMER);
                        entries.add(ModItems.IRON_HAMMER);
                        entries.add(ModItems.DIAMOND_HAMMER);
                    }).build());

    public static final ItemGroup Vanilla_Renewable_Addition = Registry.register(
            Registries.ITEM_GROUP,
            Identifier.of(VanillaAddition.MOD_ID,"vanilla_renewable"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.vanilla_renewable"))
                    .icon(()->new ItemStack(ModItems.DIAMOND_SHARD))
                    .entries((displayContext,entries)->{
                        entries.add(ModItems.DIAMOND_SHARD_STACK);
                        entries.add(ModItems.PULSE_OF_THE_SEA);
                        entries.add(ModItems.DRAGON_WING_MEMBRANE);
                        entries.add(ModItems.ANCIENT_TEAR);

                        entries.add(ModItems.DIAMOND_PROTOTYPE);
                        entries.add(ModItems.ANCIENT_PROTOTYPE);
                        entries.add(ModItems.SUSPICIOUS_PROTOTYPE);
                        entries.add(ModItems.HEAVY_CORE_PROTOTYPE);
                        entries.add(ModItems.CONDUIT_PROTOTYPE);
                        entries.add(ModItems.ELYTRA_PROTOTYPE);

                        entries.add(ModItems.PRESSURE_CRAFTING_TEMPLATE);
                        entries.add(ModItems.NETHER_SMITHING_TEMPLATE);
                        entries.add(ModItems.NETHER_SMITHING_TEMPLATE_PRO);
                        entries.add(ModItems.ELYTRA_COPY_TEMPLATE);
                        entries.add(ModItems.ENCHANTED_GOLDEN_APPLE_TEMPLATE);
                        entries.add(ModItems.HEAD_COPY_TEMPLATE);
                        entries.add(ModItems.TOTEM_OF_UNDYING_COPY_TEMPLATE);

                        entries.add(ModItems.ANGLER_POTTERY_SHERD_BLUEPRINT);
                        entries.add(ModItems.ARCHER_POTTERY_SHERD_BLUEPRINT);
                        entries.add(ModItems.ARMS_UP_POTTERY_SHERD_BLUEPRINT);
                        entries.add(ModItems.BLADE_POTTERY_SHERD_BLUEPRINT);
                        entries.add(ModItems.BREWER_POTTERY_SHERD_BLUEPRINT);
                        entries.add(ModItems.BURN_POTTERY_SHERD_BLUEPRINT);
                        entries.add(ModItems.DANGER_POTTERY_SHERD_BLUEPRINT);
                        entries.add(ModItems.EXPLORER_POTTERY_SHERD_BLUEPRINT);
                        entries.add(ModItems.FRIEND_POTTERY_SHERD_BLUEPRINT);
                        entries.add(ModItems.HEART_POTTERY_SHERD_BLUEPRINT);
                        entries.add(ModItems.HEARTBREAK_POTTERY_SHERD_BLUEPRINT);
                        entries.add(ModItems.HOWL_POTTERY_SHERD_BLUEPRINT);
                        entries.add(ModItems.MINER_POTTERY_SHERD_BLUEPRINT);
                        entries.add(ModItems.MOURNER_POTTERY_SHERD_BLUEPRINT);
                        entries.add(ModItems.PLENTY_POTTERY_SHERD_BLUEPRINT);
                        entries.add(ModItems.PRIZE_POTTERY_SHERD_BLUEPRINT);
                        entries.add(ModItems.SHEAF_POTTERY_SHERD_BLUEPRINT);
                        entries.add(ModItems.SHELTER_POTTERY_SHERD_BLUEPRINT);
                        entries.add(ModItems.SKULL_POTTERY_SHERD_BLUEPRINT);
                        entries.add(ModItems.SNORT_POTTERY_SHERD_BLUEPRINT);
                        entries.add(ModItems.FLOW_POTTERY_SHERD_BLUEPRINT);
                        entries.add(ModItems.GUSTER_POTTERY_SHERD_BLUEPRINT);
                        entries.add(ModItems.SCRAPE_POTTERY_SHERD_BLUEPRINT);

                        entries.add(ModItems.ANGLER_POTTERY_SHERD_PROTOTYPE);
                        entries.add(ModItems.ARCHER_POTTERY_SHERD_PROTOTYPE);
                        entries.add(ModItems.ARMS_UP_POTTERY_SHERD_PROTOTYPE);
                        entries.add(ModItems.BLADE_POTTERY_SHERD_PROTOTYPE);
                        entries.add(ModItems.BREWER_POTTERY_SHERD_PROTOTYPE);
                        entries.add(ModItems.BURN_POTTERY_SHERD_PROTOTYPE);
                        entries.add(ModItems.DANGER_POTTERY_SHERD_PROTOTYPE);
                        entries.add(ModItems.EXPLORER_POTTERY_SHERD_PROTOTYPE);
                        entries.add(ModItems.FRIEND_POTTERY_SHERD_PROTOTYPE);
                        entries.add(ModItems.HEART_POTTERY_SHERD_PROTOTYPE);
                        entries.add(ModItems.HEARTBREAK_POTTERY_SHERD_PROTOTYPE);
                        entries.add(ModItems.HOWL_POTTERY_SHERD_PROTOTYPE);
                        entries.add(ModItems.MINER_POTTERY_SHERD_PROTOTYPE);
                        entries.add(ModItems.MOURNER_POTTERY_SHERD_PROTOTYPE);
                        entries.add(ModItems.PLENTY_POTTERY_SHERD_PROTOTYPE);
                        entries.add(ModItems.PRIZE_POTTERY_SHERD_PROTOTYPE);
                        entries.add(ModItems.SHEAF_POTTERY_SHERD_PROTOTYPE);
                        entries.add(ModItems.SHELTER_POTTERY_SHERD_PROTOTYPE);
                        entries.add(ModItems.SKULL_POTTERY_SHERD_PROTOTYPE);
                        entries.add(ModItems.SNORT_POTTERY_SHERD_PROTOTYPE);
                        entries.add(ModItems.FLOW_POTTERY_SHERD_PROTOTYPE);
                        entries.add(ModItems.GUSTER_POTTERY_SHERD_PROTOTYPE);
                        entries.add(ModItems.SCRAPE_POTTERY_SHERD_PROTOTYPE);
                    }).build());

    public static final ItemGroup Vanilla_Building_Addition =Registry.register(
            Registries.ITEM_GROUP,
            Identifier.of(VanillaAddition.MOD_ID,"vanilla_building_addition"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.building_addition"))
                    .icon(()->new ItemStack(ModBlocks.PURPUR_WALL))
                    .entries((displayContext,entries)->{
                        entries.add(ModBlocks.STONE);
                        entries.add(ModBlocks.STONE_STAIRS);
                        entries.add(ModBlocks.STONE_SLAB);
                        entries.add(ModBlocks.STONE_WALL);

                        entries.add(ModBlocks.SMOOTH_STONE);
                        entries.add(ModBlocks.SMOOTH_STONE_STAIRS);
                        entries.add(ModBlocks.SMOOTH_STONE_SLAB);
                        entries.add(ModBlocks.SMOOTH_STONE_WALL);

                        entries.add(ModBlocks.DIRT);
                        entries.add(ModBlocks.DIRT_STAIRS);
                        entries.add(ModBlocks.DIRT_SLAB);
                        entries.add(ModBlocks.DIRT_WALL);

                        entries.add(ModBlocks.MUD);
                        entries.add(ModBlocks.MUD_STAIRS);
                        entries.add(ModBlocks.MUD_SLAB);
                        entries.add(ModBlocks.MUD_WALL);

                        entries.add(ModBlocks.CLAY);
                        entries.add(ModBlocks.CLAY_STAIRS);
                        entries.add(ModBlocks.CLAY_SLAB);
                        entries.add(ModBlocks.CLAY_WALL);

                        entries.add(ModBlocks.POLISHED_GRANITE);
                        entries.add(ModBlocks.POLISHED_GRANITE_STAIRS);
                        entries.add(ModBlocks.POLISHED_GRANITE_SLAB);
                        entries.add(ModBlocks.POLISHED_GRANITE_WALL);

                        entries.add(ModBlocks.POLISHED_DIORITE);
                        entries.add(ModBlocks.POLISHED_DIORITE_STAIRS);
                        entries.add(ModBlocks.POLISHED_DIORITE_SLAB);
                        entries.add(ModBlocks.POLISHED_DIORITE_WALL);

                        entries.add(ModBlocks.POLISHED_ANDESITE);
                        entries.add(ModBlocks.POLISHED_ANDESITE_STAIRS);
                        entries.add(ModBlocks.POLISHED_ANDESITE_SLAB);
                        entries.add(ModBlocks.POLISHED_ANDESITE_WALL);

                        entries.add(ModBlocks.CALCITE);
                        entries.add(ModBlocks.CALCITE_STAIRS);
                        entries.add(ModBlocks.CALCITE_SLAB);
                        entries.add(ModBlocks.CALCITE_WALL);

                        entries.add(ModBlocks.SMOOTH_SANDSTONE);
                        entries.add(ModBlocks.SMOOTH_SANDSTONE_STAIRS);
                        entries.add(ModBlocks.SMOOTH_SANDSTONE_SLAB);
                        entries.add(ModBlocks.SMOOTH_SANDSTONE_WALL);

                        entries.add(ModBlocks.SMOOTH_RED_SANDSTONE);
                        entries.add(ModBlocks.SMOOTH_RED_SANDSTONE_STAIRS);
                        entries.add(ModBlocks.SMOOTH_RED_SANDSTONE_SLAB);
                        entries.add(ModBlocks.SMOOTH_RED_SANDSTONE_WALL);

                        entries.add(ModBlocks.PRISMARINE_BRICKS);
                        entries.add(ModBlocks.PRISMARINE_BRICK_STAIRS);
                        entries.add(ModBlocks.PRISMARINE_BRICK_SLAB);
                        entries.add(ModBlocks.PRISMARINE_BRICK_WALL);

                        entries.add(ModBlocks.DARK_PRISMARINE);
                        entries.add(ModBlocks.DARK_PRISMARINE_STAIRS);
                        entries.add(ModBlocks.DARK_PRISMARINE_SLAB);
                        entries.add(ModBlocks.DARK_PRISMARINE_WALL);

                        entries.add(ModBlocks.OBSIDIAN);
                        entries.add(ModBlocks.OBSIDIAN_STAIRS);
                        entries.add(ModBlocks.OBSIDIAN_SLAB);
                        entries.add(ModBlocks.OBSIDIAN_WALL);

                        entries.add(ModBlocks.CRYING_OBSIDIAN);
                        entries.add(ModBlocks.CRYING_OBSIDIAN_STAIRS);
                        entries.add(ModBlocks.CRYING_OBSIDIAN_SLAB);
                        entries.add(ModBlocks.CRYING_OBSIDIAN_WALL);

                        entries.add(ModBlocks.NETHERRACK);
                        entries.add(ModBlocks.NETHERRACK_STAIRS);
                        entries.add(ModBlocks.NETHERRACK_SLAB);
                        entries.add(ModBlocks.NETHERRACK_WALL);

                        entries.add(ModBlocks.BASALT);
                        entries.add(ModBlocks.BASALT_STAIRS);
                        entries.add(ModBlocks.BASALT_SLAB);
                        entries.add(ModBlocks.BASALT_WALL);

                        entries.add(ModBlocks.SMOOTH_BASALT);
                        entries.add(ModBlocks.SMOOTH_BASALT_STAIRS);
                        entries.add(ModBlocks.SMOOTH_BASALT_SLAB);
                        entries.add(ModBlocks.SMOOTH_BASALT_WALL);

                        entries.add(ModBlocks.POLISHED_BASALT);
                        entries.add(ModBlocks.POLISHED_BASALT_STAIRS);
                        entries.add(ModBlocks.POLISHED_BASALT_SLAB);
                        entries.add(ModBlocks.POLISHED_BASALT_WALL);

                        entries.add(ModBlocks.END_STONE);
                        entries.add(ModBlocks.END_STONE_STAIRS);
                        entries.add(ModBlocks.END_STONE_SLAB);
                        entries.add(ModBlocks.END_STONE_WALL);

                        entries.add(ModBlocks.PURPUR_BLOCK);
                        entries.add(ModBlocks.PURPUR_STAIRS);
                        entries.add(ModBlocks.PURPUR_SLAB);
                        entries.add(ModBlocks.PURPUR_WALL);

                        entries.add(ModBlocks.QUARTZ_BLOCK);
                        entries.add(ModBlocks.QUARTZ_STAIRS);
                        entries.add(ModBlocks.QUARTZ_SLAB);
                        entries.add(ModBlocks.QUARTZ_WALL);

                        entries.add(ModBlocks.SMOOTH_QUARTZ);
                        entries.add(ModBlocks.SMOOTH_QUARTZ_STAIRS);
                        entries.add(ModBlocks.SMOOTH_QUARTZ_SLAB);
                        entries.add(ModBlocks.SMOOTH_QUARTZ_WALL);

                        entries.add(ModBlocks.AMETHYST_BLOCK);
                        entries.add(ModBlocks.AMETHYST_STAIRS);
                        entries.add(ModBlocks.AMETHYST_SLAB);
                        entries.add(ModBlocks.AMETHYST_WALL);

                        entries.add(ModBlocks.GLOWSTONE);
                        entries.add(ModBlocks.GLOWSTONE_STAIRS);
                        entries.add(ModBlocks.GLOWSTONE_SLAB);
                        entries.add(ModBlocks.GLOWSTONE_WALL);

                        entries.add(ModBlocks.ICE);
                        entries.add(ModBlocks.ICE_STAIRS);
                        entries.add(ModBlocks.ICE_SLAB);
                        entries.add(ModBlocks.ICE_WALL);

                        entries.add(ModBlocks.PACKED_ICE);
                        entries.add(ModBlocks.PACKED_ICE_STAIRS);
                        entries.add(ModBlocks.PACKED_ICE_SLAB);
                        entries.add(ModBlocks.PACKED_ICE_WALL);

                        entries.add(ModBlocks.BLUE_ICE);
                        entries.add(ModBlocks.BLUE_ICE_STAIRS);
                        entries.add(ModBlocks.BLUE_ICE_SLAB);
                        entries.add(ModBlocks.BLUE_ICE_WALL);

                        entries.add(ModBlocks.WHITE_CONCRETE);
                        entries.add(ModBlocks.WHITE_CONCRETE_STAIRS);
                        entries.add(ModBlocks.WHITE_CONCRETE_SLAB);
                        entries.add(ModBlocks.WHITE_CONCRETE_WALL);

                        entries.add(ModBlocks.LIGHT_GRAY_CONCRETE);
                        entries.add(ModBlocks.LIGHT_GRAY_CONCRETE_STAIRS);
                        entries.add(ModBlocks.LIGHT_GRAY_CONCRETE_SLAB);
                        entries.add(ModBlocks.LIGHT_GRAY_CONCRETE_WALL);

                        entries.add(ModBlocks.GRAY_CONCRETE);
                        entries.add(ModBlocks.GRAY_CONCRETE_STAIRS);
                        entries.add(ModBlocks.GRAY_CONCRETE_SLAB);
                        entries.add(ModBlocks.GRAY_CONCRETE_WALL);

                        entries.add(ModBlocks.BLACK_CONCRETE);
                        entries.add(ModBlocks.BLACK_CONCRETE_STAIRS);
                        entries.add(ModBlocks.BLACK_CONCRETE_SLAB);
                        entries.add(ModBlocks.BLACK_CONCRETE_WALL);

                        entries.add(ModBlocks.BROWN_CONCRETE);
                        entries.add(ModBlocks.BROWN_CONCRETE_STAIRS);
                        entries.add(ModBlocks.BROWN_CONCRETE_SLAB);
                        entries.add(ModBlocks.BROWN_CONCRETE_WALL);

                        entries.add(ModBlocks.RED_CONCRETE);
                        entries.add(ModBlocks.RED_CONCRETE_STAIRS);
                        entries.add(ModBlocks.RED_CONCRETE_SLAB);
                        entries.add(ModBlocks.RED_CONCRETE_WALL);

                        entries.add(ModBlocks.ORANGE_CONCRETE);
                        entries.add(ModBlocks.ORANGE_CONCRETE_STAIRS);
                        entries.add(ModBlocks.ORANGE_CONCRETE_SLAB);
                        entries.add(ModBlocks.ORANGE_CONCRETE_WALL);

                        entries.add(ModBlocks.YELLOW_CONCRETE);
                        entries.add(ModBlocks.YELLOW_CONCRETE_STAIRS);
                        entries.add(ModBlocks.YELLOW_CONCRETE_SLAB);
                        entries.add(ModBlocks.YELLOW_CONCRETE_WALL);

                        entries.add(ModBlocks.LIME_CONCRETE);
                        entries.add(ModBlocks.LIME_CONCRETE_STAIRS);
                        entries.add(ModBlocks.LIME_CONCRETE_SLAB);
                        entries.add(ModBlocks.LIME_CONCRETE_WALL);

                        entries.add(ModBlocks.GREEN_CONCRETE);
                        entries.add(ModBlocks.GREEN_CONCRETE_STAIRS);
                        entries.add(ModBlocks.GREEN_CONCRETE_SLAB);
                        entries.add(ModBlocks.GREEN_CONCRETE_WALL);

                        entries.add(ModBlocks.CYAN_CONCRETE);
                        entries.add(ModBlocks.CYAN_CONCRETE_STAIRS);
                        entries.add(ModBlocks.CYAN_CONCRETE_SLAB);
                        entries.add(ModBlocks.CYAN_CONCRETE_WALL);

                        entries.add(ModBlocks.LIGHT_BLUE_CONCRETE);
                        entries.add(ModBlocks.LIGHT_BLUE_CONCRETE_STAIRS);
                        entries.add(ModBlocks.LIGHT_BLUE_CONCRETE_SLAB);
                        entries.add(ModBlocks.LIGHT_BLUE_CONCRETE_WALL);

                        entries.add(ModBlocks.BLUE_CONCRETE);
                        entries.add(ModBlocks.BLUE_CONCRETE_STAIRS);
                        entries.add(ModBlocks.BLUE_CONCRETE_SLAB);
                        entries.add(ModBlocks.BLUE_CONCRETE_WALL);

                        entries.add(ModBlocks.PURPLE_CONCRETE);
                        entries.add(ModBlocks.PURPLE_CONCRETE_STAIRS);
                        entries.add(ModBlocks.PURPLE_CONCRETE_SLAB);
                        entries.add(ModBlocks.PURPLE_CONCRETE_WALL);

                        entries.add(ModBlocks.MAGENTA_CONCRETE);
                        entries.add(ModBlocks.MAGENTA_CONCRETE_STAIRS);
                        entries.add(ModBlocks.MAGENTA_CONCRETE_SLAB);
                        entries.add(ModBlocks.MAGENTA_CONCRETE_WALL);

                        entries.add(ModBlocks.PINK_CONCRETE);
                        entries.add(ModBlocks.PINK_CONCRETE_STAIRS);
                        entries.add(ModBlocks.PINK_CONCRETE_SLAB);
                        entries.add(ModBlocks.PINK_CONCRETE_WALL);

                        entries.add(ModBlocks.TERRACOTTA);
                        entries.add(ModBlocks.TERRACOTTA_STAIRS);
                        entries.add(ModBlocks.TERRACOTTA_SLAB);
                        entries.add(ModBlocks.TERRACOTTA_WALL);

                        entries.add(ModBlocks.WHITE_TERRACOTTA);
                        entries.add(ModBlocks.WHITE_TERRACOTTA_STAIRS);
                        entries.add(ModBlocks.WHITE_TERRACOTTA_SLAB);
                        entries.add(ModBlocks.WHITE_TERRACOTTA_WALL);

                        entries.add(ModBlocks.LIGHT_GRAY_TERRACOTTA);
                        entries.add(ModBlocks.LIGHT_GRAY_TERRACOTTA_STAIRS);
                        entries.add(ModBlocks.LIGHT_GRAY_TERRACOTTA_SLAB);
                        entries.add(ModBlocks.LIGHT_GRAY_TERRACOTTA_WALL);

                        entries.add(ModBlocks.GRAY_TERRACOTTA);
                        entries.add(ModBlocks.GRAY_TERRACOTTA_STAIRS);
                        entries.add(ModBlocks.GRAY_TERRACOTTA_SLAB);
                        entries.add(ModBlocks.GRAY_TERRACOTTA_WALL);

                        entries.add(ModBlocks.BLACK_TERRACOTTA);
                        entries.add(ModBlocks.BLACK_TERRACOTTA_STAIRS);
                        entries.add(ModBlocks.BLACK_TERRACOTTA_SLAB);
                        entries.add(ModBlocks.BLACK_TERRACOTTA_WALL);

                        entries.add(ModBlocks.BROWN_TERRACOTTA);
                        entries.add(ModBlocks.BROWN_TERRACOTTA_STAIRS);
                        entries.add(ModBlocks.BROWN_TERRACOTTA_SLAB);
                        entries.add(ModBlocks.BROWN_TERRACOTTA_WALL);

                        entries.add(ModBlocks.RED_TERRACOTTA);
                        entries.add(ModBlocks.RED_TERRACOTTA_STAIRS);
                        entries.add(ModBlocks.RED_TERRACOTTA_SLAB);
                        entries.add(ModBlocks.RED_TERRACOTTA_WALL);

                        entries.add(ModBlocks.ORANGE_TERRACOTTA);
                        entries.add(ModBlocks.ORANGE_TERRACOTTA_STAIRS);
                        entries.add(ModBlocks.ORANGE_TERRACOTTA_SLAB);
                        entries.add(ModBlocks.ORANGE_TERRACOTTA_WALL);

                        entries.add(ModBlocks.YELLOW_TERRACOTTA);
                        entries.add(ModBlocks.YELLOW_TERRACOTTA_STAIRS);
                        entries.add(ModBlocks.YELLOW_TERRACOTTA_SLAB);
                        entries.add(ModBlocks.YELLOW_TERRACOTTA_WALL);

                        entries.add(ModBlocks.LIME_TERRACOTTA);
                        entries.add(ModBlocks.LIME_TERRACOTTA_STAIRS);
                        entries.add(ModBlocks.LIME_TERRACOTTA_SLAB);
                        entries.add(ModBlocks.LIME_TERRACOTTA_WALL);

                        entries.add(ModBlocks.GREEN_TERRACOTTA);
                        entries.add(ModBlocks.GREEN_TERRACOTTA_STAIRS);
                        entries.add(ModBlocks.GREEN_TERRACOTTA_SLAB);
                        entries.add(ModBlocks.GREEN_TERRACOTTA_WALL);

                        entries.add(ModBlocks.CYAN_TERRACOTTA);
                        entries.add(ModBlocks.CYAN_TERRACOTTA_STAIRS);
                        entries.add(ModBlocks.CYAN_TERRACOTTA_SLAB);
                        entries.add(ModBlocks.CYAN_TERRACOTTA_WALL);

                        entries.add(ModBlocks.LIGHT_BLUE_TERRACOTTA);
                        entries.add(ModBlocks.LIGHT_BLUE_TERRACOTTA_STAIRS);
                        entries.add(ModBlocks.LIGHT_BLUE_TERRACOTTA_SLAB);
                        entries.add(ModBlocks.LIGHT_BLUE_TERRACOTTA_WALL);

                        entries.add(ModBlocks.BLUE_TERRACOTTA);
                        entries.add(ModBlocks.BLUE_TERRACOTTA_STAIRS);
                        entries.add(ModBlocks.BLUE_TERRACOTTA_SLAB);
                        entries.add(ModBlocks.BLUE_TERRACOTTA_WALL);

                        entries.add(ModBlocks.PURPLE_TERRACOTTA);
                        entries.add(ModBlocks.PURPLE_TERRACOTTA_STAIRS);
                        entries.add(ModBlocks.PURPLE_TERRACOTTA_SLAB);
                        entries.add(ModBlocks.PURPLE_TERRACOTTA_WALL);

                        entries.add(ModBlocks.MAGENTA_TERRACOTTA);
                        entries.add(ModBlocks.MAGENTA_TERRACOTTA_STAIRS);
                        entries.add(ModBlocks.MAGENTA_TERRACOTTA_SLAB);
                        entries.add(ModBlocks.MAGENTA_TERRACOTTA_WALL);

                        entries.add(ModBlocks.PINK_TERRACOTTA);
                        entries.add(ModBlocks.PINK_TERRACOTTA_STAIRS);
                        entries.add(ModBlocks.PINK_TERRACOTTA_SLAB);
                        entries.add(ModBlocks.PINK_TERRACOTTA_WALL);

                    }).build());

    public static void registerModItemGroup(){

    }
}
