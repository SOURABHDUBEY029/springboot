package com.springboot.eschool.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Slf4j
@Aspect
@Component
public class LoggerAspect {

    @Around("execution(* com.springboot.eschool..*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info(joinPoint.getSignature().toString() + " method execution start");
        Instant start = Instant.now();
        Object returnObj = joinPoint.proceed();
        Instant finish = Instant.now();
        Long timeElapsed = Duration.between(start, finish).toMillis();
        log.info("Time took to execute " + joinPoint.getSignature().toString() + " method is " + timeElapsed);
        log.info(joinPoint.getSignature().toString() + " method execution is end");
        return returnObj;
    }

    @AfterThrowing(value = "execution(* com.springboot.eschool.*.*(..))",throwing = "ex")
    public void logException(JoinPoint joinPoint, Exception ex){
        log.error(joinPoint.getSignature() + " an exception occure due to " + ex.getMessage());
    }
}
