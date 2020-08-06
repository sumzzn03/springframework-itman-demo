package org.liyong.test.annotation.test.spring;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;

import static org.junit.Assert.assertEquals;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className FictitiousTransactionalTest
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-08-06 19:25    
 *
 *
**/
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:/META-INF/datasource-metadata.xml"})
@Commit
public class FictitiousTransactionalTest extends AbstractTransactionalJUnit4SpringContextTests {

    @BeforeTransaction
    void verifyInitialDatabaseState() {
        // 执行事物之前回调
        System.out.println("verifyInitialDatabaseState");
    }

    @BeforeEach
    void setUpTestDataWithinTransaction() {
        // 在事物中设置测试数据
        System.out.println("setUpTestDataWithinTransaction");
    }

    @Test
    // overrides the class-level @Commit setting
    @Rollback
    public void modifyDatabaseWithinTransaction() {

        System.out.println("modifyDatabaseWithinTransaction");

        //执行逻辑

        assertNumUsers(1);

        //删除数据
        deleteFromTables("user");

        assertNumUsers(0);

    }

    protected void assertNumUsers(int expected) {
        assertEquals("Number of rows in the [user] table.", expected, countRowsInTable("user"));
    }

    @AfterEach
    void tearDownWithinTransaction() {

        System.out.println("tearDownWithinTransaction");

    }

    @AfterTransaction
    void verifyFinalDatabaseState() {

        // 回滚事物之前回调
        System.out.println("verifyFinalDatabaseState");

    }

}
