package com.liyong.ioccontainer.service.validator;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className ConstraintAppConfig
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-07-13 23:21    
 *
 *
**/
@Configurable
public class ConstraintAppConfig {

    @Bean
    public MyConstraintValidator constraintValidator(){
        return new MyConstraintValidator();
    }

}
