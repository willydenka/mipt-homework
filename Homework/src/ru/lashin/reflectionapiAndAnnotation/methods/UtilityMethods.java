package ru.lashin.reflectionapiAndAnnotation.methods;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class UtilityMethods {
    // 8.3.1
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
    // 8.3.4
    public static void validate(Object... objects) throws Exception {
        for (Object object : objects) {

            Validate annotation = null;
            if (object.getClass().isAnnotationPresent(Validate.class))
                annotation = object.getClass().getAnnotation(Validate.class);
            else {
                Annotation[] annotations = object.getClass().getAnnotations();
                for (Annotation ann : annotations) {
                    if (ann.annotationType().isAnnotationPresent(Validate.class)) {
                        annotation = annotations[0].annotationType().getAnnotation(Validate.class);
                        break;
                    }
                }
            }
            if (annotation == null) throw new IllegalArgumentException("Валидатора нет");

            Class<?>[] tests = annotation.value();
            for (Class<?> testClass : tests) {
                Object obj = testClass.getDeclaredConstructor().newInstance();
                Method[] methods = testClass.getDeclaredMethods();
                for (Method method : methods) {
                    try {
                        method.setAccessible(true);
                        method.invoke(obj, object);
                    } catch (InvocationTargetException e) {
                        throw new IllegalArgumentException("Объект не прошел валидацию! " + e.getCause().getMessage());
                    }
                }
            }
        }
    }

}

class A {
    @Invoke
    public String m1() {
        return "text";
    }

    public String m2() {
        return "place";
    }

    @Invoke
    public Integer m3() {
        return 42;
    }
}
@AValidate()
class Human {
    public Human() {
    }

    String name = "Вася";
    int age = 15;
}


class NameTest {
    static void testName(Human human) {
        if (human.name.charAt(0) == 'В') throw new IllegalArgumentException("Некорректное имя!");
        System.out.println("Все норм");
    }
}
class AgeTest {
    static void testAge(Human human)  {
        if (human.age < 0 || human.age > 100) throw new IllegalArgumentException("Некорректный возраст!");
        System.out.println("Все норм");
    }
}

class Main {
    public static void main(String[] args) {
        Human human = new Human();
        try {
            UtilityMethods.validate(human);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}