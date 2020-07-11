package com.liyong.ioccontainer.service.validator;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className ValidatorTest
 * @description
 * @JunitTest: {@link  }
 * @date 2020-07-11 16:14
 **/
public class ValidatorTest {

    public static void main(String[] args) {

        //这种校验如果target传递的Object类型是非常有用的
        Object target = new Person();
        DataBinder binder = new DataBinder(target);
        binder.setValidator(new PersonValidator());
        // bind to the target object
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.add("age","");
        propertyValues.add("name","ouwen");
        binder.bind(propertyValues);
        // validate the target object
        binder.validate();
        // get BindingResult that includes any validation errors
        BindingResult results = binder.getBindingResult();

        System.out.println(results.getAllErrors());

    }
}
