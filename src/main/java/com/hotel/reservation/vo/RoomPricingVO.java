package com.hotel.reservation.vo;

import java.math.BigDecimal;

public class RoomPricingVO {
	private Long bookingId;
	private String roomPref;
	private Integer adults;
	private Integer children;
	private Long numOfDays;
	private BigDecimal price;
	private String email;
	
	
	public Long getBookingId() {
		return bookingId;
	}
	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}
	public String getRoomPref() {
		return roomPref;
	}
	public void setRoomPref(String roomPref) {
		this.roomPref = roomPref;
	}
	public Integer getAdults() {
		return adults;
	}
	public void setAdults(Integer adults) {
		this.adults = adults;
	}
	public Integer getChildren() {
		return children;
	}
	public void setChildren(Integer children) {
		this.children = children;
	}
	public Long getNumOfDays() {
		return numOfDays;
	}
	public void setNumOfDays(Long numOfDays) {
		this.numOfDays = numOfDays;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "RoomPricingVO [roomPref=" + roomPref + ", adults=" + adults + ", children=" + children + ", numOfDays="
				+ numOfDays + ", price=" + price + "]";
	}
	
	
 }
