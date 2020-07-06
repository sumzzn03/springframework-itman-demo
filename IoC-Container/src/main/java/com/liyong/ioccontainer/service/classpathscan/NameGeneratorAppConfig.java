package com.liyong.ioccontainer.service.classpathscan;

import com.liyong.ioccontainer.service.classpathscan.namegenerator.MyBeanNameGenerator;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

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
@ComponentScan(basePackages = "com.liyong.ioccontainer.service.classpathscan.namegenerator",
        nameGenerator = MyBeanNameGenerator.class)
public class NameGeneratorAppConfig {


}
