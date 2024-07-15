package com.yipkei.vanilladdition.custom;

import net.minecraft.block.entity.BannerPattern;
import net.minecraft.block.entity.BannerPatterns;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.BannerPatternsComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.text.Text;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Formatting;
import net.minecraft.util.Unit;

public class CustomBanners {
    public static ItemStack getBiliBiliBannerType1(RegistryEntryLookup<BannerPattern> bannerPatternLookup, Item defaultBanner, DyeColor patternColor, Formatting color){
        ItemStack banner = new ItemStack(defaultBanner);
        DyeColor backgroundColor = checkBackground(defaultBanner);
        BannerPatternsComponent bilibiliPattern = new BannerPatternsComponent.Builder()
                .add(bannerPatternLookup, BannerPatterns.STRIPE_DOWNLEFT,        patternColor)
                .add(bannerPatternLookup, BannerPatterns.STRIPE_DOWNRIGHT,       patternColor)
                .add(bannerPatternLookup, BannerPatterns.HALF_HORIZONTAL_BOTTOM, backgroundColor)
                .add(bannerPatternLookup, BannerPatterns.CROSS,                  patternColor)
                .add(bannerPatternLookup, BannerPatterns.STRIPE_BOTTOM,          backgroundColor)
                .add(bannerPatternLookup, BannerPatterns.CIRCLE,                 backgroundColor)
                .add(bannerPatternLookup, BannerPatterns.TRIANGLE_TOP,           backgroundColor)
                .add(bannerPatternLookup, BannerPatterns.TRIANGLE_BOTTOM,        backgroundColor)
                .add(bannerPatternLookup, BannerPatterns.STRIPE_TOP,             backgroundColor)
                .add(bannerPatternLookup, BannerPatterns.PIGLIN,                 patternColor)
                .build();
        banner.set(DataComponentTypes.BANNER_PATTERNS, bilibiliPattern);
        banner.set(DataComponentTypes.HIDE_ADDITIONAL_TOOLTIP, Unit.INSTANCE);
        banner.set(DataComponentTypes.ITEM_NAME, Text.translatable("custom_banner.bilibili").formatted(color));
        return banner;
    }

    public static ItemStack getBiliBiliBannerType2(RegistryEntryLookup<BannerPattern> bannerPatternLookup, Item defaultBanner, DyeColor patternColor, Formatting color){
        ItemStack banner = new ItemStack(defaultBanner);
        DyeColor backgroundColor = checkBackground(defaultBanner);
        BannerPatternsComponent bilibiliPattern = new BannerPatternsComponent.Builder()
                .add(bannerPatternLookup, BannerPatterns.STRIPE_DOWNLEFT,        patternColor)
                .add(bannerPatternLookup, BannerPatterns.STRIPE_DOWNRIGHT,       patternColor)
                .add(bannerPatternLookup, BannerPatterns.HALF_HORIZONTAL_BOTTOM, backgroundColor)
                .add(bannerPatternLookup, BannerPatterns.CROSS,                  patternColor)
                .add(bannerPatternLookup, BannerPatterns.STRIPE_BOTTOM,          backgroundColor)
                .add(bannerPatternLookup, BannerPatterns.CIRCLE,                 backgroundColor)
                .add(bannerPatternLookup, BannerPatterns.TRIANGLE_TOP,           backgroundColor)
                .add(bannerPatternLookup, BannerPatterns.TRIANGLE_BOTTOM,        backgroundColor)
                .add(bannerPatternLookup, BannerPatterns.STRIPE_TOP,             backgroundColor)
                .add(bannerPatternLookup, BannerPatterns.PIGLIN,                 patternColor)
                .build();
        banner.set(DataComponentTypes.BANNER_PATTERNS, bilibiliPattern);
        banner.set(DataComponentTypes.HIDE_ADDITIONAL_TOOLTIP, Unit.INSTANCE);
        banner.set(DataComponentTypes.ITEM_NAME, Text.translatable("custom_banner.bilibili").formatted(color));
        return banner;
    }


    private static DyeColor checkBackground(Item banner){
        ItemStack bannerStack = banner.getDefaultStack();
        DyeColor backgroundColor = null;
        if      (bannerStack.isOf(Items.WHITE_BANNER))       {backgroundColor = DyeColor.WHITE;}
        else if (bannerStack.isOf(Items.LIGHT_GRAY_BANNER))  {backgroundColor = DyeColor.LIGHT_GRAY;}
        else if (bannerStack.isOf(Items.GRAY_BANNER))        {backgroundColor = DyeColor.GRAY;}
        else if (bannerStack.isOf(Items.BLACK_BANNER))       {backgroundColor = DyeColor.BLACK;}
        else if (bannerStack.isOf(Items.BROWN_BANNER))       {backgroundColor = DyeColor.BROWN;}
        else if (bannerStack.isOf(Items.RED_BANNER))         {backgroundColor = DyeColor.RED;}
        else if (bannerStack.isOf(Items.ORANGE_BANNER))      {backgroundColor = DyeColor.ORANGE;}
        else if (bannerStack.isOf(Items.YELLOW_BANNER))      {backgroundColor = DyeColor.YELLOW;}
        else if (bannerStack.isOf(Items.LIME_BANNER))        {backgroundColor = DyeColor.LIME;}
        else if (bannerStack.isOf(Items.GREEN_BANNER))       {backgroundColor = DyeColor.GREEN;}
        else if (bannerStack.isOf(Items.CYAN_BANNER))        {backgroundColor = DyeColor.CYAN;}
        else if (bannerStack.isOf(Items.LIGHT_BLUE_BANNER))  {backgroundColor = DyeColor.LIGHT_BLUE;}
        else if (bannerStack.isOf(Items.BLUE_BANNER))        {backgroundColor = DyeColor.BLUE;}
        else if (bannerStack.isOf(Items.PURPLE_BANNER))      {backgroundColor = DyeColor.PURPLE;}
        else if (bannerStack.isOf(Items.MAGENTA_BANNER))     {backgroundColor = DyeColor.MAGENTA;}
        else if (bannerStack.isOf(Items.PINK_BANNER))        {backgroundColor = DyeColor.PINK;}
        return backgroundColor;
    }

}
