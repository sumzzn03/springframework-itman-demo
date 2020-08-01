package org.liyong.test.annotation.test.spring.annotation.test.spring;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className CustomContextIntializer
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-08-01 22:13    
 *
 *
**/
public class CustomContextIntializer implements ApplicationContextInitializer<GenericApplicationContext> {

    @Override
    public void initialize(GenericApplicationContext applicationContext) {

        applicationContext.getBeanFactory().registerSingleton("persionService",new PersionServiceImpl());

    }
}
