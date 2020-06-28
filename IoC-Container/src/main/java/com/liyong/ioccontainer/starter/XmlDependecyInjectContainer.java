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

import com.liyong.ioccontainer.service.dependencyinject.*;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/***
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className 依赖注入
 *@description
 *@JunitTest: {@link  }
 *@date 12:22 AM 2020/5/7
 *
**/
public class XmlDependecyInjectContainer {

    public static void main(String[] args){

        String xmlResourcePath = "classpath:/META-INF/dependecy-inject-metadata.xml";

        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类） -> Spring Bean
        applicationContext.register(XmlDependecyInjectContainer.class);

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);

        // 加载 XML 资源，解析并且生成 BeanDefinition
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        // 启动 Spring 应用上下文
        applicationContext.refresh();

        //构造函数注入
        SimpleMovieLister simpleMovieLister = applicationContext.getBean("simpleMovieLister", SimpleMovieLister.class);

        //构造函数参数解析
        ThingOne thingOne = applicationContext.getBean(ThingOne.class);
        ExampleBean exampleBeanByName = applicationContext.getBean("exampleBeanByName",ExampleBean.class);
        ExampleBean exampleBeanByType = applicationContext.getBean("exampleBeanByType",ExampleBean.class);
        ExampleBean exampleBeanByIndex = applicationContext.getBean("exampleBeanByIndex",ExampleBean.class);

        //属性注入
        SimpleMovieLister2 simpleMovieLister2 = applicationContext.getBean("simpleMovieLister2", SimpleMovieLister2.class);

        //静态工厂方法
        ExampleBean2 exampleBean2 = applicationContext.getBean("exampleBean2", ExampleBean2.class);


        //构造函数参数类型匹配
        System.out.println(simpleMovieLister);
        System.out.println(thingOne);
        System.out.println(exampleBeanByName);
        System.out.println(exampleBeanByType);
        System.out.println(exampleBeanByIndex);
        System.out.println(simpleMovieLister2);
        System.out.println(exampleBean2);

        applicationContext.close();

    }
}
