package org.liyong.test.annotation.test.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.liyong.test.annotation.test.spring.annotation.test.spring.AppConfig;
import org.liyong.test.annotation.test.spring.annotation.test.spring.OtherService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className ConfigurationClassJUnitJupiterSpringTests
 *@description {@link ContextConfiguration 的替换}
 *@JunitTest: {@link  } 
 *@date 2020-08-03 22:56    
 *
 *
**/
@RunWith(SpringRunner.class)
//@SpringJUnitConfig(AppConfig.class)
@SpringJUnitConfig(locations = "classpath:/META-INF/context-configuration-child-metadata.xml")
public class ConfigurationClassJUnitJupiterSpringTests {

    @Resource
    private OtherService otherService;

    @Test
    public void testForSay(){

        otherService.say("ouwen");

    }

}
