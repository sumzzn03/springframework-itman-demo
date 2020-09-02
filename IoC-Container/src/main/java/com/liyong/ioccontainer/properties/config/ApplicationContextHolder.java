/*
 * www.fm.com Inc.
 * Copyright (c) 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * liyong 2016-12-14 22:40 创建
 */
package com.liyong.ioccontainer.properties.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;

/** @author liyong */
public class ApplicationContextHolder implements ApplicationContextAware {

  private static ApplicationContext CONTEXT;

  private static void setContext(ApplicationContext context) {
    ApplicationContextHolder.CONTEXT = context;
  }

  public static ConfigurableApplicationContext get() {
    return (ConfigurableApplicationContext) CONTEXT;
  }

  public void setApplicationContext(ApplicationContext context) throws BeansException {
    if (CONTEXT != null) {
      if (context.getParent() == CONTEXT) {
        setContext(context);
      }
    } else {
      setContext(context);
    }
  }
}
