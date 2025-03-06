package com.capgemini.flightmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.flightmanagementsystem.bean.FlightInformation;
import com.capgemini.flightmanagementsystem.response.FlightResponse;
import com.capgemini.flightmanagementsystem.service.FlightService;



@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class FlightController {
	@Autowired
	private FlightService service;
	

	@GetMapping("/getFlight")
	public FlightResponse getFlight(String flightNumber) {

		FlightInformation flightInformation = service.getFlight(flightNumber);
		FlightResponse response = new FlightResponse();
		if (flightInformation != null) {
			response.setStatusCode(210);
			response.setMessage("success");
			response.setDescription("Flight found sucessfully");
			response.setFlightInformation(flightInformation);
		} else {

			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription(" Not found.Check whether you have entered unique flight number " + flightNumber);

		}
		return response;

	}// end of getflight()

	

	

	

	@PostMapping("/searchFlight")
	public FlightResponse searchFlight(@RequestBody FlightInformation flightInformation) {
		String departureCity = flightInformation.getDepartureCity();
		String arrivalCity = flightInformation.getArrivalCity();
		String departureDate = flightInformation.getDepartureDate();
		List<FlightInformation> searchFlight = service.search(departureCity, arrivalCity, departureDate);

		FlightResponse response = new FlightResponse();
		if (searchFlight != null && !searchFlight.isEmpty()) {
			response.setStatusCode(210);
			response.setMessage("success");
			response.setDescription("List of flights ");
			response.setSearchFlight(searchFlight);
		} else {

			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription(" Unable to fetch flights. Check whether you have entered correct details.");
		}
		return response;

	}
	@GetMapping("/getAll")
	public FlightResponse getAllFlights() {

		List<FlightInformation> flightList = service.getAllFlights();
		
		FlightResponse response = new FlightResponse();
		if (flightList != null && !flightList.isEmpty()) {
			response.setStatusCode(210);
			response.setMessage("success");
			response.setDescription("All Flights Found ");
			response.setSearchFlight(flightList);
					
		} else {

			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription(" Unable to find any flights.");

		}
		return response;

	}

}// end of class

