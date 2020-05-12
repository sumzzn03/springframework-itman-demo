package com.liyong.ioccontainer.service;


import org.springframework.beans.factory.InitializingBean;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className BookService
 * @description
 * @JunitTest: {@link  }
 * @date 2020-05-06 21:38
 **/
public class DependOnService implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("开始初始化DependOnService");
    }
}
