package com.liyong.ioccontainer.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className MyBeanPostProcessor
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-05-20 23:47    
 *
 *
**/
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        System.out.println("postProcessBeforeInitialization:"+beanName);

        if("otherService".equals(beanName)){

            OtherService otherService =  (OtherService)bean;

            otherService.setName("hello");

        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization:"+beanName);
        return bean;
    }
}
