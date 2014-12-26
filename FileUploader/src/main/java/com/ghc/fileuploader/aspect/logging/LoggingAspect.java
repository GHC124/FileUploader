package com.ghc.fileuploader.aspect.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LoggingAspect implements Ordered {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
    
    private long before = 0;
    private long after = 0;

    @Before("@annotation(com.ghc.fileuploader.aspect.logging.Loggable)")
    public void logBefore(JoinPoint joinPoint) {
        printRequest(joinPoint);
        before = System.currentTimeMillis();
    }

    @AfterReturning(pointcut = "@annotation(com.ghc.fileuploader.aspect.logging.Loggable)", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        printResponse(joinPoint, result);
    }

    @AfterThrowing(pointcut = "@annotation(com.ghc.fileuploader.aspect.logging.Loggable)", throwing = "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        String msgHeader = joinPoint.getSignature().getName() + ":Error: {}";
        LOGGER.error(msgHeader, error.getMessage() + ":" + error.getCause());
    }

    @Override
    public int getOrder() {
        return 2;
    }
    
    public void printRequest(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        MethodSignature methodSign = (MethodSignature) joinPoint.getSignature();
        
        String msgHeader = methodSign + ":{}";
        String str = "Request:[BEGIN]-------------------------------\n {";
         
        /** Begin: Authentication & Authorization aspect */
        for (Object param : args) {
            str += param + ",\n";
        }
        str = str.substring(0, str.length()-2);
        str += "\n}";
        str += "Request:[END]-------------------------------\n";
        
        LOGGER.info(msgHeader, str);
    }
    
    public void printResponse(JoinPoint joinPoint, Object result) {
        String msgHeader = joinPoint.getSignature().getName() + ":Return: {}";
        after = System.currentTimeMillis();
        long duration = after - before;

        String str = "Response:[BEGIN]-------------------------------\n";
        str += result.toString();
        str += "Response:[END][DURATION:" + duration + "]-------------------------------\n";
        
        LOGGER.info(msgHeader, str);
    }
    
}
