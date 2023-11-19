package com.aop.AOPDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class CloudLogAspect {
    @Before("AopExpressions.forDaoPackageNoGetterSetter()")
    public void logToCloudAsync() {
        System.out.println("\n=====>>> Logging to Cloud Asynchronously");
    }
}
