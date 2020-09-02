package com.liyong.ioccontainer.starter;

import com.liyong.ioccontainer.properties.config.Apps;
import com.liyong.ioccontainer.properties.config.MqProperties;
import com.liyong.ioccontainer.service.BookService;
import com.liyong.ioccontainer.service.IBookService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className IoCContainer
 * @description 自定义环境变量加载 启动系统参数增加：-Dspring.profiles.active=dev 来切换环境变量
 * @JunitTest: {@link  }
 * @date 2020-05-06 21:28
 **/
@Configuration
public class CustomPropertiesIocContainer {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

        annotationConfigApplicationContext.scan("com.liyong.ioccontainer.properties");
        //注册bean到容器中
        annotationConfigApplicationContext.register(CustomPropertiesIocContainer.class);

        //启动容器
        annotationConfigApplicationContext.refresh();

        MqProperties mqProperties = Apps.buildProperties(MqProperties.class);

        System.out.println("自定义属性："+mqProperties);

        // 显示地关闭 Spring 应用上下文
        annotationConfigApplicationContext.close();

    }

}
