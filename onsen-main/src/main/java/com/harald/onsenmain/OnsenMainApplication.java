package com.harald.onsenmain;

import com.harald.onsenmain.dto.BuildInfoDto;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties(value = { BuildInfoDto.class })
@EnableDiscoveryClient
public class OnsenMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnsenMainApplication.class, args);
	}

}
