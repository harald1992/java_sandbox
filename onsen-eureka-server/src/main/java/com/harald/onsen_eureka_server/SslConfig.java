// package com.harald.onsen_eureka_server;
//
// import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
// import org.apache.hc.client5.http.impl.classic.HttpClients;
// import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
// import org.apache.hc.client5.http.io.HttpClientConnectionManager;
// import org.apache.hc.client5.http.ssl.SSLConnectionSocketFactory;
// import org.apache.hc.core5.ssl.SSLContextBuilder;
// import org.apache.http.conn.ssl.NoopHostnameVerifier;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.core.io.Resource;
// import org.springframework.http.client.ClientHttpRequestFactory;
// import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
// import org.springframework.web.client.RestTemplate;
//
// import javax.net.ssl.SSLContext;
// import java.io.IOException;
// import java.security.KeyManagementException;
// import java.security.KeyStore;
// import java.security.KeyStoreException;
// import java.security.NoSuchAlgorithmException;
// import java.security.cert.CertificateException;
//
// @Configuration
// public class SslConfig {
//
//     @Value("${trust.store}")
//     private Resource trustStore;
//
//     @Value("${trust.password}")
//     private String trustStorePassword;
//
//     @Bean
//     public RestTemplate restTemplate() throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException, KeyManagementException {
//
//         // SSLContext sslContext = new SSLContextBuilder()
//         //         .loadTrustMaterial(trustStore.getURL(), trustStorePassword.toCharArray()).build();
//         // SSLConnectionSocketFactory sslConFactory = new SSLConnectionSocketFactory(sslContext);
//         // HttpClientConnectionManager cm = PoolingHttpClientConnectionManagerBuilder.create()
//         //         .setSSLSocketFactory(sslConFactory)
//         //         .build();
//         // CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();
//         CloseableHttpClient httpClient = httpClient();
//         ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
//         return new RestTemplate(requestFactory);
//     }
//
//     @Bean
//     public CloseableHttpClient httpClient() throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException,
//     CertificateException, IOException {
//         SSLContext sslContext = new SSLContextBuilder()
//                 .loadTrustMaterial(trustStore.getURL(), trustStorePassword.toCharArray()).build();
//         SSLConnectionSocketFactory sslConFactory = new SSLConnectionSocketFactory(sslContext);
//         HttpClientConnectionManager connectionManager = PoolingHttpClientConnectionManagerBuilder.create()
//                 .setSSLSocketFactory(sslConFactory)
//                 .build();
//
//         return HttpClients.custom().setConnectionManager(connectionManager).build();
//     }
//
// }
