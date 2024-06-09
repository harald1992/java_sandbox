package com.harald.onsenconfigserver;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class BusrefreshCommandLineRunner implements CommandLineRunner {

    @Value("${server.port}")
    private String port;

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public void run(String... args) throws Exception {
        log.info("Starting CommandLineRunner to call busrefresh");
        String url = "http://localhost:" + port + "/actuator/busrefresh";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        Runnable task = () -> {
            try {
                restTemplate.postForObject(url, requestEntity, Void.class);
                log.info("Busrefresh finished successfully");
                scheduler.shutdown(); // Stop the scheduler

            } catch (Exception e) {
                log.error("Health check to busrefresh failed, retrying... ErrorMessage: " + e.getMessage());
            }
        };

        scheduler.scheduleAtFixedRate(task, 1, 5, TimeUnit.SECONDS);
    }

}
