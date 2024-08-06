package com.yipkei.vanilladdition.helper;

import com.yipkei.vanilladdition.data.generator.recipe.StackableShapedRecipeJsonBuilder;
import com.yipkei.vanilladdition.data.generator.recipe.StackableTransformRecipeJsonBuilder;
import com.yipkei.vanilladdition.init.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.List;

import static com.yipkei.vanilladdition.VanillaAddition.MOD_ID;
import static com.yipkei.vanilladdition.helper.PathHelper.getItemFromName;
import static com.yipkei.vanilladdition.helper.PathHelper.pathChange;
import static net.minecraft.data.server.recipe.RecipeProvider.*;

public abstract class ModCustomRecipeHelper {

    public static void offerReversible2x2CompactingRecipes(RecipeExporter exporter,RecipeCategory category,ItemConvertible input,ItemConvertible output){
        ShapedRecipeJsonBuilder.create(category, output,1)
                .pattern("##")
                .pattern("##")
                .input('#',input)
                .criterion(hasItem(input),conditionsFromItem(input))
                .offerTo(exporter,Identifier.of(MOD_ID,RecipeProvider.convertBetween(output,input)));
        ShapelessRecipeJsonBuilder.create(category, input, 4)
                .input(output)
                .criterion(hasItem(output),conditionsFromItem(output))
                .offerTo(exporter,Identifier.of(MOD_ID,RecipeProvider.convertBetween(input,output)));
    }

    public static void offerSwordRecipe(RecipeExporter exporter, ItemConvertible mainInput, ItemConvertible minorInput, ItemConvertible output, String type){
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output,1)
                .pattern("#")
                .pattern("#")
                .pattern("*")
                .input('#',mainInput)
                .input('*',minorInput)
                .criterion(hasItem(mainInput),conditionsFromItem(mainInput))
                .criterion(hasItem(minorInput),conditionsFromItem(minorInput))
                .offerTo(exporter,Identifier.of(MOD_ID,type + "_sword"));
    }

    public static void offerEnchantedSwordRecipe(RecipeExporter exporter, ItemConvertible mainInput, ItemConvertible minorInput, ItemConvertible output, RegistryEntry<Enchantment> enchantment, int level, String type){
        ItemStack result = new ItemStack(output);
        result.addEnchantment(enchantment, level);
        StackableShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, result)
                .pattern("#")
                .pattern("#")
                .pattern("*")
                .input('#',mainInput)
                .input('*',minorInput)
                .criterion(hasItem(mainInput),conditionsFromItem(mainInput))
                .criterion(hasItem(minorInput),conditionsFromItem(minorInput))
                .offerTo(exporter,Identifier.of(MOD_ID,type + "_sword"));
    }

    public static void offerShovelRecipe(RecipeExporter exporter,ItemConvertible mainInput, ItemConvertible minorInput, ItemConvertible output, String type){
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output,1)
                .pattern("#")
                .pattern("*")
                .pattern("*")
                .input('#',mainInput)
                .input('*',minorInput)
                .criterion(hasItem(mainInput),conditionsFromItem(mainInput))
                .criterion(hasItem(minorInput),conditionsFromItem(minorInput))
                .offerTo(exporter,Identifier.of(MOD_ID,type + "_shovel"));
    }

    public static void offerEnchantedShovelRecipe(RecipeExporter exporter, ItemConvertible mainInput, ItemConvertible minorInput, ItemConvertible output, RegistryEntry<Enchantment> enchantment, int level, String type){
        ItemStack result = new ItemStack(output);
        result.addEnchantment(enchantment, level);
        StackableShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, result)
                .pattern("#")
                .pattern("*")
                .pattern("*")
                .input('#',mainInput)
                .input('*',minorInput)
                .criterion(hasItem(mainInput),conditionsFromItem(mainInput))
                .criterion(hasItem(minorInput),conditionsFromItem(minorInput))
                .offerTo(exporter,Identifier.of(MOD_ID,type + "_shovel"));
    }

    public static void offerPickaxeRecipe(RecipeExporter exporter,ItemConvertible mainInput,ItemConvertible minorInput,ItemConvertible output,String type){
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output,1)
                .pattern("###")
                .pattern(" * ")
                .pattern(" * ")
                .input('#',mainInput)
                .input('*',minorInput)
                .criterion(hasItem(mainInput),conditionsFromItem(mainInput))
                .criterion(hasItem(minorInput),conditionsFromItem(minorInput))
                .offerTo(exporter,Identifier.of(MOD_ID,type + "_pickaxe"));
    }

    public static void offerEnchantedPickaxeRecipe(RecipeExporter exporter, ItemConvertible mainInput, ItemConvertible minorInput, ItemConvertible output, RegistryEntry<Enchantment> enchantment, int level, String type){
        ItemStack result = new ItemStack(output);
        result.addEnchantment(enchantment, level);
        StackableShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, result)
                .pattern("###")
                .pattern(" * ")
                .pattern(" * ")
                .input('#',mainInput)
                .input('*',minorInput)
                .criterion(hasItem(mainInput),conditionsFromItem(mainInput))
                .criterion(hasItem(minorInput),conditionsFromItem(minorInput))
                .offerTo(exporter,Identifier.of(MOD_ID,type + "_pickaxe"));
    }

    public static void offerAxeRecipe(RecipeExporter exporter,ItemConvertible mainInput,ItemConvertible minorInput,ItemConvertible output,String type){
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output,1)
                .pattern("##")
                .pattern("#*")
                .pattern(" *")
                .input('#',mainInput)
                .input('*',minorInput)
                .criterion(hasItem(mainInput),conditionsFromItem(mainInput))
                .criterion(hasItem(minorInput),conditionsFromItem(minorInput))
                .offerTo(exporter,Identifier.of(MOD_ID,type + "_axe"));
    }

    public static void offerEnchantedAxeRecipe(RecipeExporter exporter, ItemConvertible mainInput, ItemConvertible minorInput, ItemConvertible output, RegistryEntry<Enchantment> enchantment, int level, String type){
        ItemStack result = new ItemStack(output);
        result.addEnchantment(enchantment, level);
        StackableShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, result)
                .pattern("##")
                .pattern("#*")
                .pattern(" *")
                .input('#',mainInput)
                .input('*',minorInput)
                .criterion(hasItem(mainInput),conditionsFromItem(mainInput))
                .criterion(hasItem(minorInput),conditionsFromItem(minorInput))
                .offerTo(exporter,Identifier.of(MOD_ID,type + "_axe"));
    }

    public static void offerHoeRecipe(RecipeExporter exporter,ItemConvertible mainInput,ItemConvertible minorInput,ItemConvertible output,String type){
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output,1)
                .pattern("##")
                .pattern(" *")
                .pattern(" *")
                .input('#',mainInput)
                .input('*',minorInput)
                .criterion(hasItem(mainInput),conditionsFromItem(mainInput))
                .criterion(hasItem(minorInput),conditionsFromItem(minorInput))
                .offerTo(exporter,Identifier.of(MOD_ID,type + "_hoe"));
    }

    public static void offerEnchantedHoeRecipe(RecipeExporter exporter, ItemConvertible mainInput, ItemConvertible minorInput, ItemConvertible output, RegistryEntry<Enchantment> enchantment, int level, String type){
        ItemStack result = new ItemStack(output);
        result.addEnchantment(enchantment, level);
        StackableShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, result)
                .pattern("##")
                .pattern(" *")
                .pattern(" *")
                .input('#',mainInput)
                .input('*',minorInput)
                .criterion(hasItem(mainInput),conditionsFromItem(mainInput))
                .criterion(hasItem(minorInput),conditionsFromItem(minorInput))
                .offerTo(exporter,Identifier.of(MOD_ID,type + "_hoe"));
    }

    public static void offerHelmetRecipe(RecipeExporter exporter, ItemConvertible material, ItemConvertible output, String type){
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output,1)
                .pattern("###")
                .pattern("# #")
                .input('#',material)
                .criterion(hasItem(material),conditionsFromItem(material))
                .offerTo(exporter,Identifier.of(MOD_ID,type + "_helmet"));
    }

    public static void offerEnchantedHelmetRecipe(RecipeExporter exporter, ItemConvertible material, ItemConvertible output, RegistryEntry<Enchantment> enchantment, int level, String type){
        ItemStack result = new ItemStack(output);
        result.addEnchantment(enchantment, level);
        StackableShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output,1)
                .pattern("###")
                .pattern("# #")
                .input('#',material)
                .criterion(hasItem(material),conditionsFromItem(material))
                .offerTo(exporter,Identifier.of(MOD_ID,type + "_helmet"));
    }

    public static void offerChestplateRecipe(RecipeExporter exporter, ItemConvertible material, ItemConvertible output, String type){
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output,1)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .input('#',material)
                .criterion(hasItem(material),conditionsFromItem(material))
                .offerTo(exporter,Identifier.of(MOD_ID,type + "_chestplate"));
    }

    public static void offerEnchantedChestplateRecipe(RecipeExporter exporter, ItemConvertible material, ItemConvertible output, RegistryEntry<Enchantment> enchantment, int level, String type){
        ItemStack result = new ItemStack(output);
        result.addEnchantment(enchantment, level);
        StackableShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output,1)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .input('#',material)
                .criterion(hasItem(material),conditionsFromItem(material))
                .offerTo(exporter,Identifier.of(MOD_ID,type + "_chestplate"));
    }

    public static void offerLeggingsRecipe(RecipeExporter exporter, ItemConvertible material, ItemConvertible output, String type){
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output,1)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .input('#',material)
                .criterion(hasItem(material),conditionsFromItem(material))
                .offerTo(exporter,Identifier.of(MOD_ID,type + "_leggings"));
    }

    public static void offerEnchantedLeggingsRecipe(RecipeExporter exporter, ItemConvertible material, ItemConvertible output, RegistryEntry<Enchantment> enchantment, int level, String type){
        ItemStack result = new ItemStack(output);
        result.addEnchantment(enchantment, level);
        StackableShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output,1)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .input('#',material)
                .criterion(hasItem(material),conditionsFromItem(material))
                .offerTo(exporter,Identifier.of(MOD_ID,type + "_leggings"));
    }

    public static void offerBootsRecipe(RecipeExporter exporter, ItemConvertible material, ItemConvertible output, String type){
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output,1)
                .pattern("# #")
                .pattern("# #")
                .input('#',material)
                .criterion(hasItem(material),conditionsFromItem(material))
                .offerTo(exporter,Identifier.of(MOD_ID,type + "_boots"));
    }

    public static void offerEnchantedBootsRecipe(RecipeExporter exporter, ItemConvertible material, ItemConvertible output, RegistryEntry<Enchantment> enchantment, int level, String type){
        ItemStack result = new ItemStack(output);
        result.addEnchantment(enchantment, level);
        StackableShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output,1)
                .pattern("# #")
                .pattern("# #")
                .input('#',material)
                .criterion(hasItem(material),conditionsFromItem(material))
                .offerTo(exporter,Identifier.of(MOD_ID,type + "_boots"));
    }

    public static void offerArmorRecipe(RecipeExporter exporter, ItemConvertible material, String type){
        Item helmet = getItemFromName(type + "_helmet");
        Item chestplate = getItemFromName(type + "_chestplate");
        Item leggings = getItemFromName(type + "_leggings");
        Item boots = getItemFromName(type + "_boots");
        offerHelmetRecipe(exporter, material, helmet, type);
        offerChestplateRecipe(exporter, material, chestplate, type);
        offerLeggingsRecipe(exporter, material, leggings, type);
        offerBootsRecipe(exporter, material, boots, type);
    }

    public static void offerEnchantedArmorRecipe(RecipeExporter exporter, ItemConvertible material, RegistryEntry<Enchantment> enchantment, int level, String type){
        Item helmet = getItemFromName(type + "_helmet");
        Item chestplate = getItemFromName(type + "_chestplate");
        Item leggings = getItemFromName(type + "_leggings");
        Item boots = getItemFromName(type + "_boots");
        offerEnchantedHelmetRecipe(exporter, material, helmet, enchantment, level, type);
        offerEnchantedChestplateRecipe(exporter, material, chestplate, enchantment, level, type);
        offerEnchantedLeggingsRecipe(exporter, material, leggings, enchantment, level, type);
        offerEnchantedBootsRecipe(exporter, material, boots, enchantment, level, type);
    }

    public static void offerToolRecipe(RecipeExporter exporter, ItemConvertible material, ItemConvertible hand, String type){
        Item sword = getItemFromName(type + "_sword");
        Item shovel = getItemFromName(type + "_shovel");
        Item pickaxe = getItemFromName(type + "_pickaxe");
        Item axe = getItemFromName(type + "_axe");
        Item hoe = getItemFromName(type + "_hoe");
        offerSwordRecipe(exporter, material, hand, sword, type);
        offerShovelRecipe(exporter, material, hand, shovel, type);
        offerPickaxeRecipe(exporter, material, hand, pickaxe, type);
        offerAxeRecipe(exporter, material, hand, axe, type);
        offerHoeRecipe(exporter, material, hand, hoe, type);
    }

    public static void offerEnchantedToolRecipe(RecipeExporter exporter, ItemConvertible material, ItemConvertible hand, RegistryEntry<Enchantment> enchantment, int level, String type){
        Item sword = getItemFromName(type + "_sword");
        Item shovel = getItemFromName(type + "_shovel");
        Item pickaxe = getItemFromName(type + "_pickaxe");
        Item axe = getItemFromName(type + "_axe");
        Item hoe = getItemFromName(type + "_hoe");
        offerEnchantedSwordRecipe(exporter, material, hand, sword, enchantment, level, type);
        offerEnchantedShovelRecipe(exporter, material, hand, shovel, enchantment, level, type);
        offerEnchantedPickaxeRecipe(exporter, material, hand, pickaxe, enchantment, level, type);
        offerEnchantedAxeRecipe(exporter, material, hand, axe, enchantment, level, type);
        offerEnchantedHoeRecipe(exporter, material, hand, hoe, enchantment, level, type);
    }

    public static void offerUpgradeRecipe(RecipeExporter exporter, Item smithingTemplate, Item input, Item ingredient, RecipeCategory category, Item result){
        offerUpgradeRecipe(exporter, smithingTemplate, input, ingredient, category, result, 1);
    }

    public static void offerUpgradeRecipe(RecipeExporter exporter, Item smithingTemplate, Item input, Item ingredient, RecipeCategory category, Item result, int resultCount){
        offerUpgradeRecipe(exporter, smithingTemplate, input, ingredient, category, result, resultCount, 0);
    }

    public static void offerUpgradeRecipe(RecipeExporter exporter, Item smithingTemplate, Item input, Item ingredient, RecipeCategory category, Item result, int resultCount, int damage){
        ItemStack resultStack = new ItemStack(result, resultCount);
        if (resultStack.isDamageable()) resultStack.setDamage(damage);
        offerUpgradeRecipe(exporter, smithingTemplate, input, ingredient, category, resultStack);
    }

    public static void offerEnchantedUpgradeRecipe(RecipeExporter exporter, Item smithingTemplate, Item input, Item ingredient, RecipeCategory category, Item result, RegistryEntry<Enchantment> enchantment, int level){
        offerEnchantedUpgradeRecipe(exporter, smithingTemplate, input, ingredient, category, result, enchantment, level, 0);
    }

    public static void offerEnchantedUpgradeRecipe(RecipeExporter exporter, Item smithingTemplate, Item input, Item ingredient, RecipeCategory category, Item result, RegistryEntry<Enchantment> enchantment, int level, int damage){
        ItemStack resultStack = new ItemStack(result);
        if (resultStack.isDamageable()) resultStack.setDamage(damage);
        resultStack.addEnchantment(enchantment,level);
        offerUpgradeRecipe(exporter, smithingTemplate, input, ingredient, category, resultStack);
    }

    public static void offerUpgradeRecipe(RecipeExporter exporter, Item smithingTemplate, Item input, Item ingredient, RecipeCategory category, ItemStack resultStack){
        StackableTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(smithingTemplate),
                        Ingredient.ofItems(input),
                        Ingredient.ofItems(ingredient),
                        category,
                        resultStack)
                .criterion(hasItem(smithingTemplate), RecipeProvider
                        .conditionsFromItem(smithingTemplate))
                .offerTo(exporter, Identifier.of(MOD_ID,RecipeProvider.getItemPath(resultStack.getItem()) + "_smithing_from_" + RecipeProvider.getItemPath(input) + "_and_" + RecipeProvider.getItemPath(ingredient)));
    }

    public static void offerCookingDefault(RecipeExporter exporter, int baseCookingTime, ItemConvertible input, ItemConvertible output, float experience){
        offerFoodCookingRecipe(exporter,"smelting", RecipeSerializer.SMELTING, SmeltingRecipe::new,baseCookingTime,input,output,experience);
        offerFoodCookingRecipe(exporter,"smoking",RecipeSerializer.SMOKING, SmokingRecipe::new,baseCookingTime/2,input,output,experience);
        offerFoodCookingRecipe(exporter,"campfire_cooking",RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new,baseCookingTime*3,input,output,experience);
    }

    public static void offerMetalSmeltingDefault(RecipeExporter exporter, List<ItemConvertible> input, ItemConvertible output, float experience, int baseSmeltingTime, String group){
        offerSmelting(exporter,input,RecipeCategory.MISC,output,experience,baseSmeltingTime,group);
        offerBlasting(exporter,input,RecipeCategory.MISC,output,experience,baseSmeltingTime/2,group);
    }

    public static void offerMetalSmeltingDefault(RecipeExporter exporter, ItemConvertible input, ItemConvertible output, float experience, int baseSmeltingTime, String group){
        List<ItemConvertible> inputList = List.of(input);
        offerSmelting(exporter,inputList,RecipeCategory.MISC,output,experience,baseSmeltingTime,group);
        offerBlasting(exporter,inputList,RecipeCategory.MISC,output,experience,baseSmeltingTime/2,group);
    }

    public static void offerHammerProcessing(RecipeExporter exporter,ItemConvertible input,ItemConvertible hammer,Item result, int mutipilier, String type){
        String hammerType = "";
        if (hammer.equals(ModItems.STONE_HAMMER)) {
            hammerType = "stone_hammer";
        } else if (hammer.equals(ModItems.IRON_HAMMER)) {
            hammerType = "iron_hammer";
        } else if (hammer.equals(ModItems.DIAMOND_HAMMER)) {
            hammerType = "diamond_hammer";
        }

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, result, mutipilier)
                .input(input)
                .input(hammer)
                .group("hammer_"+type)
                .criterion(hasItem(input),conditionsFromItem(hammer))
                .criterion(hasItem(hammer),conditionsFromItem(hammer))
                .offerTo(exporter, Identifier.of(MOD_ID, RecipeProvider.getItemPath(input) + "_" + type + "_by_" + RecipeProvider.getItemPath(hammer)));
    }

    public static void offerHammerProcessing(RecipeExporter exporter, TagKey<Item> input, ItemConvertible hammer, Item result, int mutipilier, String type){
        String hammerType = "";
        if (hammer.equals(ModItems.STONE_HAMMER)) {
            hammerType = "stone_hammer";
        } else if (hammer.equals(ModItems.IRON_HAMMER)) {
            hammerType = "iron_hammer";
        } else if (hammer.equals(ModItems.DIAMOND_HAMMER)) {
            hammerType = "diamond_hammer";
        }

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, result, mutipilier)
                .input(input)
                .input(hammer)
                .group("hammer_"+type)
                .criterion(hasItem(hammer),conditionsFromItem(hammer))
                .offerTo(exporter, Identifier.of(MOD_ID, input.id().getPath() + "_" + type + "_by_" + RecipeProvider.getItemPath(hammer)));
    }

    public static void offerTorchLikeRecipe(RecipeExporter exporter,RecipeCategory category,ItemConvertible inputAbove,ItemConvertible inputBelow,Item result,int count,String path){
        ShapedRecipeJsonBuilder.create(category, result,count)
                .pattern("#")
                .pattern("*")
                .input('#',inputAbove)
                .input('*',inputBelow)
                .criterion(hasItem(inputAbove),conditionsFromItem(inputAbove))
                .criterion(hasItem(inputBelow),conditionsFromItem(inputBelow))
                .offerTo(exporter,Identifier.of(MOD_ID,path));
    }

    public static void offerTorchLikeRecipe(RecipeExporter exporter, RecipeCategory category, TagKey<Item> tagKey, ItemConvertible inputBelow, Item result, int count, String path){
        ShapedRecipeJsonBuilder.create(category, result,count)
                .pattern("#")
                .pattern("*")
                .input('#',tagKey)
                .input('*',inputBelow)
                .criterion(hasItem(inputBelow),conditionsFromItem(inputBelow))
                .offerTo(exporter,Identifier.of(MOD_ID,path));
    }

    public static void offerChestLikeRecipe(RecipeExporter exporter, RecipeCategory category, ItemConvertible baseInput, ItemConvertible result, int count){
        ShapedRecipeJsonBuilder.create(category,result,count)
                .pattern("###")
                .pattern("# #")
                .pattern("###")
                .input('#',baseInput)
                .criterion(hasItem(baseInput),conditionsFromItem(baseInput))
                .offerTo(exporter,Identifier.of(MOD_ID,RecipeProvider.convertBetween(result,baseInput)));
    }

    public static void offerChestLikeRecipe(RecipeExporter exporter, RecipeCategory category, TagKey<Item> tagKey, ItemConvertible result, int count, String baseInput){
        ShapedRecipeJsonBuilder.create(category,result,count)
                .pattern("###")
                .pattern("# #")
                .pattern("###")
                .input('#',tagKey)
                .criterion("has_"+baseInput,conditionsFromTag(tagKey))
                .offerTo(exporter,Identifier.of(MOD_ID,convertBetween(result,baseInput)));
    }

    public static void offerChestLikeRecipe(RecipeExporter exporter, RecipeCategory category, ItemConvertible baseInput, ItemConvertible additionInput, ItemConvertible result, int count){
        ShapedRecipeJsonBuilder.create(category,result,count)
                .pattern("###")
                .pattern("#*#")
                .pattern("###")
                .input('#',baseInput)
                .input('*',additionInput)
                .criterion(hasItem(baseInput),conditionsFromItem(baseInput))
                .criterion(hasItem(additionInput),conditionsFromItem(additionInput))
                .offerTo(exporter,Identifier.of(MOD_ID,convertBetween(result,baseInput,additionInput)));
    }

    public static void offerChestLikeRecipe(RecipeExporter exporter, RecipeCategory category, TagKey<Item> tagKey, ItemConvertible additionInput, ItemConvertible result, int count, String baseInput){
        ShapedRecipeJsonBuilder.create(category,result,count)
                .pattern("###")
                .pattern("#*#")
                .pattern("###")
                .input('#',tagKey)
                .input('*',additionInput)
                .criterion("has_"+baseInput,conditionsFromTag(tagKey))
                .criterion(hasItem(additionInput),conditionsFromItem(additionInput))
                .offerTo(exporter,Identifier.of(MOD_ID,convertBetween(result,baseInput,additionInput)));
    }

    public static void offerBoatLikeRecipe(RecipeExporter exporter, RecipeCategory category, ItemConvertible baseInput, Item result, int count){
        ShapedRecipeJsonBuilder.create(category,result,count)
                .pattern("# #")
                .pattern("###")
                .input('#',baseInput)
                .criterion(hasItem(baseInput),conditionsFromItem(baseInput))
                .offerTo(exporter,Identifier.of(MOD_ID,RecipeProvider.convertBetween(result,baseInput)));
    }

    public static void offerBoatLikeRecipe(RecipeExporter exporter, RecipeCategory category, TagKey<Item> tagKey, Item result,int count,String baseInput) {
        ShapedRecipeJsonBuilder.create(category, result, count)
                .pattern("# #")
                .pattern("###")
                .input('#', tagKey)
                .criterion("has_" + baseInput, conditionsFromTag(tagKey))
                .offerTo(exporter, Identifier.of(MOD_ID, convertBetween(result,baseInput)));
    }

    public static void offerBoatLikeRecipe(RecipeExporter exporter, RecipeCategory category, ItemConvertible baseInput, ItemConvertible additionInput, Item result,int count){
        ShapedRecipeJsonBuilder.create(category,result,count)
                .pattern("#*#")
                .pattern("###")
                .input('#',baseInput)
                .input('*',additionInput)
                .criterion(hasItem(baseInput),conditionsFromItem(baseInput))
                .criterion(hasItem(additionInput),conditionsFromItem(additionInput))
                .offerTo(exporter,Identifier.of(MOD_ID, convertBetween(result,baseInput,additionInput)));
    }

    public static void offerBoatLikeRecipe(RecipeExporter exporter, RecipeCategory category, TagKey<Item> tagKey, ItemConvertible additionInput, Item result,int count,String baseInput) {
        ShapedRecipeJsonBuilder.create(category, result, count)
                .pattern("#*#")
                .pattern("###")
                .input('#', tagKey)
                .input('*',additionInput)
                .criterion("has_" + baseInput, conditionsFromTag(tagKey))
                .criterion(hasItem(additionInput),conditionsFromItem(additionInput))
                .offerTo(exporter, Identifier.of(MOD_ID, convertBetween(result,baseInput,additionInput)));
    }

    public static void offerSlabLikeRecipe(RecipeExporter exporter, RecipeCategory category, ItemConvertible input, Item result, int count){
        ShapedRecipeJsonBuilder.create(category, result, count)
                .pattern("###")
                .input('#',input)
                .criterion(hasItem(input),conditionsFromItem(input))
                .offerTo(exporter,Identifier.of(MOD_ID,RecipeProvider.convertBetween(result,input)));
    }

    public static void offerSlabLikeRecipe(RecipeExporter exporter, RecipeCategory category, TagKey<Item> tagKey, Item result, int count,String baseInput){
        ShapedRecipeJsonBuilder.create(category, result, count)
                .pattern("###")
                .input('#',tagKey)
                .criterion("has_"+baseInput,conditionsFromTag(tagKey))
                .offerTo(exporter,Identifier.of(MOD_ID,convertBetween(result,baseInput)));
    }

    public static void offerTrapdoorLikeRecipe(RecipeExporter exporter, RecipeCategory category, ItemConvertible input, Item result, int count){
        ShapedRecipeJsonBuilder.create(category, result, count)
                .pattern("###")
                .pattern("###")
                .input('#',input)
                .criterion(hasItem(input),conditionsFromItem(input))
                .offerTo(exporter,Identifier.of(MOD_ID,RecipeProvider.convertBetween(result,input)));
    }

    public static void offerTrapdoorLikeRecipe(RecipeExporter exporter, RecipeCategory category, TagKey<Item> tagKey, Item result, int count,String input){
        ShapedRecipeJsonBuilder.create(category, result, count)
                .pattern("###")
                .pattern("###")
                .input('#',tagKey)
                .criterion("has_"+input,conditionsFromTag(tagKey))
                .offerTo(exporter,Identifier.of(MOD_ID,convertBetween(result,input)));
    }

    public static void offerStairsRecipe(RecipeExporter exporter, RecipeCategory category,ItemConvertible result,ItemConvertible input){
        ShapedRecipeJsonBuilder.create(category, result, 4)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .input('#',input)
                .criterion(hasItem(input),conditionsFromItem(input))
                .offerTo(exporter,Identifier.of(MOD_ID,RecipeProvider.convertBetween(result,input)));
    }

    public static void offerDefaultDecorateRecipe(RecipeExporter exporter, ItemConvertible baseBlock){
        Item wall = pathChange(baseBlock.asItem(),"_wall");
        Item stairs = pathChange(baseBlock.asItem(),"_stairs");
        Item slab = pathChange(baseBlock.asItem(),"_slab");
        offerStonecuttingRecipe(exporter,RecipeCategory.BUILDING_BLOCKS,wall,baseBlock);
        offerStonecuttingRecipe(exporter,RecipeCategory.BUILDING_BLOCKS,stairs,baseBlock);
        offerStonecuttingRecipe(exporter,RecipeCategory.BUILDING_BLOCKS,slab,baseBlock, 2);
//        offerDefaultWallRecipe(exporter, baseBlock);
//        offerDefaultStairsRecipe(exporter, baseBlock);
//        offerDefaultSlabRecipe(exporter, baseBlock);
    }

    public static void offerDefaultWallRecipe(RecipeExporter exporter, ItemConvertible baseBlock){
        Item wall = pathChange(baseBlock.asItem(),"_wall");
        offerDefaultWallRecipe(exporter,baseBlock,wall);
    }

    public static void offerDefaultWallRecipe(RecipeExporter exporter, ItemConvertible baseBlock, ItemConvertible wall){
        offerWallRecipe(exporter,RecipeCategory.BUILDING_BLOCKS,wall,baseBlock);
        offerStonecuttingRecipe(exporter,RecipeCategory.BUILDING_BLOCKS,wall,baseBlock);
    }

    public static void offerDefaultStairsRecipe(RecipeExporter exporter, ItemConvertible baseBlock){
        Item stairs = pathChange(baseBlock.asItem(), "_stairs");
        offerDefaultStairsRecipe(exporter, baseBlock, stairs);
    }

    public static void offerDefaultStairsRecipe(RecipeExporter exporter, ItemConvertible baseBlock, ItemConvertible stairs){
        offerStairsRecipe(exporter,RecipeCategory.BUILDING_BLOCKS,stairs,baseBlock);
        offerStonecuttingRecipe(exporter,RecipeCategory.BUILDING_BLOCKS,stairs,baseBlock);
    }

    public static void offerDefaultSlabRecipe(RecipeExporter exporter, ItemConvertible baseBlock){
        Item slab = pathChange(baseBlock.asItem(),"_slab");
        offerDefaultSlabRecipe(exporter, baseBlock, slab);
    }

    public static void offerDefaultSlabRecipe(RecipeExporter exporter, ItemConvertible baseBlock, ItemConvertible slab){
        offerSlabRecipe(exporter,RecipeCategory.BUILDING_BLOCKS,slab,baseBlock);
        offerStonecuttingRecipe(exporter,RecipeCategory.BUILDING_BLOCKS,slab,baseBlock, 2);
    }

    public static void offerSherdCopy(RecipeExporter exporter, Item sherd){
        Item blueprint = pathChange(sherd,"_blueprint");
        Item prototype = pathChange(sherd,"_prototype");
        List<ItemConvertible> prototypeList = List.of(prototype);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, blueprint)
                .input(sherd)
                .input(Items.PAPER)
                .criterion(hasItem(sherd),conditionsFromItem(sherd))
                .offerTo(exporter, Identifier.of(MOD_ID, RecipeProvider.convertBetween(blueprint, sherd)));
        offerSimpleCopy(exporter, RecipeCategory.MISC, blueprint, Items.PAPER);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, prototype, 4)
                .pattern(" # ")
                .pattern("#*#")
                .pattern(" # ")
                .input('#', Items.CLAY_BALL)
                .input('*', blueprint)
                .criterion(hasItem(blueprint),conditionsFromItem(blueprint))
                .offerTo(exporter, Identifier.of(MOD_ID, RecipeProvider.convertBetween(prototype,blueprint)));
        offerSmelting(exporter, prototypeList, RecipeCategory.MISC, sherd, 0.4f, 200, RecipeProvider.getItemPath(sherd));
    }

    public static void offerDiscCopy(RecipeExporter exporter, Item disc){
        Item discSheet = pathChange(disc,"_sheet_music");
        offerUpgradeRecipe(exporter, discSheet, ModItems.GLASS_DISC, ModItems.DIAMOND_GRAVER, RecipeCategory.MISC, disc, 1);
    }

    public static void offerMultipleProcess(RecipeExporter exporter, RecipeCategory category, ItemConvertible input, ItemConvertible material ,int materialMultiplier, ItemConvertible output, int outputMultiplier, String path){
        for (int i=materialMultiplier; i<=8; i+=materialMultiplier){
            int isCopy = (input.equals(output)) ? 1 : 0;
            ShapelessRecipeJsonBuilder.create(category, output, i * outputMultiplier + isCopy)
                    .input(input)
                    .input(material, i)
                    .criterion(hasItem(input),conditionsFromItem(input))
                    .offerTo(exporter, Identifier.of(MOD_ID, path + "_" + i));
        }
    }

    public static void offerMultipleProcess(RecipeExporter exporter, RecipeCategory category, ItemConvertible input, ItemConvertible material, int materialMultiplier, ItemConvertible output, int outputMultiplier){
        offerMultipleProcess(exporter, category, input, material, materialMultiplier, output, outputMultiplier, convertBetween(output, input, material));
    }

    public static void offerSimpleCopy(RecipeExporter exporter, RecipeCategory category, ItemConvertible input, ItemConvertible material, int materialMultiplier, int countMultiplier){
        offerMultipleProcess(exporter, category, input, material, materialMultiplier, input, countMultiplier);
    }

    public static void offerSimpleCopy(RecipeExporter exporter, RecipeCategory category, ItemConvertible input, ItemConvertible material, int materialMultiplier){
        offerMultipleProcess(exporter, category, input, material, materialMultiplier, input, 1);
    }

    public static void offerSimpleCopy(RecipeExporter exporter, RecipeCategory category, ItemConvertible input, ItemConvertible material){
        offerMultipleProcess(exporter, category, input, material, 1, input, 1, RecipeProvider.getItemPath(input) + "_copy_by_" + RecipeProvider.getItemPath(material));
    }

    public static void offerMultipleProcess(RecipeExporter exporter, RecipeCategory category, ItemConvertible input, TagKey<Item> material, int materialMultiplier, ItemConvertible output, int outputMultiplier, String path){
        int isCopy = (input.equals(output)) ? 1 : 0;
        for (int i=materialMultiplier; i<=8; i+=materialMultiplier){
            ShapelessRecipeJsonBuilder.create(category, output, i * outputMultiplier + isCopy)
                    .input(input)
                    .input(Ingredient.fromTag(material), i)
                    .criterion(hasItem(input),conditionsFromItem(input))
                    .offerTo(exporter, Identifier.of(MOD_ID, path + "_" + i));
        }
    }

    public static void offerMultipleProcess(RecipeExporter exporter, RecipeCategory category, ItemConvertible input, TagKey<Item> material, int materialMultiplier, ItemConvertible output, int outputMultiplier){
        String from = RecipeProvider.getItemPath(input) + "_and_" + material.id().getPath();
        offerMultipleProcess(exporter, category, input, material, materialMultiplier, output, outputMultiplier, convertBetween(output, from));
    }

    public static void offerSimpleCopy(RecipeExporter exporter, RecipeCategory category, ItemConvertible input, TagKey<Item> material, int materialMultiplier, int countMultiplier){
        offerMultipleProcess(exporter, category, input, material, materialMultiplier, input, countMultiplier);
    }

    public static void offerSimpleCopy(RecipeExporter exporter, RecipeCategory category, ItemConvertible input, TagKey<Item> material, int materialMultiplier){
        offerMultipleProcess(exporter, category, input, material, materialMultiplier, input, 1);
    }

    public static void offerSimpleCopy(RecipeExporter exporter, RecipeCategory category, ItemConvertible input, TagKey<Item> material){
        offerMultipleProcess(exporter, category, input, material, 1, input, 1);
    }

    public static String convertBetween(ItemConvertible to, ItemConvertible fromBase, ItemConvertible fromAddition) {
        return RecipeProvider.getItemPath(to) + "_from_" + RecipeProvider.getItemPath(fromBase) + "_and_" + RecipeProvider.getItemPath(fromAddition);
    }

    public static String convertBetween(ItemConvertible to, String from) {
        return RecipeProvider.getItemPath(to) + "_from_" + from;
    }

    public static String convertBetween(ItemConvertible to, String fromBase, ItemConvertible fromAddition) {
        return RecipeProvider.getItemPath(to) + "_from_" + fromBase + "_and_" + RecipeProvider.getItemPath(fromAddition);
    }
}
