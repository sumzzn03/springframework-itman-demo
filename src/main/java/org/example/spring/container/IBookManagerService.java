package org.example.spring.container;

import org.example.spring.container.entity.Book;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className IBookManager
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-05-06 21:57    
 *
 *
**/
public interface IBookManagerService {

    void save(Book book);

    void update(Book book);

}
