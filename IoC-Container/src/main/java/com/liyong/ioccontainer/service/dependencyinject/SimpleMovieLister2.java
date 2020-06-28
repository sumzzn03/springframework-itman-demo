package com.liyong.ioccontainer.service.dependencyinject;

import com.liyong.ioccontainer.service.annotationbase.MovieFinder;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className SimpleMovieLister
 *@description 构造参数注入
 *@JunitTest: {@link  } 
 *@date 2020-06-28 22:21    
 *
 *
**/
public class SimpleMovieLister2 {

    private MovieFinder movieFinder;

    // 通过Setter进行注入
    public void setMovieFinder(MovieFinder movieFinder)
    {
        this.movieFinder = movieFinder;
    }
}
