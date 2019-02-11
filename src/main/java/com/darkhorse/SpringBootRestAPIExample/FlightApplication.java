package com.darkhorse.SpringBootRestAPIExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FlightApplication {
	
	public static void main(String[] args)
	{
		SpringApplication.run(FlightApplication.class, args);
	
	}

}
