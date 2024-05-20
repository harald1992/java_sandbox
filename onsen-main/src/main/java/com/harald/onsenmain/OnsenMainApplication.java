package com.harald.onsenmain;

import com.harald.onsenmain.dto.BuildInfoDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = { BuildInfoDto.class })
public class OnsenMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnsenMainApplication.class, args);
	}

}
