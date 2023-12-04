// package com.harald.SpringSecurity.filters;
//
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.core.annotation.Order;
// import org.springframework.stereotype.Component;
// import org.springframework.web.filter.OncePerRequestFilter;
//
// import jakarta.servlet.FilterChain;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;
// import java.io.IOException;
// import java.util.Base64;
// import java.util.stream.Collectors;
//
// @Component
// public class RequestResponseLogger extends OncePerRequestFilter {
//
//     private static final Logger logger = LoggerFactory.getLogger(RequestResponseLogger.class);
//
//     @Override
//     protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//             throws ServletException, IOException {
//         logRequestDetails(request);
//         filterChain.doFilter(request, response);
//     }
//
//     private void logRequestDetails(HttpServletRequest request) throws IOException {
//         StringBuilder requestLog = new StringBuilder();
//         requestLog.append("URI: ").append(request.getRequestURI()).append("\n");
//         requestLog.append("Method: ").append(request.getMethod()).append("\n");
//
//         String authorizationHeader = request.getHeader("Authorization");
//         if (authorizationHeader != null && authorizationHeader.startsWith("Basic ")) {
//             String base64Credentials = authorizationHeader.substring(6);
//             String credentials = new String(Base64.getDecoder().decode(base64Credentials));
//             requestLog.append("Authorization Header: ").append(credentials).append("\n");
//         }
//
//         String requestBody = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
//         if (!requestBody.isEmpty()) {
//             requestLog.append("Body: ").append(requestBody).append("\n");
//         }
//
//         logger.info(requestLog.toString());
//     }
// }
