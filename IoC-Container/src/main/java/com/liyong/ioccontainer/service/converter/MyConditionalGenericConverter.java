package com.liyong.ioccontainer.service.converter;

import org.springframework.core.ResolvableType;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.ConditionalGenericConverter;
import org.springframework.core.convert.support.DefaultConversionService;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className MyConditionalGenericConverter
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-07-12 22:21    
 *
 *
**/
public class MyConditionalGenericConverter implements ConditionalGenericConverter {
    @Override
    public boolean matches(TypeDescriptor sourceType, TypeDescriptor targetType) {
        if (sourceType.getAnnotation(Resource.class)!=null){
            return true;
        }
        return false;
    }

    /**
     * 告诉转换器总部，我这个转换器支持什么样的转换，可以支持多个转换
     * 此处支持 string -> list 和 string -> map
     */
    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        Set<ConvertiblePair> convertiblePairs = Collections.newSetFromMap(new ConcurrentHashMap<>());
        ConvertiblePair stringToArray = new ConvertiblePair(String.class, List.class);
        ConvertiblePair stringToMap = new ConvertiblePair(String.class, Map.class);
        convertiblePairs.add(stringToArray);
        convertiblePairs.add(stringToMap);
        return convertiblePairs;
    }

    /**
     * @param source     被转换的东西
     * @param sourceType 被转换的东西的上下文，可以用于设置条件，具体咋玩看typeDescriptor，比如可以用来判断转换源是否拥有某些注解
     *                   @see TypeDescriptor
     * @param targetType 转换目标类型的上下文
     * @return
     * 案例场景：如果转换源被@Resource标识，并且目标类型为List，则转换list
     *                                         目标类型为map，则转换为map
     */
    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        if (targetType.getType() == List.class){
            return Arrays.asList(source.toString().split(":"));
        }
        if (targetType.getType() == Map.class){
            Map<String, String> map = new HashMap<>();
            map.put("a",source.toString().split(":")[0]);
            map.put("b",source.toString().split(":")[1]);
            return map;
        }
        return null;
    }

}


