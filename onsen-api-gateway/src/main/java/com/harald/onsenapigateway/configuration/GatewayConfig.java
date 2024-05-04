package com.harald.onsenapigateway.configuration;

import lombok.extern.slf4j.Slf4j;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
import org.apache.hc.client5.http.io.HttpClientConnectionManager;
import org.apache.hc.client5.http.ssl.SSLConnectionSocketFactory;
import org.apache.hc.core5.ssl.SSLContextBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

@Configuration
@Slf4j
public class GatewayConfig {

    @Value("${trust.store}")
    private Resource trustStore;

    @Value("${trust.password}")
    private String trustStorePassword;


    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("login-get-cookie", r -> r.path("/api/v1/auth/login")
                        .filters(f -> f.filter((exchange, chain) ->
                                chain.filter(exchange).then
                                        (Mono.fromRunnable(() ->
                                        {
                                            ServerHttpResponse response = exchange.getResponse();
                                            //
                                            String bearerHeader = response.getHeaders().getFirst("Authorization");
                                            assert bearerHeader != null;
                                            String accessToken = bearerHeader.substring(7);

                                            ResponseCookie cookie = ResponseCookie.from(HttpHeaders.SET_COOKIE, accessToken)
                                                    .httpOnly(true)
                                                    .secure(true)
                                                    .path("/")
                                                    .maxAge(1800)   // 30 min
                                                    .build();

                                            response.addCookie(cookie); // Add the cookie to the response

                                        }))))
                        .uri("https://localhost:8081"))
                .route("auth-service", r -> r.path("/api/v1/auth/**")
                        .uri("https://localhost:8081"))
                .route("onsen-main", r -> r.path("/api/v1/**")
                        .uri("https://localhost:8082"))
                .build();
    }


    @Bean
    public RestTemplate restTemplate() throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException,
            CertificateException, IOException {

        SSLContext sslContext = new SSLContextBuilder()
                .loadTrustMaterial(trustStore.getURL(), trustStorePassword.toCharArray()).build();
        SSLConnectionSocketFactory sslConFactory = new SSLConnectionSocketFactory(sslContext);
        HttpClientConnectionManager cm = PoolingHttpClientConnectionManagerBuilder.create()
                .setSSLSocketFactory(sslConFactory)
                .build();
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();
        ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
        return new RestTemplate(requestFactory);
    }

}
