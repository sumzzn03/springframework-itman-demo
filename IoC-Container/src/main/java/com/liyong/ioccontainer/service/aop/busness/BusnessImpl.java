package com.liyong.ioccontainer.service.aop.busness;

import com.liyong.ioccontainer.service.aop.Monitor;
import com.liyong.ioccontainer.service.aop.MyWithin;
import com.liyong.ioccontainer.service.aop.Person;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className BusnessImpl
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-07-16 21:50    
 *
 *
**/
@Monitor
@MyWithin
public class BusnessImpl implements Busness{

    @Qualifier
    @Override
    public void sayHello(String say) {
        System.out.println("the BusnessImpl is say "+say);
    }


    @Override
    public Object print(Person person) {
        System.out.println(person);
        return "success";
    }
}
