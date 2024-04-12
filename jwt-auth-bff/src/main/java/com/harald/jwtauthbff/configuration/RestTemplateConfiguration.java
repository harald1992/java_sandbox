package com.harald.jwtauthbff.configuration;

import com.harald.jwtauthbff.interceptor.CookieContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

@Configuration
@Slf4j
public class RestTemplateConfiguration {

    @Bean
    RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(basicAuthInterceptor());
        return restTemplate;
    }

    @Bean
    public ClientHttpRequestInterceptor basicAuthInterceptor() {
        return (request, body, execution) -> {
            String jwt = CookieContextHolder.getCookie();
            if (jwt != null) {
                request.getHeaders().add("Authorization", "Bearer " + jwt);
                CookieContextHolder.clear();
            }
            return execution.execute(request, body);
        };
    }


}
