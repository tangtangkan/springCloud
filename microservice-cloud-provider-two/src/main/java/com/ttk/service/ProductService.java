package com.ttk.service;

import com.ttk.entities.Product;

import java.util.List;

public interface ProductService {
	Product findById(Long pid);

	List<Product> findAll();

	boolean addProduct(Product product);
}
