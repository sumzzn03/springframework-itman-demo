package org.liyong.test.annotation.test.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.liyong.test.annotation.test.spring.annotation.test.spring.CustomContextIntializer;
import org.liyong.test.annotation.test.spring.annotation.test.spring.PersionService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className ContextInitializerTests
 *@description 自定义上下文加载器
 *@JunitTest: {@link  } 
 *@date 2020-08-01 22:11    
 *
 *
**/
@RunWith(SpringRunner.class)
@ContextConfiguration(initializers = CustomContextIntializer.class)
public class ContextInitializerTests {


    @Resource
    private PersionService persionService;

    @Test
    public void testSay(){

        persionService.say("ouwen");

    }

}
