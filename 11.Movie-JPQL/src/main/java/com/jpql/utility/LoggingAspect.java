package com.jpql.utility;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect {
    private final Logger logger=LogManager.getLogger(this.getClass());

    @AfterThrowing(pointcut = "execution(* com.jpql.repository.*Impl.*(..))", throwing = "exception")
    public void logRepositoryException(Exception exception) throws Exception {
        logger.error(exception.getMessage(),exception);

    }

    @AfterThrowing(pointcut = "execution(* com.jpql.service.*Impl.*(..))", throwing = "exception")
    public void logServiceException(Exception exception) throws Exception {
        logger.error(exception.getMessage(),exception);
    }


}
