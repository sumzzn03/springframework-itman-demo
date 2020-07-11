package com.liyong.ioccontainer.service.validator;
/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className Person
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-07-11 13:04    
 *
 *
**/
public class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
