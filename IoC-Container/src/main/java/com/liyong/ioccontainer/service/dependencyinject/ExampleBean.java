package com.liyong.ioccontainer.service.dependencyinject;

import java.beans.ConstructorProperties;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className ExampleBean
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-06-28 22:34    
 *
 *
**/
public class ExampleBean {
    // Number of years to calculate the Ultimate Answer
    private int years;

    // The Answer to Life, the Universe, and Everything
    private String ultimateAnswer;

    @ConstructorProperties({"years", "ultimateAnswer"})
    public ExampleBean(int years, String ultimateAnswer) {
        this.years = years;
        this.ultimateAnswer = ultimateAnswer;
    }

    @Override
    public String toString() {
        return "ExampleBean{" +
                "years=" + years +
                ", ultimateAnswer='" + ultimateAnswer + '\'' +
                '}';
    }
}
