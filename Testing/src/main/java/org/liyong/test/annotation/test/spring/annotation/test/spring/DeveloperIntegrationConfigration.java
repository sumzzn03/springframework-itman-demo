package org.liyong.test.annotation.test.spring.annotation.test.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className DeveloperIntegrationConfigration
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-08-02 09:41    
 *
 *
**/
//@Profile("dev1")
@Profile("dev")
@Configuration
public class DeveloperIntegrationConfigration {

    @Bean
    public OtherService otherService(){
        return new OtherServiceImpl();
    }

}
