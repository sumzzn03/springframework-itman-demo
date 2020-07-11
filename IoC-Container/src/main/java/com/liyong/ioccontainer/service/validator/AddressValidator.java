package com.liyong.ioccontainer.service.validator;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className AddressValidator
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-07-11 13:07    
 *
 *
**/
public class AddressValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Address.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        ValidationUtils.rejectIfEmpty(errors, "desc", "desc.empty");
        Address address = (Address) target;
        if (StringUtils.isEmpty(address.getDesc())) {
            errors.rejectValue("desc", "isentity");
        }

    }
}
