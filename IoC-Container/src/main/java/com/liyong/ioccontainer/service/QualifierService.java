package com.liyong.ioccontainer.service;


import org.springframework.beans.factory.InitializingBean;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className QualifierService
 * @description 使用自定义限定符
 * @JunitTest: {@link  }
 * @date 2020-05-06 21:38
 **/
public class QualifierService implements IOtherService, InitializingBean {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void save(String world) {
        System.out.println("The OtherService method result is  " + world);
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("OtherService开始初始化");
    }

}
