package com.make.demo;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Copyright@paidaxing
 * Author: paidaxing
 * Date:2020/8/24
 * Description:
 */

@ServletComponentScan("com.make.Filter")
@SpringBootApplication(scanBasePackages={"com.make.*","com.make.service.*"})
@MapperScan("com.make.dao")
@EnableScheduling //可调度程序
//@EnableDiscoveryClient //Eureak 客户端注册
@EnableSwagger2  //接口管理
public class DemoApp implements ApplicationRunner{
    @Value("${server.port:8080}")
    private String serverPort;
    @Value("${spring.application.name:App}")
    private String appName;
    private static final Logger logger = LoggerFactory.getLogger(DemoApp.class);

    public static void main(String[] args) {
        SpringApplication.run(DemoApp.class,args);
    }

    @Override
    public void run(ApplicationArguments arg0) throws Exception{
        logger.info(appName +" strated at port:" + serverPort);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/crossOrigin").allowedOrigins("http://localhost:9090");
            }
        };
    }

    @Bean
    public Docket heroApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.make.controller")).build();
    }
    @Bean
    public ApiInfo apiInfo() {
        Contact contact = new Contact("maketubu", "localhost:8080", "maketubu@gmail.com");
        return new ApiInfoBuilder()
                .title("SwaggerUI演示")
                .description("接口文档，描述词省略200字")
                .contact(contact)
                .version("1.0")
                .build();
    }

}
