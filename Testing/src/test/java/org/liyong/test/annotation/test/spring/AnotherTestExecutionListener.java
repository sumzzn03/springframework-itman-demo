package org.liyong.test.annotation.test.spring;

import org.springframework.test.context.TestContext;
import org.springframework.test.context.support.AbstractDirtiesContextTestExecutionListener;
import org.springframework.test.context.support.AbstractTestExecutionListener;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className AnotherTestExecutionListener
 * @description
 * @JunitTest: {@link  }
 * @date 2020-08-02 10:22
 **/
public class AnotherTestExecutionListener extends AbstractTestExecutionListener {
    @Override
    public void beforeTestMethod(TestContext testContext) throws Exception {
        super.beforeTestMethod(testContext);
        System.out.println("方法执行前");
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
