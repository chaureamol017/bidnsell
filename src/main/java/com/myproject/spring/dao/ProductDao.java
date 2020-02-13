package com.myproject.spring.dao;

import java.util.List;

import com.myproject.spring.model.Product;

public interface ProductDao {

	Product get(String id);

	List<Product> getAll();

	String save(Product product);

	void update(Product product, String id);

	void delete(String id);
}
