package com.liyong.ioccontainer.service.validator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.groups.Default;
import java.util.Iterator;
import java.util.Set;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className ConstraintTest
 * @description
 * @JunitTest: {@link  }
 * @date 2020-07-13 23:43
 * @see ConstraintController
 **/
public class ConstraintTest {

    public static void main(String[] args) {

        Job job = new Job();
//        job.setName("ouwen");

        Set<ConstraintViolation<Job>> constraintViolations =
                Validation.buildDefaultValidatorFactory().getValidator().validate(job, Default.class);


        if (!constraintViolations.isEmpty()) {

            Iterator<ConstraintViolation<Job>> it = constraintViolations.iterator();

            StringBuilder sb = new StringBuilder();

            String msg;

            while (it.hasNext()) {

                sb.append(it.next().getMessage());

                sb.append(",");

            }
            msg = sb.substring(0, sb.lastIndexOf(","));

            System.err.println(msg);


        }

    }

}
