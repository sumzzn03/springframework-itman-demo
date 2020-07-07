package com.liyong.ioccontainer.service.basejavaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className ServiceConfig
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-07-07 22:16    
 *
 *
**/
@Configuration
public class ServiceConfig {

    @Bean
    public MyService transferService(AccountRepository accountRepository) {
        return new MyServiceImpl(accountRepository);
    }
}
