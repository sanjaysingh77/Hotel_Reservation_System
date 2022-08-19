package com.hotel.reservation.service;

import java.util.List;

import com.hotel.reservation.entity.BookRoom;

public interface BookRoomService {

	Long saveBookRoom(BookRoom bookRoom);

	List<BookRoom> getAll();

	BookRoom getBookRoomById(Long id);

	void deleteBookRoom(Long id);
	
	List<BookRoom> getAllByEmail(String email);

}
