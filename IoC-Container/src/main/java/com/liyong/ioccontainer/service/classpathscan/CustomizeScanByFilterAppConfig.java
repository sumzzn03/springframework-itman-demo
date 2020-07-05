package com.liyong.ioccontainer.service.classpathscan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Repository;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className AppConfig
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-07-05 21:51    
 *
 *
**/

@Configuration
@ComponentScan(basePackages = "com.liyong.ioccontainer.service.classpathscan",
        includeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = ".*.*Repository"),
        excludeFilters = @ComponentScan.Filter(Repository.class))
public class CustomizeScanByFilterAppConfig {



}
