package com.alen.controller;

import com.alen.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private HelloService  helloService;
    /**
     * 通过Controller调用远程服务
     * @param age
     * @return
     */
    @RequestMapping("/hello")
    public String home(@RequestParam Integer age) {
        return helloService.hello(age);
    }
}
