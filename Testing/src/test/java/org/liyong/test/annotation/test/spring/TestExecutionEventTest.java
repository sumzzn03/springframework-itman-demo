package org.liyong.test.annotation.test.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.liyong.test.annotation.test.spring.annotation.test.spring.AppConfig;
import org.liyong.test.annotation.test.spring.annotation.test.spring.OtherService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestContextManager;
import org.springframework.test.context.event.AfterTestClassEvent;
import org.springframework.test.context.event.BeforeTestClassEvent;
import org.springframework.test.context.event.annotation.AfterTestClass;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Executor;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className TestExecutionEventTest
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-08-04 21:17    
 *
 *
**/
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {AppConfig.class, TestExecutionEventTest.Config.class, TestExecutionEventTest.ConfigAsyn.class})
public class TestExecutionEventTest {

    private static final String THREAD_NAME_PREFIX = "Test-";

    public static  TestContextManager testContextManager = new TestContextManager(TestExecutionEventTest.class);
    public static  TestContext testContext = testContextManager.getTestContext();
    //出发ApplicationContext加载
    public static  OtherService listener = testContext.getApplicationContext().getBean(OtherService.class);

    @Test
    public void testForSay() throws Exception {

        testContextManager.beforeTestClass();

        testContextManager.afterTestClass();

    }

    @Configuration
    static class Config{

        @BeforeTestClass
        public void beforTest(BeforeTestClassEvent event){

            System.out.println(Thread.currentThread().getName()+":BeforeTestClassEvent:"+event);

        }

        @AfterTestClass
        public void afterTest(AfterTestClassEvent event){


            System.out.println(Thread.currentThread().getName()+":AfterTestClassEvent:"+event);

        }

    }


    @Configuration
    @EnableAsync(proxyTargetClass = true)
    static class ConfigAsyn extends AsyncConfigurerSupport {

        @Override
        public Executor getAsyncExecutor() {
            ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
            executor.setThreadNamePrefix(THREAD_NAME_PREFIX);
            executor.initialize();
            return executor;
        }

        /**
         *
         * 注册异步执行组件，不能直接
         *
         * @author liyong
         * @date 10:38 PM 2020/8/4
         * @param
         * @exception
         * @return AsyncTestEventComponent
         **/
        @Bean
        public AsyncTestEventComponent asyncTestEventComponent(){

            return new AsyncTestEventComponent();

        }

    }

    static class AsyncTestEventComponent {

        @Async
        @BeforeTestClass("1==1")
        public void beforTest(BeforeTestClassEvent event){

            System.out.println(Thread.currentThread().getName()+":AsynBeforeTestClassEvent:"+event);

        }

        @Async
        @AfterTestClass("true")
        public void afterTest(AfterTestClassEvent event){


            System.out.println(Thread.currentThread().getName()+":AsynAfterTestClassEvent:"+event);

        }

    }

}
