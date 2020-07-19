package com.liyong.ioccontainer.service.aop.proxyfactorybean.service;

import org.springframework.stereotype.Service;

/**
 * @ClassName HelloServiceImpl
 * @Description
 * @Author liyong
 * @Date 2019-11-06 15:40
 * @Version v1.0.0
 **/
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public Object hello(Integer id, String name) {
        return "ouwen";
    }
}
