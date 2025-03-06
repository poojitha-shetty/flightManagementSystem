package com.capgemini.flightmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.flightmanagementsystem.bean.FlightBooking;
import com.capgemini.flightmanagementsystem.response.BookingResponse;
import com.capgemini.flightmanagementsystem.response.FlightResponse;
import com.capgemini.flightmanagementsystem.service.FlightService;



@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class FlightBookingController {

	@Autowired
	private FlightService service;

	@PostMapping("/bookFlight")
	public FlightResponse addFlight(@RequestBody FlightBooking flightBooking) {

		boolean isAdded = service.bookFlight(flightBooking);

		FlightResponse response = new FlightResponse();
		if (isAdded) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Congratulation! Flight booked successfully. ");
			response.setBookingID(flightBooking.getBookingId());

		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Oop's! Unable to book flight. All the seats has been booked.");
		}
		return response;
	}

	@GetMapping(path = "/getMyBooking", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public BookingResponse getAllBookingInfo(String userId) {

		List<FlightBooking> allBookingInfo = service.getAllBooking(userId);
		BookingResponse response = new BookingResponse();
		if (allBookingInfo != null) {
			response.setStatusCode(210);
			response.setMessage("success");
			response.setDescription("All Booking retrieved sucessfully.");
			response.setGetAllBookingInfo(allBookingInfo);
		} else {

			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription(" No booking found " + userId);

		}
		return response;

	}// end of getAllBookingInfo()

	@DeleteMapping("/deleteBooking")
	public BookingResponse deleteBooking(String bookingId) {
		boolean isDeleted = service.deleteBooking(bookingId);
		BookingResponse response = new BookingResponse();
		if (isDeleted) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Flight booking deleted sucessfully");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to delete flight booking. BookingId does not match.");

		}
		return response;
	}
}
