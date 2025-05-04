package ru.lashin.reflectionapiAndAnnotation.validate;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ValidateAnnotationProcessor {

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
