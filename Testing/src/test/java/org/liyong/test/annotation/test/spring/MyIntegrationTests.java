package org.liyong.test.annotation.test.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className MyIntegrationTests
 *@description 自定义属性文件加载
 *@JunitTest: {@link  } 
 *@date 2020-08-02 09:46    
 *
 *
**/
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfig.class)
//@TestPropertySource("classpath:/test.properties")
@TestPropertySource(properties = { "dog.age = 12"})
public class MyIntegrationTests {

    @Value("${dog.age}")
    private String age;

    @Test
    public void testForProperty(){

        System.out.println("the dog age is "+age);

    }

}
