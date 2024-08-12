package com.yipkei.vanilladdition.block;

import com.yipkei.vanilladdition.util.ModTags;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class BlindBox extends Block {
    private final RegistryKey<LootTable> lootTable;
    public BlindBox(RegistryKey<LootTable> lootTable, Block baseBlock){
        super(AbstractBlock.Settings.copy(baseBlock));
        this.lootTable = lootTable;
    }

    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit){
        if (!stack.isIn(ModTags.Items.HAMMERS)){
            return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        }
        if (world.isClient){
            return ItemActionResult.success(world.isClient);
        }
        List<ItemStack> rewards = BlindBox.generateLoot((ServerWorld) world, this.lootTable, pos, player);
        if (rewards.isEmpty()) return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        world.setBlockState(pos, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL_AND_REDRAW);
        for (ItemStack reward : rewards){
            world.spawnEntity(new ItemEntity(world, pos.getX()+0.5d, pos.getY()+0.5d, pos.getZ()+0.5d, reward, 0d, 0.2d, 0d));
        }
        stack.damage(1, player, LivingEntity.getSlotForHand(hand));
        return ItemActionResult.success(world.isClient);
    }


    private static List<ItemStack> generateLoot(ServerWorld world, RegistryKey<LootTable> lootTableKey, BlockPos pos, PlayerEntity player) {
        LootTable lootTable = world.getServer().getReloadableRegistries().getLootTable(lootTableKey);
        LootContextParameterSet lootContextParameterSet = new LootContextParameterSet.Builder(world).add(LootContextParameters.ORIGIN, Vec3d.ofCenter(pos)).add(LootContextParameters.THIS_ENTITY, player).build(LootContextTypes.VAULT);
        return lootTable.generateLoot(lootContextParameterSet);
    }
}
