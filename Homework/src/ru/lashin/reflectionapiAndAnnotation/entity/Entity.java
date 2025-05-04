package ru.lashin.reflectionapiAndAnnotation.entity;

import lombok.SneakyThrows;
import ru.lashin.reflectionapiAndAnnotation.Value;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Entity {

    @Override
    @SneakyThrows
    public String toString() {
        Class<?> clazz = this.getClass();
        String result = clazz.getSimpleName() + "{";
        List<String> fieldsAndValues = new ArrayList<>();
        while (clazz != Object.class) { // Пока есть кастомные родители

            ToString classAnnotation = clazz.getAnnotation(ToString.class); // Получаем аннотацию класса
            Field[] fields = clazz.getDeclaredFields(); // Получаем поля класса
            for (Field field : fields) {
                field.setAccessible(true);
                ToString fieldAnnotation = field.getAnnotation(ToString.class);
                if (fieldAnnotation == null) fieldAnnotation = classAnnotation;
                if (fieldAnnotation == null) continue;
                if (fieldAnnotation.value() == Value.NO) continue;
                try {
                    fieldsAndValues.add(field.getName() + "=" + field.get(this));
                } catch (IllegalAccessException e) {
                    System.out.println(e.getMessage());
                }
            }
            clazz = clazz.getSuperclass();
        }
        return result + String.join(", ", fieldsAndValues) + "}";
    }
}

