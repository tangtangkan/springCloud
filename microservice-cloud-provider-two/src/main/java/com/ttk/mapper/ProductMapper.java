package com.ttk.mapper;

import com.ttk.entities.Product;

import java.util.List;

//@Mapper	在启动类中使用@MapperScan
public interface ProductMapper {
	Product findById(Long pid);

	List<Product> findAll();

	boolean addProduct(Product product);
}
