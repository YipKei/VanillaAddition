package com.yipkei.vanilladdition.util;

import com.yipkei.vanilladdition.custom.CustomBanners;
import com.yipkei.vanilladdition.init.ModBlocks;
import com.yipkei.vanilladdition.init.ModItems;
import com.yipkei.vanilladdition.livingentity.villager.ModVillagers;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.component.ComponentChanges;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.random.Random;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

import static com.yipkei.vanilladdition.settings.VanillaAdditionSettings.enableMoreTrade;

public class VanillaTradeModifiers {
    public static void registerVanillaVillageTrades(){
        if (!enableMoreTrade){
            return;
        }
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER,3, factories -> factories
                .add(new TradeOffers.BuyItemFactory(Items.EGG, 6, 16, 10)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER,5, factories -> factories
                .add(new TradeOffers.ProcessItemFactory(Items.APPLE, 1, 64, Items.GOLDEN_APPLE, 1, 4, 30, 0.3f)));

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FISHERMAN,4, factories -> factories
                .add(new TradeOffers.BuyItemFactory(Items.SEA_LANTERN, 4, 16, 15)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FISHERMAN, 5, factories -> factories
                .add(new TradeOffers.SellItemFactory(Items.NAUTILUS_SHELL, 10, 1, 3, 10, 0.2f)));

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 1, factories -> factories
                .add(new TradeOffers.BuyItemFactory(Items.HAY_BLOCK, 3, 16, 2, 2)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 5, factories -> factories
                .add(new TradeOffers.SellItemFactory(Items.TARGET, 4, 1, 8, 20, 0.2f)));

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
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 5, factories -> {
            factories.add(new SellBiliBiliBannerFactory(Items.LIGHT_BLUE_BANNER, DyeColor.WHITE, Formatting.WHITE, 4, 30, 8));
            factories.add(new SellBiliBiliBannerFactory(Items.PINK_BANNER, DyeColor.WHITE, Formatting.WHITE, 4, 30, 8));
            factories.add(new SellBiliBiliBannerFactory(Items.WHITE_BANNER, DyeColor.LIGHT_BLUE, Formatting.WHITE, 4, 30, 8));
            factories.add(new SellBiliBiliBannerFactory(Items.WHITE_BANNER, DyeColor.PINK, Formatting.WHITE, 4, 30, 8));
        });

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
            factories.add(new TradeOffers.SellItemFactory(ModItems.STEEL_HELMET, 7, 1, 10, 20));
            factories.add(new TradeOffers.SellItemFactory(ModItems.STEEL_CHESTPLATE, 12, 1, 10, 20));
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
                .add(new SellSelectEnchantedTools(ModItems.GLASS_PICKAXE, 4, 10, 15, 0.4f, Enchantments.UNBREAKING)));

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


        TradeOfferHelper.registerVillagerOffers(ModVillagers.VAULT_TRADER, 1, factories -> {
            factories.add(new ProcessBlindBoxFactory(Blocks.STONE, 64, Items.TRIAL_KEY, 1, new ItemStack(ModBlocks.STONE_BLIND_BOX),8, 1));
            factories.add(new ProcessBlindBoxFactory(Blocks.STONE, 64, Items.OMINOUS_TRIAL_KEY, 1, new ItemStack(ModBlocks.OMINOUS_STONE_BLIND_BOX),8, 1));
            factories.add(new ProcessBlindBoxFactory(Blocks.COAL_BLOCK, 16, Items.TRIAL_KEY, 1, new ItemStack(ModBlocks.COAL_BLIND_BOX),8, 1));
            factories.add(new ProcessBlindBoxFactory(Blocks.COAL_BLOCK, 16, Items.OMINOUS_TRIAL_KEY, 1, new ItemStack(ModBlocks.OMINOUS_COAL_BLIND_BOX),8, 1));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.VAULT_TRADER, 2, factories -> {
            factories.add(new ProcessBlindBoxFactory(Blocks.COPPER_BLOCK, 16, Items.TRIAL_KEY, 4, new ItemStack(ModBlocks.COPPER_BLIND_BOX), 6, 2));
            factories.add(new ProcessBlindBoxFactory(Blocks.COPPER_BLOCK, 16, Items.OMINOUS_TRIAL_KEY, 4, new ItemStack(ModBlocks.OMINOUS_COPPER_BLIND_BOX), 6, 2));
            factories.add(new ProcessBlindBoxFactory(Blocks.IRON_BLOCK, 16, Items.TRIAL_KEY, 4, new ItemStack(ModBlocks.IRON_BLIND_BOX), 6, 2));
            factories.add(new ProcessBlindBoxFactory(Blocks.IRON_BLOCK, 16, Items.OMINOUS_TRIAL_KEY, 4, new ItemStack(ModBlocks.OMINOUS_IRON_BLIND_BOX), 6, 2));
            factories.add(new ProcessBlindBoxFactory(Blocks.GOLD_BLOCK, 16, Items.TRIAL_KEY, 4, new ItemStack(ModBlocks.GOLDEN_BLIND_BOX), 6, 2));
            factories.add(new ProcessBlindBoxFactory(Blocks.GOLD_BLOCK, 16, Items.OMINOUS_TRIAL_KEY, 4, new ItemStack(ModBlocks.OMINOUS_GOLDEN_BLIND_BOX), 6, 2));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.VAULT_TRADER, 3, factories -> {
            factories.add(new ProcessBlindBoxFactory(Blocks.EMERALD_BLOCK, 4, Items.TRIAL_KEY, 7, new ItemStack(ModBlocks.EMERALD_BLIND_BOX), 4, 3));
            factories.add(new ProcessBlindBoxFactory(Blocks.EMERALD_BLOCK, 4, Items.OMINOUS_TRIAL_KEY, 7, new ItemStack(ModBlocks.OMINOUS_EMERALD_BLIND_BOX), 4, 3));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.VAULT_TRADER, 4, factories -> {
            factories.add(new ProcessBlindBoxFactory(Blocks.DIAMOND_BLOCK, 1, Items.TRIAL_KEY, 7, new ItemStack(ModBlocks.DIAMOND_BLIND_BOX), 3, 4));
            factories.add(new ProcessBlindBoxFactory(Blocks.DIAMOND_BLOCK, 1, Items.OMINOUS_TRIAL_KEY, 7, new ItemStack(ModBlocks.OMINOUS_DIAMOND_BLIND_BOX), 3, 4));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.VAULT_TRADER, 5, factories -> {
            factories.add(new ProcessBlindBoxFactory(Blocks.NETHERITE_BLOCK, 1, Items.TRIAL_KEY, 10, new ItemStack(ModBlocks.NETHERITE_BLIND_BOX), 2, 5));
            factories.add(new ProcessBlindBoxFactory(Blocks.NETHERITE_BLOCK, 1, Items.OMINOUS_TRIAL_KEY, 10, new ItemStack(ModBlocks.OMINOUS_NETHERITE_BLIND_BOX), 2, 5));
        });

    }

    public static class SellSelectEnchantedTools implements TradeOffers.Factory{
        private final ItemStack tool;
        private final int maxUses;
        private final int experience;
        private final int basePrice;
        private final float range;
        private final float multiplier;
        private final RegistryKey<Enchantment> enchantmentKey;

        public SellSelectEnchantedTools(Item item, int maxUses, int experience, int price, float range, RegistryKey<Enchantment> enchantmentKey){
            this.tool = new ItemStack(item);
            this.maxUses = maxUses;
            this.experience = experience;
            this.basePrice = price;
            this.range = range;
            this.multiplier = 0.2f;
            this.enchantmentKey = enchantmentKey;
        }

        @Nullable
        @Override
        public TradeOffer create(Entity entity, Random random) {
            World world = entity.getWorld();
            int randomLevel = world.random.nextInt(3);
            int price = basePrice + world.random.nextInt((int) (this.basePrice * this.range * (randomLevel + 1)));
            this.tool.addEnchantment(world.getRegistryManager().get(RegistryKeys.ENCHANTMENT).getEntry(enchantmentKey).get(),randomLevel+1);
            return new TradeOffer(new TradedItem(Items.EMERALD, price), tool, maxUses, experience, multiplier);
        }
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

    public static class SellBiliBiliBannerFactory implements TradeOffers.Factory{
        private final int maxUses;
        private final int experience;
        private final int price;
        private final float multiplier;
        private final DyeColor patternColor;
        private final Item defaultBanner;
        private final Formatting formatting;

        public SellBiliBiliBannerFactory(Item banner, DyeColor patternColor, Formatting formatting, int maxUses, int experience, int price){
            this.defaultBanner = banner;
            this.patternColor = patternColor;
            this.formatting = formatting;
            this.maxUses = maxUses;
            this.experience = experience;
            this.price = price;
            this.multiplier = 0.05f;
        }

        @Override
        public TradeOffer create(Entity entity, Random random) {
            return new TradeOffer(new TradedItem(Items.EMERALD, this.price),
                    Optional.of(new TradedItem(this.defaultBanner)),
                    CustomBanners.getBiliBiliBannerType1(entity.getRegistryManager().getWrapperOrThrow(RegistryKeys.BANNER_PATTERN), this.defaultBanner, this.patternColor, this.formatting), this.maxUses, this.experience, this.multiplier);
        }
    }

    public static class ProcessBlindBoxFactory implements TradeOffers.Factory{
        private final int maxUses;
        private final int experience;
        private final float multiplier;
        private final int sourceBlockCount;
        private final Block sourceBlock;
        private final int keyCount;
        private final Item keyType;
        private final ItemStack result;

        public ProcessBlindBoxFactory(Block sourceBlock, int sourceBlockCount, ItemConvertible keyType, int keyCount, ItemStack result, int maxUses, int experience){
            this.sourceBlock = sourceBlock;
            this.sourceBlockCount = sourceBlockCount;
            this.keyType = keyType.asItem();
            this.keyCount = keyCount;
            this.result = result;
            this.maxUses = maxUses;
            this.experience = experience;
            this.multiplier = 0.0f;
        }

        @Override
        public TradeOffer create(Entity entity, Random random) {
            return new TradeOffer(new TradedItem(this.keyType, this.keyCount), Optional.of(new TradedItem(this.sourceBlock, this.sourceBlockCount)), result, 0 ,this.maxUses, this.experience, this.multiplier);
        }
    }
}
