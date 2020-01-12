package com.ttk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy // 开启路由网关
@SpringBootApplication
public class ZuulGatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(ZuulGatewayApplication.class, args);
	}
}
