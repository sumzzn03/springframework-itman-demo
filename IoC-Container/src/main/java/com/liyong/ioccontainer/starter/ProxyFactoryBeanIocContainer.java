package com.liyong.ioccontainer.starter;

import com.liyong.ioccontainer.service.aop.proxyfactorybean.Person;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className IoCContainer
 * @description 通过ProxyFactoryBeanIocContainer启动容器
 * @JunitTest: {@link  }
 * @date 2020-05-06 21:28
 **/
public class ProxyFactoryBeanIocContainer {

    public static void main(String[] args) throws Exception {

        String pointcutExpression = "execution( int com.liyong.ioccontainer.service.aop.proxyfactorybean.Person.run() )";

        // =============================================================
        //因为我们要使用AspectJ,所以此处采用AspectJProxyFactory，当然你也可以使用和容器相关的ProxyFactoryBean
        ProxyFactoryBean factory = new ProxyFactoryBean();
        factory.setTarget(new Person());

        //AspectJProxyFactory factory = new AspectJProxyFactory(new Person());

        //声明一个aspectj切点,一张切面
        AspectJExpressionPointcut cut = new AspectJExpressionPointcut();
        cut.setExpression(pointcutExpression); // 设置切点表达式

        // 声明一个通知（此处使用环绕通知 MethodInterceptor ）
        Advice advice = (MethodInterceptor) invocation -> {
            System.out.println("============>放行前拦截...");
            Object obj = invocation.proceed();
            System.out.println("============>放行后拦截...");
            return obj;
        };

        //切面=切点+通知
        // 它还有个构造函数：DefaultPointcutAdvisor(Advice advice); 用的切面就是Pointcut.TRUE，所以如果你要指定切面，请使用自己指定的构造函数
        // Pointcut.TRUE：表示啥都返回true，也就是说这个切面作用于所有的方法上/所有的方法
        // addAdvice();方法最终内部都是被包装成一个 `DefaultPointcutAdvisor`，且使用的是Pointcut.TRUE切面，因此需要注意这些区别
        Advisor advisor = new DefaultPointcutAdvisor(cut, advice);
        factory.addAdvisor(advisor);
        //Person p = factory.getProxy();
        Person p = (Person) factory.getObject();

        // 执行方法
        p.run();
        p.run(10);
        p.say();
        p.sayHi("Jack");
        p.say("Tom", 666);

    }

}


