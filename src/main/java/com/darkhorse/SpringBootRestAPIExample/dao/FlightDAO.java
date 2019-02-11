package com.darkhorse.SpringBootRestAPIExample.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darkhorse.SpringBootRestAPIExample.model.Flight;
import com.darkhorse.SpringBootRestAPIExample.repository.FlightRepository;


@Service
public class FlightDAO {
	
	@Autowired
	FlightRepository flightRepository;
	
	//to save an Flight Data
	
	public Flight save(Flight flight)
	{
		return flightRepository.save(flight);
	}
	
	//search all Flight Data 
	
	public List<Flight> findAll()
	{
		
		
		return flightRepository.findAll();
		
	}
	
	
	//Get an Flight Data by id
	
	public Flight findOne(Long flightId) {
		
		return flightRepository.findOne(flightId);
	}
	
	
	//Delete an Employee
	
	
	public void delete(Flight flight)
	{
	  flightRepository.delete(flight);	
	}
	
	
	
}
