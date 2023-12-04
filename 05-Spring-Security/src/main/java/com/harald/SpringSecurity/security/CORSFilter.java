// package com.harald.SpringSecurity.security;
// //
// // import lombok.extern.slf4j.Slf4j;
// // import org.springframework.context.annotation.ComponentScan;
// // import org.springframework.stereotype.Component;
// // import jakarta.servlet.Filter;
// // import jakarta.servlet.FilterChain;
// // import jakarta.servlet.FilterConfig;
// // import jakarta.servlet.ServletException;
// // import jakarta.servlet.ServletRequest;
// // import jakarta.servlet.ServletResponse;
// // import jakarta.servlet.http.HttpServletRequest;
// // import jakarta.servlet.http.HttpServletResponse;
// //
// // import java.io.IOException;
// // import java.util.logging.LogRecord;
// //
// // @Component
// // @Slf4j
// // public class CORSFilter implements Filter {
// //
// //
// //     public CORSFilter() {
// //         log.info("SimpleCORSFilter init");
// //     }
// //
// //     @Override
// //     public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException, IOException {
// //
// //         HttpServletRequest request = (HttpServletRequest) req;
// //         HttpServletResponse response = (HttpServletResponse) res;
// //
// //         response.setHeader("Access-Control-Allow-Origin", "*");
// //         response.setHeader("Access-Control-Allow-Credentials", "true");
// //         response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
// //         response.setHeader("Access-Control-Max-Age", "3605");
// //         response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me");
// //
// //         chain.doFilter(req, res);
// //     }
// //
// //     @Override
// //     public void init(FilterConfig filterConfig) {
// //     }
// //
// //     @Override
// //     public void destroy() {
// //     }
// //
// // }
//
//
//
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.web.cors.CorsConfiguration;
// import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
// import org.springframework.web.filter.CorsFilter;
//
// @Configuration
// public class CORSFilter {
//
//     @Bean
//     public CorsFilter corsFilter() {
//         UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//         CorsConfiguration config = new CorsConfiguration();
//
//         // Allow requests from all origins, you can specify specific origins instead of "*"
//         config.addAllowedOrigin("http://localhost:5500");
//         config.addAllowedHeader("*");
//         config.addAllowedMethod("*");
//         config.setAllowCredentials(true);
//
//         source.registerCorsConfiguration("/**", config);
//         return new CorsFilter(source);
//     }
// }
