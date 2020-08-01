package org.liyong.test.annotation.test.spring;

import org.liyong.test.annotation.test.spring.annotation.test.spring.PersionService;
import org.liyong.test.annotation.test.spring.annotation.test.spring.PersionServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className TestConfig
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-08-01 22:05    
 *
 *
**/
@Configuration
public class TestConfig {

    @Bean
    public PersionService persionService(){
        return new PersionServiceImpl();
    }
}
