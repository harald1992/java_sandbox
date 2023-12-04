// // package com.harald.SpringSecurity.advice;
// //
// // import lombok.extern.slf4j.Slf4j;
// // import org.aspectj.lang.ProceedingJoinPoint;
// // import org.aspectj.lang.annotation.Around;
// // import org.aspectj.lang.annotation.Aspect;
// // import org.aspectj.lang.annotation.Pointcut;
// // import org.slf4j.Logger;
// // import org.slf4j.LoggerFactory;
// // import org.springframework.stereotype.Component;
// //
// // import java.util.Arrays;
// //
// // @Aspect
// // @Component
// // // @Slf4j
// // public class LoggingAdvice {
// //
// //     private final Logger log = LoggerFactory.getLogger(LoggingAdvice.class);
// //
// //     // @Pointcut(value="execution(* com.harald.SpringSecurity.rest.EmployeeRestController.*(..) )")
// //     @Pointcut(value="execution(* com.harald.SpringSecurity.*.*.*(..) )")    // all over the app
// //     public void myPointcut() {  // define the path where to implement the applicationLogger
// //
// //     }
// //
// //
// //     @Around("myPointcut()")
// //     public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
// //         String methodName = pjp.getSignature().getName();
// //         String className = pjp.getTarget().getClass().toString();
// //         Object[] arguments = pjp.getArgs();
// //         log.info("LoggingAdvice: method invoked " + className + " : " + methodName + "()" + "arguments: " + Arrays.toString(arguments));
// //
// //        Object object =  pjp.proceed();
// //         log.info("LoggingAdvice: method finished " + className + " : " + methodName + "()" + "returned object: " + object.toString());
// //        return object;
// //     }
// //
// // }
//
//
// package com.harald.SpringSecurity.advice;
//
// import lombok.extern.slf4j.Slf4j;
// import org.aspectj.lang.ProceedingJoinPoint;
// import org.aspectj.lang.annotation.Around;
// import org.aspectj.lang.annotation.Aspect;
// import org.aspectj.lang.annotation.Pointcut;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.core.annotation.Order;
// import org.springframework.stereotype.Component;
//
// import com.fasterxml.jackson.databind.ObjectMapper;
//
// @Aspect
// @Component
// @Slf4j
// public class LoggingAdvice {
//
//     @Pointcut(value = "execution(* com.harald.SpringSecurity.rest.EmployeeRestController.*(..) )")
//     // have to be specific, cannot do wildcard otherwise the aspect will try to fetch the requestRsponseLogger which creates a nullPointerException
//     public void myPointcut() {
//     }
//
//     @Around("myPointcut()")
//     public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
//         ObjectMapper mapper = new ObjectMapper();
//         String methodName = pjp.getSignature().getName();
//         String className = pjp.getTarget().getClass().toString();
//         Object[] array = pjp.getArgs();
//         log.info("method invoked " + className + " : " + methodName + "()" + "arguments : "
//                 + mapper.writeValueAsString(array));
//         Object object = pjp.proceed();
//         log.info(className + " : " + methodName + "()" + "Response : "
//                 + mapper.writeValueAsString(object));
//         return object;
//     }
//
// }