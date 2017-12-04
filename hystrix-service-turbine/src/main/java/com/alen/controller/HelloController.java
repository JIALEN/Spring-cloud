package com.alen.controller;

import com.alen.service.HelloTwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @create 2017-11-27 17:32
 **/
@RestController
public class HelloController {
    @Autowired
    private HelloTwoService helloTwoService;

    /**
     * 服务调用 消费者
     * @param age
     * @return
     */
    @RequestMapping("/getage")
    public String getConsumer(@RequestParam Integer age) {
        return helloTwoService.age(age);
    }
}
