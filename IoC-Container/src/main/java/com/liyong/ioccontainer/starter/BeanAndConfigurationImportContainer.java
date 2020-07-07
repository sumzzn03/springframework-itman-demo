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

import com.liyong.ioccontainer.service.basejavaconfig.MyService;
import com.liyong.ioccontainer.service.basejavaconfig.SystemTestConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/***
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className Import bean导入
 *@description
 *@JunitTest: {@link  }
 *@date 12:22 AM 2020/5/7
 *
 **/
public class BeanAndConfigurationImportContainer {

    public static void main(String[] args) {

        annotationBase();

    }


    private static void annotationBase(){

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

//      3注册 Configuration Class（配置类） -> Spring Bean
        applicationContext.register(SystemTestConfig.class);


        // 启动 Spring 应用上下文
        applicationContext.refresh();


        MyService myService = applicationContext.getBean(MyService.class);

        myService.print();

    }

}
