// package com.harald.SpringSecurity.security;
//
// import com.harald.SpringSecurity.interceptor.GeneralInterceptor;
// import lombok.extern.slf4j.Slf4j;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.core.annotation.Order;
// import org.springframework.web.servlet.config.annotation.CorsRegistry;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
// @Configuration
// @Slf4j
// @Order(1)
// public class WebConfig implements WebMvcConfigurer {
//
//     @Override
//     public void addCorsMappings(CorsRegistry registry) {
//         registry.addMapping("/*/**") // Define the endpoint(s) you want to enable CORS for
//                 .allowedOrigins("http://localhost:5500") // Replace with your frontend URL
//                 .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allowed HTTP methods
//                 .allowedHeaders("*") // Allowed headers, adjust as needed
//                 .allowCredentials(true); // Allow sending cookies (if required)
//     }
//
// }
