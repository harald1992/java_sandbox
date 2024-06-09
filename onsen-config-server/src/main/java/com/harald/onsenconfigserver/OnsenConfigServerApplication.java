package com.harald.onsenconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class OnsenConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnsenConfigServerApplication.class, args);
    }
}
