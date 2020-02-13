package com.myproject.spring.service;

import java.util.List;

import com.myproject.spring.model.Product;

public interface ProductService {
	Product get(String id);

	List<Product> getAll();

	String save(Product crop);

	void update(Product crop, String id);

	void delete(String id);
}
