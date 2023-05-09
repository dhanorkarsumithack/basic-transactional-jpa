package com.transaction.dto;

import com.transaction.entity.PassengerInfo;
import com.transaction.entity.PaymentInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingRequest {

	private PassengerInfo passengerInfo;
	
	private PaymentInfo paymentInfo;
}
