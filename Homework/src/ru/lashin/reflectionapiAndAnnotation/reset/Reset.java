package ru.lashin.reflectionapiAndAnnotation.reset;

import java.lang.reflect.Field;
import java.util.Map;

public class Reset {

    public static void reset(Context context, Object... objects) throws Exception {
        Field fieldContext = context.getClass().getDeclaredField("defaultValues");
        fieldContext.setAccessible(true);
        Map<Class<?>, Object> defaultValues = (Map<Class<?>, Object>) fieldContext.get(context);


        for (Object object : objects) {
            Class<?> clazz = object.getClass();
            Default classDefault = clazz.getAnnotation(Default.class);
            Field[] fields = clazz.getDeclaredFields();

            for (Field field : fields) {
                field.setAccessible(true);
                if (classDefault != null && classDefault.value() == object.getClass()) {
                    field.set(object, defaultValues.get(field.getType()));
                } else {
                    Default fieldDefault = field.getAnnotation(Default.class);
                    if (fieldDefault == null || fieldDefault.value() != field.getType()) continue;
                    field.set(object, defaultValues.get(field.getType()));
                }
            }
        }
    }
}

