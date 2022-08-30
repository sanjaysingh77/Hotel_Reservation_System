package com.hotel.reservation.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.hotel.reservation.utils.Constants;
import com.hotel.reservation.vo.InquiryFormVO;
import com.hotel.reservation.vo.RoomBookingForm;
import com.hotel.reservation.vo.RoomBookingList;

@Controller
public class PageController {
	
	@Autowired
	private RestTemplate restTemplate;
	
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
			try {
				ResponseEntity<RoomBookingList> responseEntity = restTemplate.getForEntity(Constants.bookingBaseUrl+"email?email="+email.get(), RoomBookingList.class);
				model.put("myBookingList", responseEntity.getBody().getBookings());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		model.put("activeLink", "my-bookings");
		return "my-bookings";
	}
	
}
