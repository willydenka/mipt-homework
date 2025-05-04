package ru.lashin.reflectionapiAndAnnotation.reset;

import lombok.SneakyThrows;
import ru.lashin.reflectionapiAndAnnotation.invoke.InvokeAnnotationProcessor;

import java.lang.reflect.Field;
import java.util.*;

public class ResetAnnotationProcessor {

    public static void reset(Object... objects) throws Exception {
        for (Object object : objects) {
            resetObject(object);
        }
    }
    public static List<Field> getAllFields(Class<?> clz) {
        if (clz == Object.class) return new ArrayList<>();
        List<Field> fields = getAllFields(clz.getSuperclass());
        fields.addAll(Arrays.stream(clz.getDeclaredFields()).toList());
        return fields;
    }

    @SneakyThrows
    private static void resetObject(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();
        List<Field> fields = getAllFields(clazz);
        for (Field field : fields) {
            if (field.isAnnotationPresent(Default.class) && context == null)
                continue;

            Class<?> defaultClass = clazz.getAnnotation(Default.class).value();
            Map<String, Object> context = InvokeAnnotationProcessor.collect(defaultClass);
            field.setAccessible(true);
            field.set(obj, context.get(field.getName()));
        }
    }
}

