package org.liyong.test.annotation.test.spring;

import org.junit.Test;
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
 *@className ExtendedTests
 *@description 合并所有子容器bean，父bean容器不合并
 *@JunitTest: {@link  } 
 *@date 2020-08-05 22:41    
 *
 *
**/
@ContextHierarchy(
        @ContextConfiguration(name = "child", locations = "classpath:/META-INF/order-config.xml")
)
public class ExtendedTests extends BaseTests {


    @Autowired
    WebApplicationContext wac;


    @Test
    public void testHierarchy(){


        //父容器bean不存在
        assertFalse(Arrays.stream(wac.getBeanDefinitionNames()).collect(Collectors.toList()).contains("workService"));

        //合并子容器所有bean
        assertFalse(!Arrays.stream(wac.getBeanDefinitionNames()).collect(Collectors.toList()).contains("otherService"));

        assertFalse(!Arrays.stream(wac.getBeanDefinitionNames()).collect(Collectors.toList()).contains("persionService"));


    }

}
