package com.capgemini.flightmanagementsystem.service;

import java.util.List;

import com.capgemini.flightmanagementsystem.bean.FlightBooking;
import com.capgemini.flightmanagementsystem.bean.FlightInformation;


public interface FlightService {

	public FlightInformation getFlight(String flightNumber);

	
	public List<FlightInformation> search(String departureCity, String arrivalCity, String departureDate);

	public List<FlightInformation> getAllFlights();

	public boolean bookFlight(FlightBooking flightBooking);

	public List<FlightBooking> getAllBooking(String userId);
	
	public boolean deleteBooking(String bookingId);
}
