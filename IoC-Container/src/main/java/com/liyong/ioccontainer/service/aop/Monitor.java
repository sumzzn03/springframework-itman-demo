package com.liyong.ioccontainer.service.aop;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
@Documented
public @interface Monitor {

    public boolean value() default true;
}