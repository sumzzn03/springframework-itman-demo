package com.liyong.ioccontainer.service.definationwithincomponet;
/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className TestBean
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-05-25 21:30    
 *
 *
**/
public class TestBean {

    private String country;
    private Integer count;

    private TestBean spouse;

    public TestBean(String country) {
        this.country = country;
    }

    public TestBean(String country, Integer count) {
        this.country = country;
        this.count=count;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public TestBean getSpouse() {
        return spouse;
    }

    public void setSpouse(TestBean spouse) {
        this.spouse = spouse;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "country='" + country + '\'' +
                ", count=" + count +
                ", spouse=" + spouse +
                '}';
    }
}
