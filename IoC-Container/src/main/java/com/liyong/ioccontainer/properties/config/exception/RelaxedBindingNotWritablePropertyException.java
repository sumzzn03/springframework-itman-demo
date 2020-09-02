package com.liyong.ioccontainer.properties.config.exception;

import com.liyong.ioccontainer.properties.PropertyOrigin;
import org.springframework.beans.NotWritablePropertyException;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className RelaxedBindingNotWritablePropertyException
 * @description
 * @JunitTest: {@link  }
 * @date 2020-08-31 16:12
 **/
public class RelaxedBindingNotWritablePropertyException
        extends NotWritablePropertyException {

    private final String message;

    private final PropertyOrigin propertyOrigin;

    public RelaxedBindingNotWritablePropertyException(NotWritablePropertyException ex,
                                                      PropertyOrigin propertyOrigin) {
        super(ex.getBeanClass(), ex.getPropertyName());
        this.propertyOrigin = propertyOrigin;
        this.message = "Failed to bind '" + propertyOrigin.getName() + "' from '"
                + propertyOrigin.getSource().getName() + "' to '" + ex.getPropertyName()
                + "' property on '" + ex.getBeanClass().getName() + "'";
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    public PropertyOrigin getPropertyOrigin() {
        return this.propertyOrigin;
    }

}
