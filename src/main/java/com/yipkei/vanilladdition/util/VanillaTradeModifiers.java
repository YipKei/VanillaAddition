package com.yipkei.vanilladdition.util;

import com.yipkei.vanilladdition.init.ModItems;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.component.ComponentChanges;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.map.MapDecorationTypes;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.StructureTags;
import net.minecraft.util.math.random.Random;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;

public class VanillaTradeModifiers {
    public static void registerVanillaVillageTrades(){
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER,3, factories -> factories
                .add(new TradeOffers.BuyItemFactory(Items.EGG, 6, 16, 10)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER,5, factories -> factories
                .add(new TradeOffers.ProcessItemFactory(Items.APPLE, 1, 64, Items.GOLDEN_APPLE, 1, 4, 30, 0.3f)));

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FISHERMAN,4, factories -> factories
                .add(new TradeOffers.BuyItemFactory(Items.SEA_LANTERN, 4, 16, 15)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FISHERMAN, 5, factories -> factories
                .add(new TradeOffers.SellItemFactory(Items.NAUTILUS_SHELL, 10, 1, 8, 10, 0.2f)));

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 1, factories -> factories
                .add(new TradeOffers.BuyItemFactory(Items.HAY_BLOCK, 2, 16, 2, 3)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 5, factories -> factories
                .add(new TradeOffers.SellItemFactory(Items.TARGET, 4, 8, 4, 20, 0.2f)));

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FLETCHER, 3, factories -> factories
                .add(new TradeOffers.BuyItemFactory(Items.ARROW, 20, 16, 2)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FLETCHER, 5, factories -> factories
                .add(new TradeOffers.SellItemFactory(ModItems.DIAMOND_SHARD_STACK, 10, 1 , 6, 30, 0.2f)));

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.LIBRARIAN, 4, factories -> factories
                .add(new TradeOffers.BuyItemFactory(Items.CHISELED_BOOKSHELF, 1, 16, 10)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.LIBRARIAN, 5, factories -> factories
                .add(new TradeOffers.SellItemFactory(Items.TINTED_GLASS,1, 1, 12, 10)));

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 3, factories -> factories
                .add(new TradeOffers.BuyItemFactory(Items.RECOVERY_COMPASS, 1, 8, 30, 8)));
        /* 未能生效 */TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 1, factories -> {
            factories.add(new TradeOffers.SellMapFactory(8, StructureTags.ON_SWAMP_EXPLORER_MAPS, "filled_map.explorer_swamp", MapDecorationTypes.SWAMP_HUT, 12, 5));
            factories.add(new TradeOffers.SellMapFactory(8, StructureTags.ON_JUNGLE_EXPLORER_MAPS, "filled_map.explorer_jungle", MapDecorationTypes.JUNGLE_TEMPLE, 12, 5));});

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CLERIC, 4, factories -> factories
                .add(new TradeOffers.BuyItemFactory(Items.SCULK_CATALYST, 1, 16, 20, 4)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CLERIC, 5, factories -> factories
                .add(new SellOminousBottleFactory(8, 30, 16))); /* 卖不祥之瓶 */

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.ARMORER, 2, factories -> {
            factories.add(new TradeOffers.SellItemFactory(ModItems.STEEL_LEGGINGS, 10, 1, 10, 15));
            factories.add(new TradeOffers.SellItemFactory(ModItems.STEEL_BOOTS, 6, 1, 10, 15));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.ARMORER, 3, factories -> {
            factories.add(new TradeOffers.BuyItemFactory(ModItems.STEEL_INGOT, 2, 16, 10));
            factories.add(new TradeOffers.SellItemFactory(ModItems.STEEL_HELMET, 12, 1, 10, 20));
            factories.add(new TradeOffers.SellItemFactory(ModItems.STEEL_CHESTPLATE, 7, 1, 10, 20));
        });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH, 3, factories -> factories
                .add(new TradeOffers.BuyItemFactory(ModItems.STEEL_INGOT, 2, 16, 10)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH, 5, factories -> {
            factories.add(new TradeOffers.ProcessItemFactory(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, 1, 64, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, 2, 1, 30, 0.05f));
            factories.add(new TradeOffers.ProcessItemFactory(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, 1, 64, ModItems.PRESSURE_CRAFTING_TEMPLATE, 1, 1, 30, 0.05f));
        });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 3, factories -> factories
                .add(new TradeOffers.BuyItemFactory(ModItems.STEEL_INGOT, 2, 16, 10)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 5, factories -> factories
                .add(new TradeOffers.SellEnchantedToolFactory(ModItems.GLASS_PICKAXE, 10, 4, 20, 0.2f)));

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.BUTCHER, 1, factories -> {
            factories.add(new TradeOffers.BuyItemFactory(Items.SUGAR, 12, 16, 3));
            factories.add(new TradeOffers.BuyItemFactory(Items.HONEY_BOTTLE, 6, 16, 5));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.BUTCHER, 5, factories -> factories
                .add(new TradeOffers.SellItemFactory(Items.RABBIT_FOOT, 4, 1, 12, 10)));

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.LEATHERWORKER, 3, factories -> factories
                .add(new TradeOffers.BuyItemFactory(Items.ARMADILLO_SCUTE, 4, 16, 10)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.LEATHERWORKER, 5, factories -> {
            factories.add(new TradeOffers.SellItemFactory(ModItems.IRON_HORSE_ARMOR_BLUEPRINT, 28, 1, 1,30,0.2f));
            factories.add(new TradeOffers.SellItemFactory(ModItems.GOLDEN_HORSE_ARMOR_BLUEPRINT, 42, 1, 1, 30, 0.2f));
            factories.add(new TradeOffers.SellItemFactory(ModItems.DIAMOND_HORSE_ARMOR_BLUEPRINT, 64, 1, 1, 30, 0.2f));
        });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 2, factories -> {
            factories.add(new TradeOffers.BuyItemFactory(Items.DEEPSLATE, 20, 16, 10));
            factories.add(new TradeOffers.SellItemFactory(Items.NETHERRACK, 1, 4, 12, 5));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 3, factories -> {
            factories.add(new TradeOffers.BuyItemFactory(Items.TUFF, 20 ,16, 10));
            factories.add(new TradeOffers.SellItemFactory(Items.POLISHED_TUFF, 1, 4, 12 ,10));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories
                .add(new TradeOffers.SellItemFactory(Items.CALCITE, 16, 16, 20)));
    }

    public static class SellOminousBottleFactory implements TradeOffers.Factory{
        private final int maxUses;
        private final int experience;
        private final int price;
        private final float multiplier;

        public SellOminousBottleFactory(int maxUses, int experience, int price){
            this.maxUses = maxUses;
            this.experience = experience;
            this.price = price;
            this.multiplier = 0.05f;
        }

        @Override
        public TradeOffer create(Entity entity, Random random){
            int level = random.nextBetween(0,4);
            ComponentChanges componentChanges = ComponentChanges.builder().add(DataComponentTypes.OMINOUS_BOTTLE_AMPLIFIER, level).build();
            ItemStack itemStack = new ItemStack(RegistryEntry.of(Items.OMINOUS_BOTTLE), 1, componentChanges);
            return new TradeOffer(new TradedItem(Items.EMERALD, this.price), itemStack, this.maxUses, this.experience, this.multiplier);
        }
    }
}
