package com.liyong.ioccontainer.service.expression;

import com.liyong.ioccontainer.service.expression.vo.Person;
import org.springframework.context.expression.BeanExpressionContextAccessor;
import org.springframework.expression.*;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className CustomPropertyAccessor
 * @description
 *
 * <a href="https://blog.csdn.net/f641385712/article/details/90812967">参考文章</a>
 * @date 2019-12-05 10:06
 **/
public class CustomPropertyAccessor {
    public static void main(String[] args) {
        String expressionStr = "person";
        ExpressionParser parpser = new SpelExpressionParser(); //SpelExpressionParser是Spring内部对ExpressionParser的唯一最终实现类
        Expression exp = parpser.parseExpression(expressionStr); //把该表达式，解析成一个Expression对象：SpelExpression

        // 设置targetType为Person类型 此处用Person对象~
        StandardEvaluationContext context = new StandardEvaluationContext(new Person("fsx", 18));

        //因为我们指定的PropertyAccessor中，没有一个能够处理Person.class这个类型。
        //然而最终会交给ReflectivePropertyAccessor处理，而它的canRead()是返回false的（Person类因为它既没有person方法，
        //也没有person字段所以肯定返回false啊），所以就抛出异常了
        context.addPropertyAccessor(new BeanExpressionContextAccessor());
        System.out.println(exp.getValue(context));

        // 通过自定义一个处理器，让能从Person类里解析person这个Name引用~
        context.addPropertyAccessor(new PropertyAccessor() {
            // 该处理器只处理Person类目标类型~
            @Override
            public Class<?>[] getSpecificTargetClasses() {
                return new Class[]{Person.class};
            }

            // 此处：要求Person对象必须有name和age才行
            @Override
            public boolean canRead(EvaluationContext context, Object target, String name) throws AccessException {
                Person person = (Person) target;
                return person.getName() != null && person.getAge() != null;
            }

            @Override
            public TypedValue read(EvaluationContext context, Object target, String name) throws AccessException {
                Person person = (Person) target;
                return new TypedValue(person.getName() + ":" + name);
            }

            @Override
            public boolean canWrite(EvaluationContext context, Object target, String name) throws AccessException {
                return false;
            }

            @Override
            public void write(EvaluationContext context, Object target, String name, Object newValue) throws AccessException {
            }
        });
        System.out.println(exp.getValue(context)); //fsx:person
    }


}
