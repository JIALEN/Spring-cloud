package com.alen.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    /**
     * 从配置中心读取的变量的值
     * @param
     * @return
     */
    @RequestMapping("/hello")
    public String getName() {
        return "hello";
    }
}
