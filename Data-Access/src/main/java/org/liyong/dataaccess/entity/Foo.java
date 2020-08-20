package org.liyong.dataaccess.entity;
/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className Foo
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-07-22 23:45    
 *
 *
**/
public class Foo {

    private String fooName;
    private String barName;
    private Integer age;


    public Foo(String fooName, String barName,Integer age) {
        this.fooName = fooName;
        this.barName = barName;
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFooName() {
        return fooName;
    }

    public void setFooName(String fooName) {
        this.fooName = fooName;
    }

    public String getBarName() {
        return barName;
    }

    public void setBarName(String barName) {
        this.barName = barName;
    }
}
