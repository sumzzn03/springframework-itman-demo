package com.liyong.ioccontainer.service;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className AutowireCandidateService
 * @description
 * @JunitTest: {@link  }
 * @date 2020-05-12 23:44
 **/
public class AutowireCandidateService {

    /**
     * 　@Autowired 注入会报错 ，不存在该bean，因为autowire-candidate="false"影响通过类型注入
     *
     * @Resource 正常注入，这里 @Resource使用名称查找autowire-candidate="false"对其没有影响
     */
    @Autowired
    public OtherService otherService;

    @Resource
    public BookService bookService;

    public OtherService getOtherService() {
        return otherService;
    }

    public void setOtherService(OtherService otherService) {
        this.otherService = otherService;
    }

    public BookService getBookService() {
        return bookService;
    }

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }
}
