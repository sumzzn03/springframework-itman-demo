package org.liyong.dataaccess.service.annotation;

import org.liyong.dataaccess.entity.Foo;
import org.liyong.dataaccess.exception.InstrumentNotFoundException;
import org.liyong.dataaccess.service.PropagationServiceOperation;
import org.liyong.dataaccess.service.ServiceOperation;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className AnnotationServiceOperation
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-08-20 23:33    
 *
 *
**/
public class AnnotationServiceOperation implements ServiceOperation {

    private JdbcTemplate jdbcTemplate;
    private PropagationServiceOperation propagationServiceOperation;

    public AnnotationServiceOperation(JdbcTemplate jdbcTemplate, PropagationServiceOperation propagationServiceOperation){
        this.jdbcTemplate = jdbcTemplate;
        this.propagationServiceOperation = propagationServiceOperation;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void insertFoo(Foo foo) {

        jdbcTemplate.update("insert into stock(name,age) values (?, ?)",foo.getFooName(),foo.getAge());

        throw new RuntimeException("此异常事物会回滚");
    }

    @Transactional(rollbackFor = InstrumentNotFoundException.class)
    @Override
    public void insertFoo2(Foo foo) {

        jdbcTemplate.update("insert into stock(name,age) values (?, ?)",foo.getFooName(),foo.getAge());

        throw new RuntimeException("此异常事物会回滚");

    }

    //事物回滚
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void propagation1(Foo foo) {
        jdbcTemplate.update("insert into stock(name,age) values (?, ?)",foo.getFooName(),foo.getAge());

        propagationServiceOperation.doService1();
    }


    //事物提交，子事物不影响
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void propagation2(Foo foo) {
        jdbcTemplate.update("insert into stock(name,age) values (?, ?)",foo.getFooName(),foo.getAge());

        try {
            propagationServiceOperation.doService2();
        }catch (Exception e){}

    }

    //事物提交，嵌套事物回滚到相应保存点
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void propagation3(Foo foo) {
        jdbcTemplate.update("insert into stock(name,age) values (?, ?)",foo.getFooName(),foo.getAge());

        try {
            propagationServiceOperation.doService3();
        }catch (Exception e){}

    }

}
