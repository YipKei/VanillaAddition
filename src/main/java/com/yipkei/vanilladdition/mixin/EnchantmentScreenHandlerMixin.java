package com.yipkei.vanilladdition.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalRef;
import com.yipkei.vanilladdition.util.ModTags;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.entity.mob.WardenEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.screen.EnchantmentScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import static com.yipkei.vanilladdition.helper.ModEnchantmentHelper.*;
import static com.yipkei.vanilladdition.settings.VanillaAdditionSettings.wanderAffectsEnchantingTable;

@Mixin(EnchantmentScreenHandler.class)
public class EnchantmentScreenHandlerMixin {

    @Shadow
    @Final
    private ScreenHandlerContext context;

    @Inject(method = "generateEnchantments", at = @At(value = "INVOKE", target = "Ljava/util/Optional;isEmpty()Z"))
    private void hackEnchantment(DynamicRegistryManager registryManager, ItemStack stack, int slot, int level, CallbackInfoReturnable<List<EnchantmentLevelEntry>> cir, @Local LocalRef<Optional<RegistryEntryList.Named<Enchantment>>> optionalLocalRef){
        if (wanderAffectsEnchantingTable) {
            boolean hasWardenNearBy = context.get(((world, blockPos) -> {
                Box box = new Box(blockPos).expand(MAX_WARDEN_DISTANCE_FOR_SWIFT_SNEAK);
                Vec3d tablePos = Vec3d.ofBottomCenter(blockPos).offset(Direction.UP, 0.375);
                Predicate<WardenEntity> rangePredicate = e -> e.getPos().isInRange(tablePos, MAX_WARDEN_DISTANCE_FOR_SWIFT_SNEAK);
                List<WardenEntity> wardenEntities = world.getEntitiesByClass(WardenEntity.class, box, rangePredicate);
                return !wardenEntities.isEmpty();
            })).get();
            if (hasWardenNearBy) {
                optionalLocalRef.set(registryManager.get(RegistryKeys.ENCHANTMENT).getEntryList(ModTags.Enchantments.WANDER_NEARBY));
            }
        }
    }
}
