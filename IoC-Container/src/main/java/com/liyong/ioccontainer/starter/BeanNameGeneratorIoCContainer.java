package com.liyong.ioccontainer.starter;

import com.liyong.ioccontainer.service.classpathscan.NameGeneratorAppConfig;
import com.liyong.ioccontainer.service.classpathscan.namegenerator.SimpleMovieLister;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className BeanNameGeneratorIoCContainer
 * @description Bean名称生成
 * @JunitTest: {@link  }
 * @date 2020-05-06 21:28
 **/
public class BeanNameGeneratorIoCContainer {

    public static void main(String[] args) {

        baseXml();

        baseAnnotation();

    }

    private static void baseXml(){

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类） -> Spring Bean
        applicationContext.register(BeanNameGeneratorIoCContainer.class);

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);

        String xmlResourcePath = "classpath:/META-INF/beanname-generator-metadata.xml";
        // 加载 XML 资源，解析并且生成 BeanDefinition
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        // 启动 Spring 应用上下文
        applicationContext.refresh();


        String[] beanNamesForType = applicationContext.getBeanNamesForType(SimpleMovieLister.class);

        Arrays.stream(beanNamesForType).forEach(System.out::println);

    }

    private static void baseAnnotation(){

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类） -> Spring Bean
        applicationContext.register(NameGeneratorAppConfig.class);

        // 启动 Spring 应用上下文
        applicationContext.refresh();

        String[] beanNamesForType = applicationContext.getBeanNamesForType(SimpleMovieLister.class);

        Arrays.stream(beanNamesForType).forEach(System.out::println);

    }

}
