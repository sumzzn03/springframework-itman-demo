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

import com.liyong.ioccontainer.service.OtherService;
import com.liyong.ioccontainer.service.definationwithincomponet.FactoryMethodComponent;
import com.liyong.ioccontainer.service.definationwithincomponet.TestBean;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.support.DefaultFormattingConversionService;

/***
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className 在组件中定义元数据
 *@description
 *@JunitTest: {@link  }
 *@date 12:22 AM 2020/5/7
 *
 **/
@Configuration
public class XmlBeanDefinationWithinComponetIocContainer {

    public static void main(String[] args) throws InterruptedException {

        String xmlResourcePath = "classpath:/META-INF/beandefination-within-component-metadata.xml";

        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类） -> Spring Bean
        applicationContext.register(XmlBeanDefinationWithinComponetIocContainer.class);

        applicationContext.scan("com.liyong.ioccontainer.service.definationwithincomponet");
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);

        // 加载 XML 资源，解析并且生成 BeanDefinition
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        // 启动 Spring 应用上下文
        applicationContext.refresh();

        FactoryMethodComponent bean = applicationContext.getBean(FactoryMethodComponent.class);

        System.out.println(bean);

        TestBean protectedInstance = applicationContext.getBean("protectedInstance", TestBean.class);
        TestBean privateInstance = applicationContext.getBean("privateInstance", TestBean.class);
        TestBean requestScopedInstance = applicationContext.getBean("requestScopedInstance", TestBean.class);
        OtherService prototypeInstance = applicationContext.getBean("prototypeInstance", OtherService.class);

        System.out.println(protectedInstance);
        System.out.println(privateInstance);
        System.out.println(requestScopedInstance);
        System.out.println(prototypeInstance);

        applicationContext.close();

    }

}
