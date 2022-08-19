package com.hotel.reservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.reservation.dao.InquiryDAO;
import com.hotel.reservation.entity.Inquiry;

@Service
public class InquiryServiceImpl implements InquiryService{

	@Autowired
	private InquiryDAO inquiryDao;
	
	@Override
	@Transactional
	public Long saveInquiry(Inquiry inquiry) {
		return inquiryDao.saveInquiry(inquiry);
	}

	@Override
	@Transactional
	public List<Inquiry> getAllInquiries() {
		return inquiryDao.getAllInquiries();
	}

	@Override
	@Transactional
	public Inquiry getInquiryById(Long id) {
		return inquiryDao.getInquiryById(id);
	}

	@Override
	@Transactional
	public void deleteInquiry(Long id) {
		inquiryDao.deleteInquiry(id);
	}

}
