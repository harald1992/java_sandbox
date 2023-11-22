package com.harald.SpringCore.config;

import com.harald.SpringCore.classes.Cat;
import com.harald.SpringCore.interfaces.Animal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnimalConfig {

    @Bean
    public Animal cat() {
        return new Cat();
    }

}
