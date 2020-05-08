package com.liyong.ioccontainer.starter;

import com.liyong.ioccontainer.inner.SomeThing;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className InnerIoCContainer
 * @description
 * @JunitTest: {@link  }
 * @date 2020-05-08 18:16
 **/
public class InnerIoCContainer {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

        //注册bean到容器中
        annotationConfigApplicationContext.register(SomeThing.class);

        annotationConfigApplicationContext.register(SomeThing.OtherThing.class);

        //启动容器
        annotationConfigApplicationContext.refresh();


        BeanDefinition beanDefinition = annotationConfigApplicationContext.getBeanDefinition("someThing");

        //内嵌bean
        BeanDefinition otherBeanDefinition = annotationConfigApplicationContext.getBeanDefinition("someThing.OtherThing");

        System.out.println("内嵌bean class名称:" + otherBeanDefinition.getBeanClassName());

        System.out.println("外部bean class名称:" + beanDefinition.getBeanClassName());

        // 显示地关闭 Spring 应用上下文
        annotationConfigApplicationContext.close();

    }

}
