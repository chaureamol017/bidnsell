package com.myproject.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.spring.dao.BidProductDao;
import com.myproject.spring.model.BidProduct;

@Service
public class BidProductServiceImpl implements BidProductService {

	@Autowired
	private BidProductDao bidProductDaoObj;

	@Override
	@Transactional
	public BidProduct get(String id) {
		BidProduct bid = bidProductDaoObj.get(id);
		return bid;
	}

	@Override
	@Transactional
	public List<BidProduct> getAll() {
		List<BidProduct> bids = bidProductDaoObj.getAll();
		return bids;
	}

	@Override
	@Transactional
	public String save(BidProduct bid) {
		return bidProductDaoObj.save(bid);
	}

	@Override
	@Transactional
	public void update(BidProduct bid, String id) {
		bidProductDaoObj.update(bid, id);
	}

	@Override
	@Transactional
	public void delete(String id) {
		bidProductDaoObj.delete(id);
	}
}
