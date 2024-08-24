package com.yipkei.vanilladdition.block;

import com.mojang.serialization.MapCodec;
import com.yipkei.vanilladdition.block.entity.SmitherBlockEntity;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.enums.Orientation;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.SmithingRecipe;
import net.minecraft.recipe.input.SmithingRecipeInput;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class SmitherBlock extends BlockWithEntity {

    public static final MapCodec<SmitherBlock> CODEC = SmitherBlock.createCodec(SmitherBlock::new);
    public static final BooleanProperty SMITHING = Properties.CRAFTING;
    public static final BooleanProperty TRIGGERED = Properties.TRIGGERED;
    private static final EnumProperty<Orientation> ORIENTATION = Properties.ORIENTATION;

    private static final int TRIGGER_DELAY = 4;

    public SmitherBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(ORIENTATION, Orientation.NORTH_UP).with(TRIGGERED, false).with(SMITHING, false));
    }

    protected MapCodec<SmitherBlock> getCodec(){ return CODEC; }

    @Override
    protected boolean hasComparatorOutput(BlockState state) { return true; }

    private void setTriggered(@Nullable BlockEntity blockEntity, boolean triggered) {
        if (blockEntity instanceof SmitherBlockEntity smitherBlockEntity) {
            smitherBlockEntity.setTriggered(triggered);
        }
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        SmitherBlockEntity smitherBlockEntity = new SmitherBlockEntity(pos, state);
        smitherBlockEntity.setTriggered(state.contains(TRIGGERED) && state.get(TRIGGERED));
        return smitherBlockEntity;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        Direction direction = ctx.getPlayerLookDirection().getOpposite();
        Direction direction2 = switch (direction) {
            default -> throw new MatchException(null, null);
            case UP -> ctx.getHorizontalPlayerFacing();
            case DOWN -> ctx.getHorizontalPlayerFacing().getOpposite();
            case EAST, SOUTH, WEST, NORTH -> Direction.UP;
        };
        return this.getDefaultState().with(ORIENTATION, Orientation.byDirections(direction, direction2)).with(TRIGGERED, ctx.getWorld().isReceivingRedstonePower(ctx.getBlockPos()));
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
        if (state.get(TRIGGERED)) {
            world.scheduleBlockTick(pos, this, TRIGGER_DELAY);
        }
    }

    @Override
    protected void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        boolean bl = world.isReceivingRedstonePower(pos);
        boolean bl2 = state.get(TRIGGERED);
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (bl && !bl2) {
            world.scheduleBlockTick(pos, this, TRIGGER_DELAY);
            world.setBlockState(pos, state.with(TRIGGERED, true), Block.NOTIFY_LISTENERS);
            this.setTriggered(blockEntity, true);
        } else if (!bl && bl2) {
            while (world.setBlockState(pos, state.with(TRIGGERED, false).with(SMITHING, false), Block.NOTIFY_LISTENERS));
            this.setTriggered(blockEntity, false);
        }
    }

    @Override
    protected void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random){
        this.smith(state, world, pos);
    }

    protected void smith(BlockState state, ServerWorld world, BlockPos pos) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (!(blockEntity instanceof SmitherBlockEntity smitherBlockEntity)) return;
        SmithingRecipeInput smithingRecipeInput = new SmithingRecipeInput(((SmitherBlockEntity) blockEntity).getStack(0), ((SmitherBlockEntity) blockEntity).getStack(1), ((SmitherBlockEntity) blockEntity).getStack(2));
        Optional<RecipeEntry<SmithingRecipe>> optional = SmitherBlock.getSmithingRecipe(world, smithingRecipeInput);
    }

    public static Optional<RecipeEntry<SmithingRecipe>> getSmithingRecipe(World world, SmithingRecipeInput input) {
        if (input.isEmpty()) return Optional.empty();

        return null;
    }
}
