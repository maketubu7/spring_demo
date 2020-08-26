package com.make.Filter;


import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Copyright@paidaxing
 * Author: paidaxing
 * Date:2020/8/26
 * Description:
 */
@Component
public class HeroFilter implements Filter {
    private String url;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        this.url = filterConfig.getInitParameter("URL");
//        Enumeration<String> res = filterConfig.getInitParameterNames();
//        while (res.hasMoreElements()){
//            System.out.println("init names: "+res.nextElement());
//        }
//
//        System.out.println("init url: "+ this.url);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        long start = System.currentTimeMillis();
        filterChain.doFilter(request, response);
        System.out.println("timerFilter Execute cost=" + (System.currentTimeMillis()-start));
    }

    @Override
    public void destroy() {

    }
}
