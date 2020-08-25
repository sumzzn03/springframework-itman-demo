package org.liyong.dataaccess.service.annotation;

import org.liyong.dataaccess.entity.Foo;
import org.liyong.dataaccess.exception.InstrumentNotFoundException;
import org.liyong.dataaccess.service.ServiceOperation;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className QualifierAnnotationServiceOperation
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-08-20 23:33    
 *
 *
**/
public class QualifierAnnotationServiceOperation implements ServiceOperation {

    private JdbcTemplate jdbcTemplate;

    public QualifierAnnotationServiceOperation(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    //通过限定符order找到物管理器：txManager1
    @Transactional("order")
    //限定符order1找不到则使用默认事物管理器：默认配置bean名称为transactionManager
//    @Transactional("order1")
    @Override
    public void insertFoo(Foo foo) {

        jdbcTemplate.update("insert into stock(name,age) values (?, ?)",foo.getFooName(),foo.getAge());

        throw new RuntimeException("此异常事物会回滚");
    }

    //通过限定符account找到物管理器：txManager2
    @Transactional("account")
    @Override
    public void insertFoo2(Foo foo) {

        jdbcTemplate.update("insert into stock(name,age) values (?, ?)",foo.getFooName(),foo.getAge());

        throw new RuntimeException("此异常事物会回滚");

    }
}
