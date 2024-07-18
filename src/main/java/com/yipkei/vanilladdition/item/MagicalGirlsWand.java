package com.yipkei.vanilladdition.item;

import com.yipkei.vanilladdition.util.Head;
import com.yipkei.vanilladdition.util.Heads;
import com.yipkei.vanilladdition.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.state.property.Properties;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableTextContent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MagicalGirlsWand extends AbstractFairyWand{
    public MagicalGirlsWand(Settings settings)
    {
        super(settings,ModTags.Blocks.MAGICAL_GIRLS_AFFECTABLE);
    }

    @Override
    protected void replaceOrDrop(World world, BlockPos blockPos, BlockState blockState, PlayerEntity player){
        if ((blockState.isOf(Blocks.ZOMBIE_HEAD)) || (blockState.isOf(Blocks.ZOMBIE_WALL_HEAD))){
            ItemStack playerHead = Head.getNewPlayerHead(player.getGameProfile(),"",1);
            if (playerHead!=null){
                ItemEntity playerHeadItem = new ItemEntity(world, blockPos.getX(),blockPos.getY(),blockPos.getZ(), playerHead);
                playerHeadItem.setVelocity(0,0.5,0);
                world.setBlockState(blockPos,Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL_AND_REDRAW);
                world.spawnEntity(playerHeadItem);
            }
            player.addStatusEffect(new StatusEffectInstance(RegistryEntry.of(StatusEffects.INSTANT_DAMAGE.value()),1,4));
            return;
        }
        if (blockState.isOf(Blocks.REDSTONE_WIRE)){
            int redstoneIndex;
            if (blockState.getOrEmpty(Properties.POWER).isPresent()){
                redstoneIndex = blockState.get(Properties.POWER);
                ItemStack redstoneHead = Head.getTexturedHead("RedstoneHead_"+Integer.toHexString(redstoneIndex).toUpperCase(), Heads.redstoneHeadTextureList.get(redstoneIndex), Heads.redstoneHeadUUIDList.get(redstoneIndex),"", 1, MutableText.of(new TranslatableTextContent("RedstoneHead_",null,TranslatableTextContent.EMPTY_ARGUMENTS)).append(Integer.toHexString(redstoneIndex).toUpperCase()));
                ItemEntity redstoneHeadItem = new ItemEntity(world, blockPos.getX(), blockPos.getY(), blockPos.getZ(), redstoneHead);
                redstoneHeadItem.setVelocity(0, 0.5, 0);
                world.setBlockState(blockPos, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL_AND_REDRAW);
                world.spawnEntity(redstoneHeadItem);
            }
            return;
        }
        if (blockState.isOf(Blocks.LAVA_CAULDRON)){
            ItemStack lavaHead = Head.getTexturedHead(Registries.BLOCK.getId(Blocks.LAVA).getPath(), Heads.textureList.get(Blocks.LAVA_CAULDRON), Heads.uuidList.get(Blocks.LAVA_CAULDRON), "", 1, Blocks.LAVA.getName());
            ItemEntity blockHeadItem = new ItemEntity(world, blockPos.getX(), blockPos.getY(), blockPos.getZ(), lavaHead);
            blockHeadItem.setVelocity(0, 0.5, 0);
            world.setBlockState(blockPos, Blocks.CAULDRON.getDefaultState(), Block.NOTIFY_ALL_AND_REDRAW);
            world.spawnEntity(blockHeadItem);
        }
        if (blockState.isOf(Blocks.WATER_CAULDRON)){
            ItemStack waterHead = Head.getTexturedHead(Registries.BLOCK.getId(Blocks.WATER).getPath(), Heads.textureList.get(Blocks.WATER_CAULDRON), Heads.uuidList.get(Blocks.WATER_CAULDRON), "", 1, Blocks.WATER.getName());
            ItemEntity blockHeadItem = new ItemEntity(world, blockPos.getX(), blockPos.getY(), blockPos.getZ(), waterHead);
            blockHeadItem.setVelocity(0, 0.5, 0);
            world.setBlockState(blockPos, Blocks.CAULDRON.getDefaultState(), Block.NOTIFY_ALL_AND_REDRAW);
            world.spawnEntity(blockHeadItem);
        }
        Block block = blockState.getBlock();
        if (Heads.uuidList.containsKey(block)) {
            ItemStack blockHead = Head.getTexturedHead(Registries.BLOCK.getId(block).getPath(), Heads.textureList.get(block), Heads.uuidList.get(block), "", 1, block.getName());
            ItemEntity blockHeadItem = new ItemEntity(world, blockPos.getX(), blockPos.getY(), blockPos.getZ(), blockHead);
            blockHeadItem.setVelocity(0, 0.5, 0);
            if ((blockState.isOf(Blocks.BEDROCK)) || (blockState.isOf(Blocks.PISTON_HEAD) || (blockState.isOf(Blocks.REINFORCED_DEEPSLATE)))){
                if (world.random.nextInt(10)>8){
                    world.setBlockState(blockPos, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL_AND_REDRAW);
                    world.spawnEntity(blockHeadItem);
                }
                player.addStatusEffect(new StatusEffectInstance(RegistryEntry.of(StatusEffects.INSTANT_DAMAGE.value()),1,20));
                if (world.random.nextInt(10) == 0){
                    player.kill();
                }
                return;
            }
            world.setBlockState(blockPos, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL_AND_REDRAW);
            if (blockState.isOf(Blocks.TNT)){
                if (world.random.nextInt(10)>8){
                    world.spawnEntity(blockHeadItem);
                    return;
                }
                TntEntity tntEntity = new TntEntity(world, (double)blockPos.getX() + 0.5, blockPos.getY(), (double)blockPos.getZ() + 0.5, player);
                int i = tntEntity.getFuse();
                tntEntity.setFuse((short)(world.random.nextInt(i / 4) + i / 8));
                world.spawnEntity(tntEntity);
                return;
            }
            if (blockState.isOf(Blocks.TURTLE_EGG)){
                if (world.random.nextInt(10)<8){
                    return;
                }
            }
            world.spawnEntity(blockHeadItem);
        }
    }
}
