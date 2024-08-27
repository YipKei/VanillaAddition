package com.yipkei.vanilladdition.block.screen;

import com.yipkei.vanilladdition.init.ModScreenHandlerType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.CraftingResultInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.RecipeInputInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.SmithingRecipe;
import net.minecraft.recipe.input.SmithingRecipeInput;
import net.minecraft.screen.*;
import net.minecraft.screen.slot.CrafterOutputSlot;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;

import java.util.List;

public class SmitherScreenHandler extends ScreenHandler implements ScreenHandlerListener {
    private final World world;
    protected static final int SIZE = 3;
    private final PropertyDelegate propertyDelegate;
    private final PlayerEntity player;
    private final RecipeInputInventory inputInventory;
    private final CraftingResultInventory resultInventory = new CraftingResultInventory();


    public SmitherScreenHandler(int syncId, PlayerInventory playerInventory) {
        super(ModScreenHandlerType.SMITHER, syncId);
        this.player = playerInventory.player;
        this.world = player.getWorld();
        this.propertyDelegate = new ArrayPropertyDelegate(1);
        this.inputInventory = new CraftingInventory(this,3,1);
        this.addSlots(playerInventory);
    }

    public SmitherScreenHandler(int syncId, PlayerInventory playerInventory, RecipeInputInventory inputInventory, PropertyDelegate propertyDelegate) {
        super(ModScreenHandlerType.SMITHER, syncId);
        this.player = playerInventory.player;
        this.world = playerInventory.player.getWorld();
        this.propertyDelegate = propertyDelegate;
        this.inputInventory = inputInventory;
        SmitherScreenHandler.checkSize(inputInventory, 3);
        inputInventory.onOpen(playerInventory.player);
        this.addSlots(playerInventory);
        this.addListener(this);
    }

    private void addSlots(PlayerInventory playerInventory) {
        int i;
        for (i = 0; i < SIZE; ++i) {
            this.addSlot(new SmitherInputSlot(this.inputInventory, i, 8 + i * 18, 48, this));
        }
        for (i = 0; i < 3; ++i) {
            for (int j = 0; j <9; ++j) {
                this.addSlot(new Slot(playerInventory, j+i*9+9, 8+j*18, 84+i*18));
            }
        }
        for (i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
        this.addSlot(new CrafterOutputSlot(this.resultInventory, 0, 98, 48));
        this.addProperties(this.propertyDelegate);
        this.updateResult();
    }

    public boolean isTriggered() {
        return this.propertyDelegate.get(0) == 1;
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot2 = this.slots.get(slot);
        if (slot2 != null && slot2.hasStack()) {
            ItemStack itemStack2 = slot2.getStack();
            itemStack = itemStack2.copy();
            if (slot<3 ? !this.insertItem(itemStack2, 3, 39, true) : !this.insertItem(itemStack2, 0, 3, false)) {
                return ItemStack.EMPTY;
            }
            if (itemStack2.isEmpty()) {
                slot2.setStackNoCallbacks(ItemStack.EMPTY);
            } else {
                slot2.markDirty();
            }
            if (itemStack2.getCount() == itemStack.getCount()) {
                return ItemStack.EMPTY;
            }
            slot2.onTakeItem(player, itemStack2);
        }
        return itemStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inputInventory.canPlayerUse(player);
    }

    public void updateResult(){
        if (this.player instanceof ServerPlayerEntity serverPlayerEntity) {
            SmithingRecipeInput smithingRecipeInput = this.createRecipeInput();
            List<RecipeEntry<SmithingRecipe>> list = world.getRecipeManager().getAllMatches(RecipeType.SMITHING, smithingRecipeInput, world);
            if (list.isEmpty()) {
                this.resultInventory.setStack(0, ItemStack.EMPTY);
            } else {
                RecipeEntry<SmithingRecipe> recipeEntry = list.getFirst();
                ItemStack stack = recipeEntry.value().craft(smithingRecipeInput, world.getRegistryManager());
                if (stack.isItemEnabled(world.getEnabledFeatures())){
                    this.resultInventory.setLastRecipe(recipeEntry);
                    this.resultInventory.setStack(0, stack);
                }
            }
        }
    }

    public Inventory getInputInventory() {
        return this.inputInventory;
    }

    @Override
    public void onSlotUpdate(ScreenHandler handler, int slotId, ItemStack stack) {
        this.updateResult();
    }

    @Override
    public void onPropertyUpdate(ScreenHandler handler, int property, int value) {
    }

    private SmithingRecipeInput createRecipeInput() {
        return new SmithingRecipeInput(this.inputInventory.getStack(0), this.inputInventory.getStack(1), this.inputInventory.getStack(2));
    }
}
