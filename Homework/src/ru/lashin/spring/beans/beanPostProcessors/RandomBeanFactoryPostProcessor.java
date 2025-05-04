package ru.lashin.spring.beans.beanPostProcessors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;


public class RandomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        if (beanFactory.containsBeanDefinition("random")) return;
        BeanDefinitionRegistry beanDefinitionRegistry = (BeanDefinitionRegistry) beanFactory;
        BeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClassName("java.lang.Integer");
        beanDefinition.setScope("prototype");
        beanDefinition.setFactoryBeanName("randomIntFactory");
        beanDefinition.setFactoryMethodName("random");
        beanDefinitionRegistry.registerBeanDefinition("random", beanDefinition);
        }
}

