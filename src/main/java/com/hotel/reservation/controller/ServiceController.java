package com.hotel.reservation.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hotel.reservation.service.TestService;
import com.hotel.reservation.utils.DateUtil;
import com.hotel.reservation.vo.InquiryFormVO;
import com.hotel.reservation.vo.RoomBookingForm;

@Controller
public class ServiceController {
	
	@Autowired
	private TestService testService;

	
	@RequestMapping(path = "/postInquiry", method = RequestMethod.POST)
	public String createInquiry(@Valid @ModelAttribute("inquiryForm")InquiryFormVO inquiryForm, 
		      BindingResult result, ModelMap model) {
		model.put("activeLink", "inquiry");
		if(result.hasErrors()) {
			return "inquiry";
		}
		//Do the saving part here
		testService.test();
		
		model.put("inquiryForm", inquiryForm);
		return "inquiry-success";
	}
	
	@RequestMapping(path = "/bookRoom", method = RequestMethod.POST)
	public String bookRoom(@Valid @ModelAttribute("roomBookingForm")RoomBookingForm roomBookingForm, 
		      BindingResult result, ModelMap model) {
		model.put("activeLink", "book-room");
		if(result.hasErrors()) {
			return "book-room";
		}
		//Do the saving part here
		
		model.put("roomBookingForm", roomBookingForm);
		model.put("numOfDays", DateUtil.getNumberOfDays(roomBookingForm.getCheckIn(), roomBookingForm.getCheckOut()));
		return "book-room-success";
	}
	
}
