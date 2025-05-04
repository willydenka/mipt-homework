package ru.lashin.spring.beans.beanPostProcessors;

import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import ru.lashin.reflectionapiAndAnnotation.entity.ToString;
import ru.lashin.reflectionapiAndAnnotation.Value;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ToStringBeanPostProcessor implements BeanPostProcessor {
    private final Map<String, Object> map = new HashMap<>();

    static class Entity {
        Object bean;

        public Entity(Object bean) {
            this.bean = bean;
        }

        @SneakyThrows
        public String toString() {
            Class<?> clazz = bean.getClass();
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
                        fieldsAndValues.add(field.getName() + "=" + field.get(bean));
                    } catch (IllegalAccessException e) {
                        System.out.println(e.getMessage());
                    }
                }
                clazz = clazz.getSuperclass();
            }
            return result + String.join(", ", fieldsAndValues) + "}";
        }
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("random")) return bean;
        if (bean.getClass().isAnnotationPresent(ToString.class)) map.put(beanName, bean);
        else {
            Field[] fields = bean.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(ToString.class)) map.put(beanName, bean);
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (map.containsKey(beanName)) {
            MethodInterceptor methodInterceptor =
                    (obj, method, args, proxy) -> new Entity(bean).toString();
            return Enhancer.create(Object.class, methodInterceptor);
        }
        return bean;
    }
}
