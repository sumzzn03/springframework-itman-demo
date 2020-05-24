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

import com.liyong.ioccontainer.service.MovieRecommender;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.support.DefaultFormattingConversionService;

import java.util.concurrent.TimeUnit;

/***
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className 通过加载xml中配置的bean元数据
 *@description
 *@JunitTest: {@link  }
 *@date 12:22 AM 2020/5/7
 *
 **/
@PropertySource("classpath:application.properties")
public class XmlValueIocContainer {

    public static void main(String[] args) throws InterruptedException {

        String xmlResourcePath = "classpath:/META-INF/value-metadata.xml";

        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类） -> Spring Bean
        applicationContext.register(XmlValueIocContainer.class);

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);

        // 加载 XML 资源，解析并且生成 BeanDefinition
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        // 启动 Spring 应用上下文
        applicationContext.refresh();

        MovieRecommender movieRecommender = applicationContext.getBean(MovieRecommender.class);

        System.out.println(movieRecommender.getCatalog());

        System.out.println(movieRecommender.getUserName());

        applicationContext.close();


    }

    /***
     *
     * 严格控制值不存在,当不存在时会报错
     *
     * @author liyong 
     * @date 1:05 PM 2020/5/24 
     * @param  
     * @exception 
     * @return org.springframework.context.support.PropertySourcesPlaceholderConfigurer 
     **/
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    /***
     *
     * 自定义类型转换器
     *
     * @author liyong
     * @date 1:04 PM 2020/5/24
     * @param
     * @exception
     * @return org.springframework.core.convert.ConversionService
     **/
    @Bean
    public ConversionService conversionService() {
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
        conversionService.addConverter(new MyCustomConverter());
        return conversionService;
    }

    /***
     *@author <a href="http://youngitman.tech">青年IT男</a>
     *@version v1.0.0
     *@className 自定义类型转换
     *@description
     *@JunitTest: {@link  }
     *@date 1:08 PM 2020/5/24
     *
    **/
    class MyCustomConverter implements Converter<String, Integer> {
        @Override
        public Integer convert(String source) {
            return Integer.valueOf(source);
        }
    }
}
