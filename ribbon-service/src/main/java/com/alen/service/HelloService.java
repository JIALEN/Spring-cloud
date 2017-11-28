package com.alen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
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
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    RestTemplate restTemplate;
    @Value("${eurekaclientURL}")
    private String eurekaclientURL;
    @Value("${ribbonserviceproviderURL}")
    private String ribbonserviceproviderURL;

    public String getAge(Integer age) {
        //打印一下到底调用的是哪个
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("eureka-client");
        System.out.println("===" + ":" + serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":" + serviceInstance.getPort());
        ServiceInstance serviceInstance2 = this.loadBalancerClient.choose("ribbon-service-provider");
        System.out.println("===" + ":" + serviceInstance2.getServiceId() + ":" + serviceInstance2.getHost() + ":" + serviceInstance2.getPort());
        restTemplate.getForObject(ribbonserviceproviderURL + age, String.class);
        return restTemplate.getForObject(eurekaclientURL + age, String.class);
    }
}
