package org.liyong.test.annotation.test.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.liyong.test.annotation.test.spring.annotation.test.spring.AppConfig;
import org.liyong.test.annotation.test.spring.annotation.test.spring.OtherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className SessionScopedBeanTests
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-08-05 23:17    
 *
 *
**/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
public class SessionScopedBeanTests {

    @Autowired
    OtherService otherService;

    @Autowired
    MockHttpSession session;

    @Test
    public void sessionScope() throws Exception {

        session.setAttribute("theme", "blue");

        otherService.say("ouwen");
    }

}
