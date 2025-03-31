package ru.lashin.reflectionapiAndAnnotation.entity;

import ru.lashin.reflectionapiAndAnnotation.methods.Value;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Entity {

    @Override
    public String toString() {
        Map<String, Object> map = new HashMap<>();
        Class<?> clazz = this.getClass();
        while (clazz != Object.class) { // Пока есть кастомные родители
            ToString classAnnotation = clazz.getAnnotation(ToString.class); // Получаем аннотацию класса
            Field[] fields = clazz.getDeclaredFields(); // Получаем поля класса
            for (Field field : fields) {
                try {
                    field.setAccessible(true);
                    ToString fieldAnnotation = field.getAnnotation(ToString.class);
                    if (fieldAnnotation == null) fieldAnnotation = classAnnotation;
                    if (fieldAnnotation == null) continue;
                    if (fieldAnnotation.value() == Value.NO) continue;
                    map.put(field.getName(), field.get(this));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            clazz = clazz.getSuperclass();
        }
        return map.toString();
    }
}

