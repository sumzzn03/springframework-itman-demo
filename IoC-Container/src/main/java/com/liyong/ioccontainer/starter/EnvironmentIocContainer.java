package com.liyong.ioccontainer.starter;

import com.liyong.ioccontainer.service.environment.AppConfig;
import com.liyong.ioccontainer.service.environment.TestBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className IoCContainer
 * @description 通过AnnotationConfigApplicationContext启动容器
 * @JunitTest: {@link  }
 * @date 2020-05-06 21:28
 **/
@Configuration
public class EnvironmentIocContainer {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

        //注册bean到容器中
        annotationConfigApplicationContext.register(AppConfig .class);

        //启动容器
        annotationConfigApplicationContext.refresh();


        TestBean testBean = annotationConfigApplicationContext.getBean(TestBean.class);

        System.out.println(testBean.getName());

        // 显示地关闭 Spring 应用上下文
        annotationConfigApplicationContext.close();

    }

}
