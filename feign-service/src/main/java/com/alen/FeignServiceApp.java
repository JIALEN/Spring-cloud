package com.alen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
//通过注解@EnableEurekaClient 表明自己是一个eurekaclient.
@EnableEurekaClient
//开启Feign的功能
@EnableFeignClients
public class FeignServiceApp {
	public static void main(String[] args) {
		SpringApplication.run(FeignServiceApp.class, args);
	}
}
