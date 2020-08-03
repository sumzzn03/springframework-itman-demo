package org.liyong.test.annotation.test.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.liyong.test.annotation.test.spring.annotation.test.spring.AppConfig;
import org.springframework.test.annotation.IfProfileValue;
import org.springframework.test.annotation.ProfileValueSource;
import org.springframework.test.annotation.ProfileValueSourceConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className testProcessWhichRunsOnlyOnOracleJvm
 *@description 根据条件启动测试用例
 *@JunitTest: {@link  } 
 *@date 2020-08-03 22:13    
 *
 *
**/

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@ProfileValueSourceConfiguration(ProfileValueTest.HardCodedProfileValueSource.class)
public class ProfileValueTest {

    static String NAME = "env";

    @IfProfileValue(name="env",value = "integration")
    @Test
    public void testProcessWhichRunsOnlyOnOracleJvm() {

        System.out.println(System.getProperty("java.vendor"));

    }

    @IfProfileValue(name="java.vendor", value="Oracle Corporation")
    @Test
    public void testProcessWhichRunsOnlyOnOracleJvm1() {


        System.out.println(System.getProperty("java.vendor"));

    }


    /**
     *@author <a href="http://youngitman.tech">青年IT男</a>
     *@version v1.0.0
     *@className 判断输入name返回value 用于IfProfileValue的name和value进行匹配
     *@description
     *@JunitTest: {@link  }
     *@date 10:40 PM 2020/8/3
     *
    **/
    public static class HardCodedProfileValueSource implements ProfileValueSource {

        @Override
        public String get(final String key) {
            return (key.equals(NAME) ? "integration" : null);
        }
    }

}
