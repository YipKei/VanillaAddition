package com.yipkei.vanilladdition.data.recipe;

import com.yipkei.vanilladdition.VanillaAddition;
import com.yipkei.vanilladdition.init.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.*;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public abstract class ModCustomRecipeProvider extends FabricRecipeProvider {

    public ModCustomRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    public static void offerReversible2x2CompactingRecipes(RecipeExporter exporter,RecipeCategory category,ItemConvertible input,ItemConvertible output){
        ShapedRecipeJsonBuilder.create(category, output,1)
                .pattern("##")
                .pattern("##")
                .input('#',input)
                .criterion(hasItem(input),conditionsFromItem(input))
                .offerTo(exporter,Identifier.of(VanillaAddition.MOD_ID,convertBetween(output,input)));
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
                .offerTo(exporter,Identifier.of(VanillaAddition.MOD_ID,type + "_sword"));
    }


    public static void offerShovelRecipe(RecipeExporter exporter,ItemConvertible mainInput,ItemConvertible minorInput,ItemConvertible output,String type){
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output,1)
                .pattern("#")
                .pattern("*")
                .pattern("*")
                .input('#',mainInput)
                .input('*',minorInput)
                .criterion(hasItem(mainInput),conditionsFromItem(mainInput))
                .criterion(hasItem(minorInput),conditionsFromItem(minorInput))
                .offerTo(exporter,Identifier.of(VanillaAddition.MOD_ID,type + "_shovel"));
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
                .offerTo(exporter,Identifier.of(VanillaAddition.MOD_ID,type + "_pickaxe"));
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
                .offerTo(exporter,Identifier.of(VanillaAddition.MOD_ID,type + "_axe"));
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
                .offerTo(exporter,Identifier.of(VanillaAddition.MOD_ID,type + "_hoe"));
    }



    public static void offerUpgradeRecipe(RecipeExporter exporter, Item smithingTemplate, Item input, Item ingredient, RecipeCategory category, Item result ){
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(smithingTemplate),
                        Ingredient.ofItems(input),
                        Ingredient.ofItems(ingredient),
                        category,
                        result).criterion("has_"+smithingTemplate.toString(), RecipeProvider
                        .conditionsFromItem(smithingTemplate))
                .offerTo(exporter, RecipeProvider.getItemPath(result) + "_smithing");
    }

    public static void offerUpgradeRecipe(RecipeExporter exporter, Item smithingTemplate, Item input, Item ingredient, RecipeCategory category, Item result, RegistryEntry<Enchantment> enchantment, int level){
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(smithingTemplate),
                        Ingredient.ofItems(input),
                        Ingredient.ofItems(ingredient),
                        category,
                        result)
                .criterion("has_"+smithingTemplate.toString(), RecipeProvider
                        .conditionsFromItem(smithingTemplate))
                .offerTo(exporter, RecipeProvider.getItemPath(result) + "_smithing");
    }

//    public static void offerDiamondShardsUpgradeRecipe(RecipeExporter exporter, Item input, RecipeCategory category, Item result){
//        SmithingTransformRecipeJsonBuilder.create(
//                        Ingredient.ofItems(ModItems.DIAMOND_SHARDS_UPGRADED_SMITHING_TEMPLATE),
//                        Ingredient.ofItems(input),
//                        Ingredient.ofItems(ModItems.STEEL_INGOT),
//                        category,
//                        result).criterion("has_diamond_shards_upgrade_smithing_template", RecipeProvider
//                        .conditionsFromItem(ModItems.DIAMOND_SHARDS_UPGRADED_SMITHING_TEMPLATE))
//                .offerTo(exporter, RecipeProvider.getItemPath(result) + "_smithing");
//    }


    public static void offerCookingDefault(RecipeExporter exporter, int baseCookingTime, ItemConvertible input, ItemConvertible output, float experience){
        offerFoodCookingRecipe(exporter,"smelting", RecipeSerializer.SMELTING, SmeltingRecipe::new,baseCookingTime,input,output,experience);
        offerFoodCookingRecipe(exporter,"smoking",RecipeSerializer.SMOKING, SmokingRecipe::new,baseCookingTime/2,input,output,experience);
        offerFoodCookingRecipe(exporter,"campfire_cooking",RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new,baseCookingTime*3,input,output,experience);
    }


    public static void offerMetalSmeltingDefault(RecipeExporter exporter, List<ItemConvertible> input, ItemConvertible output, float experience, int baseSmeltingTime, String group){
        offerSmelting(exporter,input,RecipeCategory.MISC,output,experience,baseSmeltingTime,group);
        offerBlasting(exporter,input,RecipeCategory.MISC,output,experience,baseSmeltingTime/2,group);
    }

    public static void offerHammerProcessing(RecipeExporter exporter,ItemConvertible input,int size,ItemConvertible hammer,Item result,int count,String type){
        String hammerType = "";
        if (hammer.equals(ModItems.STONE_HAMMER)) {
            hammerType = "stone_hammer";
        } else if (hammer.equals(ModItems.IRON_HAMMER)) {
            hammerType = "iron_hammer";
        } else if (hammer.equals(ModItems.DIAMOND_HAMMER)) {
            hammerType = "diamond_hammer";
        }
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC,result,count)
                .input(input,size)
                .input(hammer)
                .criterion(hasItem(input),conditionsFromItem(input))
                .criterion(hasItem(hammer),conditionsFromItem(hammer))
                .group("hammer_processing")
                .offerTo(exporter,RecipeProvider.getItemPath(input)+"_"+type+"_by_"+ hammerType);
    }

    public static void offerHammerProcessing(RecipeExporter exporter, TagKey<Item> tagKey, int size, ItemConvertible hammer, Item result, int count, String type,String tagName){
        String hammerType = "";
        if (hammer.equals(ModItems.STONE_HAMMER)) {
            hammerType = "stone_hammer";
        } else if (hammer.equals(ModItems.IRON_HAMMER)) {
            hammerType = "iron_hammer";
        } else if (hammer.equals(ModItems.DIAMOND_HAMMER)) {
            hammerType = "diamond_hammer";
        }
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC,result,count)
                .input(Ingredient.fromTag(tagKey),size)
                .input(hammer)
                .criterion(hasItem(hammer),conditionsFromItem(hammer))
                .group("hammer_processing")
                .offerTo(exporter,tagName+"_"+type+"_by_"+ hammerType);
    }

    public static void offerTorchLikeRecipe(RecipeExporter exporter,RecipeCategory category,ItemConvertible inputAbove,ItemConvertible inputBelow,Item result,int count,String path){
        ShapedRecipeJsonBuilder.create(category, result,count)
                .pattern("#")
                .pattern("*")
                .input('#',inputAbove)
                .input('*',inputBelow)
                .criterion(hasItem(inputAbove),conditionsFromItem(inputAbove))
                .criterion(hasItem(inputBelow),conditionsFromItem(inputBelow))
                .offerTo(exporter,Identifier.of(VanillaAddition.MOD_ID,path));
    }

    public static void offerTorchLikeRecipe(RecipeExporter exporter, RecipeCategory category, TagKey<Item> tagKey, ItemConvertible inputBelow, Item result, int count, String path){
        ShapedRecipeJsonBuilder.create(category, result,count)
                .pattern("#")
                .pattern("*")
                .input('#',tagKey)
                .input('*',inputBelow)
                .criterion(hasItem(inputBelow),conditionsFromItem(inputBelow))
                .offerTo(exporter,Identifier.of(VanillaAddition.MOD_ID,path));
    }

    public static void offerChestLikeRecipe(RecipeExporter exporter, RecipeCategory category, ItemConvertible baseInput, Item result, int count){
        ShapedRecipeJsonBuilder.create(category,result,count)
                .pattern("###")
                .pattern("# #")
                .pattern("###")
                .input('#',baseInput)
                .criterion(hasItem(baseInput),conditionsFromItem(baseInput))
                .offerTo(exporter,Identifier.of(VanillaAddition.MOD_ID,convertBetween(result,baseInput)));
    }

    public static void offerChestLikeRecipe(RecipeExporter exporter, RecipeCategory category, TagKey<Item> tagKey, Item result, int count, String baseInput){
        ShapedRecipeJsonBuilder.create(category,result,count)
                .pattern("###")
                .pattern("# #")
                .pattern("###")
                .input('#',tagKey)
                .criterion("has_"+baseInput,conditionsFromTag(tagKey))
                .offerTo(exporter,Identifier.of(VanillaAddition.MOD_ID,convertBetween(result,baseInput)));
    }

    public static void offerChestLikeRecipe(RecipeExporter exporter, RecipeCategory category, ItemConvertible baseInput, ItemConvertible additionInput, Item result, int count){
        ShapedRecipeJsonBuilder.create(category,result,count)
                .pattern("###")
                .pattern("#*#")
                .pattern("###")
                .input('#',baseInput)
                .input('*',additionInput)
                .criterion(hasItem(baseInput),conditionsFromItem(baseInput))
                .criterion(hasItem(additionInput),conditionsFromItem(additionInput))
                .offerTo(exporter,Identifier.of(VanillaAddition.MOD_ID,convertBetween(result,baseInput,additionInput)));
    }

    public static void offerChestLikeRecipe(RecipeExporter exporter, RecipeCategory category, TagKey<Item> tagKey, ItemConvertible additionInput, Item result, int count, String baseInput){
        ShapedRecipeJsonBuilder.create(category,result,count)
                .pattern("###")
                .pattern("#*#")
                .pattern("###")
                .input('#',tagKey)
                .input('*',additionInput)
                .criterion("has_"+baseInput,conditionsFromTag(tagKey))
                .criterion(hasItem(additionInput),conditionsFromItem(additionInput))
                .offerTo(exporter,Identifier.of(VanillaAddition.MOD_ID,convertBetween(result,baseInput,additionInput)));
    }

    public static void offerBoatLikeRecipe(RecipeExporter exporter, RecipeCategory category, ItemConvertible baseInput, Item result, int count){
        ShapedRecipeJsonBuilder.create(category,result,count)
                .pattern("# #")
                .pattern("###")
                .input('#',baseInput)
                .criterion(hasItem(baseInput),conditionsFromItem(baseInput))
                .offerTo(exporter,Identifier.of(VanillaAddition.MOD_ID,convertBetween(result,baseInput)));
    }

    public static void offerBoatLikeRecipe(RecipeExporter exporter, RecipeCategory category, TagKey<Item> tagKey, Item result,int count,String baseInput) {
        ShapedRecipeJsonBuilder.create(category, result, count)
                .pattern("# #")
                .pattern("###")
                .input('#', tagKey)
                .criterion("has_" + baseInput, conditionsFromTag(tagKey))
                .offerTo(exporter, Identifier.of(VanillaAddition.MOD_ID, convertBetween(result,baseInput)));
    }

    public static void offerBoatLikeRecipe(RecipeExporter exporter, RecipeCategory category, ItemConvertible baseInput, ItemConvertible additionInput, Item result,int count){
        ShapedRecipeJsonBuilder.create(category,result,count)
                .pattern("#*#")
                .pattern("###")
                .input('#',baseInput)
                .input('*',additionInput)
                .criterion(hasItem(baseInput),conditionsFromItem(baseInput))
                .criterion(hasItem(additionInput),conditionsFromItem(additionInput))
                .offerTo(exporter,Identifier.of(VanillaAddition.MOD_ID, convertBetween(result,baseInput,additionInput)));
    }

    public static void offerBoatLikeRecipe(RecipeExporter exporter, RecipeCategory category, TagKey<Item> tagKey, ItemConvertible additionInput, Item result,int count,String baseInput) {
        ShapedRecipeJsonBuilder.create(category, result, count)
                .pattern("#*#")
                .pattern("###")
                .input('#', tagKey)
                .input('*',additionInput)
                .criterion("has_" + baseInput, conditionsFromTag(tagKey))
                .criterion(hasItem(additionInput),conditionsFromItem(additionInput))
                .offerTo(exporter, Identifier.of(VanillaAddition.MOD_ID, convertBetween(result,baseInput,additionInput)));
    }

    public static void offerSlabLikeRecipe(RecipeExporter exporter, RecipeCategory category, ItemConvertible input, Item result, int count){
        ShapedRecipeJsonBuilder.create(category, result, count)
                .pattern("###")
                .input('#',input)
                .criterion(hasItem(input),conditionsFromItem(input))
                .offerTo(exporter,Identifier.of(VanillaAddition.MOD_ID,convertBetween(result,input)));
    }

    public static void offerSlabLikeRecipe(RecipeExporter exporter, RecipeCategory category, TagKey<Item> tagKey, Item result, int count,String baseInput){
        ShapedRecipeJsonBuilder.create(category, result, count)
                .pattern("###")
                .input('#',tagKey)
                .criterion("has_"+baseInput,conditionsFromTag(tagKey))
                .offerTo(exporter,Identifier.of(VanillaAddition.MOD_ID,convertBetween(result,baseInput)));
    }

    public static void offerTrapdoorLikeRecipe(RecipeExporter exporter, RecipeCategory category, ItemConvertible input, Item result, int count){
        ShapedRecipeJsonBuilder.create(category, result, count)
                .pattern("###")
                .pattern("###")
                .input('#',input)
                .criterion(hasItem(input),conditionsFromItem(input))
                .offerTo(exporter,Identifier.of(VanillaAddition.MOD_ID,convertBetween(result,input)));
    }

    public static void offerTrapdoorLikeRecipe(RecipeExporter exporter, RecipeCategory category, TagKey<Item> tagKey, Item result, int count,String input){
        ShapedRecipeJsonBuilder.create(category, result, count)
                .pattern("###")
                .pattern("###")
                .input('#',tagKey)
                .criterion("has_"+input,conditionsFromTag(tagKey))
                .offerTo(exporter,Identifier.of(VanillaAddition.MOD_ID,convertBetween(result,input)));
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
