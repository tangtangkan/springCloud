package com.ttk.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.ttk.entities.Product;
import com.ttk.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/product/add", method = RequestMethod.POST)
	public boolean add(@RequestBody Product product) {
		return productService.addProduct(product);
	}

	@HystrixCommand(fallbackMethod = "getFallback")
	@RequestMapping(value = "/product/findById/{id}", method = RequestMethod.GET)
	public Product findById(@PathVariable("id") Long id) {
		Product product = productService.findById(id);
		if (product == null) {
			throw new RuntimeException("无效ID" + id + "无效");
		}
		return product;
	}

	@RequestMapping(value = "/product/list", method = RequestMethod.GET)
	public List<Product> list() {
		return productService.findAll();
	}

	public Product getFallback(@PathVariable("id") Long id) {
		return new Product(id, "ID" + id + "无效，@HystrixCommand", "无法找到对应数据库");
	}
}
