package com.liyong.ioccontainer.service.aop;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @ClassName LogMethodAdvice
 * @Description
 * @Author liyong
 * @Date 2019-11-08 10:01
 * @Version v1.0.0
 **/
// 先定义一个前置通知
//@Component("logMethodBeforeAdvice")
public class LogMethodAdvice implements MethodBeforeAdvice, AfterReturningAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("this is LogMethodAdvice before");
    }


    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("this is LogMethodAdvice afterReturning");
    }
}


