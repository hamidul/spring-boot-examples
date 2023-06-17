package com.example.model;

public class Customer {

	String name;
	String address;
	String customerCode;
	int phoneNumber;

	public Customer(String name, String address, String customerCode, int phoneNumber) {
		super();
		this.name = name;
		this.address = address;
		this.customerCode = customerCode;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
