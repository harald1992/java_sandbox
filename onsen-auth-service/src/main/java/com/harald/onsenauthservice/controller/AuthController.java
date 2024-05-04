package com.harald.onsenauthservice.controller;

import com.harald.onsenauthservice.service.JwtService;
import com.harald.onsenauthservice.service.UserDetailsServiceImpl;
import com.harald.onsenauthservice.service.UserService;
import com.harald.jwtshared.dto.AuthRequestDto;
import com.harald.jwtshared.dto.AuthResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.harald.onsenauthservice.constants.EndpointConstants.API_AUTH_URL;

@RestController
@RequestMapping(API_AUTH_URL)
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    // private final UserRepository userRepository;

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    private final UserDetailsServiceImpl userDetailsServiceImpl;

    private final UserService userService;


    @PostMapping("/login")
    public ResponseEntity<Void> login(@Valid @RequestBody AuthRequestDto authRequestDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequestDto.getUsername(), authRequestDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);   // what does this do?

        if (authentication.isAuthenticated()) {
            String jwt = jwtService.CreateJwt(authRequestDto.getUsername());

            return ResponseEntity.ok().header("Authorization", "Bearer " + jwt).build();

        } else {
            throw new UsernameNotFoundException("invalid user request..!!");
        }

    }


    @PostMapping("register")
    public ResponseEntity<String> register(@Valid @RequestBody AuthRequestDto authRequestDto) {
        userService.registerUser(authRequestDto);
        return new ResponseEntity<>("User registered success!", HttpStatus.OK);
    }

    @PostMapping("validate")
    public ResponseEntity<Boolean> validateJwt(@RequestBody String jwt) {
        boolean isValidToken = jwtService.isTokenValid(jwt);

        return isValidToken ? ResponseEntity.ok(true) : ResponseEntity.status(HttpStatus.FORBIDDEN).body(false);

    }


}
