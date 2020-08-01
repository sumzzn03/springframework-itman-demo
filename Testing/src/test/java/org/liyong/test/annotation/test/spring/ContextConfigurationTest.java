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
 *@className ContextConfigurationTest
 *@description 指定XML配置文件路径加载容器上下文
 *@JunitTest: {@link  } 
 *@date 2020-08-01 16:49    
 *
 *
**/
@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:/META-INF/context-configuration-metadata.xml")
public class ContextConfigurationTest {

    @Resource
    private PersionService persionService;


    @Test
    public void testForSay(){

        persionService.say("ouwen");

    }


}
