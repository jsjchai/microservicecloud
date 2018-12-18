package com.jsjchai.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.jsjchai.springcloud"})
@ComponentScan("com.jsjchai.springcloud")
public class DeptFeignConsumer80App {

	public static void main(String[] args) {
		SpringApplication.run(DeptFeignConsumer80App.class, args);
	}
}
