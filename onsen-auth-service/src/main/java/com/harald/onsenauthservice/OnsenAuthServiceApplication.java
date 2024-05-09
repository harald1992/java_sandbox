package com.harald.onsenauthservice;

import com.harald.onsenauthservice.dto.AuthRequestDto;
import com.harald.onsenauthservice.service.UserService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAwareImpl")
@OpenAPIDefinition(
        info = @Info(
                title = "Auth Service",
                description = "Creating and validating JWT",
                version = "v1",
                license = @License(
                        name = "Apache 2.0",
                        url = "www.example.com/license"
                )
        )
)
public class OnsenAuthServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnsenAuthServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(UserService userService) {
        return args -> userService.registerUser(new AuthRequestDto("postgres", "root", true));
    }

}
