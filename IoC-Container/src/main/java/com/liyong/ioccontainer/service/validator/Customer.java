package com.liyong.ioccontainer.service.validator;
/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className Customer
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-07-11 13:05    
 *
 *
**/
public class Customer {
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
