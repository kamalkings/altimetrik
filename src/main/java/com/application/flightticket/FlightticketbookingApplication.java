package com.application.flightticket;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.application.flightticket.service.FlightTicketService;

@SpringBootApplication
public class FlightticketbookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightticketbookingApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(FlightTicketService service) {
		return (args) -> {
			service.insert();
		};
	}

}
