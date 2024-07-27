package com.yipkei.vanilladdition.settings;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class SettingManager {
    public void parseSettingClass(Class<?> settingClass){
        nextRule : for (Field field : settingClass.getFields()){
            Class<? extends Rule.Condition>[] conditions;
            Rule annotation = field.getAnnotation(Rule.class);
            conditions = annotation.conditions();
            for (Class<? extends Rule.Condition> condition: conditions){
                try{
                    Constructor<? extends Rule.Condition> constructor = condition.getDeclaredConstructor();
                    constructor.setAccessible(true);
                    if (!constructor.newInstance().shouldRegister())
                        continue nextRule;
                }
                catch (ReflectiveOperationException e){
                    throw new IllegalArgumentException(e);
                }
            }
        }
    }
}
