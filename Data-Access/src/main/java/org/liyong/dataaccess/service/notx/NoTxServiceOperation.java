package org.liyong.dataaccess.service.notx;

import org.liyong.dataaccess.entity.Foo;
import org.liyong.dataaccess.service.ServiceOperation;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className NoTxServiceOperation
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-08-20 23:33    
 *
 *
**/
public class NoTxServiceOperation implements ServiceOperation {

    private JdbcTemplate jdbcTemplate;

    public NoTxServiceOperation(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertFoo(Foo foo) {
        jdbcTemplate.update("insert into stock(name,age) values (?, ?)",foo.getFooName(),foo.getAge());

        throw new RuntimeException("此异常事物不会回滚");
    }
}
