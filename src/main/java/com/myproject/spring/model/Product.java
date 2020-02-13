package com.myproject.spring.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private String productCategory;
	private String productName;
	private String description;
	private int productQuantity;
	private int expectedSellingRate;
	private int actualSellingRate;
	private Date dateToBeAvailable;
	private boolean isSold;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public int getExpectedSellingRate() {
		return expectedSellingRate;
	}

	public void setExpectedSellingRate(int expectedSellingRate) {
		this.expectedSellingRate = expectedSellingRate;
	}

	public int getActualSellingRate() {
		return actualSellingRate;
	}

	public void setActualSellingRate(int actualSellingRate) {
		this.actualSellingRate = actualSellingRate;
	}

	public Date getDateToBeAvailable() {
		return dateToBeAvailable;
	}

	public void setDateToBeAvailable(Date dateToBeAvailable) {
		this.dateToBeAvailable = dateToBeAvailable;
	}

	public boolean isSold() {
		return isSold;
	}

	public void setSold(boolean isSold) {
		this.isSold = isSold;
	}

	@Override
	public String toString() {
		return "Product [productCategory=" + productCategory + ", productName=" + productName + ", description="
				+ description + ", productQuantity=" + productQuantity + ", expectedSellingRate=" + expectedSellingRate
				+ ", actualSellingRate=" + actualSellingRate + ", dateToBeAvailable=" + dateToBeAvailable + ", isSold="
				+ isSold + "]";
	}
}
