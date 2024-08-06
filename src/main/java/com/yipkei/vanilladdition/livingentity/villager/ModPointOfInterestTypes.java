package com.yipkei.vanilladdition.livingentity.villager;

import com.yipkei.vanilladdition.VanillaAddition;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.poi.PointOfInterestType;

public class ModPointOfInterestTypes {
    public static final RegistryKey<PointOfInterestType> VAULT_TRADER_POI = of("vault_trader_poi");

    private static RegistryKey<PointOfInterestType> of(String id){
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, Identifier.of(VanillaAddition.MOD_ID, id));
    }

    public static void registerModPointOfInterestType(){}
}
