package com.liyong.ioccontainer.service.expression;

import com.liyong.ioccontainer.service.expression.vo.Inventor;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className CollectionSelected
 * @description
 * @JunitTest: {@link  }
 * @date 2020-07-14 22:57
 **/
public class CollectionSelected {

    public static void main(String[] args) {

        testForList();

        testForMap();

    }

    private static void testForMap(){

        ExpressionParser parser = new SpelExpressionParser();

        StandardEvaluationContext context = new StandardEvaluationContext();

        Map<String,Person> map = new HashMap<>();

        Person person1 = new Person();
        person1.setAge(20);
        person1.setNationality("Serbian");
        map.put("ouwen",person1);

        Person person2 = new Person();
        person2.setAge(30);
        person2.setNationality("Serbian");
        map.put("liyong",person2);

        Member2 member2 = new Member2(map);

        Map newMap = (Map) parser.parseExpression("Persions.?[value.age<27]").getValue(context,member2);

        newMap.entrySet().stream().forEach(System.out::println);
    }

    private static void testForList() {

        ExpressionParser parser = new SpelExpressionParser();

        StandardEvaluationContext context = new StandardEvaluationContext();

        List<Person> peoples = new ArrayList<>();

        Person person1 = new Person();
        person1.setNationality("Serbian");

        Person person2 = new Person();
        person2.setNationality("China");

        Person person3 = new Person();
        person3.setNationality("USA");


        peoples.add(person1);
        peoples.add(person2);
        peoples.add(person3);

        Member member = new Member(peoples);

        List<Person> list = (List<Person>) parser.parseExpression("Persions.?[Nationality == 'Serbian']").getValue(context, member);

        list.stream().forEach(System.out::println);

    }

    static class Member2 {

        private Map<String,Person> persions;

        public Member2(Map<String,Person> persions) {
            this.persions = persions;
        }

        public Map<String, Person> getPersions() {
            return persions;
        }

        public void setPersions(Map<String, Person> persions) {
            this.persions = persions;
        }
    }

    static class Member {

        private List<Person> persions;

        public Member(List<Person> persions) {
            this.persions = persions;
        }

        public List<Person> getPersions() {
            return persions;
        }

        public void setPersions(List<Person> persions) {
            this.persions = persions;
        }
    }


    static class Person {

        private String nationality;

        private Integer age;

        public String getNationality() {

            return nationality;
        }

        public void setNationality(String nationality) {
            this.nationality = nationality;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "nationality='" + nationality + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

}
