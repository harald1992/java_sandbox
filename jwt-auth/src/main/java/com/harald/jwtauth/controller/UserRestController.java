package com.harald.jwtauth.controller;

import com.harald.jwtauth.constants.EndpointConstants;
import com.harald.jwtauth.entity.User;
import com.harald.jwtauth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(EndpointConstants.API_USERS_URL)
@RequiredArgsConstructor
public class UserRestController {

  private final  UserService userService;

    @GetMapping()
    public List<User> getAllUsers() {
       return userService.getUserList();
    }

}
