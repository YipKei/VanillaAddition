package com.yipkei.vanilladdition.item;

import com.yipkei.vanilladdition.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


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


    protected void replaceOrDrop(World world, BlockPos blockPos, BlockState blockState, PlayerEntity player){
//        if (blockState.isOf(Blocks.WITHER_SKELETON_SKULL) || blockState.isOf(Blocks.WITHER_SKELETON_WALL_SKULL)){
//            world.playSound(null, blockPos, SoundEvents.ENTITY_DRAGON_FIREBALL_EXPLODE, SoundCategory.BLOCKS, 1.0f, 1.0f);
//            world.setBlockState(blockPos, Blocks.DRAGON_HEAD.getDefaultState(), Block.NOTIFY_ALL_AND_REDRAW);
//        }
//        if (blockState.isOf(Blocks.CREEPER_HEAD) || blockState.isOf(Blocks.CREEPER_WALL_HEAD)){
//            LightningEntity lightningEntity = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
//            lightningEntity.setPos(blockPos.getX(),blockPos.getY(),blockPos.getZ());
//            world.spawnEntity(lightningEntity);
//        }
//        if (blockState.isOf(Blocks.SKELETON_SKULL) || blockState.isOf(Blocks.SKELETON_WALL_SKULL)){
//            world.playSound(null, blockPos, SoundEvents.ENTITY_SKELETON_STEP, SoundCategory.BLOCKS, 1.0f, 1.0f);
//            world.setBlockState(blockPos, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL_AND_REDRAW);
//            AbstractSkeletonEntity skeleton = EntityType.SKELETON.create(world);
//            world.spawnEntity(skeleton);
//        }
//        if (blockState.isOf(Blocks.ZOMBIE_HEAD) || blockState.isOf(Blocks.ZOMBIE_WALL_HEAD)){
//            UUID uuid = player.getUuid();
//            String textures = getTextures(player);
//            world.playSound(null, blockPos, SoundEvents.ENTITY_ZOMBIE_AMBIENT, SoundCategory.BLOCKS, 1.0f, 1.0f);
//            world.setBlockState(blockPos, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL_AND_REDRAW);
//            ItemStack stack = new Head( uuid ,textures).createStack();
//            ItemEntity itemEntity = new ItemEntity(world, (double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.1, (double)blockPos.getZ() + 0.5 , stack);
//            world.spawnEntity(itemEntity);
//        }
    }

    protected static void createExplosionBySkull(World world, BlockPos blockPos){
        world.playSound(null, blockPos, SoundEvents.BLOCK_STONE_BREAK, SoundCategory.BLOCKS, 1.0f, 1.0f);
        world.setBlockState(blockPos, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL_AND_REDRAW);
        world.createExplosion(null,blockPos.getX(),blockPos.getY()+0.5,blockPos.getZ(),10.0f, false,World.ExplosionSourceType.BLOCK);
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
                    if (!world.getBlockState(blockPos.north(i).east(j)).isOf(block)) {
                        hasBlock = false;
                        break;
                    }
                    if (!world.getBlockState(blockPos.east(i).south(j)).isOf(block)) {
                        hasBlock = false;
                        break;
                    }
                    if (!world.getBlockState(blockPos.south(i).west(j)).isOf(block)) {
                        hasBlock = false;
                        break;
                    }
                    if (!world.getBlockState(blockPos.west(i).north(j)).isOf(block)) {
                        hasBlock = false;
                        break;
                    }
                }
            }
            if (hasBlock) distance++;
        }while (hasBlock);
        return distance;
    }
}

