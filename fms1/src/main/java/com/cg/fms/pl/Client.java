package com.cg.fms.pl;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.cg.fms.bean.Flight;
import com.cg.fms.exception.FlightException;
import com.cg.fms.service.FlightService;
import com.cg.fms.service.FlightServiceImpl;

		public class Client {

			public static void main(String[] args) {
				 

				Scanner sc=new Scanner(System.in);
				FlightService flightservice=new FlightServiceImpl();
				int choice=0;
				Flight flight=null;
				List<Flight> list=null;
				while(choice!=6)

				{
					System.out.println("1.Add flight");
					System.out.println("2.Modify flight");
					System.out.println("3.View list of flights");
					System.out.println("4.Exit");

					choice=sc.nextInt();
					sc.nextLine();
			 
					
					switch(choice)
					{
					case 1:try
					{
						flight=new Flight();
						System.out.println("Enter carriername");
						String name=sc.nextLine();
						
						
						
						flight.setCarrierName(name);
						System.out.println("enter flight Model");
						String model=sc.nextLine();
						flight.setFlightModel(model);
						System.out.println("Enter seat capacity");
						int seat=sc.nextInt();
						flight.setSeatCapacity(seat);
						
			
							int flightnum= flightservice.addFlight(flight);
							System.out.println("Flight number="+flightnum);
						}
						catch(FlightException e)
						{
						 System.err.println(e.getMessage());
						 }
						break;
						case 2:
							System.out.println("Enter flightnumber");
							int flightNumber=sc.nextInt();
							sc.nextLine();
							try
							{
	
							System.out.println("Enter Updated Seat Capacity");
							int i=sc.nextInt();
							sc.nextLine();
							System.out.println("Enter Updated carrier name");
							String s=sc.nextLine();
							
							System.out.println("Enter Updated flight model");
							String b=sc.nextLine();
	
							flight=flightservice.modifyFlight(flight,i,b,s);
	
							}
							catch(FlightException e)
							{
								System.err.println(e.getMessage());
							}
							break;
						
						case 3:
							try
							{
								list=flightservice.viewFlight();
								for(Flight fl: list)
								{
									flightNumber=fl.getFlightNumber();
									String name=fl.getCarrierName();
									String model=fl.getFlightModel();
									int seat=fl.getSeatCapacity();
									System.out.println(flightNumber+" "+name+" "+model+" "+seat);
								}
								}
								catch(FlightException e) {
								System.err.println(e.getMessage());
								}
							break;
							 
							}

				  
			}
		
					
		}
		}
