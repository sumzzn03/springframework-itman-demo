package org.liyong.dataaccess.service;

import org.liyong.dataaccess.entity.Foo;

public interface ServiceOperation {
    void insertFoo(Foo foo);

    void insertFoo2(Foo foo);

    default void propagation1(Foo foo) {
    }

    default void propagation2(Foo foo) {
    }

    default void propagation3(Foo foo) {
    }
}
