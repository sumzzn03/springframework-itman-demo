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

import com.liyong.ioccontainer.entity.Book;
import com.liyong.ioccontainer.service.CustomFactorBean;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/***
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className 通过加载xml中配置的bean元数据
 *@description
 *@JunitTest: {@link  }
 *@date 12:22 AM 2020/5/7
 *
**/
public class CustomFactoryIocContainer {

    public static void main(String[] args) {

        String xmlResourcePath = "classpath:/META-INF/custom-factorybean-metadata.xml";

        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类） -> Spring Bean
        applicationContext.register(CustomFactoryIocContainer.class);

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);

        // 加载 XML 资源，解析并且生成 BeanDefinition
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        // 启动 Spring 应用上下文
        applicationContext.refresh();

        //获取CustomFactorBean对象本身
        CustomFactorBean customFactorBean = applicationContext.getBean(CustomFactorBean.class);

        System.out.println(customFactorBean);

        //获取CustomFactorBean产生的 Book对象
        Book book1 = (Book) applicationContext.getBean("customFactorBean");

        Book book2 = (Book) applicationContext.getBean("customFactorBean");

        System.out.println(book1.hashCode() == book2.hashCode());

        //获取CustomFactorBean对象本身
        Object bean = applicationContext.getBean("&customFactorBean");

        System.out.println(bean);

        applicationContext.close();

    }
}
