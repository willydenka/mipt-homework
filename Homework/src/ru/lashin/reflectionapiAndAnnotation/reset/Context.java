package ru.lashin.reflectionapiAndAnnotation.reset;

import java.util.HashMap;
import java.util.Map;

class Context {
    private Map<Class<?>, Object> defaultValues = new HashMap<>();

    void setBean(Class<?> clazz, Object value) {
        defaultValues.put(clazz, value);
    }

}
