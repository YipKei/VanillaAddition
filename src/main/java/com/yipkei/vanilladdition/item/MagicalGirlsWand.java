package com.yipkei.vanilladdition.item;

import com.yipkei.vanilladdition.util.Head;
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
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.state.property.Properties;
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
                spawnHead(world, blockPos, playerHead);
            }
            player.addStatusEffect(new StatusEffectInstance(RegistryEntry.of(StatusEffects.INSTANT_DAMAGE.value()),1,4));
            return;
        }
        if (blockState.isOf(Blocks.REDSTONE_WIRE)){
            spawnHead(world, blockPos, Head.getPowerHead(blockState));
            return;
        }
        if (blockState.isOf(Blocks.LAVA_CAULDRON)){
            spawnHead(world, blockPos, Head.getBlockHead(Blocks.LAVA), Blocks.CAULDRON.getDefaultState());
            return;
        }
        if (blockState.isOf(Blocks.WATER_CAULDRON) && blockState.get(Properties.LEVEL_3)==3){
            spawnHead(world, blockPos, Head.getBlockHead(Blocks.WATER), Blocks.CAULDRON.getDefaultState());
            return;
        }
        ItemStack head = Head.getBlockHead(blockState.getBlock());
        if (head == null){
            return;
        }
        int chance = world.random.nextInt(10);
        if ((blockState.isOf(Blocks.BEDROCK)) || (blockState.isOf(Blocks.PISTON_HEAD) || (blockState.isOf(Blocks.REINFORCED_DEEPSLATE)))){
            if (chance == 0){
                player.kill();
                return;
            }else if (chance > 8){
                spawnHead(world, blockPos, head);
            }
            player.addStatusEffect(new StatusEffectInstance(RegistryEntry.of(StatusEffects.INSTANT_DAMAGE.value()),1,20));
            return;
        }
        if (blockState.isOf(Blocks.TNT)){
            if (chance > 8){
                spawnHead(world, blockPos, head);
                return;
            }
            TntEntity tntEntity = new TntEntity(world, (double)blockPos.getX() + 0.5, blockPos.getY(), (double)blockPos.getZ() + 0.5, player);
            int i = tntEntity.getFuse();
            tntEntity.setFuse((short)(world.random.nextInt(i / 4) + i / 8));
            world.spawnEntity(tntEntity);
            return;
        }
        if (blockState.isOf(Blocks.TURTLE_EGG)){
            if (chance <= 8 ){
                world.setBlockState(blockPos, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL_AND_REDRAW);
                return;
            }
        }
        spawnHead(world,blockPos,head);
    }

    private static void spawnHead(World world, BlockPos pos, ItemStack head){
        spawnHead(world, pos, head, Blocks.AIR.getDefaultState());
    }

    private static void spawnHead(World world, BlockPos pos, ItemStack head, BlockState blockState){
        ItemEntity headEntity = new ItemEntity(world, pos.getX(), pos.getY(),pos.getZ(),head);
        headEntity.setVelocity(0,0.5,0);
        world.setBlockState(pos, blockState, Block.NOTIFY_ALL_AND_REDRAW);
        world.spawnEntity(headEntity);
    }
}
