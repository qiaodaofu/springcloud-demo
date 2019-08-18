package com.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class TestAOP {
    @Pointcut("execution(* com.spring.aop.log..*.*(..))")
    public void test(){}

    @Before("test()")
    public void before(JoinPoint joinPoint){
        System.out.println("before"+joinPoint.getKind());
    }
    @After("test()")
    public void after(){
        System.out.println("after");
    }
    @AfterReturning(value = "execution(public String com.spring.aop.log.LogTest.*(..))",returning ="result")
    public void result(String result){
        System.out.println("afterReturning运行结果是：{"+result+"}");
    }
    @AfterThrowing(value = "test()",throwing = "e")
    public void afterThrowing(Exception e){
        System.out.println(e.getMessage()+"+++++++++++++++++");
    }

    @Around("test()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("around之前");
        Object proceed = point.proceed();
        System.out.println("around之之后");
        return  proceed;
    }
}
