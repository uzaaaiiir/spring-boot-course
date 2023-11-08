package com.spring.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Track Coach: Run a hard 5k.";
    }
}
