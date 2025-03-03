package ru.lashin.patterns;

import java.util.*;
import java.util.function.Function;

public class DataBase {
    private final List<String> list = new ArrayList<>();
    private final Map<Class<?>, Function<String, ?>> storageConvertors = new HashMap<>();

    public <T> void addCreator(Function<String, T> function, Class<T> clazz) {
        storageConvertors.put(clazz, function);
    }

    public void addToList(String string) {
        list.add(string);
    }

    public <T> T get(int idx, Class<T> clazz) {
        return (T) storageConvertors.get(clazz).apply(list.get(idx));
    }

}


class Test {
    public static void main(String[] args) {
        // Создание базы
        DataBase dataBase = new DataBase();
        dataBase.addCreator(Integer::parseInt, Integer.class);

        // Получение из базы
        int num = dataBase.get(0, Integer.class);
        System.out.println(num+5);

    }
}