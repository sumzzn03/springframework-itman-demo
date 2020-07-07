package com.liyong.ioccontainer.service.basejavaconfig;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className MyServiceImpl
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-07-07 21:27    
 *
 *
**/
public class MyServiceImpl implements MyService, InitializingBean , DisposableBean {

    private AccountRepository repository;

    public MyServiceImpl(){}

    public MyServiceImpl(AccountRepository repository){
        this.repository = repository;
    }

    @Override
    @PostConstruct
    public void init(){
        System.out.println("init");
    }

    @Override
    @PreDestroy
    public void destory(){
        System.out.println("destory");
    }


    @Override
    public void print() {
        System.out.println("MyServiceImpl");
    }

    @Override
    public void destroy() throws Exception {
        destory();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        init();
    }
}
