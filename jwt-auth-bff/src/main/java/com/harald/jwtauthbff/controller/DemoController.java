package com.harald.jwtauthbff.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.harald.jwtauthbff.constants.EndpointConstants.API_DEMO_URL;

@RestController
@RequestMapping(API_DEMO_URL)
public class DemoController {

    @GetMapping()
    public ResponseEntity<String> helloWorld(HttpServletRequest request) {

        // TODO: check cookie and fetch jwt and send in requests in http interceptor or filter or smth.
        // Cookie[] cookies = request.getCookies();
        // String jwt;
        // if (cookies != null) {
        //     for (Cookie cookie : cookies) {
        //         if (cookie.getName().equals("accessToken")) {
        //             jwt = cookie.getValue();
        //         }
        //     }
        // }
        return ResponseEntity.ok("Hello world");
    }


}
