package com.liyong.ioccontainer.service.annotationbase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className MovieRecommender
 * @description 集合注入
 * @JunitTest: {@link  }
 * @date 2020-05-22 23:46
 **/
@Component
public class MovieRecommenderSet {

    private Set<MovieCatalog> movieCatalogs;

    @Autowired
    public void setMovieCatalogs(Set<MovieCatalog> movieCatalogs) {
        this.movieCatalogs = movieCatalogs;
    }


    public void print() {
        movieCatalogs.stream().forEach(movieCatalog -> movieCatalog.print());
    }

}
