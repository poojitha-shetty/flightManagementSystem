package com.capgemini.flightmanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.flightmanagementsystem.bean.FlightInformation;



@Repository
public class FlightDAOJpaImpl implements FlightDAO {

	@PersistenceUnit
	private EntityManagerFactory emf;


	@Override
	public FlightInformation getFlight(String flightNumber) {
		EntityManager manager = emf.createEntityManager();
		FlightInformation flightInformation = manager.find(FlightInformation.class, flightNumber);
		manager.close();
		return flightInformation;
		
	}

	
	// Search Flight details...
	@Override
	public List<FlightInformation> search(String departureCity, String arrivalCity, String departureDate) {
		EntityManager manager = emf.createEntityManager();
		String jpql = "from FlightInformation where departureCity = :departure and arrivalCity = :arrival and departureDate= :date";
		Query query = manager.createQuery(jpql);
		query.setParameter("departure", departureCity);
		query.setParameter("arrival", arrivalCity);
		query.setParameter("date", departureDate);
		List<FlightInformation> flightList = null;
		try {
			flightList = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flightList;
	}

	@Override
	public List<FlightInformation> getAllFlights() {
		EntityManager manager = emf.createEntityManager();
		String jpql = "from FlightInformation";
		Query query = manager.createQuery(jpql);

		List<FlightInformation> flightList = null;
		try {
			flightList = query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return flightList;
	}

	
}
