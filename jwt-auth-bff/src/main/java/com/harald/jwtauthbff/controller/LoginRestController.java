package com.harald.jwtauthbff.controller;

import com.harald.jwtauthbff.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static com.harald.jwtauthbff.constants.EndpointConstants.API_LOGIN_URL;

@RestController
@RequestMapping(API_LOGIN_URL)
public class LoginRestController {

    @GetMapping()
    public ResponseEntity<List<UserDto>> getAllUsers(@RequestBody final UserDto user) {
        String uri = "http://localhost:8082/api/v1/users";
        RestTemplate restTemplate = new RestTemplate();
        List<UserDto> result = restTemplate.getForObject(uri, List.class);
        return ResponseEntity.ok(result);
    }

    @PostMapping()
    public ResponseEntity<Boolean> login(@RequestBody final UserDto user) {
        String uri = "http://localhost:8082/api/v1/users";
        RestTemplate restTemplate = new RestTemplate();
        Boolean result = restTemplate.postForObject(uri, user, Boolean.class);
        return ResponseEntity.ok(result);
    }




}
