package com.myproject.spring.dao;

import java.util.List;

import com.myproject.spring.model.ProductCategory;

public interface CategoryDao {

	ProductCategory get(String id);

	List<ProductCategory> getAll();

	String save(ProductCategory productCategory);

	void update(ProductCategory productCategory, String id);

	void delete(String id);
}
