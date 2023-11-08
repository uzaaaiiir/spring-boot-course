package com.spring.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    public TennisCoach() {
        System.out.printf("In constructor: %s%n", getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Tennis Coach: Practice backhand volley.";
    }
}
