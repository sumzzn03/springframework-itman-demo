package com.liyong.ioccontainer.service.aop.regexpmethodpointcutadvisor;

import org.springframework.stereotype.Service;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className TestService
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-04-21 18:02    
 *
 *
**/
@Service
public class TestServiceImpl implements TestService{
    @Override
    public String set(String name){
        return name;
    }
    @Override
    public String get(String name){
        return name;
    }
}
