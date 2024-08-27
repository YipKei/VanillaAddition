package com.yipkei.vanilladdition.helper;

import com.yipkei.vanilladdition.VanillaAddition;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.CraftingRecipe;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.input.CraftingRecipeInput;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

import java.util.List;
import java.util.Optional;

public class ModRecipeHelper {
    public static List<String> DISABLED_CRAFTING_REMAINDER = List.of(
            "diamond_hammer"
    );

    public static boolean checkCraftingRepair(CraftingRecipeInput input, World world) {
        RecipeManager recipeManager = world.getRecipeManager();
        DefaultedList<ItemStack> defaultedList = recipeManager.getRemainingStacks(RecipeType.CRAFTING, input, world);
        Optional<RecipeEntry<CraftingRecipe>> recipeEntry = recipeManager.getFirstMatch(RecipeType.CRAFTING, input, world);
        Item check = null;
        boolean isRepair = false;
        for (ItemStack stack : defaultedList) {
            if (stack.equals(ItemStack.EMPTY)) continue;
            if (check == null) {
                check = stack.getItem();
                continue;
            }
            if (stack.isOf(check)) {
                if (isRepair) {
                    isRepair = false;
                    break;
                }
                isRepair = true;
            }
        }
        for (String path : ModRecipeHelper.DISABLED_CRAFTING_REMAINDER) {
            if (recipeEntry.equals(world.getRecipeManager().get(Identifier.of(VanillaAddition.MOD_ID, path)))) {
                isRepair = true;
                break;
            }
        }
        return isRepair;
    }
}
