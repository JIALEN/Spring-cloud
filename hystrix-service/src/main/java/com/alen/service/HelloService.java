package com.alen.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;
    @Value("${eurekaclientURL}")
    private String eurekaclientURL;

    //该注解对该方法创建了熔断器的功能，并指定了fallbackMethod熔断方法
    //有个坑 这个方法fallbackMethod = "failError"的方法参数还得和getAge原方法的一样才行
    @HystrixCommand(fallbackMethod = "failError")
    public String getAge(Integer age) {
        return restTemplate.getForObject(eurekaclientURL + age, String.class);
    }

    public String failError(Integer age) {
        return "hi,"+age+",sorry,error!";
    }
}
