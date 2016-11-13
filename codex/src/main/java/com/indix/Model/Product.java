package com.indix.Model;

import java.sql.Date;

public class Product {
	private String pId;
	private String title;
	private int upcs;
	private int categoryld;
	private int storeld;
	private String seller;
	private Date date;
	private float price;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String pId, String title, int upcs, int categoryld, int storeld, String seller, Date date,
			float price) {
		this.pId = pId;
		this.title = title;
		this.upcs = upcs;
		this.categoryld = categoryld;
		this.storeld = storeld;
		this.seller = seller;
		this.date = date;
		this.price = price;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getUpcs() {
		return upcs;
	}

	public void setUpcs(int upcs) {
		this.upcs = upcs;
	}

	public int getCategoryld() {
		return categoryld;
	}

	public void setCategoryld(int categoryld) {
		this.categoryld = categoryld;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public int getStoreld() {
		return storeld;
	}

	public void setStoreld(int storeld) {
		this.storeld = storeld;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
