package com.liyong.ioccontainer.service.basejavaandxml;

import com.liyong.ioccontainer.service.basejavaconfig.AccountRepository;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className TransferServiceImpl
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-07-07 22:51    
 *
 *
**/
public class TransferServiceImpl implements TransferService{
    private AccountRepository repository;
    public TransferServiceImpl(){}
    public TransferServiceImpl(AccountRepository repository){
        this.repository = repository;
    }


    @Override
    public void print() {
        repository.print();
    }
}
