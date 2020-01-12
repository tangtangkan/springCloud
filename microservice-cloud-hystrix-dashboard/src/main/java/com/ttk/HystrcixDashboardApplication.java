package com.ttk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrixDashboard // 开启服务监控
@SpringBootApplication
public class HystrcixDashboardApplication {
	public static void main(String[] args) {
		SpringApplication.run(HystrcixDashboardApplication.class, args);
	}
}
