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

import com.liyong.ioccontainer.service.CollectionsService;
import com.liyong.ioccontainer.service.InnerService;
import com.liyong.ioccontainer.service.OuterService;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/***
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className 通过加载xml中配置的bean元数据集合注入
 *@description
 *@JunitTest: {@link  }
 *@date 12:22 AM 2020/5/7
 *
**/
public class XmlCollectionsIocContainer {

    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);

        String xmlResourcePath = "classpath:/META-INF/collections-metadata.xml";

        // 加载 XML 资源，解析并且生成 BeanDefinition
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        // 依赖查找并且创建 Bean
        CollectionsService collectionsService = beanFactory.getBean(CollectionsService.class);

        Set<String> datas = collectionsService.getDatas();

        Map<String, String> maps = collectionsService.getMaps();

        List<String> names = collectionsService.getNames();

        Properties properties = collectionsService.getProperties();

        System.out.println(datas);

        System.out.println(maps);

        System.out.println(names);

        System.out.println(properties);

    }
}
