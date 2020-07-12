package com.liyong.ioccontainer.service.propertyeditor;

import java.beans.PropertyEditorSupport;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className ExoticTypeEditor
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-07-12 21:52    
 *
 *
**/
public class ExoticTypeEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) {
        setValue(new ExoticType(text.toUpperCase()));
    }
}
