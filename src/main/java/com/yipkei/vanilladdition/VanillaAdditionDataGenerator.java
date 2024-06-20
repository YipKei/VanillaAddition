package com.yipkei.vanilladdition;

import com.yipkei.vanilladdition.data.generator.*;
import com.yipkei.vanilladdition.data.lang.ModEnUsLangProvider;
import com.yipkei.vanilladdition.data.lang.ModZhCnLangProvider;
import com.yipkei.vanilladdition.data.lang.ModZhHkLangProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.data.DataOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.server.loottable.LootTableProvider;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.registry.BuiltinRegistries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Util;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;

public class VanillaAdditionDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack =fabricDataGenerator.createPack();


		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModModelsProvider::new);
		pack.addProvider(ModBlockLootTablesProvider::new);
//		pack.addProvider(ModEntityLootTablesProvider::new);
		pack.addProvider(ModRecipesProvider::new);
		pack.addProvider(ModEnUsLangProvider::new);
		pack.addProvider(ModZhCnLangProvider::new);
		pack.addProvider(ModZhHkLangProvider::new);

	}

}
