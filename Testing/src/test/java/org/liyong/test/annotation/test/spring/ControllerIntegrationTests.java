package org.liyong.test.annotation.test.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertFalse;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className ControllerIntegrationTests
 *@description 具有上下文层次结构的单个测试类
 *@JunitTest: {@link  } 
 *@date 2020-08-05 22:12    
 *
 *
**/
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy({
        @ContextConfiguration(classes = ControllerIntegrationTests.AppConfig.class),
        @ContextConfiguration(classes = ControllerIntegrationTests.WebConfig.class)
})
public class ControllerIntegrationTests {

    @Configuration
    static class AppConfig {

        @Bean
        public String foo() {
            return "foo";
        }
    }

    @Configuration
    static class WebConfig {

        @Bean
        public String bar() {
            return "bar";
        }
    }


    @Autowired
    WebApplicationContext wac;


    @Test
    public void testHierarchy(){

        ApplicationContext parent = wac.getParent();

        WebApplicationContext root = (WebApplicationContext) parent;

        assertFalse(root.getBeansOfType(String.class).containsKey("bar"));

        //在WebConfig容器中
        assertFalse(!wac.getBeansOfType(String.class).containsKey("bar"));

    }



}
