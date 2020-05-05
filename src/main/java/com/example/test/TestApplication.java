package com.example.test;

import com.example.test.util.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Date;

@SpringBootApplication
public class TestApplication {
    protected static final Logger logger = LoggerFactory.getLogger(TestApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(TestApplication.class, args);
        System.out.println(DateUtils.timestamp2LocalDateTime(Long.valueOf("1567242193000")));
        HelloBean helloBean =(HelloBean)run.getBean("helloBean");
        helloBean.sayHello();
        logger.trace("I am trace log.");
        logger.debug("I am debug log.");
        logger.info("I am info log.");
        logger.warn("I am warn log.");
        logger.error("I am error log.{}", new Date());


    }

}
