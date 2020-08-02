package org.liyong.test.annotation.test.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.liyong.test.annotation.test.spring.annotation.test.spring.DeveloperIntegrationConfigration;
import org.liyong.test.annotation.test.spring.annotation.test.spring.OtherService;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className DeveloperIntegrationTests
 *@description 指定激活那个配置环境
 *@JunitTest: {@link  } 
 *@date 2020-08-02 09:40    
 *
 *
**/
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DeveloperIntegrationConfigration.class)
@ActiveProfiles({"dev", "integration"})
public class DeveloperIntegrationTests {

    @Resource
    private OtherService otherService;


    @Test
    public void testForSay(){
        otherService.say("ouwen");
    }

}
