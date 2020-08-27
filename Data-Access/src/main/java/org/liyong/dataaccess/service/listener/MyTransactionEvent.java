package org.liyong.dataaccess.service.listener;

import org.springframework.context.ApplicationEvent;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className MyTransactionEvent
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-08-27 23:16    
 *
 *
**/
public class MyTransactionEvent extends ApplicationEvent {
    private String name;
    public MyTransactionEvent(String name, Object source) {
        super(source);
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
}
