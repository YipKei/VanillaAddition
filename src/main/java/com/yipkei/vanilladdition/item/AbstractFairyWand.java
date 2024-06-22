package com.yipkei.vanilladdition.item;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.mojang.authlib.properties.PropertyMap;
import com.yipkei.vanilladdition.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;


public class AbstractFairyWand extends Item {
    public AbstractFairyWand(Settings settings) {
        super(settings);
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
        if (blockState.isIn(ModTags.Blocks.FAIRY_WAND_REPLACEABLE)){
            replaceOrDropHead(world, blockPos, blockState, playerEntity);
            context.getStack().damage(100, context.getPlayer(), EquipmentSlot.MAINHAND);
        }
        return ActionResult.SUCCESS;
    }

    protected void replaceOrDropHead(World world, BlockPos blockPos, BlockState blockState, PlayerEntity player){
        if (blockState.isOf(Blocks.WITHER_SKELETON_SKULL) || blockState.isOf(Blocks.WITHER_SKELETON_WALL_SKULL)){
            world.playSound(null, blockPos, SoundEvents.ENTITY_DRAGON_FIREBALL_EXPLODE, SoundCategory.BLOCKS, 1.0f, 1.0f);
            world.setBlockState(blockPos, Blocks.DRAGON_HEAD.getDefaultState(), Block.NOTIFY_ALL_AND_REDRAW);
        }
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

    private static @NotNull String getTextures(PlayerEntity player) {
        GameProfile gameProfile = player.getGameProfile();
        PropertyMap properties = gameProfile.getProperties();
        String texturePropertyValue = "";
        for (Property textureProperty : properties.get("textures")) {
            if (textureProperty.name().equals("textures")) {
                texturePropertyValue = textureProperty.value();
                break;
            }
        }
        return "ewogICJ0aW1lc3RhbXAiIDogMCwKICAicHJvZmlsZUlk" + texturePropertyValue.split("cHJvZmlsZUlk")[1];
    }
}

