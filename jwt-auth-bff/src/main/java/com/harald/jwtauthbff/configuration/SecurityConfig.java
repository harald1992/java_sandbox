package com.harald.jwtauthbff.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
// @EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    //
    // private final JwtAuthenticationFilter jwtAuthFilter;    // automatically created via spring and requiredArgsConstructor.
    //
    // private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
                //
           http.authorizeHttpRequests((configurer) -> configurer
                        // .requestMatchers(API_AUTH_URL + "/**").permitAll() // only permit the auth endpoints without authentication
                        .anyRequest().permitAll())   // for all other requests the user needs to be authenticated.

        // .formLogin(form -> form.defaultSuccessUrl("/admin")
        //         .loginPage("/login")
        //            .failureUrl("/login"));

                // )
                // .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // .authenticationProvider(authenticationProvider)
                // .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)      // add this one before JwtAuthenticationFilter??
        ;  // stateless: new session for each request.
        // http.httpBasic(Customizer.withDefaults());


        //  This method disables CSRF (Cross-Site Request Forgery) protection. CSRF protection is typically disabled for stateless applications or
        //  APIs where CSRF attacks are not a concern.
        http.csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }

}