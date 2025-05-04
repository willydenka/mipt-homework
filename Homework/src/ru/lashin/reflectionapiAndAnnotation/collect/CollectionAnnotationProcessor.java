package ru.lashin.reflectionapiAndAnnotation.collect;

import ru.lashin.reflectionapiAndAnnotation.invoke.Invoke;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CollectionAnnotationProcessor {

    public static Map<String, Object> collect(Class<?>... clazz) throws Exception {
        Map<String, Object> result = new HashMap<>();
        for (Class<?> c : clazz) {
            Object instance = c.getDeclaredConstructor().newInstance();
            Method[] methods = c.getDeclaredMethods();

            for (Method m : methods) {
                m.setAccessible(true);
                if (m.getParameterCount() == 0
                        && m.getReturnType() != void.class
                        && m.isAnnotationPresent(Invoke.class)) {
                    Object value = m.invoke(instance);
                    result.put(m.getName(), value);
                }
            }
        }
        return result;
    }
}
