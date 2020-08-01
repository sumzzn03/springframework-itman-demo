package org.liyong.test.annotation.test.spring.annotation.test.spring;
/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className OtherServiceImpl
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-08-01 22:30    
 *
 *
**/
public class OtherServiceImpl implements OtherService{
    @Override
    public void say(String say) {
        System.out.println("the other is say "+say);
    }
}
