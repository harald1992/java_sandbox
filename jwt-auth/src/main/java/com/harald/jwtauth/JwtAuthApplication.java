package com.harald.jwtauth;

import com.harald.jwtauth.service.UserService;
import com.harald.jwtshared.dto.AuthRequestDto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JwtAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtAuthApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(UserService userService) {
        return args -> userService.registerUser(new AuthRequestDto("postgres", "root"));
    }

}
