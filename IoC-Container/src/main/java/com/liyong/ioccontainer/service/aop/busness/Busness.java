package com.liyong.ioccontainer.service.aop.busness;

import com.liyong.ioccontainer.service.aop.Person;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className Busness
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-07-16 21:50    
 *
 *
**/
public interface Busness {

    public void sayHello(String say);

    public Object print(Person person);

}
