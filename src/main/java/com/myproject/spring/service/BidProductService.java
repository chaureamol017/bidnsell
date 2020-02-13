package com.myproject.spring.service;

import java.util.List;

import com.myproject.spring.model.BidProduct;

public interface BidProductService {
	BidProduct get(String id);

	List<BidProduct> getAll();

	String save(BidProduct bid);

	void update(BidProduct bid, String id);

	void delete(String id);
}
