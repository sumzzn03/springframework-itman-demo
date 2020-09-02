package com.liyong.ioccontainer.properties.config.exception;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className AppConfigException
 * @description
 * @JunitTest: {@link  }
 * @date 2020-08-31 16:20
 **/
public class AppConfigException extends BusinessException {

    public AppConfigException(Throwable cause) {
        super(cause);
    }

    public AppConfigException(String message) {
        super(message);
    }

    public AppConfigException(String message, Throwable cause) {
        super(message, cause);
    }

    public static void throwIt(String message) {
        throw new AppConfigException(message);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}


