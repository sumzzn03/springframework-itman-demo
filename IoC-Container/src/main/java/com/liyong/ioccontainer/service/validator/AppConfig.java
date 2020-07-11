package com.liyong.ioccontainer.service.validator;

import org.hibernate.validator.HibernateValidator;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className AppConfig
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-07-11 16:45    
 *
 *
**/
@Configurable
public class AppConfig {


    /**
     *
     * 定义校验器
     *
     * @author liyong
     * @date 5:04 PM 2020/7/11
     * @param messageSource
     * @exception
     * @return LocalValidatorFactoryBean
     **/
    @Bean
    public LocalValidatorFactoryBean validator(ReloadableResourceBundleMessageSource messageSource){

        LocalValidatorFactoryBean validatorFactoryBean = new LocalValidatorFactoryBean();

        validatorFactoryBean.setProviderClass(HibernateValidator.class);

        validatorFactoryBean.setValidationMessageSource(messageSource);

        return validatorFactoryBean;

    }


    /**
     *
     * 定义消息源
     *
     * @author liyong
     * @date 5:04 PM 2020/7/11
     * @param
     * @exception
     * @return org.springframework.context.support.ReloadableResourceBundleMessageSource
     **/
    @Bean
    public ReloadableResourceBundleMessageSource messageSource(){

        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("classpath:ValidationMessages.properties");

        return messageSource;
    }
}
