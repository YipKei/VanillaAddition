package com.yipkei.vanilladdition.data.generator.tag;

import com.yipkei.vanilladdition.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModEnchantmentTagProvider extends FabricTagProvider.EnchantmentTagProvider {

    public ModEnchantmentTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Enchantments.WANDER_NEARBY)
                .add(Enchantments.SWIFT_SNEAK);
    }
}
