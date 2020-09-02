/*
 * 修订记录:
 * liyong 2016-12-14 22:32 创建
 */
package com.liyong.ioccontainer.properties.config;

import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;
import static com.liyong.ioccontainer.properties.config.CustomApplicationContext.SPRING_PROFILE_ACTIVE;

/**
 * @author liyong
 */
public class Apps {

    public static ApplicationContext getApplicationContext() {
        return ApplicationContextHolder.get();
    }

    /**
     * 暴露info信息，可以通过 actuator info endpoint获取
     *
     * @param key   key
     * @param value value
     */
    public static void exposeInfo(String key, Object value) {
        String infoKey = "info." + key;
        System.setProperty(infoKey, String.valueOf(value));
    }

    public static void setProfileIfNotExists(String profile) {
        if (!StringUtils.hasLength(System.getProperty(SPRING_PROFILE_ACTIVE))
                && !System.getenv().containsKey("SPRING_PROFILES_ACTIVE")) {
            System.setProperty(SPRING_PROFILE_ACTIVE, profile);
        }
    }

    /**
     * 当前环境变量
     **/
    public static String getCurrentProfile() {
        return System.getProperty(SPRING_PROFILE_ACTIVE);
    }


    public static <T> T buildProperties(Class<T> clazz) {
        return EnvironmentHolder.buildProperties(clazz);
    }

    public static Environment getEnvironment() {
        return EnvironmentHolder.get();
    }

}
