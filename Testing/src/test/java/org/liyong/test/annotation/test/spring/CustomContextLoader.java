package org.liyong.test.annotation.test.spring;

import org.liyong.test.annotation.test.spring.annotation.test.spring.OtherService;
import org.liyong.test.annotation.test.spring.annotation.test.spring.OtherServiceImpl;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.MergedContextConfiguration;
import org.springframework.test.context.support.GenericXmlContextLoader;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className CustomContextLoader
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-08-01 22:24    
 *
 *
**/
public class CustomContextLoader extends GenericXmlContextLoader {

    @Override
    protected void customizeContext(ConfigurableApplicationContext context, MergedContextConfiguration mergedConfig) {

        super.customizeContext(context, mergedConfig);

        context.getBeanFactory().registerSingleton("otherService",new OtherServiceImpl());

    }
}
