package com.yipkei.vanilladdition.init;

import com.yipkei.vanilladdition.VanillaAddition;
import com.yipkei.vanilladdition.block.entity.SmitherBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntityType{
    public static final BlockEntityType<SmitherBlockEntity> SMITHER = (BlockEntityType<SmitherBlockEntity>) registerBlockEntities("smither", SmitherBlockEntity::new, ModBlocks.SMITHER);


    private static BlockEntityType<?> registerBlockEntities(String id, BlockEntityType.BlockEntityFactory<?> factory, Block block){
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(VanillaAddition.MOD_ID, id), BlockEntityType.Builder.create(factory, block).build());
    }

    public static void registerBlockEntities(){}
}
