package com.myproject.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myproject.spring.model.Product;
import com.myproject.spring.model.ProductCategory;;

@Repository
public class CategoryDaoImpl implements CategoryDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public ProductCategory get(String id) {
		ProductCategory category = (ProductCategory) getCurrentSession().get(ProductCategory.class, id);
		return category;
	}

	@Override
	public List<ProductCategory> getAll() {
		List<ProductCategory> list = getCurrentSession().createQuery(" FROM ProductCategory ").list();
		return list;
	}

	@Override
	public String save(ProductCategory category) {
		getCurrentSession().save(category);
		return category.getCategoryId();
	}

	@Override
	public void update(ProductCategory category, String id) {
		Session sessionObj = getCurrentSession();
		ProductCategory oldCategory = sessionObj.byId(ProductCategory.class).load(id);
		
		oldCategory.setCategoryId(category.getCategoryId());
		oldCategory.setCategoryName(category.getCategoryName());
		oldCategory.setCategoryDescription(category.getCategoryDescription());
		
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
