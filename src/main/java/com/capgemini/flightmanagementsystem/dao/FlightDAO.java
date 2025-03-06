package com.capgemini.flightmanagementsystem.dao;

import java.util.List;

import com.capgemini.flightmanagementsystem.bean.FlightInformation;



public interface FlightDAO {

	public FlightInformation getFlight(String flightNumber);

	public List<FlightInformation> search(String departureCity, String arrivalCity, String departureDate);
	
	public List<FlightInformation> getAllFlights();
	
	
	
	

}
