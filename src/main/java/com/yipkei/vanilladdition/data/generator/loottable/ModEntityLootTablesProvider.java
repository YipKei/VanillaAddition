package com.yipkei.vanilladdition.data.generator.loottable;

import com.yipkei.vanilladdition.custom.FabricEntityLootTablesProvider;
import com.yipkei.vanilladdition.init.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.entity.EntityType;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.KilledByPlayerLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.EnchantedCountIncreaseLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

@Deprecated
public class ModEntityLootTablesProvider extends FabricEntityLootTablesProvider {


    public ModEntityLootTablesProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        this.register(EntityType.ENDER_DRAGON, LootTable.builder()
                .pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0f))
                        .with((LootPoolEntry.Builder<?>) ((Object) ((LeafEntry.Builder) ItemEntry
                                .builder(ModItems.DRAGON_WING_MEMBRANE)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(8.0f, 16.0f))))
                                .apply(EnchantedCountIncreaseLootFunction.builder(this.registryLookup, UniformLootNumberProvider.create(0.0f, 2.0f)))
                                .conditionally(KilledByPlayerLootCondition.builder())))));
//        配方参考
//        this.register(EntityType.ZOMBIE,
//                LootTable.builder()
//                        .pool(LootPool.builder()
//                                .rolls(ConstantLootNumberProvider.create(1.0f))
//                                .with((LootPoolEntry.Builder<?>) ((Object) ((LeafEntry.Builder) ItemEntry
//                                        .builder(Items.ROTTEN_FLESH)
//                                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0f, 2.0f))))
//                                        .apply(EnchantedCountIncreaseLootFunction.builder(this.registryLookup, UniformLootNumberProvider.create(0.0f, 1.0f))))))
//                        .pool(LootPool.builder()
//                                .rolls(ConstantLootNumberProvider.create(1.0f))
//                                .with(ItemEntry.builder(Items.IRON_INGOT))
//                                .with(ItemEntry.builder(Items.CARROT))
//                                .with((LootPoolEntry.Builder<?>) ((Object) ItemEntry
//                                        .builder(Items.POTATO)
//                                        .apply((LootFunction.Builder) ((Object) FurnaceSmeltLootFunction.builder().conditionally(this.createSmeltLootCondition())))))
//                                .conditionally(KilledByPlayerLootCondition.builder())
//                                .conditionally(RandomChanceWithEnchantedBonusLootCondition
//                                        .builder(this.registryLookup, 0.025f, 0.01f))));
//        this.register(EntityType.SKELETON,
//                LootTable.builder()
//                        .pool(LootPool.builder()
//                                .rolls(ConstantLootNumberProvider.create(1.0f))
//                                .with((LootPoolEntry.Builder<?>)((Object)((LeafEntry.Builder)ItemEntry
//                                        .builder(Items.ARROW)
//                                        .apply(SetCountLootFunction
//                                                .builder(UniformLootNumberProvider.create(0.0f, 2.0f))))
//                                        .apply(EnchantedCountIncreaseLootFunction
//                                                .builder(this.registryLookup, UniformLootNumberProvider.create(0.0f, 1.0f))))))
//                        .pool(LootPool.builder()
//                                .rolls(ConstantLootNumberProvider.create(1.0f))
//                                .with((LootPoolEntry.Builder<?>)((Object)((LeafEntry.Builder)ItemEntry
//                                        .builder(Items.BONE)
//                                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0f, 2.0f))))
//                                        .apply(EnchantedCountIncreaseLootFunction
//                                                .builder(this.registryLookup, UniformLootNumberProvider.create(0.0f, 1.0f)))))));

}

}
