package com.yipkei.vanilladdition.data.generator;

import com.yipkei.vanilladdition.init.ModItems;
import com.yipkei.vanilladdition.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.BEACON_PAYMENT_ITEMS)
                .add(ModItems.STEEL_INGOT);

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.STEEL_SWORD)
               /*.add(ModItems.BONE_SWORD)*/;

        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.STEEL_SHOVEL);

        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.STEEL_PICKAXE)
                .add(ModItems.DIAMOND_UPGRADED_PICKAXE)
                .add(ModItems.GLASS_PICKAXE)
                .add(ModItems.DESTROYER_PICKAXE)
        ;

        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.STEEL_AXE)
                .add(ModItems.DIAMOND_UPGRADED_AXE);

        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.STEEL_HOE);

        getOrCreateTagBuilder(ModTags.Items.STEEL_TOOLS)
                .add(ModItems.STEEL_SWORD)
                .add(ModItems.STEEL_SHOVEL)
                .add(ModItems.STEEL_PICKAXE)
                .add(ModItems.STEEL_AXE)
                .add(ModItems.STEEL_HOE);

        getOrCreateTagBuilder(ModTags.Items.DIAMOND_LIKE_SHARDS)
                .add(ModItems.DIAMOND_SHARD);

        getOrCreateTagBuilder(ModTags.Items.DIAMOND_LIKE_INGREDIENTS)
                .add(Items.DIAMOND);

        getOrCreateTagBuilder(ModTags.Items.QUARTZ_BLOCK)
                .add(Items.QUARTZ_BLOCK)
                .add(Items.CHISELED_QUARTZ_BLOCK)
                .add(Items.SMOOTH_QUARTZ)
                .add(Items.QUARTZ_BRICKS)
                .add(Items.QUARTZ_PILLAR);
    }
}
