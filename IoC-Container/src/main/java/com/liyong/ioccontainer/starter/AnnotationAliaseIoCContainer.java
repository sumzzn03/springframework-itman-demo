package com.liyong.ioccontainer.starter;

import com.liyong.ioccontainer.service.BookService;
import com.liyong.ioccontainer.service.IBookService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
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
public class AnnotationAliaseIoCContainer {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

        //注册bean到容器中
        annotationConfigApplicationContext.register(AnnotationAliaseIoCContainer.class);

        //启动容器
        annotationConfigApplicationContext.refresh();

        BookService bookService = annotationConfigApplicationContext.getBean("bookService", BookService.class);
        BookService bookService1 = annotationConfigApplicationContext.getBean("bookService1", BookService.class);
        BookService bookService2 = annotationConfigApplicationContext.getBean("bookService2", BookService.class);

        System.out.println(bookService ==  bookService1);

        System.out.println(bookService1 == bookService2);

        // 显示地关闭 Spring 应用上下文
        annotationConfigApplicationContext.close();

    }

    @Bean(value = {"bookService","bookService1", "bookService2"})
//    @Bean( name = {"bookService","bookService1", "bookService2"})
    public IBookService bookService() {
        return new BookService();
    }
}
