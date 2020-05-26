package com.liyong.ioccontainer.service.injectnamed;

import com.liyong.ioccontainer.service.annotationbase.MovieFinder;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
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
public class SimpleMovieLister1 {
    private Provider<MovieFinder> movieFinder;

    @Inject
    public void setMovieFinder(Provider<MovieFinder> movieFinder) {
        this.movieFinder = movieFinder;
        this.movieFinder.get().findMovies("SimpleMovieLister1");
    }

}
