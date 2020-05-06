package org.example.spring.container;

import org.example.spring.container.entity.Book;
import org.example.spring.container.entity.User;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className IUserService
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-05-06 21:34    
 *
 *
**/
public interface IUserService {
    void buyBook(User usr, Book book);
}
