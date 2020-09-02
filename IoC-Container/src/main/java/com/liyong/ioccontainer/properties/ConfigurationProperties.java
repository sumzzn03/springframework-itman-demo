package com.liyong.ioccontainer.properties;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className ConfigurationProperties
 * @description {@link org.springframework.boot.context.properties.ConfigurationProperties}
 * @JunitTest: {@link  }
 * @date 2020-08-31 16:00
 **/
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ConfigurationProperties {

    /**
     * The name prefix of the properties that are valid to bind to this object. Synonym
     * for {@link #prefix()}.
     * @return the name prefix of the properties to bind
     */
    @AliasFor("prefix")
    String value() default "";

    /**
     * The name prefix of the properties that are valid to bind to this object. Synonym
     * for {@link #value()}.
     * @return the name prefix of the properties to bind
     */
    @AliasFor("value")
    String prefix() default "";

    /**
     * Flag to indicate that when binding to this object invalid fields should be ignored.
     * Invalid means invalid according to the binder that is used, and usually this means
     * fields of the wrong type (or that cannot be coerced into the correct type).
     * @return the flag value (default false)
     */
    boolean ignoreInvalidFields() default false;

    /**
     * Flag to indicate that when binding to this object fields with periods in their
     * names should be ignored.
     * @return the flag value (default false)
     */
    boolean ignoreNestedProperties() default false;

    /**
     * Flag to indicate that when binding to this object unknown fields should be ignored.
     * An unknown field could be a sign of a mistake in the Properties.
     * @return the flag value (default true)
     */
    boolean ignoreUnknownFields() default true;

    /**
     * Flag to indicate that an exception should be raised if a Validator is available,
     * the class is annotated with {@link Validated @Validated} and validation fails. If
     * it is set to false, validation errors will be swallowed. They will be logged, but
     * not propagated to the caller.
     * @return the flag value (default true)
     * @deprecated as of 1.5 since validation only kicks in when {@code @Validated} is
     * present
     */
    @Deprecated
    boolean exceptionIfInvalid() default true;

}

