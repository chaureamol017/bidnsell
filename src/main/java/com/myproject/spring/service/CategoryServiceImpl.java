package com.myproject.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.spring.dao.CategoryDao;
import com.myproject.spring.model.ProductCategory;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDaoObj;

	@Override
	@Transactional
	public ProductCategory get(String id) {
		ProductCategory category = categoryDaoObj.get(id);
		return category;
	}

	@Override
	@Transactional
	public List<ProductCategory> getAll() {
		List<ProductCategory> categories = categoryDaoObj.getAll();
		return categories;
	}

	@Override
	@Transactional
	public String save(ProductCategory category) {
		return categoryDaoObj.save(category);
	}

	@Override
	@Transactional
	public void update(ProductCategory category, String id) {
		categoryDaoObj.update(category, id);
	}

	@Override
	@Transactional
	public void delete(String id) {
		categoryDaoObj.delete(id);
	}
}
