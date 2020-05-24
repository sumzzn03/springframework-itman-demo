package com.liyong.ioccontainer.service;
/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className StringStore
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-05-24 09:45    
 *
 *
**/
public class StringStore implements Store<String>{
    @Override
    public void print() {
        System.out.println("StringStore is printed");
    }
}
