package com.harald.jwtauth.controller;

import com.harald.jwtauth.service.JwtService;
import com.harald.jwtauth.service.UserDetailsServiceImpl;
import com.harald.jwtauth.service.UserService;
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

import static com.harald.jwtauth.constants.EndpointConstants.API_AUTH_URL;

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
    public AuthResponseDto login(@Valid @RequestBody AuthRequestDto authRequestDto) {
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
    public ResponseEntity<String> register(@Valid  @RequestBody AuthRequestDto authRequestDto) {

        userService.registerUser(authRequestDto);
        //
        // User user = new User();
        // user.setUsername(authRequestDto.getUsername());
        // user.setPassword(passwordEncoder.encode((authRequestDto.getPassword())));
        // user.setEnabled(true);
        //
        // List<UserRole> roles = roleRepository.findAllByName("USER");
        // user.setRoles(roles);
        //
        // userRepository.save(user);

        return new ResponseEntity<>("User registered success!", HttpStatus.OK);
    }


}
