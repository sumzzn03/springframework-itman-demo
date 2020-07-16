package com.liyong.ioccontainer.service.aop;
/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className AopServiceImpl
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-07-16 21:47    
 *
 *
**/
public class AopServiceImpl implements AopService{

    @Override
    public void sayHello() {

        System.out.println("the AopServiceImpl is say hello ");

    }

    @Override
    public void sayException() {

        throw new RuntimeException("发生异常");

    }
}
