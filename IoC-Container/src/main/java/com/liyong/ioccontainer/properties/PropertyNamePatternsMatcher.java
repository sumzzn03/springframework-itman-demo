package com.liyong.ioccontainer.properties;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className PropertyNamePatternsMatcher
 * @description {@link org.springframework.boot.bind.PropertyNamePatternsMatcher}
 * @JunitTest: {@link  }
 * @date 2020-08-31 16:15
 **/
interface PropertyNamePatternsMatcher {

    PropertyNamePatternsMatcher ALL = new PropertyNamePatternsMatcher() {

        @Override
        public boolean matches(String propertyName) {
            return true;
        }

    };

    PropertyNamePatternsMatcher NONE = new PropertyNamePatternsMatcher() {

        @Override
        public boolean matches(String propertyName) {
            return false;
        }

    };

    /**
     * Return {@code true} of the property name matches.
     * @param propertyName the property name
     * @return {@code true} if the property name matches
     */
    boolean matches(String propertyName);

}
