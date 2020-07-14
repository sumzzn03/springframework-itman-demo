package com.liyong.ioccontainer.service.expression;

import com.liyong.ioccontainer.service.expression.vo.Simple;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className SimpleEvaluationTest
 * @description
 * @JunitTest: {@link  }
 * @date 2020-04-06 11:57
 **/
public class SimpleEvaluationTest {
    public static void main(String[] args) {
        Simple simple = new Simple();
        simple.booleanList.add(true);

        SpelExpressionParser parser = new SpelExpressionParser();

        EvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();

// "false" is passed in here as a String. SpEL and the conversion service
// will recognize that it needs to be a Boolean and convert it accordingly.
        parser.parseExpression("booleanList[0]").setValue(context, simple, "false");

// b is false
        Boolean b = simple.booleanList.get(0);
        System.out.println(b);


    }
}
