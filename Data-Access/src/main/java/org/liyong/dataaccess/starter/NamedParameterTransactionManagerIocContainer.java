package org.liyong.dataaccess.starter;

import org.liyong.dataaccess.dao.CorporateEventDao;
import org.liyong.dataaccess.entity.Foo;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className JdbcTemplateBestTransactionManagerIocContainer
 * @description
 * @JunitTest: {@link  }
 * @date 2020-08-31 23:12
 **/
public class NamedParameterTransactionManagerIocContainer {


    public static void main(String[] args) {

        String xmlResourcePath = "classpath:/META-INF/namedparameter-jdbctemplate-transaction-manager-metadata.xml";

        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类） -> Spring Bean
        applicationContext.register(NamedParameterTransactionManagerIocContainer.class);

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);

        // 加载 XML 资源，解析并且生成 BeanDefinition
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        // 启动 Spring 应用上下文
        applicationContext.refresh();


        CorporateEventDao corporateEventDao = (CorporateEventDao) applicationContext.getBean("jdbcCorporateEventDao");

        try {
            //数据插入
            corporateEventDao.insertFoo(new Foo("ouwen", "liyong", 30));
        } catch (Exception e) {
        }

        applicationContext.close();

    }

}
