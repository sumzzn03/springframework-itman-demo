package org.liyong.test.annotation.test.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

import static org.junit.Assert.assertEquals;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className TransactionUserRepositoryTests
 *@description 测试插入数据事物，测试完成后回滚数据,使用hsqldb
 *@JunitTest: {@link  } 
 *@date 2020-08-06 16:27    
 *
 *
**/
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TransactionUserRepositoryTests.Config.class)
//@Transactional
public class TransactionUserRepositoryTests {


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource1) {
        this.jdbcTemplate = new JdbcTemplate(dataSource1);
    }


    @Test
    @Transactional
    public void transactionalTest() {

        TransactionTestUtils.assertInTransaction(true);


        ClassPathResource resource = new ClassPathResource("/META-INF/jdbc/data.sql");

        //插入数据
        new ResourceDatabasePopulator(resource).execute(jdbcTemplate.getDataSource());

        assertNumUsers(1);

    }

    /**
     *
     * 统计数据行数
     *
     * @author liyong
     * @date 6:19 PM 2020/8/6
     * @param tableName
     * @exception
     * @return int
     **/
    private int countRowsInTable(String tableName) {
        return JdbcTestUtils.countRowsInTable(this.jdbcTemplate, tableName);
    }

    private void assertNumUsers(int expected) {
        assertEquals("Number of rows in the [user] table.", expected, countRowsInTable("user"));
    }

    @Configuration
    @EnableTransactionManagement
    static class Config {

        /**
         *
         * 事物管理
         *
         * @author liyong
         * @date 6:18 PM 2020/8/6
         * @param
         * @exception
         * @return PlatformTransactionManager
         **/
        @Primary
        @Bean
        public PlatformTransactionManager primaryTransactionManager() {
            return new DataSourceTransactionManager(dataSource1());
        }

        @Bean
        public PlatformTransactionManager additionalTransactionManager() {
            return new DataSourceTransactionManager(dataSource2());
        }

        /**
         *
         * 数据源
         *
         * @author liyong
         * @date 6:19 PM 2020/8/6
         * @param
         * @exception
         * @return javax.sql.DataSource
         **/
        @Bean
        public DataSource dataSource1() {
            //动态创建数据库
            return new EmbeddedDatabaseBuilder()
                    .generateUniqueName(true)
                    .addScript("classpath:/META-INF/jdbc/schema.sql")
                    .build();
        }

        @Bean
        public DataSource dataSource2() {
            return new EmbeddedDatabaseBuilder().generateUniqueName(true).build();
        }
    }

}
