package com.harald.jwtauth.controller;

import com.harald.jwtauth.dto.AuthRequestDto;
import com.harald.jwtauth.dto.AuthResponseDto;
import com.harald.jwtauth.entity.User;
import com.harald.jwtauth.entity.UserRole;
import com.harald.jwtauth.error.ApiError;
import com.harald.jwtauth.repository.RoleRepository;
import com.harald.jwtauth.repository.UserRepository;
import com.harald.jwtauth.service.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import static com.harald.jwtauth.constants.EndpointConstants.API_AUTH_URL;

@RestController
@RequestMapping(API_AUTH_URL)
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public AuthResponseDto login(@RequestBody AuthRequestDto authRequestDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequestDto.getUsername(), authRequestDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);   // what does this do?

        if (authentication.isAuthenticated()) {
            String jwt = jwtService.CreateJwt(authRequestDto.getUsername());

            return AuthResponseDto.builder()
                    .accessToken(jwt)
                    .token("Create refresh token later?").build();

        } else {
            throw new UsernameNotFoundException("invalid user request..!!");
        }

    }


    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody AuthRequestDto authRequestDto) {
        if (userRepository.existsByUsername(authRequestDto.getUsername())) {
            return new ResponseEntity<>("Username is taken!", HttpStatus.BAD_REQUEST);
        }

        User user = new User();
        user.setUsername(authRequestDto.getUsername());
        user.setPassword(passwordEncoder.encode((authRequestDto.getPassword())));
        user.setEnabled(true);

        List<UserRole> roles = roleRepository.findAllByName("USER");
        user.setRoles(roles);

        userRepository.save(user);

        return new ResponseEntity<>("User registered success!", HttpStatus.OK);
    }


}
