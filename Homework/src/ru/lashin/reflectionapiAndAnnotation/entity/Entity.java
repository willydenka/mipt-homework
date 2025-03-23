package ru.lashin.reflectionapiAndAnnotation.entity;

import ru.lashin.reflectionapiAndAnnotation.methods.Value;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Entity {
//    String s = "sss";
//    int x = 5;

    @Override
    public String toString() {
        Map<String, Object> map = new HashMap<>();
        Class<?> clazz = this.getClass();
        while (clazz != Object.class) { // Пока есть кастомные родители
            ToString ann = clazz.getAnnotation(ToString.class); // Получаем аннотацию класса
            Field[] fields = clazz.getDeclaredFields(); // Получаем поля класса
            for (Field field : fields) {
                try {
                    field.setAccessible(true);
                    execute(ann, field, map);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            clazz = clazz.getSuperclass();
        }
        return map.toString();
    }

    // Метод для всех условий
    private void execute(ToString classAnnotation, Field field, Map<String, Object> map) throws IllegalAccessException {
        ToString fieldAnnotation = field.getAnnotation(ToString.class); // Получаем аннотацию поля
        boolean isClassToString = classAnnotation == null || classAnnotation.value() == Value.YES; // Класс тустрингуеется, если на нем нет аннотации или она со значением YES
        boolean isFieldToString = (isClassToString && (fieldAnnotation == null || fieldAnnotation.value() == Value.YES)) // Полу тустрингуется, если тустрингуется класс и у поля нет значения NO или класс не тустрингуется, но есть значение у поля YES
                || (!isClassToString && (fieldAnnotation != null && fieldAnnotation.value() == Value.YES));

        if ((isClassToString && isFieldToString) // Если тустрингуется и класс и поле
                || (!isClassToString && isFieldToString)) { // или класс не тустрингуется, но тустрингуется поле
            map.put(field.getName(), field.get(this)); // добавляем значение метода в мапу
        }
    }
}

