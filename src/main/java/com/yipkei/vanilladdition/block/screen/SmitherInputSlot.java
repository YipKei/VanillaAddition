package com.yipkei.vanilladdition.block.screen;

import net.minecraft.inventory.Inventory;
import net.minecraft.screen.slot.Slot;

public class SmitherInputSlot extends Slot {
    private final SmitherScreenHandler smitherScreenHandler;
    public SmitherInputSlot(Inventory inventory, int index, int x, int y, SmitherScreenHandler smitherScreenHandler) {
        super(inventory, index, x, y);
        this.smitherScreenHandler = smitherScreenHandler;
    }

    @Override
    public void markDirty(){
        super.markDirty();
        this.smitherScreenHandler.onContentChanged(this.inventory);
    }
}
