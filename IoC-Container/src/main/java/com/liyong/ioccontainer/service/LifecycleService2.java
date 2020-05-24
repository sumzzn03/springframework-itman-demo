package com.liyong.ioccontainer.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className LifecycleService
 * @description
 * @JunitTest: {@link  }
 * @date 2020-05-19 18:10
 **/
public class LifecycleService2 {


    @PostConstruct
    public void start() {
        System.out.println("The LifecycleService2 start method is exec");
    }

    @PreDestroy
    public void stop() {
        System.out.println("The LifecycleService stop method is exec");
    }


}
