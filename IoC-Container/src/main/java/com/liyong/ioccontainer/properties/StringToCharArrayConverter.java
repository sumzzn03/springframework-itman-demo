package com.liyong.ioccontainer.properties;

import org.springframework.core.convert.converter.Converter;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className StringToCharArrayConverter
 * @description {@link org.springframework.boot.bind.StringToCharArrayConverter}
 * @JunitTest: {@link  }
 * @date 2020-08-31 16:13
 **/
public class StringToCharArrayConverter implements Converter<String, char[]> {

    @Override
    public char[] convert(String source) {
        return source.toCharArray();
    }

}
