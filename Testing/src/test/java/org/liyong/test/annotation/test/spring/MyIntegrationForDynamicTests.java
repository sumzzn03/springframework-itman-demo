package org.liyong.test.annotation.test.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className MyIntegrationForDynamicTests
 * @description 动态属性加载
 * @JunitTest: {@link  }
 * @date 2020-08-02 09:55
 **/
@RunWith(SpringRunner.class)
@ContextConfiguration
public class MyIntegrationForDynamicTests {

    @Value("${server.port}")
    private String port;

    static MyExternalServer server = new MyExternalServer("8080");

    @DynamicPropertySource
    static void dynamicProperties(DynamicPropertyRegistry registry) {
        registry.add("server.port", server::getPort);
    }


    /**
     * 获取动态加载属性
     *
     * @param
     * @return void
     * @throws
     * @author liyong
     * @date 9:59 AM 2020/8/2
     **/
    @Test
    public void testForDynamicProperties() {

        System.out.println("The port is " + port);

    }

    static class MyExternalServer {

        public MyExternalServer(String port) {
            this.port = port;
        }

        private String port;

        public String getPort() {
            return port;
        }

        public void setPort(String port) {
            this.port = port;
        }

    }


}
