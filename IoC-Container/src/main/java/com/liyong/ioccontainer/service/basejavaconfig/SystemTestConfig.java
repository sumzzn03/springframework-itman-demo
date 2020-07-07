package com.liyong.ioccontainer.service.basejavaconfig;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className SystemTestConfig
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-07-07 22:17    
 *
 *
**/
@Configuration
@Import({ServiceConfig.class, RepositoryConfig.class})
public class SystemTestConfig {

    @Bean
    public DataSource dataSource() {
       return new DruidDataSource();
    }
}