package ru.lashin.reflectionapiAndAnnotation.invoke;

import lombok.SneakyThrows;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class InvokeAnnotationProcessor {

    @SneakyThrows
    public static Map<String, Object> collect(Class<?>... classes) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Map<String, Object> result = new HashMap<>();
        for (Class<?> c : classes) {
            Method[] methods = c.getDeclaredMethods();
            Constructor<?> constructor = c.getDeclaredConstructor();
            Object obj = null;
            for (Method m : methods) {
                if (m.isAnnotationPresent(Invoke.class)
                        && m.getReturnType() != void.class
                        && m.getParameterCount() == 0) {
                    if (obj == null) obj = constructor.newInstance();
                    String name = m.getAnnotation(Invoke.class).value();
                    if (name.isEmpty()) name = m.getName();
                    result.put(name, m.invoke(obj));
                }
            }
        }
        return result;
    }
}
