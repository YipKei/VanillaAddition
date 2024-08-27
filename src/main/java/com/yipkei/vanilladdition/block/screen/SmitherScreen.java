package com.yipkei.vanilladdition.block.screen;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerListener;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import org.joml.Quaternionf;
import org.joml.Vector3f;

@Environment(value = EnvType.CLIENT)
public class SmitherScreen extends HandledScreen<SmitherScreenHandler> implements ScreenHandlerListener {
    private static final Identifier POWERED_REDSTONE_TEXTURE = Identifier.ofVanilla("container/crafter/powered_redstone");
    private static final Identifier UNPOWERED_REDSTONE_TEXTURE = Identifier.ofVanilla("container/crafter/unpowered_redstone");
    private static final Identifier TEXTURE = Identifier.ofVanilla("textures/gui/container/smithing.png");

    private static final Vector3f VECTOR_3_F = new Vector3f();
    private static final Quaternionf ARMOR_STAND_ROTATION = new Quaternionf().rotationXYZ(0.43633232f, 0.0f, (float)Math.PI);
    @Nullable
    private ArmorStandEntity armorStand;


    public SmitherScreen(SmitherScreenHandler handler, PlayerInventory playerInventory, Text title){
        super(handler, playerInventory, title);
        this.titleX = 44;
        this.titleY = 15;
    }

    @Override
    protected void init() {
        super.init();
        this.setup();
        this.handler.addListener(this);
    }

    protected void setup() {
        this.armorStand = new ArmorStandEntity(this.client.world, 0.0, 0.0, 0.0);
        this.armorStand.setHideBasePlate(true);
        this.armorStand.setShowArms(true);
        this.armorStand.bodyYaw = 210.0f;
        this.armorStand.setPitch(25.0f);
        this.armorStand.headYaw = this.armorStand.getYaw();
        this.armorStand.prevHeadYaw = this.armorStand.getYaw();
        this.equipArmorStand((this.handler).getSlot(3).getStack());
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        this.drawArrowTexture(context);
        this.drawMouseoverTooltip(context, mouseX, mouseY);
    }

    private void drawArrowTexture(DrawContext context) {
        int i = this.width / 2 + 9;
        int j = this.height /2 - 48;
        Identifier identifier = this.handler.isTriggered() ? POWERED_REDSTONE_TEXTURE : UNPOWERED_REDSTONE_TEXTURE;
        context.drawGuiTexture(identifier, i, j, 16, 16);
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        int i = (this.width - this.backgroundWidth) / 2;
        int j = (this.height - this.backgroundHeight) / 2;
        context.drawTexture(TEXTURE, i, j, 0, 0, this.backgroundWidth, this.backgroundHeight);
        InventoryScreen.drawEntity(context, this.x + 141, this.y + 75, 25.0f, VECTOR_3_F, ARMOR_STAND_ROTATION, null, this.armorStand);
    }

    @Override
    public void onSlotUpdate(ScreenHandler handler, int slotId, ItemStack stack) {
        if (slotId == 3) {
            this.equipArmorStand(stack);
        }
    }

    private void equipArmorStand(ItemStack stack) {
        if (this.armorStand == null) {
            return;
        }
        for (EquipmentSlot equipmentSlot : EquipmentSlot.values()) {
            this.armorStand.equipStack(equipmentSlot, ItemStack.EMPTY);
        }
        if (!stack.isEmpty()) {
            ItemStack itemStack = stack.copy();
            Item item = stack.getItem();
            if (item instanceof ArmorItem armorItem) {
                this.armorStand.equipStack(armorItem.getSlotType(), itemStack);
            } else {
                this.armorStand.equipStack(EquipmentSlot.OFFHAND, itemStack);
            }
        }
    }

    @Override
    public void onPropertyUpdate(ScreenHandler handler, int property, int value) {

    }

//    @Override
//    protected void drawInvalidRecipeArrow(DrawContext context, int x, int y) {
//        if (this.hasInvalidRecipe()) {
//            context.drawGuiTexture(ERROR_TEXTURE, this.width /2 +9, this.height/2-48, 28, 21);
//        }
//    }
//
//    private boolean hasInvalidRecipe(){
//        return this.handler.getSlot(0).hasStack() && this.handler.getSlot(1).hasStack() && this.handler.getSlot(2).hasStack() && !this.handler.getSlot(3).hasStack();
//    }
}
