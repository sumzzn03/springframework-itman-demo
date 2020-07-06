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

import com.liyong.ioccontainer.service.classpathscan.NameGeneratorAppConfig;
import com.liyong.ioccontainer.service.classpathscan.namegenerator.SimpleMovieLister;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/***
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className XmlAliasIocContainer
 *@description
 *@JunitTest: {@link  }
 *@date 12:22 AM 2020/5/7
 *
**/
public class AutoCheckAndRegisterBeanDefinitionIocContainer {

    public static void main(String[] args) {

        //基于xml
        xmlBase();

        //基于注解
        annotaionBase();

    }

    private static void xmlBase(){

        String xmlResourcePath = "classpath:/META-INF/autocheck-register-beandefinition-metadata.xml";

        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类） -> Spring Bean
        applicationContext.register(AutoCheckAndRegisterBeanDefinitionIocContainer.class);

        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);

        // 加载 XML 资源，解析并且生成 BeanDefinition
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        applicationContext.refresh();

        SimpleMovieLister simpleMovieLister = applicationContext.getBean(SimpleMovieLister.class);

        System.out.println(simpleMovieLister);
    }

    private static void annotaionBase(){

        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类） -> Spring Bean
        applicationContext.register(NameGeneratorAppConfig.class);

        applicationContext.refresh();

        SimpleMovieLister simpleMovieLister = applicationContext.getBean(SimpleMovieLister.class);

        System.out.println(simpleMovieLister);
    }

}
