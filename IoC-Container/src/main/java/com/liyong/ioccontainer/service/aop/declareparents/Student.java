package com.liyong.ioccontainer.service.aop.declareparents;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className Student
 *@description sayIdentification方法不能在接口中定义
 *@JunitTest: {@link  } 
 *@date 2020-07-16 23:58    
 *
 *
**/
public class Student implements Person {

    public void sayIdentification(){
        System.out.println("我是学生。");
    }
}
