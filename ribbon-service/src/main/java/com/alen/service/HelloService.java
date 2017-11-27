package com.alen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 测试调用
 *
 * @create 2017-11-27 17:14
 **/
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;
    @Value("${consumerURL}")
    private String consumerUrl;

    public String getAge(Integer age) {
        return restTemplate.getForObject("http://EUREKA-CLIENT/hello?age=" + age, String.class);
    }
}
