package org.liyong.dataaccess.service;

import org.liyong.dataaccess.entity.Foo;

import java.util.List;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className JdbcTemplateService
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-08-31 23:09    
 *
 *
**/
public interface JdbcTemplateService {

   int findCount(String name);

   String findNameById(Integer id);

   Foo findById(Integer id);

   List<Foo> findAllActors();

   void insert(Foo foo);

   void update(Foo foo);

   void delete(Integer id);

}
