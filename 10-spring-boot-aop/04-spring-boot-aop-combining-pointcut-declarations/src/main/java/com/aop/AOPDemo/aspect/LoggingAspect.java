package com.aop.AOPDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Pointcut("execution(* com.aop.AOPDemo.dao.*.*(..))")
    private void forDaoPackage() {}

    @Pointcut("execution(* com.aop.AOPDemo.dao.*.get*(..))") // create pointcut for getters
    private void getter() {}

    @Pointcut("execution(* com.aop.AOPDemo.dao.*.set*(..))") // create pointcut for setters
    private void setter() {}

    @Pointcut("forDaoPackage() && !(getter() || setter())") // combine pointcuts
    private void forDaoPackageNoGetterSetter() {}

    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>>> Executing @Before advice on addAccount");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("=====>>> Performing API Analytics");
    }
}
