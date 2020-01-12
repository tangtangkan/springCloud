package com.ttk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableHystrix
@EnableEurekaClient
@MapperScan("com.ttk.mapper")
@SpringBootApplication
public class ProviderHystrixApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProviderHystrixApplication.class, args);
	}
}
