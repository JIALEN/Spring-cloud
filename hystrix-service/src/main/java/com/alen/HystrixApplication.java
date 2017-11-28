package com.alen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//通过注解@EnableEurekaClient 表明自己是一个eurekaclient.
@EnableEurekaClient
//注解开启Hystrix
@EnableHystrix
//启用Hystrix仪表板
@EnableHystrixDashboard
public class HystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixApplication.class, args);
	}

	/**
	 * 向程序的ioc注入一个bean: restTemplate;
	 * 并通过@LoadBalanced注解表明这个restRemplate开启负载均衡的功能。
	 */
	@Bean
	@LoadBalanced
    public 	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
