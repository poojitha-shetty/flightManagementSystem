package com.capgemini.flightmanagementsystem.response;

import java.util.List;

import com.capgemini.flightmanagementsystem.bean.FlightInformation;

public class FlightResponse {
	private int statusCode;
	private String message;
	private String description;
	private FlightInformation flightInformation;
	private List<FlightInformation> searchFlight;

	private String BookingID;
	public String getBookingID() {
		return BookingID;
	}

	public void setBookingID(String bookingID) {
		BookingID = bookingID;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public FlightInformation getFlightInformation() {
		return flightInformation;
	}

	public void setFlightInformation(FlightInformation flightInformation) {
		this.flightInformation = flightInformation;
	}

	public List<FlightInformation> getSearchFlight() {
		return searchFlight;
	}

	public void setSearchFlight(List<FlightInformation> searchFlight) {
		this.searchFlight = searchFlight;
	}

}
