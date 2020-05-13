package com.liyong.ioccontainer.service;

import com.liyong.ioccontainer.entity.Book;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className CommandManager
 * @description 查看BookManager$$EnhancerBySpringCGLIB$$956bc0f6.java被CGLIB生成的子类
 * @JunitTest: {@link  }
 * @date 2020-05-13 22:51
 **/
public abstract class BookManager {

    public void process(Book book) {

        IBookService bookService = createBookService();

        bookService.save(book);

    }

    //方法查找由Spring生成子类实现
    protected abstract IBookService createBookService();
}