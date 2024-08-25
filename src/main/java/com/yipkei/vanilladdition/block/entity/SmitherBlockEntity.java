package com.yipkei.vanilladdition.block.entity;

import com.yipkei.vanilladdition.block.SmitherBlock;
import com.yipkei.vanilladdition.block.screen.SmitherScreenHandler;
import com.yipkei.vanilladdition.init.ModBlockEntityType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.RecipeInputInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.RecipeMatcher;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SmitherBlockEntity extends LootableContainerBlockEntity implements RecipeInputInventory {
    public static final int GRID_SIZE = 3;
    private DefaultedList<ItemStack> inputStacks = DefaultedList.ofSize(3, ItemStack.EMPTY);
    private int smithingTicksRemaining = 0;
    protected final PropertyDelegate propertyDelegate = new PropertyDelegate() {
        private int triggered = 0;

        @Override
        public int get(int index) {
            return this.triggered;
        }

        @Override
        public void set(int index, int value) {
            this.triggered = value;
        }

        @Override
        public int size() {
            return 1;
        }
    };

    public SmitherBlockEntity(BlockPos pos, BlockState state){
        super(ModBlockEntityType.SMITHER, pos, state);
    }

    protected Text getContainerName() { return Text.translatable("container.smither");}

    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new SmitherScreenHandler(syncId, playerInventory, this.propertyDelegate, ScreenHandlerContext.create(world, pos));
    }

// setSlotEnabled & isSlotDisabled 设置与读取禁用槽位
// isValid 读取是否可用槽位，用于物品输入（通用）
// betterSlotExists 剩余槽位是否可用

    @Override
    public boolean isValid(int slot, ItemStack stack) {
        ItemStack itemStack = this.inputStacks.get(slot);
        int i = itemStack.getCount();
        if (i >= itemStack.getMaxCount()) {
            return false;
        }
        if (itemStack.isEmpty()) {
            return true;
        }
        return super.isValid(slot, stack);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        this.smithingTicksRemaining = nbt.getInt("smithing_ticks_remaining");
        this.inputStacks = DefaultedList.ofSize(this.size(), ItemStack.EMPTY);
        if (!this.readLootTable(nbt)) {
            Inventories.readNbt(nbt, this.inputStacks, registryLookup);
        }
        this.propertyDelegate.set(0, nbt.getInt("triggered"));
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        nbt.putInt("smithing_ticks_remaining", this.smithingTicksRemaining);
        if (!this.writeLootTable(nbt)) {
            Inventories.writeNbt(nbt, this.inputStacks, registryLookup);
        }
        nbt.putInt("triggered", this.propertyDelegate.get(0));
    }

    @Override
    public int size() {
        return 3;
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack itemStack : this.inputStacks) {
            if (itemStack.isEmpty()) continue;
            return false;
        }
        return true;
    }

    @Override
    public ItemStack getStack(int slot) {
        return this.inputStacks.get(slot);
    }

// setStack 无特殊操作，无需覆写

    @Override
    public boolean canPlayerUse(PlayerEntity player) {
        return Inventory.canPlayerUse(this, player);
    }

    @Override
    public DefaultedList<ItemStack> getHeldStacks() {
        return this.inputStacks;
    }

    @Override
    protected void setHeldStacks(DefaultedList<ItemStack> inventory) {
        this.inputStacks = inventory;
    }

    @Override
    public int getWidth() {
        return 3;
    }

    @Override
    public int getHeight() {
        return 1;
    }

    @Override
    public void provideRecipeInputs(RecipeMatcher finder) {
        for (ItemStack itemStack : this.inputStacks) {
            finder.addUnenchantedInput(itemStack);
        }
    }


    public void setTriggered(boolean triggered) {
        this.propertyDelegate.set(0, triggered ? 1 : 0);
    }

    public boolean isTriggered() {
        return this.propertyDelegate.get(0) == 1;
    }

    public static void tickSmithing(World world, BlockPos pos, BlockState state, SmitherBlockEntity blockEntity) {
        int i = blockEntity.smithingTicksRemaining - 1;
        if (i < 0) {
            return;
        }
        blockEntity.smithingTicksRemaining = i;
        if (i == 0) {
            world.setBlockState(pos, state.with(SmitherBlock.SMITHING, false), Block.NOTIFY_ALL);
        }
    }

    public void setSmithingTicksRemaining(int smithingTicksRemaining) {
        this.smithingTicksRemaining = smithingTicksRemaining;
    }

    public int getComparatorOutput() {
        int i = 0;
        for (int j = 0; j < this.size(); ++j) {
            ItemStack itemStack = this.getStack(j);
            if (itemStack.isEmpty()) continue;
            ++i;
        }
        return i;
    }



}
