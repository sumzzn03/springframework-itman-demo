package com.liyong.ioccontainer.service.propertyeditor;
/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className DependsOnExoticType
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-07-12 21:50    
 *
 *
**/
public class DependsOnExoticType {

    private ExoticType type;

    public void setType(ExoticType type) {
        this.type = type;
    }

    public ExoticType getType() {
        return type;
    }
}