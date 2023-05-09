package com.transaction.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.transaction.dto.FlightBookingAcknowledgement;
import com.transaction.dto.FlightBookingRequest;
import com.transaction.entity.PassengerInfo;
import com.transaction.entity.PaymentInfo;
import com.transaction.repository.PassengerInfoRepo;
import com.transaction.repository.PaymentInfoRepo;
import com.transaction.utils.PaymentUtils;

@Service
public class FlightBookingService {

	@Autowired
	private PassengerInfoRepo passengerInfoRepo;
	
	@Autowired
	private PaymentInfoRepo paymentInfoRepo;
	
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
	public FlightBookingAcknowledgement bookingFlightTicket(FlightBookingRequest request) {
		
		
		PassengerInfo passengerInfo =request.getPassengerInfo();
		passengerInfo= passengerInfoRepo.save(passengerInfo);
		
		PaymentInfo paymentInfo=request.getPaymentInfo();
		
	    PaymentUtils.validatecreditLimit(paymentInfo.getAccountNo(),passengerInfo.getFare());
	    
	    paymentInfo.setPassengerId(passengerInfo.getPid());
	    
	    paymentInfo.setAmount(passengerInfo.getFare());
	    
	    paymentInfoRepo.save(paymentInfo);
	    
		
		return new FlightBookingAcknowledgement("SUCCESS",passengerInfo.getFare(),UUID.randomUUID().toString().split("-")[0],passengerInfo);
	}
}
