package com.spring.springcoredemo.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class SwimCoach implements Coach {
    public SwimCoach() {
        System.out.printf("In constructor: %s%n", getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim Coach: Swim 1000m today as a warm-up.";
    }
}
