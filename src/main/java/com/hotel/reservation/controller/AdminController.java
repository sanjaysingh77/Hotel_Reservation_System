package com.hotel.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.hotel.reservation.utils.Constants;
import com.hotel.reservation.vo.InquiryFormVO;
import com.hotel.reservation.vo.InquiryList;
import com.hotel.reservation.vo.RoomBookingList;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		model.put("activeLink", "home");
		return "admin/admin_home";
	}

	@RequestMapping(path = "/inquiries", method = RequestMethod.GET)
	public String inquiry(ModelMap model) {
		model.put("activeLink", "inquiries");
		try {
			List<InquiryFormVO> voList = restTemplate.getForEntity(Constants.inquiryBaseUrl, InquiryList.class)
					.getBody().getInquiries();
			model.put("inquiriesList", voList);
			return "admin/admin_inquiry";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	@RequestMapping(path = "/bookings", method = RequestMethod.GET)
	public String bookRoom(ModelMap model) {
		model.put("activeLink", "bookings");
		try {
			ResponseEntity<RoomBookingList> responseEntity = restTemplate.getForEntity(Constants.bookingBaseUrl,
					RoomBookingList.class);
			model.put("bookingsList", responseEntity.getBody().getBookings());
			return "admin/admin_bookings";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

}
