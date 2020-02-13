package com.myproject.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myproject.spring.model.BidProduct;

@Repository
public class BidProductDaoImpl implements BidProductDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public BidProduct get(String id) {
		BidProduct bid = (BidProduct) getCurrentSession().get(BidProduct.class, id);
		return bid;
	}

	@Override
	public List<BidProduct> getAll() {
		List<BidProduct> list = getCurrentSession().createQuery("FROM BidProduct ").list();
		return list;
	}

	@Override
	public String save(BidProduct bid) {
		getCurrentSession().save(bid);
		return bid.getId();
	}

	@Override
	public void update(BidProduct bid, String id) {
		Session sessionObj = getCurrentSession();
		BidProduct oldBid = sessionObj.byId(BidProduct.class).load(id);
		
		oldBid.setBiddingRate(bid.getBiddingRate());

		sessionObj.flush();
	}

	@Override
	public void delete(String id) {
		Session sessionObj = getCurrentSession();
		BidProduct oldProduct = sessionObj.byId(BidProduct.class).load(id);
		
		sessionObj.delete(oldProduct);
	}

	private Session getCurrentSession() {
		Session sessionObj = sessionFactory.getCurrentSession();
		
		return sessionObj;
	}
}
