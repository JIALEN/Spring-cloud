package com.alen.service;

import com.alen.service.lmpl.HelloServiceImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 定义一个feign接口，通过@ FeignClient（“服务名”），来指定调用哪个服务
 **/
@FeignClient(value ="eureka-client",fallback = HelloServiceImpl.class)
public interface HelloService {
    @RequestMapping("/hello")
     //必须显示的指定age，不显示还不行
      String hello(@RequestParam("age") Integer age);
}
