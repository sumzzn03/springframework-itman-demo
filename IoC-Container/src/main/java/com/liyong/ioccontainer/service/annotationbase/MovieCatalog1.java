package com.liyong.ioccontainer.service.annotationbase;

import org.springframework.stereotype.Component;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className MovieCatalog1
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-05-22 23:52    
 *
 *
**/
@Component
public class MovieCatalog1 implements MovieCatalog{
    @Override
    public void print() {
        System.out.println("MovieCatalog1");
    }
}
