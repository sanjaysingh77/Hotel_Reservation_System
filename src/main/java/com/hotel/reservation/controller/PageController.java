package com.hotel.reservation.controller;

import java.sql.SQLException;
import java.util.Optional;

import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotel.reservation.mapper.BookRoomMapper;
import com.hotel.reservation.service.BookRoomService;
import com.hotel.reservation.vo.InquiryFormVO;
import com.hotel.reservation.vo.RoomBookingForm;

@Controller
public class PageController {
	
	@Autowired
	private BookRoomService bookRoomService;
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		model.put("activeLink", "home");
		return "home";
	}

	@RequestMapping(path = "/about", method = RequestMethod.GET)
	public String about(ModelMap model) {
		model.put("activeLink", "about");
		return "about";
	}
	
	@RequestMapping(path = "/inquiry", method = RequestMethod.GET)
	public String inquiry(ModelMap model) {
		model.put("activeLink", "inquiry");
		model.put("inquiryForm", new InquiryFormVO());
		return "inquiry";
	}
	
	@RequestMapping(path = "/book-room", method = RequestMethod.GET)
	public String bookRoom(ModelMap model) {
		model.put("activeLink", "book-room");
		model.put("roomBookingForm", new RoomBookingForm());
		return "book-room";
	}
	
	@RequestMapping(path = "/my-bookings", method = {RequestMethod.GET, RequestMethod.POST})
	public String myBookings(@RequestParam("email") Optional<String> email, ModelMap model) {
		
		if(email.isPresent()) {
			model.put("searchEmail", email.get());
			model.put("myBookingList", BookRoomMapper.entityListToVoList(bookRoomService.getAllByEmail(email.get())));
		}
		model.put("activeLink", "my-bookings");
		return "my-bookings";
	}
	
}
