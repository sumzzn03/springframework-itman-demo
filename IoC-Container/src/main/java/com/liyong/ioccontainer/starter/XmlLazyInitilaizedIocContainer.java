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

import com.liyong.ioccontainer.service.DependOnService;
import com.liyong.ioccontainer.service.OtherService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/***
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className 延迟加载
 *@description
 *@JunitTest: {@link  }
 *@date 12:22 AM 2020/5/7
 *
 **/
public class XmlLazyInitilaizedIocContainer {

    public static void main(String[] args) {

        String xmlResourcePath = "classpath:/META-INF/lazy-initialized-metadata.xml";

        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(xmlResourcePath);

        classPathXmlApplicationContext.refresh();


        System.out.println("=====================请求容器=====================");


        // 依赖查找并且创建 Bean
        DependOnService dependOnService = classPathXmlApplicationContext.getBean(DependOnService.class);

       // BookService bookService = classPathXmlApplicationContext.getBean(BookService.class);

        //OtherService被容器加载
        OtherService otherService = classPathXmlApplicationContext.getBean(OtherService.class);


    }
}
