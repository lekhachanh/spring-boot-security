package com.codegym.springboot.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
public class LoggingAspect {

    private final ObjectMapper objectMapper;

    @Around("PointCuts.inController() && target(instance)")
    public Object controllerOperation(ProceedingJoinPoint joinPoint, Object instance) throws Throwable{

        Class<?> clazz = instance.getClass();
        String className = clazz.getSimpleName();
        String packageName = clazz.getPackage().getName();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getName();

        long start = System.currentTimeMillis();
        try {
            log.info("Entering {}.{}.{}.({})", packageName, className, methodName, joinPoint.getArgs());
            return joinPoint.proceed();
        }finally {
            long elapsedTime = System.currentTimeMillis() - start;
            log.info("Exiting {}.{}.{}(); exec time {}ms: " , packageName, className, methodName, elapsedTime);
        }
    }
}
