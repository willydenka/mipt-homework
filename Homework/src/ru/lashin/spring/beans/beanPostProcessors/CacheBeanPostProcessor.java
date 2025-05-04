package ru.lashin.spring.beans.beanPostProcessors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import ru.lashin.reflectionapiAndAnnotation.cache.Bukva;
import ru.lashin.reflectionapiAndAnnotation.cache.Cache;
import ru.lashin.reflectionapiAndAnnotation.cache.Cacher;

import java.util.HashMap;
import java.util.Map;

public class CacheBeanPostProcessor implements BeanPostProcessor {
    private final Map<String, Object> map = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAssignableFrom(Cache.class)) map.put(beanName, bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (!map.containsKey(beanName)) return bean;
        return Cacher.cache(bean).getFirst();
    }
}
