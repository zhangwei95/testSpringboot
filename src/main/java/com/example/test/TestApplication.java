package com.example.test;

import com.example.test.entity.HelloBean;
import com.example.test.util.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

@SpringBootApplication
public class TestApplication {
    protected static final Logger logger = LoggerFactory.getLogger(TestApplication.class);

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext run = SpringApplication.run(TestApplication.class, args);


        Environment env = run.getEnvironment();
        logger.info(
                "\n----------------------------------------------------------\n\t"
                        + "Application '{}' is running! Access URLs:\n\t"
                        + "Local: \t\thttp://127.0.0.1:{}\n\t"
                        + "External: \thttp://{}:{}\n----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                env.getProperty("server.port"),
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port"));

        String configServerStatus = env.getProperty("configserver.status");
        logger.info(
                "\n----------------------------------------------------------\n\t"
                        + "Config Server: \t{}\n----------------------------------------------------------",
                configServerStatus == null
                        ? "Not found or not setup for this application"
                        : configServerStatus);

        HelloBean helloBean =(HelloBean)run.getBean("helloBean");

        helloBean.sayHello();

        logger.trace("I am trace log.");
        logger.debug("I am debug log.");
        logger.info("I am info log.");
        logger.warn("I am warn log.");
        logger.error("I am error log.{}", new Date());


    }



}
