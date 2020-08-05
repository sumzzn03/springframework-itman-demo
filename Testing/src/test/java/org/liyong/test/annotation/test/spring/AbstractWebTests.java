package org.liyong.test.annotation.test.spring;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className AbstractWebTests
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-08-05 22:24    
 *
 *
**/
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath:/META-INF/applicationContext.xml")
public class AbstractWebTests {
}
