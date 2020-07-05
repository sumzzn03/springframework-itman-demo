package com.liyong.ioccontainer.service.classpathscan;

import org.springframework.stereotype.Service;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className SimpleMovieLister
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-07-05 21:49    
 *
 *
**/
@Service
public class SimpleMovieLister {

    private MovieFinder movieFinder;

    public SimpleMovieLister(MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }
}