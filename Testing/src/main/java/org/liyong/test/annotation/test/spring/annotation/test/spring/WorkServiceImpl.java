package org.liyong.test.annotation.test.spring.annotation.test.spring;
/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className WorkServiceImpl
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-08-05 22:30    
 *
 *
**/
public class WorkServiceImpl implements WorkService{
    @Override
    public void say(String say) {
        System.out.println("hello "+say);
    }
}
