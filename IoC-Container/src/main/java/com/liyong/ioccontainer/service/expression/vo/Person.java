package com.liyong.ioccontainer.service.expression.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Person
 * @Description
 * @Author liyong
 * @Date 2019-11-11 16:43
 * @Version v1.0.0
 **/
public class Person implements Serializable {

    private String name;
    private Integer age;
    private String flag;
    private List<String> list;
    private Map<String,String> map;
    private boolean isMon;

    public Person(){}
    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public boolean isMon() {
        return isMon;
    }

    public void setMon(boolean mon) {
        isMon = mon;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", flag='" + flag + '\'' +
                ", list=" + list +
                ", map=" + map +
                '}';
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

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
