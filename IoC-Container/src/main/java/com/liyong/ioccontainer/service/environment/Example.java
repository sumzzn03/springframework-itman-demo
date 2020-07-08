package com.liyong.ioccontainer.service.environment;

import org.springframework.context.MessageSource;

import java.util.Locale;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className Example
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-07-08 23:12    
 *
 *
**/
public class Example {

    private MessageSource messages;

    public void setMessages(MessageSource messages) {
        this.messages = messages;
    }

    public void execute() {
        String message = this.messages.getMessage("argument.required",
                new Object [] {"userDao"}, "Required", Locale.ENGLISH);
        System.out.println(message);
    }
}