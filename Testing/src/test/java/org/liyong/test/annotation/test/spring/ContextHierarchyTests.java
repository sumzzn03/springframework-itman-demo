package org.liyong.test.annotation.test.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.liyong.test.annotation.test.spring.annotation.test.spring.OtherService;
import org.liyong.test.annotation.test.spring.annotation.test.spring.PersionService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className ContextHierarchyTests
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-08-01 23:05    
 *
 *
**/
@RunWith(SpringRunner.class)
@ContextHierarchy({
        @ContextConfiguration("classpath:/META-INF/context-configuration-parent-metadata.xml"),
        @ContextConfiguration("classpath:/META-INF/context-configuration-child-metadata.xml")
})
public class ContextHierarchyTests {

    @Resource
    private PersionService persionService;

    @Resource
    private OtherService otherService;


    @Test
    public void testToSay(){

        persionService.say("liyong");

        otherService.say("ouwen");

    }


}
