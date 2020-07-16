package com.liyong.ioccontainer.service.aop;
/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className Person
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-07-16 23:07    
 *
 *
**/
@Monitor
public class Person {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
