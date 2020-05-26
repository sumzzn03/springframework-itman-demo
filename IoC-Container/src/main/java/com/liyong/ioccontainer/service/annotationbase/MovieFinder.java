package com.liyong.ioccontainer.service.annotationbase;

import org.springframework.stereotype.Component;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className MovieFinder
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-05-22 23:44    
 *
 *
**/
@Component
public class MovieFinder {
    public void findMovies(String name){
        System.out.println(name);
    }
}
