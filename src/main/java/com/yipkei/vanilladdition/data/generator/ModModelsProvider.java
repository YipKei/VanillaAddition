package com.yipkei.vanilladdition.data.generator;

import com.yipkei.vanilladdition.init.ModBlocks;
import com.yipkei.vanilladdition.init.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.BlockStateModelGenerator.BlockTexturePool;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelsProvider extends FabricModelProvider {
    public ModModelsProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockTexturePool steel              = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.STEEL_BLOCK);
        BlockTexturePool stone              = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.STONE);
        BlockTexturePool smoothStone        = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.SMOOTH_STONE);
        BlockTexturePool polishedGranite    = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.POLISHED_GRANITE);
        BlockTexturePool polishedDiorite    = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.POLISHED_DIORITE);
        BlockTexturePool polishedAndesite   = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.POLISHED_ANDESITE);
        BlockTexturePool smoothSandstone    = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.SMOOTH_SANDSTONE);
        BlockTexturePool smoothRedSandStone = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.SMOOTH_RED_SANDSTONE);
        BlockTexturePool prismarineBricks   = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.PRISMARINE_BRICKS);
        BlockTexturePool darkPrismarine     = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.DARK_PRISMARINE);
        BlockTexturePool netherrack         = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.NETHERRACK);
        BlockTexturePool basalt             = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SHADOW_BASALT);
        BlockTexturePool smoothBasalt       = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.SMOOTH_BASALT);
        BlockTexturePool polishedBasalt     = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SHADOW_POLISHED_BASALT);
        BlockTexturePool purpur             = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.PURPUR_BLOCK);
        BlockTexturePool quartz             = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SHADOW_QUARTZ_BLOCK);
        BlockTexturePool smoothQuartz       = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.SMOOTH_QUARTZ);
        BlockTexturePool dirt               = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.DIRT);
        BlockTexturePool mud                = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.MUD);
        BlockTexturePool clay               = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.CLAY);
        BlockTexturePool ice                = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.ICE);
        BlockTexturePool packedIce          = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.PACKED_ICE);
        BlockTexturePool blueIce            = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.BLUE_ICE);
        BlockTexturePool calcite            = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.CALCITE);
        BlockTexturePool obsidian           = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.OBSIDIAN);
        BlockTexturePool cryingObsidian     = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.CRYING_OBSIDIAN);
        BlockTexturePool endStone           = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.END_STONE);
        BlockTexturePool amethystBlock      = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.AMETHYST_BLOCK);
        BlockTexturePool glowstone          = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.GLOWSTONE);

        BlockTexturePool whiteConcrete      = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.WHITE_CONCRETE);
        BlockTexturePool orangeConcrete     = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.ORANGE_CONCRETE);
        BlockTexturePool magentaConcrete    = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.MAGENTA_CONCRETE);
        BlockTexturePool lightBlueConcrete  = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.LIGHT_BLUE_CONCRETE);
        BlockTexturePool yellowConcrete     = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.YELLOW_CONCRETE);
        BlockTexturePool limeConcrete       = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.LIME_CONCRETE);
        BlockTexturePool pinkConcrete       = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.PINK_CONCRETE);
        BlockTexturePool grayConcrete       = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.GRAY_CONCRETE);
        BlockTexturePool lightGrayConcrete  = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.LIGHT_GRAY_CONCRETE);
        BlockTexturePool cyanConcrete       = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.CYAN_CONCRETE);
        BlockTexturePool purpleConcrete     = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.PURPLE_CONCRETE);
        BlockTexturePool blueConcrete       = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.BLUE_CONCRETE);
        BlockTexturePool brownConcrete      = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.BROWN_CONCRETE);
        BlockTexturePool greenConcrete      = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.GREEN_CONCRETE);
        BlockTexturePool redConcrete        = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.RED_CONCRETE);
        BlockTexturePool blackConcrete      = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.BLACK_CONCRETE);

        BlockTexturePool terracotta         = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.TERRACOTTA);
        BlockTexturePool whiteTerracotta    = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.WHITE_TERRACOTTA);
        BlockTexturePool orangeTerracotta   = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.ORANGE_TERRACOTTA);
        BlockTexturePool magentaTerracotta  = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.MAGENTA_TERRACOTTA);
        BlockTexturePool lightBlueTerracotta= blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.LIGHT_BLUE_TERRACOTTA);
        BlockTexturePool yellowTerracotta   = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.YELLOW_TERRACOTTA);
        BlockTexturePool limeTerracotta     = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.LIME_TERRACOTTA);
        BlockTexturePool pinkTerracotta     = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.PINK_TERRACOTTA);
        BlockTexturePool grayTerracotta     = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.GRAY_TERRACOTTA);
        BlockTexturePool lightGrayTerracotta= blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.LIGHT_GRAY_TERRACOTTA);
        BlockTexturePool cyanTerracotta     = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.CYAN_TERRACOTTA);
        BlockTexturePool purpleTerracotta   = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.PURPLE_TERRACOTTA);
        BlockTexturePool blueTerracotta     = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.BLUE_TERRACOTTA);
        BlockTexturePool brownTerracotta    = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.BROWN_TERRACOTTA);
        BlockTexturePool greenTerracotta    = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.GREEN_TERRACOTTA);
        BlockTexturePool redTerracotta      = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.RED_TERRACOTTA);
        BlockTexturePool blackTerracotta    = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.BLACK_TERRACOTTA);


        //方块补全（一）只缺墙
        //石质
        stone.wall(ModBlocks.STONE_WALL);
        //磨制花岗岩
        polishedGranite.wall(ModBlocks.POLISHED_GRANITE_WALL);
        //磨制闪长岩
        polishedDiorite.wall(ModBlocks.POLISHED_DIORITE_WALL);
        //磨制安山岩
        polishedAndesite.wall(ModBlocks.POLISHED_ANDESITE_WALL);
        //平滑砂岩
        smoothSandstone.wall(ModBlocks.SMOOTH_SANDSTONE_WALL);
        //平滑红砂岩
        smoothRedSandStone.wall(ModBlocks.SMOOTH_RED_SANDSTONE_WALL);
        //海晶砖
        prismarineBricks.wall(ModBlocks.PRISMARINE_BRICK_WALL);
        //暗海晶砖
        darkPrismarine.wall(ModBlocks.DARK_PRISMARINE_WALL);
        //石英 - 特殊模型
        quartz
                .wall  (ModBlocks.QUARTZ_WALL)        ;
        //平滑石英
        smoothQuartz
                .wall  (ModBlocks.SMOOTH_QUARTZ_WALL);

        //缺楼梯和墙
        //平滑石
        smoothStone
                .wall  (ModBlocks.SMOOTH_STONE_WALL)
                .stairs(ModBlocks.SMOOTH_STONE_STAIRS);

        //缺楼梯、墙、半砖
        //泥土
        dirt
                .wall  (ModBlocks.DIRT_WALL)
                .stairs(ModBlocks.DIRT_STAIRS)
                .slab  (ModBlocks.DIRT_SLAB);
        //泥巴
        mud
                .wall  (ModBlocks.MUD_WALL)
                .stairs(ModBlocks.MUD_STAIRS)
                .slab  (ModBlocks.MUD_SLAB);
        //黏土
        clay
                .wall  (ModBlocks.CLAY_WALL)
                .stairs(ModBlocks.CLAY_STAIRS)
                .slab  (ModBlocks.CLAY_SLAB);
        //方解石
        calcite
                .wall  (ModBlocks.CALCITE_WALL)
                .stairs(ModBlocks.CALCITE_STAIRS)
                .slab  (ModBlocks.CALCITE_SLAB);

        //下界岩
        netherrack
                .wall  (ModBlocks.NETHERRACK_WALL)
                .stairs(ModBlocks.NETHERRACK_STAIRS)
                .slab  (ModBlocks.NETHERRACK_SLAB);
        //玄武岩 - 特殊模型
        basalt
                .wall  (ModBlocks.BASALT_WALL)
                .stairs(ModBlocks.BASALT_STAIRS)
                .slab  (ModBlocks.BASALT_SLAB);
        //平滑玄武岩
        smoothBasalt
                .wall  (ModBlocks.SMOOTH_BASALT_WALL)
                .stairs(ModBlocks.SMOOTH_BASALT_STAIRS)
                .slab  (ModBlocks.SMOOTH_BASALT_SLAB);
        //磨制玄武岩 - 特殊模型
        polishedBasalt
                .wall  (ModBlocks.POLISHED_BASALT_WALL)
                .stairs(ModBlocks.POLISHED_BASALT_STAIRS)
                .slab  (ModBlocks.POLISHED_BASALT_SLAB);
        //黑曜石
        obsidian
                .wall  (ModBlocks.OBSIDIAN_WALL)
                .stairs(ModBlocks.OBSIDIAN_STAIRS)
                .slab  (ModBlocks.OBSIDIAN_SLAB);
        //哭泣黑曜石
        cryingObsidian
                .wall  (ModBlocks.CRYING_OBSIDIAN_WALL)
                .stairs(ModBlocks.CRYING_OBSIDIAN_STAIRS)
                .slab  (ModBlocks.CRYING_OBSIDIAN_SLAB);
        //紫珀块
        purpur
                .wall  (ModBlocks.PURPUR_WALL);
        //末地石
        endStone
                .wall  (ModBlocks.END_STONE_WALL)
                .stairs(ModBlocks.END_STONE_STAIRS)
                .slab  (ModBlocks.END_STONE_SLAB);
        //浮冰
        ice
                .wall  (ModBlocks.ICE_WALL)
                .stairs(ModBlocks.ICE_STAIRS)
                .slab  (ModBlocks.ICE_SLAB);
        //冰
        packedIce
                .wall  (ModBlocks.PACKED_ICE_WALL)
                .stairs(ModBlocks.PACKED_ICE_STAIRS)
                .slab  (ModBlocks.PACKED_ICE_SLAB);
        //蓝冰
        blueIce
                .wall  (ModBlocks.BLUE_ICE_WALL)
                .stairs(ModBlocks.BLUE_ICE_STAIRS)
                .slab  (ModBlocks.BLUE_ICE_SLAB);
        //萤石
        glowstone
                .wall (ModBlocks.GLOWSTONE_WALL)
                .stairs(ModBlocks.GLOWSTONE_STAIRS)
                .slab  (ModBlocks.GLOWSTONE_SLAB);
        //紫水晶
        amethystBlock
                .wall  (ModBlocks.AMETHYST_WALL)
                .stairs(ModBlocks.AMETHYST_STAIRS)
                .slab  (ModBlocks.AMETHYST_SLAB);

        //彩色方块
        whiteConcrete
                .wall  (ModBlocks.WHITE_CONCRETE_WALL)
                .stairs(ModBlocks.WHITE_CONCRETE_STAIRS)
                .slab  (ModBlocks.WHITE_CONCRETE_SLAB);
        lightGrayConcrete
                .wall  (ModBlocks.LIGHT_GRAY_CONCRETE_WALL)
                .stairs(ModBlocks.LIGHT_GRAY_CONCRETE_STAIRS)
                .slab  (ModBlocks.LIGHT_GRAY_CONCRETE_SLAB);
        grayConcrete
                .wall  (ModBlocks.GRAY_CONCRETE_WALL)
                .stairs(ModBlocks.GRAY_CONCRETE_STAIRS)
                .slab  (ModBlocks.GRAY_CONCRETE_SLAB);
        blackConcrete
                .wall  (ModBlocks.BLACK_CONCRETE_WALL)
                .stairs(ModBlocks.BLACK_CONCRETE_STAIRS)
                .slab  (ModBlocks.BLACK_CONCRETE_SLAB);
        brownConcrete
                .wall  (ModBlocks.BROWN_CONCRETE_WALL)
                .stairs(ModBlocks.BROWN_CONCRETE_STAIRS)
                .slab  (ModBlocks.BROWN_CONCRETE_SLAB);
        redConcrete
                .wall  (ModBlocks.RED_CONCRETE_WALL)
                .stairs(ModBlocks.RED_CONCRETE_STAIRS)
                .slab  (ModBlocks.RED_CONCRETE_SLAB);
        orangeConcrete
                .wall  (ModBlocks.ORANGE_CONCRETE_WALL)
                .stairs(ModBlocks.ORANGE_CONCRETE_STAIRS)
                .slab  (ModBlocks.ORANGE_CONCRETE_SLAB);
        yellowConcrete
                .wall  (ModBlocks.YELLOW_CONCRETE_WALL)
                .stairs(ModBlocks.YELLOW_CONCRETE_STAIRS)
                .slab  (ModBlocks.YELLOW_CONCRETE_SLAB);
        limeConcrete
                .wall  (ModBlocks.LIME_CONCRETE_WALL)
                .stairs(ModBlocks.LIME_CONCRETE_STAIRS)
                .slab  (ModBlocks.LIME_CONCRETE_SLAB);
        greenConcrete
                .wall  (ModBlocks.GREEN_CONCRETE_WALL)
                .stairs(ModBlocks.GREEN_CONCRETE_STAIRS)
                .slab  (ModBlocks.GREEN_CONCRETE_SLAB);
        cyanConcrete
                .wall  (ModBlocks.CYAN_CONCRETE_WALL)
                .stairs(ModBlocks.CYAN_CONCRETE_STAIRS)
                .slab  (ModBlocks.CYAN_CONCRETE_SLAB);
        lightBlueConcrete
                .wall  (ModBlocks.LIGHT_BLUE_CONCRETE_WALL)
                .stairs(ModBlocks.LIGHT_BLUE_CONCRETE_STAIRS)
                .slab  (ModBlocks.LIGHT_BLUE_CONCRETE_SLAB);
        blueConcrete
                .wall  (ModBlocks.BLUE_CONCRETE_WALL)
                .stairs(ModBlocks.BLUE_CONCRETE_STAIRS)
                .slab  (ModBlocks.BLUE_CONCRETE_SLAB);
        purpleConcrete
                .wall  (ModBlocks.PURPLE_CONCRETE_WALL)
                .stairs(ModBlocks.PURPLE_CONCRETE_STAIRS)
                .slab  (ModBlocks.PURPLE_CONCRETE_SLAB);
        magentaConcrete
                .wall  (ModBlocks.MAGENTA_CONCRETE_WALL)
                .stairs(ModBlocks.MAGENTA_CONCRETE_STAIRS)
                .slab  (ModBlocks.MAGENTA_CONCRETE_SLAB);
        pinkConcrete
                .wall  (ModBlocks.PINK_CONCRETE_WALL)
                .stairs(ModBlocks.PINK_CONCRETE_STAIRS)
                .slab  (ModBlocks.PINK_CONCRETE_SLAB);

        terracotta
                .wall  (ModBlocks.TERRACOTTA_WALL)
                .stairs(ModBlocks.TERRACOTTA_STAIRS)
                .slab  (ModBlocks.TERRACOTTA_SLAB);
        whiteTerracotta
                .wall  (ModBlocks.WHITE_TERRACOTTA_WALL)
                .stairs(ModBlocks.WHITE_TERRACOTTA_STAIRS)
                .slab  (ModBlocks.WHITE_TERRACOTTA_SLAB);
        lightGrayTerracotta
                .wall  (ModBlocks.LIGHT_GRAY_TERRACOTTA_WALL)
                .stairs(ModBlocks.LIGHT_GRAY_TERRACOTTA_STAIRS)
                .slab  (ModBlocks.LIGHT_GRAY_TERRACOTTA_SLAB);
        grayTerracotta
                .wall  (ModBlocks.GRAY_TERRACOTTA_WALL)
                .stairs(ModBlocks.GRAY_TERRACOTTA_STAIRS)
                .slab  (ModBlocks.GRAY_TERRACOTTA_SLAB);
        blackTerracotta
                .wall  (ModBlocks.BLACK_TERRACOTTA_WALL)
                .stairs(ModBlocks.BLACK_TERRACOTTA_STAIRS)
                .slab  (ModBlocks.BLACK_TERRACOTTA_SLAB);
        brownTerracotta
                .wall  (ModBlocks.BROWN_TERRACOTTA_WALL)
                .stairs(ModBlocks.BROWN_TERRACOTTA_STAIRS)
                .slab  (ModBlocks.BROWN_TERRACOTTA_SLAB);
        redTerracotta
                .wall  (ModBlocks.RED_TERRACOTTA_WALL)
                .stairs(ModBlocks.RED_TERRACOTTA_STAIRS)
                .slab  (ModBlocks.RED_TERRACOTTA_SLAB);
        orangeTerracotta
                .wall  (ModBlocks.ORANGE_TERRACOTTA_WALL)
                .stairs(ModBlocks.ORANGE_TERRACOTTA_STAIRS)
                .slab  (ModBlocks.ORANGE_TERRACOTTA_SLAB);
        yellowTerracotta
                .wall  (ModBlocks.YELLOW_TERRACOTTA_WALL)
                .stairs(ModBlocks.YELLOW_TERRACOTTA_STAIRS)
                .slab  (ModBlocks.YELLOW_TERRACOTTA_SLAB);
        limeTerracotta
                .wall  (ModBlocks.LIME_TERRACOTTA_WALL)
                .stairs(ModBlocks.LIME_TERRACOTTA_STAIRS)
                .slab  (ModBlocks.LIME_TERRACOTTA_SLAB);
        greenTerracotta
                .wall  (ModBlocks.GREEN_TERRACOTTA_WALL)
                .stairs(ModBlocks.GREEN_TERRACOTTA_STAIRS)
                .slab  (ModBlocks.GREEN_TERRACOTTA_SLAB);
        cyanTerracotta
                .wall  (ModBlocks.CYAN_TERRACOTTA_WALL)
                .stairs(ModBlocks.CYAN_TERRACOTTA_STAIRS)
                .slab  (ModBlocks.CYAN_TERRACOTTA_SLAB);
        lightBlueTerracotta
                .wall  (ModBlocks.LIGHT_BLUE_TERRACOTTA_WALL)
                .stairs(ModBlocks.LIGHT_BLUE_TERRACOTTA_STAIRS)
                .slab  (ModBlocks.LIGHT_BLUE_TERRACOTTA_SLAB);
        blueTerracotta
                .wall  (ModBlocks.BLUE_TERRACOTTA_WALL)
                .stairs(ModBlocks.BLUE_TERRACOTTA_STAIRS)
                .slab  (ModBlocks.BLUE_TERRACOTTA_SLAB);
        purpleTerracotta
                .wall  (ModBlocks.PURPLE_TERRACOTTA_WALL)
                .stairs(ModBlocks.PURPLE_TERRACOTTA_STAIRS)
                .slab  (ModBlocks.PURPLE_TERRACOTTA_SLAB);
        magentaTerracotta
                .wall  (ModBlocks.MAGENTA_TERRACOTTA_WALL)
                .stairs(ModBlocks.MAGENTA_TERRACOTTA_STAIRS)
                .slab  (ModBlocks.MAGENTA_TERRACOTTA_SLAB);
        pinkTerracotta
                .wall  (ModBlocks.PINK_TERRACOTTA_WALL)
                .stairs(ModBlocks.PINK_TERRACOTTA_STAIRS)
                .slab  (ModBlocks.PINK_TERRACOTTA_SLAB);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.ROASTED_ROTTEN_FLESH,Models.GENERATED);
        
        itemModelGenerator.register(ModItems.STEEL_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIAMOND_SHARD,Models.GENERATED);
        itemModelGenerator.register(ModItems.DIAMOND_SHARD_STACK,Models.GENERATED);
        itemModelGenerator.register(ModItems.PULSE_OF_THE_SEA,Models.GENERATED);
        itemModelGenerator.register(ModItems.DRAGON_WING_MEMBRANE,Models.GENERATED);
        itemModelGenerator.register(ModItems.ANCIENT_TEAR,Models.GENERATED);
        
        itemModelGenerator.register(ModItems.STONE_HAMMER,Models.GENERATED);
        itemModelGenerator.register(ModItems.IRON_HAMMER,Models.GENERATED);
        itemModelGenerator.register(ModItems.DIAMOND_HAMMER,Models.GENERATED);

        itemModelGenerator.register(ModItems.STEEL_SWORD,Models.HANDHELD);
        itemModelGenerator.register(ModItems.STEEL_SHOVEL,Models.HANDHELD);
        itemModelGenerator.register(ModItems.STEEL_PICKAXE,Models.HANDHELD);
        itemModelGenerator.register(ModItems.STEEL_AXE,Models.HANDHELD);
        itemModelGenerator.register(ModItems.STEEL_HOE,Models.HANDHELD);

        itemModelGenerator.register(ModItems.DIAMOND_UPGRADED_PICKAXE,Models.HANDHELD);
        itemModelGenerator.register(ModItems.DIAMOND_UPGRADED_AXE,Models.HANDHELD);
        itemModelGenerator.register(ModItems.GLASS_PICKAXE_PROTOTYPE,Models.HANDHELD);
        itemModelGenerator.register(ModItems.GLASS_PICKAXE,Models.HANDHELD);
        itemModelGenerator.register(ModItems.DESTROYER_PICKAXE,Models.HANDHELD);

        itemModelGenerator.register(ModItems.DIAMOND_FLINT,Models.HANDHELD);
        itemModelGenerator.register(ModItems.STEEL_SHEARS,Models.HANDHELD);

        itemModelGenerator.register(ModItems.DEEP_DARK_FANTASY,Models.HANDHELD);
        itemModelGenerator.register(ModItems.EXPLOSION_CREATOR,Models.HANDHELD);

        itemModelGenerator.register(ModItems.DIAMOND_PROTOTYPE,Models.GENERATED);
        itemModelGenerator.register(ModItems.ANCIENT_PROTOTYPE,Models.GENERATED);
        itemModelGenerator.register(ModItems.SUSPICIOUS_PROTOTYPE,Models.GENERATED);
        itemModelGenerator.register(ModItems.HEAVY_CORE_PROTOTYPE,Models.GENERATED);
        itemModelGenerator.register(ModItems.CONDUIT_PROTOTYPE,Models.GENERATED);
        itemModelGenerator.register(ModItems.ELYTRA_PROTOTYPE,Models.GENERATED);

        itemModelGenerator.register(ModItems.DIAMOND_SHARDS_UPGRADED_SMITHING_TEMPLATE,Models.GENERATED);
        itemModelGenerator.register(ModItems.PRESSURE_CRAFTING_TEMPLATE,Models.GENERATED);
        itemModelGenerator.register(ModItems.NETHER_SMITHING_TEMPLATE,Models.GENERATED);
        itemModelGenerator.register(ModItems.NETHER_SMITHING_TEMPLATE_PRO,Models.GENERATED);
        itemModelGenerator.register(ModItems.ELYTRA_COPY_TEMPLATE,Models.GENERATED);
        itemModelGenerator.register(ModItems.ENCHANTED_GOLDEN_APPLE_TEMPLATE,Models.GENERATED);
        itemModelGenerator.register(ModItems.HEAD_COPY_TEMPLATE,Models.GENERATED);
        itemModelGenerator.register(ModItems.TOTEM_OF_UNDYING_COPY_TEMPLATE,Models.GENERATED);

        itemModelGenerator.register(ModItems.ANGLER_POTTERY_SHERD_BLUEPRINT,Models.GENERATED);
        itemModelGenerator.register(ModItems.ARCHER_POTTERY_SHERD_BLUEPRINT,Models.GENERATED);
        itemModelGenerator.register(ModItems.ARMS_UP_POTTERY_SHERD_BLUEPRINT,Models.GENERATED);
        itemModelGenerator.register(ModItems.BLADE_POTTERY_SHERD_BLUEPRINT,Models.GENERATED);
        itemModelGenerator.register(ModItems.BREWER_POTTERY_SHERD_BLUEPRINT,Models.GENERATED);
        itemModelGenerator.register(ModItems.BURN_POTTERY_SHERD_BLUEPRINT,Models.GENERATED);
        itemModelGenerator.register(ModItems.DANGER_POTTERY_SHERD_BLUEPRINT,Models.GENERATED);
        itemModelGenerator.register(ModItems.EXPLORER_POTTERY_SHERD_BLUEPRINT,Models.GENERATED);
        itemModelGenerator.register(ModItems.FRIEND_POTTERY_SHERD_BLUEPRINT,Models.GENERATED);
        itemModelGenerator.register(ModItems.HEART_POTTERY_SHERD_BLUEPRINT,Models.GENERATED);
        itemModelGenerator.register(ModItems.HEARTBREAK_POTTERY_SHERD_BLUEPRINT,Models.GENERATED);
        itemModelGenerator.register(ModItems.HOWL_POTTERY_SHERD_BLUEPRINT,Models.GENERATED);
        itemModelGenerator.register(ModItems.MINER_POTTERY_SHERD_BLUEPRINT,Models.GENERATED);
        itemModelGenerator.register(ModItems.MOURNER_POTTERY_SHERD_BLUEPRINT,Models.GENERATED);
        itemModelGenerator.register(ModItems.PLENTY_POTTERY_SHERD_BLUEPRINT,Models.GENERATED);
        itemModelGenerator.register(ModItems.PRIZE_POTTERY_SHERD_BLUEPRINT,Models.GENERATED);
        itemModelGenerator.register(ModItems.SHEAF_POTTERY_SHERD_BLUEPRINT,Models.GENERATED);
        itemModelGenerator.register(ModItems.SHELTER_POTTERY_SHERD_BLUEPRINT,Models.GENERATED);
        itemModelGenerator.register(ModItems.SKULL_POTTERY_SHERD_BLUEPRINT,Models.GENERATED);
        itemModelGenerator.register(ModItems.SNORT_POTTERY_SHERD_BLUEPRINT,Models.GENERATED);
        itemModelGenerator.register(ModItems.FLOW_POTTERY_SHERD_BLUEPRINT,Models.GENERATED);
        itemModelGenerator.register(ModItems.GUSTER_POTTERY_SHERD_BLUEPRINT,Models.GENERATED);
        itemModelGenerator.register(ModItems.SCRAPE_POTTERY_SHERD_BLUEPRINT,Models.GENERATED);

        itemModelGenerator.register(ModItems.ANGLER_POTTERY_SHERD_PROTOTYPE,Models.GENERATED);
        itemModelGenerator.register(ModItems.ARCHER_POTTERY_SHERD_PROTOTYPE,Models.GENERATED);
        itemModelGenerator.register(ModItems.ARMS_UP_POTTERY_SHERD_PROTOTYPE,Models.GENERATED);
        itemModelGenerator.register(ModItems.BLADE_POTTERY_SHERD_PROTOTYPE,Models.GENERATED);
        itemModelGenerator.register(ModItems.BREWER_POTTERY_SHERD_PROTOTYPE,Models.GENERATED);
        itemModelGenerator.register(ModItems.BURN_POTTERY_SHERD_PROTOTYPE,Models.GENERATED);
        itemModelGenerator.register(ModItems.DANGER_POTTERY_SHERD_PROTOTYPE,Models.GENERATED);
        itemModelGenerator.register(ModItems.EXPLORER_POTTERY_SHERD_PROTOTYPE,Models.GENERATED);
        itemModelGenerator.register(ModItems.FRIEND_POTTERY_SHERD_PROTOTYPE,Models.GENERATED);
        itemModelGenerator.register(ModItems.HEART_POTTERY_SHERD_PROTOTYPE,Models.GENERATED);
        itemModelGenerator.register(ModItems.HEARTBREAK_POTTERY_SHERD_PROTOTYPE,Models.GENERATED);
        itemModelGenerator.register(ModItems.HOWL_POTTERY_SHERD_PROTOTYPE,Models.GENERATED);
        itemModelGenerator.register(ModItems.MINER_POTTERY_SHERD_PROTOTYPE,Models.GENERATED);
        itemModelGenerator.register(ModItems.MOURNER_POTTERY_SHERD_PROTOTYPE,Models.GENERATED);
        itemModelGenerator.register(ModItems.PLENTY_POTTERY_SHERD_PROTOTYPE,Models.GENERATED);
        itemModelGenerator.register(ModItems.PRIZE_POTTERY_SHERD_PROTOTYPE,Models.GENERATED);
        itemModelGenerator.register(ModItems.SHEAF_POTTERY_SHERD_PROTOTYPE,Models.GENERATED);
        itemModelGenerator.register(ModItems.SHELTER_POTTERY_SHERD_PROTOTYPE,Models.GENERATED);
        itemModelGenerator.register(ModItems.SKULL_POTTERY_SHERD_PROTOTYPE,Models.GENERATED);
        itemModelGenerator.register(ModItems.SNORT_POTTERY_SHERD_PROTOTYPE,Models.GENERATED);
        itemModelGenerator.register(ModItems.FLOW_POTTERY_SHERD_PROTOTYPE,Models.GENERATED);
        itemModelGenerator.register(ModItems.GUSTER_POTTERY_SHERD_PROTOTYPE,Models.GENERATED);
        itemModelGenerator.register(ModItems.SCRAPE_POTTERY_SHERD_PROTOTYPE,Models.GENERATED);
    }
}
