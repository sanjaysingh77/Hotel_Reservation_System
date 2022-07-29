package com.hotel.reservation.vo;

import org.hibernate.validator.constraints.NotEmpty;

public class Address {

	@NotEmpty(message = "Address must be provided")
	private String address1;
	private String address2;
	@NotEmpty(message = "City must be provided")
	private String city;
	@NotEmpty(message = "State must be provided")
	private String state;
	private String zipCode;
	
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	
}
