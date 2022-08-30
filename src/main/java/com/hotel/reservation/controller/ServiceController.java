package com.hotel.reservation.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.hotel.reservation.utils.Constants;
import com.hotel.reservation.vo.InquiryFormVO;
import com.hotel.reservation.vo.RoomBookingForm;
import com.hotel.reservation.vo.RoomBookingList;

@Controller
public class ServiceController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(path = "/postInquiry", method = RequestMethod.POST)
	public String createInquiry(@Valid @ModelAttribute("inquiryForm")InquiryFormVO inquiryForm, 
		      BindingResult result, ModelMap model) {
		model.put("activeLink", "inquiry");
		if(result.hasErrors()) {
			return "inquiry";
		}
		
		try {
			HttpEntity<InquiryFormVO> request = new HttpEntity<>(inquiryForm);
			InquiryFormVO inquiry = restTemplate.postForObject(Constants.inquiryBaseUrl, request, InquiryFormVO.class);
			model.put("inquiryForm", inquiry);
			return "inquiry-success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
	}
	
	@RequestMapping(path = "/bookRoom", method = RequestMethod.POST)
	public String bookRoom(@Valid @ModelAttribute("roomBookingForm")RoomBookingForm roomBookingForm, 
		      BindingResult result, ModelMap model) {
		model.put("activeLink", "book-room");
		if(result.hasErrors()) {
			return "book-room";
		}
		try {
			HttpEntity<RoomBookingForm> request = new HttpEntity<>(roomBookingForm);
			RoomBookingForm booking = restTemplate.postForObject(Constants.bookingBaseUrl, request, RoomBookingForm.class);
			model.put("roomBookingForm", booking);
			return "book-room-success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
	}
	
	@RequestMapping(path = "/edit-booking", method = RequestMethod.POST)
	public String editBooking(@RequestParam("bookingId") Long bookingId, ModelMap model) {
		model.put("activeLink", "book-room");
		try {
			ResponseEntity<RoomBookingForm> responseEntity = restTemplate.getForEntity(Constants.bookingBaseUrl+bookingId, RoomBookingForm.class);
			model.put("roomBookingForm", responseEntity.getBody());
			return "book-room";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	@RequestMapping(path = "/delete-booking", method = RequestMethod.POST)
	public String deleteBooking(@RequestParam("bookingId") Long bookingId, @RequestParam("email") String email, ModelMap model) {
		model.put("activeLink", "my-bookings");
		try {
			restTemplate.delete(Constants.bookingBaseUrl+bookingId);
			ResponseEntity<RoomBookingList> responseEntity = restTemplate.getForEntity(Constants.bookingBaseUrl+"email?email="+email, RoomBookingList.class);
			model.put("searchEmail", email);
			model.put("myBookingList", responseEntity.getBody().getBookings());
			return "my-bookings";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
}
