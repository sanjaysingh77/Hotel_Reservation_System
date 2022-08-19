package com.hotel.reservation.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class InquiryFormVO {

	
	private Long id;
	
	@Size(min=3, max=30, message = "Name must be between 3 and 30 characters")
	private String name;
	
	private String email;
	
	@NotNull(message = "Mobile number must be provided")
	private Long  mobNumber;
	
	@NotEmpty(message = "Please add some text")
	private String inquiryText;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getMobNumber() {
		return mobNumber;
	}
	public void setMobNumber(Long mobNumber) {
		this.mobNumber = mobNumber;
	}
	public String getInquiryText() {
		return inquiryText;
	}
	public void setInquiryText(String inquiryText) {
		this.inquiryText = inquiryText;
	}
	
}
