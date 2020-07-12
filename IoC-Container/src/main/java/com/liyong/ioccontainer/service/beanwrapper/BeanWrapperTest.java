package com.liyong.ioccontainer.service.beanwrapper;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyValue;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className BeanWrapperTest
 * @description 使用BeanWrapper对bean进行包装
 * @JunitTest: {@link  }
 * @date 2020-07-12 20:41
 **/
public class BeanWrapperTest {

    public static void main(String[] args) {

        BeanWrapper company = new BeanWrapperImpl(new Company());
        //设置name属性值
        company.setPropertyValue("name", "Some Company Inc.");
        //设置name属性值，覆盖上面属性值
        PropertyValue value = new PropertyValue("name", "Some Company Inc2.");
        company.setPropertyValue(value);


        BeanWrapper jim = new BeanWrapperImpl(new Employee());
        jim.setPropertyValue("name", "Jim Stravinsky");
        company.setPropertyValue("managingDirector", jim.getWrappedInstance());

        //获取Employee.salary
        Float salary = (Float) company.getPropertyValue("managingDirector.salary");
        String employeeName = (String) company.getPropertyValue("managingDirector.name");
        //获取Company.name
        String companyName = (String) company.getPropertyValue("name");

        System.out.println("employeeName:" + employeeName);
        System.out.println("companyName:" + companyName);
        System.out.println("salary:" + salary);

    }

}
