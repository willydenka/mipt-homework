package ru.lashin.spring.beans.beanPostProcessors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import java.lang.reflect.Field;


public class ControlNameBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("random")) return bean;
        Class<?> clazz = bean.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if (field.getName().equals("name") && field.getType() == String.class && field.get(bean) == null) {
                    field.set(bean, "vasia");
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return bean;
    }
}
