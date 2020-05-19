package com.liyong.ioccontainer.service;

import org.springframework.context.SmartLifecycle;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className LifecycleService
 * @description
 * @JunitTest: {@link  }
 * @date 2020-05-19 18:10
 **/
public class LifecycleService implements SmartLifecycle {

    private boolean isRunning = false;

    @Override
    public void start() {
        isRunning = true;
        System.out.println("The LifecycleService start method is exec");
    }

    @Override
    public void stop() {
        isRunning = false;
        System.out.println("The LifecycleService stop method is exec");
    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }

}
