package com.liyong.ioccontainer.service.dependencyinject;

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
public class ExampleBean2 {

    private AnotherBean beanOne;

    private YetAnotherBean beanTwo;

    private int i;

    //需要在构造函数中声明需要依赖的类型定义
    public ExampleBean2(
            AnotherBean anotherBean, YetAnotherBean yetAnotherBean, int i) {
        this.beanOne = anotherBean;
        this.beanTwo = yetAnotherBean;
        this.i = i;
    }

    //静态工厂方法
    public static ExampleBean2 createInstance (
            AnotherBean anotherBean, YetAnotherBean yetAnotherBean, int i) {

        ExampleBean2 eb = new ExampleBean2 (anotherBean,yetAnotherBean,i);

        return eb;
    }

    @Override
    public String toString() {
        return "ExampleBean2{" +
                "beanOne=" + beanOne +
                ", beanTwo=" + beanTwo +
                ", i=" + i +
                '}';
    }
}
