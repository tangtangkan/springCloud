package com.ttk.controller;

import com.ttk.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ProductConsumerController {

//	private static String URL = "http://localhost:8001";
	private static String URL = "http://microservice-product";

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/consumer/product/add")
	public boolean add(Product product) {
		return restTemplate.postForObject(URL + "/product/add", product, Boolean.class);
	}

	@RequestMapping(value = "/consumer/product/get/{id}")
	public Product get(@PathVariable Long pid){
		return restTemplate.getForObject(URL + "/product/get" + pid, Product.class);
	}

	@RequestMapping(value = "/consumer/product/list")
	public List<Product> list () {
		return restTemplate.getForObject(URL + "/product/list", List.class);
	}
}
