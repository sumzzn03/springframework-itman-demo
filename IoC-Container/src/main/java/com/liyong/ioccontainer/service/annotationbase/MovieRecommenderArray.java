package com.liyong.ioccontainer.service.annotationbase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className MovieRecommender
 * @description 集合注入
 * @JunitTest: {@link  }
 * @date 2020-05-22 23:46
 **/
@Component
public class MovieRecommenderArray {

    @Autowired
    private MovieCatalog[] movieCatalogs;


    public void print() {
        Arrays.stream(movieCatalogs).forEach(movieCatalog -> movieCatalog.print());
    }

}
