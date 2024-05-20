package com.harald.onsenauthservice.controller;

import com.harald.onsenauthservice.constants.EndpointConstants;
import com.harald.onsenauthservice.entity.UserDetailsImpl;
import com.harald.onsenauthservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(EndpointConstants.API_USERS_URL)
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;


    @GetMapping()
    public List<UserDetailsImpl> getAllUsers() {
        return userService.getUserList();
    }

}
