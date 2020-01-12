package com.ttk.controller;

import com.ttk.entities.Product;
import com.ttk.service.ProductClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductConsumerController {

	@Autowired
	ProductClientService productClientService;

	@RequestMapping(value = "/consumer/product/add")
	public boolean add(Product product) {
		return productClientService.add(product);
	}

	@RequestMapping(value = "/consumer/product/get/{id}")
	public Product get(@PathVariable(value = "id") Long id){
		return productClientService.findById(id);
	}

	@RequestMapping(value = "/consumer/product/list")
	public List<Product> list () {
		return productClientService.list();
	}
}
