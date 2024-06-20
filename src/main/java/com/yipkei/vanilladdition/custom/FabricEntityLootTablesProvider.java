package com.yipkei.vanilladdition.custom;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLootTableProvider;
import net.fabricmc.fabric.impl.datagen.loot.FabricLootTableProviderImpl;
import net.minecraft.data.DataWriter;
import net.minecraft.data.server.loottable.EntityLootTableGenerator;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.util.Identifier;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public abstract class FabricEntityLootTablesProvider extends EntityLootTableGenerator implements FabricLootTableProvider {
    private final FabricDataOutput output;
    private final CompletableFuture<RegistryWrapper.WrapperLookup> registryLookupFuture;

    protected FabricEntityLootTablesProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(FeatureFlags.FEATURE_MANAGER.getFeatureSet(), (RegistryWrapper.WrapperLookup) registryLookup);
        this.output = dataOutput;
        this.registryLookupFuture = registryLookup;
    }

    @Override
    public abstract void generate();

    @Override
    public CompletableFuture<?> run(DataWriter writer) {
        return FabricLootTableProviderImpl.run(writer, this, LootContextTypes.ENTITY, output, registryLookupFuture);
    }

    @Override
    public String getName() {
        return "Entity Loot Tables";
    }
}
