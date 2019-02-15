package com.training.bean;

public class TC077_LoginBean1{
	private String memlogin;
	private String amount;
	private String description;

	public TC077_LoginBean1() {
	}

	public TC077_LoginBean1(String memlogin, String amount,String description) {
		super();
		
		this.memlogin = memlogin;
		this.amount = amount;
		this.description=description;
	}

	public String getmemlogin() {
		return memlogin;
	}

	public void setmemlogin(String memlogin) {
		this.memlogin = memlogin;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "LoginBean [memlogin=" + memlogin + ", amount=" + amount + ", description=" + description + "]";
	}

}

