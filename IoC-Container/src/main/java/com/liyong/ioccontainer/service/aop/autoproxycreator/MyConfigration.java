package com.liyong.ioccontainer.service.aop.autoproxycreator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className MyConfigration
 * @description
 * @date 2020-03-20 17:50
 * @JunitTest: {@link  }
 **/
@Configuration
public class MyConfigration {

    @Bean
    public CustomAutoProxyCreator customAutoProxyCreator(){
        return new CustomAutoProxyCreator();
    }

}
