package org.liyong.dataaccess.dao;

import org.liyong.dataaccess.entity.Foo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className NameParameterJdbcCorporateEventDao
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-09-01 22:30    
 *
 *
**/
@Repository
public class NameParameterJdbcCorporateEventDao implements CorporateEventDao{

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public void insertFoo(Foo foo){

        Map<String,String> map = new HashMap<>();

        map.put("name",foo.getFooName());

        map.put("age",String.valueOf(foo.getAge()));

        SqlParameterSource namedParameters = new MapSqlParameterSource(map);

        jdbcTemplate.update("insert into stock(name,age) values (:name, :age)",namedParameters);


    }

}
