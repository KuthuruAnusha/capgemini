package com.cg.fms.dao;


import java.util.List;

import com.cg.fms.bean.Flight;
import com.cg.fms.exception.FlightException;



public interface FlightDao {

	public int addFlight(Flight flight) throws FlightException;
	public Flight modifyFlight(Flight flight,int id) throws FlightException;
	
	public List<Flight> viewFlight () throws FlightException;
	
}
