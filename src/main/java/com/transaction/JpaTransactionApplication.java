package com.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.transaction.dto.FlightBookingAcknowledgement;
import com.transaction.dto.FlightBookingRequest;
import com.transaction.service.FlightBookingService;

@SpringBootApplication
@RestController
@EnableTransactionManagement
public class JpaTransactionApplication {
	
	@Autowired
	private FlightBookingService service;
	
	@PostMapping("/bookingFlightTicket")
	public FlightBookingAcknowledgement bookFlightTicket(@RequestBody FlightBookingRequest request) {
		
		return service.bookingFlightTicket(request);
		
	}

	public static void main(String[] args) {
		SpringApplication.run(JpaTransactionApplication.class, args);
	}

}
