package com.harald.jwtauthbff.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

import static com.harald.jwtauthbff.constants.EndpointConstants.API_USER_URL;

@RestController
@RequestMapping(API_USER_URL)

public class UserRestController {

    private final RestTemplate restTemplate;

    public UserRestController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping()
    public ResponseEntity<Object> getAllUsers(HttpServletRequest request) {
        // String jwt = "";
        // Cookie[] cookies = request.getCookies();
        //
        // if (cookies != null) {
        //     for (Cookie cookie : cookies) {
        //         if (cookie.getName().equals("accessToken")) {
        //             jwt = cookie.getValue();
        //         }
        //     }
        // }

        // HttpHeaders headers = new HttpHeaders();
        // headers.add("Authorization", "Bearer " + jwt);
        HttpEntity<String> entity = new HttpEntity<>(new HttpHeaders());
        String apiUrl = "http://localhost:8082/api/v1/users";

        ResponseEntity<Object> result = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, Object.class);
        return result;

    }

}
