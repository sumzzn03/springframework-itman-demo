package com.liyong.ioccontainer.service.beanscope;
/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className SimpleUserService
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-06-29 23:27    
 *
 *
**/
public class SimpleUserService {

    private UserPreferences userPreferences;

    public UserPreferences getUserPreferences() {
        return userPreferences;
    }

    public void setUserPreferences(UserPreferences userPreferences) {
        this.userPreferences = userPreferences;
    }
}
