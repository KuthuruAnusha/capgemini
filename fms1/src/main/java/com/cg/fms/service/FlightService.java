package com.cg.fms.service;


import java.util.List;

import com.cg.fms.bean.Flight;
import com.cg.fms.exception.FlightException;

public interface FlightService {

public void validateFlight(Flight flight);
public int addFlight(Flight flight) throws FlightException;
public Flight modifyFlight(Flight flight,int id) throws FlightException;

public List<Flight > viewFlight() throws FlightException;

}
