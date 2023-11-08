package com.spring.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.printf("In constructor: %s%n", getClass().getSimpleName());
    }

    // define init method (during initialization of bean)
    @PostConstruct
    public void startup() {
        System.out.printf("Startup: %s%n", getClass().getSimpleName());
    }

    @PreDestroy
    public void destroy() {
        System.out.printf("Cleanup: %s$n", getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes.";
    }
}
