package com.liyong.ioccontainer.service.basejavaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className RepositoryConfig
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-07-07 22:17    
 *
 *
**/
@Configuration
public class RepositoryConfig {

    @Bean
    public AccountRepository accountRepository(DataSource dataSource) {
        return new AccountRepositoryImpl(dataSource);
    }
}
