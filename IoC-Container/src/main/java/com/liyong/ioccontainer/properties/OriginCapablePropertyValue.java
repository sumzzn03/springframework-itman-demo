package com.liyong.ioccontainer.properties;

import org.springframework.beans.PropertyValue;
import org.springframework.core.env.PropertySource;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className OriginCapablePropertyValue
 * @description {@link org.springframework.boot.bind.OriginCapablePropertyValue}
 * @JunitTest: {@link  }
 * @date 2020-08-31 16:11
 **/
public class OriginCapablePropertyValue extends PropertyValue {

    private static final String ATTRIBUTE_PROPERTY_ORIGIN = "propertyOrigin";

    private final PropertyOrigin origin;

    OriginCapablePropertyValue(PropertyValue propertyValue) {
        this(propertyValue.getName(), propertyValue.getValue(),
                (PropertyOrigin) propertyValue.getAttribute(ATTRIBUTE_PROPERTY_ORIGIN));
    }

    OriginCapablePropertyValue(String name, Object value, String originName,
                               PropertySource<?> originSource) {
        this(name, value, new PropertyOrigin(originSource, originName));
    }

    OriginCapablePropertyValue(String name, Object value, PropertyOrigin origin) {
        super(name, value);
        this.origin = origin;
        setAttribute(ATTRIBUTE_PROPERTY_ORIGIN, origin);
    }

    public PropertyOrigin getOrigin() {
        return this.origin;
    }

    @Override
    public String toString() {
        String name = this.origin != null ? this.origin.getName() : this.getName();
        String source = this.origin.getSource() != null
                ? this.origin.getSource().getName() : "unknown";
        return "'" + name + "' from '" + source + "'";
    }

    public static PropertyOrigin getOrigin(PropertyValue propertyValue) {
        if (propertyValue instanceof OriginCapablePropertyValue) {
            return ((OriginCapablePropertyValue) propertyValue).getOrigin();
        }
        return new OriginCapablePropertyValue(propertyValue).getOrigin();
    }

}
