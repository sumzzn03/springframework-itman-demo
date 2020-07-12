package com.liyong.ioccontainer.service.propertyeditor;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className Person
 * @description
 * @JunitTest: {@link  }
 * @date 2020-07-12 21:45
 **/
public class Person {
    private String name;
    private String sex;
    private int age;

    public Person(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person[" + name + ", " + sex + ", " + age + "]";
    }
}