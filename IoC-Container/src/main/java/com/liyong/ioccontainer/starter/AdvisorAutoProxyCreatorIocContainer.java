package com.liyong.ioccontainer.starter;

import com.liyong.ioccontainer.service.aop.autoproxycreator.MyConfigration;
import com.liyong.ioccontainer.service.aop.autoproxycreator.MyService;
import com.liyong.ioccontainer.service.aop.proxyfactorybean.Person;
import com.liyong.ioccontainer.service.aop.regexpmethodpointcutadvisor.TestService;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className IoCContainer
 * @description 通过AdvisorAutoProxyCreatorIocContainer启动容器
 * @JunitTest: {@link  }
 * @date 2020-05-06 21:28
 **/
public class AdvisorAutoProxyCreatorIocContainer {

    public static void main(String[] args) throws Exception {


        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

        //注册bean到容器中
        annotationConfigApplicationContext.register(MyConfigration.class);

        //启动容器
        annotationConfigApplicationContext.refresh();

        MyService service = (MyService) annotationConfigApplicationContext.getBean("myService");

        service.setName("ouwen");

        System.out.println(service.getName());

        // 显示地关闭 Spring 应用上下文
        annotationConfigApplicationContext.close();



    }

}


