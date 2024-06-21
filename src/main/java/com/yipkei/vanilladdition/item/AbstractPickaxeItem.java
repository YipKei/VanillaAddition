package com.yipkei.vanilladdition.item;


import net.minecraft.block.Block;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.component.type.ToolComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

import java.util.List;

public class AbstractPickaxeItem extends ToolItem {

    private final int stackDamage;

    public AbstractPickaxeItem(ToolMaterial toolMaterial, TagKey<Block> specialBlocks, float specialMiningSpeed, int mineDamage, int stackDamage, Item.Settings settings){
        super(toolMaterial, settings.component(DataComponentTypes.TOOL, AbstractPickaxeItem.createToolComponent(specialBlocks,toolMaterial.getInverseTag(),specialMiningSpeed,toolMaterial.getMiningSpeedMultiplier(), mineDamage)));
        this.stackDamage = stackDamage;
    }

    private static ToolComponent createToolComponent(TagKey<Block> specialBlocks, TagKey<Block> inverseBlock, float specialMiningSpeed, float defaultMiningSpeed, int mineDamage){
        return new ToolComponent(List.of(ToolComponent.Rule.of(specialBlocks,specialMiningSpeed),ToolComponent.Rule.ofNeverDropping(inverseBlock),ToolComponent.Rule.ofAlwaysDropping(BlockTags.PICKAXE_MINEABLE,defaultMiningSpeed)),1f,mineDamage);
    }

    public static AttributeModifiersComponent createAttributeModifiers(ToolMaterial material, int baseAttackDamage, float attackSpeed) {
        return AttributeModifiersComponent.builder().add(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(BASE_ATTACK_DAMAGE_MODIFIER_ID, (float)baseAttackDamage + material.getAttackDamage(), EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND).add(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(BASE_ATTACK_SPEED_MODIFIER_ID, attackSpeed, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND).build();
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        return true;
    }

    @Override
    public void postDamageEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(this.stackDamage, attacker, EquipmentSlot.MAINHAND);
    }
}
