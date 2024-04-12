package com.harald.jwtauthbff.controller;

import com.harald.jwtshared.dto.AuthRequestDto;
import com.harald.jwtshared.dto.AuthResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import static com.harald.jwtauthbff.constants.EndpointConstants.API_AUTH_URL;

@RestController
@RequestMapping(API_AUTH_URL)
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final RestTemplate restTemplate;


    @Value("${app.cookie_expiration_ms}")
    private int COOKIE_EXPIRATION_MS;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequestDto loginRequestDto) {

        String uri = "http://localhost:8082/api/v1/auth/login";

        AuthResponseDto result = restTemplate.postForObject(uri, loginRequestDto, AuthResponseDto.class);

        assert result != null;

        ResponseCookie cookie = ResponseCookie
                .from("accessToken", result.getAccessToken())
                .httpOnly(true)
                .secure(false)  // turn on when supporting https, which is not when doing locally
                .path("/")
                .maxAge(COOKIE_EXPIRATION_MS)
                .build();

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.SET_COOKIE, cookie.toString());

        return ResponseEntity.ok()
                .headers(headers)
                .body("Successful login");
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AuthRequestDto loginRequestDto) {

        String uri = "http://localhost:8082/api/v1/auth/register";

        String result = restTemplate.postForObject(uri, loginRequestDto, String.class);

        return ResponseEntity.ok().body(result);
    }

}
