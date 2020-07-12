package com.liyong.ioccontainer.service.converter;

import org.springframework.core.ResolvableType;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.support.DefaultConversionService;

import java.util.List;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className ConditionalConverterTest
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-07-12 22:22    
 *
 *
**/
public class ConditionalConverterTest {
    public static void main(String[] args) throws NoSuchFieldException {
        DefaultConversionService defaultConversionService = new DefaultConversionService();
        defaultConversionService.addConverter(new MyConditionalGenericConverter());

        Persion persion = new Persion();
        persion.setName("1:2");

        List convert = (List) defaultConversionService.convert(persion.getName(),
                //source字段类型描述
                new TypeDescriptor(Persion.class.getDeclaredField("name")),
                //目标类型描述
                new TypeDescriptor(ResolvableType.forRawClass(List.class),null,null));
        System.out.println(convert.toString());
    }
}
