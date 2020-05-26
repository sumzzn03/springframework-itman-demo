package com.liyong.ioccontainer.service.injectnamed;

import com.liyong.ioccontainer.service.annotationbase.MovieFinder;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className SimpleMovieLister
 * @description
 * @JunitTest: {@link  }
 * @date 2020-05-26 22:39
 **/
@Component
public class SimpleMovieLister3 {

    private MovieFinder movieFinder;

    @Inject
    public void setMovieFinder(@Named("main") MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
        movieFinder.findMovies("SimpleMovieLister3");
    }


}
