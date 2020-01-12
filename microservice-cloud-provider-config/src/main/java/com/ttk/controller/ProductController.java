package com.ttk.controller;

import com.ttk.entities.Product;
import com.ttk.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RefreshScope
@RestController
public class ProductController {

	@Value("${emp.name}")
	private String name;

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/product/add", method = RequestMethod.POST)
	public boolean add(@RequestBody Product product) {
		return productService.addProduct(product);
	}

	@RequestMapping(value = "/product/findById/{id}", method = RequestMethod.GET)
	public Product findById(@PathVariable("id") Long id) {
		return productService.findById(id);
	}

	@RequestMapping(value = "/product/list", method = RequestMethod.GET)
	public List<Product> list() {
		return productService.findAll();
	}

	@GetMapping(value = "hello")
	public String hello() {
		return "你好，" + name;
	}
}
