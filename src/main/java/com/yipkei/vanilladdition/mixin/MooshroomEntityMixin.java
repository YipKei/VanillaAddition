package com.yipkei.vanilladdition.mixin;

import com.yipkei.vanilladdition.util.ModTags;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Shearable;
import net.minecraft.entity.VariantHolder;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.MooshroomEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Deprecated
@Mixin(MooshroomEntity.class)
public abstract class MooshroomEntityMixin extends CowEntity
        implements Shearable, VariantHolder<MooshroomEntity.Type> {
    protected MooshroomEntityMixin(EntityType<? extends CowEntity> entityType, World world) {
        super(entityType, world);
    }



    @Shadow
    public abstract boolean isShearable();

    @Shadow public abstract void sheared(SoundCategory shearedSoundCategory);


    @Inject(method = "interactMob", at = @At("HEAD"), cancellable = true)
    private void checkSteelShears(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> ci){
        ItemStack itemStack = player.getStackInHand(hand);
        if (itemStack.isIn(ModTags.Items.SHEARS) && this.isShearable()){
            this.sheared(SoundCategory.PLAYERS);
            this.emitGameEvent(GameEvent.SHEAR, player);
            if (!this.getWorld().isClient) {
                itemStack.damage(1, player, getSlotForHand(hand));
            }
            ci.setReturnValue(ActionResult.success(this.getWorld().isClient));
        }
    }

//    /**
//     * @author YipKei
//     * @reason  The original method cannot accept custom Shears.
//     */
//    @Overwrite
//    public ActionResult interactMob(PlayerEntity player, Hand hand) {
//        ItemStack itemStack = player.getStackInHand(hand);
//        if (itemStack.isOf(Items.BOWL) && !this.isBaby()) {
//            boolean bl = false;
//            ItemStack itemStack2;
//            if (this.stewEffects != null) {
//                bl = true;
//                itemStack2 = new ItemStack(Items.SUSPICIOUS_STEW);
//                itemStack2.set(DataComponentTypes.SUSPICIOUS_STEW_EFFECTS, this.stewEffects);
//                this.stewEffects = null;
//            } else {
//                itemStack2 = new ItemStack(Items.MUSHROOM_STEW);
//            }
//
//            ItemStack itemStack3 = ItemUsage.exchangeStack(itemStack, player, itemStack2, false);
//            player.setStackInHand(hand, itemStack3);
//            SoundEvent soundEvent;
//            if (bl) {
//                soundEvent = SoundEvents.ENTITY_MOOSHROOM_SUSPICIOUS_MILK;
//            } else {
//                soundEvent = SoundEvents.ENTITY_MOOSHROOM_MILK;
//            }
//
//            this.playSound(soundEvent, 1.0F, 1.0F);
//            return ActionResult.success(this.getWorld().isClient);
//        } else if (itemStack.isIn(ModTags.Items.SHEARS) && this.isShearable()) {
//            this.sheared(SoundCategory.PLAYERS);
//            this.emitGameEvent(GameEvent.SHEAR, player);
//            if (!this.getWorld().isClient) {
//                itemStack.damage(1, player, getSlotForHand(hand));
//            }
//
//            return ActionResult.success(this.getWorld().isClient);
//        } else if (this.getVariant() == MooshroomEntity.Type.BROWN && itemStack.isIn(ItemTags.SMALL_FLOWERS)) {
//            if (this.stewEffects != null) {
//                for(int i = 0; i < 2; ++i) {
//                    this.getWorld().addParticle(ParticleTypes.SMOKE, this.getX() + this.random.nextDouble() / 2.0, this.getBodyY(0.5), this.getZ() + this.random.nextDouble() / 2.0, 0.0, this.random.nextDouble() / 5.0, 0.0);
//                }
//            } else {
//                Optional<SuspiciousStewEffectsComponent> optional = this.getStewEffectFrom(itemStack);
//                if (optional.isEmpty()) {
//                    return ActionResult.PASS;
//                }
//
//                itemStack.decrementUnlessCreative(1, player);
//
//                for(int j = 0; j < 4; ++j) {
//                    this.getWorld().addParticle(ParticleTypes.EFFECT, this.getX() + this.random.nextDouble() / 2.0, this.getBodyY(0.5), this.getZ() + this.random.nextDouble() / 2.0, 0.0, this.random.nextDouble() / 5.0, 0.0);
//                }
//
//                this.stewEffects = (SuspiciousStewEffectsComponent)optional.get();
//                this.playSound(SoundEvents.ENTITY_MOOSHROOM_EAT, 2.0F, 1.0F);
//            }
//
//            return ActionResult.success(this.getWorld().isClient);
//        } else {
//            return super.interactMob(player, hand);
//        }
//    }
}
