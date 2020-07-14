package com.liyong.ioccontainer.service.expression;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className CollectionProjection
 *@description 集合投影
 *@JunitTest: {@link  } 
 *@date 2020-07-14 23:33    
 *
 *
**/
public class CollectionProjection {

    public static void main(String[] args) {

        testForList();

        testForMap();

    }

    private static void testForMap(){

        ExpressionParser parser = new SpelExpressionParser();

        EvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();

        Map<String,Persion> persions = new HashMap<>();

        Persion persion1= new Persion(new PlaceOfBirth("shengzheng","深圳市"));
        persions.put("ouwen",persion1);

        Persion persion2= new Persion(new PlaceOfBirth("chongqing","重庆市"));
        persions.put("liyong",persion2);

        Member2 member = new Member2(persions);


        List datas = (List)parser.parseExpression("Persions.![value.placeOfBirth.city]").getValue(context,member);

        datas.stream().forEach(System.out::println);

    }

    private static void testForList(){

        ExpressionParser parser = new SpelExpressionParser();

        EvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();

        List<Persion> persions = new ArrayList<>();

        Persion persion1= new Persion(new PlaceOfBirth("shengzheng","深圳市"));
        persions.add(persion1);

        Persion persion2= new Persion(new PlaceOfBirth("chongqing","重庆市"));
        persions.add(persion2);

        Member member = new Member(persions);


        List datas = (List)parser.parseExpression("Persions.![placeOfBirth.city]").getValue(context,member);

        datas.stream().forEach(System.out::println);

    }

    static class Member2{

        private Map<String,Persion> persions;

        public Member2( Map<String,Persion> persions) {
            this.persions = persions;
        }

        public  Map<String,Persion> getPersions() {
            return persions;
        }

        public void setPersions( Map<String,Persion> persions) {
            this.persions = persions;
        }
    }

    static class Member{

        private List<Persion> persions;

        public Member(List<Persion> persions) {
            this.persions = persions;
        }

        public List<Persion> getPersions() {
            return persions;
        }

        public void setPersions(List<Persion> persions) {
            this.persions = persions;
        }
    }

    static class PlaceOfBirth{

        private String city;

        private String addrass;

        public PlaceOfBirth(String city,String addrass) {
            this.city = city;
            this.addrass = addrass;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getAddrass() {
            return addrass;
        }

        public void setAddrass(String addrass) {
            this.addrass = addrass;
        }
    }

    static class Persion{

        private PlaceOfBirth placeOfBirth;

        public Persion(PlaceOfBirth placeOfBirth) {
            this.placeOfBirth = placeOfBirth;
        }

        public PlaceOfBirth getPlaceOfBirth() {
            return placeOfBirth;
        }

        public void setPlaceOfBirth(PlaceOfBirth placeOfBirth) {
            this.placeOfBirth = placeOfBirth;
        }
    }

}
