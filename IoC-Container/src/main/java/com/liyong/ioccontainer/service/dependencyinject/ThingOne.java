package com.liyong.ioccontainer.service.dependencyinject;
/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className ThingOne
 *@description 构造函数参数解析
 *@JunitTest: {@link  } 
 *@date 2020-06-28 22:23    
 *
 *
**/
public class ThingOne {

    private ThingTwo thingTwo;
    private ThingThree thingThree;


    public ThingOne(ThingTwo thingTwo, ThingThree thingThree) {

        this.thingTwo=thingTwo;
        this.thingThree=thingThree;

    }
}
