package com.harald.onsenauthservice.controller;

import com.harald.onsenauthservice.entity.UserDetailsImpl;
import com.harald.onsenauthservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.harald.onsenauthservice.constants.EndpointConstants.API_USERS_URL;

@RestController
@RequestMapping(API_USERS_URL)
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    @GetMapping()
    public List<String> getAllUsers() {
        return userService.getUserList().stream().map(UserDetailsImpl::getUsername).toList();
    }

}
