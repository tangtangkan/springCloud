package com.ttk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.ttk.service")
@EnableEurekaClient
@SpringBootApplication
public class ConsumerFeignHystrixApplication {
	public static void main(String[] args) {
		SpringApplication.run(ConsumerFeignHystrixApplication.class, args);
	}
}
