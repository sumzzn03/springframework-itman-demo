package org.liyong.dataaccess.service;

import org.liyong.dataaccess.entity.Foo;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className Service
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-08-27 21:52    
 *
 *
**/
public interface Service {

    Object someServiceMethod(Foo foo);

    void updateOperation1(Foo foo);

    Object query(Foo foo);

}
