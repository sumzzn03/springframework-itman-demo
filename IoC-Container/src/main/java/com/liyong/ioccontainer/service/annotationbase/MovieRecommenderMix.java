package com.liyong.ioccontainer.service.annotationbase;

import com.liyong.ioccontainer.service.BookService;
import com.liyong.ioccontainer.service.OtherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className MovieRecommender
 * @description 构造函数和字段注入混合
 * @JunitTest: {@link  }
 * @date 2020-05-22 23:46
 **/
@Component
public class MovieRecommenderMix {

    private OtherService otherService;

    @Autowired
    private BookService movieCatalog;

    @Autowired
    public MovieRecommenderMix(OtherService otherService) {
        this.otherService = otherService;
    }

}
