package org.liyong.test.annotation.test.spring;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.Assert.assertFalse;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className ExtendedTests1
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-08-05 22:54    
 *
 *
**/
@ContextHierarchy(
        @ContextConfiguration(
                name = "child",
                locations = "classpath:/META-INF/test-user-config.xml",
                inheritLocations = false
        ))
public class ExtendedTests1 extends BaseTests {

    @Autowired
    WebApplicationContext wac;


    @Test
    public void testHierarchy(){


        assertFalse(Arrays.stream(wac.getBeanDefinitionNames()).collect(Collectors.toList()).contains("persionService"));

        //父容器获取
        assertFalse(!Arrays.stream(wac.getParent().getBeanDefinitionNames()).collect(Collectors.toList()).contains("workService"));

        //被子层级覆盖
        assertFalse(!Arrays.stream(wac.getBeanDefinitionNames()).collect(Collectors.toList()).contains("otherService"));


    }

}
