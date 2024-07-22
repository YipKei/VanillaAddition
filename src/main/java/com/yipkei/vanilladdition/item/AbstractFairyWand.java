package com.yipkei.vanilladdition.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import static com.yipkei.vanilladdition.settings.VanillaAdditionSettings.enableFairyWoodPunishment;


public class AbstractFairyWand extends Item {
    private final TagKey<Block> applyBlocks;

    public AbstractFairyWand(Settings settings, TagKey<Block> applyBlocks) {
        super(settings);
        this.applyBlocks = applyBlocks;
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    @Override
    public boolean isEnchantable(ItemStack stack) { return false; }

    public ActionResult useOnBlock(ItemUsageContext context){
        World world = context.getWorld();
        if (world.isClient){
            return ActionResult.SUCCESS;
        }
        BlockPos blockPos = context.getBlockPos();
        PlayerEntity playerEntity = context.getPlayer();
        BlockState blockState = context.getWorld().getBlockState(blockPos);
        if (blockState.isIn(applyBlocks)){
            replaceOrDrop(world, blockPos, blockState, playerEntity);
            context.getStack().damage(1, (LivingEntity) playerEntity, LivingEntity.getSlotForHand(playerEntity.getActiveHand()));
        }
        return ActionResult.SUCCESS;
    }


    protected void replaceOrDrop(World world, BlockPos blockPos, BlockState blockState, PlayerEntity player) {}

    protected static void createExplosionBySkull(World world, BlockPos blockPos){
        world.playSound(null, blockPos, SoundEvents.BLOCK_STONE_BREAK, SoundCategory.BLOCKS, 1.0f, 1.0f);
        world.setBlockState(blockPos, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL_AND_REDRAW);
        if (enableFairyWoodPunishment) {
            world.createExplosion(null, blockPos.getX(), blockPos.getY() + 0.5, blockPos.getZ(), world.random.nextBetween(60, 101) / 10F, false, World.ExplosionSourceType.BLOCK);
        }
    }

    protected static int checkManhattanDistance(World world, BlockPos blockPos, Block block, int maxDistance){
        int distance = 0;
        boolean hasBlock = true;
        do {
            if (distance>=maxDistance) hasBlock = false;
            for (int i=1; i <= distance+1; i++ ){
                int j = distance + 1 - i;
                    if (!world.getBlockState(blockPos.north(i).east(j)).isOf(block)) {hasBlock = false; break;}
                    if (!world.getBlockState(blockPos.east(i).south(j)).isOf(block)) {hasBlock = false; break;}
                    if (!world.getBlockState(blockPos.south(i).west(j)).isOf(block)) {hasBlock = false; break;}
                    if (!world.getBlockState(blockPos.west(i).north(j)).isOf(block)) {hasBlock = false; break;}
            }
            if (hasBlock) distance++;
        }while (hasBlock);
        return distance;
    }

    protected static int checkChebyshevDistance(World world, BlockPos blockPos, Block block, int maxDistance){
        int distance = 0;
        boolean hasBlock = true;
        do {
            if (distance>=maxDistance) hasBlock = false;
            for (int i=1; i <= distance+1; i++ ){
                for (int j = -i; j <= i; j++) {
                    if (!world.getBlockState(blockPos.north(i).east(j)).isOf(block)) {hasBlock = false; break;}
                    if (!world.getBlockState(blockPos.east(i).south(j)).isOf(block)) {hasBlock = false; break;}
                    if (!world.getBlockState(blockPos.south(i).west(j)).isOf(block)) {hasBlock = false; break;}
                    if (!world.getBlockState(blockPos.west(i).north(j)).isOf(block)) {hasBlock = false; break;}
                }
            }
            if (hasBlock) distance++;
        }while (hasBlock);
        return distance;
    }

    protected static void playerPunishment(PunishmentType type, World world, PlayerEntity player, int multiplier){
        if (!enableFairyWoodPunishment) return;
        switch (type) {
            case EXPLOSION: world.createExplosion(null, player.getX(), player.getY() + 0.5, player.getZ(), world.random.nextBetween(60, 61 + multiplier*10) / 10F, false, World.ExplosionSourceType.BLOCK);
            case INSTANT_DAMAGE: player.addStatusEffect(new StatusEffectInstance(RegistryEntry.of(StatusEffects.INSTANT_DAMAGE.value()),1, multiplier));
        }
    }

    protected enum PunishmentType{
        EXPLOSION,
        INSTANT_DAMAGE,
    }
}

