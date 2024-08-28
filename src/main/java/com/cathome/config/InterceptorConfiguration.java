//package com.airport.airaistudy.config;
//
//import com.airport.airaistudy.interceptor.LoginCheckInterceptor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
///**
// * 定义登陆拦截器
// */
//@Configuration
//public class InterceptorConfiguration implements WebMvcConfigurer {
//    @Autowired
//    private LoginCheckInterceptor loginCheckInterceptor;
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //排除登陆
//        registry.addInterceptor(loginCheckInterceptor).addPathPatterns("/**").excludePathPatterns("/login");
//        WebMvcConfigurer.super.addInterceptors(registry);
//    }
//}
