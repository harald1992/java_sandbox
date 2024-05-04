package com.harald.onsenapigateway.filter;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class CustomGlobalFilter implements GlobalFilter, Ordered {

    private final AuthenticationFilter authenticationFilter;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        return authenticationFilter.apply(new AuthenticationFilter.Config()).filter(exchange, chain);
    }

    @Override
    public int getOrder() {
        // Ensure your filter runs early in the filter chain
        return Ordered.HIGHEST_PRECEDENCE;
    }

}
