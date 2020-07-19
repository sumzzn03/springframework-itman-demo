package com.liyong.ioccontainer.service.aop.autoproxycreator;

import org.springframework.aop.Advisor;
import org.springframework.aop.TargetSource;
import org.springframework.aop.framework.AdvisedSupport;
import org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeansException;
import org.springframework.core.annotation.AnnotationUtils;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className CustomAutoProxyCreator
 * @description 自定义类的代理对象创建
 * @date 2020-03-20 16:59
 * @JunitTest: {@link  }
 **/
public class CustomAutoProxyCreator extends AbstractAutoProxyCreator {

    private CustomInterceptor interceptor = new CustomInterceptor();

    @Override
    protected Object[] getAdvicesAndAdvisorsForBean(Class<?> beanClass, String beanName, TargetSource customTargetSource) throws BeansException {
        return new Object[]{interceptor};
    }

    @Override
    protected Object wrapIfNecessary(Object bean, String beanName, Object cacheKey) {

        CustomAnotation annotation = AnnotationUtils.findAnnotation(bean.getClass(), CustomAnotation.class);
        if (annotation == null) {
            return bean;
        }

        if (!AopUtils.isAopProxy(bean)) {
            //bean没有被代理直接包装成代理
            bean = super.wrapIfNecessary(bean, beanName, cacheKey);
        } else {
            //bean已经被代理了增加Advisor包装Interceptor
            AdvisedSupport advised = null;
            try {
                advised = SpringProxyUtils.getAdvisedSupport(bean);
                Advisor[] advisor = buildAdvisors(beanName, getAdvicesAndAdvisorsForBean(null, null, null));
                for (Advisor avr : advisor) {
                    advised.addAdvisor(0, avr);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return bean;
    }
}