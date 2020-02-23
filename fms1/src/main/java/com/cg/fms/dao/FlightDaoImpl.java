package com.cg.fms.dao;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.cg.fms.bean.Flight;
import com.cg.fms.exception.FlightException;

public class FlightDaoImpl implements FlightDao{

	private List<Flight> list;
   
	public FlightDaoImpl() {
		super();
		list=new ArrayList<Flight>();
	}

	public int addFlight(Flight flight) throws FlightException {

		boolean flag = list.stream().anyMatch(p-> p.getFlightNumber()==flight.getFlightNumber());
		
			list.add(flight);
		
		return flight.getFlightNumber();
	}

	public Flight modifyFlight(Flight flight,int id,String s,String b) throws FlightException {

		boolean flag = list.stream().anyMatch(p-> p.getFlightNumber()==flight.getFlightNumber());
		if(flag==true)
		{
			flight.setSeatCapacity(id);
			flight.setCarrierName(s);
			flight.setFlightModel(b);
		}
		else
		{
			throw new FlightException("FLIGHT NOT FOUND");
		}
		return flight;
	}

	
	public List<Flight> viewFlight() throws FlightException {

		List<Flight> flightlist=list.stream().collect(Collectors.toList());
		return flightlist;
	}

}
