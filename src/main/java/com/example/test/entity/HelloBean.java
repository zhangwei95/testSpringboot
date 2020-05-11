package com.example.test.entity;

import com.example.test.MyInterface;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.*;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

/**
 * lifeCycle
 * @see BeanNameAware#setBeanName
 * @see BeanClassLoaderAware#setBeanClassLoader
 * @see BeanFactoryAware#setBeanFactory
 * @see org.springframework.context.ResourceLoaderAware#setResourceLoader
 * @see org.springframework.context.ApplicationEventPublisherAware#setApplicationEventPublisher
 * @see org.springframework.context.MessageSourceAware#setMessageSource
 * @see org.springframework.context.ApplicationContextAware#setApplicationContext
 * @see org.springframework.web.context.ServletContextAware#setServletContext
 * @see org.springframework.beans.factory.config.BeanPostProcessor#postProcessBeforeInitialization
 * @see InitializingBean#afterPropertiesSet
 * @see org.springframework.beans.factory.support.RootBeanDefinition#getInitMethodName
 * @see org.springframework.beans.factory.config.BeanPostProcessor#postProcessAfterInitialization
 * @see DisposableBean#destroy
 * @see org.springframework.beans.factory.support.RootBeanDefinition#getDestroyMethodName
 */
@Component
public class HelloBean extends RootBeanDefinition implements BeanNameAware,
        BeanClassLoaderAware, BeanFactoryAware, ResourceLoaderAware, ApplicationEventPublisherAware,
        MessageSourceAware, ApplicationContextAware, ServletContextAware, BeanPostProcessor,
        InitializingBean, DisposableBean, SmartInitializingSingleton, SmartLifecycle,
        MyInterface {

    private final Log logger = LogFactory.getLog(getClass());
    private boolean isRunning;

    @Override
    public  String getInitMethodName(){
        System.out.println("12、getInitMethodName");
        return super.getInitMethodName();
    }

    @Override
    public  String getDestroyMethodName(){
        System.out.println("15、getDestroyMethodName");
        return super.getDestroyMethodName();
    }


    public HelloBean() {
        System.out.println("1、实例化");
    }

    public void sayHello(){
        System.out.println("hello World");
    }

    @Override
    public void afterSingletonsInstantiated() {
        System.out.println("SmartInitializingSingleton afterSingletonsInstantiated");
    }

    @Override
    public void start() {
        isRunning = true;
        System.out.println("LifeCycle start");
    }

    @Override
    public void stop() {
        System.out.println("LifeCycle stop");
    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }

    @Override
    public boolean isAutoStartup() {
        return true;
    }

    @Override
    public void stop(Runnable callback) {
        System.out.println("LifeScycle stop");
        callback.run();
    }

    @Override
    public int getPhase() {
        return 0;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("10、afterproperties set");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("14 、destroy");
    }

    public void my(String str) {
        System.out.println(str);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("2 、set bean Name aware");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("8、set Application Aware");
    }

    @Override
    public void my() {
        System.out.println("my print");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("11、helloBean postProcessBeforeInitialization call");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("13、helloBean  postProcessAfterInitialization call");
        return bean;
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("3、helloBean  setBeanClassLoader "+ classLoader.toString());
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("4、helloBean  setBeanFactory " + beanFactory.toString());
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        System.out.println("5、helloBean  setResourceLoader " + resourceLoader.toString());
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        System.out.println("6、helloBean  setApplicationEventPublisher " + applicationEventPublisher.toString());
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        System.out.println("7、helloBean  setMessageSource " + messageSource.toString());
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        System.out.println("9、helloBean  setServletContext " + servletContext.toString());
    }
}
