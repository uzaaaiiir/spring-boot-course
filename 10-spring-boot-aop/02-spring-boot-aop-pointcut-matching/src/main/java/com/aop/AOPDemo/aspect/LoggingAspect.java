package com.aop.AOPDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    //@Before("execution(public void com.aop.AOPDemo.dao.AccountDAO.addAccount())") // match fully qualified classname
    //@Before("execution(public void addAccount())") // match on method names
    //@Before("execution(public void add*())") // match on wild cards
    // @Before("execution(* add*(com.aop.AOPDemo.Account, ..))") // match on parameters
    // @Before("execution(* add*(..))")

    @Before("execution(* com.aop.AOPDemo.dao.*.*(..))")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>>> Executing @Before advice on addAccount");
    }

}
