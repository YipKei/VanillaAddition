package com.yipkei.vanilladdition.custom;

import com.google.common.base.Suppliers;
import com.yipkei.vanilladdition.init.ModItems;
import com.yipkei.vanilladdition.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

import java.util.Objects;
import java.util.function.Supplier;


public enum ModToolMaterials implements ToolMaterial {
    /** 钢制工具/武器：铁的采掘等级，更高的耐久*/
    STEEL(BlockTags.INCORRECT_FOR_IRON_TOOL, 600, 6.5F, 2.5F, 12, () -> Ingredient.ofItems(ModItems.STEEL_INGOT)),
    /** 碎钻强化材质：钻石采掘等级，耐久比钻石工具低，通过模板升级钢质工具得到*/
    DIAMOND_SHARD(BlockTags.INCORRECT_FOR_DIAMOND_TOOL,1200,6.5f,2.5f,12,()->Ingredient.fromTag(ModTags.Items.DIAMOND_LIKE_SHARDS))
    ;
    private final TagKey<Block> inverseTag;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    ModToolMaterials(final TagKey<Block> inverseTag, final int itemDurability, final float miningSpeed, final float attackDamage, final int enchantability, final Supplier<Ingredient> repairIngredient) {
        this.inverseTag = inverseTag;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        Objects.requireNonNull(repairIngredient);
        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
    }

    public int getDurability() {
        return this.itemDurability;
    }

    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    public TagKey<Block> getInverseTag() {
        return this.inverseTag;
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
