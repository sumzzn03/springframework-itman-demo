package com.liyong.ioccontainer.service.expression;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className BeanRef
 * @description
 * @JunitTest: {@link  }
 * @date 2020-07-14 22:45
 **/
public class BeanRef {

    public static void main(String[] args) {

        testRef1();

        testRef2();

    }

    private static void testRef2(){
        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setBeanResolver(new PropertiesArraysAndSoOn.MyBeanResolver());

        //触发MyBeanResolver的resolve(context,"&foo")调用
        Object bean = parser.parseExpression("&foo").getValue(context);

        System.out.println(bean);
    }

    private static void testRef1() {
        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setBeanResolver(new PropertiesArraysAndSoOn.MyBeanResolver());

        //触发MyBeanResolver的resolve(context,"something")调用
        Object bean = parser.parseExpression("@something").getValue(context);

        System.out.println(bean);
    }
}
