package org.liyong.test.annotation.test.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.context.ContextCustomizerFactory;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DefaultTestContextBootstrapper;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className BootstrapWithTest
 *@description @BootstrapWith自定义启Spring TestContext启动引导
 *@JunitTest: {@link  } 
 *@date 2020-08-01 16:38    
 *
 *
**/
@RunWith(SpringRunner.class)
@BootstrapWith(BootstrapWithTest.CustomTestContextBootstrapper.class)
public class BootstrapWithTest {

    @Autowired
    String foo;


    @Test
    public void injectedBean() {
        assertEquals("foo", foo);
    }


    /**
     *@author <a href="http://youngitman.tech">青年IT男</a>
     *@version v1.0.0
     *@className 启动注入foo bean到容器中
     *@description
     *@JunitTest: {@link  }
     *@date 4:41 PM 2020/8/1
     *
    **/
    static class CustomTestContextBootstrapper extends DefaultTestContextBootstrapper {

        @Override
        protected List<ContextCustomizerFactory> getContextCustomizerFactories() {
            return singletonList(
                    (testClass, configAttributes) ->
                            (context, mergedConfig) -> context.getBeanFactory().registerSingleton("foo", "foo")
            );
        }
    }

}
