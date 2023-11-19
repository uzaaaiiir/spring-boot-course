package com.aop.AOPDemo.aspect;

import com.aop.AOPDemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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
}
