package com.liyong.ioccontainer.service;

import com.liyong.ioccontainer.entity.Book;
import org.springframework.beans.factory.FactoryBean;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className CustomFactorBean
 *@description 自定义FactoryBean
 *@JunitTest: {@link  } 
 *@date 2020-07-02 22:52    
 *
 *
**/
public class CustomFactorBean implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        return new Book();
    }

    @Override
    public Class<?> getObjectType() {
        return Book.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
