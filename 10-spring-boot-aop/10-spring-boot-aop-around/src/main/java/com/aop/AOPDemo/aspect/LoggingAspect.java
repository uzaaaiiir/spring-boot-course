package com.aop.AOPDemo.aspect;

import com.aop.AOPDemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.List;

@Aspect
@Component
@Order(2)
public class LoggingAspect {
    @Before("AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("=====>>> Executing @Before advice on addAccount");

        // Display Method Signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        // Display Method Arguments
        Object[] args = joinPoint.getArgs();

        for (Object arg : args) {
            System.out.println(arg);
            if (arg instanceof Account) {
                Account account = (Account) arg;
                System.out.println("Account name: " + account.getName());
                System.out.println("Account level: " + account.getLevel());
            }
        }
    }

    @AfterReturning(
            pointcut = "execution(* com.aop.AOPDemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        System.out.println("\n\n=====>Executing @AfterReturning on method: "
                + joinPoint.getSignature().toShortString());

        System.out.println("=====>Result is: " + result);
        System.out.println("-------------------------");


        // Post process data and modify it
        System.out.println("Modifying Data:");
        convertToUpperCase(result);
        System.out.println("=====>Result is: " + result);

    }

    @AfterThrowing(
            pointcut = "execution(* com.aop.AOPDemo.dao.AccountDAO.findAccounts(..))",
            throwing = "exception"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exception) {
        System.out.println("\n\n=====>Executing @AfterThrowing on method: "
                + joinPoint.getSignature().toShortString());

        System.out.println("=====>The Exception is: " + exception);
    }

    private void convertToUpperCase(List<Account> result) {
        for (Account account : result) {
            String upperName = account.getName().toUpperCase();
            account.setName(upperName);
        }
    }

    @After("execution(* com.aop.AOPDemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountAdvice(JoinPoint joinPoint) {
        System.out.println("\n\n=====>Executing @After on method: "
                + joinPoint.getSignature().toShortString());
    }

    @Around("execution(* com.aop.AOPDemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("\n\n=====>Executing @Around on method: "
                + proceedingJoinPoint.getSignature().toShortString());

        long start = System.currentTimeMillis();

        Object result = null;

        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            // result = "Major accident! Response is on the way.";

            // rethrow exception
            throw ex;
        }

        long end = System.currentTimeMillis();
        long duration = end - start;

        System.out.println("\n=====>Duration: " + duration / 1000.0 + " seconds");
        return result;
    }
}
