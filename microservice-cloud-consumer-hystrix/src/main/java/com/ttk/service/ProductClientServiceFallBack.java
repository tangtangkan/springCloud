package com.ttk.service;

import com.ttk.entities.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductClientServiceFallBack implements ProductClientService {
	@Override
	public boolean add(Product product) {
		return false;
	}

	@Override
	public Product findById(Long id) {
		return new Product(id, "ID=" + id + "无数据", "数据库无数据");
	}

	@Override
	public List<Product> list() {
		return null;
	}
}
