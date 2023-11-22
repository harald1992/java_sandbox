package com.harald.SpringCore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.harald.SpringCore.interfaces.Coach;

@RestController
public class FieldInjectionController {

// Field injection is not recommended anymore by the spring team because it is harder to unit test.
    @Autowired
    private Coach myCoach;

    @GetMapping("hello2")
    public String printStuff() {
        return myCoach.getDailyWorkout();
    }

}
