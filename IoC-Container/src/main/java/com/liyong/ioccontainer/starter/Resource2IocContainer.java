package com.liyong.ioccontainer.starter;

import cn.hutool.core.io.resource.InputStreamResource;
import com.liyong.ioccontainer.service.AutowireCandidateService;
import com.liyong.ioccontainer.service.resource.ResourceService;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.*;

import java.io.IOException;
import java.io.InputStream;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className ResourceIocContainer
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-07-09 21:02    
 *
 *
**/
public class Resource2IocContainer {

    public static void main(String[] args) throws Exception {

        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类） -> Spring Bean
        applicationContext.register(Resource2IocContainer.class);

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);

        String xmlResourcePath = "classpath:/META-INF/resource-metadata.xml";
        // 加载 XML 资源，解析并且生成 BeanDefinition
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        // 启动 Spring 应用上下文
        applicationContext.refresh();

        ResourceService resourceService = applicationContext.getBean(ResourceService.class);


        Resource resource1 = resourceService.getResource1();

        Resource resource2 = resourceService.getResource2();

        Resource resource3 = resourceService.getResource3();

        ResourceIocContainer.print("resource1",resource1.getInputStream());
        ResourceIocContainer.print("resource2",resource2.getInputStream());
        ResourceIocContainer.print("resource3",resource3.getInputStream());

        // 显示地关闭 Spring 应用上下文
        applicationContext.close();

    }


}
