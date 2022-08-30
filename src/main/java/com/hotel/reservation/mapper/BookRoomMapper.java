package com.hotel.reservation.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.hotel.reservation.entity.Address;
import com.hotel.reservation.entity.BookRoom;
import com.hotel.reservation.utils.DateUtil;
import com.hotel.reservation.vo.AddressVO;
import com.hotel.reservation.vo.RoomBookingForm;
import com.hotel.reservation.vo.RoomPricingVO;

public class BookRoomMapper {
	
	public static BookRoom voToEntity(RoomBookingForm vo) {
		BookRoom entity = new BookRoom();
		entity.setBookingId(vo.getBookingId());
		entity.setAddress(addressVoToAddress(vo.getAddress()));
		entity.setEmail(vo.getEmail());
		entity.setMobNumber(vo.getMobNumber());
		entity.setFirstName(vo.getFirstName());
		entity.setLastName(vo.getLastName());
		entity.setChildren(vo.getChildren());
		entity.setNumOfAdults(vo.getNumOfAdults());
		entity.setCheckIn(vo.getCheckIn());
		entity.setCheckOut(vo.getCheckOut());
		entity.setRoomPreference(vo.getRoomPreference());
		entity.setPrice(vo.getPrice());
		return entity;		
	}
	
	public static Address addressVoToAddress(AddressVO vo) {
		Address address = new Address();
		address.setAddressId(vo.getAddressId());		
		address.setAddress1(vo.getAddress1());
		address.setAddress2(vo.getAddress2());
		address.setCity(vo.getCity());
		address.setState(vo.getState());
		address.setZipCode(vo.getZipCode());
		return address;
	}
	
	public static RoomBookingForm entityToVo(BookRoom entity) {
		RoomBookingForm vo = new RoomBookingForm();
		vo.setBookingId(entity.getBookingId());
		vo.setAddress(addressToAddressVO(entity.getAddress()));
		vo.setEmail(entity.getEmail());
		vo.setMobNumber(entity.getMobNumber());
		vo.setFirstName(entity.getFirstName());
		vo.setLastName(entity.getLastName());
		vo.setChildren(entity.getChildren());
		vo.setNumOfAdults(entity.getNumOfAdults());
		vo.setCheckIn(entity.getCheckIn());
		vo.setCheckOut(entity.getCheckOut());
		vo.setRoomPreference(entity.getRoomPreference());
		vo.setPrice(entity.getPrice());
		return vo;	
	} 
	
	public static AddressVO addressToAddressVO(Address entity) {
		AddressVO vo = new AddressVO();
		vo.setAddressId(entity.getAddressId());		
		vo.setAddress1(entity.getAddress1());
		vo.setAddress2(entity.getAddress2());
		vo.setCity(entity.getCity());
		vo.setState(entity.getState());
		vo.setZipCode(entity.getZipCode());
		return vo;
	}

	public static RoomPricingVO pricingVoFromEntity(BookRoom bookRoom) {
		RoomPricingVO vo = new RoomPricingVO();
		vo.setBookingId(bookRoom.getBookingId());
		vo.setRoomPref(bookRoom.getRoomPreference());
		vo.setNumOfDays(DateUtil.getNumberOfDays(bookRoom.getCheckIn(), bookRoom.getCheckOut()));
		vo.setAdults(bookRoom.getNumOfAdults());
		vo.setChildren(bookRoom.getChildren());
		vo.setEmail(bookRoom.getEmail());
		return vo;
	}
	
	public static List<RoomBookingForm> entityListToVoList(List<BookRoom> entityList){
		return entityList.stream().map(entity -> entityToVo(entity)).collect(Collectors.toList());
	}
	
	public static List<BookRoom> voListToEntityList(List<RoomBookingForm> voList){
		return voList.stream().map(vo -> voToEntity(vo)).collect(Collectors.toList());
	}
}
