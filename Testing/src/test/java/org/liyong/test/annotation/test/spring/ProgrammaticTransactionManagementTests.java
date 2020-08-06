package org.liyong.test.annotation.test.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.transaction.TestTransaction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className ProgrammaticTransactionManagementTests
 *@description 编程式手动提交事物
 *@JunitTest: {@link  } 
 *@date 2020-08-06 19:06    
 *
 *
**/
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:/META-INF/datasource-metadata.xml"})
public class ProgrammaticTransactionManagementTests extends AbstractTransactionalJUnit4SpringContextTests {

    @Test
    public void transactionalTest() {
        //断言数据库中数据总数
        assertNumUsers(1);

        //删除数据
        deleteFromTables("user");

        //手动提交事物
        TestTransaction.flagForCommit();
        TestTransaction.end();
        assertFalse(TestTransaction.isActive());
        assertNumUsers(0);

        TestTransaction.start();

    }

    protected void assertNumUsers(int expected) {
        assertEquals("Number of rows in the [user] table.", expected, countRowsInTable("user"));
    }

}
