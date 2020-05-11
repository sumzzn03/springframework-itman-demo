package com.liyong.ioccontainer.service;
/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className PNameSpaceService
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-05-11 21:51    
 *
 *
**/
public class CNameSpaceService {

    private OtherService otherService;

    private String name;

    private String alias;

    public CNameSpaceService(OtherService otherService, String name, String alias) {
        this.otherService = otherService;
        this.name = name;
        this.alias = alias;
    }

    public OtherService getOtherService() {
        return otherService;
    }

    public void setOtherService(OtherService otherService) {
        this.otherService = otherService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Override
    public String toString() {
        return "PNameSpaceService{" +
                "name='" + name + '\'' +
                ", alias='" + alias + '\'' +
                '}';
    }
}
