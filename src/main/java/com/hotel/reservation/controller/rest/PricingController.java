package com.hotel.reservation.controller.rest;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.reservation.service.RoomPricingService;
import com.hotel.reservation.vo.RoomPricingVO;

@RestController
@RequestMapping("api")
public class PricingController {
	
	private final RoomPricingService pricingService;
	
	
	public PricingController(RoomPricingService pricingService) {
		super();
		this.pricingService = pricingService;
	}

	@PostMapping(value = "/room-pricing")
	public ResponseEntity<RoomPricingVO> getRoomPricing(@RequestBody RoomPricingVO roomPricing) {
		BigDecimal roomPrice = pricingService.calculateRoomPrice(roomPricing);
		roomPricing.setPrice(roomPrice);
		return ResponseEntity.ok(roomPricing);
	}

}
