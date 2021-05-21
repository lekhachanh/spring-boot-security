package com.codegym.springboot.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class PointCuts {

    @Pointcut("execution(public * *(..))")
    public void anyPublicOperation(){}

    @Pointcut("within(com.codegym.springboot.controller..*)")
    public void inController(){}
}
