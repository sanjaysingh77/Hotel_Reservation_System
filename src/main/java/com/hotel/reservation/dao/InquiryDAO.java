package com.hotel.reservation.dao;

import java.util.List;

import com.hotel.reservation.entity.Inquiry;


public interface InquiryDAO {

	Long saveInquiry(Inquiry inquiry);
	
	List<Inquiry> getAllInquiries();
	
	Inquiry getInquiryById(Long id);
	
	void deleteInquiry(Long id);
}
