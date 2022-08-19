package com.hotel.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hotel.reservation.mapper.BookRoomMapper;
import com.hotel.reservation.mapper.InquiryMapper;
import com.hotel.reservation.service.BookRoomService;
import com.hotel.reservation.service.InquiryService;
import com.hotel.reservation.vo.InquiryFormVO;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private InquiryService inquiryService;
	
	@Autowired
	private BookRoomService bookingService;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		model.put("activeLink", "home");
		return "admin/admin_home";
	}
	
	@RequestMapping(path = "/inquiries", method = RequestMethod.GET)
	public String inquiry(ModelMap model) {
		List<InquiryFormVO> voList = InquiryMapper.entityListToVoList(inquiryService.getAllInquiries());

		model.put("activeLink", "inquiries");
		model.put("inquiriesList", voList);
		return "admin/admin_inquiry";
	}
	
	@RequestMapping(path = "/bookings", method = RequestMethod.GET)
	public String bookRoom(ModelMap model) {
		model.put("activeLink", "bookings");
		model.put("bookingsList", BookRoomMapper.entityListToVoList(bookingService.getAll()));
		return "admin/admin_bookings";
	}
	
}
