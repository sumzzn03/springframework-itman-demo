package com.liyong.ioccontainer.starter;

import com.liyong.ioccontainer.service.aop.targetsource.AutoConfig;
import org.springframework.aop.target.CommonsPool2TargetSource;
import org.springframework.aop.target.PrototypeTargetSource;
import org.springframework.aop.target.ThreadLocalTargetSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className IoCContainer
 * @description 通过RegexpMethodPointCutAdvisorIocContainer启动容器
 * @JunitTest: {@link  }
 * @date 2020-05-06 21:28
 **/
public class TargetSourceIocContainer {

    public static void main(String[] args) throws Exception {

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

        //注册bean到容器中
        annotationConfigApplicationContext.register(AutoConfig.class );

        //启动容器
        annotationConfigApplicationContext.refresh();

        ThreadLocalTargetSource threadLocalTargetSource = annotationConfigApplicationContext.getBean(ThreadLocalTargetSource.class);

        for (int i = 0; i < 10; i++) {

            final int _i = i;
            new Thread(() -> {

                AutoConfig.MyService  target = (AutoConfig.MyService ) threadLocalTargetSource.getTarget();

                target.say("x" + _i);

            }).start();

        }

        PrototypeTargetSource prototypeTargetSource = annotationConfigApplicationContext.getBean(PrototypeTargetSource.class);

        for (int i = 0; i < 10; i++) {

            AutoConfig.MyService  myService2 = (AutoConfig.MyService ) prototypeTargetSource.getTarget();

            System.out.println("myService2 = " + myService2.hashCode());

        }

        CommonsPool2TargetSource commonsPool2TargetSource = annotationConfigApplicationContext.getBean(CommonsPool2TargetSource.class);



        for (int i = 0; i < 10; i++) {

            AutoConfig.MyService  myService3 = (AutoConfig.MyService ) commonsPool2TargetSource.getTarget();

            System.out.println("myService3 = " + myService3.hashCode());

            //释放对象
            //commonsPool2TargetSource.releaseTarget(myService3);
        }

        // 显示地关闭 Spring 应用上下文
        annotationConfigApplicationContext.close();

    }

}
