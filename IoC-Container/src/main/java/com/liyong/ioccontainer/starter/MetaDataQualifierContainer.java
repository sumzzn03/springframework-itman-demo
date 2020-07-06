package com.liyong.ioccontainer.starter;

import com.liyong.ioccontainer.service.classpathscan.MetaDataAuqlifierAppConfig;
import com.liyong.ioccontainer.service.classpathscan.metadataqualifier.MyActionService;
import com.liyong.ioccontainer.service.classpathscan.namegenerator.SimpleMovieLister;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className BeanNameGeneratorIoCContainer
 * @description 注解提供限定元数据
 * @JunitTest: {@link  }
 * @date 2020-05-06 21:28
 **/
public class MetaDataQualifierContainer {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类） -> Spring Bean
        applicationContext.register(MetaDataAuqlifierAppConfig.class);

        // 启动 Spring 应用上下文
        applicationContext.refresh();

        MyActionService myActionService =  applicationContext.getBean(MyActionService.class);

        myActionService.print();

    }

}
