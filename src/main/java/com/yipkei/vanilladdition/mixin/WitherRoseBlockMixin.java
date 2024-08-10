package com.yipkei.vanilladdition.mixin;

import com.yipkei.vanilladdition.util.ModTags;
import net.minecraft.block.*;
import net.minecraft.component.type.SuspiciousStewEffectsComponent;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldAccess;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(WitherRoseBlock.class)
public abstract class WitherRoseBlockMixin extends FlowerBlock {

    public WitherRoseBlockMixin(RegistryEntry<StatusEffect> registryEntry, float f, AbstractBlock.Settings settings) {
        this(WitherRoseBlock.createStewEffectList(registryEntry, f), settings);
    }

    public WitherRoseBlockMixin(SuspiciousStewEffectsComponent suspiciousStewEffectsComponent, AbstractBlock.Settings settings) {
        super(suspiciousStewEffectsComponent, settings);
    }

    @Override
    protected BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos){
        BlockState floor = world.getBlockState(pos.down());
        return (state.canPlaceAt(world, pos) || floor.isIn(ModTags.Blocks.WITHER_ROSE_CAN_KEEP_ON)) ? state : Blocks.AIR.getDefaultState();
    }
}
