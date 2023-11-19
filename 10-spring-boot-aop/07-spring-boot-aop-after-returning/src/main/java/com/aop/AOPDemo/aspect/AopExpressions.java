package com.aop.AOPDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {
    @Pointcut("execution(* com.aop.AOPDemo.dao.*.*(..))")
    protected void forDaoPackage() {}

    @Pointcut("execution(* com.aop.AOPDemo.dao.*.get*(..))") // create pointcut for getters
    protected void getter() {}

    @Pointcut("execution(* com.aop.AOPDemo.dao.*.set*(..))") // create pointcut for setters
    protected void setter() {}

    @Pointcut("forDaoPackage() && !(getter() || setter())") // combine pointcuts
    protected void forDaoPackageNoGetterSetter() {}
}
