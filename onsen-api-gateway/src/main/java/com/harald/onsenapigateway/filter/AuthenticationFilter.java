package com.harald.onsenapigateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

    private final RestTemplate restTemplate;

    public AuthenticationFilter(RestTemplate restTemplate) {
        super(Config.class);
        this.restTemplate = restTemplate;
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (((exchange, chain) -> {
            String path = exchange.getRequest().getPath().toString();

            if (path.contains("/api/v1/auth/")) {
                log.info(path + " is an open endpoint, no jwt cookie  needed in this call");
                return chain.filter(exchange);
            }

            log.info(path + " is a protected endpoint, validating if the user is logged in via the cookie.");
            MultiValueMap<String, HttpCookie> cookies = exchange.getRequest().getCookies();
            HttpCookie setCookieJwt = cookies.getFirst(HttpHeaders.SET_COOKIE);
            assert setCookieJwt != null;
            String payload = setCookieJwt.getValue();

            try {
                Boolean isValidToken = restTemplate.postForObject("https://localhost:8081/api/v1/auth/validate", payload, Boolean.class);
                log.info("JWT token is : " + isValidToken);

                if (isValidToken == null || !isValidToken) {
                    throw new RuntimeException("Invalid JWT token");
                }
            } catch (Exception e) {
                log.error(e.getMessage());
                throw new RuntimeException("Unauthorized or another error occurred");
            }

            return chain.filter(exchange);
        }));
    }

    public static class Config {

    }


}
