package org.liyong.dataaccess.service.transaction;

import org.liyong.dataaccess.entity.transaction.Foo;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className DefaultFooService
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-07-22 23:40    
 *
 *
**/
public class DefaultFooService implements FooService {

    @Override
    public Foo getFoo(String fooName) {
       return new Foo(fooName,null);
    }

    @Override
    public Foo getFoo(String fooName, String barName) {
        return new Foo(fooName,barName);
    }

    @Override
    public void insertFoo(Foo foo) {
        System.out.println("insertFoo");
    }

    @Override
    public void updateFoo(Foo foo) {
        System.out.println("updateFoo");
    }
}
