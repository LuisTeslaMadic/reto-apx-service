package com.entelgy.app.models.entity;

import java.io.Serializable;
import java.util.List;

public class UserModalData implements Serializable{

	
	private int page;
	private int per_page;
	private int total;
	private List<User> data;
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPer_page() {
		return per_page;
	}

	public void setPer_page(int per_page) {
		this.per_page = per_page;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<User> getData() {
		return data;
	}

	public void setData(List<User> data) {
		this.data = data;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -564913131151123680L;

}
