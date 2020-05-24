package com.liyong.ioccontainer.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className MovieRecommender
 * @description
 * @JunitTest: {@link  }
 * @date 2020-05-24 12:59
 **/
@Component
public class MovieRecommender {

    private final String catalog;
    private final String userName;

    public MovieRecommender(@Value("${catalog.name}") String catalog, @Value("${user.name}") String userName) {
        this.catalog = catalog;
        this.userName = userName;
    }

    public String getCatalog() {
        return catalog;
    }


    public String getUserName() {
        return userName;
    }
}
