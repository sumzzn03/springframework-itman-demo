package com.liyong.ioccontainer.service.expression;

import com.liyong.ioccontainer.service.expression.vo.Inventor;
import com.liyong.ioccontainer.service.expression.vo.Person;
import com.liyong.ioccontainer.service.expression.vo.PlaceOfBirth;
import org.springframework.expression.*;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.*;

import static com.liyong.ioccontainer.service.expression.Printer.print;


/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className PropertiesArraysAndSoOn
 * @description Properties, Arrays, Lists, Maps, and Indexers
 *
 * <a href="https://docs.spring.io/spring/docs/4.3.25.RELEASE/spring-framework-reference/htmlsingle/#expressions-evaluation-context">参考地址</a>
 * <a href="https://blog.csdn.net/f641385712/article/details/84452191">Value(${}#{})使用Demo</a>
 *
 * @date 2019-12-04 15:39
 **/
public class PropertiesArraysAndSoOn {

    public static void main(String[] args) {
        testForParse();
        testForArray();
        testForList();
        testForProperties();
        testForIndex();
        testForMap();
        testForDynamic();
        testForMethod();
        testForStaticFiledAndMethod();
        testForObject();
        testForAccessor();
        testForRoot1();
        testForRoot2();
        testForGenerics();
        testForParseConfiguration();
        testForAssignment();
        testForTypes();
        testForConstructors();
        testForVariables();
        testForThisAndRoot();
        testForFunctions();
        testForReferences();
        testForTernaryOperator();
        testForSafeNavigationOperator();
        testForCollectionSelection();
        testForCollectProjection();
    }

    private static void testForCollectProjection(){
        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();

        List<Inventor> sources = new ArrayList<>();
        Inventor inventor1 = new Inventor("ouwen", new Date(), "china");
        PlaceOfBirth placeOfBirth1 = new PlaceOfBirth("cq");
        inventor1.setPlaceOfBirth(placeOfBirth1);
        Inventor inventor2 = new Inventor("ly", new Date(), "Serbian");
        PlaceOfBirth placeOfBirth2 = new PlaceOfBirth("bj");
        inventor2.setPlaceOfBirth(placeOfBirth2);

        sources.add(inventor1);
        sources.add(inventor2);
        context.setVariable("sources",sources);

        List placesOfBirth = (List)parser.parseExpression("#sources.![placeOfBirth.city]").getValue(context);

        print(placesOfBirth);
    }

    private static void testForCollectionSelection(){

        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();

        List<Inventor> sources = new ArrayList<>();
        sources.add(new Inventor("ouwen",new Date(),"china"));
        sources.add(new Inventor("ouwen",new Date(),"Serbian"));
        context.setVariable("sources",sources);

        List<Inventor> list = (List<Inventor>) parser.parseExpression(
                "#sources.?[Nationality == 'Serbian']").getValue(context);

        print(list);

        Map map = new HashMap(2);
        map.put("1",10);
        map.put("2",30);
        map.put("3",50);
        map.put("4",5);
        context.setVariable("map",map);
        Map newMap = (Map) parser.parseExpression("#map.?[value<27]").getValue(context);
        print(newMap);

        //拿到匹配的第一个
        newMap = (Map) parser.parseExpression("#map.^[value<27]").getValue(context);
        print(newMap);

        //拿到匹配的最后一个
        newMap = (Map) parser.parseExpression("#map.$[value<27]").getValue(context);
        print(newMap);
    }

    /**
     * 安全访问 ？
     */
    private static void testForSafeNavigationOperator(){
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();

        Inventor tesla = new Inventor("Nikola Tesla", "Serbian");
        tesla.setPlaceOfBirth(new PlaceOfBirth("Smiljan"));

        String city = parser.parseExpression("PlaceOfBirth?.City").getValue(context, tesla, String.class);
        print(city);  // Smiljan

        tesla.setPlaceOfBirth(null);
        city = parser.parseExpression("PlaceOfBirth?.City").getValue(context, tesla, String.class);
        print(city);  // null - does not throw NullPointerException!!!
        city = parser.parseExpression("PlaceOfBirth?.City ?: 'default'").getValue(context, tesla, String.class);
        print(city);  // default
    }

    /**
     * 三元表达式
     */
    private static void testForTernaryOperator(){
        ExpressionParser parser = new SpelExpressionParser();

        String expression = parser.parseExpression(
                "false ? 'trueExp' : 'falseExp'").getValue(String.class);

        print(expression);
    }

    static class MyBeanResolver implements BeanResolver

    {
        @Override
        public Object resolve(EvaluationContext context, String beanName) throws AccessException {
            //可以从BeanFactory获取对象
            System.out.println("进入自定义解析:"+beanName);
            return new Person();
        }
    }

    private static void testForReferences(){
        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setBeanResolver(new MyBeanResolver());

// This will end up calling resolve(context,"foo") on MyBeanResolver during evaluation
        Object bean = parser.parseExpression("@foo").getValue(context);


        context.setBeanResolver(new MyBeanResolver());

// This will end up calling resolve(context,"&foo") on MyBeanResolver during evaluation
        Object bean2 = parser.parseExpression("&foo").getValue(context);

        print(bean);
        print(bean2);
    }

    /**
     * 自定义处理方法
     */
    private static void  testForFunctions() {

        ExpressionParser parser = new SpelExpressionParser();

        EvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();
        try {
            context.setVariable("reverseString",
                    StringUtils.class.getDeclaredMethod("reverseString", String.class));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        String helloWorldReversed = parser.parseExpression(
                "#reverseString('hello')").getValue(context, String.class);

        print(helloWorldReversed);
    }
    public static abstract class StringUtils {
        public static String reverseString(String input) {
            StringBuilder backwards = new StringBuilder(input.length());
            for (int i = 0; i < input.length(); i++) {
                backwards.append(input.charAt(input.length() - 1 - i));
            }

            return backwards.toString();
        }
    }
    private static void testForThisAndRoot(){
        // create an array of integers
        List<Integer> primes = new ArrayList<Integer>();
        primes.addAll(Arrays.asList(2,3,5,7,11,13,17));

// create parser and set variable 'primes' as the array of integers
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();
        context.setVariable("primes", primes);

// all prime numbers > 10 from the list (using selection ?{...})
// evaluates to [11, 13, 17]
        //#this指向当前计算对象 #root始终指向根对象
        List<Integer> primesGreaterThanTen = (List<Integer>) parser.parseExpression(
                "#primes.?[#this>10]").getValue(context);

        print(primesGreaterThanTen);
    }

    private static void testForVariables(){

        ExpressionParser parser = new SpelExpressionParser();
        Inventor tesla = new Inventor("Nikola Tesla", "Serbian");

        EvaluationContext context = SimpleEvaluationContext.forReadWriteDataBinding().build();
        context.setVariable("newName", "Mike Tesla");

        parser.parseExpression("Name = #newName").getValue(context, tesla);
        print(tesla.getName());  // "Mike Tesla"
    }

    private static void testForConstructors(){

        class Simple{
            public List<Inventor> members = new ArrayList<>();

        }
        Simple  simple =  new Simple();
        ExpressionParser parser = new SpelExpressionParser();

        Inventor einstein = parser.parseExpression("new com.ouwen.springboot.spel.vo.Inventor('Albert Einstein', 'German')")
                .getValue(Inventor.class);
        print("testForConstructors:"+einstein);

        //context.setRootObject(members);
        //create new inventor instance within add method of List
//        Object value = parser.parseExpression("#root.add(new com.ouwen.springboot.spel.vo.Inventor('Albert Einstein', 'German'))").getValue(context);
//        Object value = parser.parseExpression("add(new com.ouwen.springboot.spel.vo.Inventor('Albert Einstein', 'German'))").getValue(context);
        Object value = parser.parseExpression("members.add(new com.ouwen.springboot.spel.vo.Inventor('Albert Einstein', 'German'))").getValue(simple);
        print("testForConstructors"+value);

        print("testForConstructors:"+simple);

    }

    private static void testForTypes(){
        ExpressionParser parser = new SpelExpressionParser();
        Class dateClass = parser.parseExpression("T(java.util.Date)").getValue(Class.class);
        //java.lang package下面类不用指定全路径，其他包需要指定全路径
        Class stringClass = parser.parseExpression("T(String)").getValue(Class.class);

        boolean trueValue = parser.parseExpression(
                "T(java.math.RoundingMode).CEILING < T(java.math.RoundingMode).FLOOR")
                .getValue(Boolean.class);
        print(dateClass);
        print(stringClass);
        print(trueValue);
    }

    private static void testForAssignment(){
        ExpressionParser parser = new SpelExpressionParser();
        Inventor inventor = new Inventor();
        EvaluationContext context = SimpleEvaluationContext.forReadWriteDataBinding().build();

        parser.parseExpression("name").setValue(context, inventor, "Aleksandar Seovic");

        // alternatively
        String aleks = parser.parseExpression(
                "Name = 'Aleksandar Seovic'").getValue(context, inventor, String.class);
        print(aleks);
    }

    private static void testForParseConfiguration(){
        class Demo {
            public List<String> list;
        }
        //自动扩容，对象不存在自动创建空对象，控制编译行为 and so on
        SpelParserConfiguration config = new SpelParserConfiguration(true,true);

        ExpressionParser parser = new SpelExpressionParser(config);

        Expression expression = parser.parseExpression("list[3]");

        Demo demo = new Demo();

        Object o = expression.getValue(demo);

        print("testForParseConfiguration:"+o);

        print("testForParseConfiguration:"+demo.list);
    }

    private static void testForRoot2(){
        // Create and set a calendar
        GregorianCalendar c = new GregorianCalendar();
        c.set(1856, 7, 9);

// The constructor arguments are name, birthday, and nationality.
        Inventor tesla = new Inventor("Nikola Tesla", c.getTime(), "Serbian");

        ExpressionParser parser = new SpelExpressionParser();

        Expression exp = parser.parseExpression("name");
        //设置root object
        String name = (String) exp.getValue(tesla);
// name == "Nikola Tesla"

        exp = parser.parseExpression("name == 'Nikola Tesla'");
        boolean result = exp.getValue(tesla, Boolean.class);

        print(name);
        print(result);

    }


    private static void testForGenerics(){
        class Simple {
            public List<Boolean> booleanList = new ArrayList<Boolean>();
        }

        ExpressionParser parser = new SpelExpressionParser();
        Simple simple = new Simple();
        simple.booleanList.add(true);

        //第一种
//        EvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();

        //第二种DataBindingPropertyAccessor 扩展 ReflectivePropertyAccessor 而DataBindingPropertyAccessor 是默认的获取器所以可有可无
        StandardEvaluationContext context = new StandardEvaluationContext();
       // context.addPropertyAccessor(DataBindingPropertyAccessor.forReadOnlyAccess());

        //第三种默认不设置PropertyAccessor

// "false" is passed in here as a String. SpEL and the conversion service
// will recognize that it needs to be a Boolean and convert it accordingly.
        parser.parseExpression("booleanList[0]").setValue(context, simple, "false");

        // parser.parseExpression("booleanList[0]").setValue( simple, "false");

// b will be false
        Boolean b = simple.booleanList.get(0);
        print("testForGenerics:"+b);
    }

    private static void testForRoot1() {
        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setRootObject(new Person("fsx", 18)); // 这个就是最终#root取出来的对象  若没有设置  就不能使用#root


        System.out.println(parser.parseExpression("#root").getValue(context) instanceof Person); // true
        System.out.println(parser.parseExpression("#root").getValue(context)); //Person{name='fsx', age=18}
        System.out.println(parser.parseExpression("#root.name").getValue(context)); //fsx
        System.out.println(parser.parseExpression("#root.age").getValue(context)); // 18


        // 若单纯的想获取属性值，请不要使用#  直接使用name即可
        // #root代表把root当作key先去查找出对象，再导航查找。。。。。而不用#类似全文查找（这个做法非常非常像JSP的el表达式的写法）
        System.out.println(parser.parseExpression("#name").getValue(context)); // null
        System.out.println(parser.parseExpression("name").getValue(context)); // fsx


        // el参与计算时，取值方式也可以是#root 或者直接name属性的方式 都是可以的
        System.out.println(parser.parseExpression("name=='孙悟空'").getValue(context)); //false
        System.out.println(parser.parseExpression("name=='fsx'").getValue(context)); //true
        System.out.println(parser.parseExpression("#root.name=='fsx'").getValue(context)); //true

        System.out.println(parser.parseExpression("name.equals('fsx')").getValue(context)); //true
        //org.springframework.expression.spel.SpelEvaluationException: EL1004E: Method call: Method equalsXXX(java.lang.String) cannot be found on type java.lang.String
//        System.out.println(parser.parseExpression("name.equalsXXX('fsx')").getValue(context)); // 报错


    }

    private static void testForAccessor() {
        ExpressionParser parser = new SpelExpressionParser();

        Person person = new Person("fsx", 30);
        List<String> list = new ArrayList<String>() {{
            add("fsx");
            add("周杰伦");
        }};
        Map<String, Integer> map = new HashMap<String, Integer>() {{
            put("fsx", 18);
            put("周杰伦", 40);
        }};

        EvaluationContext ctx = new StandardEvaluationContext();
        //把list和map都放进环境变量里面去
        ctx.setVariable("myPerson", person);
        ctx.setVariable("myList", list);
        ctx.setVariable("myMap", map);


        //============================================
        System.out.println(parser.parseExpression("#myPerson").getValue(ctx)); //Person{name='fsx', age=30}
        System.out.println(parser.parseExpression("#myPerson.name").getValue(ctx)); //fsx
        // setVariable方式取值不能像root一样，前缀不可省略~~~~~
        System.out.println(parser.parseExpression("#name").getValue(ctx)); //null 显然找不到这个key就返回null呗~~~
        // 不写前缀默认去root找，找出一个null。再访问name属性那可不报错了吗
        //System.out.println(parser.parseExpression("name").getValue(ctx)); // Property or field 'name' cannot be found on null


        System.out.println(parser.parseExpression("#myList").getValue(ctx)); // [fsx, 周杰伦]
        System.out.println(parser.parseExpression("#myList[1]").getValue(ctx)); // 周杰伦

        // 请注意对Map取值两者的区别：中文作为key必须用''包起来   当然['fsx']也是没有问题的
        System.out.println(parser.parseExpression("#myMap[fsx]").getValue(ctx)); //18
        System.out.println(parser.parseExpression("#myMap['周杰伦']").getValue(ctx)); //40

        // =========若采用#key引用的变量不存在，返回的是null，并不会报错哦==============
        System.out.println(parser.parseExpression("#map").getValue(ctx)); //null

        // 黑科技：SpEL内直接可以使用new方式创建实例  能创建数组、List  但不能创建普通的实例对象（难道是我还不知道）~~~~
        System.out.println(parser.parseExpression("new String[]{'java','spring'}").getValue()); //[Ljava.lang.String;@30b8a058
        System.out.println(parser.parseExpression("{'java','c语言','PHP'}").getValue()); //[java, c语言, PHP] 创建List
        System.out.println(parser.parseExpression("new com.ouwen.springboot.po.Person()").getValue()); //A problem occurred whilst attempting to const

    }

    private static void testForObject() {
        ExpressionParser parser = new SpelExpressionParser();
        //解析表达式需要的上下文，解析时有一个默认的上下文
        EvaluationContext ctx = new StandardEvaluationContext();
        Inventor inventor = new Inventor(2);
        //设置为rootobject，获取值不需要#
        ((StandardEvaluationContext) ctx).setRootObject(inventor);
//        Object value = parser.parseExpression("age").getValue(ctx);
        Object value = parser.parseExpression("age").getValue(inventor);
        print("age:" + value);
    }

    private static void testForStaticFiledAndMethod() {
        ExpressionParser parser = new SpelExpressionParser();
        //解析表达式需要的上下文，解析时有一个默认的上下文
        EvaluationContext ctx = new StandardEvaluationContext();
        System.out.println(parser.parseExpression("T(System).getProperty('user.dir')").getValue());
        Object value = parser.parseExpression("T(java.lang.Math).random() * 100.0").getValue(ctx);
        Object value2 = parser.parseExpression("T(java.lang.Math).PI").getValue(ctx);
        Object value3 = parser.parseExpression("T(com.ouwen.springboot.Utils.Printer).isMember('xo')").getValue(ctx);
        print(value);
        print(value2);
        print(value3);
    }

    private static void testForMethod() {
        ExpressionParser parser = new SpelExpressionParser();
        //解析表达式需要的上下文，解析时有一个默认的上下文
        EvaluationContext ctx = new StandardEvaluationContext();
        Inventor inventor = new Inventor(1);
        ctx.setVariable("inventor", inventor);
        // string literal, evaluates to "bc"
        String bc = parser.parseExpression("'abc'.substring(1, 3)").getValue(String.class);

        Object value = parser.parseExpression("#inventor.getAge()").getValue(ctx);

        print(bc);
        print(value);
    }

    private static void testForDynamic() {

        ExpressionParser parser = new SpelExpressionParser();
        //解析表达式需要的上下文，解析时有一个默认的上下文
        EvaluationContext ctx = new StandardEvaluationContext();
        int[] numbers1 = (int[]) parser.parseExpression("new int[4]").getValue(ctx);

        // Array with initializer
        int[] numbers2 = (int[]) parser.parseExpression("new int[]{1,2,3}").getValue(ctx);

        // Multi dimensional array
        int[][] numbers3 = (int[][]) parser.parseExpression("new int[4][5]").getValue(ctx);

        print(numbers1);
        print(numbers2);
        print(numbers3);
    }

    private static void testForMap() {
        ExpressionParser parser = new SpelExpressionParser();
        //解析表达式需要的上下文，解析时有一个默认的上下文
        EvaluationContext ctx = new StandardEvaluationContext();
        // evaluates to a Java map containing the two entries
        Map inventorInfo = (Map) parser.parseExpression("{name:'Nikola',dob:'10-July-1856'}").getValue(ctx);
        Map mapOfMaps = (Map) parser.parseExpression("{name:{first:'Nikola',last:'Tesla'},dob:{day:10,month:'July',year:1856}}").getValue(ctx);
        print(inventorInfo);
        print(mapOfMaps);
    }

    private static void testForIndex() {
        ExpressionParser parser = new SpelExpressionParser();
        //解析表达式需要的上下文，解析时有一个默认的上下文
        EvaluationContext ctx = new StandardEvaluationContext();
        Inventor user1 = new Inventor("邹任飞", 9001);
        Inventor user2 = new Inventor("练汶峰", 9002);
        List<Inventor> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        ctx.setVariable("users", users);


        String name = parser.parseExpression("#users[1].name").getValue(ctx, String.class);
        print(name);
    }

    private static void testForList() {
        ExpressionParser parser = new SpelExpressionParser();
        List numbers = (List) parser.parseExpression("{1,2,3,4,5}").getValue();
        System.out.println(numbers);
        List listOfLists = (List) parser.parseExpression("{{'a','b'},{'x','y'}}").getValue();
        print(listOfLists);
    }

    /**
     * 属性访问
     */
    private static void testForProperties() {
        Inventor inventor = new Inventor(1);
        //创建SpEL表达式的解析器
        ExpressionParser parser = new SpelExpressionParser();
        //解析表达式需要的上下文，解析时有一个默认的上下文
        EvaluationContext ctx = new StandardEvaluationContext();
        //在上下文中设置变量，变量名为user，内容为user对象
        ctx.setVariable("inventor", inventor);
        //从用户对象中获得id并+1900，获得解析后的值在ctx上下文中
        int id = (Integer) parser.parseExpression("#inventor.age + 1900").getValue(ctx);
        print(id);
    }

    private static void testForParse() {
        //其中#{}表示表达式的起止，#user是表达式字符串，表示引用一个变量
        String greetingExp = "Hello, #{ #user }, #{'user'}";
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext();
        context.setVariable("user", "Gangyou");

        Expression expression = parser.parseExpression(greetingExp,
                new TemplateParserContext());
        print(expression.getValue(context, String.class));
    }

    /**
     * 数组访问
     */
    private static void testForArray() {
        ExpressionParser parser = new SpelExpressionParser();

        StandardEvaluationContext context = new StandardEvaluationContext();

        Inventor inventor = new Inventor();
        inventor.setBirthdate(new Date());
        inventor.setAge(10);

        context.setVariable("inventor", inventor);

        Inventor[] inventors = {new Inventor(1), new Inventor(2)};

        context.setVariable("inventors", inventors);

        int year = (Integer) parser.parseExpression("#inventor.age + 10").getValue(context);

        int year2 = (Integer) parser.parseExpression("#inventors[1].age + 10").getValue(context);

        print(year);
        print(year2);
    }
}
