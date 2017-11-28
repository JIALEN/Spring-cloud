package com.alen.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @create 2017-11-27 17:32
 **/
@RestController
public class HelloController {

    /**
     * 提供测试服务
     * @param age
     * @return
     */
    @RequestMapping("/hello")
    public String home(@RequestParam Integer age) {
        age=age*10;
        return age.toString();
    }
}
