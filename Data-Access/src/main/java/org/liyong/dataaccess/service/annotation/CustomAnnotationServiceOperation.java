package org.liyong.dataaccess.service.annotation;

import org.liyong.dataaccess.annotation.AccountTx;
import org.liyong.dataaccess.annotation.OrderTx;
import org.liyong.dataaccess.entity.Foo;
import org.liyong.dataaccess.service.ServiceOperation;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className QualifierAnnotationServiceOCustomAnnotationServiceOperationperation
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-08-20 23:33    
 *
 *
**/
public class CustomAnnotationServiceOperation implements ServiceOperation {

    private JdbcTemplate jdbcTemplate;

    public CustomAnnotationServiceOperation(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @OrderTx
    @Override
    public void insertFoo(Foo foo) {

        jdbcTemplate.update("insert into stock(name,age) values (?, ?)",foo.getFooName(),foo.getAge());

        throw new RuntimeException("此异常事物会回滚");
    }

    @AccountTx
    @Override
    public void insertFoo2(Foo foo) {

        jdbcTemplate.update("insert into stock(name,age) values (?, ?)",foo.getFooName(),foo.getAge());

        throw new RuntimeException("此异常事物会回滚");

    }
}
