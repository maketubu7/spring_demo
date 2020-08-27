package com.make.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Copyright@paidaxing
 * Author: paidaxing
 * Date:2020/8/25
 * Description:
 */

@Component
public class HeroServiceInterceptorAppConfig implements WebMvcConfigurer {

    @Autowired
    HeroServiceInterceptor heroServiceInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("拦截器注册。。。。");
        registry.addInterceptor(heroServiceInterceptor).addPathPatterns("/interceptor/**");
        System.out.println("拦截器注册成功");
    }
}
//public class HeroServiceInterceptorAppConfig implements WebMvcConfigurer {
//
//    @Autowired
//    HeroServiceInterceptor heroServiceInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(heroServiceInterceptor);
//    }
//}
