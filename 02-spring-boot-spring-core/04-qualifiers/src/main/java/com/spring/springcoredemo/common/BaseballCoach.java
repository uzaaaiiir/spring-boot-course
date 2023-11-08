package com.spring.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements  Coach{
    @Override
    public String getDailyWorkout() {
        return "Baseball coach: Spend 30 minutes in batting practice.";
    }
}
