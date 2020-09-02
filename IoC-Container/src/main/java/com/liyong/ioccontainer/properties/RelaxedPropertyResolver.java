package com.liyong.ioccontainer.properties;

import org.springframework.core.env.PropertyResolver;
import org.springframework.util.Assert;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className RelaxedPropertyResolver
 * @description {@link org.springframework.boot.bind.RelaxedPropertyResolver}
 * @JunitTest: {@link  }
 * @date 2020-08-31 15:56
 **/
public class RelaxedPropertyResolver implements PropertyResolver {

    private final PropertyResolver resolver;

    private final String prefix;

    public RelaxedPropertyResolver(PropertyResolver resolver) {
        this(resolver, null);
    }

    public RelaxedPropertyResolver(PropertyResolver resolver, String prefix) {
        Assert.notNull(resolver, "PropertyResolver must not be null");
        this.resolver = resolver;
        this.prefix = (prefix == null ? "" : prefix);
    }

    @Override
    public String getRequiredProperty(String key) throws IllegalStateException {
        return getRequiredProperty(key, String.class);
    }

    @Override
    public <T> T getRequiredProperty(String key, Class<T> targetType)
            throws IllegalStateException {
        T value = getProperty(key, targetType);
        Assert.state(value != null, String.format("required key [%s] not found", key));
        return value;
    }

    @Override
    public String getProperty(String key) {
        return getProperty(key, String.class, null);
    }

    @Override
    public String getProperty(String key, String defaultValue) {
        return getProperty(key, String.class, defaultValue);
    }

    @Override
    public <T> T getProperty(String key, Class<T> targetType) {
        return getProperty(key, targetType, null);
    }

    @Override
    public <T> T getProperty(String key, Class<T> targetType, T defaultValue) {
        RelaxedNames prefixes = new RelaxedNames(this.prefix);
        RelaxedNames keys = new RelaxedNames(key);
        for (String prefix : prefixes) {
            for (String relaxedKey : keys) {
                if (this.resolver.containsProperty(prefix + relaxedKey)) {
                    return this.resolver.getProperty(prefix + relaxedKey, targetType);
                }
            }
        }
        return defaultValue;
    }


    @Override
    public boolean containsProperty(String key) {
        RelaxedNames prefixes = new RelaxedNames(this.prefix);
        RelaxedNames keys = new RelaxedNames(key);
        for (String prefix : prefixes) {
            for (String relaxedKey : keys) {
                if (this.resolver.containsProperty(prefix + relaxedKey)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String resolvePlaceholders(String text) {
        throw new UnsupportedOperationException(
                "Unable to resolve placeholders with relaxed properties");
    }

    @Override
    public String resolveRequiredPlaceholders(String text)
            throws IllegalArgumentException {
        throw new UnsupportedOperationException(
                "Unable to resolve placeholders with relaxed properties");
    }


}

