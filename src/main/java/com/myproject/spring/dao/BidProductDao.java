package com.myproject.spring.dao;

import java.util.List;

import com.myproject.spring.model.BidProduct;

public interface BidProductDao {

	BidProduct get(String id);

	List<BidProduct> getAll();

	String save(BidProduct product);

	void update(BidProduct product, String id);

	void delete(String id);
}
