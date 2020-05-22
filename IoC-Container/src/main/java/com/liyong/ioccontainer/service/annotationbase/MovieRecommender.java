package com.liyong.ioccontainer.service.annotationbase;

import com.liyong.ioccontainer.service.OtherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className MovieRecommender
 * @description 构造方法注入
 * @JunitTest: {@link  }
 * @date 2020-05-22 23:46
 **/
@Component
public class MovieRecommender {

    @Autowired
    private ApplicationContext context;

    private final OtherService otherService;

    @Autowired
    public MovieRecommender(OtherService otherService) {
        this.otherService = otherService;
    }
}
