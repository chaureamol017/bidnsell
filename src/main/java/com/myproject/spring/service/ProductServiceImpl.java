package com.myproject.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.spring.dao.ProductDao;
import com.myproject.spring.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDaoObj;

	@Override
	@Transactional
	public Product get(String id) {
		Product product = productDaoObj.get(id);
		return product;
	}

	@Override
	@Transactional
	public List<Product> getAll() {
		List<Product> product = productDaoObj.getAll();
		return product;
	}

	@Override
	@Transactional
	public String save(Product product) {
		return productDaoObj.save(product);
	}

	@Override
	@Transactional
	public void update(Product product, String id) {
		productDaoObj.update(product, id);
	}

	@Override
	@Transactional
	public void delete(String id) {
		productDaoObj.delete(id);

	}

}
