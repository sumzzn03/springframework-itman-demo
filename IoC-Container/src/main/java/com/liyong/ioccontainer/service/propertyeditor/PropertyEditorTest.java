package com.liyong.ioccontainer.service.propertyeditor;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className PropertyEditorTest
 * @description
 * @JunitTest: {@link  }
 * @date 2020-07-12 21:46
 **/
public class PropertyEditorTest {
    public static void main(String[] args) {
        PersonPropertyEditor editor = new PersonPropertyEditor();
        editor.setAsText("ouwen,男,18");
        System.out.println(editor.getValue());
    }
}
