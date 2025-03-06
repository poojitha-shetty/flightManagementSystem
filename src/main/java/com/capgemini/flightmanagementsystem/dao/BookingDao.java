package com.capgemini.flightmanagementsystem.dao;

import java.util.List;

import com.capgemini.flightmanagementsystem.bean.FlightBooking;

public interface BookingDao {
	
	public boolean bookFlight(FlightBooking flightBooking);

	public boolean cancelBookedFlight();

	public List<FlightBooking> getAllBooking(String userId);
	
	public boolean deleteBooking(String bookingId);

}
