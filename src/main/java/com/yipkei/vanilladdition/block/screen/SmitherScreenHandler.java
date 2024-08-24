package com.yipkei.vanilladdition.block.screen;

import com.yipkei.vanilladdition.init.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.SmithingRecipe;
import net.minecraft.recipe.input.SmithingRecipeInput;
import net.minecraft.screen.*;
import net.minecraft.screen.slot.ForgingSlotsManager;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;

import java.util.List;

public class SmitherScreenHandler extends ForgingScreenHandler implements ScreenHandlerListener {
    public static final int TEMPLATE_ID = 0;
    public static final int EQUIPMENT_ID = 1;
    public static final int MATERIAL_ID = 2;
    public static final int OUTPUT_ID = 3;
    public static final int TEMPLATE_X = 8;
    public static final int EQUIPMENT_X = 26;
    public static final int MATERIAL_X = 44;
    private static final int OUTPUT_X = 98;
    public static final int SLOT_Y = 48;
    private final World world;
    private RecipeEntry<SmithingRecipe> currentRecipe;
    private final List<RecipeEntry<SmithingRecipe>> recipes;
    protected static final int SIZE = 3;
    private final boolean triggered;


    public SmitherScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory,new SimpleInventory(4), false, ScreenHandlerContext.EMPTY);
    }

    public SmitherScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inputInventory, boolean triggered, ScreenHandlerContext context) {
        super(ScreenHandlerType.SMITHING, syncId, playerInventory, context);
        this.world = playerInventory.player.getWorld();
        this.triggered = triggered;
        this.addListener(this);
        this.recipes = this.world.getRecipeManager().listAllOfType(RecipeType.SMITHING);
    }

    @Override
    protected ForgingSlotsManager getForgingSlotsManager(){
        return ForgingSlotsManager.create().input(0, 8, 48, stack -> !stack.isEmpty()).input(1, 26, 48, stack -> !stack.isEmpty()).input(2, 44, 48, stack -> !stack.isEmpty()).output(3, 98, 48).build();
    }

    public boolean isTriggered() {
        return this.triggered;
    }


    @Override
    protected boolean canTakeOutput(PlayerEntity player, boolean present) {
        return false;
    }

    @Override
    protected void onTakeOutput(PlayerEntity player, ItemStack stack) {

    }

    @Override
    protected boolean canUse(BlockState state) {
        return state.isOf(ModBlocks.SMITHER);
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.input.canPlayerUse(player);
    }

    @Override
    public void updateResult(){
        if (this.player instanceof ServerPlayerEntity serverPlayerEntity) {
            World world = serverPlayerEntity.getWorld();
            SmithingRecipeInput smithingRecipeInput = this.createRecipeInput();
            List<RecipeEntry<SmithingRecipe>> list = world.getRecipeManager().getAllMatches(RecipeType.SMITHING, smithingRecipeInput, world);
            if (list.isEmpty()) {
                this.output.setStack(0, ItemStack.EMPTY);
            } else {
                RecipeEntry<SmithingRecipe> recipeEntry = list.getFirst();
                ItemStack stack = recipeEntry.value().craft(smithingRecipeInput, world.getRegistryManager());
                if (stack.isItemEnabled(world.getEnabledFeatures())){
                    this.currentRecipe = recipeEntry;
                    this.output.setLastRecipe(recipeEntry);
                    this.output.setStack(0, stack);
                }
            }
        }
    }

    public Inventory getInputInventory() {
        return this.input;
    }

    @Override
    public void onSlotUpdate(ScreenHandler handler, int slotId, ItemStack stack) {
        this.updateResult();
    }

    @Override
    public void onPropertyUpdate(ScreenHandler handler, int property, int value) {
    }

    private SmithingRecipeInput createRecipeInput() {
        return new SmithingRecipeInput(this.input.getStack(0), this.input.getStack(1), this.input.getStack(2));
    }
}
