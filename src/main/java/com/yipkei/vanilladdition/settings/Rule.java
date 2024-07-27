package com.yipkei.vanilladdition.settings;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Rule {
    String[] categories();
    String[] options() default {};
    boolean strict() default true;
    String appSource() default "";

    Class<? extends Condition>[] conditions() default {};

    interface Condition{
        boolean shouldRegister();
    }
}
