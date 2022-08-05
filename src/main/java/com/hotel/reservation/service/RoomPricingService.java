package com.hotel.reservation.service;

import java.math.BigDecimal;

import com.hotel.reservation.vo.RoomPricingVO;

public interface RoomPricingService {
	
	BigDecimal calculateRoomPrice(RoomPricingVO roomPricing);
}
