package com.example.test.ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * HelloBeanFactoryPostProcessor
 * @author zhangwei
 */
@Component
public class HelloBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    /**
     * 通过beanFactory可以获取bean的示例或定义
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("HelloBeanFactoryPostProcessor...postProcessBeanFactory");
        int count = beanFactory.getBeanDefinitionCount();
        BeanNameAware helloBean = (BeanNameAware)beanFactory.getBean("helloBean");
        helloBean.setBeanName("helloBean1111");
        String[] names = beanFactory.getBeanDefinitionNames();
        System.out.println("当前 BeanFactory 中有" + count + "个bean");
        System.out.println(Arrays.asList(names));
    }
}
