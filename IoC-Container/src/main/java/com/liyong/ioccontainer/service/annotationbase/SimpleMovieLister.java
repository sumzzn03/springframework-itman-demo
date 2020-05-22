package com.liyong.ioccontainer.service.annotationbase;

import org.springframework.beans.factory.annotation.Required;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className SimpleMovieLister
 *@description 属性方法注入限制
 *@JunitTest: {@link  } 
 *@date 2020-05-22 23:44    
 *
 *
**/
public class SimpleMovieLister {

    private MovieFinder movieFinder;

    @Required
    public void setMovieFinder(MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }
}
