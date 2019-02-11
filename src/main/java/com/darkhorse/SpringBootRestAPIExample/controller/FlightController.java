package com.darkhorse.SpringBootRestAPIExample.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.darkhorse.SpringBootRestAPIExample.dao.FlightDAO;
import com.darkhorse.SpringBootRestAPIExample.model.Flight;

@RestController
@RequestMapping("/flight")
public class FlightController {
	
	@Autowired
	FlightDAO flightDAO;
	
	
	
	//to save an Flight Data
	
	@PostMapping("/flightdata")
	public Flight createFlight(@Valid @RequestBody Flight flight)
	{
		return flightDAO.save(flight);
	}
	
	//get All Flight Data
	
	@GetMapping("/search")
	public List<Flight> getAllFlights()
	{
	List<Flight> list=flightDAO.findAll();
	Collections.sort(list);
		return list;
	}
	
	/*get flight by flightid*/
	@GetMapping("/flight/{id}")
	public ResponseEntity<Flight> getFlightById(@PathVariable(value="id") Long flightid){
		
		Flight flight=flightDAO.findOne(flightid);
		
		if(flight==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(flight);
		
	}
	
	
	/*update an flight by flightid*/
	@PutMapping("/flights/{id}")
	public ResponseEntity<Flight> updateFlight(@PathVariable(value="id") Long flightId,@Valid @RequestBody Flight flightDetails){
		
		Flight flight=flightDAO.findOne(flightId);
		if(flight==null) {
			return ResponseEntity.notFound().build();
		}
		
		flight.setAirlineName(flightDetails.getAirlineName());
		flight.setOrigin(flightDetails.getOrigin());
		flight.setDestination(flightDetails.getDestination());
		flight.setPrice(flightDetails.getPrice());
		
		Flight updateFlight=flightDAO.save(flight);
		return ResponseEntity.ok().body(updateFlight);
		
		
		
	}
	
	/*Delete an flight*/
	@DeleteMapping("/flights/{id}")
	public ResponseEntity<Flight> deleteFlight(@PathVariable(value="id") Long flightId){
		
		Flight flight=flightDAO.findOne(flightId);
		if(flight==null) {
			return ResponseEntity.notFound().build();
		}
		flightDAO.delete(flight);
		
		return ResponseEntity.ok().build();
		
		
	}
	
	/*get flight by flightid*/
	
	@GetMapping("/search/{Origin}/{destination}")
	public List<Flight> getFlightbetweenPath(@PathVariable(value="Origin") String Origin,@PathVariable(value="destination") String destination ){
		
		List<Flight> list=flightDAO.findAll();
		
		//Code to Get Flight between source and destination
		List<Flight> perfectList=new ArrayList<Flight>();
		
		for(int i =0;i<list.size();i++) 
		{
			String CheckOrigin=list.get(i).getOrigin();
			String CheckDest=list.get(i).getDestination();
			
			if((CheckDest.contentEquals(destination))&&(CheckOrigin.contentEquals(Origin))) 
			{
				perfectList.add(list.get(i));
			}
		}
 		
		//Handling No Flight details
		if(perfectList.isEmpty()) {
			return null;
		}
		//sort on the basis of Price
	  Collections.sort(perfectList);
		return perfectList;
		
	}

	

}
