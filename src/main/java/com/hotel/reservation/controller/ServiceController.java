package com.hotel.reservation.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotel.reservation.entity.BookRoom;
import com.hotel.reservation.entity.Inquiry;
import com.hotel.reservation.mapper.BookRoomMapper;
import com.hotel.reservation.mapper.InquiryMapper;
import com.hotel.reservation.service.BookRoomService;
import com.hotel.reservation.service.InquiryService;
import com.hotel.reservation.vo.InquiryFormVO;
import com.hotel.reservation.vo.RoomBookingForm;

@Controller
public class ServiceController {
	
	@Autowired
	private InquiryService inquiryService;
	
	@Autowired
	private BookRoomService bookRoomService;

	
	@RequestMapping(path = "/postInquiry", method = RequestMethod.POST)
	public String createInquiry(@Valid @ModelAttribute("inquiryForm")InquiryFormVO inquiryForm, 
		      BindingResult result, ModelMap model) {
		model.put("activeLink", "inquiry");
		if(result.hasErrors()) {
			return "inquiry";
		}
		Long saveId = inquiryService.saveInquiry(InquiryMapper.voToEntity(inquiryForm));
		Inquiry inquiry = inquiryService.getInquiryById(saveId);
		
		model.put("inquiryForm", InquiryMapper.entityToVo(inquiry));
		return "inquiry-success";
	}
	
	@RequestMapping(path = "/bookRoom", method = RequestMethod.POST)
	public String bookRoom(@Valid @ModelAttribute("roomBookingForm")RoomBookingForm roomBookingForm, 
		      BindingResult result, ModelMap model) {
		model.put("activeLink", "book-room");
		if(result.hasErrors()) {
			return "book-room";
		}
		Long saveId = bookRoomService.saveBookRoom(BookRoomMapper.voToEntity(roomBookingForm));
		BookRoom bookRoomById = bookRoomService.getBookRoomById(saveId);
		
		model.put("roomBookingForm", BookRoomMapper.entityToVo(bookRoomById));		
		return "book-room-success";
	}
	
	@RequestMapping(path = "/edit-booking", method = RequestMethod.POST)
	public String editBooking(@RequestParam("bookingId") Long bookingId, ModelMap model) {
		model.put("activeLink", "book-room");
		BookRoom bookRoom = bookRoomService.getBookRoomById(bookingId); 
		RoomBookingForm roomBookingForm = new RoomBookingForm();
		if(bookRoom !=null) {
			roomBookingForm = BookRoomMapper.entityToVo(bookRoom);
		}
		model.put("roomBookingForm", roomBookingForm);
		return "book-room";
	}
	
	@RequestMapping(path = "/delete-booking", method = RequestMethod.POST)
	public String deleteBooking(@RequestParam("bookingId") Long bookingId, @RequestParam("email") String email, ModelMap model) {
		model.put("activeLink", "my-bookings");
		bookRoomService.deleteBookRoom(bookingId);
		model.put("searchEmail", email);
		model.put("myBookingList", BookRoomMapper.entityListToVoList(bookRoomService.getAllByEmail(email)));
		return "my-bookings";
	}
	
}
