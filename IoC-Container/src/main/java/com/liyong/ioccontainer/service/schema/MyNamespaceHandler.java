package com.liyong.ioccontainer.service.schema;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className MyNamespaceHandler
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-07-20 08:47    
 *
 *
**/
public class MyNamespaceHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        registerBeanDefinitionParser("dateformat", new SimpleDateFormatBeanDefinitionParser());
    }
}