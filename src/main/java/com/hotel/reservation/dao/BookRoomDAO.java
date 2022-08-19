package com.hotel.reservation.dao;

import java.util.List;

import com.hotel.reservation.entity.BookRoom;


public interface BookRoomDAO {

	Long saveBookRoom(BookRoom bookRoom);
	
	List<BookRoom> getAll();
	
	BookRoom getBookRoomById(Long id);
	
	void deleteBookRoom(Long id);

	List<BookRoom> getAllByEmail(String email);
}
