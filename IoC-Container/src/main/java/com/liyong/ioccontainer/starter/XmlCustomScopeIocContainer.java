/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.liyong.ioccontainer.starter;

import com.liyong.ioccontainer.entity.User;
import com.liyong.ioccontainer.inner.ThreadLocalScope;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.SimpleThreadScope;

import java.io.IOException;

/***
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className 自定义作用域
 *@description
 *@JunitTest: {@link  }
 *@date 12:22 AM 2020/5/7
 *
 **/
public class XmlCustomScopeIocContainer {


    @Scope(ThreadLocalScope.SCOPE_NAME)
    @Bean
    public User user() {
        User user = new User();

        user.setId(1L);
        user.setAge(18);
        user.setName("ouwen");

        return user;
    }

    public static void main(String[] args) throws IOException {

        String xmlResourcePath = "classpath:/META-INF/custom-scope-metadata.xml";

        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类） -> Spring Bean
        applicationContext.register(XmlCustomScopeIocContainer.class);

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);

        // 加载 XML 资源，解析并且生成 BeanDefinition
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);


        //编程式注入
//        org.springframework.beans.factory.config.Scope threadScope = new ThreadLocalScope();
//        applicationContext.getBeanFactory().registerScope("thread", threadScope);

        // 启动 Spring 应用上下文
        applicationContext.refresh();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                User user = applicationContext.getBean(User.class);
                System.out.println(user.hashCode());
            }).start();
        }

        System.in.read();

    }
}
