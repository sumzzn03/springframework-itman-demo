package org.liyong.dataaccess.service;

import org.liyong.dataaccess.entity.Foo;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className JdbcTemplateServiceImpl
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-08-31 23:10    
 *
 *
**/
public class JdbcTemplateServiceImpl implements JdbcTemplateService{

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplateServiceImpl(JdbcTemplate jdbcTemplate){

        this.jdbcTemplate = jdbcTemplate;

    }

    @Override
    public int findCount(String name){
        return this.jdbcTemplate.queryForObject("select count(*) from stock", Integer.class);
    }

    @Override
    public String findNameById(Integer id){
        return this.jdbcTemplate.queryForObject(
                "select name from stock where id = ?",
                String.class, id);
    }

    @Override
    public Foo findById(Integer id){
        return jdbcTemplate.queryForObject(
                "select name,age from stock where id = ?",
                (resultSet, rowNum) -> {
                    Foo newFoo = new Foo("ouwen","liyong",18);
                    newFoo.setAge(resultSet.getInt("age"));
                    newFoo.setFooName(resultSet.getString("name"));
                    return newFoo;
                },
                id);
    }

    @Override
    public List<Foo> findAllActors(){
        return this.jdbcTemplate.query(
                "select name,age from stock",
                (resultSet, rowNum) -> {
                    Foo newFoo = new Foo("ouwen","liyong",18);
                    newFoo.setAge(resultSet.getInt("age"));
                    newFoo.setFooName(resultSet.getString("name"));
                    return newFoo;
                });
    }

    @Override
    public void insert(Foo foo){
        this.jdbcTemplate.update(
                "insert into stock (name, age) values (?, ?)",
                foo.getFooName(), foo.getAge());
    }

    @Override
    public void update(Foo foo){
        this.jdbcTemplate.update(
                "update stock set age = ? where name = ?",
                foo.getAge(),foo.getFooName() );
    }

    @Override
    public void delete(Integer id){
        this.jdbcTemplate.update(
                "delete from stock where id = ?",
                id);
    }

}
