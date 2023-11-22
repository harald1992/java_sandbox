package com.harald.SpringCore.controllers;

import com.harald.SpringCore.interfaces.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private Coach myCoach;

    // setter injection
        @Autowired
        public void setCoach(Coach coach) {
            myCoach = coach;
        }

    @GetMapping("/hello")
      public String printHello() {
        return myCoach.getDailyWorkout();
    }
}
