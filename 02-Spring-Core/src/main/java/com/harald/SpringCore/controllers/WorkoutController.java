package com.harald.SpringCore.controllers;

import com.harald.SpringCore.interfaces.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkoutController {

    private Coach myCoach;


    // constructor injection
    // @Autowired
    // public WorkoutController(Coach coach) {
    //     myCoach = coach;
    // }

    // bij meer classes voor interface moet je aangeven welke specifiek door Qualifier
    @Autowired
    public WorkoutController(@Qualifier("cricketCoach") Coach coach) {
        myCoach = coach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }


}
