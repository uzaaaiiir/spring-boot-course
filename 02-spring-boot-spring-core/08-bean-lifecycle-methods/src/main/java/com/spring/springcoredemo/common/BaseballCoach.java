package com.spring.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements  Coach {

    public BaseballCoach() {
        System.out.printf("In constructor: %s%n", getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Baseball coach: Spend 30 minutes in batting practice.";
    }
}
