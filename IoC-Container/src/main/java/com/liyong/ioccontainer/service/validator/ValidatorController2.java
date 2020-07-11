package com.liyong.ioccontainer.service.validator;

import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
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
public class ValidatorController2 {

    @InitBinder
    public void initBinder(DataBinder binder) {
        // 为DataBinder对象设置Validator校验接口
        binder.setValidator(new PersonValidator());
    }

    @RequestMapping("/people")
    public String people(@Valid Person person, BindingResult result) {
        List<ObjectError> allErrors;
        if (result.hasErrors()) {
            allErrors = result.getAllErrors();
            // 输出所有错误信息
            for (ObjectError objectError : allErrors) {
                System.out.println("code = " + objectError.getCode() +
                        "DefaultMessage = " + objectError.getDefaultMessage());
            }

            // 最后返回视图
            return "fail";
        }
        return "success";
    }

}
