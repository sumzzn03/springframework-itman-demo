package com.liyong.ioccontainer.service.schema;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className MyServiceImpl
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-07-20 08:53    
 *
 *
**/
public class MyServiceImpl implements MyService{

    private SimpleDateFormat format = new SimpleDateFormat();


    @Override
    public void print() {
        System.out.print(format.format(new Date()));
    }

    public SimpleDateFormat getFormat() {
        return format;
    }

    public void setFormat(SimpleDateFormat format) {
        this.format = format;
    }
}
