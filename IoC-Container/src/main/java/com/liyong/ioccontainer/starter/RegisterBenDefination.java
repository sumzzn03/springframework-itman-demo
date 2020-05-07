package com.liyong.ioccontainer.starter;

import com.liyong.ioccontainer.service.BookService;
import com.liyong.ioccontainer.service.OtherService;
import com.liyong.ioccontainer.service.UserService;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className RegisterBenDefination
 * @description 通过BeanDefinition组成bean
 * @JunitTest: {@link  }
 * @date 2020-05-07 23:50
 **/
public class RegisterBenDefination {

    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(OtherService.class);

        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();

        //注册bean
        beanFactory.registerBeanDefinition("otherService", beanDefinition);

        BookService bookService = new BookService();

        //注册单例bean
        beanFactory.registerSingleton("bookService",bookService);

        OtherService otherService = beanFactory.getBean(OtherService.class);

        otherService.save("hello world");

        BookService bookService1 = beanFactory.getBean(BookService.class);

        BookService bookService12 = beanFactory.getBean(BookService.class);

        System.out.println("是否是单例bean:" + (bookService1 == bookService12));

    }
}
