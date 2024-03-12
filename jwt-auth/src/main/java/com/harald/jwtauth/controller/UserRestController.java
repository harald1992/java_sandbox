package com.harald.jwtauth.controller;

import com.harald.jwtauth.constants.EndpointConstants;
import com.harald.jwtauth.dto.UserDto;
import com.harald.jwtauth.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(EndpointConstants.API_USERS_URL)
public class UserRestController {

    UserService userService;

    public UserRestController(final UserService userService
    ) {
        this.userService = userService;
    }

    @PostConstruct
    private void setDatabase() {
        userService.deleteAll();
        userService.addUser(new UserDto("Bert", "Wachtwoord1234"));
    }

    @GetMapping()
    public List<UserDto> getAllUsers() {
       return userService.getUserList();

    }

}
