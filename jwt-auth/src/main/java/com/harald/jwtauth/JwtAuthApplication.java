package com.harald.jwtauth;

import com.harald.jwtauth.entity.User;
import com.harald.jwtauth.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class JwtAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtAuthApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        // String password = passwordEncoder.encode("root");
        String password = "root";

        User user = User
                .builder()
                .username("postgres")
                .password(password)
                .enabled(true)
                .build();
        return args -> userRepository.save(user);
    }

}
