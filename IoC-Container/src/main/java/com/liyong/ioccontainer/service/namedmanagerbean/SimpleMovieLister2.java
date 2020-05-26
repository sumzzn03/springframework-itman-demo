package com.liyong.ioccontainer.service.namedmanagerbean;

import com.liyong.ioccontainer.service.annotationbase.MovieFinder;

import javax.annotation.ManagedBean;
import javax.inject.Inject;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className SimpleMovieLister
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-05-26 23:06    
 *
 *
**/
@ManagedBean("movieListener2")
public class SimpleMovieLister2 {

    private MovieFinder movieFinder;

    @Inject
    public void setMovieFinder(MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
        movieFinder.findMovies("SimpleMovieLister2");
    }

    // ...
}