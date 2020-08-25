package org.liyong.dataaccess.service.annotation;

import org.liyong.dataaccess.service.PropagationServiceOperation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className PropagationServiceOperationImpl
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-08-25 23:35    
 *
 *
**/
public class PropagationServiceOperationImpl implements PropagationServiceOperation {


    //外部事物存在则加入，不存在咋新建事物
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void doService1() {

        throw new RuntimeException("同级事物抛出异常");

    }

    //不管外部是否存在事物，新建事物
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void doService2() {


        throw new RuntimeException("新建事物抛出异常");

    }


    @Transactional(propagation = Propagation.NESTED)
    @Override
    public void doService3() {

        throw new RuntimeException("嵌入事物抛出异常");

    }


}
