package com.sid.spring.bean;

public class CustomerDTO {

	private Integer customerDimKey;
	private String customerSk;
	private String customerGender;
	private String customerCardRK;
	private String customerPostal;

	public Integer getCustomerDimKey() {
		return customerDimKey;
	}

	public void setCustomerDimKey(Integer customerDimKey) {
		this.customerDimKey = customerDimKey;
	}

	public String getCustomerSk() {
		return customerSk;
	}

	public void setCustomerSk(String customerSk) {
		this.customerSk = customerSk;
	}

	public String getCustomerGender() {
		return customerGender;
	}

	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}

	public String getCustomerCardRK() {
		return customerCardRK;
	}

	public void setCustomerCardRK(String customerCardRK) {
		this.customerCardRK = customerCardRK;
	}

	public String getCustomerPostal() {
		return customerPostal;
	}

	public void setCustomerPostal(String customerPostal) {
		this.customerPostal = customerPostal;
	}

	@Override
	public String toString() {
		return "CustomerDTO [customerDimKey=" + customerDimKey + ", customerSk=" + customerSk + ", customerGender="
				+ customerGender + ", customerCardRK=" + customerCardRK + ", customerPostal=" + customerPostal + "]";
	}

}