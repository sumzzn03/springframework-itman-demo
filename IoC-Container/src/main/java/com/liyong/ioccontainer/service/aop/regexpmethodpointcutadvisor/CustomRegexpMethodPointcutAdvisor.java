package com.liyong.ioccontainer.service.aop.regexpmethodpointcutadvisor;

import org.aopalliance.aop.Advice;
import org.springframework.aop.support.RegexpMethodPointcutAdvisor;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className CustomRegexpMethodPointcutAdvisor
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-04-21 17:53    
 *
 *
**/
public class CustomRegexpMethodPointcutAdvisor extends RegexpMethodPointcutAdvisor {

    public CustomRegexpMethodPointcutAdvisor(Advice advice, String[] patterns) {
        super(patterns,advice);
    }
}
