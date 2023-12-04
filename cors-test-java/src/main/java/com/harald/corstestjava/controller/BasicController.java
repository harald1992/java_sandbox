package com.harald.corstestjava.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class BasicController {


    @GetMapping("/basic")
    public String getString() {
        return "Basic String!!!";
    }
}
