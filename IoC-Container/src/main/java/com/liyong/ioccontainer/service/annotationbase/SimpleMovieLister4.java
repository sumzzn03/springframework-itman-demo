package com.liyong.ioccontainer.service.annotationbase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className SimpleMovieLister
 *@description 属性注入，参数可为空和@Autowired(required = false)类似
 *@JunitTest: {@link  } 
 *@date 2020-05-22 23:44    
 *
 *
**/
@Component
public class SimpleMovieLister4 {

    private MovieFinder movieFinder;

    @Autowired
    public void setMovieFinder(@Nullable MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }
}
