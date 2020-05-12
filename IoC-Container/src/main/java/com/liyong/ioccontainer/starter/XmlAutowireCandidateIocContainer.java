package com.liyong.ioccontainer.starter;

import com.liyong.ioccontainer.service.AutowireCandidateService;
import com.liyong.ioccontainer.service.BookService;
import com.liyong.ioccontainer.service.OtherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className XmlAutowireCandidateIocContainer
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-05-12 23:39    
 *
 *
**/
public class XmlAutowireCandidateIocContainer {




    public static void main(String[] args) {

        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类） -> Spring Bean
        applicationContext.register(XmlAutowireCandidateIocContainer.class);

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);

        String xmlResourcePath = "classpath:/META-INF/autowire-candidate-metadata.xml";
        // 加载 XML 资源，解析并且生成 BeanDefinition
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        // 启动 Spring 应用上下文
        applicationContext.refresh();

        AutowireCandidateService autowireCandidateService = applicationContext.getBean(AutowireCandidateService.class);

        System.out.println("otherService=>"+autowireCandidateService.getOtherService());

        System.out.println("bookService=>"+autowireCandidateService.getBookService());

        // 显示地关闭 Spring 应用上下文
        applicationContext.close();
    }


    @Bean
    public AutowireCandidateService autowireCandidateService(){
        return new AutowireCandidateService();
    }
}
