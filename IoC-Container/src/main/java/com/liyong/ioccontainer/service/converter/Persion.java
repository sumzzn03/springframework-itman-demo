package com.liyong.ioccontainer.service.converter;

import javax.annotation.Resource;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className Apple
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-07-12 22:24    
 *
 *
**/
public class Persion {

    @Resource
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
