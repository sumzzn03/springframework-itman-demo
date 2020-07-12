package com.liyong.ioccontainer.service.beanwrapper;
/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className Employee
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-07-12 20:39    
 *
 *
**/
public class Employee {

    private String name;

    private float salary;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}
