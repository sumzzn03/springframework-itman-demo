package com.liyong.ioccontainer.service.basejavaandxml;

import com.liyong.ioccontainer.service.basejavaconfig.AccountRepository;

import javax.sql.DataSource;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className JdbcAccountRepository
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-07-07 22:52    
 *
 *
**/
public class JdbcAccountRepository implements AccountRepository {

    private DataSource dataSource;
    public JdbcAccountRepository(){}

    public JdbcAccountRepository(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public void print() {
        System.out.println("JdbcAccountRepository");
    }
}
