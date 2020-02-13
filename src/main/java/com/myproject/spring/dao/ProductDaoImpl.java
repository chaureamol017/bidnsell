package com.myproject.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myproject.spring.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Product get(String id) {
		Product product = (Product) getCurrentSession().get(Product.class, id);
		return product;
	}

	@Override
	public List<Product> getAll() {
		List<Product> list = getCurrentSession().createQuery("FROM Product ").list();
		return list;
	}

	@Override
	public String save(Product product) {
		getCurrentSession().save(product);
		return product.getId();
	}

	@Override
	public void update(Product product, String id) {
		Session sessionObj = getCurrentSession();
		Product oldProduct = sessionObj.byId(Product.class).load(id);
		
		oldProduct.setProductCategory(product.getProductCategory());
		oldProduct.setProductName(product.getProductName());
		oldProduct.setDescription(product.getDescription());
		oldProduct.setProductQuantity(product.getProductQuantity());
		oldProduct.setExpectedSellingRate(product.getExpectedSellingRate());
		oldProduct.setActualSellingRate(product.getActualSellingRate());
		oldProduct.setDateToBeAvailable(product.getDateToBeAvailable());
		
		sessionObj.flush();
	}

	@Override
	public void delete(String id) {
		Session sessionObj = getCurrentSession();
		Product oldProduct = sessionObj.byId(Product.class).load(id);
		
		sessionObj.delete(oldProduct);

	}

	private Session getCurrentSession() {
		Session sessionObj = sessionFactory.getCurrentSession();
		
		return sessionObj;
	}
}
