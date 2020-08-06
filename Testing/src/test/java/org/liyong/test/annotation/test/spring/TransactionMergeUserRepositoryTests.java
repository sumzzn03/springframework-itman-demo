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
 *@description 测试插入数据事物，测试完成后回滚数据，使用mysql
 *@JunitTest: {@link  } 
 *@date 2020-08-06 16:27    
 *
 *
**/
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:/META-INF/datasource-metadata.xml"})
//@Transactional
public class TransactionMergeUserRepositoryTests {


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Test
    @Transactional
    public void transactionalTest() {

        TransactionTestUtils.assertInTransaction(true);

        //插入数据
        jdbcTemplate.execute("INSERT INTO user VALUES('Dilbert');");

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

}
