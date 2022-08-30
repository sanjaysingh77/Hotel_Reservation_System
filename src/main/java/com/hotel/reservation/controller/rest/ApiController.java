package com.hotel.reservation.controller.rest;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.reservation.entity.BookRoom;
import com.hotel.reservation.mapper.BookRoomMapper;
import com.hotel.reservation.service.BookRoomService;
import com.hotel.reservation.service.InquiryService;
import com.hotel.reservation.service.RoomPricingService;
import com.hotel.reservation.vo.RoomPricingVO;

@RestController
@RequestMapping("api")
public class ApiController {
	
//	@Autowired
	private RoomPricingService pricingService;
//	@Autowired
	private BookRoomService bookRoomService;
//	@Autowired
	private InquiryService inquiryService;
	
	@GetMapping(value = "/room-pricing/{id}")
	public ResponseEntity<RoomPricingVO> getRoomDetail(@PathVariable("id") Long bookingId) {
		BookRoom bookRoom = bookRoomService.getBookRoomById(bookingId);
		RoomPricingVO roomPricing = BookRoomMapper.pricingVoFromEntity(bookRoom);
		BigDecimal roomPrice = pricingService.calculateRoomPrice(roomPricing);
		roomPricing.setPrice(roomPrice);
		return ResponseEntity.ok(roomPricing);
	}

	@PostMapping(value = "/confirm-booking")
	public ResponseEntity<Void> getRoomPricing(@RequestBody RoomPricingVO roomPricing) {
		BookRoom bookRoom = bookRoomService.getBookRoomById(roomPricing.getBookingId());
		bookRoom.setPrice(roomPricing.getPrice());
		bookRoomService.saveBookRoom(bookRoom);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping(value = "/delete-inquiry/{id}")
	public ResponseEntity<Void> deleteInquiry(@PathVariable("id") Long inquiryId) {
		inquiryService.deleteInquiry(inquiryId);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping(value = "/delete-booking/{id}")
	public ResponseEntity<Void> deleteBooking(@PathVariable("id") Long bookingId) {
		bookRoomService.deleteBookRoom(bookingId);
		return ResponseEntity.ok().build();
	}

}
