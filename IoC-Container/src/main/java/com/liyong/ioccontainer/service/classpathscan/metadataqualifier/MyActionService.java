package com.liyong.ioccontainer.service.classpathscan.metadataqualifier;

import com.liyong.ioccontainer.service.annotationbase.MovieCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className MyActionService
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-07-06 23:20    
 *
 *
**/
@Service
public class MyActionService {

    @Resource
    @Qualifier("Action")
    private MovieCatalog movieCatalog1;

    @Genre("Action")
    @Resource
    private MovieCatalog movieCatalog2;

    @Offline
    @Resource
    private MovieCatalog movieCatalog3;

    public void print(){

        movieCatalog1.print();
        movieCatalog2.print();
        movieCatalog3.print();

    }


}
