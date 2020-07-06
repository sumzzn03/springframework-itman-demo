package com.liyong.ioccontainer.service.classpathscan.metadataqualifier;

import com.liyong.ioccontainer.service.annotationbase.MovieCatalog;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className ActionMovieCatalog
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-07-06 23:17    
 *
 *
**/
@Component
@Qualifier("Action")
public class ActionMovieCatalog1 implements MovieCatalog {
    @Override
    public void print() {
        System.out.println("actionMovieCatalog1:"+this);
    }
}
