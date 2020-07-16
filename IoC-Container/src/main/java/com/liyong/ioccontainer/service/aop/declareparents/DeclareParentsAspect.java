package com.liyong.ioccontainer.service.aop.declareparents;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className AopConfig
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-07-16 23:56    
 *
 *
**/
@Aspect
public class DeclareParentsAspect {

    // “...aop.Person”后面的 “+” 号，表示只要是Person及其子类都可以添加新的方法
    @DeclareParents(value = "com.liyong.ioccontainer.service.aop.declareparents.Person+", defaultImpl = SkillImpl.class)
    public Skill skill;


}
