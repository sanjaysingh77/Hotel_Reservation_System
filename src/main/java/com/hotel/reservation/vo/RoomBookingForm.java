package com.hotel.reservation.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class RoomBookingForm {

	private Long bookingId;
	@Size(min=3, max=30, message = "First name must be between 3 and 30 characters")
	private String firstName;
	private String lastName;
	@Valid
	private AddressVO address;
	@NotNull(message = "Mobile number must be provided")
	private Long mobNumber;
	@Email(regexp = ".+[@].+[\\.].+", message = "Valid email required")
	private String email;
	@DateTimeFormat(iso = ISO.DATE)
	@NotNull(message = "Check in date must be provided")
	private Date checkIn;
	@DateTimeFormat(iso = ISO.DATE)
	@NotNull(message = "Check out date must be provided")
	private Date checkOut;
	private String roomPreference = "standard";
	@NotNull(message = "Please select number of guests")
	private Integer numOfAdults;
	private Integer children;
	private BigDecimal price;
	
	public Long getBookingId() {
		return bookingId;
	}
	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
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
	public AddressVO getAddress() {
		return address;
	}
	public void setAddress(AddressVO address) {
		this.address = address;
	}
	public Long getMobNumber() {
		return mobNumber;
	}
	public void setMobNumber(Long mobNumber) {
		this.mobNumber = mobNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}
	public Date getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}
	public String getRoomPreference() {
		return roomPreference;
	}
	public void setRoomPreference(String roomPreference) {
		this.roomPreference = roomPreference;
	}
	public Integer getNumOfAdults() {
		return numOfAdults;
	}
	public void setNumOfAdults(Integer numOfAdults) {
		this.numOfAdults = numOfAdults;
	}
	public Integer getChildren() {
		return children;
	}
	public void setChildren(Integer children) {
		this.children = children;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
}
