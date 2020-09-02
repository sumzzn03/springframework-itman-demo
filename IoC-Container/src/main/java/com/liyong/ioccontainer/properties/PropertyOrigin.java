package com.liyong.ioccontainer.properties;

import org.springframework.core.env.PropertySource;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className PropertyOrigin
 * @description {@link org.springframework.boot.bind.PropertyOrigin}
 * @JunitTest: {@link  }
 * @date 2020-08-31 16:10
 **/
public class PropertyOrigin {

    private final PropertySource<?> source;

    private final String name;

    PropertyOrigin(PropertySource<?> source, String name) {
        this.name = name;
        this.source = source;
    }

    public PropertySource<?> getSource() {
        return this.source;
    }

    public String getName() {
        return this.name;
    }

}

