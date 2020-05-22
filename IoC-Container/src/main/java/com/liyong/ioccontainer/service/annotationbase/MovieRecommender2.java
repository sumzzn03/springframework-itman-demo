package com.liyong.ioccontainer.service.annotationbase;

import com.liyong.ioccontainer.service.BookService;
import com.liyong.ioccontainer.service.OtherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className MovieRecommender
 * @description 多参数注入
 * @JunitTest: {@link  }
 * @date 2020-05-
 * 22 23:46
 **/
@Component
public class MovieRecommender2 {

    private OtherService otherService;

    private BookService bookService;

    @Autowired
    public void prepare(OtherService otherService,
                        BookService bookService) {
        this.otherService = otherService;
        this.bookService = bookService;
    }
}
