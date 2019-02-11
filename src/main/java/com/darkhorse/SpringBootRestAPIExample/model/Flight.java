package com.darkhorse.SpringBootRestAPIExample.model;



import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@SuppressWarnings("deprecation")
@Entity

@Table(name="FlightData")
@EntityListeners(AuditingEntityListener.class)
public class Flight implements Comparable<Flight>{
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	
	@Deprecated
	@NotEmpty    
	private String airlineName;
	
	@Deprecated
    @NotEmpty 
	private String Origin;
	
	
	@Deprecated
    @NotEmpty
	private String destination;
	
	@NotNull
	private int price;
	
	
	public Flight() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Flight(Long id, String airlineName, String origin, String destination, int price) {
		super();
		this.id = id;
		this.airlineName = airlineName;
		Origin = origin;
		this.destination = destination;
		this.price = price;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getOrigin() {
		return Origin;
	}

	public void setOrigin(String origin) {
		Origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}


     public int compareTo(Flight flight) {
		// TODO Auto-generated method stub
		return this.price-flight.price;
	}
	
	

}
