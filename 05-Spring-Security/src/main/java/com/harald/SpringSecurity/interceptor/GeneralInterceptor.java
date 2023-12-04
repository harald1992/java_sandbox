// package com.harald.SpringSecurity.interceptor;
//
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.lang.Nullable;
// import org.springframework.stereotype.Component;
// import org.springframework.web.servlet.HandlerInterceptor;
// import org.springframework.web.servlet.ModelAndView;
//
// @Component
// public class GeneralInterceptor implements HandlerInterceptor {
//
//     private Logger log = LoggerFactory.getLogger(GeneralInterceptor.class);
//
//     @Override
//     public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//         log.info("Prehandle:{}:{}", request.getRequestURI(), request.getMethod());
//         return true;
//         // return HandlerInterceptor.super.preHandle(request, response, handler);
//
//     }
//
//
//     @Override
//     public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView)
//             throws Exception {
//     }
//
//     @Override
//     public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
//     }
//
// }
