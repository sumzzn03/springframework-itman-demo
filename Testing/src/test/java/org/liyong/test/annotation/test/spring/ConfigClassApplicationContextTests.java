package org.liyong.test.annotation.test.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.liyong.test.annotation.test.spring.annotation.test.spring.PersionService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className ConfigClassApplicationContextTests
 *@description 通过指定Configuration加载容器上下文
 *@JunitTest: {@link  } 
 *@date 2020-08-01 22:05    
 *
 *
**/
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class ConfigClassApplicationContextTests {

    @Resource
    private PersionService persionService;


    @Test
    public void testSay(){
        persionService.say("liyong");
    }

}
