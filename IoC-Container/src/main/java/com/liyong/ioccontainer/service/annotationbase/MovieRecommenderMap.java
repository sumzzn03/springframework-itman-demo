package com.liyong.ioccontainer.service.annotationbase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className MovieRecommender
 * @description Map集合注入
 * @JunitTest: {@link  }
 * @date 2020-05-22 23:46
 **/
@Component
public class MovieRecommenderMap {

    private Map<String, MovieCatalog> movieCatalogs;

    @Autowired
    public void setMovieCatalogs(Map<String, MovieCatalog> movieCatalogs) {
        this.movieCatalogs = movieCatalogs;
    }


    public void print() {
        movieCatalogs.entrySet().stream().forEach(e->e.getValue().print());
    }

}
