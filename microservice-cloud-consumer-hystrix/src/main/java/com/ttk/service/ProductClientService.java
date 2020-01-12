package com.ttk.service;

import com.ttk.entities.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

// 指定调用微服务名称
// fallback 指定熔断处理类
@FeignClient(value = "microservice-product", fallback = ProductClientServiceFallBack.class)
public interface ProductClientService {

	@RequestMapping(value = "/product/add", method = RequestMethod.POST)
	boolean add(Product product);

	@RequestMapping(value = "/product/findById/{id}", method = RequestMethod.GET)
	Product findById(@PathVariable("id") Long id);

	@RequestMapping(value = "/product/list", method = RequestMethod.GET)
	List<Product> list();
}
