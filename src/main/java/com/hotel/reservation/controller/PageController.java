package com.hotel.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hotel.reservation.vo.InquiryFormVO;
import com.hotel.reservation.vo.RoomBookingForm;

@Controller
public class PageController {
	
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
}
