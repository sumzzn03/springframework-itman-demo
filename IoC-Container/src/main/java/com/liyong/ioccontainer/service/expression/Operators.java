package com.liyong.ioccontainer.service.expression;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className Operators
 * @description
 * @date 2019-12-04 16:39
 **/
public class Operators {
    public static void main(String[] args) {
        relative();
        logic();
        calc();
    }

    private static void relative(){
        ExpressionParser parser = new SpelExpressionParser();
        //true
        boolean trueValue1 = parser.parseExpression("2 == 2").getValue(Boolean.class);
        //false
        boolean falseValue1 = parser.parseExpression("2 < -5.0").getValue(Boolean.class);
        //true
        boolean trueValue2 = parser.parseExpression("'black' < 'block'").getValue(Boolean.class);
        //false，字符xyz是否为int类型
        boolean falseValue2 = parser.parseExpression("'xyz' instanceof T(int)").getValue(Boolean.class);
        //true，正则是否匹配
        boolean trueValue3 =parser.parseExpression("'5.00' matches '^-?\\d+(\\.\\d{2})?$'").getValue(Boolean.class);
        //false
        boolean falseValue3=parser.parseExpression("'5.0067' matches '^-?\\d+(\\.\\d{2})?$'").getValue(Boolean.class);

        // 关系操作符
        System.out.println(parser.parseExpression("5>2").getValue());
        System.out.println(parser.parseExpression("2 between {1,9}").getValue());
        // 逻辑运算符
        System.out.println(parser.parseExpression("(5>2) and (2==1)").getValue());
        // 算术操作符
        System.out.println(parser.parseExpression("100-2^2").getValue());
    }

    private static void logic(){
        ExpressionParser parser = new SpelExpressionParser();
        //解析表达式需要的上下文，解析时有一个默认的上下文
        EvaluationContext societyContext = new StandardEvaluationContext();
        // evaluates to false
        boolean falseValue = parser.parseExpression("true and false").getValue(Boolean.class);

// evaluates to true
        String expression2 = "isMember('Nikola Tesla') and isMember('Mihajlo Pupin')";
        boolean trueValue2 = parser.parseExpression(expression2).getValue(societyContext, Boolean.class);

// -- OR --

// evaluates to true
        boolean trueValue = parser.parseExpression("true or false").getValue(Boolean.class);

// evaluates to true
        String expression3 = "isMember('Nikola Tesla') or isMember('Albert Einstein')";
        boolean trueValue3 = parser.parseExpression(expression3).getValue(societyContext, Boolean.class);

// -- NOT --

// evaluates to false
        boolean falseValue2 = parser.parseExpression("!true").getValue(Boolean.class);

// -- AND and NOT --
        String expression4 = "isMember('Nikola Tesla') and !isMember('Mihajlo Pupin')";
        boolean falseValue3 = parser.parseExpression(expression4).getValue(societyContext, Boolean.class);
    }

    private static void calc(){
        ExpressionParser parser = new SpelExpressionParser();
        // Addition
        int two = parser.parseExpression("1 + 1").getValue(Integer.class); // 2
        String testString =
                parser.parseExpression("'test' + ' ' + 'string'").getValue(String.class); // 'test string'
// Subtraction
        int four = parser.parseExpression("1 - -3").getValue(Integer.class); // 4
        double d = parser.parseExpression("1000.00 - 1e4").getValue(Double.class); // -9000
// Multiplication
        int six = parser.parseExpression("-2 * -3").getValue(Integer.class); // 6
        double twentyFour = parser.parseExpression("2.0 * 3e0 * 4").getValue(Double.class); // 24.0
// Division
        int minusTwo = parser.parseExpression("6 / -3").getValue(Integer.class); // -2
        double one = parser.parseExpression("8.0 / 4e0 / 2").getValue(Double.class); // 1.0
// Modulus
        int three = parser.parseExpression("7 % 4").getValue(Integer.class); // 3
        int one2 = parser.parseExpression("8 / 5 % 2").getValue(Integer.class); // 1
// Operator precedence
        int minusTwentyOne = parser.parseExpression("1+2-3*8").getValue(Integer.class); // -21
    }
}
