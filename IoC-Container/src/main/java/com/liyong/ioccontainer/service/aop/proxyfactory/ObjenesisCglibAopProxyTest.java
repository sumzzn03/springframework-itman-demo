package com.liyong.ioccontainer.service.aop.proxyfactory;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.util.Arrays;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className ObjenesisCglibAopProxyTest
 * @description 代理类不需实现接口
 * 参考地址
 * <a herf="https://blog.csdn.net/f641385712/article/details/88952482"></a>
 * @date 2019-11-20 17:09
 **/
public class ObjenesisCglibAopProxyTest {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory(new Demo());
        proxyFactory.addAdvice((MethodBeforeAdvice) (method, args1, target) -> {
                    System.out.println("你被拦截了：方法名为：" + method.getName() + " 参数为--" + Arrays.asList(args1));
                }
        );

        Demo demo = (Demo) proxyFactory.getProxy();
        //你被拦截了：方法名为：hello 参数为--[]
        //this demo show
        demo.hello();
    }

    // 不要再实现接口,就会用CGLIB去代理
    static class Demo {
        public void hello() {
            System.out.println("this demo show");
        }
    }
}
