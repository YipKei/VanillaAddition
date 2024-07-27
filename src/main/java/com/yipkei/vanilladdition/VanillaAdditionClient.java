package com.yipkei.vanilladdition;

import com.yipkei.vanilladdition.init.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.impl.blockrenderlayer.BlockRenderLayerMapImpl;
import net.minecraft.client.render.RenderLayer;

public class VanillaAdditionClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMapImpl blockRenderLayerMap = new BlockRenderLayerMapImpl();
        blockRenderLayerMap.putBlocks(RenderLayer.getTranslucent(), ModBlocks.ICE_SLAB, ModBlocks.ICE_STAIRS, ModBlocks.ICE_WALL);
    }
}
