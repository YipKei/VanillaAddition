package com.yipkei.vanilladdition.entity;

import com.yipkei.vanilladdition.init.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.fluid.FluidState;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtHelper;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.TeleportTarget;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import net.minecraft.world.explosion.ExplosionBehavior;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class EnderTntEntity extends Entity implements Ownable{

    private static final TrackedData<Integer> FUSE = DataTracker.registerData(EnderTntEntity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<BlockState> BLOCK_STATE = DataTracker.registerData(EnderTntEntity.class, TrackedDataHandlerRegistry.BLOCK_STATE);
    private static final int DEFAULT_FUSE = 40;
    public static final String FUSE_NBT_KEY = "fuse";
    private static final String BLOCK_STATE_NBT_KEY = "block_state";
    private static final ExplosionBehavior TELEPORTED_EXPLOSION_BEHAVIOR = new ExplosionBehavior() {
        @Override
        public boolean canDestroyBlock(Explosion explosion, BlockView world, BlockPos pos, BlockState state, float power) {
            if (state.isOf(Blocks.NETHER_PORTAL)) {
                return false;
            }
            return super.canDestroyBlock(explosion, world, pos, state, power);
        }

        @Override
        public Optional<Float> getBlastResistance(Explosion explosion, BlockView world, BlockPos pos, BlockState blockState, FluidState fluidState) {
            if (blockState.isOf(Blocks.NETHER_PORTAL)) {
                return Optional.empty();
            }
            return super.getBlastResistance(explosion, world, pos, blockState, fluidState);
        }
    };

    private LivingEntity causingEntity;
    private boolean teleported;
    private Direction facing;

    public EnderTntEntity(EntityType<? extends TntEntity> entityType, World world, Direction facing) {
        super(entityType, world);
        this.facing = facing;
    }

    public EnderTntEntity(World world, double x, double y, double z, @Nullable LivingEntity igniter, Direction facing) {
        this((EntityType<? extends TntEntity>)EntityType.TNT, world, facing);
        this.setPosition(x, y, z);
        this.setVelocity(0f, 0.2f, 0f);
        this.setFuse(DEFAULT_FUSE);
        this.prevX = x;
        this.prevY = y;
        this.prevZ = z;
        this.causingEntity = igniter;
        this.facing = facing;
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder){
        builder.add(FUSE, DEFAULT_FUSE);
        builder.add(BLOCK_STATE, ModBlocks.ENDER_TNT.getDefaultState());
    }

    @Override
    public void tick(){
        this.tickPortalTeleportation();
        this.applyGravity();
        this.move(MovementType.SELF, this.getVelocity());
        this.setVelocity(this.getVelocity().multiply(0.98));
        if (this.isOnGround()) {
            this.setVelocity(this.getVelocity().multiply(0.7, -0.5, 0.7));
        }
        int i = this.getFuse() - 1;
        this.setFuse(i);
        if (i <= 0) {
            this.discard();
            if (!this.getWorld().isClient) {
                this.explode();
            }
        } else {
            this.updateWaterState();
            if (this.getWorld().isClient) {
                this.getWorld().addParticle(ParticleTypes.SMOKE, this.getX(), this.getY() + 0.5, this.getZ(), 0.0, 0.0, 0.0);
            }
        }
    }

    private void explode() {
        BlockPos pos = this.getBlockPos();
        World world = this.getWorld();
        if (world.getBlockState(pos).isAir()){
            pos = pos.offset(this.facing,1);
        }
        float destroyPower = 10000f;
        for (int i=10; i>0; i--){
            float resistance = world.getBlockState(pos).getBlock().getBlastResistance();
            destroyPower = destroyPower / ((resistance == 0F) ? 1 : resistance);
            if (destroyPower > 10000) destroyPower = 10000f;
            world.removeBlock(pos, false);
            pos = pos.offset(this.facing,1);
            if (destroyPower < 1.0F) break;
        }
        float power = 4.0f;
        this.getWorld().createExplosion(this, Explosion.createDamageSource(this.getWorld(), this), this.teleported ? TELEPORTED_EXPLOSION_BEHAVIOR : null, this.getX(), this.getBodyY(0.0625), this.getZ(), power, false, World.ExplosionSourceType.TNT);
    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {
        nbt.putShort(FUSE_NBT_KEY, (short)this.getFuse());
        nbt.put(BLOCK_STATE_NBT_KEY, NbtHelper.fromBlockState(this.getBlockState()));
    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {
        this.setFuse(nbt.getShort(FUSE_NBT_KEY));
        if (nbt.contains(BLOCK_STATE_NBT_KEY, NbtElement.COMPOUND_TYPE)) {
            this.setBlockState(NbtHelper.toBlockState(this.getWorld().createCommandRegistryWrapper(RegistryKeys.BLOCK), nbt.getCompound(BLOCK_STATE_NBT_KEY)));
        }
    }

    @Override
    @Nullable
    public LivingEntity getOwner() {
        return this.causingEntity;
    }

    @Override
    public void copyFrom(Entity original) {
        super.copyFrom(original);
        if (original instanceof TntEntity) {
            EnderTntEntity enderTntEntity = (EnderTntEntity)original;
            this.causingEntity = enderTntEntity.causingEntity;
        }
    }

    private void setTeleported(boolean teleported) {
        this.teleported = teleported;
    }

    public void setFuse(int fuse) {
        this.dataTracker.set(FUSE, fuse);
    }

    public int getFuse() {
        return this.dataTracker.get(FUSE);
    }

    public void setBlockState(BlockState state) {
        this.dataTracker.set(BLOCK_STATE, state);
    }

    public BlockState getBlockState() {
        return this.dataTracker.get(BLOCK_STATE);
    }

    @Override
    protected double getGravity() {
        return 0.04;
    }

    @Override
    @Nullable
    public Entity teleportTo(TeleportTarget teleportTarget) {
        Entity entity = super.teleportTo(teleportTarget);
        if (entity instanceof TntEntity) {
            EnderTntEntity enderTntEntity = (EnderTntEntity)entity;
            enderTntEntity.setTeleported(true);
        }
        return entity;
    }
}
