package com.liyong.ioccontainer.service.resource;

import org.springframework.core.io.Resource;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className ResourceService
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-07-09 21:50    
 *
 *
**/
public class ResourceService {

    private Resource resource1;

    private Resource resource2;

    private Resource resource3;

    public Resource getResource1() {
        return resource1;
    }

    public void setResource1(Resource resource1) {
        this.resource1 = resource1;
    }

    public Resource getResource2() {
        return resource2;
    }

    public void setResource2(Resource resource2) {
        this.resource2 = resource2;
    }

    public Resource getResource3() {
        return resource3;
    }

    public void setResource3(Resource resource3) {
        this.resource3 = resource3;
    }
}
