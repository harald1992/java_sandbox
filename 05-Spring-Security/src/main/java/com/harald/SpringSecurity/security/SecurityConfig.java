package com.harald.SpringSecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
public class SecurityConfig {


    // users and roles
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails employee = User.builder().username("employee")
                .password("{noop}root")
                .roles("EMPLOYEE")
                .build();

        UserDetails manager = User.builder()
                .username("manager")
                .password("{noop}root")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password("{noop}root")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(employee, manager, admin);
        // overrides username and password if set in applications properties
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/employees").hasRole("ADMIN")
                        // .requestMatchers(HttpMethod.OPTIONS, "/api/employees").hasRole("EMPLOYEE")
        ));
        // use basic authentication
        http.httpBasic(Customizer.withDefaults());
        // http.cors(cors -> cors.disable());
        // disable anti CSRF, not needed for stateless REST API's that use POST, PUT, PATCH, DELETE
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }

    // @Bean
    // CorsConfigurationSource corsConfigurationSource() {
    //     CorsConfiguration configuration = new CorsConfiguration();
    //     configuration.setAllowedOrigins(Arrays.asList("https://localhost:5050"));
    //     configuration.setAllowedMethods(Arrays.asList("GET","POST"));
    //     UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    //     source.registerCorsConfiguration("/**", configuration);
    //     return source;
    // }


}