package org.liyong.test.annotation.test.spring.annotation.test.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className AppConfig
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-08-01 23:14    
 *
 *
**/
@Configuration
public class AppConfig{

    @Bean
    public OtherService otherService(){
        return new OtherServiceImpl();
    }


}
