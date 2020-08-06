package org.liyong.test.annotation.test.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
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
 *@description 注解式提交事物
 *@JunitTest: {@link  } 
 *@date 2020-08-06 19:06    
 *
 *
**/
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:/META-INF/datasource-metadata.xml"})
public class AnnotationTransactionManagementTests extends AbstractTransactionalJUnit4SpringContextTests {

    @Commit
    @Test
    public void transactionalTestForCommit() {
        //断言数据库中数据总数
        assertNumUsers(1);

        //删除数据
        deleteFromTables("user");

        assertNumUsers(0);

    }


    @Rollback
    @Test
    public void transactionalTestForRollback() {
        //断言数据库中数据总数
        assertNumUsers(1);

        //删除数据
        deleteFromTables("user");

        assertNumUsers(0);

    }


    protected void assertNumUsers(int expected) {
        assertEquals("Number of rows in the [user] table.", expected, countRowsInTable("user"));
    }

}
