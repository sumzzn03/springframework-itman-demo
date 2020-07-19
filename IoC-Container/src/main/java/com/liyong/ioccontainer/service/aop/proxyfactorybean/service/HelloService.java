package com.liyong.ioccontainer.service.aop.proxyfactorybean.service;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

/**
 * @ClassName HelloService
 * @Description
 * @Author liyong
 * @Date 2019-11-06 15:39
 * @Version v1.0.0
 **/
@Validated(Default.class)//必须标注
public interface HelloService {

    /*
        @NotNull
        Object hello(@NotNull @Min(10) Integer id, @NotNull String name);
     */
   @NotNull Object hello(@NotNull @Min(10) Integer id, @NotNull String name);
}
