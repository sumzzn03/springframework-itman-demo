package com.liyong.ioccontainer;

import com.liyong.ioccontainer.entity.Book;
import com.liyong.ioccontainer.entity.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className IoCContainer
 * @description 启动类
 * @JunitTest: {@link  }
 * @date 2020-05-06 21:28
 **/
public class IoCContainer {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

        //注册bean到容器中
        annotationConfigApplicationContext.register(IoCContainer.class);

        annotationConfigApplicationContext.register(UserService.class);

        annotationConfigApplicationContext.register(BookService.class);

        annotationConfigApplicationContext.register(BookManagerService.class);

        //启动容器
        annotationConfigApplicationContext.refresh();

        IUserService userService = annotationConfigApplicationContext.getBean(IUserService.class);

        User user = new User();
        user.setId(3L);
        user.setAge(18);
        user.setName("ouwen");

        Book book = new Book();
        book.setPrice(50);
        book.setName("SpringCloud");
        book.setId(1L);

        userService.buyBook(user, book);


        IBookManagerService bookManagerService =  annotationConfigApplicationContext.getBean(IBookManagerService.class);

        Book book2 = new Book();
        book2.setPrice(60);
        book2.setName("Netty5");
        book2.setId(2L);
        bookManagerService.save(book2);

        // 显示地关闭 Spring 应用上下文
        annotationConfigApplicationContext.close();

    }
}
