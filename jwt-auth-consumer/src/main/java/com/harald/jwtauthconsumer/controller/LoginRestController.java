package com.harald.jwtauthconsumer.controller;

import com.harald.jwtauthconsumer.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static com.harald.jwtauthconsumer.constants.EndpointConstants.API_LOGIN_URL;

@RestController
@RequestMapping(API_LOGIN_URL)
public class LoginRestController {


    @PostMapping()
    public ResponseEntity<List<UserDto>> login(@RequestBody final UserDto user) {
        String uri = "http://localhost:8082/api/v1/users";
        RestTemplate restTemplate = new RestTemplate();
        List<UserDto> result = restTemplate.getForObject(uri, List.class);
        return ResponseEntity.ok(result);
    }

}
