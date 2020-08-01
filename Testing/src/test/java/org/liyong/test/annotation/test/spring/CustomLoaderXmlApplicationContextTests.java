package org.liyong.test.annotation.test.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.liyong.test.annotation.test.spring.annotation.test.spring.OtherService;
import org.liyong.test.annotation.test.spring.annotation.test.spring.PersionService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className CustomLoaderXmlApplicationContextTests
 *@description 1.指定XML容器配置文件 2.自定义上下文加器
 *@JunitTest: {@link  } 
 *@date 2020-08-01 22:23    
 *
 *
**/
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/context-configuration-metadata.xml",
        loader = CustomContextLoader.class)
public class CustomLoaderXmlApplicationContextTests {


    @Resource
    private PersionService persionService;

    @Resource
    private OtherService otherService;


    @Test
    public void testForSay(){

        persionService.say("ouwen");

        otherService.say("liyong");

    }


}
