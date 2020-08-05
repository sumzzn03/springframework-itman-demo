package org.liyong.test.annotation.test.spring;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className SoapWebServiceTests
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-08-05 22:25    
 *
 *
**/
@ContextHierarchy(@ContextConfiguration("classpath:/META-INF/soap-ws-config.xml"))
public class SoapWebServiceTests extends AbstractWebTests{
}
