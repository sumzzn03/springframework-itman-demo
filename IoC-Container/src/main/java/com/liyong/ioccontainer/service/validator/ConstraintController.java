package com.liyong.ioccontainer.service.validator;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className ConstraintController
 * @description Spring MVC自定义参数约束
 * @JunitTest: {@link  }
 * @date 2020-07-13 23:52
 * @see ConstraintTest
 **/
@Controller
@RequestMapping(value = "/constraint")
public class ConstraintController {

    @RequestMapping(value = "/job", method = RequestMethod.POST)
    public void agentAction(@RequestBody @Valid Job job, BindingResult result, HttpServletRequest request) {
        System.out.println("source=>" + job);

        if (result.hasErrors()) {

            List<FieldError> list = result.getFieldErrors();

            for (FieldError error : list) {

                System.out.println(error.getObjectName() + "." + error.getField() + " failed; cause by : " + error.getDefaultMessage());

            }

        }

    }

}
