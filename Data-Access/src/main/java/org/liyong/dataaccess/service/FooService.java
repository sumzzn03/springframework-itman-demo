package org.liyong.dataaccess.service;


import org.liyong.dataaccess.entity.Foo;

public interface FooService {

    Foo getFoo(String fooName);

    Foo getFoo(String fooName, String barName);

    void insertFoo(Foo foo);

    void updateFoo(Foo foo);

}
