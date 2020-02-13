package com.myproject.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "bid_product")
public class BidProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private String productId;
	private String farmer;
	private String buyer;
	private int productQuantity;
	private int biddingRate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getFarmer() {
		return farmer;
	}

	public void setFarmer(String farmer) {
		this.farmer = farmer;
	}

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public int getBiddingRate() {
		return biddingRate;
	}

	public void setBiddingRate(int biddingRate) {
		this.biddingRate = biddingRate;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", farmer=" + farmer + ", buyer=" + buyer + ", productQuantity="
				+ productQuantity + ", biddingRate=" + biddingRate + "]";
	}
}
