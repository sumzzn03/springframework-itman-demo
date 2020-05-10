package com.liyong.ioccontainer.service;
/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className OuterService
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-05-10 22:16    
 *
 *
**/
public class OuterService {

    private InnerService target;

    public OuterService(){}

    public OuterService(InnerService target) {
        this.target = target;
    }

    public InnerService getTarget() {
        return target;
    }

    public void setTarget(InnerService target) {
        this.target = target;
    }
}
