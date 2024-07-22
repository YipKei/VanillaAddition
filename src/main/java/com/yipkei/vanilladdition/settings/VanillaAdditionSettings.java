package com.yipkei.vanilladdition.settings;

import com.yipkei.vanilladdition.VanillaAddition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class VanillaAdditionSettings {
    public static final Logger LOG = LoggerFactory.getLogger(VanillaAddition.MOD_ID);

    @VanillaAdditionSetting("true")
    public static boolean dragonDropsElytraTemplateAtFirstFight = true;

    @VanillaAdditionSetting("true")
    public static boolean dragonDropsWingsMembrane = true;

    @VanillaAdditionSetting("true")
    public static boolean wanderDropsAncientTears = true;

    @VanillaAdditionSetting("true")
    public static boolean wanderAffectsEnchantingTable = true;

    @VanillaAdditionSetting("true")
    public static boolean extraTallPlantFertilizable = true;

    @VanillaAdditionSetting("true")
    public static boolean netherSmithingTemplateCanFindInBastion = true;

    @VanillaAdditionSetting("true")
    public static boolean elytraTemplateCanFindInEndCity = true;

    @VanillaAdditionSetting("true")
    public static boolean ancientCityCanFindMoreTreasure = true;

    @VanillaAdditionSetting("true")
    public static boolean enableMoreTrade = true;

    @VanillaAdditionSetting("false")
    public static boolean enableWitherSkeletonSpawnOnMoreBlocks = false;

    @VanillaAdditionSetting("true")
    public static boolean enableFairyWoodPunishment = true;

    @VanillaAdditionSetting("true")
    public static boolean enableFairyWoodNormalAffectBlocks = true;

    @VanillaAdditionSetting("true")
    public static boolean enableSpawnHeads = true;
}
