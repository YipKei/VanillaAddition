package com.yipkei.vanilladdition.custom;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent ROASTED_ROTTEN_FLESH = new FoodComponent.Builder()
            .nutrition(1)
            .snack()
            .saturationModifier(0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA,20, 1),0.8f)
            .build();
}
