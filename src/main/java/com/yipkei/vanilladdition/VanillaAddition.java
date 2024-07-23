package com.yipkei.vanilladdition;

import com.yipkei.vanilladdition.custom.ModDispenserBehavior;
import com.yipkei.vanilladdition.init.ModBlocks;
import com.yipkei.vanilladdition.init.ModItemGroups;
import com.yipkei.vanilladdition.init.ModItems;
import com.yipkei.vanilladdition.util.ModLootTableModifiers;
import com.yipkei.vanilladdition.util.VanillaTradeModifiers;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.impl.blockrenderlayer.BlockRenderLayerMapImpl;
import net.minecraft.client.render.RenderLayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VanillaAddition implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "vanilla-addition";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);



	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerModItemGroup();

		ModLootTableModifiers.modifierLootTables();
		VanillaTradeModifiers.registerVanillaVillageTrades();

		ModDispenserBehavior.register();

		FuelRegistry.INSTANCE.add(ModBlocks.COMPRESS_WOOL, 800);

		BlockRenderLayerMapImpl blockRenderLayerMap = new BlockRenderLayerMapImpl();
		blockRenderLayerMap.putBlocks(RenderLayer.getTranslucent(), ModBlocks.ICE_SLAB, ModBlocks.ICE_STAIRS, ModBlocks.ICE_WALL);
	}
}