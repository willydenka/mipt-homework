package ru.lashin.reflectionapiAndAnnotation.cache;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;

public class Cacher {
    public static ArrayList<?> cache(Object... objects) {
        ArrayList<Bukva> listProxy = new ArrayList<>(); // Так как принимает набор объектов, то и возвращает лист
        for (Object object : objects) { // По каждому объекту
            if (object.getClass().isAnnotationPresent(Cache.class)) { // Если есть анноташка
                String[] names = object.getClass().getAnnotation(Cache.class).value(); // Берем у нее значения
                if (names.length != 0) { // Если значения есть (т.е не дефолтное), то
                    Object res = Proxy.newProxyInstance(
                            object.getClass().getClassLoader(),
                            object.getClass().getInterfaces(),
                            new CacheHandler<>(object, names) // Проксюем, передав те имена методов, которые нужно кэшировать
                    );
                    listProxy.add((Bukva) res); // Добавляем в результирующую коллекцию
                    continue; // Берем следующий элемент
                }
            }  // Ну а если анноташки нет или у нее дефолтное значение (т.е. пустой массив), то
            Object res = Proxy.newProxyInstance(
                    object.getClass().getClassLoader(),
                    object.getClass().getInterfaces(),
                    new CacheHandler<>(object) // Проксюем по обычному
            );
            listProxy.add((Bukva)res); // Добавляем в результат
        }
        return listProxy;
    }

    static class CacheHandler<T> implements InvocationHandler {
        final T originalObject;
        final Map<Method, Object> cache = new HashMap<>();
        int stateHash;
        ArrayList<String> nameMethods = new ArrayList<>();

        CacheHandler(T originalObject) {
            this(originalObject, null);
            this.stateHash = originalObject.hashCode();
        }
        CacheHandler(T originalObject, String[] strings) {
            this.originalObject = originalObject;
            if (strings != null) Collections.addAll(nameMethods, strings);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            method.setAccessible(true);
            // Если в списке методов нет текущего метода, то он не кэшируется
            if (!nameMethods.contains(method.getName())) return method.invoke(originalObject, args);
            // Если есть в списке, то кэшируем так:
            // - Проверяем, был ли он уже закэширован
            // - Если не был, то кэшируем и забиваем
           if (!cache.containsKey(method)) return executeCache(method);
            // - Если был закеширован ранее, то по хэшу проверяем, изменился ли основной объект
           int nextHash = originalObject.hashCode();
           if (stateHash != nextHash) return executeCache(method); // Изменился - кэшуем еще раз
           return cache.get(method); // Не изменился - возвращаем результат
        }

        private Object executeCache(Method method) throws Throwable {
            Object res = method.invoke(originalObject);
            cache.put(method, res);
            stateHash = originalObject.hashCode();
            return res;
        }
    }
}

