package com.liyong.ioccontainer.service.validator;

import org.springframework.validation.annotation.Validated;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className JobServiceImpl
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-07-13 23:00    
 *
 *
**/
@Validated
public class JobServiceImpl implements JobService{

    @MyConstraint
    private Job job;

    @Override
    public  Job findJob(Long id) {

        return new Job();

    }

    @Override
    public boolean isValide() {
        return true;
    }

    @Override
    public Job getJob() {
        return job;
    }


}
