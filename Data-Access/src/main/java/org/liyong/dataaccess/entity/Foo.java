package org.liyong.dataaccess.entity.transaction;
/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className Foo
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-07-22 23:45    
 *
 *
**/
public class Foo {

    private String fooName;
    private String barName;


    public Foo(String fooName, String barName) {
        this.fooName = fooName;
        this.barName = barName;
    }

    public String getFooName() {
        return fooName;
    }

    public void setFooName(String fooName) {
        this.fooName = fooName;
    }

    public String getBarName() {
        return barName;
    }

    public void setBarName(String barName) {
        this.barName = barName;
    }
}
