package com.yipkei.vanilladdition.init;

import com.mojang.serialization.MapCodec;
import com.yipkei.vanilladdition.block.SmitherBlock;
import net.minecraft.block.Block;
import net.minecraft.registry.Registry;

public class ModBlockTypes{
    public static MapCodec<? extends Block> registerAndGetDefault(Registry<MapCodec<? extends Block>> registry) {
        return Registry.register(registry, "smither", SmitherBlock.CODEC);
    }


}
