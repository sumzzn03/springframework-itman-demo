package com.liyong.ioccontainer.service.aop.declareparents;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className SkillImpl
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-07-16 23:57    
 *
 *
**/
public class SkillImpl implements Skill {
    @Override
    public void getSkill(String skill) {
        System.out.println(skill);
    }
}
