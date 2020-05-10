package com.liyong.ioccontainer.service;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className InnerService
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-05-10 22:16    
 *
 *
**/
public class InnerService {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "InnerService{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
