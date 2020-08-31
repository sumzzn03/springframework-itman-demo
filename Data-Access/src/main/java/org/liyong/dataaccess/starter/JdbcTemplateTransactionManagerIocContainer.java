package org.liyong.dataaccess.starter;

import org.liyong.dataaccess.entity.Foo;
import org.liyong.dataaccess.service.JdbcTemplateService;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className JdbcTemplateTransactionManagerIocContainer
 * @description
 * @JunitTest: {@link  }
 * @date 2020-08-31 23:12
 **/
public class JdbcTemplateTransactionManagerIocContainer {


    public static void main(String[] args) {

        String xmlResourcePath = "classpath:/META-INF/jdbctemplate-transaction-manager-metadata.xml";

        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类） -> Spring Bean
        applicationContext.register(JdbcTemplateTransactionManagerIocContainer.class);

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);

        // 加载 XML 资源，解析并且生成 BeanDefinition
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        // 启动 Spring 应用上下文
        applicationContext.refresh();


        JdbcTemplateService jdbcTemplateService = (JdbcTemplateService) applicationContext.getBean("jdbcTemplateService");

        try {
            //数据插入
            jdbcTemplateService.insert(new Foo("ouwen", "liyong", 30));
        } catch (Exception e) {
        }

        try {
            //数据更新
            jdbcTemplateService.update(new Foo("ouwen", "liyong", 40));
        } catch (Exception e) {
        }

        try {
            Foo foo = jdbcTemplateService.findById(1);
            System.out.print("查询单条数据：" + foo);
        } catch (Exception e) {
        }

        try {
            List<Foo> foos = jdbcTemplateService.findAllActors();
            System.out.println("所有数据：" + foos);
        } catch (Exception e) {
        }

        try {
            int count = jdbcTemplateService.findCount("ouwen");
            System.out.println("通过名字查询数据条数：" + count);
        } catch (Exception e) {
        }

        try {
            String name = jdbcTemplateService.findNameById(1);
            System.out.println("通过名字查询数据名称：" + name);
        } catch (Exception e) {
        }

        try {
            //删除数据
            jdbcTemplateService.delete(1);
        } catch (Exception e) {
        }

        applicationContext.close();

    }

}
