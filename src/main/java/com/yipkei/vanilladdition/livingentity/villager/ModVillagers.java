package com.yipkei.vanilladdition.livingentity.villager;

import com.google.common.collect.ImmutableSet;
import com.yipkei.vanilladdition.VanillaAddition;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;
import org.jetbrains.annotations.Nullable;

public class ModVillagers {
    public static final VillagerProfession VAULT_TRADER = register("vault_trader", ModPointOfInterestTypes.VAULT_TRADER_POI, SoundEvents.ENTITY_VILLAGER_WORK_FISHERMAN);

    public static final PointOfInterestType VAULT_TRADER_POI = registerPointOfInterestType("vault_trader_poi", Blocks.VAULT);

    private static VillagerProfession register(String id, RegistryKey<PointOfInterestType> heldWorkstation, @Nullable SoundEvent workSound) {
        return Registry.register(Registries.VILLAGER_PROFESSION, Identifier.of(VanillaAddition.MOD_ID, id),
                new VillagerProfession(id, pointOfInterestTypeRegistryEntry -> pointOfInterestTypeRegistryEntry.matchesKey(heldWorkstation), pointOfInterestTypeRegistryEntry -> pointOfInterestTypeRegistryEntry.matchesKey(heldWorkstation), ImmutableSet.of(), ImmutableSet.of(),workSound));
    }

    private static PointOfInterestType registerPointOfInterestType(String id, Block block){
        return PointOfInterestHelper.register(Identifier.of(VanillaAddition.MOD_ID, id), 1, 1, block);
    }

    public static void registerModVillagers(){}
}
