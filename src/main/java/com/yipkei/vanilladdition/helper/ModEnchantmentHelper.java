package com.yipkei.vanilladdition.helper;

public class ModEnchantmentHelper {
    public static final double MAX_WARDEN_DISTANCE_FOR_SWIFT_SNEAK = 8.0;

    public static int getSwiftSneakMinCost(int level) {
        return 14 + level * 7;
    }

    public static int getSwiftSneakMaxCost(int level) {
        return getSwiftSneakMinCost(level) + 50;
    }
}
