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
package org.liyong.dataaccess.starter;

import org.liyong.dataaccess.entity.Foo;
import org.liyong.dataaccess.service.ServiceOperation;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/***
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className 自定义组合注解
 *@description
 *@JunitTest: {@link  }
 *@date 12:22 AM 2020/5/7
 *
 **/
public class CustomAnnotationTransactionManagerIocContainer {

    public static void main(String[] args) {

        String xmlResourcePath = "classpath:/META-INF/custom-annotation-transaction-manager-metadata.xml";

        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类） -> Spring Bean
        applicationContext.register(CustomAnnotationTransactionManagerIocContainer.class);

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);

        // 加载 XML 资源，解析并且生成 BeanDefinition
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        // 启动 Spring 应用上下文
        applicationContext.refresh();


        ServiceOperation defaultServiceOperation = (ServiceOperation) applicationContext.getBean("customAnnotationServiceOperation");

        try {
            //数据不会插入
            defaultServiceOperation.insertFoo (new Foo("ouwen","liyong",30));
        }catch (Exception e){}

        try {
            //数据会插入
            defaultServiceOperation.insertFoo2 (new Foo("ouwen","liyong",40));
        }catch (Exception e){}

        applicationContext.close();

    }
}
