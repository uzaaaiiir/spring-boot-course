package com.spring.springcoredemo.rest;

import com.spring.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachController {
    private Coach coach;

    private Coach coach2;

    @Autowired
    public CoachController(@Qualifier("cricketCoach") Coach coach,
                           @Qualifier("cricketCoach") Coach coach2) {
        System.out.printf("In constructor: %s%n", getClass().getSimpleName());
        this.coach = coach;
        this.coach2 = coach2;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return coach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check() {
        return String.format("Comparing beans: coach == coach2, %b", coach == coach2);
    }

}
