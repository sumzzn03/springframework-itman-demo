package com.liyong.ioccontainer.service.beanscope;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className LoginAction
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-06-29 23:15    
 *
 *
**/
@RequestScope//指定作用域访问为request
@Component
public class LoginAction2 {
}
