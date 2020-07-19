package com.liyong.ioccontainer.service.aop.autoproxycreator;

import java.lang.annotation.*;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className CustomAnotation
 * @description
 * @date 2020-03-20 19:35
 * @JunitTest: {@link  }
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CustomAnotation {
    String value() default "";
}
