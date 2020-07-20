package com.liyong.ioccontainer.service.schema;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

import java.text.SimpleDateFormat;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className SimpleDateFormatBeanDefinitionParser
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-07-20 08:48    
 *
 *
**/
public class SimpleDateFormatBeanDefinitionParser extends AbstractSingleBeanDefinitionParser { //1

    @Override
    protected Class getBeanClass(Element element) {
        return SimpleDateFormat.class; //2
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder bean) {
        // this will never be null since the schema explicitly requires that a value be supplied
        String pattern = element.getAttribute("pattern");
        bean.addConstructorArgValue(pattern);

        // this however is an optional property
        String lenient = element.getAttribute("lenient");
        if (StringUtils.hasText(lenient)) {
            bean.addPropertyValue("lenient", Boolean.valueOf(lenient));
        }
    }

}
