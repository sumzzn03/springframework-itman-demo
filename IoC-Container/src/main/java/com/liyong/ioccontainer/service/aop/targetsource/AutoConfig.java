package com.liyong.ioccontainer.service.aop.targetsource;

import org.springframework.aop.target.CommonsPool2TargetSource;
import org.springframework.aop.target.PrototypeTargetSource;
import org.springframework.aop.target.ThreadLocalTargetSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className AutoConfig
 * @description
 * @JunitTest: {@link  }
 * @date 2020-04-27 20:57
 **/
@Configuration
public class AutoConfig {


    @Scope(scopeName = "prototype")
    @Bean
    public MyService myService() {
        return new MyService();
    }

    @Scope(scopeName = "prototype")
    @Bean
    public MyService myService2() {
        return new MyService();
    }

    @Scope(scopeName = "prototype")
    @Bean
    public MyService myService3() {
        return new MyService();
    }

    @Bean
    public CommonsPool2TargetSource commonsPool2TargetSource(){

        CommonsPool2TargetSource commonsPool2TargetSource = new CommonsPool2TargetSource();

        commonsPool2TargetSource.setTargetBeanName("myService3");

        commonsPool2TargetSource.setMaxSize(3);

        return commonsPool2TargetSource;
    }

    @Bean
    public PrototypeTargetSource prototypeTargetSource(){

        PrototypeTargetSource prototypeTargetSource = new PrototypeTargetSource();

        prototypeTargetSource.setTargetBeanName("myService2");

        return prototypeTargetSource;
    }

    /***
     *
     * 替代ThreadLocal方案
     *
     * @author liyong
     * @date 9:18 PM 2020/4/27
     * @param
     * @exception
     * @return org.springframework.aop.target.ThreadLocalTargetSource
     **/
    @Bean
    public ThreadLocalTargetSource threadLocalTargetSource() {

        ThreadLocalTargetSource threadLocalTargetSource = new ThreadLocalTargetSource();

        threadLocalTargetSource.setTargetBeanName("myService");

        return threadLocalTargetSource;
    }


   public class MyService {

        private String name;

        public void say(String name) {
            System.out.println("before : the thread "+this.name+" is " + Thread.currentThread().getName());
            this.name = name;
            System.out.println("after : the thread "+this.name+" is " + Thread.currentThread().getName());
        }
    }

}
