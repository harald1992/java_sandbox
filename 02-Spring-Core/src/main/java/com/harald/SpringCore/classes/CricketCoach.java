package com.harald.SpringCore.classes;

import com.harald.SpringCore.interfaces.Coach;
import org.springframework.stereotype.Component;

@Component  // mark as spring bean for dependency injection
public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Run 5 miles!!";
    }

}
