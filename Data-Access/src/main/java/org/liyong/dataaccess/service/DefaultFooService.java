package org.liyong.dataaccess.service;


import org.liyong.dataaccess.entity.Foo;
import org.liyong.dataaccess.exception.InstrumentNotFoundException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className DefaultFooService
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-07-22 23:40    
 *
 *
**/
public class DefaultFooService implements FooService {


    private JdbcTemplate jdbcTemplate;

    public DefaultFooService(){}

    public DefaultFooService(JdbcTemplate jdbcTemplate){

        this.jdbcTemplate = jdbcTemplate;

    }

    @Override
    public Foo getFoo(String fooName) {
       return new Foo(fooName,null,10);
    }

    @Override
    public Foo getFoo(String fooName, String barName) {
        return new Foo(fooName,barName,10);
    }

    @Override
    public void insertFoo(Foo foo) {

        jdbcTemplate.update("insert into stock(name,age) values (?, ?)",foo.getFooName(),foo.getAge());

        //抛出指定异常回滚事物
        throw new InstrumentNotFoundException();

    }

    @Override
    public void updateFoo(Foo foo) {
        System.out.println("updateFoo");
    }

    @Override
    public void updateStock(Foo foo) {

    }
}
