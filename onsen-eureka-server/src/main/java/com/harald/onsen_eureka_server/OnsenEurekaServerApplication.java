package com.harald.onsen_eureka_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer	// convert spring app to service discovery using eureka netflix
public class OnsenEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnsenEurekaServerApplication.class, args);
	}

}
