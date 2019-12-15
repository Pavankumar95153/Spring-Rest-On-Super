package com.example.demo;

public class SuperMarket {

	private String productName;
	private String productCompany;
	
	public void SuperMarket() {
		
	}

	public SuperMarket(String productName, String productCompany) {
		this.productName = productName;
		this.productCompany = productCompany;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCompany() {
		return productCompany;
	}

	public void setProductCompany(String productCompany) {
		this.productCompany = productCompany;
	}
	
}
