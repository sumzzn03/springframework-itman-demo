package com.liyong.ioccontainer.service.basejavaconfig;

import org.springframework.context.annotation.*;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className AppConfig
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-07-05 21:51    
 *
 *
**/
@Configuration
@ComponentScan(basePackages = "com.liyong.ioccontainer.service.basejavaconfig")
public class AppConfig {

    @Bean(initMethod ="init")
    //生成基于jdk的代理
    @Scope(value = "prototype",proxyMode = ScopedProxyMode.INTERFACES)
    public MyService myService() {
        return new MyServiceImpl();
    }


    @Bean(destroyMethod = "destory")
    public MyService myService2() {
        return new MyServiceImpl(accountRepository());
    }

    //myService33会覆盖myService3的bean名称
    @Bean(name = "myService33")
    public MyService myService3(AccountRepository repository) {
        return new MyServiceImpl(repository);
    }

    @Description("定义别名")
    @Bean({"accountRepository1","accountRepository2"})
    public AccountRepository accountRepository(){
        return new AccountRepositoryImpl();
    }
}
