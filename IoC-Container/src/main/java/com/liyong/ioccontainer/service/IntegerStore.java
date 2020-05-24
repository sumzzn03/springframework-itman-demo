package com.liyong.ioccontainer.service;
/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className IntegerStore
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-05-24 09:46    
 *
 *
**/
public class IntegerStore implements Store<Integer>{
    @Override
    public void print() {
        System.out.println("IntegerStore is printed");
    }
}
