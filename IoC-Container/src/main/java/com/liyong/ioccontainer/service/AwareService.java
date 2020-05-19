package com.liyong.ioccontainer.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className AwareService
 * @description
 * @JunitTest: {@link  }
 * @date 2020-05-19 22:56
 **/
public class AwareService implements ApplicationContextAware, BeanNameAware {

    private ApplicationContext applicationContext;

    private String name;

    /***
     *
     * 由容器注入bean名称
     *
     * @author liyong 
     * @date 10:59 PM 2020/5/19
     * @param name 
     * @exception 
     * @return void 
     **/
    @Override
    public void setBeanName(String name) {
        this.name = name;
    }

    /***
     *
     * 注入ApplicationContext上下文
     *
     * @author liyong
     * @date 10:59 PM 2020/5/19
     * @param applicationContext
     * @exception
     * @return void
     **/
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
