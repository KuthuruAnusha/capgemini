package com.cg.fms1.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.cg.fms.bean.Flight;
import com.cg.fms.dao.FlightDao;
import com.cg.fms.dao.FlightDaoImpl;
import com.cg.fms.exception.FlightException;

public class flightManagementSystem {
	Flight f=new Flight();
	FlightDao fd=new FlightDaoImpl();
	//private List<Flight> list;

	@Test
	public void addtest() throws FlightException {
		List<Flight> flight=new ArrayList<Flight>();
		Flight flight1=new Flight(1001,"indigo","asdfg",70) ;
		fd.addFlight(flight1);
		 //assertEquals(1,fd.addFlight(flight1));
	}
 

}
