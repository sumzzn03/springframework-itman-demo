package com.liyong.ioccontainer.service.classpathscan.metadataqualifier;

import com.liyong.ioccontainer.service.annotationbase.MovieCatalog;
import org.springframework.stereotype.Component;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className CachingMovieCatalog
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-07-06 23:18    
 *
 *
**/
@Component
@Offline//自定义限定符
public class CachingMovieCatalog implements MovieCatalog {
    @Override
    public void print() {
        System.out.println("cachingMovieCatalog2:"+this);
    }
}
