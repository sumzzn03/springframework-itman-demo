package com.liyong.ioccontainer.properties;

import java.beans.PropertyEditorSupport;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className InetAddressEditor
 * @description {@link org.springframework.boot.bind.InetAddressEditor}
 * @JunitTest: {@link  }
 * @date 2020-08-31 16:14
 **/
public class InetAddressEditor extends PropertyEditorSupport {

    @Override
    public String getAsText() {
        return ((InetAddress) getValue()).getHostAddress();
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            setValue(InetAddress.getByName(text));
        }
        catch (UnknownHostException ex) {
            throw new IllegalArgumentException("Cannot locate host", ex);
        }
    }

}
