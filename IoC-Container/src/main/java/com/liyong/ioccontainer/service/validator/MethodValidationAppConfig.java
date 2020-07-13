package com.liyong.ioccontainer.service.validator;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className MethodValidationAppConfig
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-07-13 22:58    
 *
 *
**/
@Configurable
public class MethodValidationAppConfig {
    /**
     *
     * 对方法参数或返回值进行校验
     *
     * @author liyong
     * @date 10:52 PM 2020/7/13
     * @param
     * @exception
     * @return org.springframework.validation.beanvalidation.MethodValidationPostProcessor
     **/
    @Bean
    public MethodValidationPostProcessor validationPostProcessor() {
        return new MethodValidationPostProcessor();
    }
}
