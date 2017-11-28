package com.alen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
//通过注解@EnableEurekaClient 表明自己是一个eurekaclient.
@EnableEurekaClient
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
