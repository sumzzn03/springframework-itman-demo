package com.liyong.ioccontainer.service.expression;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import static com.liyong.ioccontainer.service.expression.Printer.print;


/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className LiteralExpr
 * @description 字符串解析
 * @date 2019-12-04 15:24
 **/
public class LiteralExpr {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        String hello_world = (String) parser.parseExpression("'hello world'").getValue();
        print(hello_world);
        double avogadrosNumber = (Double) parser.parseExpression("6.0221415E+23").getValue();
        print(avogadrosNumber);
        int maxValue = (Integer) parser.parseExpression("0x7FFFFFFF").getValue();
        print(maxValue);
        boolean trueValue = (Boolean) parser.parseExpression("true").getValue();
        print(trueValue);
        Object nullValue = parser.parseExpression("null").getValue();
        print(nullValue);
        Object value = parser.parseExpression("'hello world'.bytes.length").getValue();
        print(value);
        String value1 = parser.parseExpression("new String('hello world').toUpperCase()").getValue(String.class);
        print(value1);
    }
}
