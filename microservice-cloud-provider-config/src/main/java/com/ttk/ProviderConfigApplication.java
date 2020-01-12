package com.ttk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@MapperScan("com.ttk.mapper")
@EnableEurekaClient
@SpringBootApplication
public class ProviderConfigApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProviderConfigApplication.class, args);
	}
}
