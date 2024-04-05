package com.harald.jwtauthbff.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
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
            // HttpHeaders headers = request.getHeaders();
            // headers.setBasicAuth("postgres", "root");
            // headers.setBasicAuth("john", "root");
            // log.info("Request Headers: {}", request.getHeaders());

            return execution.execute(request, body);
        };
    }


}
