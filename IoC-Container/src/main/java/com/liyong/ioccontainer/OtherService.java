package com.liyong.ioccontainer;


/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className BookService
 * @description
 * @JunitTest: {@link  }
 * @date 2020-05-06 21:38
 **/
public class OtherService implements IOtherService {

    @Override
    public void save(String world) {
        System.out.println("The OtherService method result is  " + world);
    }
}
