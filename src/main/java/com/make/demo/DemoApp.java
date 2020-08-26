package com.make.demo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Copyright@paidaxing
 * Author: paidaxing
 * Date:2020/8/24
 * Description:
 */

@SpringBootApplication(scanBasePackages="com.make.*")
public class DemoApp implements ApplicationRunner{
    @Value("${server.port:8080}")
    private String serverPort;
    @Value("${server.portspring.application.name:App}")
    private String appName;
    private static final Logger logger = LoggerFactory.getLogger(DemoApp.class);

    public static void main(String[] args) {
        SpringApplication.run(DemoApp.class,args);
    }

    @Override
    public void run(ApplicationArguments arg0) throws Exception{
//        System.out.println(serverPort);
//        System.out.println(appName);
        logger.info(appName +" strated at port:" + serverPort);
    }
}
