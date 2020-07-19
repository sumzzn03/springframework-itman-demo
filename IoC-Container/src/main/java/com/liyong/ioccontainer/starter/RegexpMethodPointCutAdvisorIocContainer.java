package com.liyong.ioccontainer.starter;

import com.liyong.ioccontainer.service.aop.regexpmethodpointcutadvisor.TestService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className IoCContainer
 * @description 通过RegexpMethodPointCutAdvisorIocContainer启动容器
 * @JunitTest: {@link  }
 * @date 2020-05-06 21:28
 **/
@Configuration
public class RegexpMethodPointCutAdvisorIocContainer {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

        //注册bean到容器中
        annotationConfigApplicationContext.register(RegexpMethodPointCutAdvisorIocContainer.class);

        //启动容器
        annotationConfigApplicationContext.refresh();

        TestService service = annotationConfigApplicationContext.getBean(TestService.class);

        service.get("liyong");

        service.set("ouwen");

        // 显示地关闭 Spring 应用上下文
        annotationConfigApplicationContext.close();

    }

}
