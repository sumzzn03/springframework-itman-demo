package com.liyong.ioccontainer.service.aop;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE})
@Documented
public @interface MyWithin {

    public boolean value() default true;
}