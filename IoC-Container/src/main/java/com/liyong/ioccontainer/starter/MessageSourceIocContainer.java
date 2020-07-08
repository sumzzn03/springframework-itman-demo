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

import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

/***
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className 资源国际化
 *@description
 *@JunitTest: {@link  }
 *@date 12:22 AM 2020/5/7
 *
**/
public class MessageSourceIocContainer {

    public static void main(String[] args) {

        messageSource1();

        messageSource2();

    }

    private static void messageSource2(){

        String xmlResourcePath = "classpath:/META-INF/message-source-metadata1.xml";

        MessageSource resources = new ClassPathXmlApplicationContext(xmlResourcePath);
        String message = resources.getMessage("argument.required",
                new Object [] {"userDao"}, "Required", Locale.UK);
        System.out.println(message);
    }

    private static void messageSource1(){

        String xmlResourcePath = "classpath:/META-INF/message-source-metadata2.xml";

        MessageSource resources = new ClassPathXmlApplicationContext(xmlResourcePath);
        String message = resources.getMessage("message", null, "Default", Locale.ENGLISH);
        System.out.println(message);

    }

}
