package ru.lashin.spring.beans.beanPostProcessors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.lashin.reflectionapiAndAnnotation.validate.AValidate;
import ru.lashin.spring.beans.beanPostProcessors.annotations.Validate;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ValidateBeanPostProcessor implements BeanPostProcessor {

    private final Map<String, Object> map = new HashMap<>();
    private final ValidateProcessor validateProcessor;

    @Autowired
    public ValidateBeanPostProcessor(ValidateProcessor validateProcessor) {
        this.validateProcessor = validateProcessor;
    }

    public static class ValidateProcessor {
        private final AnnotationConfigApplicationContext context;

        @Autowired
        private ValidateProcessor(AnnotationConfigApplicationContext context) {
            this.context = context;
        }

        public void validate(Object... objects) throws Exception {
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
                String[] tests = annotation.value();
                for (String testClass : tests) {
                    Object obj = context.getBean(testClass);
                    Method[] methods = obj.getClass().getDeclaredMethods();
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

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("random")) return bean;
        if (bean.getClass().isAnnotationPresent(Validate.class)
                || bean.getClass().isAnnotationPresent(AValidate.class)) {
            map.put(beanName, bean);
            return bean;
        }
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Validate.class) || field.isAnnotationPresent(AValidate.class)) {
                map.put(beanName, bean);
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (!map.containsKey(beanName)) return bean;
        try {
            validateProcessor.validate(bean);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return bean;
    }
}
