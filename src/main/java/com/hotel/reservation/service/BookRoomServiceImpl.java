package com.hotel.reservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.reservation.dao.BookRoomDAO;
import com.hotel.reservation.entity.BookRoom;

@Service
public class BookRoomServiceImpl implements BookRoomService{

	@Autowired
	private BookRoomDAO bookRoomDao;
	
	@Override
	@Transactional
	public Long saveBookRoom(BookRoom bookRoom) {
		return bookRoomDao.saveBookRoom(bookRoom);
	}

	@Override
	@Transactional
	public List<BookRoom> getAll() {
		return bookRoomDao.getAll();
	}

	@Override
	@Transactional
	public BookRoom getBookRoomById(Long id) {
		return bookRoomDao.getBookRoomById(id);
	}

	@Override
	@Transactional
	public void deleteBookRoom(Long id) {
		bookRoomDao.deleteBookRoom(id);
	}

	@Override
	@Transactional
	public List<BookRoom> getAllByEmail(String email) {
		return bookRoomDao.getAllByEmail(email);
	}

}
