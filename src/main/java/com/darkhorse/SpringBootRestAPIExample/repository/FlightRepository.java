package com.darkhorse.SpringBootRestAPIExample.repository;

import com.darkhorse.SpringBootRestAPIExample.model.Flight;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@SuppressWarnings("unused")
public interface FlightRepository extends JpaRepository<Flight, Long> {
	//List<Flight> getByDetails(String Origin,String destination);
}