package com.yipkei.vanilladdition.mixin;

import com.yipkei.vanilladdition.util.ModTags;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Shearable;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.SheepEntity;
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

@Mixin(SheepEntity.class)
public abstract class SheepEntityMixin extends AnimalEntity implements Shearable {


    @Shadow public abstract boolean isShearable();

    @Shadow public abstract void sheared(SoundCategory shearedSoundCategory);

    protected SheepEntityMixin(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }



    @Inject(method = "interactMob", at = @At( value = "HEAD" ), cancellable = true)
    private void checkSteelShears(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> ci){
        ItemStack itemStack = player.getStackInHand(hand);
        if (itemStack.isIn(ModTags.Items.SHEARS)){
            if (!this.getWorld().isClient && this.isShearable()){
                this.sheared(SoundCategory.PLAYERS);
                this.emitGameEvent(GameEvent.SHEAR, player);
                itemStack.damage(1, player, getSlotForHand(hand));
                ci.setReturnValue(ActionResult.SUCCESS);
            }
        }
    }

//    /**
//     * @author YipKei
//     * @reason The original method cannot accept custom Shears.
//     */
//    @Overwrite
//    public ActionResult interactMob(PlayerEntity player, Hand hand){
//        ItemStack itemStack = player.getStackInHand(hand);
//        if (itemStack.isIn(ModTags.Items.SHEARS)) {
//            if (!this.getWorld().isClient && this.isShearable()) {
//                this.sheared(SoundCategory.PLAYERS);
//                this.emitGameEvent(GameEvent.SHEAR, player);
//                itemStack.damage(1, player, getSlotForHand(hand));
//                return ActionResult.SUCCESS;
//            } else {
//                return ActionResult.CONSUME;
//            }
//        } else {
//            return super.interactMob(player, hand);
//        }
//    }
}
