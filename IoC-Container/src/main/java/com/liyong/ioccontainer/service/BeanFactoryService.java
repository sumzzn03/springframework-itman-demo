package com.liyong.ioccontainer.service;


/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className BookService
 * @description
 * @JunitTest: {@link  }
 * @date 2020-05-06 21:38
 **/
public class BeanFactoryService {

    private String name;

    private Long age;

    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 设置为初始化执行方法
     */
    public void init() {

        this.name = "init";
        System.out.println("init method");
    }

}
