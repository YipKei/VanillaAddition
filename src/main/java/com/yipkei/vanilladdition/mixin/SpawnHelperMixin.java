package com.yipkei.vanilladdition.mixin;

import com.yipkei.vanilladdition.util.ModTags;
import net.minecraft.block.Blocks;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.SpawnHelper;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.structure.Structure;
import net.minecraft.world.gen.structure.StructureKeys;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(SpawnHelper.class)
public class SpawnHelperMixin {

    /**
     * @author YipKei
     * @reason  Add NetherFortress Spawn Blocks
     */
    @Overwrite
    public static boolean shouldUseNetherFortressSpawns(BlockPos pos, ServerWorld world, SpawnGroup spawnGroup, StructureAccessor structureAccessor) {
        if (spawnGroup != SpawnGroup.MONSTER || !world.getBlockState(pos.down()).isIn(ModTags.Blocks.NETHER_BRICKS)) {
            return false;
        }
        Structure structure = structureAccessor.getRegistryManager().get(RegistryKeys.STRUCTURE).get(StructureKeys.FORTRESS);
        if (structure == null) {
            return false;
        }
        return structureAccessor.getStructureAt(pos, structure).hasChildren();
    }
}
