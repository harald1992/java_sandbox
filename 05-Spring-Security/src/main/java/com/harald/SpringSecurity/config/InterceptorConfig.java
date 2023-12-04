// package com.harald.SpringSecurity.config;
//
// import com.harald.SpringSecurity.interceptor.GeneralInterceptor;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
// @Configuration
// public class InterceptorConfig implements WebMvcConfigurer {
//
//     @Autowired
//     private GeneralInterceptor interceptor;
//
//     @Override
//     public void addInterceptors(InterceptorRegistry registry) {
//         registry.addInterceptor(interceptor);
//         WebMvcConfigurer.super.addInterceptors(registry);
//     }
//
// }
