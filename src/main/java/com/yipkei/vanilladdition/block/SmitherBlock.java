package com.yipkei.vanilladdition.block;

import com.mojang.serialization.MapCodec;
import com.yipkei.vanilladdition.block.entity.SmitherBlockEntity;
import com.yipkei.vanilladdition.init.ModBlockEntityType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.dispenser.ItemDispenserBehavior;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.HopperBlockEntity;
import net.minecraft.block.enums.Orientation;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.SmithingRecipe;
import net.minecraft.recipe.input.SmithingRecipeInput;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class SmitherBlock extends BlockWithEntity {

    public static final MapCodec<SmitherBlock> CODEC = SmitherBlock.createCodec(SmitherBlock::new);
    public static final BooleanProperty SMITHING = Properties.CRAFTING;
    public static final BooleanProperty TRIGGERED = Properties.TRIGGERED;
    private static final EnumProperty<Orientation> ORIENTATION = Properties.ORIENTATION;

    private static final int TRIGGER_DELAY = 4;

    public SmitherBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(ORIENTATION, Orientation.NORTH_UP).with(TRIGGERED, false).with(SMITHING, false));
    }

    protected MapCodec<SmitherBlock> getCodec(){ return CODEC; }

    @Override
    protected boolean hasComparatorOutput(BlockState state) { return true; }

    @Override
    protected int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof SmitherBlockEntity smitherBlockEntity) {
            return smitherBlockEntity.getComparatorOutput();
        }
        return 0;
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
            world.setBlockState(pos, state.with(TRIGGERED, false).with(SMITHING, false), Block.NOTIFY_LISTENERS);
            this.setTriggered(blockEntity, false);
        }
    }

    @Override
    protected void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random){
        this.smith(state, world, pos);
    }

    @Override
    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return world.isClient ? null : SmitherBlock.validateTicker(type, ModBlockEntityType.SMITHER, SmitherBlockEntity::tickSmithing);
    }

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
    protected void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        ItemScatterer.onStateReplaced(state, newState, world, pos);
        super.onStateReplaced(state, world, pos, newState, moved);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (world.isClient) {
            return ActionResult.SUCCESS;
        }
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof SmitherBlockEntity) {
            player.openHandledScreen((SmitherBlockEntity)blockEntity);
        }
        return ActionResult.CONSUME;
    }

    protected void smith(BlockState state, ServerWorld world, BlockPos pos) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (!(blockEntity instanceof SmitherBlockEntity smitherBlockEntity)) return;
        SmithingRecipeInput smithingRecipeInput = new SmithingRecipeInput(((SmitherBlockEntity) blockEntity).getStack(0), ((SmitherBlockEntity) blockEntity).getStack(1), ((SmitherBlockEntity) blockEntity).getStack(2));
        Optional<RecipeEntry<SmithingRecipe>> optional = SmitherBlock.getSmithingRecipe(world, smithingRecipeInput);
        if (optional.isEmpty()) {
            world.syncWorldEvent(WorldEvents.CRAFTER_FAILS, pos, 0);
            return;
        }
        RecipeEntry<SmithingRecipe> recipeEntry = optional.get();
        ItemStack itemStack = recipeEntry.value().craft(smithingRecipeInput, world.getRegistryManager());
        if (itemStack.isEmpty()) {
            world.syncWorldEvent(WorldEvents.CRAFTER_FAILS, pos, 0);
            return;
        }
        smitherBlockEntity.setSmithingTicksRemaining(6);
        world.setBlockState(pos, state.with(SMITHING, true), Block.NOTIFY_LISTENERS);
        itemStack.onCraftByCrafter(world);
        this.transferOrSpawnStack(world, pos, smitherBlockEntity, itemStack, state, recipeEntry);
        int i = -1;
        for (ItemStack itemStack2 : recipeEntry.value().getRemainder(smithingRecipeInput)) {
            i++;
            if (itemStack2.isEmpty() || itemStack2.isOf(smithingRecipeInput.getStackInSlot(i).getItem())) continue;
            this.transferOrSpawnStack(world, pos, smitherBlockEntity, itemStack2, state, recipeEntry);
        }
        smitherBlockEntity.getHeldStacks().forEach(stack -> {
            if (stack.isEmpty()) {
                return;
            }
            if (stack.getRecipeRemainder().isOf(stack.getItem())){
                stack.setDamage(stack.getRecipeRemainder().getDamage());
                return;
            }
            stack.decrement(1);
        });
        smitherBlockEntity.markDirty();
    }

    public static Optional<RecipeEntry<SmithingRecipe>> getSmithingRecipe(World world, SmithingRecipeInput input) {
        List<RecipeEntry<SmithingRecipe>> list = world.getRecipeManager().getAllMatches(RecipeType.SMITHING, input, world);
        if (list.isEmpty()) return Optional.empty();
        return Optional.ofNullable(list.getFirst());
    }

    private void transferOrSpawnStack(ServerWorld world, BlockPos pos, SmitherBlockEntity blockEntity, ItemStack stack, BlockState state, RecipeEntry<SmithingRecipe> recipe) {
        Direction direction = state.get(ORIENTATION).getFacing();
        Inventory inventory = HopperBlockEntity.getInventoryAt(world, pos.offset(direction));
        ItemStack itemStack = stack.copy();
        if (inventory != null && (inventory instanceof SmitherBlockEntity || stack.getCount() > inventory.getMaxCount(stack))) {
            ItemStack itemStack2;
            ItemStack itemStack3;
            while (!itemStack.isEmpty() && (itemStack3 = HopperBlockEntity.transfer(blockEntity, inventory, itemStack2 = itemStack.copyWithCount(1), direction.getOpposite())).isEmpty()) {
                itemStack.decrement(1);
            }
        } else if (inventory != null) {
            int i ;
            while (!itemStack.isEmpty() && (i = itemStack.getCount()) != (itemStack = HopperBlockEntity.transfer(blockEntity, inventory, itemStack, direction.getOpposite())).getCount()){
            }
        }
        if (!itemStack.isEmpty()) {
            Vec3d vec3d = Vec3d.ofCenter(pos);
            Vec3d vec3d2 = vec3d.offset(direction, 0.7);
            ItemDispenserBehavior.spawnItem(world, itemStack, 6, direction, vec3d2);
        }
        world.syncWorldEvent(WorldEvents.CRAFTER_CRAFTS, pos, 0);
        world.syncWorldEvent(WorldEvents.CRAFTER_SHOOTS, pos, direction.getId());
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) { return BlockRenderType.MODEL; }

    @Override
    protected BlockState rotate(BlockState state, BlockRotation rotation) {
        return (BlockState)state.with(ORIENTATION, rotation.getDirectionTransformation().mapJigsawOrientation(state.get(ORIENTATION)));
    }

    @Override
    protected BlockState mirror(BlockState state, BlockMirror mirror) {
        return (BlockState)state.with(ORIENTATION, mirror.getDirectionTransformation().mapJigsawOrientation(state.get(ORIENTATION)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder){
        builder.add(ORIENTATION, TRIGGERED, SMITHING);
    }
}
