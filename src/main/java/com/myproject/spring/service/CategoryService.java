package com.myproject.spring.service;

import java.util.List;

import com.myproject.spring.model.ProductCategory;

public interface CategoryService {
	ProductCategory get(String id);

	List<ProductCategory> getAll();

	String save(ProductCategory crop);

	void update(ProductCategory crop, String id);

	void delete(String id);
}
