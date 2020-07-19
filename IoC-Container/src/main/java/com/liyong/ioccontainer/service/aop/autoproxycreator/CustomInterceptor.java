package com.liyong.ioccontainer.service.aop.autoproxycreator;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className CustomInterceptor
 * @description
 *
 * 自定义拦截器
 * @date 2020-03-20 17:01
 * @JunitTest: {@link  }
 **/
public class CustomInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        System.out.println("方法调用前置拦截:"+invocation.getMethod().getName());
        Object result = invocation.proceed();
        System.out.println("方法调用后置拦截:"+invocation.getMethod().getName());
        return result;
    }
}
