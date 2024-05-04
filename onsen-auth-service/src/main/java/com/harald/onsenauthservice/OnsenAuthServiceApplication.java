package com.harald.onsenauthservice;

import com.harald.onsenauthservice.service.UserService;
import com.harald.jwtshared.dto.AuthRequestDto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OnsenAuthServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnsenAuthServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(UserService userService) {
        return args -> userService.registerUser(new AuthRequestDto("postgres", "root", true));
    }

}
