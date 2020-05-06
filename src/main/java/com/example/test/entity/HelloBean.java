package com.example.test.entity;

import com.example.test.MyInterface;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

@Component
public class HelloBean implements SmartInitializingSingleton, SmartLifecycle, InitializingBean,
        DisposableBean, MyInterface, BeanNameAware, ApplicationContextAware
{

    private final Log logger = LogFactory.getLog(getClass());
    private boolean isRunning;


    public HelloBean() {
        System.out.println("实例化");
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
        System.out.println("afterproperties set");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy");
    }

    public void my(String str) {
        System.out.println(str);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("set bean Name aware");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("set Application Aware");
    }

    @Override
    public void my() {
        System.out.println("my print");
    }
}
