package com.liyong.ioccontainer.service.classpathscan.namegenerator;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className MyBeanNameGenerator
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-07-06 22:02    
 *
 *
**/
public class MyBeanNameGenerator implements BeanNameGenerator{

    @Override
    public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {

        String beanClassName = definition.getBeanClassName();

        registry.registerBeanDefinition(beanClassName,definition);

        return beanClassName;

    }
}
