package com.capgemini.flightmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.flightmanagementsystem.bean.FlightBooking;
import com.capgemini.flightmanagementsystem.bean.FlightInformation;
import com.capgemini.flightmanagementsystem.dao.BookingDao;
import com.capgemini.flightmanagementsystem.dao.FlightDAO;

@Service
public class FlightServiceImpl implements FlightService {
	@Autowired
	private FlightDAO flightdao;

	@Autowired
	private BookingDao bookingDao;

	@Override
	public FlightInformation getFlight(String flightNumber) {
		return flightdao.getFlight(flightNumber);
	}

	@Override
	public List<FlightInformation> search(String departureCity, String arrivalCity, String departureDate) {

		return flightdao.search(departureCity, arrivalCity, departureDate);
	}

	@Override
	public List<FlightInformation> getAllFlights() {
		return flightdao.getAllFlights();
	}

	@Override
	public boolean bookFlight(FlightBooking flightBooking) {
		return bookingDao.bookFlight(flightBooking);
	}

	@Override
	public List<FlightBooking> getAllBooking(String userId) {
		return bookingDao.getAllBooking(userId);
	}

	@Override
	public boolean deleteBooking(String bookingId) {
		return bookingDao.deleteBooking(bookingId);
	}
}
