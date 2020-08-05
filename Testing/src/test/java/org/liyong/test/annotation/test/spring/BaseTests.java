package org.liyong.test.annotation.test.spring;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className BaseTests
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-08-05 22:41    
 *
 *
**/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy({
        @ContextConfiguration(name = "parent", locations = "classpath:/META-INF/app-config.xml"),
        @ContextConfiguration(name = "child", locations = "classpath:/META-INF/user-config.xml")
})
@WebAppConfiguration
public class BaseTests {
}
