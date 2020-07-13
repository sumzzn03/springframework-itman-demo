package com.liyong.ioccontainer.service.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className MyConstraint
 * @description
 * @JunitTest: {@link  }
 * @date 2020-07-13 23:14
 **/
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {MyConstraintValidator.class})
public @interface MyConstraint {

   String message() default "参数不能同时为空!";


   Class<?>[] groups() default {};

   Class<? extends Payload>[] payload() default {};

   boolean required() default false;
}
