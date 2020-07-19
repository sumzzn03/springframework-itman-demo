package com.liyong.ioccontainer.service.aop.autoproxycreator;

import org.springframework.stereotype.Component;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className MyService
 * @description
 * @date 2020-03-20 17:51
 * @JunitTest: {@link  }
 **/
@CustomAnotation
@Component
public class MyService {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
