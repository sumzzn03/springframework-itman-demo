package com.liyong.ioccontainer.service.namedmanagerbean;

import com.liyong.ioccontainer.service.annotationbase.MovieFinder;

import javax.inject.Inject;
import javax.inject.Named;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className SimpleMovieLister1
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-05-26 23:06    
 *
 *
**/
@Named
public class SimpleMovieLister1 {

    private MovieFinder movieFinder;

    @Inject
    public void setMovieFinder(MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
        movieFinder.findMovies("SimpleMovieLister1");
    }

    // ...
}