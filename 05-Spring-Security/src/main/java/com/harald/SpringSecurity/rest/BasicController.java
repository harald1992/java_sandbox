package com.harald.SpringSecurity.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {


    @GetMapping("/basic")
    public String getBasicReturn() {
        return "Hopefully works";
    }
}
