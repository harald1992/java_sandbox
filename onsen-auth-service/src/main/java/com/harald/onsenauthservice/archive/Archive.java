// package com.harald.jwtauth.archive;
//
// import com.harald.jwtauth.filter.JwtAuthFilter;
// import com.harald.jwtauth.service.UserService;
// import lombok.RequiredArgsConstructor;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.AuthenticationProvider;
// import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
// import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.provisioning.JdbcUserDetailsManager;
// import org.springframework.security.provisioning.UserDetailsManager;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
// import javax.sql.DataSource;
//
// import static com.harald.jwtauth.constants.EndpointConstants.API_AUTH_URL;
//
// public class Archive {
// package com.harald.jwtauth.configuration;
//
// import com.harald.jwtauth.filter.JwtAuthFilter;
// import com.harald.jwtauth.service.UserService;
// import lombok.RequiredArgsConstructor;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.AuthenticationProvider;
// import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
// import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.provisioning.JdbcUserDetailsManager;
// import org.springframework.security.provisioning.UserDetailsManager;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
// import javax.sql.DataSource;
//
// import static com.harald.jwtauth.constants.EndpointConstants.API_AUTH_URL;
//
//     @Configuration
//     @RequiredArgsConstructor
//     public class SecurityConfig {
//
//         private final JwtAuthFilter jwtAuthFilter;
//
//         private final AuthenticationProvider authenticationProvider;
//
//         private final UserService userService;
//
//         @Bean
//         public PasswordEncoder passwordEncoder() {
//             return new BCryptPasswordEncoder();
//         }
//
//         @Bean
//         public AuthenticationProvider authenticationProvider() {    // DAO (Data access object) to fetch user details and encode passwords
//             DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//             authenticationProvider.setUserDetailsService(userService);
//             authenticationProvider.setPasswordEncoder(passwordEncoder());
//             return authenticationProvider;
//         }
//
//         @Bean
//         public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
//             return config.getAuthenticationManager();
//         }
//
//         @Bean
//         public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//             http
//                     .authorizeHttpRequests(configurer ->
//                             configurer
//                                     .requestMatchers(API_AUTH_URL + "/**").permitAll()
//                                     .anyRequest().authenticated()
//                     )
//                     .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                     .authenticationProvider(authenticationProvider)
//                     .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)      // add this one before JwtAuthenticationFilter??
//                     .csrf(AbstractHttpConfigurer::disable);
//
//             return http.build();
//         }
//
//
//         /* Maybe not used anymore: */
//         @Bean
//         public UserDetailsManager userDetailsManager(DataSource dataSource) {
//             // Data source is auto configured by spring boot
//
//             //  If not following the standard table structure
//             JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
//             userDetailsManager.setUsersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username=?");
//             userDetailsManager.setAuthoritiesByUsernameQuery("SELECT username, role FROM authorities WHERE username=?");
//
//
//             //  Tell spring security to use JDBC authentication with our datasource. Will automatically check the database, as long as it conforms to
//             //  the users and authorities stuff.
//             return new JdbcUserDetailsManager(dataSource);
//         }
//
//     }
//
// /*
// // @Bean
// // public SecurityFilterChain filterChainOLD(HttpSecurity http) throws Exception {
// //     http.authorizeHttpRequests((configurer ->
// //             configurer
// //                     .requestMatchers(HttpMethod.GET, EndpointConstants.API_USERS_URL).hasRole("ADMIN")
// //                     .requestMatchers("/**").permitAll()
// //     ));
// //
// //
// //     // This method configures HTTP Basic authentication. Customizer.withDefaults() provides default settings for HTTP Basic authentication.
// //     http.httpBasic(Customizer.withDefaults());
// //
// //     //  This method disables CSRF (Cross-Site Request Forgery) protection. CSRF protection is typically disabled for stateless applications or
// //     //  APIs where CSRF attacks are not a concern.
// //     http.csrf(csrf -> csrf.disable());
// //
// //     return http.build();
// //
// // }
//
//    BCRYPT:
// - Performs one way hashing, so cannot decrypt it. Only hash the input and check if the output is the same as the originally hashed password in the
// database.
// - Also adds random salt so passwords that are the same can have different outputs.
// - Includes support for brute force attacks.
// - 68 characters, {bcrypt}=8chars, encodedPassword=60chars.
//
//
//
// // public InMemoryUserDetailsManager userDetailsManager() {
// // @Bean
// //     UserDetails admin = User.builder()
// //             .username("admin")
// //             .password("{noop}root")
// //             .roles("EMPLOYEE", "MANAGER", "ADMIN")
//
// //     return new InMemoryUserDetailsManager(employee, manager, admin);
// //     // overrides username and password if set in applications properties
// */
// }
