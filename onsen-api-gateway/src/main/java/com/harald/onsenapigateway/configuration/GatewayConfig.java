package com.harald.onsenapigateway.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.server.reactive.ServerHttpResponse;
import reactor.core.publisher.Mono;

@Configuration
@Slf4j
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/onsen-main/**")
                        .filters(f -> f.rewritePath("/onsen-main/?(?<remaining>.*)", "/${remaining}"))
                        .uri("lb://ONSEN-MAIN")
                )
                .route(r -> r.path("/onsen-auth-service/**")
                        .filters(f -> f.rewritePath("/onsen-auth-service/?(?<remaining>.*)", "/${remaining}"))
                        .uri("lb://ONSEN-AUTH-SERVICE")
                )
                //
                // .route("login-get-cookie", r -> r.path("/api/v1/auth/login")
                //         .filters(f -> f.filter((exchange, chain) ->
                //                 chain.filter(exchange).then
                //                         (Mono.fromRunnable(() ->
                //                         {
                //                             ServerHttpResponse response = exchange.getResponse();
                //                             //
                //                             String bearerHeader = response.getHeaders().getFirst("Authorization");
                //                             assert bearerHeader != null;
                //                             String accessToken = bearerHeader.substring(7);
                //
                //                             ResponseCookie cookie = ResponseCookie.from(HttpHeaders.SET_COOKIE, accessToken)
                //                                     .httpOnly(true)
                //                                     .secure(true)
                //                                     .path("/")
                //                                     .maxAge(1800)   // 30 min
                //                                     .build();
                //
                //                             response.addCookie(cookie); // Add the cookie to the response
                //
                //                         }))))
                //         .uri("http://localhost:8081"))
                // .route("auth-service", r -> r.path("/api/v1/auth/**")
                //         .uri("http://localhost:8081"))
                // .route("onsen-main", r -> r.path("/api/v1/**")
                //         .uri("http://localhost:8082"))
                .build();
    }

}
