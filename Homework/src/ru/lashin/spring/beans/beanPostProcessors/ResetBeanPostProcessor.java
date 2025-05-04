package ru.lashin.spring.beans.beanPostProcessors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.lashin.reflectionapiAndAnnotation.reset.Default;
import ru.lashin.reflectionapiAndAnnotation.reset.ResetAnnotationProcessor;
import ru.lashin.spring.beans.beanPostProcessors.annotations.Validate;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


public class ResetBeanPostProcessor implements BeanPostProcessor {

    private final Map<String, Object> map = new HashMap<>();
    private final AnnotationProcessor annotationProcessor;

    public ResetBeanPostProcessor(AnnotationProcessor annotationProcessor) {
        this.annotationProcessor = annotationProcessor;
    }

    public static class AnnotationProcessor {

        private final AnnotationConfigApplicationContext context;
        @Autowired
        public AnnotationProcessor(AnnotationConfigApplicationContext context) {
            this.context = context;
        }

        public void reset(Object object) throws IllegalAccessException, InvocationTargetException {
            Class<?> clazz = object.getClass();


            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Default.class)) {
                    field.setAccessible(true);
                    field.set(object, context.getBean(field.getAnnotation(Default.class).value()));
                }
            }
            /*
            Условие в задании, лично для меня, немного размыто и абстрактно.
            "b.	Если проаннотирован класс – то у него есть методы получения значения по умолчанию."
            Т.е. мы заранее в классе, который хотим проаннотировать, должны написать методы получения значений по умолчанию?
            А зачем нам тогда в аннотации имя бина указывать?
            В общем немного смутился. Наверное, все-таки в самом бине есть эти методы.
             */
            if (clazz.isAnnotationPresent(Default.class)) {
                Object obj = context.getBean(clazz.getAnnotation(Default.class).value());
                Method[] methods = obj.getClass().getDeclaredMethods();
                for (Method method : methods) {
                    Object result = method.invoke(obj);
                    for (Field field : fields) {
                        if (result == field.getType()) {
                            field.setAccessible(true);
                            field.set(object, result);
                            break;
                        }
                    }
                }
            }
        }
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("random")) return bean;
        Class<?> clz = bean.getClass();
        if (clz.isAnnotationPresent(Default.class)) {
            map.put(beanName, bean);
            return bean;
        }
        Field[] fields = clz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Default.class)) {
                map.put(beanName, bean);
                return bean;
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (map.containsKey(beanName)) {
            try {
                annotationProcessor.reset(bean);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return bean;
    }
}
