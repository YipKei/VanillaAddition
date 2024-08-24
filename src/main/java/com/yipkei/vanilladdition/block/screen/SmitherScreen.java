package com.yipkei.vanilladdition.block.screen;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.ForgingScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

@Environment(value = EnvType.CLIENT)
public class SmitherScreen extends ForgingScreen<SmitherScreenHandler> {
    private static final Identifier POWERED_REDSTONE_TEXTURE = Identifier.ofVanilla("container/crafter/powered_redstone");
    private static final Identifier UNPOWERED_REDSTONE_TEXTURE = Identifier.ofVanilla("container/crafter/unpowered_redstone");
    private static final Identifier TEXTURE = Identifier.ofVanilla("textures/gui/container/smithing_table.png");
    private static final Identifier ERROR_TEXTURE = Identifier.ofVanilla("container/smithing/error");



    public SmitherScreen(SmitherScreenHandler handler, PlayerInventory playerInventory, Text title){
        super(handler, playerInventory, title,Identifier.ofVanilla("textures/gui/container/smithing.png"));
        this.titleX = 44;
        this.titleY = 15;
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        this.drawArrowTexture(context);
        this.drawMouseoverTooltip(context, mouseX, mouseY);
    }

    private void drawArrowTexture(DrawContext context) {
        int i = this.width / 2 + 9;
        int j = this.height /2 -48;
        Identifier identifier = this.handler.isTriggered() ? POWERED_REDSTONE_TEXTURE : UNPOWERED_REDSTONE_TEXTURE;
        context.drawGuiTexture(identifier, i, j, 16, 16);
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        int i = (this.width - this.backgroundWidth) / 2;
        int j = (this.height - this.backgroundHeight) / 2;
        context.drawTexture(TEXTURE, i, j, 0, 0, this.backgroundWidth, this.backgroundHeight);
    }

    @Override
    protected void drawInvalidRecipeArrow(DrawContext context, int x, int y) {
        if (this.hasInvalidRecipe()) {
            context.drawGuiTexture(ERROR_TEXTURE, this.width /2 +9, this.height/2-48, 28, 21);
        }
    }

    private boolean hasInvalidRecipe(){
        return this.handler.getSlot(0).hasStack() && this.handler.getSlot(1).hasStack() && this.handler.getSlot(2).hasStack() && !this.handler.getSlot(3).hasStack();
    }
}
