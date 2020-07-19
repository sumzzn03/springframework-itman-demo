package com.liyong.ioccontainer.service.aop.proxyfactorybean;
/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className Person
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-07-19 23:16    
 *
 *
**/
public class Person {
    public int run() {
        System.out.println("我在run...");
        return 0;
    }

    public void run(int i) {
        System.out.println("我在run...<" + i + ">");
    }

    public void say() {
        System.out.println("我在say...");
    }

    public void sayHi(String name) {
        System.out.println("Hi," + name + ",你好");
    }

    public int say(String name, int i) {
        System.out.println(name + "----" + i);
        return 0;
    }
}
