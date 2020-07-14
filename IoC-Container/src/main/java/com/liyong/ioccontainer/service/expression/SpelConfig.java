package com.liyong.ioccontainer.service.expression;

import com.liyong.ioccontainer.service.expression.vo.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className SpelConfig
 * @description
 * @date 2019-12-05 10:14
 **/
@Configuration
public class SpelConfig {
    @Bean
    public Person person() {
        return new Person("fsx", 18);
    }
}
