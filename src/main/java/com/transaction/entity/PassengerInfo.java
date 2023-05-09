package com.transaction.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "passenger_info")
public class PassengerInfo {

	@Id
	@GeneratedValue
	private Long pid;
	
	private String name;
	
	private String email;
	
	private String source;
	
	private String destination;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date travelDate ;
	
	private String pickupTime;
	private String arrivalTime;
	private Double fare;//fee paid by passenger for airtransport
}
