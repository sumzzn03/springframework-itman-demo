package com.liyong.ioccontainer.service;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className ReplacementComputeValue
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-05-13 23:43    
 *
 *
**/
public class ReplacementComputeValue  implements MethodReplacer {

    @Override
    public Object reimplement(Object o, Method m, Object[] args) throws Throwable {
        // get the input value, work with it, and return a computed result
        String input = (String) args[0];

        return input+" hello Spring";
    }
}
