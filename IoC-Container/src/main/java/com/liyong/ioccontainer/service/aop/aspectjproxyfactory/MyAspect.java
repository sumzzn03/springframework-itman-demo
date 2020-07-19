package com.liyong.ioccontainer.service.aop.aspectjproxyfactory;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @ClassName MyAspect
 * @Description
 * @Author liyong
 * @Date 2019-11-08 10:26
 * @Version v1.0.0
 **/
@Aspect
public class MyAspect {

    @Pointcut("execution(* hello(..))")
    private void beforeAdd() {
    }

    @Before("beforeAdd()")
    public void before1() {
        System.out.println("-----------before-----------");
    }

}
