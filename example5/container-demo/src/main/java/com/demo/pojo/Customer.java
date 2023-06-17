package com.demo.pojo;

public class Customer {

	private String firstName;
	private String lastName;
	private String address;
	private int pincode;
	
	public Customer() {
		
	}
	

	public Customer(String firstName, String lastName, String address, int pincode) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.pincode = pincode;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

}
