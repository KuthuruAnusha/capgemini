package com.cg.fms.service;

import java.math.*;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.cg.fms.exception.FlightException;



import com.cg.fms.bean.Flight;
import com.cg.fms.dao.FlightDao;
import com.cg.fms.dao.FlightDaoImpl;

	public class FlightServiceImpl implements FlightService {

			private FlightDao flightDao;

			public FlightServiceImpl()
			{
				super();
				flightDao = new FlightDaoImpl();
			}

			public void validateFlight(Flight flight) {

				boolean f=flight.getCarrierName().matches("[a-zA-Z]+");
				f=flight.getFlightModel().matches("[a-zA-Z]+");
				String flightnum=String.valueOf(flight.getFlightNumber());
				f=flightnum.matches("[0-9]{4}");
				String seatCapacity=String.valueOf(flight.getSeatCapacity());
				f=flightnum.matches("[0-9]{2}");
			}
			public boolean carriername(String flight) throws FlightException
			{
				boolean flag1=false,flag2=false,flag3=false;
				  
				if( flight.matches("[a-zA-Z]+"))
				{
					 return true;
				}
			return false;	
			
			}

			public int addFlight(Flight flight) throws FlightException {

				boolean flag1=false,flag2=false,flag3=false;
				flag1=flight.getCarrierName().matches("[a-zA-Z]+");
				if(flag1==false)
				{
					throw new FlightException("Invalid carrier name ");
				}
				flag3=flight.getFlightModel().matches("[a-zA-z]+");
				if(flag3==false)
				{
					throw new FlightException("Invalid flightmodel ");
				}
				String seatCapacity=String.valueOf(flight.getSeatCapacity());
				flag2= seatCapacity.matches("[0-9]{2}");
				if( flag2==false)
				{
					throw new FlightException(" Invalid Seatcapacity");
				}
				Random random=new Random();
				int flightnum1=random.nextInt(1000)+1000;
				flight.setFlightNumber(flightnum1);
				flightnum1=flightDao.addFlight(flight);
				return flightnum1;
			}

			public Flight modifyFlight(Flight flight,int id,String s,String b ) throws FlightException {

				String flightnum=String.valueOf(flight.getFlightNumber());
				boolean flag=flightnum.matches("[0-9]{4}");
				if(!flag)
				{
					throw new FlightException("Invalid flight number ");
				}
				return flightDao.modifyFlight(flight,id,b,s);
				}

			
			public List<Flight> viewFlight() throws FlightException {

				return flightDao.viewFlight();
			}

	}
