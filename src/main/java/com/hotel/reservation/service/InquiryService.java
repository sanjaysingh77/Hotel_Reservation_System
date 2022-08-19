package com.hotel.reservation.service;

import java.util.List;

import com.hotel.reservation.entity.Inquiry;

public interface InquiryService {

	Long saveInquiry(Inquiry inquiry);

	List<Inquiry> getAllInquiries();

	Inquiry getInquiryById(Long id);

	void deleteInquiry(Long id);

}
