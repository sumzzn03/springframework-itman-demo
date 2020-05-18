package com.liyong.ioccontainer.entity;

import org.springframework.beans.factory.DisposableBean;

import javax.annotation.PreDestroy;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className User
 * @description
 * @JunitTest: {@link  }
 * @date 2020-05-06 21:34
 **/
public class User implements DisposableBean {
    private String name;
    private Integer age;
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }

    public void destroy2(){
        System.out.println("The method destroy2 is exec");
    }

    @PreDestroy
    public void destroy1(){
        System.out.println("The method init is exec");
    }


    @Override
    public void destroy() throws Exception {
        System.out.println("The method destroy is exec");
    }
}
