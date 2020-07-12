package com.liyong.ioccontainer.service.propertyeditor;

import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className PersonPropertyEditor
 * @description
 * @JunitTest: {@link  }
 * @date 2020-07-12 21:45
 **/
public class PersonPropertyEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) {
        setValue(parseString(text));
    }

    /***
     *
     * 解析传入的文本字符串解析为对象
     *
     * @author liyong
     * @date 9:47 PM 2020/7/12
     * @param text
     * @exception
     * @return java.lang.Object
     **/
    private Object parseString(String text) {
        String[] parts = tokenizeToStringArray(text, ", ", false, false);
        String name = (parts.length > 0 ? parts[0] : "undefine");
        String sex = (parts.length > 1 ? parts[1] : "undefine");
        int age = (parts.length > 2 ? Integer.valueOf(parts[2]) : 0);
        //创建Person对象
        return (text.length() > 0 ? new Person(name, sex, age) : null);
    }

    private String[] tokenizeToStringArray(String str, String delimiters, boolean trimTokens,
                                           boolean ignoreEmptyTokens) {
        StringTokenizer st = new StringTokenizer(str, delimiters);
        List tokens = new ArrayList();
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (trimTokens) {
                token = token.trim();
            }
            if (!ignoreEmptyTokens || token.length() > 0) {
                tokens.add(token);
            }
        }
        return toStringArray(tokens);
    }

    private String[] toStringArray(Collection collection) {
        if (collection == null) {
            return null;
        }
        return (String[]) collection.toArray(new String[collection.size()]);
    }
}
