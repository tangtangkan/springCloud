package com.ttk.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

// 向容器中注入RestTemplate
@Configuration
public class ConfigBean {

	// @LoadBalanced注解表示开启负载均衡, 在调用提供者接口时, 可以用服务名称代替真实IP地址,
	@LoadBalanced
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}