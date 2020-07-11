package com.liyong.ioccontainer.service.validator;

import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className ValidatorController
 * @description 这里读者自行集成Spring Boot或Spring MVC进行验证
 * @JunitTest: {@link  }
 * @date 2020-07-11 16:21
 **/
@RestController
public class ValidatorController {

    @RequestMapping("/people")
    public String people(Person person) {

        //手动校验
        PersonValidator validator = new PersonValidator();
        if (validator.supports(Person.class)) {
            BindException errors = new BindException(person, "person");
            validator.validate(person, errors);
            List<ObjectError> allErrors = errors.getAllErrors();
            System.out.println("size=" + allErrors.size());
            for (int i = 0; i < allErrors.size(); i++) {
                System.out.println(allErrors.get(i).getCode());
            }

        }
        return "success";
    }

}
