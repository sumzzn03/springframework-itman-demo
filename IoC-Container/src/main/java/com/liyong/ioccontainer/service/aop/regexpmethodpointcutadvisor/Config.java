package com.liyong.ioccontainer.service.aop.regexpmethodpointcutadvisor;
/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className Config
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-04-21 18:04    
 *
 *
**/

import com.liyong.ioccontainer.service.aop.LogMethodAdvice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public  class Config{

    @Bean
    public LogMethodAdvice logMethodAdvice(){
        return new LogMethodAdvice();
    }

    @Bean
    public CustomRegexpMethodPointcutAdvisor customRegexpMethodPointcutAdvisor(LogMethodAdvice logMethodAdvice){
        return new CustomRegexpMethodPointcutAdvisor(logMethodAdvice,new String[]{".*set.*",".*get.*"});
    }

}
