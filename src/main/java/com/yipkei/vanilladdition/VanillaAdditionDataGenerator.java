package com.yipkei.vanilladdition;

import com.yipkei.vanilladdition.data.generator.*;
import com.yipkei.vanilladdition.data.lang.ModEnUsLangProvider;
import com.yipkei.vanilladdition.data.lang.ModZhCnLangProvider;
import com.yipkei.vanilladdition.data.lang.ModZhHkLangProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class VanillaAdditionDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack =fabricDataGenerator.createPack();

		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModModelsProvider::new);
		pack.addProvider(ModLootTablesProvider::new);
		pack.addProvider(ModRecipesProvider::new);
		pack.addProvider(ModEnUsLangProvider::new);
		pack.addProvider(ModZhCnLangProvider::new);
		pack.addProvider(ModZhHkLangProvider::new);
	}
}
