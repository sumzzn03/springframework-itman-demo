package com.liyong.ioccontainer.service.annotationbase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className SimpleMovieLister
 *@description 属性注入，非必须 实例bean不存在不报错
 *@JunitTest: {@link  } 
 *@date 2020-05-22 23:44    
 *
 *
**/
@Component
public class SimpleMovieLister3 {

    private MovieFinder movieFinder;

    @Autowired(required = false)
    public void setMovieFinder(MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }
}
