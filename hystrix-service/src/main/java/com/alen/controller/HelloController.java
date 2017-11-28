package com.alen.controller;

import com.alen.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @create 2017-11-27 17:32
 **/
@RestController
public class HelloController {
    @Autowired
    private HelloService helloService;

    /**
     * 服务调用 消费者
     * @param age
     * @return
     */
    @RequestMapping("/getage")
    public String getConsumer(@RequestParam Integer age) {
        return helloService.getAge(age);
    }
}
