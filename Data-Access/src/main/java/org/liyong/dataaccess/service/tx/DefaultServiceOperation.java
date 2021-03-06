package org.liyong.dataaccess.service.tx;

import org.liyong.dataaccess.entity.Foo;
import org.liyong.dataaccess.service.ServiceOperation;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className DefaultServiceOperation
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-08-20 23:32    
 *
 *
**/
public class DefaultServiceOperation implements ServiceOperation {

    private JdbcTemplate jdbcTemplate;

    public DefaultServiceOperation(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertFoo(Foo foo) {
        jdbcTemplate.update("insert into stock(name,age) values (?, ?)",foo.getFooName(),foo.getAge());
        throw new RuntimeException("此异常事物会回滚");
    }

    @Override
    public void insertFoo2(Foo foo) {

    }
}
