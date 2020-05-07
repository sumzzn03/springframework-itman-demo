package com.liyong.ioccontainer.service;


import com.liyong.ioccontainer.entity.Book;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className IBookService
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-05-06 21:37    
 *
 *
**/
public interface IBookService {

    Book findById(Long id);

    void save(Book book);

    void update(Book book);

}
