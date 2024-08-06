package com.yipkei.vanilladdition.data.generator.recipe;


import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementCriterion;
import net.minecraft.advancement.AdvancementRequirements;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.advancement.criterion.RecipeUnlockedCriterion;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.SmithingTransformRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.LinkedHashMap;
import java.util.Map;

public class StackableTransformRecipeJsonBuilder {
    private final Ingredient template;
    private final Ingredient base;
    private final Ingredient addition;
    private final RecipeCategory category;
    private final ItemStack resultStack;
    private final Map<String, AdvancementCriterion<?>> criteria = new LinkedHashMap<>();

    private StackableTransformRecipeJsonBuilder(Ingredient template, Ingredient base, Ingredient addition, RecipeCategory category, ItemStack resultStack) {
        this.category = category;
        this.template = template;
        this.base = base;
        this.addition = addition;
        this.resultStack = resultStack;
    }


    public static StackableTransformRecipeJsonBuilder create(Ingredient template, Ingredient base, Ingredient addition, RecipeCategory category, ItemStack resultStack) {
        return new StackableTransformRecipeJsonBuilder(template, base, addition, category, resultStack);
    }

    public StackableTransformRecipeJsonBuilder criterion(String name, AdvancementCriterion<?> criterion) {
        this.criteria.put(name, criterion);
        return this;
    }

    public void offerTo(RecipeExporter exporter, String recipeId) {
        this.offerTo(exporter, Identifier.of(recipeId));
    }

    public void offerTo(RecipeExporter exporter, Identifier recipeId) {
        this.validate(recipeId);
        Advancement.Builder builder = exporter.getAdvancementBuilder().criterion("has_the_recipe", RecipeUnlockedCriterion.create(recipeId)).rewards(AdvancementRewards.Builder.recipe(recipeId)).criteriaMerger(AdvancementRequirements.CriterionMerger.OR);
        this.criteria.forEach(builder::criterion);
        SmithingTransformRecipe smithingTransformRecipe = new SmithingTransformRecipe(this.template, this.base, this.addition, resultStack);
        exporter.accept(recipeId, smithingTransformRecipe, builder.build(recipeId.withPrefixedPath("recipes/" + this.category.getName() + "/")));
    }

    private void validate(Identifier recipeId) {
        if (this.criteria.isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + String.valueOf(recipeId));
        }
    }
}
