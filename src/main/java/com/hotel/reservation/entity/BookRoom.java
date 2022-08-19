package com.hotel.reservation.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "book_room")
public class BookRoom {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long bookingId;
	private String firstName;
	private String lastName;
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="address_id")
	private Address address;
	private Long mobNumber;
	private String email;
	private Date checkIn;
	private Date checkOut;
	private String roomPreference = "standard";
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
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
