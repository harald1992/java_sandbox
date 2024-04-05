package com.harald.jwtauthbff.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

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
    public ResponseEntity<Object> getAllUsers() {
        String apiUrl = "http://localhost:8082/api/v1/users";
       try { var result = restTemplate.getForObject(apiUrl, List.class);
           return ResponseEntity.ok(result);

       } catch (RestClientException rce) {
           return new ResponseEntity<>(
                   rce.getMessage(),
                   HttpStatus.FORBIDDEN);
       }

    }

}
