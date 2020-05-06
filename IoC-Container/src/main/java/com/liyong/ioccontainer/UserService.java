package com.liyong.ioccontainer;


import com.liyong.ioccontainer.entity.Book;
import com.liyong.ioccontainer.entity.User;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className UserService
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-05-06 21:35    
 *
 *
**/
public class UserService implements IUserService{

    private BookService bookService;

    /***
     *
     * 构造函数注入
     *
     * @author liyong
     * @date 9:57 PM 2020/5/6
     * @param bookService
     * @exception
     * @return
     **/
    public UserService(BookService bookService){

        this.bookService = bookService;
    }


    @Override
    public void buyBook(User usr, Book book) {

        System.out.println("用户："+usr+"，购买书："+book);

        bookService.save(book);
    }
}
