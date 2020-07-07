package com.liyong.ioccontainer.service.basejavaconfig;

import javax.sql.DataSource;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className AccountRepositoryImpl
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-07-07 21:40    
 *
 *
**/
public class AccountRepositoryImpl implements AccountRepository{

    private DataSource dataSource;

    public AccountRepositoryImpl(){}

    public AccountRepositoryImpl(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public void print() {
        System.out.println("AccountRepositoryImpl");
    }
}
