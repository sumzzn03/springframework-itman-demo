package com.liyong.ioccontainer.service.validator;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className Job
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-07-13 23:00    
 *
 *
**/
public class Job {

    @MyConstraint
    private String name;
    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
