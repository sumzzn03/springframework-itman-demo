package com.liyong.ioccontainer.service.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className MyConstraintValidator
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-07-13 23:14    
 *
 *
**/
public class MyConstraintValidator implements ConstraintValidator<MyConstraint,String> {

    boolean required;

    @Override
    public void initialize(MyConstraint constraintAnnotation) {

         required = constraintAnnotation.required();

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if(value == null){
            return false;
        }


        return true;
    }


}
