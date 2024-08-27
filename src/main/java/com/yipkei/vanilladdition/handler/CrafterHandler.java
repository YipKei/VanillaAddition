package com.yipkei.vanilladdition.handler;

public class CrafterHandler {
    public static final ThreadLocal<Boolean> IS_REPAIR = new ThreadLocal<>();
    public static final ThreadLocal<Boolean> PASSED_RESULT = new ThreadLocal<>();

    public static final ThreadLocal<Integer> SLOT = new ThreadLocal<>();
}
