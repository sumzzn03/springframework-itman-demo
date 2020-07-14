package com.liyong.ioccontainer.service.expression;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.List;

/**
 *@className SpelParserConfigurationTest
 *@description 
 *@version v1.0.0
 *@JunitTest: {@link  } 
 *@date 2020-04-06 12:07    
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *
**/
public class SpelParserConfigurationTest {

    public static void main(String[] args) {

        //1.元素为空自动生成对象 2.元素个数超过集合或数组长度时，自动扩展集合
        SpelParserConfiguration config = new SpelParserConfiguration(true,true);

        ExpressionParser parser = new SpelExpressionParser(config);

        Expression expression = parser.parseExpression("list[3]");

        Demo demo = new Demo();

        Object o = expression.getValue(demo);

    }

    static class Demo {
        public List<String> list;
    }
}
