// package com.harald.jwtauth.aspect;
//
// import org.aspectj.lang.JoinPoint;
// import org.aspectj.lang.annotation.Aspect;
// import org.aspectj.lang.annotation.Before;
// import org.springframework.stereotype.Component;
// import org.springframework.web.bind.annotation.ControllerAdvice;
//
// @Aspect
// @Component
// public class LoggerAdvice {// Advice means it is performing an action at a certain JoinPoint.
//     // Aspect means to support cross-cutting concerns like logging, profiling, caching and transaction management.
//
//
//     @Before("within(com.harald..*)")
//     public void logBefore(JoinPoint joinPoint) {
//         // System.out.println("LoggerAdvice Log Before");
//         System.out.println(joinPoint.toString());
//
//         // System.out.println("Before method: " + joinPoint.getSignature().getName());
//
//     }
//
// }
