package org.liyong.test.annotation.test.spring;

import org.junit.Test;
import org.liyong.test.annotation.test.spring.annotation.test.spring.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.Assert.assertFalse;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className RestWebServiceTests
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-08-05 22:25    
 *
 *
**/
@ContextHierarchy(@ContextConfiguration("classpath:/META-INF/rest-ws-config.xml"))
public class RestWebServiceTests extends AbstractWebTests{


    @Autowired
    WebApplicationContext wac;


    @Test
    public void testHierarchy(){

        ApplicationContext parent = wac.getParent();

        WebApplicationContext root = (WebApplicationContext) parent;

        assertFalse(Arrays.stream(root.getBeanDefinitionNames()).collect(Collectors.toList()).contains("workService"));

        //在WebConfig子容器中
        assertFalse(!Arrays.stream(wac.getBeanDefinitionNames()).collect(Collectors.toList()).contains("workService"));

    }

}
