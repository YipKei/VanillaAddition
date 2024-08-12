package com.yipkei.vanilladdition.init;

import com.yipkei.vanilladdition.VanillaAddition;
import net.minecraft.loot.LootTable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ModLootTables {
    private static final Set<RegistryKey<LootTable>> MOD_LOOT_TABLES = new HashSet<>();
    private static final Set<RegistryKey<LootTable>> MOD_LOOT_TABLES_READ_ONLY = Collections.unmodifiableSet(MOD_LOOT_TABLES);
    public static final RegistryKey<LootTable> EMPTY = RegistryKey.of(RegistryKeys.LOOT_TABLE, Identifier.of(VanillaAddition.MOD_ID, "empty"));

    public static final RegistryKey<LootTable> COAL_BLIND_BOX       = ModLootTables.register("blind_box/coal");
    public static final RegistryKey<LootTable> STONE_BLIND_BOX      = ModLootTables.register("blind_box/stone");
    public static final RegistryKey<LootTable> COPPER_BLIND_BOX     = ModLootTables.register("blind_box/copper");
    public static final RegistryKey<LootTable> IRON_BLIND_BOX       = ModLootTables.register("blind_box/iron");
    public static final RegistryKey<LootTable> GOLDEN_BLIND_BOX     = ModLootTables.register("blind_box/golden");
    public static final RegistryKey<LootTable> EMERALD_BLIND_BOX    = ModLootTables.register("blind_box/emerald");
    public static final RegistryKey<LootTable> DIAMOND_BLIND_BOX    = ModLootTables.register("blind_box/diamond");
    public static final RegistryKey<LootTable> NETHERITE_BLIND_BOX  = ModLootTables.register("blind_box/netherite");

    public static final RegistryKey<LootTable> OMINOUS_COAL_BLIND_BOX       = ModLootTables.register("blind_box/ominous_coal");
    public static final RegistryKey<LootTable> OMINOUS_STONE_BLIND_BOX      = ModLootTables.register("blind_box/ominous_stone");
    public static final RegistryKey<LootTable> OMINOUS_COPPER_BLIND_BOX     = ModLootTables.register("blind_box/ominous_copper");
    public static final RegistryKey<LootTable> OMINOUS_IRON_BLIND_BOX       = ModLootTables.register("blind_box/ominous_iron");
    public static final RegistryKey<LootTable> OMINOUS_GOLDEN_BLIND_BOX     = ModLootTables.register("blind_box/ominous_golden");
    public static final RegistryKey<LootTable> OMINOUS_EMERALD_BLIND_BOX    = ModLootTables.register("blind_box/ominous_emerald");
    public static final RegistryKey<LootTable> OMINOUS_DIAMOND_BLIND_BOX    = ModLootTables.register("blind_box/ominous_diamond");
    public static final RegistryKey<LootTable> OMINOUS_NETHERITE_BLIND_BOX  = ModLootTables.register("blind_box/ominous_netherite");

    public static final RegistryKey<LootTable> COAL_BLIND_BOX_COMMON = ModLootTables.register("blind_box/coal_common");
    public static final RegistryKey<LootTable> COAL_BLIND_BOX_UNCOMMON = ModLootTables.register("blind_box/coal_uncommon");
    public static final RegistryKey<LootTable> COAL_BLIND_BOX_RARE   = ModLootTables.register("blind_box/coal_rare");
    public static final RegistryKey<LootTable> COAL_BLIND_BOX_UNIQUE = ModLootTables.register("blind_box/coal_unique");
    public static final RegistryKey<LootTable> STONE_BLIND_BOX_COMMON = ModLootTables.register("blind_box/stone_common");
    public static final RegistryKey<LootTable> STONE_BLIND_BOX_UNCOMMON = ModLootTables.register("blind_box/stone_uncommon");
    public static final RegistryKey<LootTable> STONE_BLIND_BOX_RARE   = ModLootTables.register("blind_box/stone_rare");
    public static final RegistryKey<LootTable> STONE_BLIND_BOX_UNIQUE = ModLootTables.register("blind_box/stone_unique");
    public static final RegistryKey<LootTable> COPPER_BLIND_BOX_COMMON = ModLootTables.register("blind_box/copper_common");
    public static final RegistryKey<LootTable> COPPER_BLIND_BOX_UNCOMMON = ModLootTables.register("blind_box/copper_uncommon");
    public static final RegistryKey<LootTable> COPPER_BLIND_BOX_RARE   = ModLootTables.register("blind_box/copper_rare");
    public static final RegistryKey<LootTable> COPPER_BLIND_BOX_UNIQUE = ModLootTables.register("blind_box/copper_unique");
    public static final RegistryKey<LootTable> IRON_BLIND_BOX_COMMON = ModLootTables.register("blind_box/iron_common");
    public static final RegistryKey<LootTable> IRON_BLIND_BOX_UNCOMMON = ModLootTables.register("blind_box/iron_uncommon");
    public static final RegistryKey<LootTable> IRON_BLIND_BOX_RARE   = ModLootTables.register("blind_box/iron_rare");
    public static final RegistryKey<LootTable> IRON_BLIND_BOX_UNIQUE = ModLootTables.register("blind_box/iron_unique");
    public static final RegistryKey<LootTable> GOLDEN_BLIND_BOX_COMMON = ModLootTables.register("blind_box/golden_common");
    public static final RegistryKey<LootTable> GOLDEN_BLIND_BOX_UNCOMMON = ModLootTables.register("blind_box/golden_uncommon");
    public static final RegistryKey<LootTable> GOLDEN_BLIND_BOX_RARE   = ModLootTables.register("blind_box/golden_rare");
    public static final RegistryKey<LootTable> GOLDEN_BLIND_BOX_UNIQUE = ModLootTables.register("blind_box/golden_unique");
    public static final RegistryKey<LootTable> EMERALD_BLIND_BOX_COMMON = ModLootTables.register("blind_box/emerald_common");
    public static final RegistryKey<LootTable> EMERALD_BLIND_BOX_UNCOMMON = ModLootTables.register("blind_box/emerald_uncommon");
    public static final RegistryKey<LootTable> EMERALD_BLIND_BOX_RARE   = ModLootTables.register("blind_box/emerald_rare");
    public static final RegistryKey<LootTable> EMERALD_BLIND_BOX_UNIQUE = ModLootTables.register("blind_box/emerald_unique");
    public static final RegistryKey<LootTable> DIAMOND_BLIND_BOX_COMMON = ModLootTables.register("blind_box/diamond_common");
    public static final RegistryKey<LootTable> DIAMOND_BLIND_BOX_UNCOMMON = ModLootTables.register("blind_box/diamond_uncommon");
    public static final RegistryKey<LootTable> DIAMOND_BLIND_BOX_RARE   = ModLootTables.register("blind_box/diamond_rare");
    public static final RegistryKey<LootTable> DIAMOND_BLIND_BOX_UNIQUE = ModLootTables.register("blind_box/diamond_unique");
    public static final RegistryKey<LootTable> NETHERITE_BLIND_BOX_COMMON = ModLootTables.register("blind_box/netherite_common");
    public static final RegistryKey<LootTable> NETHERITE_BLIND_BOX_UNCOMMON = ModLootTables.register("blind_box/netherite_uncommon");
    public static final RegistryKey<LootTable> NETHERITE_BLIND_BOX_RARE   = ModLootTables.register("blind_box/netherite_rare");
    public static final RegistryKey<LootTable> NETHERITE_BLIND_BOX_UNIQUE = ModLootTables.register("blind_box/netherite_unique");

    public static final RegistryKey<LootTable> OMINOUS_COAL_BLIND_BOX_COMMON = ModLootTables.register("blind_box/ominous_coal_common");
    public static final RegistryKey<LootTable> OMINOUS_COAL_BLIND_BOX_UNCOMMON = ModLootTables.register("blind_box/ominous_coal_uncommon");
    public static final RegistryKey<LootTable> OMINOUS_COAL_BLIND_BOX_RARE   = ModLootTables.register("blind_box/ominous_coal_rare");
    public static final RegistryKey<LootTable> OMINOUS_COAL_BLIND_BOX_UNIQUE = ModLootTables.register("blind_box/ominous_coal_unique");
    public static final RegistryKey<LootTable> OMINOUS_STONE_BLIND_BOX_COMMON = ModLootTables.register("blind_box/ominous_stone_common");
    public static final RegistryKey<LootTable> OMINOUS_STONE_BLIND_BOX_UNCOMMON = ModLootTables.register("blind_box/ominous_stone_uncommon");
    public static final RegistryKey<LootTable> OMINOUS_STONE_BLIND_BOX_RARE   = ModLootTables.register("blind_box/ominous_stone_rare");
    public static final RegistryKey<LootTable> OMINOUS_STONE_BLIND_BOX_UNIQUE = ModLootTables.register("blind_box/ominous_stone_unique");
    public static final RegistryKey<LootTable> OMINOUS_COPPER_BLIND_BOX_COMMON = ModLootTables.register("blind_box/ominous_copper_common");
    public static final RegistryKey<LootTable> OMINOUS_COPPER_BLIND_BOX_UNCOMMON = ModLootTables.register("blind_box/ominous_copper_uncommon");
    public static final RegistryKey<LootTable> OMINOUS_COPPER_BLIND_BOX_RARE   = ModLootTables.register("blind_box/ominous_copper_rare");
    public static final RegistryKey<LootTable> OMINOUS_COPPER_BLIND_BOX_UNIQUE = ModLootTables.register("blind_box/ominous_copper_unique");
    public static final RegistryKey<LootTable> OMINOUS_IRON_BLIND_BOX_COMMON = ModLootTables.register("blind_box/ominous_iron_common");
    public static final RegistryKey<LootTable> OMINOUS_IRON_BLIND_BOX_UNCOMMON = ModLootTables.register("blind_box/ominous_iron_uncommon");
    public static final RegistryKey<LootTable> OMINOUS_IRON_BLIND_BOX_RARE   = ModLootTables.register("blind_box/ominous_iron_rare");
    public static final RegistryKey<LootTable> OMINOUS_IRON_BLIND_BOX_UNIQUE = ModLootTables.register("blind_box/ominous_iron_unique");
    public static final RegistryKey<LootTable> OMINOUS_GOLDEN_BLIND_BOX_COMMON = ModLootTables.register("blind_box/ominous_golden_common");
    public static final RegistryKey<LootTable> OMINOUS_GOLDEN_BLIND_BOX_UNCOMMON = ModLootTables.register("blind_box/ominous_golden_uncommon");
    public static final RegistryKey<LootTable> OMINOUS_GOLDEN_BLIND_BOX_RARE   = ModLootTables.register("blind_box/ominous_golden_rare");
    public static final RegistryKey<LootTable> OMINOUS_GOLDEN_BLIND_BOX_UNIQUE = ModLootTables.register("blind_box/ominous_golden_unique");
    public static final RegistryKey<LootTable> OMINOUS_EMERALD_BLIND_BOX_COMMON = ModLootTables.register("blind_box/ominous_emerald_common");
    public static final RegistryKey<LootTable> OMINOUS_EMERALD_BLIND_BOX_UNCOMMON = ModLootTables.register("blind_box/ominous_emerald_uncommon");
    public static final RegistryKey<LootTable> OMINOUS_EMERALD_BLIND_BOX_RARE   = ModLootTables.register("blind_box/ominous_emerald_rare");
    public static final RegistryKey<LootTable> OMINOUS_EMERALD_BLIND_BOX_UNIQUE = ModLootTables.register("blind_box/ominous_emerald_unique");
    public static final RegistryKey<LootTable> OMINOUS_DIAMOND_BLIND_BOX_COMMON = ModLootTables.register("blind_box/ominous_diamond_common");
    public static final RegistryKey<LootTable> OMINOUS_DIAMOND_BLIND_BOX_UNCOMMON = ModLootTables.register("blind_box/ominous_diamond_uncommon");
    public static final RegistryKey<LootTable> OMINOUS_DIAMOND_BLIND_BOX_RARE   = ModLootTables.register("blind_box/ominous_diamond_rare");
    public static final RegistryKey<LootTable> OMINOUS_DIAMOND_BLIND_BOX_UNIQUE = ModLootTables.register("blind_box/ominous_diamond_unique");
    public static final RegistryKey<LootTable> OMINOUS_NETHERITE_BLIND_BOX_COMMON = ModLootTables.register("blind_box/ominous_netherite_common");
    public static final RegistryKey<LootTable> OMINOUS_NETHERITE_BLIND_BOX_UNCOMMON = ModLootTables.register("blind_box/ominous_netherite_uncommon");
    public static final RegistryKey<LootTable> OMINOUS_NETHERITE_BLIND_BOX_RARE   = ModLootTables.register("blind_box/ominous_netherite_rare");
    public static final RegistryKey<LootTable> OMINOUS_NETHERITE_BLIND_BOX_UNIQUE = ModLootTables.register("blind_box/ominous_netherite_unique");

    public static final RegistryKey<LootTable> LEATHER_ARMORS =    ModLootTables.register("equipments/leather_armors");
    public static final RegistryKey<LootTable> IRON_TOOLS =        ModLootTables.register("equipments/iron_tools");
    public static final RegistryKey<LootTable> IRON_ARMORS =       ModLootTables.register("equipments/iron_armors");
    public static final RegistryKey<LootTable> CHAINMAIL_ARMORS =  ModLootTables.register("equipments/chainmail_armors");
    public static final RegistryKey<LootTable> IRON_EQUIPMENT =    ModLootTables.register("equipments/iron_equipment");
    public static final RegistryKey<LootTable> GOLDEN_TOOLS =      ModLootTables.register("equipments/golden_tools");
    public static final RegistryKey<LootTable> GOLDEN_ARMORS =     ModLootTables.register("equipments/golden_armors");
    public static final RegistryKey<LootTable> GOLDEN_EQUIPMENT =  ModLootTables.register("equipments/golden_equipment");
    public static final RegistryKey<LootTable> DIAMOND_TOOLS =     ModLootTables.register("equipments/diamond_tools");
    public static final RegistryKey<LootTable> DIAMOND_ARMORS =    ModLootTables.register("equipments/diamond_armors");
    public static final RegistryKey<LootTable> DIAMOND_EQUIPMENT = ModLootTables.register("equipments/diamond_equipment");

    public static final RegistryKey<LootTable> ENCHANTED_LEATHER_ARMORS =    ModLootTables.register("equipments/enchanted_leather_armors");
    public static final RegistryKey<LootTable> ENCHANTED_IRON_TOOLS =        ModLootTables.register("equipments/enchanted_iron_tools");
    public static final RegistryKey<LootTable> ENCHANTED_IRON_ARMORS =       ModLootTables.register("equipments/enchanted_iron_armors");
    public static final RegistryKey<LootTable> ENCHANTED_CHAINMAIL_ARMORS =  ModLootTables.register("equipments/enchanted_chainmail_armors");
    public static final RegistryKey<LootTable> ENCHANTED_IRON_EQUIPMENT =    ModLootTables.register("equipments/enchanted_iron_equipment");
    public static final RegistryKey<LootTable> ENCHANTED_GOLDEN_TOOLS =      ModLootTables.register("equipments/enchanted_golden_tools");
    public static final RegistryKey<LootTable> ENCHANTED_GOLDEN_ARMORS =     ModLootTables.register("equipments/enchanted_golden_armors");
    public static final RegistryKey<LootTable> ENCHANTED_GOLDEN_EQUIPMENT =  ModLootTables.register("equipments/enchanted_golden_equipment");
    public static final RegistryKey<LootTable> ENCHANTED_DIAMOND_TOOLS =     ModLootTables.register("equipments/enchanted_diamond_tools");
    public static final RegistryKey<LootTable> ENCHANTED_DIAMOND_ARMORS =    ModLootTables.register("equipments/enchanted_diamond_armors");
    public static final RegistryKey<LootTable> ENCHANTED_DIAMOND_EQUIPMENT = ModLootTables.register("equipments/enchanted_diamond_equipment");

    private static RegistryKey<LootTable> register(String id) {
        return ModLootTables.registerLootTable(RegistryKey.of(RegistryKeys.LOOT_TABLE, Identifier.of(VanillaAddition.MOD_ID, id)));
    }

    private static RegistryKey<LootTable> registerLootTable(RegistryKey<LootTable> key){
        if (MOD_LOOT_TABLES.add(key)){
            return key;
        }
        throw new IllegalArgumentException(key.getValue() + " is already a registered built-in loot table");
    }

    public static Set<RegistryKey<LootTable>> getAll() {
        return MOD_LOOT_TABLES_READ_ONLY;
    }
}
