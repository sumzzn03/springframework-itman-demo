package com.liyong.ioccontainer.service.expression;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className Printer
 * @description
 * @date 2019-12-04 15:32
 **/
public class Printer {
    public static void print(Object o){
        System.out.println(o);
    }

    public static boolean isMember(String msg){
        System.out.println("msg:"+msg);
        return true;}
}
