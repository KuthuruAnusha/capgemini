package com.cg.fms1.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.cg.fms.bean.Flight;
import com.cg.fms.dao.FlightDao;
import com.cg.fms.dao.FlightDaoImpl;
import com.cg.fms.exception.FlightException;

class FmsTest {
	FlightDao flightDao=null;
	//Flight flight=new Flight(1612,"kingfisher","bussines",60);
	
	@Before
	public void addFlight()
	{
		flightDao=new FlightDaoImpl();
	}

	@Test
	public void testaddFlight() throws FlightException{
		Flight flight=new Flight(1612,"kingfisher","bussines",60);
	
		int flight1=flightDao.addFlight(flight);
		assertEquals(flight.getFlightNumber(),flight1);
		 
	}

}
